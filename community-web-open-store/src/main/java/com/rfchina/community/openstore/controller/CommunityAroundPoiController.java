package com.rfchina.community.openstore.controller;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openstore.service.CommunityAroundManageStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENSTORE + "/poi")
public class CommunityAroundPoiController extends BaseController {

    @Autowired
    private CommunityAroundManageStoreService communityAroundManageStoreService;

    @PostMapping("getPoiDetail")
    public Result getPoiDetail(Long poiId,Long communityId){
        return Result.successData(communityAroundManageStoreService.getPoiDetail(poiId,communityId));
    }
}
