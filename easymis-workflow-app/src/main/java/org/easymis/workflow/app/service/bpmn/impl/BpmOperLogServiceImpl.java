package org.easymis.workflow.app.service.bpmn.impl;

import java.util.List;

import org.easymis.workflow.app.entity.bpm.BpmnOperLog;
import org.easymis.workflow.app.entity.vo.BpmnOperLogVO;
import org.easymis.workflow.app.service.bpmn.BpmnOperLogService;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
@Service
@Transactional
public class BpmOperLogServiceImpl implements BpmnOperLogService {

	@Override
	public Boolean save(BpmnOperLog bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(BpmnOperLog bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BpmnOperLog get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo findByPage(BpmnOperLogVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BpmnOperLog> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataTableResult findByDataTable(BpmnOperLogVO vo) {
		// TODO Auto-generated method stub
		return null;
	}}
