package com.rfchina.community.service.openser.entity;

import java.io.Serializable;
import java.util.List;

import com.rfchina.community.persistence.model.OpenStoreGoodOrderRel;

public class OpenStoreGoodOrderRelVO extends OpenStoreGoodOrderRel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<VerifyCardVO> verifyCardVOList;

	public List<VerifyCardVO> getVerifyCardVOList() {
		return verifyCardVOList;
	}

	public void setVerifyCardVOList(List<VerifyCardVO> verifyCardVOList) {
		this.verifyCardVOList = verifyCardVOList;
	}
	
	
}