package com.rfchina.community.openapi.entity;

public class AccountData {
	String accountId;

	String accountMchid;

	public String getAccountId() {
		return accountId;
	}

	public AccountData(String accountId, String accountMchid) {
		super();
		this.accountId = accountId;
		this.accountMchid = accountMchid;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountMchid() {
		return accountMchid;
	}

	public void setAccountMchid(String accountMchid) {
		this.accountMchid = accountMchid;
	}
}
