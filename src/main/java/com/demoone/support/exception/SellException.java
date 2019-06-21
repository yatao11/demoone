package com.demoone.support.exception;

import com.demoone.support.sys.ErrCode;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yatao.zhang
 * @version 1.0
 * @since 2019/06/21 10:20
 */

@Data
@AllArgsConstructor
public class SellException extends RuntimeException{

	private Integer code;

	private String message;

	public SellException(ErrCode errCode){
		this.code = errCode.getCode();
		this.message = errCode.getMessage();
	}
}
