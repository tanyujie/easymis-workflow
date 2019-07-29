package org.easymis.workflow.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.easymis.workflow.app.entity.vo.GroupVO;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GroupServiceImpl {
	@Autowired
	private IdentityService identityService;
	
	public  DataTableResult  findAll(Map<String, Object> map, int page, int rows) {
        DataTableResult result=new DataTableResult();
        int totle=identityService.createGroupQuery().list().size();
		List<Group> groups = identityService.createGroupQuery().listPage(page, rows);
		List<GroupVO> dataList = new ArrayList<GroupVO>();
		for (Group grop : groups) {
			GroupVO gropVO = new GroupVO();
			gropVO.setId(grop.getId());
			gropVO.setName(grop.getName());
			gropVO.setType(grop.getType());
			dataList.add(gropVO);
		}
		//result.setDraw(page);
		result.setData(dataList);
		result.setRecordsTotal(totle);
		result.setRecordsFiltered(totle);

		return result;
		
	}
}
