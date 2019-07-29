package org.easymis.workflow.app.service.bpmn.impl;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.easymis.workflow.app.entity.bpm.BpmnTask;
import org.easymis.workflow.app.entity.vo.BaseForm;
import org.easymis.workflow.app.entity.vo.BpmnTaskVO;
import org.easymis.workflow.app.service.bpmn.BpmnTaskService;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
@Service
@Transactional
public class BpmnTaskServiceImpl implements BpmnTaskService {
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private IdentityService identityService;
	@Autowired
	private TaskService taskService;
	@Override
	public Boolean save(BpmnTask bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(BpmnTask bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BpmnTask get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo findByPage(BpmnTaskVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BpmnTask> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataTableResult findByDataTable(BpmnTaskVO vo) {		
		//PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		DataTableResult result = new DataTableResult();
		List<Task> tasks = taskService.createTaskQuery().listPage(vo.getPageNum(), vo.getPageSize());
		List<BpmnTaskVO> dataList = new ArrayList<BpmnTaskVO>();
		for (Task task : tasks) {
			BpmnTaskVO bean = new BpmnTaskVO();
			bean.setId(task.getId());
			bean.setName(task.getName());
			//bean.seta
			bean.setCreateTime(task.getCreateTime());
			if(task.getPriority()==50)
			bean.setStatusString("普通");
			
			
			// 查询流程参数
			BaseForm var = (BaseForm) runtimeService.getVariable(task.getProcessInstanceId(), "arg");
			if(var!=null)
			//实例标题
			bean.setSubject(var.getTitle());

			dataList.add(bean);
		}
		result.setData(dataList);
		PageInfo<Task> info = new PageInfo<>(tasks);
		result.setRecordsTotal((int) info.getTotal());
		result.setRecordsFiltered((int) info.getTotal());
		return result;

	
	}

	@Override
	public Boolean completeBatch(String[] taskIds, String opinion, String actionName) {
		if(taskIds.length>0) {
			for(int i=0;i<taskIds.length;i++) {
				ProcessInstance pi = getProcessInstance(taskIds[i]);
				this.identityService.setAuthenticatedUserId("1a91404e-211b-4042-9241-800f8e6bfa05");
				// 添加评论
				this.taskService.addComment(taskIds[i], pi.getId(), opinion);
				// 完成任务
				this.taskService.complete(taskIds[i]);
				
			}

		}

		return true;
	}
	private ProcessInstance getProcessInstance(String taskId) {
		Task task = this.taskService.createTaskQuery().taskId(taskId)
				.singleResult();
		// 根据任务查询流程实例
		ProcessInstance pi = this.runtimeService.createProcessInstanceQuery()
				.processInstanceId(task.getProcessInstanceId()).singleResult();
		return pi;
	}

}
