package org.easymis.workflow.app.utils;

import java.io.Serializable;

/**
 * API统一返回值类
 *
 */
public class RestfulMessage implements Serializable {

	private String msg;
	private String cause;
	private Integer code;
	private Object data;// 数据

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	// 成功，不返回具体数据
	public static RestfulMessage success() {
		RestfulMessage result = new RestfulMessage();
		result.setResultCode(ResultCode.SUCCESS);
		return result;
	}
	// 成功，不返回具体数据
	public static RestfulMessage success(String messgae) {
		RestfulMessage result = new RestfulMessage();
		result.setResultCode(ResultCode.SUCCESS);
		result.setMsg(messgae);
		return result;
	}
	// 成功，返回数据
	public static RestfulMessage success(Object data) {
		RestfulMessage result = new RestfulMessage();
		result.setResultCode(ResultCode.SUCCESS);
		result.setData(data);
		return result;
	}

	// 成功，返回数据
	public static RestfulMessage success(String message, Object data) {
		RestfulMessage restMessgae = new RestfulMessage();
		restMessgae.setCode(200);
		restMessgae.setMsg(message);
		restMessgae.setData(data);
		return restMessgae;
	}

	public static RestfulMessage failure(ResultCode resultCode) {
		RestfulMessage result = new RestfulMessage();
		result.setResultCode(resultCode);
		return result;
	}

	public static RestfulMessage failure(ResultCode resultCode, Object data) {
		RestfulMessage result = new RestfulMessage();
		result.setResultCode(resultCode);
		result.setData(data);
		return result;
	}

	public static RestfulMessage failure(String message, Object data) {
		RestfulMessage restMessgae = new RestfulMessage();
		restMessgae.setCode(500);
		restMessgae.setMsg(message);
		restMessgae.setData(data);
		return restMessgae;
	}
	public static RestfulMessage failure(String message) {
		RestfulMessage restMessgae = new RestfulMessage();
		restMessgae.setCode(500);
		restMessgae.setMsg(message);
		return restMessgae;
	}
	public void setResultCode(ResultCode code) {
		this.code = code.code();
		this.msg = code.message();
	}
}
