package com.rfchina.community.openstore.service;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.OpenMiniConstant;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.OpenMiniAdTabMapper;
import com.rfchina.community.persistence.mapper.OpenStoreGoodMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJInfoMapper;
import com.rfchina.community.persistence.mapper.ext.ExtOpenMiniAdInfoMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.persistence.model.ext.ExtOpenMiniAdInfo;
import com.rfchina.community.persistence.model.ext.ExtOpenMiniAdTab;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OpenMiniAdInfoService {
    @Autowired
    private OpenMiniAdTabMapper openMiniAdTabMapper;
    @Autowired
    private CommunityServiceMapper communityServiceMapper;
    @Autowired
    private OpenStoreGoodMapper openStoreGoodMapper;
    @Autowired
    private OpenXFSJInfoMapper openXFSJInfoMapper;
    @Autowired
    private ExtOpenMiniAdInfoMapper extOpenMiniAdInfoMapper;
    @Value("${open.storeapi.url}")
    private String openStoreapiUrl;

    public List<ExtOpenMiniAdInfo> getMiniInfoListByCommunity(Integer communityId){
        Map<String, Object> param = new HashMap<>();
        param.put("communityId", communityId);
        param.put("status", 1);
        List<ExtOpenMiniAdInfo> list = extOpenMiniAdInfoMapper.getMiniInfoListByCommunity(param);
        for(ExtOpenMiniAdInfo info : list){
            info.setTabList(this.getTabList(info.getId()));
        }
        return list;
    }

    //精选活动
    public List<JSONObject> resultActivity(Integer communityId) {
        OpenXFSJInfoExample e = new OpenXFSJInfoExample();
        e.createCriteria().andStatusEqualTo(1).andCommunityIdEqualTo(communityId).andTypeEqualTo("community").andEndTimeGreaterThanOrEqualTo(new Date());
        e.or().andStatusEqualTo(1).andCommunityIdEqualTo(communityId).andTypeEqualTo("platform");
        e.setOrderByClause("type,id desc");
        List<OpenXFSJInfo> list_activity = openXFSJInfoMapper.selectByExample(e);
        List<JSONObject> result_activity = new ArrayList<>();
        for (OpenXFSJInfo openXfsjInfo : list_activity) {
            JSONObject json = new JSONObject();
            json.put("id", openXfsjInfo.getId());
            json.put("title", openXfsjInfo.getActTitile());
            json.put("link", openXfsjInfo.getActUrl());
            result_activity.add(json);
        }
        return result_activity;
    }

    private List<ExtOpenMiniAdTab> getTabList(long infoId){
        OpenMiniAdTabExample example = new OpenMiniAdTabExample();
        example.createCriteria().andMiniAdInfoIdEqualTo(infoId);
        example.setOrderByClause("serial_number");
        List<OpenMiniAdTab> list = openMiniAdTabMapper.selectByExample(example);
        List<ExtOpenMiniAdTab> extList = new ArrayList<>();
        for(OpenMiniAdTab tab : list){
            ExtOpenMiniAdTab extTab = new ExtOpenMiniAdTab();
            BeanUtils.copyProperties(tab, extTab);
            if(OpenMiniConstant.Type.SERVICE.getCode().equals(tab.getType())){
                CommunityService service = communityServiceMapper.selectByPrimaryKey(tab.getTargetId());
                extTab.setUrl(new StringBuilder().append(openStoreapiUrl).append("#/home?isNew=1&serviceId=").append(service.getId()).toString());
            }else if(OpenMiniConstant.Type.GOOD.getCode().equals(tab.getType())){
                OpenStoreGood good = openStoreGoodMapper.selectByPrimaryKey(tab.getTargetId());
                extTab.setUrl(new StringBuilder().append(openStoreapiUrl).append("#/goodsDetail?isNew=1&serviceId=").append(good.getServiceId()).append("&goodId=").append(good.getId()).toString());
            }else{
                extTab.setUrl(tab.getTargetUrl());
            }
            extList.add(extTab);
        }

        return extList;
    }

    public List<Community> getRecentlyCommunity(Double longitude, Double latitude){
        Map<String, Object> param = new HashMap<>();
        param.put("longitude", longitude);
        param.put("latitude", latitude);
        return extOpenMiniAdInfoMapper.getRecentlyCommunity(param);
    }
}
