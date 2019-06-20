package com.rfchina.community.base.exception;

import com.rfchina.community.base.StatusCode;

public class RoleRunTimeException extends CodeRunTimeException {

	public RoleRunTimeException(String message) {
		super(StatusCode.ROLE_NOT, message);
	}

}
