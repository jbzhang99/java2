package com.rfchina.community.openstore.entity.ext;

import java.util.List;

import com.rfchina.community.persistence.model.OpenXFSJStore;

public class ExtXFSJShop extends OpenXFSJStore{
	private ExtOpenStoreServiceTemplete templetInfo;
	
	private List<ExtXFSJGood> goodList;
	
	public ExtOpenStoreServiceTemplete getTempletInfo() {
		return templetInfo;
	}

	public void setTempletInfo(ExtOpenStoreServiceTemplete templetInfo) {
		this.templetInfo = templetInfo;
	}

	public List<ExtXFSJGood> getGoodList() {
		return goodList;
	}

	public void setGoodList(List<ExtXFSJGood> goodList) {
		this.goodList = goodList;
	}
    
}