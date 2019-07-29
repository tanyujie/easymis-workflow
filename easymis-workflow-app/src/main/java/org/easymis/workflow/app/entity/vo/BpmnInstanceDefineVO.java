package org.easymis.workflow.app.entity.vo;

import java.util.Date;

public class BpmnInstanceDefineVO extends VO{
	private String pk;
	private String createBy;//": "1",
	private Date createTime;//": "2019-05-29 15:08:37",
	private String id;//": "583310737061969920",
	private String subject;//": "管理员在2019-05-29 15:08:37发起签报流转流程",
	//流程实例id
	private String procDefId;//": "486475689579511808",
	private String bpmnDefId;//: "Process_qianbao:1:486475689378185216",
	private String procDefKey;//": "Process_qianbao",
	//流程名称
	private String procDefName;//": "签报流转流程",
	private String bizKey;//": "583310698570842112",
	private String formType;//": "frame",
	private String formKey;//": "",
	private String status;//": "suspend",
	private String statusString;//": "suspend",
/*	"bpmnInstId": "583310742678142976",
	"isFormmal": "N",
	"parentInstId": "0",
	"isForbidden": 0,
	"dataMode": "pk",
	"forbidden": "未禁止",
	"authorizeRight": {
		"authType": "instance",
		"managementEdit": "N",
		"managementDel": "N",
		"managementStart": "N",
		"managementSet": "N",
		"managementInternational": "N",
		"managementClean": "N",
		"managementGuideEdit": "N",
		"instanceDel": "Y",
		"instanceLog": "Y",
		"rightContent": "{}",
		"rightJsonObj": {}
	},*/
	
	private String currentNode;//": "部门领导审批"
	

	public String getBizKey() {
		return bizKey;
	}
	public void setBizKey(String bizKey) {
		this.bizKey = bizKey;
	}
	public String getFormType() {
		return formType;
	}
	public void setFormType(String formType) {
		this.formType = formType;
	}
	public String getFormKey() {
		return formKey;
	}
	public void setFormKey(String formKey) {
		this.formKey = formKey;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusString() {
		return statusString;
	}
	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}
	public String getProcDefId() {
		return procDefId;
	}
	public void setProcDefId(String procDefId) {
		this.procDefId = procDefId;
	}
	public String getBpmnDefId() {
		return bpmnDefId;
	}
	public void setBpmnDefId(String bpmnDefId) {
		this.bpmnDefId = bpmnDefId;
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
	public String getCurrentNode() {
		return currentNode;
	}
	public void setCurrentNode(String currentNode) {
		this.currentNode = currentNode;
	}
	public String getPk() {
		return pk;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setPk(String pk) {
		this.pk = pk;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
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
	
}
