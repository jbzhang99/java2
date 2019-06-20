package com.rfchina.community.open.bridge.entity;

import java.io.Serializable;

import com.rfchina.community.persistence.model.CommunityServiceCategory;

public class ExtCommunityServiceCategory extends CommunityServiceCategory implements Serializable {
    private String categoryTypeName;

	public String getCategoryTypeName() {
		return categoryTypeName;
	}

	public void setCategoryTypeName(String categoryTypeName) {
		this.categoryTypeName = categoryTypeName;
	}

}