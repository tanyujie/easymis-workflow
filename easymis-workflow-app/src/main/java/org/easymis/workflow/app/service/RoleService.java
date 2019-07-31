package org.easymis.workflow.app.service;

import java.util.List;

import org.easymis.workflow.app.entity.Role;
import org.easymis.workflow.app.mapper.RoleMapper;
import org.easymis.workflow.app.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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

	public boolean update(Role bean) {
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

	public boolean delete(String[] ids) {
		boolean flag = false;
		try {
			// roleMapper.insertByBean(bean);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List<Role> findAll() {
		return roleMapper.findAll();
	}

	public PageInfo getPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Role> list = roleMapper.findAll();
		PageInfo<Role> pageInfo = new PageInfo<Role>(list);
		return pageInfo;
	}
}
