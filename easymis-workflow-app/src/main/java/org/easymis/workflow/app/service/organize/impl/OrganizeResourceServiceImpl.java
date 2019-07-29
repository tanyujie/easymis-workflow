package org.easymis.workflow.app.service.organize.impl;

import java.util.List;

import org.easymis.workflow.app.entity.organize.OrganizeResource;
import org.easymis.workflow.app.entity.vo.OrganizeResourceVO;
import org.easymis.workflow.app.mapper.OrganizeResourceMapper;
import org.easymis.workflow.app.service.organize.OrganizeResourceService;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
@Transactional
public class OrganizeResourceServiceImpl implements OrganizeResourceService {
	@Autowired
	private OrganizeResourceMapper mapper;
	@Override
	public Boolean save(OrganizeResource bean) {
		try {
			mapper.insertByBean(bean);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean update(OrganizeResource bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrganizeResource get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo findByPage(OrganizeResourceVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrganizeResource> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataTableResult findByDataTable(OrganizeResourceVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		DataTableResult result = new DataTableResult();
		List<OrganizeResourceVO> itemList = mapper.findByBean(vo);
		result.setData(itemList);
		PageInfo<OrganizeResourceVO> info = new PageInfo<>(itemList);
		result.setRecordsTotal((int) info.getTotal());
		result.setRecordsFiltered((int) info.getTotal());
		return result;

	}

}
