package com.rfchina.community.openweb.entity;

import com.rfchina.community.persistence.model.Community;

public class ExtCommunity extends Community{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int provinceAreaId;
	
	private String provinceAreaName;
	
	private int cityAreaId;
	
	private String cityAreaName;
	
	private String areaName;

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public int getProvinceAreaId() {
		return provinceAreaId;
	}

	public void setProvinceAreaId(int provinceAreaId) {
		this.provinceAreaId = provinceAreaId;
	}

	public String getProvinceAreaName() {
		return provinceAreaName;
	}

	public void setProvinceAreaName(String provinceAreaName) {
		this.provinceAreaName = provinceAreaName;
	}

	public int getCityAreaId() {
		return cityAreaId;
	}

	public void setCityAreaId(int cityAreaId) {
		this.cityAreaId = cityAreaId;
	}

	public String getCityAreaName() {
		return cityAreaName;
	}

	public void setCityAreaName(String cityAreaName) {
		this.cityAreaName = cityAreaName;
	}
	
	
}
