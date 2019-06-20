package com.rfchina.community.openweb.handler;

import org.apache.shiro.authc.AuthenticationException;

public class TempTokenInvalidException extends AuthenticationException {
	int code;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public TempTokenInvalidException(String message) {
		super(message);
	}

	public TempTokenInvalidException(int code, String message) {
		super(message);
		this.code = code;
	}

}
