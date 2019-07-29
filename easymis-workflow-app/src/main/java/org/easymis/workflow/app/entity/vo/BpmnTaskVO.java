package org.easymis.workflow.app.entity.vo;

import java.util.Date;

public class BpmnTaskVO extends VO {
	private String pk;// ": "",
	private String name;// ": "部门领导审批",
	private Date createTime;// ": "2019-05-29 15:08:40",
	private String id;// ": "583310749892345857",
	private String subject;// ": "管理员在2019-05-29 15:08:37发起签报流转流程",
	private String procInstId;// ": "583310737061969920",
	private String taskId;// ": "583310749892345857",
	private String execId;// ": "583310742678142976",
	private String nodeId;// ": "UserTask_18paosc",
	private String procDefId;// ": "486475689579511808",
	private String procDefKey;// ": "Process_qianbao",
	private String procDefName;// ": "签报流转流程",
	private String status;// ": "NORMAL",
	private String statusString;//状态
	private Integer priority;// ": 50,
	private Integer suspendState;// ": 2,
	private String bpmnInstId;// ": "583310742678142976",
	private String bpmnDefId;// ": "Process_qianbao:1:486475689378185216",
	private String categoryId;// ": "485095036371861504",
	private Integer lockState;// ": 1,
	private String lockUser;// ": "1",
	private String allowShfit;// ": "Y",
	/*
	 * "authorizeRight": { "authType": "task", "managementEdit": "N",
	 * "managementDel": "N", "managementStart": "N", "managementSet": "N",
	 * "managementInternational": "N", "managementClean": "N",
	 * "managementGuideEdit": "N", "instanceDel": "N", "instanceLog": "N",
	 * "rightContent": "{}", "rightJsonObj": {} },
	 */
	private String ownerName;// 管理员,财务人员00003,测试二部00001",
	private Integer remindTimes;
	private Boolean identityEmpty;
	public String getPk() {
		return pk;
	}
	public String getStatusString() {
		return statusString;
	}
	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}
	public void setPk(String pk) {
		this.pk = pk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getProcInstId() {
		return procInstId;
	}
	public void setProcInstId(String procInstId) {
		this.procInstId = procInstId;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getExecId() {
		return execId;
	}
	public void setExecId(String execId) {
		this.execId = execId;
	}
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public String getProcDefId() {
		return procDefId;
	}
	public void setProcDefId(String procDefId) {
		this.procDefId = procDefId;
	}
	public String getProcDefKey() {
		return procDefKey;
	}
	public void setProcDefKey(String procDefKey) {
		this.procDefKey = procDefKey;
	}
	public String getProcDefName() {
		return procDefName;
	}
	public void setProcDefName(String procDefName) {
		this.procDefName = procDefName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getSuspendState() {
		return suspendState;
	}
	public void setSuspendState(Integer suspendState) {
		this.suspendState = suspendState;
	}
	public String getBpmnInstId() {
		return bpmnInstId;
	}
	public void setBpmnInstId(String bpmnInstId) {
		this.bpmnInstId = bpmnInstId;
	}
	public String getBpmnDefId() {
		return bpmnDefId;
	}
	public void setBpmnDefId(String bpmnDefId) {
		this.bpmnDefId = bpmnDefId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getLockState() {
		return lockState;
	}
	public void setLockState(Integer lockState) {
		this.lockState = lockState;
	}
	public String getLockUser() {
		return lockUser;
	}
	public void setLockUser(String lockUser) {
		this.lockUser = lockUser;
	}
	public String getAllowShfit() {
		return allowShfit;
	}
	public void setAllowShfit(String allowShfit) {
		this.allowShfit = allowShfit;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public Integer getRemindTimes() {
		return remindTimes;
	}
	public void setRemindTimes(Integer remindTimes) {
		this.remindTimes = remindTimes;
	}
	public Boolean getIdentityEmpty() {
		return identityEmpty;
	}
	public void setIdentityEmpty(Boolean identityEmpty) {
		this.identityEmpty = identityEmpty;
	}

}
