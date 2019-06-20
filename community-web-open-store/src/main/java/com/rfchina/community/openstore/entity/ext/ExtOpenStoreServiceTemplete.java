package com.rfchina.community.openstore.entity.ext;

import com.rfchina.community.persistence.model.OpenStoreServiceDiscount;
import com.rfchina.community.persistence.model.OpenStoreServiceTemplete;

public class ExtOpenStoreServiceTemplete  extends OpenStoreServiceTemplete {

	private static final long serialVersionUID = 2L;
	private String title;
    private String png;
    private String description;
    private String merchantTitle;

	public String getMerchantTitle() {
		return merchantTitle;
	}

	public void setMerchantTitle(String merchantTitle) {
		this.merchantTitle = merchantTitle;
	}

	private OpenStoreServiceDiscount openStoreServiceDiscount;
    
	public OpenStoreServiceDiscount getOpenStoreServiceDiscount() {
		return openStoreServiceDiscount;
	}

	public void setOpenStoreServiceDiscount(OpenStoreServiceDiscount openStoreServiceDiscount) {
		this.openStoreServiceDiscount = openStoreServiceDiscount;
	}

	public String getPng() {
		return png;
	}

	public void setPng(String png) {
		this.png = png;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


}