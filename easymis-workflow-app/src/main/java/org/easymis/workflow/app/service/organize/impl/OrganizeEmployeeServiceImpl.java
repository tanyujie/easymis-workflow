package org.easymis.workflow.app.service.organize.impl;

import java.util.List;

import org.easymis.workflow.app.entity.organize.OrganizeEmployee;
import org.easymis.workflow.app.entity.vo.OrganizeEmployeeVO;
import org.easymis.workflow.app.mapper.OrganizeEmployeeMapper;
import org.easymis.workflow.app.service.organize.OrganizeEmployeeService;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
@Transactional
public class OrganizeEmployeeServiceImpl implements OrganizeEmployeeService {
	@Autowired
	private OrganizeEmployeeMapper mapper;
	@Override
	public Boolean save(OrganizeEmployee bean) {
		try {
			mapper.insertByBean(bean);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean update(OrganizeEmployee bean) {
		try {
			mapper.updateByBean(bean);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean delete(String id) {
		try {
			mapper.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public Boolean disable(String id) {
		try {
			//
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public OrganizeEmployee get(String id) {

		return mapper.findById(id);

	}

	@Override
	public PageInfo findByPage(OrganizeEmployeeVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<OrganizeEmployee> dataList = mapper.findByBean(vo);
		PageInfo<OrganizeEmployee>  p = new PageInfo<>(dataList);
		return p;
	}

	@Override
	public List<OrganizeEmployee> findAll() {
		return mapper.findAll();
		}

	@Override
	public DataTableResult findByDataTable(OrganizeEmployeeVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		DataTableResult result = new DataTableResult();
		List<OrganizeEmployee> itemList = mapper.findByBean(vo);
		result.setData(itemList);
		PageInfo<OrganizeEmployee> info = new PageInfo<>(itemList);
		result.setRecordsTotal((int) info.getTotal());
		result.setRecordsFiltered((int) info.getTotal());
		return result;

	}



}
