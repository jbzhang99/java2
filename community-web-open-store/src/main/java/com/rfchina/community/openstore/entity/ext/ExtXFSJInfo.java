package com.rfchina.community.openstore.entity.ext;

import java.util.List;

import com.rfchina.community.persistence.model.OpenXFSJInfo;

public class ExtXFSJInfo extends OpenXFSJInfo {
	private String detail;

	private List<ExtXFSJShop> lifeShopList;

	private List<ExtXFSJShop> betterShopList;
	
	private String groupAreaName;
	
	private String communityName;
	
	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getGroupAreaName() {
		return groupAreaName;
	}

	public void setGroupAreaName(String groupAreaName) {
		this.groupAreaName = groupAreaName;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public List<ExtXFSJShop> getLifeShopList() {
		return lifeShopList;
	}

	public void setLifeShopList(List<ExtXFSJShop> lifeShopList) {
		this.lifeShopList = lifeShopList;
	}

	public List<ExtXFSJShop> getBetterShopList() {
		return betterShopList;
	}

	public void setBetterShopList(List<ExtXFSJShop> betterShopList) {
		this.betterShopList = betterShopList;
	}
	
}