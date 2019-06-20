package com.rfchina.community.base.exception;

import com.rfchina.community.base.StatusCode;

public class LoginRunTimeException extends CodeRunTimeException {
	public LoginRunTimeException(String message) {
		super(StatusCode.TOKEN_EXPIRED, message);
	}

	public LoginRunTimeException(int code, String message) {
		super(code, message);
	}

}
