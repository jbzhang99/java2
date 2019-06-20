package com.rfchina.community.openweb.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.rfchina.community.service.openser.entity.ExtVerifyCardVO;
import com.rfchina.community.service.openser.entity.OpenStoreGoodOrderRelVO;

public class ExtOpenStoreVerifyCard  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private BigDecimal totalAmount;
    private String outTradeNo;
	private List<OpenStoreGoodOrderRelVO> goodList;
	
	private ExtVerifyCardVO extVerifyCardVO;
	
	public ExtVerifyCardVO getExtVerifyCardVO() {
		return extVerifyCardVO;
	}

	public void setExtVerifyCardVO(ExtVerifyCardVO extVerifyCardVO) {
		this.extVerifyCardVO = extVerifyCardVO;
	}

	public List<OpenStoreGoodOrderRelVO> getGoodList() {
		return goodList;
	}

	public void setGoodList(List<OpenStoreGoodOrderRelVO> goodList) {
		this.goodList = goodList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	
	

}