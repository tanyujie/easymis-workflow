package org.easymis.workflow.app.entity.bpm;

import java.util.Date;

import org.easymis.workflow.app.entity.vo.VO;

public class BpmFormTemplateVO extends VO {
	private String templateId;
	private String orgId;
	private String templateName;
	private String categoryId;
	private Date createTime;
	private String macroTemplateAlias;
	private String html;
	private String template_depict;
	private Boolean can_edit;
	private String alias;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getMacroTemplateAlias() {
		return macroTemplateAlias;
	}

	public void setMacroTemplateAlias(String macroTemplateAlias) {
		this.macroTemplateAlias = macroTemplateAlias;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getTemplate_depict() {
		return template_depict;
	}

	public void setTemplate_depict(String template_depict) {
		this.template_depict = template_depict;
	}

	public Boolean getCan_edit() {
		return can_edit;
	}

	public void setCan_edit(Boolean can_edit) {
		this.can_edit = can_edit;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

}
