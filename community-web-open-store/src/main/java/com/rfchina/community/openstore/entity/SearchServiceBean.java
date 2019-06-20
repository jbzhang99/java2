package com.rfchina.community.openstore.entity;

import java.math.BigDecimal;

import com.rfchina.community.persistence.model.OpenStoreServiceDiscount;

/**
 */

/**
 * @author:fukangwen
 * @Description: 搜索结果
 */
public class SearchServiceBean {

    private int serviceId;

    private String title;

    private int type;

    private int provideType;

    private String png;

    private int userRange;//'社区用户覆盖范围，1：社区认证用户及社区关注用户，2：社区认证用户',

    private String serviceDescription;//描述

    private int isNeedPropAddrBind;
    private int available4Click;
    private int serviceDisableReason;

    private Integer pageType;
    private OpenStoreServiceDiscount discount;
	private BigDecimal expressMoney;


    private Integer flagship = 0;

    public int getProvideType() {
        return provideType;
    }

    public void setProvideType(int provideType) {
        this.provideType = provideType;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIsNeedPropAddrBind() {
        return isNeedPropAddrBind;
    }

    public void setIsNeedPropAddrBind(int isNeedPropAddrBind) {
        this.isNeedPropAddrBind = isNeedPropAddrBind;
    }

    public int getAvailable4Click() {
        return available4Click;
    }

    public void setAvailable4Click(int available4Click) {
        this.available4Click = available4Click;
    }

    public int getServiceDisableReason() {
        return serviceDisableReason;
    }

    public void setServiceDisableReason(int serviceDisableReason) {
        this.serviceDisableReason = serviceDisableReason;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPng() {
        return png;
    }

    public void setPng(String png) {
        this.png = png;
    }

    public int getUserRange() {
        return userRange;
    }

    public void setUserRange(int userRange) {
        this.userRange = userRange;
    }

    public Integer getPageType() {
        return pageType;
    }

    public void setPageType(Integer pageType) {
        this.pageType = pageType;
    }

	public OpenStoreServiceDiscount getDiscount() {
		return discount;
	}

	public void setDiscount(OpenStoreServiceDiscount discount) {
		this.discount = discount;
	}

	public BigDecimal getExpressMoney() {
		return expressMoney;
	}

	public void setExpressMoney(BigDecimal expressMoney) {
		this.expressMoney = expressMoney;
	}

    public Integer getFlagship() {
        return flagship;
    }

    public void setFlagship(Integer flagship) {
        this.flagship = flagship;
    }
}
