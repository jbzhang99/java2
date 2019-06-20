package com.rfchina.community.brothers.handler;

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
	public Result jsonErrorHandler(HttpServletRequest request, Exception e) throws Exception {
		if (e instanceof MethodArgumentTypeMismatchException) {
			return new Result<>(StatusCode.WORK_ERROR, ((MethodArgumentTypeMismatchException) e).getName() + "参数格式错误");
		} else if (e instanceof MissingServletRequestParameterException) {
			return new Result<>(StatusCode.WORK_ERROR,
					((MissingServletRequestParameterException) e).getParameterName() + "参数缺失!");
		} else if (e instanceof LoginRunTimeException) {
			return Result.create(((LoginRunTimeException) e).getCode(), e.getMessage());
		}
		if (e instanceof RoleRunTimeException) {
			return Result.create(((RoleRunTimeException) e).getCode(), e.getMessage());
		}
		if (e instanceof WorkRunTimeException) {
			logger.error("path:{},msg:{}", request.getPathInfo(), e.getMessage());
			return Result.create(((WorkRunTimeException) e).getCode(), e.getMessage());
		}
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		logger.error("Handle exception for [GlobalExceptionHandler]", e);
		return Result.create(StatusCode.SERVICE_ERROR.value(), e.getMessage(), sw.toString());
	}

}