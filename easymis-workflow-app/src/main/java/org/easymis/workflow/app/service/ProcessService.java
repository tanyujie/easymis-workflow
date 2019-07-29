package org.easymis.workflow.app.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.FormService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.easymis.workflow.app.entity.Vacation;
import org.easymis.workflow.app.entity.vo.BaseForm;
import org.easymis.workflow.app.entity.vo.ProcessVO;
import org.easymis.workflow.app.entity.vo.VacationForm;
import org.easymis.workflow.app.mapper.VacationMapper;
import org.easymis.workflow.app.utils.DateUtil;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class ProcessService {
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private IdentityService identityService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private ProcessEngine processEngine;
	@Autowired
	private FormService formService;
	@Autowired
	private VacationMapper vacationMapper;

	// 查询请假申请
	public DataTableResult listVacation(String userId, int page, int rows) {
		PageHelper.startPage(page, rows);
		DataTableResult result = new DataTableResult();
		// 查询OA_VACATION表的数据
		List<Vacation> vacs = vacationMapper.findByUserId(userId);
		List<ProcessVO> dataList = new ArrayList<ProcessVO>();
		for (Vacation vac : vacs) {
			// 查询流程实例
			ProcessInstance pi = this.runtimeService.createProcessInstanceQuery()
					.processInstanceId(vac.getProcessInstanceId()).singleResult();
			if (pi != null) {
				// 查询流程参数
				BaseForm var = (BaseForm) this.runtimeService.getVariable(pi.getId(), "arg");
				// 封装界面对象
				ProcessVO vo = new ProcessVO();
				vo.setTitle(var.getTitle());
				vo.setRequestDate(var.getRequestDate());
				vo.setId(pi.getId());
				dataList.add(vo);
			}
		}
		result.setData(dataList);
		PageInfo<Vacation> info = new PageInfo<>(vacs);
		result.setRecordsTotal((int) info.getTotal());
		result.setRecordsFiltered((int) info.getTotal());
		return result;
	}

	// 启动请假流程
	public ProcessInstance startVacation(VacationForm vacation) {
		// 设置标题
		vacation.setTitle(vacation.getUserName() + " 的请假申请");
		vacation.setBusinessType("请假申请");
		// 查找流程定义
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().processDefinitionKey("Vacation")
				.singleResult();
		// 初始化任务参数
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("arg", vacation);
		// 启动流程
		ProcessInstance pi = this.runtimeService.startProcessInstanceByKey(pd.getKey());
		// 查询第一个任务
		Task firstTask = this.taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
		// 设置任务受理人
		taskService.setAssignee(firstTask.getId(), vacation.getUserId());
		// 完成任务
		taskService.complete(firstTask.getId(), vars);
		// 记录请假数据
		saveVacation(vacation, pi.getId());
		return pi;
	}
	// 启动请假流程
	public void startVacation(String processInstanceId) {
		// 查找流程定义
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().processDefinitionKey("ExternalForm")
				.singleResult();

		// 启动流程并设置days参数
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("days", "4");
		ProcessInstance pi = formService.submitStartFormData(pd.getId(), vars);
		// 输出开始表单内容
		Object obj = formService.getRenderedStartForm(pd.getId());
		System.out.println(obj);
		// 输出被渲染后的任务表单内容
		Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
		Object form = formService.getRenderedTaskForm(task.getId());
		System.out.println(form);
	}
	// 将一条请假申请保存到OA_VACATION表中
	private void saveVacation(VacationForm vacForm, String piId) {
		Vacation bean = new Vacation();
		bean.setBeginDate(DateUtil.getDate(vacForm.getStartDate()));
		bean.setDays(vacForm.getDays());
		bean.setEndDate(DateUtil.getDate(vacForm.getEndDate()));
		bean.setProcessInstanceId(piId);
		bean.setReason(vacForm.getReason());
		bean.setVacationType(vacForm.getVacationType());
		bean.setUserId(vacForm.getUserId());
		vacationMapper.insertByBean(bean);
	}
	public InputStream getDiagram(String processInstanceId) {
		// 查询流程实例
		ProcessInstance pi = this.runtimeService.createProcessInstanceQuery()
				.processInstanceId(processInstanceId).singleResult();
		// 查询流程实例
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()
				.processDefinitionId(pi.getProcessDefinitionId()).singleResult();
		// 获取BPMN模型对象
		BpmnModel model = repositoryService.getBpmnModel(pd.getId());
		// 定义使用宋体
		String fontName = "宋体";
		// 获取流程实实例当前点的节点，需要高亮显示
		List<String> currentActs = runtimeService.getActiveActivityIds(pi.getId());
		// BPMN模型对象、图片类型、显示的节点
		InputStream is = processEngine
				.getProcessEngineConfiguration()
				.getProcessDiagramGenerator()
				.generateDiagram(model, "png", currentActs, new ArrayList<String>(), 
				fontName, fontName, fontName,null, 1.0);
		return is;
	}
}
