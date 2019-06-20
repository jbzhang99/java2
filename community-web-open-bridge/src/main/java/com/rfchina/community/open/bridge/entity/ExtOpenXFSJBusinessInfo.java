package com.rfchina.community.open.bridge.entity;

import java.util.List;

import com.rfchina.community.persistence.model.CommunityResource;
import com.rfchina.community.persistence.model.OpenXFSJBusinessInfo;

public class ExtOpenXFSJBusinessInfo extends OpenXFSJBusinessInfo {
	private List<ExtCommunityResourceActivity> communityResourceList;

	private String businessType;

	public List<ExtCommunityResourceActivity> getCommunityResourceList() {
		return communityResourceList;
	}

	public void setCommunityResourceList(List<ExtCommunityResourceActivity> communityResourceList) {
		this.communityResourceList = communityResourceList;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	
}
