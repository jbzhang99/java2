package com.rfchina.community.openstore.controller;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openstore.service.CommunityService;
import com.rfchina.community.openstore.service.CommunityServiceRelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 */
@RestController
@RequestMapping(value = {Constant.ROOT_PATH_OPENSTORE})
public class OpenCommunityController extends BaseController {

    @Autowired
    private CommunityServiceRelaService communityServiceRelaService;
    @Autowired
    private CommunityService communityService;


    /**
     * @author:fukangwen
     * @Description: 判断该社区是否可以用该服务
     * @return Result<?>
     * @throws
     */
    @RequestMapping("/canUseThisCommunity")
    public Result<?> canUseThisCommunity(
            @RequestParam(value = "service_id", required = false, defaultValue = "0") int serviceId,
            @RequestParam(value = "community_id", required = false, defaultValue = "0") int communityId) {
        return Result.successData(communityServiceRelaService.checkService(serviceId, communityId));
    }

    @RequestMapping(value = {"/getCommunityListByCityId"})
    public Result<?> getCommunityListByCityId(Integer cityId) {
        return Result.successData(communityService.getCommunityByCityId(cityId));
    }
}
