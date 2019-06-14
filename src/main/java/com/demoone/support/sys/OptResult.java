package com.demoone.support.sys;

import lombok.Data;

/**
 * @author yatao.zhang
 * @version 1.0
 * @since 2019/06/14 10:11
 */
@Data
public class OptResult<T> {

	/**
	 * 数据结果
	 */
	private T data;

	/**
	 * 是否查询成功
	 */
	private boolean success;
	/**
	 * 回馈信息
	 */
	private String msg;

	/**
	 *错误代码
	 */
	private String errorCode;

	public static OptResult success(String message) {
		OptResult result = new OptResult();
		result.setSuccess(true);
		result.setData(message);
		return result;
	}

	public static OptResult success() {
		return success(null);
	}
	public static OptResult fail(String message) {
		OptResult result = new OptResult();
		result.setSuccess(false);
		result.setErrorCode(message);
		return result;
	}
	public static OptResult fail() {
		return fail(null);
	}
}
