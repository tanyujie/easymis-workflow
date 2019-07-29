package org.easymis.workflow.app.service.organize.impl;

import java.util.List;

import org.easymis.workflow.app.entity.organize.OrganizeGroup;
import org.easymis.workflow.app.entity.vo.OrganizeGroupVO;
import org.easymis.workflow.app.mapper.OrganizeGroupMapper;
import org.easymis.workflow.app.service.organize.OrganizeGroupService;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
@Transactional
public class OrganizeGroupServiceImpl implements OrganizeGroupService {
	@Autowired
	private OrganizeGroupMapper mapper;
	@Override
	public Boolean save(OrganizeGroup bean) {
		try {
			mapper.insertByBean(bean);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean update(OrganizeGroup bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrganizeGroup get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo findByPage(OrganizeGroupVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrganizeGroup> findAll() {
		return mapper.findAll();
		}

	@Override
	public DataTableResult findByDataTable(OrganizeGroupVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		DataTableResult result = new DataTableResult();
		List<OrganizeGroup> itemList = mapper.findByBean(vo);
		result.setData(itemList);
		PageInfo<OrganizeGroup> info = new PageInfo<>(itemList);
		result.setRecordsTotal((int) info.getTotal());
		result.setRecordsFiltered((int) info.getTotal());
		return result;

	}

}
