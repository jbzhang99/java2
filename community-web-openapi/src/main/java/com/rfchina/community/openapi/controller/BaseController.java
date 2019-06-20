package com.rfchina.community.openapi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.rfchina.community.base.exception.WorkRunTimeException;
import com.rfchina.community.base.util.HttpUtil;
import com.rfchina.community.component.OperLogComponent;

/**
 */
public abstract class BaseController  {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpServletResponse response;

	@Autowired
	protected OperLogComponent operLogComponent;
	

	@Value("${platform.host}")
	private String host;

	protected String getIp2() {
		return HttpUtil.getIp2(request);
	}

	protected void error(String msg) {
		throw new WorkRunTimeException(msg);
	}

	protected void error(Exception e) {
		throw new RuntimeException(e);
	}
	
	protected void validator(boolean fag, String msg) {
		if (fag) {
			error(msg);
		}
	}
	
}
