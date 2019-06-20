package com.rfchina.community.openstore.entity.ext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.rfchina.community.persistence.model.Community;

public class ExtXFSJCommunity extends Community implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String distance;

    private List<String> services = new ArrayList<>();

    private Integer userAttention = 0;

    private Long attentionCount = 0L;

    private String areaName;

    private Integer masterUser;

    private String introUrl;
    
    private long serviceCount;
    
    private Integer isLastUserOpen = 0;
    
    private Integer isAuthentication = 0;
    
    

	public Integer getIsLastUserOpen() {
		return isLastUserOpen;
	}

	public void setIsLastUserOpen(Integer isLastUserOpen) {
		this.isLastUserOpen = isLastUserOpen;
	}

	public Integer getIsAuthentication() {
		return isAuthentication;
	}

	public void setIsAuthentication(Integer isAuthentication) {
		this.isAuthentication = isAuthentication;
	}

	public long getServiceCount() {
		return serviceCount;
	}

	public void setServiceCount(long serviceCount) {
		this.serviceCount = serviceCount;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public List<String> getServices() {
		return services;
	}

	public void setServices(List<String> services) {
		this.services = services;
	}

	public Integer getUserAttention() {
		return userAttention;
	}

	public void setUserAttention(Integer userAttention) {
		this.userAttention = userAttention;
	}

	public Long getAttentionCount() {
		return attentionCount;
	}

	public void setAttentionCount(Long attentionCount) {
		this.attentionCount = attentionCount;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getMasterUser() {
		return masterUser;
	}

	public void setMasterUser(Integer masterUser) {
		this.masterUser = masterUser;
	}

	public String getIntroUrl() {
		return introUrl;
	}

	public void setIntroUrl(String introUrl) {
		this.introUrl = introUrl;
	}
}
