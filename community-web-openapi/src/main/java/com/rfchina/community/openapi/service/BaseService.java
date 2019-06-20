package com.rfchina.community.openapi.service;

import com.rfchina.community.base.exception.WorkRunTimeException;

public class BaseService {

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
