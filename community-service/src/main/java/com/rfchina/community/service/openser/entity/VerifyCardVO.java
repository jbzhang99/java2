package com.rfchina.community.service.openser.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class VerifyCardVO implements Serializable {
    private Long id;

    private String goodName;
    
    private String goodCode;

    private String code;
    
    private Integer orderId;

    private Integer verifyStatus;
    
    private Date verifyTime;
    
    private Integer goodOrderRelId;
    
    private Long uid;
    
    private BigDecimal singleScalePrice;
    
    public BigDecimal getSingleScalePrice() {
		return singleScalePrice;
	}

	public void setSingleScalePrice(BigDecimal singleScalePrice) {
		this.singleScalePrice = singleScalePrice;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Integer getGoodOrderRelId() {
		return goodOrderRelId;
	}

	public void setGoodOrderRelId(Integer goodOrderRelId) {
		this.goodOrderRelId = goodOrderRelId;
	}

	public String getGoodCode() {
		return goodCode;
	}

	public void setGoodCode(String goodCode) {
		this.goodCode = goodCode;
	}

	public Date getVerifyTime() {
		return verifyTime;
	}

	public void setVerifyTime(Date verifyTime) {
		this.verifyTime = verifyTime;
	}

	private static final long serialVersionUID = 1L;

    
    public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

}