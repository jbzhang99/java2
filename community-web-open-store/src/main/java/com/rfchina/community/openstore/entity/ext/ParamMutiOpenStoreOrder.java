package com.rfchina.community.openstore.entity.ext;

import java.math.BigDecimal;
import java.util.List;

public class ParamMutiOpenStoreOrder {
    private long communityId;//社区id

    private List<Integer> shoppingCartIdList; //购物车进来需要传递购物车的id进来

    private String addrDetail;

    private Long addrInfoId;

    private String userName;

    private String mobile;

    private BigDecimal mutiTotal;

    private List<MutiOrderCreateParam> mutiOrderCreateParam;

    private long uid;

    private long groupDataId;

    private int groupStatus;

    private String clientType;

    public long getGroupDataId() {
        return groupDataId;
    }

    public void setGroupDataId(long groupDataId) {
        this.groupDataId = groupDataId;
    }

    public int getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(int groupStatus) {
        this.groupStatus = groupStatus;
    }

    public Long getAddrInfoId() {
        return addrInfoId;
    }

    public void setAddrInfoId(Long addrInfoId) {
        this.addrInfoId = addrInfoId;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public BigDecimal getMutiTotal() {
        return mutiTotal;
    }

    public void setMutiTotal(BigDecimal mutiTotal) {
        this.mutiTotal = mutiTotal;
    }


    public long getCommunityId() {
        return communityId;
    }


    public void setCommunityId(long communityId) {
        this.communityId = communityId;
    }


    public List<Integer> getShoppingCartIdList() {
        return shoppingCartIdList;
    }


    public void setShoppingCartIdList(List<Integer> shoppingCartIdList) {
        this.shoppingCartIdList = shoppingCartIdList;
    }


    public String getAddrDetail() {
        return addrDetail;
    }


    public void setAddrDetail(String addrDetail) {
        this.addrDetail = addrDetail;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getMobile() {
        return mobile;
    }


    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public List<MutiOrderCreateParam> getMutiOrderCreateParam() {
        return mutiOrderCreateParam;
    }


    public void setMutiOrderCreateParam(List<MutiOrderCreateParam> mutiOrderCreateParam) {
        this.mutiOrderCreateParam = mutiOrderCreateParam;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    @Override
    public String toString() {
        return "ParamMutiOpenStoreOrder{" +
                "communityId=" + communityId +
                ", shoppingCartIdList=" + shoppingCartIdList +
                ", addrDetail='" + addrDetail + '\'' +
                ", addrInfoId=" + addrInfoId +
                ", userName='" + userName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", mutiTotal=" + mutiTotal +
                ", mutiOrderCreateParam=" + mutiOrderCreateParam +
                ", uid=" + uid +
                ", groupDataId=" + groupDataId +
                ", groupStatus=" + groupStatus +
                ", clientType=" + clientType +
                '}';
    }
}
