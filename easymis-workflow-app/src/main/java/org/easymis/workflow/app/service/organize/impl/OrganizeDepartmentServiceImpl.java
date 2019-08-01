package org.easymis.workflow.app.service.organize.impl;

import java.util.List;

import org.easymis.workflow.app.entity.organize.OrganizeDepartment;
import org.easymis.workflow.app.entity.organize.OrganizeDepartmentVO;
import org.easymis.workflow.app.service.organize.OrganizeDepartmentService;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
@Service
@Transactional
public class OrganizeDepartmentServiceImpl implements OrganizeDepartmentService {

	@Override
	public Boolean save(OrganizeDepartment bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(OrganizeDepartment bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrganizeDepartment get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo findByPage(OrganizeDepartmentVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrganizeDepartment> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataTableResult findByDataTable(OrganizeDepartmentVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
