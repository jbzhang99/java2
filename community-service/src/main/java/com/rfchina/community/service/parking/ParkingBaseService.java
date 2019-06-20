package com.rfchina.community.service.parking;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.mapper.ext.ExtParkingBindCaptchaMapper;
import com.rfchina.community.persistence.mapper.ext.ExtParkingOrderMapper;
import com.rfchina.community.persistence.model.*;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 */
public abstract class ParkingBaseService  {

    public static final Integer ORDER_SUCCESS = 1;

    public static final Integer ORDER_NOT_EXISTED = 10;

    public static final Integer ORDER_STATUS_IS_NOT_UNPAIED = 11;

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected Cache<String, ParkingConf> PARKING_CONF_CACHE = CacheBuilder.newBuilder()
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .build();

    @Autowired
    protected ParkingBindMapper parkingBindMapper;

    @Autowired
    protected ParkingBindHisMapper parkingBindHisMapper;

    @Autowired
    protected ParkingOrderMapper parkingOrderMapper;

    @Autowired
    protected ExtParkingOrderMapper extParkingOrderMapper;

    @Autowired
    protected ParkingBindCaptchaMapper parkingBindCaptchaMapper;

    @Autowired
    protected ParkingCarPlateMapper parkingCarPlateMapper;

    @Autowired
    protected ExtParkingBindCaptchaMapper extParkingBindCaptchaMapper;

    @Autowired
    protected CommunityMapper communityMapper;

    @Autowired
    protected CommunityPayMapper communityPayMapper;

    @Autowired
    protected UserInfoMapper userInfoMapper;

    @Autowired
    protected ParkingConfMapper parkingConfMapper;

    protected String getCommunityName(Integer communityId) {
        Community record = communityMapper.selectByPrimaryKey(communityId);
        return record!=null? record.getName():"";
    }

    protected boolean hasBindMonthlyParking(Integer communityId, String carPlateNo) {
        ParkingBindExample example = new ParkingBindExample();
        example.createCriteria()
                .andCommunityIdEqualTo(communityId)
                .andCarPlateNoEqualTo(carPlateNo);
        Long count = parkingBindMapper.countByExample(example);
        return count.longValue() > 0;
    }

    protected ParkingConf getParkingConf(String parkingCode) {
        ParkingConf cacheVal = PARKING_CONF_CACHE.getIfPresent(parkingCode);
        if(null == cacheVal) {
            ParkingConfExample example = new ParkingConfExample();
            example.createCriteria().andParkingCodeEqualTo(parkingCode);
            List<ParkingConf> list = parkingConfMapper.selectByExample(example);
            if(CollectionUtils.isNotEmpty(list)) {
                cacheVal = list.get(0);
                PARKING_CONF_CACHE.put(parkingCode, cacheVal);
            }
        }
        return cacheVal;
    }

    public ParkingConf getParkingConf(Integer communityId) {
        ParkingConf record = parkingConfMapper.selectByPrimaryKey(communityId);
        return record;
    }

    protected ParkingBind getParkingBind(String carPlateNo, Integer communityId) {
        ParkingBindExample example = new ParkingBindExample();
        example.createCriteria()
                .andCommunityIdEqualTo(communityId)
                .andCarPlateNoEqualTo(carPlateNo);
        List<ParkingBind> list = parkingBindMapper.selectByExample(example);
        return CollectionUtils.isNotEmpty(list)? list.get(0):null;
    }

    protected ParkingBind getParkingBind(String carPlateNo) {
        ParkingBindExample example = new ParkingBindExample();
        example.createCriteria()
//                .andCommunityIdEqualTo(communityId)
                .andCarPlateNoEqualTo(carPlateNo);
        List<ParkingBind> list = parkingBindMapper.selectByExample(example);
        return CollectionUtils.isNotEmpty(list)? list.get(0):null;
    }
}
