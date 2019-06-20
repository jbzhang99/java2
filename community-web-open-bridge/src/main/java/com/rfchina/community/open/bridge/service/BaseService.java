package com.rfchina.community.open.bridge.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rfchina.community.base.exception.WorkRunTimeException;

public class BaseService {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
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
