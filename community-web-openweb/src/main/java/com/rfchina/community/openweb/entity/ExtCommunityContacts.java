package com.rfchina.community.openweb.entity;

import java.io.Serializable;

public class ExtCommunityContacts implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String communityContactsName;
	
	public String communityConstactsPhone;
	
	public String communtiyConstactsEmail;

	public String getCommunityContactsName() {
		return communityContactsName;
	}

	public void setCommunityContactsName(String communityContactsName) {
		this.communityContactsName = communityContactsName;
	}

	public String getCommunityConstactsPhone() {
		return communityConstactsPhone;
	}

	public void setCommunityConstactsPhone(String communityConstactsPhone) {
		this.communityConstactsPhone = communityConstactsPhone;
	}

	public String getCommuntiyConstactsEmail() {
		return communtiyConstactsEmail;
	}

	public void setCommuntiyConstactsEmail(String communtiyConstactsEmail) {
		this.communtiyConstactsEmail = communtiyConstactsEmail;
	}
}
