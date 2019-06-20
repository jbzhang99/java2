package com.rfchina.community.openapi.service.ext;

public class PFUser implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int email_status;
	Long id;
	int status;

	public int getEmail_status() {
		return email_status;
	}

	public void setEmail_status(int email_status) {
		this.email_status = email_status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getMobile_status() {
		return mobile_status;
	}

	public void setMobile_status(int mobile_status) {
		this.mobile_status = mobile_status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	int mobile_status;
	String email;
	String account;
	String avatar;
	String mobile;
	String create_time;

}
