package com.rfchina.community.openapi.service.ext;

public class PFLogin {

	String access_token;
	String refresh_token;
	Long expire_time;
	PFUser user;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public Long getExpire_time() {
		return expire_time;
	}

	public void setExpire_time(Long expire_time) {
		this.expire_time = expire_time;
	}

	public PFUser getUser() {
		return user;
	}

	public void setUser(PFUser user) {
		this.user = user;
	}
}
