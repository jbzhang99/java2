package com.rfchina.community.openstore.entity.ext;

import java.math.BigDecimal;
import java.util.List;

import com.rfchina.community.persistence.model.OpenStoreServiceDiscount;

public class ExtMutiStoreShoppingCart implements Comparable<ExtMutiStoreShoppingCart>{
	private int serviceId;
	private String title;
	private List<ExtOpenStoreShoppingCart> cartList;
	private OpenStoreServiceDiscount openStoreServiceDiscount;
	private int isRelate;
	private BigDecimal expressMoney;
	
	public BigDecimal getExpressMoney() {
		return expressMoney;
	}
	public void setExpressMoney(BigDecimal expressMoney) {
		this.expressMoney = expressMoney;
	}
	public int getIsRelate() {
		return isRelate;
	}
	public void setIsRelate(int isRelate) {
		this.isRelate = isRelate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public OpenStoreServiceDiscount getOpenStoreServiceDiscount() {
		return openStoreServiceDiscount;
	}
	public void setOpenStoreServiceDiscount(OpenStoreServiceDiscount openStoreServiceDiscount) {
		this.openStoreServiceDiscount = openStoreServiceDiscount;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public List<ExtOpenStoreShoppingCart> getCartList() {
		return cartList;
	}
	public void setCartList(List<ExtOpenStoreShoppingCart> cartList) {
		this.cartList = cartList;
	}
	
	
	@Override
	public String toString() {
		return "ExtMutiStoreShoppingCart [serviceId=" + serviceId + ", title=" + title + ", cartList=" + cartList
				+ ", openStoreServiceDiscount=" + openStoreServiceDiscount + ", isRelate=" + isRelate + "]";
	}
	@Override  
    public int compareTo(ExtMutiStoreShoppingCart o) {  
        int i = o.getIsRelate()-this.getIsRelate();//先按照是否关联
        if(i == 0){  
            return this.getServiceId() - o.getServiceId();//服务id
        }  
        return i;  
    }

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
