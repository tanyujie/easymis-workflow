package org.easymis.workflow.app.entity.system;

import java.util.Date;

/**
 * 
 * @ClassName: LoginLog
 * @Description: TODO(用户登录日志)
 * @author lenovo-t
 * @date 2019年6月9日
 *
 */
public class LoginLog {
	private String loginLogId;
	private String creatorId;
	private String creator;

	private Date loginTime;// '登录时间',
	private String loginType;// '登录类型',
	private String ip;// 源IP地址',
	private String place;// 登录地点',
	private String deviceType;// 设备类型',
	private String kernel;// 终端内核',
	private String platform;// 平台',
	private String imei;// IMEI设备号',
	private String certifiedResult;// 认证结果',
	private String delegateUser;// 委托用户',

	public String getLoginLogId() {
		return loginLogId;
	}

	public void setLoginLogId(String loginLogId) {
		this.loginLogId = loginLogId;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getKernel() {
		return kernel;
	}

	public void setKernel(String kernel) {
		this.kernel = kernel;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getCertifiedResult() {
		return certifiedResult;
	}

	public void setCertifiedResult(String certifiedResult) {
		this.certifiedResult = certifiedResult;
	}

	public String getDelegateUser() {
		return delegateUser;
	}

	public void setDelegateUser(String delegateUser) {
		this.delegateUser = delegateUser;
	}

}
