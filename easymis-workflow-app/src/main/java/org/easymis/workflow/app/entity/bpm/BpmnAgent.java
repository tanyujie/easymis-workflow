package org.easymis.workflow.app.entity.bpm;

import java.util.Date;

public class BpmnAgent {
	private String agentId;
	private String creatorId;
	private Date createTime;
	// 标题
	private String title;
	// 委托人
	private String delegatorId;
	// 代理人
	private String agenterId;
	//
	private String procDefKey;
	// 是否启用
	private Boolean isEnabled;
	// 生效时间
	private Date effectiveTime;
	// 失效时间
	private Date expiryTime;
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDelegatorId() {
		return delegatorId;
	}
	public void setDelegatorId(String delegatorId) {
		this.delegatorId = delegatorId;
	}
	public String getAgenterId() {
		return agenterId;
	}
	public void setAgenterId(String agenterId) {
		this.agenterId = agenterId;
	}
	public String getProcDefKey() {
		return procDefKey;
	}
	public void setProcDefKey(String procDefKey) {
		this.procDefKey = procDefKey;
	}
	public Boolean getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public Date getEffectiveTime() {
		return effectiveTime;
	}
	public void setEffectiveTime(Date effectiveTime) {
		this.effectiveTime = effectiveTime;
	}
	public Date getExpiryTime() {
		return expiryTime;
	}
	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
	}

}
