package com.rfchina.community.openweb.entity;

import java.io.Serializable;

/**
 */
public class AdminUserInfo implements Serializable {
	private static final long serialVersionUID = 3984572966595619261L;
	private Long uid;

	private String email;

	private String userName;

	private String userToken;

	private String regProgress;

	private String mchId;

	private String remark;

	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getRegProgress() {
		return regProgress;
	}

	public void setRegProgress(String regProgress) {
		this.regProgress = regProgress;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUid() {
		return uid;
	}

	
	public void setUid(Long uid) {
		this.uid = uid;
	}

	
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "AdminUserInfo{" +
				"uid=" + uid +
				", email='" + email + '\'' +
				", userName='" + userName + '\'' +
				", userToken='" + userToken + '\'' +
				", regProgress='" + regProgress + '\'' +
				", mchId='" + mchId + '\'' +
				", remark='" + remark + '\'' +
				'}';
	}

	public void setEmail(String email) {
		this.email = email;
	}

	 
}
