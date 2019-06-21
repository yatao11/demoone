package com.demoone.support.sys;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yatao.zhang
 * @version 1.0
 * @since 2019/06/14 10:11
 */
@Data
@NoArgsConstructor
public class OptResult<T> {

	@ApiModelProperty("数据结果")
	private T data;

	@ApiModelProperty("回馈信息")
	private String msg;

	@ApiModelProperty("错误代码")
	private Integer code;

	public OptResult(String msg,Integer code){
		this.msg = msg;
		this.code = code;
	}

	public static OptResult success(Object data) {
		OptResult result =setRequestCode(ErrCode.SUCCESS);
		result.setData(data);
		return result;
	}

	public static OptResult success() {
		return success(null);
	}

	public static OptResult setRequestCode(ErrCode errCode){
		OptResult result = new OptResult();
		result.setCode(errCode.getCode());
		result.setMsg(errCode.getMessage());
		return result;
	}


	public static OptResult fail(ErrCode errCode) {
		if (errCode==null){
			errCode = ErrCode.FAIL;
		}
		return setRequestCode(errCode);
	}

	public static OptResult fail() {
		return fail(null);
	}
}
