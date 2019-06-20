package com.rfchina.community.openstore.handler;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.rfchina.community.base.Result;
import com.rfchina.community.base.StatusCode;
import com.rfchina.community.base.exception.LoginRunTimeException;
import com.rfchina.community.base.exception.RoleRunTimeException;
import com.rfchina.community.base.exception.WorkRunTimeException;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result<?> jsonErrorHandler(HttpServletRequest request, Exception e) {
		if (e instanceof MethodArgumentTypeMismatchException) {
			return new Result<>(StatusCode.INVALID_PARAM_FORMAT.value(),
					((MethodArgumentTypeMismatchException) e).getName() + StatusCode.INVALID_PARAM_FORMAT.name());
		} else if (e instanceof MissingServletRequestParameterException) {
			return new Result<>(StatusCode.PARAM_REQUIRED.value(),
					((MissingServletRequestParameterException) e).getParameterName() + StatusCode.PARAM_REQUIRED.name());
		} else if (e instanceof LoginRunTimeException) {
			return Result.create(((LoginRunTimeException) e).getCode(), e.getMessage());
		} else if (e instanceof RoleRunTimeException) {
			return Result.create(((RoleRunTimeException) e).getCode(), e.getMessage());
		} else if (e instanceof WorkRunTimeException) {
			return Result.create(((WorkRunTimeException) e).getCode(), e.getMessage());
		} 
		logger.error(e.getMessage(), e);
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return Result.create(StatusCode.SERVICE_ERROR.value(), e.getMessage(), sw.toString());
	}
}