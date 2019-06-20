package com.rfchina.community.openweb.entity;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.type.JdbcType;

import com.rfchina.community.persistence.model.OpenXFSJBusinessInfo;

public class ExtOpenXFSJBusinessInfo extends OpenXFSJBusinessInfo {
	private List<ExtCommunityResourceActivity> communityResourceList;
	private String businessType;
	private Integer communityId;
	private String actTitile;
	private String actAddress;
	private String actTime;
	private String actImg;
	private String actUrl;
	private Integer status;
	private Date createTime;
	private Long createUid;
	private Date beginTime;
	private Date endTime;

	private String areaName;
	private String communityName;
	
	private Integer userSignUpStatus; //报名支付状态
	private Integer activityStatus; //活动状态
	private String refuseContent;
	
	private String orderId;
	
	private Long signUpId;
	

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	
	public Long getSignUpId() {
		return signUpId;
	}

	public void setSignUpId(Long signUpId) {
		this.signUpId = signUpId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getUserSignUpStatus() {
		return userSignUpStatus;
	}

	public void setUserSignUpStatus(Integer userSignUpStatus) {
		this.userSignUpStatus = userSignUpStatus;
	}

	public String getRefuseContent() {
		return refuseContent;
	}

	public void setRefuseContent(String refuseContent) {
		this.refuseContent = refuseContent;
	}

	public Integer getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(Integer activityStatus) {
		this.activityStatus = activityStatus;
	}

	public Integer getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}

	public String getActTitile() {
		return actTitile;
	}

	public void setActTitile(String actTitile) {
		this.actTitile = actTitile;
	}

	public String getActAddress() {
		return actAddress;
	}

	public void setActAddress(String actAddress) {
		this.actAddress = actAddress;
	}

	public String getActTime() {
		return actTime;
	}

	public void setActTime(String actTime) {
		this.actTime = actTime;
	}

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

	public String getActImg() {
		return actImg;
	}

	public void setActImg(String actImg) {
		this.actImg = actImg;
	}

	public String getActUrl() {
		return actUrl;
	}

	public void setActUrl(String actUrl) {
		this.actUrl = actUrl;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getCreateUid() {
		return createUid;
	}

	public void setCreateUid(Long createUid) {
		this.createUid = createUid;
	}


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
