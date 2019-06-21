package com.demoone.support.sys;

/**
 * @author yatao.zhang
 * @version 1.0
 * @since 2019/06/21 09:28
 */
public enum  ErrCode {

	SUCCESS(0,"请求成功"),

	FAIL(9999,"请求失败"),

	NO_DATA(1000,"无数据"),

	ILLEGAL_PARAM(2000,"参数不合法");

	private Integer code;

	private String message;


	ErrCode(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
