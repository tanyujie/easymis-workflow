package org.easymis.workflow.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.easymis.workflow.app.entity.Role;
import org.easymis.workflow.app.entity.vo.UserVO;
import org.easymis.workflow.app.mapper.RoleMapper;
import org.easymis.workflow.app.utils.UUIDUtils;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private IdentityService identityService;

	public Role findById(String roleId) {
		return roleMapper.findById(roleId);
	}

	public boolean save(Role bean) {
		boolean flag = false;
		try {
			bean.setRoleId(UUIDUtils.getUUID());
			bean.setPriority(1);
			bean.setIsSuper(false);
			bean.setSystemDefault(false);
			roleMapper.insertByBean(bean);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// 查询全部用户
	public DataTableResult findAll(Map<String, Object> map, int page, int rows) {
        DataTableResult result=new DataTableResult();
        int totle=identityService.createUserQuery().list().size();
		List<User> users = this.identityService.createUserQuery().listPage(page, rows);
		List<UserVO> dataList = new ArrayList<UserVO>();
		for (User user : users) {
			UserVO userVO = new UserVO();
			userVO.setUserId(user.getId());
			userVO.setLastName(user.getLastName());
			// 查询用户组
			Group group = this.identityService.createGroupQuery()
					.groupMember(user.getId()).singleResult();
			// 查询年龄信息
			String age = identityService.getUserInfo(user.getId(), "age");
			userVO.setGroupName(group.getName());
			userVO.setAge(Integer.parseInt(age));
			dataList.add(userVO);
		}
		result.setData(dataList);
		result.setRecordsTotal(users.size());
		result.setRecordsFiltered(users.size());
		return result;
	}
}
