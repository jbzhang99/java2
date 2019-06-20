package com.rfchina.community.open.bridge.controller.community;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.service.CommunityServiceService;
import com.rfchina.community.persistence.model.CommunityServiceExample;
import com.rfchina.community.persistence.model.OpenAuditInfo;
import com.rfchina.community.persistence.model.OpenManagerInvite;
import com.rfchina.community.persistence.model.OpenMerchantInfo;
import com.rfchina.community.service.openser.OpenAuditInfoService;
import com.rfchina.community.service.openser.OpenManagerInviteService;
import com.rfchina.community.service.openser.OpenMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MerchantInfoController
 * @Description 商家相关接口，包含查询列表，详情，修改
 * @Author wlrllr
 * @Date 2018/12/25 11:33
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = { OpenConstant.ROOT_PATH_COMMUNITY })
public class MerchantInfoController  extends BaseController {

    @Autowired
    private OpenAuditInfoService openAuditInfoService;
    @Autowired
    private OpenMerchantService openMerchantService;
    @Autowired
    private CommunityServiceService communityServiceService;
    @Autowired
    private OpenManagerInviteService openManagerInviteService;


    @RequestMapping(value = { "/merchantDetail" })
    public Result<?> getMerchantDetail(@RequestParam(value = "id") long id,
                                       @RequestParam("merchant_id") Long merchantId) {
        JSONObject result = new JSONObject();
        OpenAuditInfo audit = openAuditInfoService.selectByPrimaryKey(id);
        validator(audit == null, "数据不存在" + id);
        validator(merchantId.longValue() != audit.getMerchantId(), "请提供正确的商家id");
        OpenMerchantInfo merchant = openMerchantService.selectByPrimaryKey(merchantId);
        //富慧通未审核通过的只查询审核信息和商家信息
        if(!merchant.getStatus().equals(Constant.merchantInfo.status.normal)){
            result.put("audit", audit);
            result.put("merchant", merchant);
            //如果是小富市集则查询邀请人信息
            if(merchant.getXfsjStatus() == 1){
                OpenManagerInvite invite = openManagerInviteService.getbyMerchantId(merchantId);
                result.put("invite", invite);
            }
        }else{
            CommunityServiceExample example = new CommunityServiceExample();
            example.createCriteria().andMerchantIdEqualTo(merchantId);
           // result.put("cityName", getCityShortName(merchant.getSrcCity()));
        }
        return Result.successData(result);
    }

}
