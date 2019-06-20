package com.rfchina.community.openstore.entity.ext;

import com.rfchina.community.persistence.model.OpenXFSJStoreGood;

public class ExtXFSJGood extends OpenXFSJStoreGood {
	
	private ExtOpenStoreGood goodInfo;

	public ExtOpenStoreGood getGoodInfo() {
		return goodInfo;
	}

	public void setGoodInfo(ExtOpenStoreGood goodInfo) {
		this.goodInfo = goodInfo;
	}
	
}