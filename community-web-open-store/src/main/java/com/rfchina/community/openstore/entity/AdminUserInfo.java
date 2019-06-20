package com.rfchina.community.openstore.entity;

import java.io.Serializable;

/**
 */
public class AdminUserInfo implements Serializable {

	private Long uid;

	private String email;

	
	public Long getUid() {
		return uid;
	}

	
	public void setUid(Long uid) {
		this.uid = uid;
	}

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	 
}
