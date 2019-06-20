package com.rfchina.community.base.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 */
public class AddrUtils {

    public static final String create(String communityName, String loudong, String floor, String room) {
        if(StringUtils.isBlank(loudong)) {
            loudong = "无栋";
        } else {
            if(!StringUtils.contains(loudong, "栋")) {
                loudong = loudong + "栋";
            }
        }
        //
        if(StringUtils.isBlank(floor)) {
            floor = "无层";
        } else {
            if(!StringUtils.contains(floor, "层")) {
                floor = floor + "层";
            }
        }
        //
        if(StringUtils.isBlank(room)) {
            room = "无号";
        } else {
            if(!StringUtils.contains(room, "号")) {
                room = room + "号";
            }
        }
        return Optional.ofNullable(communityName).orElse("") + loudong + floor + room;
    }
    
    public static final String createForCert(String cityName, String communityName, String loudong, String floor, String room, String companyName) {
        if (StringUtils.isNotBlank(loudong)) {
            loudong = StringUtils.replacePattern(loudong, "(栋)+$", "栋");
        }
        //
        if (StringUtils.isNotBlank(floor)) {
            floor = StringUtils.replacePattern(floor, "(层)+$", "层");
        }
        //
        if (StringUtils.isNotBlank(room)) {
            room = StringUtils.replacePattern(room, "(号)+$", "号");
        }
        return (StringUtils.isNotBlank(cityName) ? cityName : "")
                + (StringUtils.isNotBlank(communityName) ? "-" + communityName : "")
                + (StringUtils.isNotBlank(loudong) ? "-" + loudong : "")
                + (StringUtils.isNotBlank(floor) ? "-" + floor : "")
                + (StringUtils.isNotBlank(room) ? "-" + room : "")
                + (StringUtils.isNotBlank(companyName) ? "-" + companyName : "");
    }
}
