package org.easymis.workflow.app.entity.vo;

import java.util.Date;

public class OrganizeEmployeeVO extends VO {
	private String employeeId;
	private String name;
	private String employeeAccount;
	private String status;
	private Date createTimeBegin;
	private Date createTimeEnd;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployeeAccount() {
		return employeeAccount;
	}

	public void setEmployeeAccount(String employeeAccount) {
		this.employeeAccount = employeeAccount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTimeBegin() {
		return createTimeBegin;
	}

	public void setCreateTimeBegin(Date createTimeBegin) {
		this.createTimeBegin = createTimeBegin;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

}
