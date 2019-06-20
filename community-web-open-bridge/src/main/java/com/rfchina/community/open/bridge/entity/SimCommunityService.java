package com.rfchina.community.open.bridge.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SimCommunityService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String title;

    private String png;

    private Integer status;

    private String description;

    private Date createTime;

    private double  recommendLevel; 	//推荐指数
    
    private Integer categoryId;	//分类id

    private String categoryName;	//分类名称
    
    private Integer selectStatus;	//选择状态

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public double getRecommendLevel() {
		return recommendLevel;
	}

	public void setRecommendLevel(double recommendLevel) {
		this.recommendLevel = recommendLevel;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getSelectStatus() {
		return selectStatus;
	}

	public void setSelectStatus(Integer selectStatus) {
		this.selectStatus = selectStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    

    
    
    
}
