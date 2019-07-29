package org.easymis.workflow.app.service.organize.impl;

import java.util.List;

import org.easymis.workflow.app.entity.organize.OrganizePosition;
import org.easymis.workflow.app.entity.vo.OrganizePositionVO;
import org.easymis.workflow.app.mapper.OrganizePositionMapper;
import org.easymis.workflow.app.service.organize.OrganizePositionService;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
@Transactional
public class OrganizePositionServiceImpl implements OrganizePositionService {
	@Autowired
	private OrganizePositionMapper mapper;
	@Override
	public Boolean save(OrganizePosition bean) {
		try {
			mapper.insertByBean(bean);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean update(OrganizePosition bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrganizePosition get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo findByPage(OrganizePositionVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrganizePosition> findAll() {
		return mapper.findAll();
		}

	@Override
	public DataTableResult findByDataTable(OrganizePositionVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		DataTableResult result = new DataTableResult();
		List<OrganizePositionVO> itemList = mapper.findByBean(vo);
		result.setData(itemList);
		PageInfo<OrganizePositionVO> info = new PageInfo<>(itemList);
		result.setRecordsTotal((int) info.getTotal());
		result.setRecordsFiltered((int) info.getTotal());
		return result;

	}

}
