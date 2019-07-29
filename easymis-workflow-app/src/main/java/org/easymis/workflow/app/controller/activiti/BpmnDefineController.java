package org.easymis.workflow.app.controller.activiti;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.runtime.ProcessInstance;
import org.easymis.workflow.app.entity.bpm.BpmnDefine;
import org.easymis.workflow.app.entity.vo.BpmnDefineVO;
import org.easymis.workflow.app.service.ProcessDefinitionService;
import org.easymis.workflow.app.service.bpm.BpmDefineService;
import org.easymis.workflow.app.utils.RestfulMessage;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;

@RestController
@Api(value = "流程定义controller", tags = { "流程定义操作接口" })
@RequestMapping("/bpmn/bpmDefine")
public class BpmnDefineController {
    @Autowired
    private ProcessDefinitionService processDefinitionService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private BpmDefineService service;

	@RequestMapping("/")
	public ModelAndView index1(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("bpmn/bpmDefine/index");
		return mv;
	}
	@RequestMapping("/index.html")
	public ModelAndView  index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("bpmn/bpmDefine/index");
		return mv;
	}
	//保存
		@RequestMapping(value = "/save/", method = RequestMethod.POST)  
		public RestfulMessage saveCategory(HttpSession httpSession, @RequestBody BpmnDefine bean) {
			try {
				httpSession.getAttribute("userLogin");
				service.save(bean);
				return new RestfulMessage().success("保存分类成功");
			} catch (Exception e) {
				return new RestfulMessage().success("保存分类失败");
			}

		}
		//修改
		@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)  
		public RestfulMessage  updateCategory(HttpSession httpSession,@PathVariable("id") String id,@RequestBody BpmnDefine bean) {
			try {
				httpSession.getAttribute("userLogin");
				service.update(bean);
				return new RestfulMessage().success("更新分类成功");
			} catch (Exception e) {
				return new RestfulMessage().success("更新分类失败");
			}

		}
		//获取详情
		@RequestMapping(value = "/get/{id}",  method = RequestMethod.GET)  
		public RestfulMessage  getCategory(HttpSession httpSession,@PathVariable("id") String id) {
			try {
				httpSession.getAttribute("userLogin");
				BpmnDefine bean=service.get(id);
				return new RestfulMessage().success(bean);
			} catch (Exception e) {
				return new RestfulMessage().success("获取分类失败");
			}

		}

	//删除流程实例
	@RequestMapping(value = "/remove/{modelId}", method = {RequestMethod.DELETE,RequestMethod.GET})
	public RestfulMessage delete(HttpSession httpSession, @PathVariable("modelId") String[] modelId) {
		httpSession.getAttribute("userLogin");
		if (modelId.length > 0) {
			for (int i = 0; i < modelId.length; i++) {
				Model modelData = repositoryService.getModel(modelId[i]);
				if (null != modelData) {
					try {
						ProcessInstance pi = runtimeService.createProcessInstanceQuery()
								.processDefinitionKey(modelData.getKey()).singleResult();
						if (null != pi) {
							runtimeService.deleteProcessInstance(pi.getId(), "");
							historyService.deleteHistoricProcessInstance(pi.getId());
						}
						repositoryService.deleteModel(modelId[i]);
					} catch (Exception e) {
						return new RestfulMessage().success("删除流程实例服务异常");
					}
				}
			}

		}

		return new RestfulMessage().success();
	}
	
	//设置分类
	@RequestMapping(value = "/setCategory/{categoryId}/{defIds}",method = {RequestMethod.DELETE,RequestMethod.GET})
	public RestfulMessage  setCategory(HttpSession httpSession,@PathVariable("defIds") String defIds[],@PathVariable("categoryId") String categoryId) {
		httpSession.getAttribute("userLogin");
		if (defIds.length > 0) {
			for (int i = 0; i < defIds.length; i++) {
				Model modelData = repositoryService.getModel(defIds[i]);
				modelData.setCategory(categoryId);
				if (null != modelData) {
					try { /**
							 * 参数不加true:为普通删除，如果当前规则下有正在执行的流程，则抛异常 参数加true:为级联删除,会删除和当前规则相关的所有信息，包括历史
							 */
						 repositoryService.saveModel(modelData);
					} catch (Exception e) {
						return new RestfulMessage().failure("撤销流程定义异常");
					}
				}
			}}

		return new RestfulMessage().success();
	}
	//导出zip流程文件
	@RequestMapping("/export")
	public RestfulMessage  export(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("activiti/process/definition/index");
		return new RestfulMessage().success();
	}
	//导入zip流程文件
	@RequestMapping("/import")
	public RestfulMessage  importXml(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("activiti/process/definition/index");
		return new RestfulMessage().success();
	}
	//挂起,撤销流程定义
	@RequestMapping("/suspend/{modelId}")
	public RestfulMessage suspend(HttpSession httpSession, @PathVariable("modelId") String modelId[]) {
		httpSession.getAttribute("userLogin");
		if (modelId.length > 0) {
			for (int i = 0; i < modelId.length; i++) {
				Model modelData = repositoryService.getModel(modelId[i]);
				if (null != modelData) {
					try { /**
							 * 参数不加true:为普通删除，如果当前规则下有正在执行的流程，则抛异常 参数加true:为级联删除,会删除和当前规则相关的所有信息，包括历史
							 */
						repositoryService.deleteDeployment(modelData.getDeploymentId(), true);
					} catch (Exception e) {
						return new RestfulMessage().success("撤销流程定义异常");
					}
				}
			}}

		return new RestfulMessage().success();
	}

	// 发布流程
	@RequestMapping("/publish/{modelId}")
	public RestfulMessage publish(HttpSession httpSession, @PathVariable("modelId") String modelId[]) {
		RestfulMessage result = new RestfulMessage();
		if (modelId.length > 0) {
			for (int i = 0; i < modelId.length; i++) {
				try {
					Model modelData = repositoryService.getModel(modelId[i]);
					byte[] bytes = repositoryService.getModelEditorSource(modelData.getId());
					if (bytes == null) {

						result = RestfulMessage.failure("部署ID:" + modelId + "的模型数据为空，请先设计流程并成功保存，再进行发布");
					}
					JsonNode modelNode = new ObjectMapper().readTree(bytes);
					BpmnModel model = new BpmnJsonConverter().convertToBpmnModel(modelNode);
					Deployment deployment = repositoryService.createDeployment().name(modelData.getName())
							.addBpmnModel(modelData.getKey() + ".bpmn20.xml", model).deploy();
					modelData.setDeploymentId(deployment.getId());
					repositoryService.saveModel(modelData);
					result = RestfulMessage.success();
				} catch (Exception e) {
					result = RestfulMessage.failure("部署modelId:模型服务异常" + modelId);
				}
			}
		}
		return result;
	}
	//恢复|发布流程
	@RequestMapping("/recover/modelId")
	public RestfulMessage  recover(HttpSession httpSession,@PathVariable("modelId") String modelId) {
		RestfulMessage result= new RestfulMessage();
		try {
			Model modelData = repositoryService.getModel(modelId);
	        byte[] bytes = repositoryService.getModelEditorSource(modelData.getId());
			if (bytes == null) {

				result = RestfulMessage.failure("部署ID:" + modelId + "的模型数据为空，请先设计流程并成功保存，再进行发布");
			}
			JsonNode modelNode = new ObjectMapper().readTree(bytes);
			BpmnModel model = new BpmnJsonConverter().convertToBpmnModel(modelNode);
	        Deployment deployment = repositoryService.createDeployment()
	        		.name(modelData.getName())
	        		.addBpmnModel(modelData.getKey()+".bpmn20.xml", model)
	        		.deploy();
	        modelData.setDeploymentId(deployment.getId());
	        repositoryService.saveModel(modelData);
	        result = RestfulMessage.success();
		} catch (Exception e) {
			result = RestfulMessage.failure("部署modelId:模型服务异常" + modelId );
		}
		return result;
    }
	//复制
	@RequestMapping("/copy")
	public ModelAndView  copy(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("activiti/process/definition/index");
		return mv;
	}
	//设置
	//编辑指南
	//清楚数据
	/**
流程名称、流程业务主键、流程状态、测试状态、创建开始时间、创建结束时间
	 */
	@RequestMapping(value = "/datatable/listJson.json", method = RequestMethod.GET)
	public DataTableResult listJson(HttpServletRequest request,HttpSession httpSession,BpmnDefineVO vo) {
		return service.findByDataTable(vo);
	}
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public DataTableResult findAll(HttpServletRequest request,HttpSession httpSession) {
		int start = Integer.parseInt(request.getParameter("start"));
		int rows = Integer.parseInt(request.getParameter("length"));

		HashMap<String, Object> map = new HashMap<String, Object>();
		int page=1;
		if(start==0) {
			 page=1;
		}else {
			 page=start/rows+1;			
		}
		httpSession.getAttribute("userLogin");
		return processDefinitionService.findAll(map, page, rows);
	}
}
