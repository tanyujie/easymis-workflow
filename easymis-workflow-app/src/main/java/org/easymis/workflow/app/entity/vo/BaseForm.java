package org.easymis.workflow.app.entity.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.easymis.workflow.app.utils.DateUtil;


public abstract class BaseForm implements Serializable{
	// 申请日期
	private String requestDate = DateUtil.getTodayString();
	
	// 申请人id
	private String userId;
	
	// 申请的标题
	private String title;
	
	// 申请人名称
	private String userName;
	
	// 单据类型
	private String businessType;
	
	// 表单的域
	private List<FormField> fields = new ArrayList<FormField>();
	
	// 用于存放FormField对象
	private Map<String, FormField> fileMap = new HashMap<String, FormField>();
	
	// 请假类型
	public final static String VACATION = "vacation";	
	public final static String SALARY = "salary";	
	public final static String EXPENSE = "expense";
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public List<FormField> getFields() {
		return fields;
	}
	public void setFields(List<FormField> fields) {
		this.fields = fields;
	}
	public Map<String, FormField> getFileMap() {
		return fileMap;
	}
	public void setFileMap(Map<String, FormField> fileMap) {
		this.fileMap = fileMap;
	}
	protected FormField getFormField(String key, String text, String value) {
		if (fileMap.get(key) == null) {
			FormField field = new FormField(text, value);
			fileMap.put(key, field);
		}
		return fileMap.get(key);
	}	
}
