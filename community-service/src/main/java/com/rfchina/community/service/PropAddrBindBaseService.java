package com.rfchina.community.service;

import com.google.common.primitives.Ints;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.util.AddrUtils;
import com.rfchina.community.component.PropAddrBindComponent;
import com.rfchina.community.entity.PropAddrBindRoom;
import com.rfchina.community.entity.PropAddrCertRoom;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.mapper.ext.ExtMasterInfoGlobalMapper;
import com.rfchina.community.persistence.mapper.ext.ExtPropAddrBindMapper;
import com.rfchina.community.persistence.model.MasterChild;
import com.rfchina.community.persistence.model.MasterChildExample;
import com.rfchina.community.persistence.model.MasterInfo;
import com.rfchina.community.persistence.model.MasterInfoExample;
import com.rfchina.community.persistence.model.ext.MasterInfoExt;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


/**
 */
public abstract class PropAddrBindBaseService {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected ExtMasterInfoGlobalMapper extMasterInfoMapper;

    @Autowired
    protected PropAddrBindMapper propAddrBindMapper;

    @Autowired
    protected PropAddrUnbindMapper propAddrUnbindMapper;

    @Autowired
    protected ExtPropAddrBindMapper extPropAddrBindMapper;

    @Autowired
    protected MasterInfoMapper masterInfoMapper;

    @Autowired
    protected MasterChildMapper masterChildMapper;

    @Autowired
    protected PropAddrBindComponent propAddrBindComponent;

    @Autowired
    protected UserInfoMapper userInfoMapper;

    protected Integer[] communityIdStrToIntArray(String communityIds) {
        if(StringUtils.isBlank(communityIds)) {
            return new Integer[0];
        }
        String[] communityIdStrArray = communityIds.split(",");
        Integer[] communityIdArray = new Integer[communityIdStrArray.length];
        int j = 0;
        for(String communityIdStr : communityIdStrArray) {
            Integer communityId = Ints.tryParse(communityIdStr);
            if(null != communityId) {
                communityIdArray[j++] = communityId;
            }
        }
        return communityIdArray;
    }

    protected PropAddrCertRoom toPropAddrCertRoom(MasterInfoExt infoExt, Integer type, boolean isBind, Long houseId) {
        PropAddrCertRoom item = new PropAddrCertRoom();
        item.setId(infoExt.getId());
        String communityName = StringUtils.defaultIfBlank(infoExt.getCommunityName(), "");
        String loudong = StringUtils.defaultIfBlank(infoExt.getLoudong(), "");
        String floor =  StringUtils.defaultIfBlank(infoExt.getFloor(), "");
        String room =  StringUtils.defaultIfBlank(infoExt.getRoom(), "");
        String roomName = AddrUtils.create(communityName, loudong, floor, room);
        item.setName(roomName);
        item.setType(type);
        item.setBindFlag(isBind? Constant.YesOrNo.YES: Constant.YesOrNo.NO);
        item.setHouseId(houseId);
        item.setAddress("");
        return item;
    }

    protected PropAddrBindRoom toPropAddrBindRoom(MasterInfoExt infoExt) {
        PropAddrBindRoom item = new PropAddrBindRoom();
        item.setId(infoExt.getId());
        String communityName = StringUtils.defaultIfBlank(infoExt.getCommunityName(), "");
        String loudong = StringUtils.defaultIfBlank(infoExt.getLoudong(), "");
        String floor =  StringUtils.defaultIfBlank(infoExt.getFloor(), "");
        String room =  StringUtils.defaultIfBlank(infoExt.getRoom(), "");
        String roomName = AddrUtils.create(communityName, loudong, floor, room);
        item.setName(roomName);
        item.setAddress("");
        Integer type = Optional.ofNullable(infoExt).map(MasterInfoExt::getType).map((i) -> {
            if(Constant.MasterInfo.Type.PARKING.equals(i)) {
                return Constant.PaymentOrder.PARKING;
            } else {
                return Constant.PaymentOrder.ROOM;
            }
        }).orElse(Constant.PaymentOrder.ROOM);
        item.setType(type);
        return item;
    }


    protected MasterInfo getMasterInfo(Long id) {
        MasterInfoExample example = new MasterInfoExample();
        example.createCriteria().andIdEqualTo(id)
                .andStatusEqualTo(Constant.MasterChild.Status.ENABLE);
        List<MasterInfo> list = masterInfoMapper.selectByExample(example);
        return CollectionUtils.isNotEmpty(list)? list.get(0):null;
    }

    protected MasterChild getMasterChild(Long masterId, Long uid) {
        MasterChildExample example = new MasterChildExample();
        example.createCriteria().andUidEqualTo(uid)
                .andMasterIdEqualTo(masterId)
                .andStatusEqualTo(Constant.MasterChild.Status.ENABLE);
        List<MasterChild> list = masterChildMapper.selectByExample(example);
        return CollectionUtils.isNotEmpty(list)? list.get(0):null;
    }

}
