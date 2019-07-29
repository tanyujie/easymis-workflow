package org.easymis.workflow.app.entity.vo;

import java.util.Date;

import org.easymis.workflow.app.entity.bpm.BpmDefineXmlPo;

public class BpmnDefineVO extends VO {
	private String id;
	private String name;
	private String createBy;
	private Date createTime;
	private Date updateTime;
	private String defId;
	private String defKey;
	private String status;

	private String testStatus;
	private String bpmnDefId;
	private String bpmnDeployId;
	private String version;
	private String mainDefId;
	private String isMain;
	private BpmDefineXmlPo bpmDefineXmlPo;
	private String designer;
	private String sn;
	private Boolean favorites;
	private Boolean hasGuide;
	private Boolean main;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getDefId() {
		return defId;
	}

	public void setDefId(String defId) {
		this.defId = defId;
	}

	public String getDefKey() {
		return defKey;
	}

	public void setDefKey(String defKey) {
		this.defKey = defKey;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}

	public String getBpmnDefId() {
		return bpmnDefId;
	}

	public void setBpmnDefId(String bpmnDefId) {
		this.bpmnDefId = bpmnDefId;
	}

	public String getBpmnDeployId() {
		return bpmnDeployId;
	}

	public void setBpmnDeployId(String bpmnDeployId) {
		this.bpmnDeployId = bpmnDeployId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getMainDefId() {
		return mainDefId;
	}

	public void setMainDefId(String mainDefId) {
		this.mainDefId = mainDefId;
	}

	public String getIsMain() {
		return isMain;
	}

	public void setIsMain(String isMain) {
		this.isMain = isMain;
	}

	public BpmDefineXmlPo getBpmDefineXmlPo() {
		return bpmDefineXmlPo;
	}

	public void setBpmDefineXmlPo(BpmDefineXmlPo bpmDefineXmlPo) {
		this.bpmDefineXmlPo = bpmDefineXmlPo;
	}

	public String getDesigner() {
		return designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Boolean getFavorites() {
		return favorites;
	}

	public void setFavorites(Boolean favorites) {
		this.favorites = favorites;
	}

	public Boolean getHasGuide() {
		return hasGuide;
	}

	public void setHasGuide(Boolean hasGuide) {
		this.hasGuide = hasGuide;
	}

	public Boolean getMain() {
		return main;
	}

	public void setMain(Boolean main) {
		this.main = main;
	}

}
