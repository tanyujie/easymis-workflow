package org.easymis.workflow.app.service.bpm.impl;

import java.util.List;

import org.easymis.workflow.app.entity.bpm.FormDefine;
import org.easymis.workflow.app.entity.vo.FormDefineVO;
import org.easymis.workflow.app.service.bpm.FormDefineService;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
@Service
@Transactional
public class FormDefineServiceImpl implements FormDefineService {

	@Override
	public Boolean save(FormDefine bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(FormDefine bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FormDefine get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo findByPage(FormDefineVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FormDefine> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataTableResult findByDataTable(FormDefineVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
