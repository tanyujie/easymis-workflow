package org.easymis.workflow.app.service.bpm.impl;

import java.util.List;

import org.easymis.workflow.app.entity.bpm.BpmFormTemplate;
import org.easymis.workflow.app.entity.bpm.BpmFormTemplateVO;
import org.easymis.workflow.app.service.bpm.BpmFormTemplateService;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
@Service
@Transactional
public class BpmFormTemplateServiceImpl implements BpmFormTemplateService {

	@Override
	public Boolean save(BpmFormTemplate bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(BpmFormTemplate bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BpmFormTemplate get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo findByPage(BpmFormTemplateVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BpmFormTemplate> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataTableResult findByDataTable(BpmFormTemplateVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
