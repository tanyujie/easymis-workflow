package org.easymis.workflow.app.service.organize.impl;

import java.util.List;

import org.easymis.workflow.app.entity.organize.OrganizeEmployee;
import org.easymis.workflow.app.entity.organize.OrganizeRole;
import org.easymis.workflow.app.entity.vo.OrganizeRoleVO;
import org.easymis.workflow.app.mapper.OrganizeRoleMapper;
import org.easymis.workflow.app.service.organize.OrganizeRoleService;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
@Transactional
public class OrganizeRoleServiceImpl implements OrganizeRoleService {
	@Autowired
	private OrganizeRoleMapper mapper;
	@Override
	public Boolean save(OrganizeRole bean) {
		try {
			mapper.insertByBean(bean);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean update(OrganizeRole bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrganizeRole get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo findByPage(OrganizeRoleVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrganizeRole> findAll() {
		return mapper.findAll();
		}

	@Override
	public DataTableResult findByDataTable(OrganizeRoleVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		DataTableResult result = new DataTableResult();
		List<OrganizeRole> itemList = mapper.findByBean(vo);
		result.setData(itemList);
		PageInfo<OrganizeRole> info = new PageInfo<>(itemList);
		result.setRecordsTotal((int) info.getTotal());
		result.setRecordsFiltered((int) info.getTotal());
		return result;

	}

}
