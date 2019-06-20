package com.rfchina.community.openstore.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserGroupDetail implements Serializable {
    private Long id;

    private Long userId;

	private String userName;

	private String picUrl;

	private int groupMasterStatus;

	private BigDecimal groupPrice;

	private Date payTime;

	private int meStatus;

	public int getMeStatus() {
		return meStatus;
	}

	public void setMeStatus(int meStatus) {
		this.meStatus = meStatus;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public BigDecimal getGroupPrice() {
		return groupPrice;
	}

	public void setGroupPrice(BigDecimal groupPrice) {
		this.groupPrice = groupPrice;
	}

	private Date stopTime;

	private Integer usableNum;

	public Integer getUsableNum() {
		return usableNum;
	}

	public void setUsableNum(Integer usableNum) {
		this.usableNum = usableNum;
	}

	public Date getStopTime() {
		return stopTime;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public int getGroupMasterStatus() {
		return groupMasterStatus;
	}

	public void setGroupMasterStatus(int groupMasterStatus) {
		this.groupMasterStatus = groupMasterStatus;
	}
}