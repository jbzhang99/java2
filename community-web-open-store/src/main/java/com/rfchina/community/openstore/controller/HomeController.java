package com.rfchina.community.openstore.controller;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openstore.service.OpenMiniAdInfoService;
import com.rfchina.community.persistence.mapper.CommunityMapper;
import com.rfchina.community.persistence.mapper.MasterChildMapper;
import com.rfchina.community.persistence.mapper.UserDefaultCommunityMapper;
import com.rfchina.community.persistence.model.Community;
import com.rfchina.community.persistence.model.MasterChild;
import com.rfchina.community.persistence.model.MasterChildExample;
import com.rfchina.community.persistence.model.UserDefaultCommunity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 小程序主页数据
 */
@RestController
@RequestMapping(value = {Constant.ROOT_PATH_OPENSTORE})
public class HomeController extends BaseController {
    @Autowired
    private OpenMiniAdInfoService openMiniAdInfoService;
    @Autowired
    private CommunityMapper communityMapper;
    @Autowired
    private UserDefaultCommunityMapper userDefaultCommunityMapper;
    @Autowired
    private MasterChildMapper masterChildMapper;

    @Value("${user.default.community:1}")
    private Integer userDefaultCommunity;

    /**
     * 获取主页小程序广告列表
     */
    @RequestMapping("/getMiniInfoListByCommunity")
    public Result<?> getMiniInfoListByCommunity(
            @RequestParam(value = "communityId", defaultValue = "0") Integer communityId) {
        return Result.successData(openMiniAdInfoService.getMiniInfoListByCommunity(communityId));
    }

    /**
     * 获取主页小程序活动广告
     */
    @RequestMapping("/getActivityAdByCommunity")
    public Result<?> getActivityAdByCommunity(
            @RequestParam(value = "communityId", defaultValue = "0") Integer communityId) {
        return Result.successData(openMiniAdInfoService.resultActivity(communityId));
    }


    /**
     * 获取最近位置的社区信息
     */
    @RequestMapping(value = "getRecentlyCommunity")
    public Result<Object> getRecentlyCommunity(@RequestParam(value = "longitude", defaultValue = "0") Double longitude,
                                               @RequestParam(value = "token", defaultValue = "") String token,
                                               @RequestParam(value = "latitude", defaultValue = "0") Double latitude) {
        Community community = null;
        if (StringUtils.isNotBlank(token)) {
            Long uid = getUidByToken(token);

            Integer currentCommunityId = null;

            if (uid != null) {
                UserDefaultCommunity def = userDefaultCommunityMapper.selectByPrimaryKey(uid);
                if (def == null) {
                    currentCommunityId = this.getDefaultCommunityId(uid);
                } else {
                    currentCommunityId = def.getCommunityId();
                }
            }

            if (currentCommunityId == null) {
                currentCommunityId = userDefaultCommunity;
            }
            community = communityMapper.selectByPrimaryKey(currentCommunityId);
        } else {
            if (longitude != 0 && latitude != 0) {
                List<Community> communityList = openMiniAdInfoService.getRecentlyCommunity(longitude, latitude);
                community = communityList.get(0);
            } else {
                community = communityMapper.selectByPrimaryKey(userDefaultCommunity);
            }
        }

        JSONObject json = new JSONObject();
        json.put("id", community.getId());
        json.put("communityName", community.getName());
        json.put("cityId", community.getCityId());
        json.put("cityName", community.getCityName() == null ? "" : community.getCityName());
        return Result.successData(json);
    }

    /**
     * @return Integer
     * @throws
     * @author:fukangwen
     * @Description: 获取默认的社区id，多个取最新的一个
     */
    private Integer getDefaultCommunityId(Long uid) {
        MasterChildExample example = new MasterChildExample();
        example.createCriteria().andUidEqualTo(uid).andStatusEqualTo(1);
        example.setOrderByClause("id desc");
        List<MasterChild> records = masterChildMapper.selectByExample(example);
        if (records.isEmpty())
            return null;
        return records.get(0).getCommunityId();
    }

}
