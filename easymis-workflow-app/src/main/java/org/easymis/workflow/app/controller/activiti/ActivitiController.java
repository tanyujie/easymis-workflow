package org.easymis.workflow.app.controller.activiti;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowNode;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.easymis.workflow.app.service.InitActivitiService;
import org.easymis.workflow.app.utils.ActUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/activiti")
@Api(value = "activiti测试工具类controller", tags = { "activiti测试工具类操作接口" })
public class ActivitiController {
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private ProcessEngine processEngine;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private InitActivitiService initActivitiService;
	
	@RequestMapping("init")
	public HashMap initActivitiService() {
		HashMap map = new HashMap();
		initActivitiService.init();
		map.put("ok", "初始化执行完毕");
		return map;
	}
	/**
	 * 部署流程、启动流程、完成任务节点
	 */
	@RequestMapping("helloWorld")
	public HashMap helloWorld() {
		HashMap map = new HashMap();
		// 根据bpmn文件部署流程
		Deployment deploy = repositoryService.createDeployment().addClasspathResource("processes/TestProcess.bpmn").deploy();
		// 获取流程定义
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.deploymentId(deploy.getId()).singleResult();
		map.put("definitionId", processDefinition.getId());
		// 启动流程定义，返回流程实例
		ProcessInstance pi = runtimeService.startProcessInstanceById(processDefinition.getId());
		String processId = pi.getId();
		System.out.println("流程创建成功，当前流程实例ID：" + processId);
		map.put("processId", processId);
		Task task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
		System.out.println("执行前，任务名称：" + task.getName());
		taskService.complete(task.getId());
		map.put("taskName", task.getName());
		task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
		System.out.println("task为null，任务执行完毕：" + task);
		return map;
	}

	/**
	 * 
	 * 动态设置任务节点处理人(单人)
	 */
	@RequestMapping("singleAssignee")
	public HashMap setSingleAssignee() {
		HashMap map = new HashMap();
		// 根据bpmn文件部署流程
		Deployment deploy = repositoryService.createDeployment().addClasspathResource("processes/singleAssignee.bpmn").deploy();
		// 获取流程定义
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.deploymentId(deploy.getId()).singleResult();
		map.put("definitionId", processDefinition.getId());
		
		// 设置User Task1受理人变量
		Map<String, Object> variables = new HashMap<>();
		variables.put("user1", "007");
		// 采用key来启动流程定义并设置流程变量，返回流程实例
		ProcessInstance pi = runtimeService.startProcessInstanceByKey("singleAssignee", variables);
		String processId = pi.getId();
		System.out.println("流程创建成功，当前流程实例ID：" + processId);
		map.put("processId", processId);
		
		// 注意 这里需要拿007来查询，key-value需要拿value来获取任务
		List<Task> list = taskService.createTaskQuery().taskAssignee("007").list();
		if (list != null && list.size() > 0) {
			for (org.activiti.engine.task.Task task : list) {
				System.out.println("任务ID：" + task.getId());
				System.out.println("任务的办理人：" + task.getAssignee());
				System.out.println("任务名称：" + task.getName());
				System.out.println("任务的创建时间：" + task.getCreateTime());
				System.out.println("流程实例ID：" + task.getProcessInstanceId());
				System.out.println("#######################################");
			}
		}

		// 设置User Task2的受理人变量
		Map<String, Object> variables1 = new HashMap<>();
		variables1.put("user2", "Kevin");
		// 因为007只有一个代办的任务，直接完成任务，并赋值下一个节点的受理人user2为Kevin办理
		taskService.complete(list.get(0).getId(), variables1);
		System.out.println("User Task1被完成了，此时流程已流转到User Task2");
		map.put("taskName", list.get(0).getName());
		return map;
	}

