package com.demoone.support.exception;

import com.demoone.support.sys.ErrCode;
import com.demoone.support.sys.OptResult;
import com.sun.corba.se.impl.io.TypeMismatchException;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

/**
 * @author yatao.zhang
 * @version 1.0
 * @since 2019/06/21 10:28
 */
@RestControllerAdvice
public class SellExceptionHandler {


	//运行时异常
	@ExceptionHandler(SellException.class)
	public OptResult runtimeExceptionHandler(SellException ex) {
		ex.printStackTrace();
		return new OptResult(ex.getMessage(),ex.getCode());
	}

	//运行时异常
	@ExceptionHandler(RuntimeException.class)
	public OptResult runtimeExceptionHandler(RuntimeException ex) {
		ex.printStackTrace();
		return OptResult.fail(ErrCode.ILLEGAL_PARAM);
	}

	//IO异常
	@ExceptionHandler(IOException.class)
	public OptResult iOExceptionHandler(IOException ex) {
		ex.printStackTrace();
		return new OptResult("IO异常",3004);
	}

	//未知方法异常
	@ExceptionHandler(NoSuchMethodException.class)
	public OptResult noSuchMethodExceptionHandler(NoSuchMethodException ex) {
		ex.printStackTrace();
		return new OptResult("未知方法异常",3005);
	}

	//400错误
	@ExceptionHandler({HttpMessageNotReadableException.class})
	public OptResult requestNotReadable(HttpMessageNotReadableException ex) {
		ex.printStackTrace();
		return OptResult.fail(ErrCode.ILLEGAL_PARAM);
	}

	//400错误
	@ExceptionHandler({TypeMismatchException.class})
	public OptResult requestTypeMismatch(TypeMismatchException ex) {
		ex.printStackTrace();
		return OptResult.fail(ErrCode.ILLEGAL_PARAM);
	}

	//400错误
	@ExceptionHandler({MissingServletRequestParameterException.class})
	public OptResult requestMissingServletRequest(MissingServletRequestParameterException ex) {
		ex.printStackTrace();
		return OptResult.fail(ErrCode.ILLEGAL_PARAM);
	}

	//405错误
	@ExceptionHandler({HttpRequestMethodNotSupportedException.class})
	public OptResult request405(HttpRequestMethodNotSupportedException ex) {
		ex.printStackTrace();
		return new OptResult("不允许使用该方法",3010);
	}

	//406错误
	@ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
	public OptResult request406(HttpMediaTypeNotAcceptableException ex) {
		ex.printStackTrace();
		return new OptResult("不接受",3011);
	}

	//500错误
	@ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
	public OptResult server500(RuntimeException ex) {
		ex.printStackTrace();
		return OptResult.fail(ErrCode.FAIL);
	}

	//栈溢出
	@ExceptionHandler({StackOverflowError.class})
	public OptResult requestStackOverflow(StackOverflowError ex) {
		ex.printStackTrace();
		return new OptResult("栈溢出",3013);
	}

	//其他错误
	@ExceptionHandler({Exception.class})
	public OptResult exception(Exception ex) {
		ex.printStackTrace();
		return OptResult.fail(ErrCode.FAIL);
	}

}
