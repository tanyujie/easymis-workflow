package org.easymis.workflow.app.service.bpm.impl;

import java.util.List;

import org.easymis.workflow.app.entity.bpm.BpmnCategory;
import org.easymis.workflow.app.entity.vo.BpmnCategoryVO;
import org.easymis.workflow.app.mapper.BpmnCategoryMapper;
import org.easymis.workflow.app.service.bpm.BpmCategoryService;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
@Transactional
public class BpmnCategoryServiceImpl implements BpmCategoryService {
	@Autowired
	private BpmnCategoryMapper mapper;
	@Override
	public Boolean save(BpmnCategory bean) {
		try {
			mapper.insertByBean(bean);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean update(BpmnCategory bean) {
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
	public BpmnCategory get(String id) {

		return mapper.findById(id);

	}

	@Override
	public PageInfo findByPage(BpmnCategoryVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<BpmnCategory> dataList = mapper.findByBean(vo);
		PageInfo<BpmnCategory>  p = new PageInfo<>(dataList);
		return p;
	}

	@Override
	public List<BpmnCategory> findAll() {
		return mapper.findAll();
	}

	@Override
	public DataTableResult findByDataTable(BpmnCategoryVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		DataTableResult result = new DataTableResult();
		List<BpmnCategory> itemList = mapper.findByBean(vo);
		result.setData(itemList);
		PageInfo<BpmnCategory> info = new PageInfo<>(itemList);
		result.setRecordsTotal((int) info.getTotal());
		result.setRecordsFiltered((int) info.getTotal());
		return result;

	}

}
