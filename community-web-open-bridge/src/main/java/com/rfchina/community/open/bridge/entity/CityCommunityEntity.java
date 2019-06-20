package com.rfchina.community.open.bridge.entity;

import java.util.ArrayList;
import java.util.List;

import com.rfchina.community.persistence.model.Community;

public class CityCommunityEntity {
	int id;
	String cityName;
	List<Community> list = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Community> getList() {
		return list;
	}

	public void setList(List<Community> list) {
		this.list = list;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