	/**
	 * 
	 * 动态设置任务节点处理人(多人); 多个人同时处理一个任务，并且需要判断他们是否全部或者部分人处理了任务，才能跳到下一个任务节点时
	 */
	@RequestMapping("multiAssignee")
	public HashMap setMultiAssignee() {
		HashMap map = new HashMap();
		// 根据bpmn文件部署流程
		Deployment deploy = repositoryService.createDeployment().addClasspathResource("processes/MultiAssignee.bpmn").deploy();
		// 获取流程定义
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.deploymentId(deploy.getId()).singleResult();
		map.put("definitionId", processDefinition.getId());
		// 设置多个处理人变量 这里设置了三个人
		Map<String, Object> variables = new HashMap<>();
		List<String> userList = new ArrayList<>();
		userList.add("user1");
		userList.add("user2");
		userList.add("user3");
		variables.put("userList", userList);
		// 采用key来启动流程定义并设置流程变量，返回流程实例
		ProcessInstance pi = runtimeService.startProcessInstanceByKey("multiAssigneeProcess", variables);
		String processId = pi.getId();
		System.out.println("流程创建成功，当前流程实例ID：" + processId);
		map.put("processId", processId);
		
		// 查看user1的任务
		List<Task> list = taskService.createTaskQuery().taskAssignee("user1").list();
		if (list != null && list.size() > 0) {
			for (org.activiti.engine.task.Task task : list) {
				System.out.println("任务ID：" + task.getId());
				System.out.println("任务的办理人：" + task.getAssignee());
				System.out.println("任务名称：" + task.getName());
				System.out.println("任务的创建时间：" + task.getCreateTime());
				System.out.println("流程实例ID：" + task.getProcessInstanceId());
				System.out.println("#######################################");
			}
		}

		// 查看user2的任务
		List<Task> list2 = taskService.createTaskQuery().taskAssignee("user2").list();
		if (list2 != null && list2.size() > 0) {
			for (org.activiti.engine.task.Task task : list2) {
				System.out.println("任务ID：" + task.getId());
				System.out.println("任务的办理人：" + task.getAssignee());
				System.out.println("任务名称：" + task.getName());
				System.out.println("任务的创建时间：" + task.getCreateTime());
				System.out.println("流程实例ID：" + task.getProcessInstanceId());
				System.out.println("#######################################");
			}
		}

		// 查看user3的任务
		List<Task> list3 = taskService.createTaskQuery().taskAssignee("user3").list();
		if (list3 != null && list3.size() > 0) {
			for (org.activiti.engine.task.Task task : list3) {
				System.out.println("任务ID：" + task.getId());
				System.out.println("任务的办理人：" + task.getAssignee());
				System.out.println("任务名称：" + task.getName());
				System.out.println("任务的创建时间：" + task.getCreateTime());
				System.out.println("流程实例ID：" + task.getProcessInstanceId());
				System.out.println("#######################################");
			}
		}
		map.put("taskName", list.get(0).getName());
		return map;
	}

