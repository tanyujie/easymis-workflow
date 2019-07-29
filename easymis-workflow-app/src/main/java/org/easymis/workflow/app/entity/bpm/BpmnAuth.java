package org.easymis.workflow.app.entity.bpm;

/**
 * 流程分管授权
 *
 */
public class BpmnAuth {
	private String authId;
	private String name;
	private String rightsOwnerList;
	private String rightsDefList;
	private String type;
	public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRightsOwnerList() {
		return rightsOwnerList;
	}
	public void setRightsOwnerList(String rightsOwnerList) {
		this.rightsOwnerList = rightsOwnerList;
	}
	public String getRightsDefList() {
		return rightsDefList;
	}
	public void setRightsDefList(String rightsDefList) {
		this.rightsDefList = rightsDefList;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
