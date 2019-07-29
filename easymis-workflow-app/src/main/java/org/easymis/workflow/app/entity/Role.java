package org.easymis.workflow.app.entity;

import java.util.ArrayList;
import java.util.List;

public class Role {
	private String roleId;
	private String roleName;
	private Boolean isSuper;
	private Integer priority;// 排列顺序
	private Boolean systemDefault;//系统默认
	private String depict;
    private List<User> users = new ArrayList<>();
    private List<Permission> permissions = new ArrayList<>();
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Boolean getIsSuper() {
		return isSuper;
	}

	public void setIsSuper(Boolean isSuper) {
		this.isSuper = isSuper;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}



	public Boolean getSystemDefault() {
		return systemDefault;
	}

	public void setSystemDefault(Boolean systemDefault) {
		this.systemDefault = systemDefault;
	}

	public String getDepict() {
		return depict;
	}

	public void setDepict(String depict) {
		this.depict = depict;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

}
