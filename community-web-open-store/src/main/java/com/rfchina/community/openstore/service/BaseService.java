package com.rfchina.community.openstore.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.rfchina.community.base.exception.WorkRunTimeException;

public class BaseService{
	
	@Value("${auth.enabled:false}")
	private boolean authEnabled;

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public boolean isAuthEnabled() {
		return authEnabled;
	}

	public static void error(String msg) {
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