	/**
	 * 
	 * 排他网关(Exclusive Gateway); 
	 * 排他网关其实就是一个条件选择器，看你选择了什么条件，流程图的路线就会走到哪一个节点;
	 * 在使用排他网关时，需设置默认路线，并且默认路线不用设置条件；
	 * 定时边界任务使用时，若不需要中断流程，Cancel activity设置为false；
	 * 使用ISO 8601的格式设置时间，请将启动时间设置到当前时间之后，否则数据库的ACT_RU_TIMER_JOB里面的任务永远不会被执行！
	 */
	@RequestMapping("exclusiveGateway")
	public void exclusiveGateway() {

		// 根据bpmn文件部署流程
		repositoryService.createDeployment().addClasspathResource("processes/exclusiveGateway.bpmn").deploy();
		// 设置User Task1受理人变量
		Map<String, Object> variables = new HashMap<>();
		variables.put("user1", "007");
		// 采用key来启动流程定义并设置流程变量，返回流程实例
		ProcessInstance pi = runtimeService.startProcessInstanceByKey("exclusiveGatewayAndTimerBoundaryEventProcess",
				variables);
		String processId = pi.getId();
		System.out.println("流程创建成功，当前流程实例ID：" + processId);

		// 注意 这里需要拿007来查询，key-value需要拿value来获取任务
		List<Task> list = taskService.createTaskQuery().taskAssignee("007").list();
		Map<String, Object> variables1 = new HashMap<>();
		variables1.put("user2", "lili"); // 设置User Task2的受理人变量
		variables1.put("operate", ""); // 设置用户的操作 为空 表示走flow3的默认路线
		taskService.complete(list.get(0).getId(), variables1);
		System.out.println("User Task1被完成了，此时流程已流转到User Task2");

		List<Task> list1 = taskService.createTaskQuery().taskAssignee("lili").list();
		Map<String, Object> variables2 = new HashMap<>();
		variables2.put("user4", "bobo");
		variables2.put("startTime", "2018-6-11T14:22:00"); // 设置定时边界任务的触发时间 注意：后面的时间必须是ISO 8601时间格式的字符串！！！
		taskService.complete(list1.get(0).getId(), variables2);

		List<Task> list2 = taskService.createTaskQuery().taskAssignee("bobo").list();
		if (list2 != null && list2.size() > 0) {
			for (org.activiti.engine.task.Task task : list2) {
				System.out.println("任务ID：" + task.getId());
				System.out.println("任务的办理人：" + task.getAssignee());
				System.out.println("任务名称：" + task.getName());
				System.out.println("任务的创建时间：" + task.getCreateTime());
				System.out.println("流程实例ID：" + task.getProcessInstanceId());
				System.out.println("#######################################");
			}
		}
	}
	@RequestMapping(value = "/getFlowImg/{processInstanceId}")
	public void getFlowImgByInstantId(@PathVariable("processInstanceId") String processInstanceId, HttpServletResponse response) {
		try {
			System.out.println("processInstanceId:" + processInstanceId);
			ActUtils.getFlowImgByInstanceId(processInstanceId, response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @Author 谭宇杰
	 * @Note 读取流程资源
	 * @param processDefinitionId
	 *            流程定义ID
	 * @param resourceName
	 *            资源名称
	 */
	@RequestMapping(value = "/read-resource")
	public void readResource(String processDefinitionId, String resourceName, String pProcessInstanceId,
			HttpServletResponse response) throws Exception {
		// 设置页面不缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		ProcessDefinitionQuery pdq = repositoryService.createProcessDefinitionQuery();
		ProcessDefinition pd = pdq.processDefinitionId(processDefinitionId).singleResult();

		if (resourceName.endsWith(".png") && StringUtils.isEmpty(pProcessInstanceId) == false) {
			getActivitiProccessImage(pProcessInstanceId, response);
			// ProcessDiagramGenerator.generateDiagram(pde, "png",
			// getRuntimeService().getActiveActivityIds(processInstanceId));
		} else {
			// 通过接口读取
			InputStream resourceAsStream = repositoryService.getResourceAsStream(pd.getDeploymentId(), resourceName);

			// 输出资源内容到相应对象
			byte[] b = new byte[1024];
			int len = -1;
			while ((len = resourceAsStream.read(b, 0, 1024)) != -1) {
				response.getOutputStream().write(b, 0, len);
			}
		}
	}
/**
 * 获取流程图像，已执行节点和流程线高亮显示
 */
public void getActivitiProccessImage(String pProcessInstanceId, HttpServletResponse response)
{
    //logger.info("[开始]-获取流程图图像");
    try {
        //  获取历史流程实例
        HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery()
                .processInstanceId(pProcessInstanceId).singleResult();

        if (historicProcessInstance == null) {
            //throw new BusinessException("获取流程实例ID[" + pProcessInstanceId + "]对应的历史流程实例失败！");
        }
        else
        {
            // 获取流程定义
            ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
                    .getDeployedProcessDefinition(historicProcessInstance.getProcessDefinitionId());

            // 获取流程历史中已执行节点，并按照节点在流程中执行先后顺序排序
            List<HistoricActivityInstance> historicActivityInstanceList = historyService.createHistoricActivityInstanceQuery()
                    .processInstanceId(pProcessInstanceId).orderByHistoricActivityInstanceId().asc().list();

            // 已执行的节点ID集合
            List<String> executedActivityIdList = new ArrayList<String>();
            int index = 1;
            //logger.info("获取已经执行的节点ID");
            for (HistoricActivityInstance activityInstance : historicActivityInstanceList) {
                executedActivityIdList.add(activityInstance.getActivityId());

                //logger.info("第[" + index + "]个已执行节点=" + activityInstance.getActivityId() + " : " +activityInstance.getActivityName());
                index++;
            }

            BpmnModel bpmnModel = repositoryService.getBpmnModel(historicProcessInstance.getProcessDefinitionId());

            // 已执行的线集合
            List<String> flowIds = new ArrayList<String>();
            // 获取流程走过的线 (getHighLightedFlows是下面的方法)
            flowIds = getHighLightedFlows(bpmnModel,processDefinition, historicActivityInstanceList);



            // 获取流程图图像字符流
            ProcessDiagramGenerator pec = processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator();
            //配置字体
            InputStream imageStream = pec.generateDiagram(bpmnModel, "png", executedActivityIdList, flowIds,"宋体","微软雅黑","黑体",null,2.0);

            response.setContentType("image/png");
            OutputStream os = response.getOutputStream();
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = imageStream.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            imageStream.close();
        }
        //logger.info("[完成]-获取流程图图像");
    } catch (Exception e) {
        System.out.println(e.getMessage());
        //logger.error("【异常】-获取流程图失败！" + e.getMessage());
        //throw new BusinessException("获取流程图失败！" + e.getMessage());
    }
}

public List<String> getHighLightedFlows(BpmnModel bpmnModel,ProcessDefinitionEntity processDefinitionEntity,List<HistoricActivityInstance> historicActivityInstances)
{
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //24小时制
    List<String> highFlows = new ArrayList<String>();// 用以保存高亮的线flowId

    for (int i = 0; i < historicActivityInstances.size() - 1; i++)
    {
        // 对历史流程节点进行遍历
        // 得到节点定义的详细信息
        FlowNode activityImpl = (FlowNode)bpmnModel.getMainProcess().getFlowElement(historicActivityInstances.get(i).getActivityId());


        List<FlowNode> sameStartTimeNodes = new ArrayList<FlowNode>();// 用以保存后续开始时间相同的节点
        FlowNode sameActivityImpl1 = null;

        HistoricActivityInstance activityImpl_ = historicActivityInstances.get(i);// 第一个节点
        HistoricActivityInstance activityImp2_ ;

        for(int k = i + 1 ; k <= historicActivityInstances.size() - 1; k++)
        {
            activityImp2_ = historicActivityInstances.get(k);// 后续第1个节点

            if ( activityImpl_.getActivityType().equals("userTask") && activityImp2_.getActivityType().equals("userTask") &&
                    df.format(activityImpl_.getStartTime()).equals(df.format(activityImp2_.getStartTime()))   ) //都是usertask，且主节点与后续节点的开始时间相同，说明不是真实的后继节点
            {

            }
            else
            {
                sameActivityImpl1 = (FlowNode)bpmnModel.getMainProcess().getFlowElement(historicActivityInstances.get(k).getActivityId());//找到紧跟在后面的一个节点
                break;
            }

        }
        sameStartTimeNodes.add(sameActivityImpl1); // 将后面第一个节点放在时间相同节点的集合里
        for (int j = i + 1; j < historicActivityInstances.size() - 1; j++)
        {
            HistoricActivityInstance activityImpl1 = historicActivityInstances.get(j);// 后续第一个节点
            HistoricActivityInstance activityImpl2 = historicActivityInstances.get(j + 1);// 后续第二个节点

            if (df.format(activityImpl1.getStartTime()).equals(df.format(activityImpl2.getStartTime()))  )
            {// 如果第一个节点和第二个节点开始时间相同保存
                FlowNode sameActivityImpl2 = (FlowNode)bpmnModel.getMainProcess().getFlowElement(activityImpl2.getActivityId());
                sameStartTimeNodes.add(sameActivityImpl2);
            }
            else
            {// 有不相同跳出循环
                break;
            }
        }
        List<SequenceFlow> pvmTransitions = activityImpl.getOutgoingFlows() ; // 取出节点的所有出去的线

        for (SequenceFlow pvmTransition : pvmTransitions)
        {// 对所有的线进行遍历
            FlowNode pvmActivityImpl = (FlowNode)bpmnModel.getMainProcess().getFlowElement( pvmTransition.getTargetRef());// 如果取出的线的目标节点存在时间相同的节点里，保存该线的id，进行高亮显示
            if (sameStartTimeNodes.contains(pvmActivityImpl)) {
                highFlows.add(pvmTransition.getId());
            }
        }

    }
    return highFlows;

}


}
