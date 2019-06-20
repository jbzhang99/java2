package com.rfchina.community.base.exception;

import com.rfchina.community.base.StatusCode;

public class WorkRunTimeException extends CodeRunTimeException {

	public WorkRunTimeException(String message) {
		super(StatusCode.WORK_ERROR, message);
	}

	public WorkRunTimeException(int code, String message) {
		super(code, message);
	}

}
