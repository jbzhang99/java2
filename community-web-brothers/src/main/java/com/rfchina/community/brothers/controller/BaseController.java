package com.rfchina.community.brothers.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rfchina.community.base.exception.WorkRunTimeException;
import com.rfchina.community.base.util.HttpUtil;

/**
 */
public abstract class BaseController {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpServletResponse response;

	protected void error(String msg) {
		throw new WorkRunTimeException(msg);
	}

	protected void validator(boolean fag, String msg) {
		if (fag) {
			error(msg);
		}
	}
}
