package com.rfchina.community.openstore.entity.ext;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.OpenStoreGoodGroupInfo;
import com.rfchina.community.persistence.model.ext.ExtUserComment;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ExtOpenStoreGood  implements Serializable {
    private Integer id;

    private Integer serviceId;

    private String code;

    private String name;

    private String shortDetail;

    private BigDecimal prePrice;

    private BigDecimal price;

    private Integer status;

    private String picUrl;

    private String detail;
    
    private Date createTime;
    
    private int stock;
    
    private Integer premiumNum;
    
    private BigDecimal premiumPrice;
    
    private int openPoint;

    private Long commentTotalNum;

    private ExtUserComment firstGoodsComment;

    private Integer virtualSaleAmount;

    private Integer totalSaleAmount;

    private Integer isUseMainPic;

    private String showUrl;

    private String remark;

    private int limitTimes;

    //团购
    private int groupStatus;

    //团购价
    private BigDecimal groupPrice;

    //团购库存
    private int groupStock;

    //团购单次购买数量
    private int groupLimitTimes;

    private OpenStoreGoodGroupInfo unStartGroupInfo;

    private String serviceName;

    public OpenStoreGoodGroupInfo getUnStartGroupInfo() {
        return unStartGroupInfo;
    }

    public void setUnStartGroupInfo(OpenStoreGoodGroupInfo unStartGroupInfo) {
        this.unStartGroupInfo = unStartGroupInfo;
    }

    public int getLimitTimes() {
        return limitTimes;
    }

    public void setLimitTimes(int limitTimes) {
        this.limitTimes = limitTimes;
    }

    public int getGroupStock() {
        return groupStock;
    }

    public void setGroupStock(int groupStock) {
        this.groupStock = groupStock;
    }

    public int getGroupLimitTimes() {
        return groupLimitTimes;
    }

    public void setGroupLimitTimes(int groupLimitTimes) {
        this.groupLimitTimes = groupLimitTimes;
    }

    private ExtOpenStoreGoodGroupInfo groupInfo;

    public ExtOpenStoreGoodGroupInfo getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(ExtOpenStoreGoodGroupInfo groupInfo) {
        this.groupInfo = groupInfo;
    }

    public int getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(int groupStatus) {
        this.groupStatus = groupStatus;
    }

    public BigDecimal getGroupPrice() {
        return groupPrice;
    }

    public void setGroupPrice(BigDecimal groupPrice) {
        this.groupPrice = groupPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDetail() {
        return shortDetail;
    }

    public void setShortDetail(String shortDetail) {
        this.shortDetail = shortDetail;
    }

    public BigDecimal getPrePrice() {
        return prePrice;
    }

    public void setPrePrice(BigDecimal prePrice) {
        this.prePrice = prePrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Integer getPremiumNum() {
        return premiumNum;
    }

    public void setPremiumNum(Integer premiumNum) {
        this.premiumNum = premiumNum;
    }

    public BigDecimal getPremiumPrice() {
        return premiumPrice;
    }

    public void setPremiumPrice(BigDecimal premiumPrice) {
        this.premiumPrice = premiumPrice;
    }

    public int getOpenPoint() {
        return openPoint;
    }

    public void setOpenPoint(int openPoint) {
        this.openPoint = openPoint;
    }

    public Long getCommentTotalNum() {
        return commentTotalNum;
    }

    public void setCommentTotalNum(Long commentTotalNum) {
        this.commentTotalNum = commentTotalNum;
    }

    public ExtUserComment getFirstGoodsComment() {
        return firstGoodsComment;
    }

    public void setFirstGoodsComment(ExtUserComment firstGoodsComment) {
        this.firstGoodsComment = firstGoodsComment;
    }

    public Integer getVirtualSaleAmount() {
        return virtualSaleAmount;
    }


    public void setVirtualSaleAmount(Integer virtualSaleAmount) {
        this.virtualSaleAmount = virtualSaleAmount;
    }

    public Integer getTotalSaleAmount() {
        return totalSaleAmount;
    }

    public void setTotalSaleAmount(Integer totalSaleAmount) {
        this.totalSaleAmount = totalSaleAmount;
    }

    public Integer getIsUseMainPic() {
        return isUseMainPic;
    }

    public void setIsUseMainPic(Integer isUseMainPic) {
        this.isUseMainPic = isUseMainPic;
    }

    public String getShowUrl() {
        return showUrl;
    }

    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", serviceId=").append(serviceId);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", shortDetail=").append(shortDetail);
        sb.append(", prePrice=").append(prePrice);
        sb.append(", price=").append(price);
        sb.append(", status=").append(status);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", commentTotalNum=").append(commentTotalNum);
        sb.append(", firstGoodsComment=").append(JSONObject.toJSONString(firstGoodsComment));
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ExtOpenStoreGood other = (ExtOpenStoreGood) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getShortDetail() == null ? other.getShortDetail() == null : this.getShortDetail().equals(other.getShortDetail()))
            && (this.getPrePrice() == null ? other.getPrePrice() == null : this.getPrePrice().equals(other.getPrePrice()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPicUrl() == null ? other.getPicUrl() == null : this.getPicUrl().equals(other.getPicUrl()))
            && (this.getCommentTotalNum() == null ? other.getCommentTotalNum() == null : this.getCommentTotalNum().equals(other.getCommentTotalNum()))
            && (this.getFirstGoodsComment() == null ? other.getFirstGoodsComment() == null : this.getFirstGoodsComment().equals(other.getFirstGoodsComment()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getShortDetail() == null) ? 0 : getShortDetail().hashCode());
        result = prime * result + ((getPrePrice() == null) ? 0 : getPrePrice().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPicUrl() == null) ? 0 : getPicUrl().hashCode());
        result = prime * result + ((getCommentTotalNum() == null) ? 0 : getCommentTotalNum().hashCode());
        result = prime * result + ((getFirstGoodsComment() == null) ? 0 : getFirstGoodsComment().hashCode());
        return result;
    }

}