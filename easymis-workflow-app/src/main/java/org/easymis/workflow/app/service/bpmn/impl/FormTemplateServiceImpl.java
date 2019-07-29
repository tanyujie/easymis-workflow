package org.easymis.workflow.app.service.bpmn.impl;

import java.util.List;

import org.easymis.workflow.app.entity.bpm.FormTemplate;
import org.easymis.workflow.app.entity.vo.FormTemplateVO;
import org.easymis.workflow.app.service.bpmn.FormTemplateService;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
@Service
@Transactional
public class FormTemplateServiceImpl implements FormTemplateService {

	@Override
	public Boolean save(FormTemplate bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(FormTemplate bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FormTemplate get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo findByPage(FormTemplateVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FormTemplate> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataTableResult findByDataTable(FormTemplateVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
