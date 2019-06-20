package com.rfchina.community.open.bridge.controller.platform;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.rfchina.community.persistence.mapper.OpenStoreServiceTempleteMapper;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.service.openser.OpenServicePayService;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.entity.ExtCommunityService;
import com.rfchina.community.open.bridge.service.CommunityServiceInfoService;
import com.rfchina.community.open.bridge.service.CommunityServicePFService;
import com.rfchina.community.open.bridge.service.OpenDebugUserService;
import com.rfchina.community.persistence.mapper.OpenServiceDetailMapper;
import com.rfchina.community.service.openser.OpenServiceDetailTabService;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class ServiceInfoPFController extends BaseController {

    @Autowired
    private CommunityServiceInfoService communityServiceInfoService;
    @Autowired
    private CommunityServicePFService communityServicePFService;
    @Autowired
    private OpenDebugUserService openDebugUserService;
    @Autowired
    private OpenServiceDetailMapper openServiceDetailMapper;
    @Autowired
    private OpenStoreServiceTempleteMapper openStoreServiceTempleteMapper;
    @Autowired
    private OpenServiceDetailTabService openServiceDetailTabService;
    @Autowired
    private OpenServicePayService openServicePayService;

    @RequestMapping("/getCommunityServiceList")
    public Result<?> getCommunityServiceList(@RequestParam(value = "id", required = false, defaultValue = "0") int id,
                                             @RequestParam(value = "title", required = false, defaultValue = "") String title,
                                             @RequestParam(value = "merchantId", required = false, defaultValue = "0") int merchantId,
                                             @RequestParam(value = "merchantName", required = false, defaultValue = "") String merchantName,
                                             @RequestParam(value = "categoryId", required = false, defaultValue = "0") int categoryId,
                                             @RequestParam(value = "startCreateTime", required = false, defaultValue = "") String startCreateTime,
                                             @RequestParam(value = "endCreateTime", required = false, defaultValue = "") String endCreateTime,
                                             @RequestParam(value = "verifyRole", required = false, defaultValue = "") String verifyRole,
                                             @RequestParam(value = "type", required = false, defaultValue = "0") int type,
                                             @RequestParam(value = "quickPay", required = false) Integer quickPay,
                                             @RequestParam(value = "index", required = false, defaultValue = "1") int index,
                                             //保证金状态
                                             @RequestParam(value = "cautionMoneyStatus", required = false, defaultValue = "0") int cautionMoneyStatus,
                                             //上架状态
                                             @RequestParam(value = "groundAuditStatus", required = false, defaultValue = "0") int groundAuditStatus,
                                             @RequestParam(value = "size", required = false, defaultValue = "10") int size) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startCreateDate = null;
        Date endCreateDate = null;
        if (StringUtils.isNotBlank(startCreateTime)) {
            startCreateDate = sdf.parse(startCreateTime);
        }
        if (StringUtils.isNotBlank(endCreateTime)) {
            endCreateDate = sdf.parse(endCreateTime);
        }
        PageList<ExtCommunityService> serviceList = communityServicePFService.getCommunityServiceList(id, title,
                merchantId, merchantName, categoryId, startCreateDate, endCreateDate, index, size, cautionMoneyStatus, groundAuditStatus, verifyRole, type,
                quickPay);
        if (serviceList != null && serviceList.size() > 0) {
            for (ExtCommunityService extCommunityService : serviceList) {
                OpenServiceDetail dl = openServiceDetailMapper.selectByPrimaryKey(extCommunityService.getId());
                if (dl == null) {
                    dl = new OpenServiceDetail();
                }
                extCommunityService.setServiceDetail(dl);


                OpenStoreServiceTemplete templete = openStoreServiceTempleteMapper.selectByPrimaryKey(extCommunityService.getId());
                if (templete == null) {
                    extCommunityService.setFlagship(0);
                } else {
                    extCommunityService.setFlagship(templete.getFlagship());
                }

                //标签list
                extCommunityService.setTabList(openServiceDetailTabService.getTabs(extCommunityService.getId()));

                // 查询测试账号
                List<OpenDebugUser> userList = openDebugUserService.getOpenDebugUserList(extCommunityService.getId());
                String remark = "";
                if (userList != null && userList.size() > 0) {
                    for (OpenDebugUser openDebugUser : userList) {
                        remark = remark + "自在社区-" + openDebugUser.getPhone() + ";";
                    }
                }
                //查询费率
                OpenServicePay openServicePay = openServicePayService.getOpenServicePay(extCommunityService.getId());
                if(openServicePay != null){
                    extCommunityService.setCommunityRate(openServicePay.getCommunityRate());
                    extCommunityService.setPlatformFee(openServicePay.getPlatformFee());
                    extCommunityService.setThinkRate(openServicePay.getThinkRate());
                }
                extCommunityService.setRemark(remark
                        + (extCommunityService.getRemark() == null ? "" : "服务-" + extCommunityService.getRemark()));


                if (extCommunityService.getStatus() != 4 && extCommunityService.getType() == 4 && "STORE".equals(extCommunityService.getTempleteName())) {
                    OpenStoreServiceTempleteExample exa = new OpenStoreServiceTempleteExample();
                    exa.createCriteria().andServiceIdEqualTo(extCommunityService.getId());
                    extCommunityService.setIsShowRole(openStoreServiceTempleteMapper.countByExample(exa) > 0 ? 1 : 0);
                }

            }
        }

        return Result.successData(serviceList.convert());
    }

    @RequestMapping("/getCommunityServiceInfo")
    public Result<?> getCommunityServiceInfo(@RequestParam(value = "id", required = true) String ids) {
        int id = 0;
        try {
            id = Integer.parseInt(ids);
        } catch (Exception e) {
            // id=s432:i364
            String[] temp = ids.split(":");
            for (String string : temp) {
                if (string.startsWith("s")) {
                    id = Integer.parseInt(string.substring(1));
                }
            }
        }
        JSONObject json = communityServiceInfoService.getCommunityServiceInfo(id);

        return Result.successData(json);
    }

    /**
     * @return Result<?>
     * @throws
     * @author:fukangwen
     * @Description: 保存标签
     */
    @RequestMapping("/saveServiceTabs")
    public Result<?> saveServiceTabs(
            @RequestParam(value = "types", required = false) String types,
            @RequestParam(value = "serviceId", required = true) int serviceId) {
        openServiceDetailTabService.saveServiceTabs(types, serviceId);
        return Result.success();
    }


    @RequestMapping(value = {"/searchCommunityServiceList"}, method = {RequestMethod.POST})
    public Result<?> searchCommunityServiceList(
            @RequestParam("keyword") String keyword) {
        return Result.successData(communityServiceInfoService.searchCommunityServiceList(keyword));
    }
}
