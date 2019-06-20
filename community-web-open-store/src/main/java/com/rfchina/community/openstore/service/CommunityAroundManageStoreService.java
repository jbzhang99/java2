package com.rfchina.community.openstore.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.rfchina.community.base.SysConstant;
import com.rfchina.community.base.util.HarvenSinUtils;
import com.rfchina.community.persistence.model.CommunityAround;
import com.rfchina.community.persistence.model.ext.ExtCommunityAroundPoi;
import com.rfchina.community.service.openser.CommunityAroundPoiService;
import com.rfchina.community.service.openser.RedisService;
import com.rfchina.community.service.openser.UserCommentService;
import com.rfchina.platform.common.http.HttpUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName CommunityAroundManageBridgeService
 * @Description 社区周边service包含单个社区周边信息刷新
 * @Author wlrllr
 * @Date 2019/4/25 15:24
 * @Version 1.0
 **/
@Service
public class CommunityAroundManageStoreService extends BaseService {

    @Autowired
    private CommunityAroundPoiService communityAroundPoiService;
    @Autowired
    private UserCommentService userCommentService;
    @Value("${gaode.api.url.coordinate_convert}")
    private String gaodeCoordinateConvertUrl;
    @Autowired
    private RedisService redisService;

    public Map<String,Object> getPoiDetail(Long poiId,Long communityId) {
        Map<String,Object> map = Maps.newHashMap();
        CommunityAround communityAround = communityAroundPoiService.getCommunityById(communityId);
        validator(communityAround == null,"没有该社区");
        ExtCommunityAroundPoi poi = communityAroundPoiService.getPoiById(poiId);
        validator(poi == null,"没有该商户");
        if(StringUtils.isBlank(poi.getPicUrl()) && poi.getPoiType() != null){
            poi.setPicUrl(poi.getPoiType().getPoiPicUrl());
        }
        String apiType = poi.getApiType();
        if(StringUtils.isNotBlank(apiType));{
            Set<String> typeSet = new HashSet<>();
            typeSet.addAll(Arrays.asList(apiType.split(";")));
            poi.setApiType(StringUtils.join(typeSet.iterator(),";"));
        }
        map.put("poi",poi);
        map.put("tags",communityAroundPoiService.getTagByPoiId(poiId));
        //计算到社区距离
        Double distance = HarvenSinUtils.distance(communityAround.getLatitude(),communityAround.getLongitude(),poi.getLatitude(),poi.getLongitude());
        map.put("distance",distance);
        //获取图片
        map.put("pics",communityAroundPoiService.getPicByPoiId(poiId));
        //获取评论
        map.put("comments",getPoiComment(poiId,1,10));
        map.put("locations", JSON.toJSONString(buildMaps(poi)));
        return map;
    }


    public PageInfo getPoiComment(Long poiId, int index, int size) {
        com.github.pagehelper.Page page = PageHelper.startPage(index, size);
        userCommentService.pageComment(poiId,SysConstant.COMMENT_TARGET_TYPE_POI,index,size);
        return new PageInfo(page);
    }

   private List<Map<String,Object>> buildMaps(ExtCommunityAroundPoi poi){
       List<Map<String,Object>> maps = new ArrayList<>();
       Map<String,Object> baiduMap = Maps.newHashMap();
       baiduMap.put("lat",Double.parseDouble(poi.getLatitude()));
       baiduMap.put("lon",Double.parseDouble(poi.getLongitude()));
       baiduMap.put("type",SysConstant.MAP_TYPE_BAIDU);
       maps.add(baiduMap);
       String key = new StringBuilder().append(poi.getLatitude()).append(",").append(poi.getLongitude()).append(":").append(SysConstant.MAP_TYPE_BAIDU).append("to").append(SysConstant.MAP_TYPE_GAODE).toString();
       String gaodeLocation = redisService.get(key);
       if(StringUtils.isBlank(gaodeLocation)){
           String[] coordinates = coordinateBaidu2Gaode(poi.getLongitude() + "," + poi.getLatitude());
           if(coordinates != null && coordinates.length>0){
               gaodeLocation = coordinates[0];
               redisService.set(key,gaodeLocation);
           }
       }
       if(StringUtils.isNotBlank(gaodeLocation)){
           Map<String,Object> gaodeMap = Maps.newHashMap();
           String[] location = gaodeLocation.split(",");
           gaodeMap.put("lat",Double.parseDouble(location[1]));
           gaodeMap.put("lon",Double.parseDouble(location[0]));
           gaodeMap.put("type",SysConstant.MAP_TYPE_GAODE);
           maps.add(gaodeMap);
       }
       return maps;
   }

    private String[] coordinateBaidu2Gaode(String oldlocations) {
        String url = String.format(gaodeCoordinateConvertUrl, oldlocations, "baidu");
        String response = HttpUtil.get(url);
        JSONObject obj = JSONObject.parseObject(response);
        if ("1".equals(obj.getString("status"))) {
            String locations = obj.getString("locations");
            return locations.split(";");
        }
        return null;
    }

}
