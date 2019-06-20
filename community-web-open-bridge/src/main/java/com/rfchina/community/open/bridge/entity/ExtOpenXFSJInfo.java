package com.rfchina.community.open.bridge.entity;

import com.rfchina.community.persistence.model.OpenXFSJInfo;

public class ExtOpenXFSJInfo extends OpenXFSJInfo {

	private String communityName;
	private Integer amount;//可报名人数
	private Integer signUpStatus;//报名状态 1可报名，2不可报名
	
	private String groupAreaName;
	
	private String categoryName;
	
	private int cityId;

	private String detail;

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getGroupAreaName() {
		return groupAreaName;
	}

	public void setGroupAreaName(String groupAreaName) {
		this.groupAreaName = groupAreaName;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getSignUpStatus() {
		return signUpStatus;
	}

	public void setSignUpStatus(Integer signUpStatus) {
		this.signUpStatus = signUpStatus;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
}
