package org.easymis.workflow.app.service.bpm.impl;

import java.util.List;

import org.easymis.workflow.app.entity.bpm.BpmnTask;
import org.easymis.workflow.app.entity.vo.BpmnTaskVO;
import org.easymis.workflow.app.service.bpm.BpmAuthService;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
@Service
@Transactional
public class BpmnAuthServiceImpl implements BpmAuthService {

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
		// TODO Auto-generated method stub
		return null;
	}

}
