package com.rfchina.community.openweb.entity;

import java.io.Serializable;

import com.rfchina.community.persistence.model.OpenStoreServiceTemplete;

public class ExtOpenStoreServiceTemplete  extends OpenStoreServiceTemplete implements Serializable {

    private String title;

    private String templeteName;
    
	public String getTempleteName() {
		return templeteName;
	}

	public void setTempleteName(String templeteName) {
		this.templeteName = templeteName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


}