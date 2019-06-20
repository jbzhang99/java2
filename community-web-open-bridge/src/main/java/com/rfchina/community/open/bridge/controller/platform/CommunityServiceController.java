package com.rfchina.community.open.bridge.controller.platform;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.service.CommunityServiceRelaService;
import com.rfchina.community.open.bridge.service.CommunityServiceService;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.CommunityServiceTemp;
import com.rfchina.community.persistence.model.OpenMerchantInfo;
import com.rfchina.community.persistence.model.OpenServicePay;
import com.rfchina.community.service.openser.OpenServicePayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @ClassName CommunityServiceController
 * @Description 服务相关
 * @Author wlrllr
 * @Date 2018/12/17 17:24
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class CommunityServiceController extends BaseController {
    @Autowired
    private OpenServicePayService openServicePayService;
    @Autowired
    private CommunityServiceService communityServiceService;
    @Autowired
    private CommunityServiceRelaService communityServiceRelaService;

    /**
     * @Author wlrllr
     * @Description //调整服务的手续费
     * @Date 2018/12/17  
     * @Param [id, platformFee, communityRate]
     * @return com.rfchina.community.base.Result<?>
     **/
    @RequestMapping("/updateCommunityRate")
    public Result<?> updateServiceRate(@RequestParam("id") int id,
                                       @RequestParam(value = "platformFee") Double platformFee,
                                       @RequestParam(value = "thinkRate") Double thinkRate,
                                       @RequestParam(value = "communityRate") Double communityRate) {
        OpenServicePay openServicePay = openServicePayService.getOpenServicePay(id);
        if (openServicePay == null) {
            error("此服务不存在");
        }
        CommunityServiceTemp communityServiceTemp = communityServiceService.getCommunityServiceTemp(id);
        validator(communityServiceTemp.getAuditStatus() == Constant.OpenAdmin.CommunityServiceAuditStatus.AUDIT, "该服务在审批中不能修改!");
        OpenMerchantInfo openMerchantInfo = communityServiceService.getOpenMerchantInfo(communityServiceTemp.getMerchantId());
        if (openMerchantInfo == null) {
            error("服务对应的服务商信息不存在");
        }
        CommunityService communityService = communityServiceService.getCommunityService(id);
        if (communityService == null) {
            error("此服务不存在");
        }
        if (communityRate.doubleValue() < 0 || communityRate.doubleValue() >= 100) {
            error("社区服务费比例不能少于0%或大于等于100%");
        }
        if (platformFee.doubleValue() < 0 || platformFee.doubleValue() >= 100) {
            error("平台手续费比例不能少于0%或大于等于100%");
        }
        if (thinkRate.doubleValue() < 0 || thinkRate.doubleValue() >= 100) {
            error("支付手续费比例不能少于0%或大于等于100%");
        }
        double totalFee = communityRate + platformFee+thinkRate;
        if (totalFee < 0 || totalFee >= 100) {
            error("平台手续费比例+社区服务费比例+支付手续费比例不能少于0%或大于等于100%");
        }
        logger.info("{} 佣金比例从{}修改为{},平台费率从{}修改为{},支付手续费率从{}修改为{}",
                communityService.getTitle(),openServicePay.getCommunityRate(),communityRate,
                openServicePay.getPlatformFee(),platformFee,openServicePay.getThinkRate(),thinkRate);
        openServicePay.setPlatformFee(new BigDecimal(platformFee));
        openServicePay.setCommunityRate(new BigDecimal(communityRate));
        openServicePay.setThinkRate(BigDecimal.valueOf(thinkRate));
        openServicePayService.insertOrUpdate(openServicePay);
        return Result.success();
    }

    @RequestMapping("/service_community_list")
    public Result<?> serviceCommunityList(@RequestParam("service_id") int serviceId,
                                          @RequestParam(value = "index", required = false, defaultValue = "1") int index,
                                          @RequestParam(value = "size", required = false, defaultValue = "10000") int size) {
        CommunityServiceTemp communityServiceTemp = communityServiceService
                .getCommunityServiceTempByPrimaryKey(serviceId);
        validator(communityServiceTemp == null, "此服务信息不存在");
        return Result.successData(
                communityServiceRelaService.getCommunityServiceRelaTempList(serviceId, index, size).convert());
    }

}
