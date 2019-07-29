package org.easymis.workflow.app.service;

import java.util.List;

import org.easymis.workflow.app.entity.Role;
import org.easymis.workflow.app.mapper.RoleMapper;
import org.easymis.workflow.app.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService {
	@Autowired
	private RoleMapper roleMapper;

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
	public List<Role> findAll() {
		return roleMapper.findAll();
	}
}
