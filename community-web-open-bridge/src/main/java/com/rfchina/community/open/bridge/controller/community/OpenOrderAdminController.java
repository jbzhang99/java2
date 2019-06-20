package com.rfchina.community.open.bridge.controller.community;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.service.OpenOrderService;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_COMMUNITY)
public class OpenOrderAdminController extends BaseController {

    @Autowired
    private OpenOrderService openOrderService;

    @RequestMapping("/getOrderList")
    public Result<?> getOpenOrderList(
            @RequestParam(value = "cityId", required = false, defaultValue = "0") int cityId,
            @RequestParam(value = "communityIds", required = true) String communityIds,
            @RequestParam(value = "startCreateTime", required = false, defaultValue = "") String startCreateTime,
            @RequestParam(value = "endCreateTime", required = false, defaultValue = "") String endCreateTime,
            @RequestParam(value = "serviceId", required = false, defaultValue = "0") int serviceId,
            @RequestParam(value = "merchantId", required = false, defaultValue = "0") int merchantId,
            @RequestParam(value = "serviceName", required = false, defaultValue = "") String serviceName,
            @RequestParam(value = "merchantName", required = false, defaultValue = "") String merchantName,
            @RequestParam(value = "billStatus", required = false, defaultValue = "0") int billStatus,
            @RequestParam(value = "index", required = false, defaultValue = "1") int index,
            @RequestParam(value = "outTradeNo", required = false, defaultValue = "") String outTradeNo,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size) throws Exception {

        // Integer commid = getCommunityId();
        //现在只能查询一个社区,2017-12-15
        Integer commid = Integer.valueOf(communityIds);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date startCreateDate = null;
        Date endCreateDate = null;

        if (StringUtils.isNotBlank(startCreateTime)) {
            startCreateDate = sdf.parse(startCreateTime);
        }

        if (StringUtils.isNotBlank(endCreateTime)) {
            endCreateDate = sdf.parse(endCreateTime);
        }
        return Result.successData(openOrderService.getOpenOrderList(startCreateDate, endCreateDate, serviceId, merchantId, serviceName, merchantName, commid, null, billStatus, index, outTradeNo, size).convert());
    }

}
