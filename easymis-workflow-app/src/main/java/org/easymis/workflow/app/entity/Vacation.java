package org.easymis.workflow.app.entity;

import java.util.Date;

public class Vacation{
	// 带薪假
	public final static int TYPE_PAID = 0;
	// 病假
	public final static int TYPE_SICK = 1;
	// 事假
	public final static int TYPE_MATTER = 2;
	private int id;
	private int days;
	private Date beginDate;
	private Date endDate;
	private int vacationType;
	private String reason;
	private String processInstanceId;
	private String userId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getVacationType() {
		return vacationType;
	}
	public void setVacationType(int vacationType) {
		this.vacationType = vacationType;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	
}
