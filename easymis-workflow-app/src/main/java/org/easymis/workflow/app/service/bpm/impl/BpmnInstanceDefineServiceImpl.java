package org.easymis.workflow.app.service.bpm.impl;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.easymis.workflow.app.entity.bpm.BpmnInstanceDefine;
import org.easymis.workflow.app.entity.vo.BaseForm;
import org.easymis.workflow.app.entity.vo.BpmnInstanceDefineVO;
import org.easymis.workflow.app.service.bpm.BpmInstanceDefineService;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
@Service
@Transactional
public class BpmnInstanceDefineServiceImpl implements BpmInstanceDefineService {
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private ProcessEngine processEngine;
	@Override
	public Boolean save(BpmnInstanceDefine bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(BpmnInstanceDefine bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BpmnInstanceDefine get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo findByPage(BpmnInstanceDefineVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BpmnInstanceDefine> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataTableResult findByDataTable(BpmnInstanceDefineVO vo) {		
		//PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		DataTableResult result = new DataTableResult();
		List<ProcessInstance> instances = runtimeService.createProcessInstanceQuery().listPage(vo.getPageNum(), vo.getPageSize());
		List<BpmnInstanceDefineVO> dataList = new ArrayList<BpmnInstanceDefineVO>();
		for (ProcessInstance pi : instances) {
			BpmnInstanceDefineVO bean = new BpmnInstanceDefineVO();
			bean.setId(pi.getId());
			bean.setCreateTime(pi.getStartTime());
			bean.setCreateBy(pi.getStartUserId());	
			//
			bean.setProcDefName(pi.getName());
			bean.setProcDefId(pi.getProcessInstanceId());
			bean.setBpmnDefId(pi.getProcessDefinitionId());
			
			//当前节点
			Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
			if (task != null) {
				bean.setCurrentNode(task.getName());
				bean.setStatusString("运行中");
			}
			else {
				bean.setStatusString("草稿");
			}
			// 查询流程参数
			BaseForm var = (BaseForm) this.runtimeService.getVariable(
					pi.getId(), "arg");
			if(var!=null)
			//实例标题
			bean.setSubject(var.getTitle());

			dataList.add(bean);
		}
		result.setData(dataList);
		PageInfo<ProcessInstance> info = new PageInfo<>(instances);
		result.setRecordsTotal((int) info.getTotal());
		result.setRecordsFiltered((int) info.getTotal());
		return result;

	
	}

}
