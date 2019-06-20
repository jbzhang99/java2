package com.rfchina.community.persistence.model.ext;

import com.rfchina.community.persistence.model.CommunityServiceRela;

public class ExtCommunityServiceRela extends CommunityServiceRela{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String areaName;

	private String communityName;
	private String downQrcodeUrl;

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	 

	public String getDownQrcodeUrl() {
		return downQrcodeUrl;
	}

	public void setDownQrcodeUrl(String downQrcodeUrl) {
		this.downQrcodeUrl = downQrcodeUrl;
	}
	
	
}
