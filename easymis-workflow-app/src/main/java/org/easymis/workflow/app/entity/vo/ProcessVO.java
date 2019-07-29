package org.easymis.workflow.app.entity.vo;

/**
 * 流程值对象
 * 
 * @ClassName: ProcessVO
 * @Description: 流程值对象
 * @author lenovo-t
 * @date 2019年6月16日
 *
 */
public class ProcessVO {
	// 流程实例id
	private String id;

	// 申请标题
	private String title;

	// 申请日期
	private String requestDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

}
