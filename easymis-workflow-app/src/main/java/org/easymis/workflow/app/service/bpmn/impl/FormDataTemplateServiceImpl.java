package org.easymis.workflow.app.service.bpmn.impl;

import java.util.List;

import org.easymis.workflow.app.entity.bpm.FormDataTemplate;
import org.easymis.workflow.app.entity.vo.FormDataTemplateVO;
import org.easymis.workflow.app.service.bpmn.FormDataTemplateService;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
@Service
@Transactional
public class FormDataTemplateServiceImpl implements FormDataTemplateService {

	@Override
	public Boolean save(FormDataTemplate bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(FormDataTemplate bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FormDataTemplate get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo findByPage(FormDataTemplateVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FormDataTemplate> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataTableResult findByDataTable(FormDataTemplateVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
