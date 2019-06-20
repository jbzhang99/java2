package com.rfchina.community.open.bridge.entity;

import java.io.Serializable;

import com.rfchina.community.persistence.model.OpenXFSJAreaConfig;

public class ExtOpenXFSJAreaConfig extends OpenXFSJAreaConfig implements Serializable {
	private String cityName;
	private String groupConfigName;
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getGroupConfigName() {
		return groupConfigName;
	}
	public void setGroupConfigName(String groupConfigName) {
		this.groupConfigName = groupConfigName;
	}
	
}