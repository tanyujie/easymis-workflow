package org.easymis.workflow.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.easymis.workflow.app.entity.vo.BpmnModelVO;
import org.easymis.workflow.app.entity.vo.ProcessDefinitionVO;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class ProcessDefinitionService {
	@Autowired
	private RepositoryService repositoryService;
	

	public List<ProcessDefinitionVO> findAll() {

		List<ProcessDefinition> pdefs = repositoryService.createProcessDefinitionQuery().list();
		List<ProcessDefinitionVO> result = new ArrayList<ProcessDefinitionVO>();
		for (ProcessDefinition pdef : pdefs) {
			ProcessDefinitionVO pdefVO = new ProcessDefinitionVO();
			pdefVO.setName(pdef.getName());
			pdefVO.setKey(pdef.getKey());
			pdefVO.setId(pdef.getId());
			pdefVO.setResourceName(pdef.getResourceName());
			pdefVO.setDiagramResourceName(pdef.getDiagramResourceName());
			pdefVO.setIsSuspended(pdef.isSuspended());
			result.add(pdefVO);
		}
		return result;
	}
	public DataTableResult  findAll(Map<String, Object> map, int page, int rows) {
        DataTableResult result=new DataTableResult();
        /*        int totle=repositoryService.createProcessDefinitionQuery().list().size();
     
		List<ProcessDefinition> pdefs = repositoryService.createProcessDefinitionQuery().listPage(page, rows);
		List<ProcessDefinitionVO> dataList = new ArrayList<ProcessDefinitionVO>();
		for (ProcessDefinition pdef : pdefs) {
			ProcessDefinitionVO pdefVO = new ProcessDefinitionVO();
			pdefVO.setName(pdef.getName());
			pdefVO.setKey(pdef.getKey());
			pdefVO.setId(pdef.getId());
			pdefVO.setResourceName(pdef.getResourceName());
			pdefVO.setDiagramResourceName(pdef.getDiagramResourceName());
			pdefVO.setIsSuspended(pdef.isSuspended());
			dataList.add(pdefVO);
		}*/
        int totle=repositoryService.createModelQuery().list().size();
        List<Model> models=repositoryService.createModelQuery().listPage(page, rows);
		List<BpmnModelVO> dataList = new ArrayList<BpmnModelVO>();
		for (Model model : models) {
			BpmnModelVO modelVo = new BpmnModelVO();
			modelVo.setId(model.getId());
			modelVo.setName(model.getName());
			modelVo.setKey(model.getKey());
			modelVo.setCategory(model.getCategory());
			modelVo.setCreateTime(model.getCreateTime());
			modelVo.setLastUpdateTime(model.getLastUpdateTime());
			modelVo.setVersion(model.getVersion());
			modelVo.setMetaInfo(model.getMetaInfo());
			modelVo.setDeploymentId(model.getDeploymentId());
			//modelVo.setEditorSourceValueId(model.get);
			//modelVo.setEditorSourceExtraValueId(model.gete);
			modelVo.setTenantId(model.getTenantId());
			dataList.add(modelVo);
		}
		
		//result.setDraw(page);
		result.setData(dataList);
		result.setRecordsTotal(totle);
		result.setRecordsFiltered(totle);

		return result;
		
	}
	
}
