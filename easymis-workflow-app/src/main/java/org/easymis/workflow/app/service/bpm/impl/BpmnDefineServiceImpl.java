package org.easymis.workflow.app.service.bpm.impl;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.RepositoryService;
import org.easymis.workflow.app.entity.bpm.BpmnDefine;
import org.easymis.workflow.app.entity.vo.BpmnDefineVO;
import org.easymis.workflow.app.entity.vo.BpmnModelVO;
import org.easymis.workflow.app.mapper.BpmnDefineMapper;
import org.easymis.workflow.app.service.bpm.BpmDefineService;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
@Transactional
public class BpmnDefineServiceImpl implements BpmDefineService{
	@Autowired
	private BpmnDefineMapper mapper;
	@Autowired
	private RepositoryService repositoryService;
	@Override
	public Boolean save(BpmnDefine bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(BpmnDefine bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(String id) {
		try {
			repositoryService.deleteDeployment(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteDeployment(String deploymentId) {
		try {
			repositoryService.deleteDeployment(deploymentId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public BpmnDefine get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo findByPage(BpmnDefineVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BpmnDefine> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataTableResult findByDataTable(BpmnDefineVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		DataTableResult result = new DataTableResult();
		List<BpmnModelVO> models = mapper.findByBean(vo);

		List<BpmnDefineVO> dataList = new ArrayList<BpmnDefineVO>();
		for (BpmnModelVO model : models) {
			BpmnDefineVO bpmnDefine = new BpmnDefineVO();
			bpmnDefine.setId(model.getId());
			bpmnDefine.setName(model.getName());
			bpmnDefine.setDefKey(model.getKey());
			bpmnDefine.setCreateTime(model.getCreateTime());
			bpmnDefine.setUpdateTime(model.getLastUpdateTime());
			if(model.getDeploymentId()!=null)
			bpmnDefine.setStatus("已发布");
			else
				bpmnDefine.setStatus("草稿");
				
			bpmnDefine.setTestStatus("测试");
			bpmnDefine.setVersion(model.getVersion().toString());
			dataList.add(bpmnDefine);
		}
		result.setData(dataList);
		PageInfo<BpmnModelVO> info = new PageInfo<>(models);
		result.setRecordsTotal((int) info.getTotal());
		result.setRecordsFiltered((int) info.getTotal());
		return result;

	}


}
