package com.rfchina.community.open.bridge.controller.community;


import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.ValueNamePair;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.entity.ExtCommunityServiceAdmin;
import com.rfchina.community.open.bridge.entity.SimCommunityService;
import com.rfchina.community.open.bridge.mapper.ext.ExtCommunityServiceMapper;
import com.rfchina.community.open.bridge.service.CommunityServiceCommentService;
import com.rfchina.community.open.bridge.service.CommunityServiceRelaService;
import com.rfchina.community.open.bridge.service.CommunityServiceService;
import com.rfchina.community.open.bridge.service.OpenDebugUserService;
import com.rfchina.community.persistence.mapper.CommunityMapper;
import com.rfchina.community.persistence.mapper.CommunityPayMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.model.Community;
import com.rfchina.community.persistence.model.CommunityPay;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.CommunityServiceRela;
import com.rfchina.community.persistence.model.OpenDebugUser;
import com.rfchina.community.persistence.model.OpenMerchantInfo;
/**
 */
@RestController
@RequestMapping(value = {OpenConstant.ROOT_PATH_COMMUNITY})
public class CommunityServiceAdminController extends BaseController {

    @Autowired
    private CommunityServiceMapper communityServiceMapper;
    @Autowired
    private CommunityMapper communityMapper;
    @Autowired
    private ExtCommunityServiceMapper extCommunityServiceMapper;
    @Autowired
    private CommunityServiceService communityServiceService;
    @Autowired
    private OpenMerchantInfoMapper openMerchantInfoMapper;
    @Autowired
    private CommunityServiceCommentService communityServiceCommentService;
    @Autowired
    private CommunityServiceRelaService communityServiceRelaService;
    @Autowired
    private OpenDebugUserService openDebugUserService;
    @Autowired
    private CommunityPayMapper communityPayMapper;

    public static final ValueNamePair<Integer, String> CASCADE_DELETE_APPOINTMENT_SERVICE = ValueNamePair.of(40001, "门禁一旦禁用，邀请来访功能也将一并禁用");
    /**
     * @author:fukangwen
     * @Description: 获取服务市场列表
     * @return Result<?>
     * @throws
     */
    @RequestMapping("/getCommunityServiceList")
    public Result<?> getCommunityServiceList(
            @RequestParam(value = "cityId", required = false, defaultValue = "0") int cityId,
            @RequestParam(value = "communityIds", required = true) String communityIds,
            @RequestParam(value = "categoryId", required = false, defaultValue = "0") int categoryId,
            @RequestParam(value = "index", required = false, defaultValue = "1") int index,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size) {

        // 现在只能查询一个社区,2017-12-15
        Integer commid = Integer.valueOf(communityIds);
        
        //获取社区信息
        Community community = communityMapper.selectByPrimaryKey(commid);
        validator(community == null, "该社区不存在");
        
        PageList<SimCommunityService> serviceList = null;
        
        if(Constant.CommunityCategory.ENTITY == community.getCategory()) {
	        serviceList = communityServiceService.getSimCommunityServiceList(categoryId,
	                Constant.OpenAdmin.CommunityServiceGroundStatus.GROUNDING, commid, index, size);
	        return Result.successData(serviceList.convert());
        }
        
        //虚拟社区
        serviceList = communityServiceService.getVirtualSimCommunityServiceList(categoryId,
                Constant.OpenAdmin.CommunityServiceGroundStatus.GROUNDING, index, size);
        
        for(SimCommunityService service : serviceList) {
        	service.setSelectStatus(this.getServiceSelectStatus(service.getId(), commid));
        }
        
        return Result.successData(serviceList.convert()); 
    }

    /**
     * @author:fukangwen
     * @Description: 获取是否选用
     * @return Integer
     * @throws
     */
    private Integer getServiceSelectStatus(Integer serviceId, Integer communityId) {
    	CommunityServiceRela rela = communityServiceRelaService.getCommunityServiceRela(serviceId, communityId);
    	if(rela == null)
    		return 2;// 禁用
		return rela.getStatus();
	}

	/**
     * @author:fukangwen
     * @Description: 评论
     * @return Result<?>
     * @throws
     */
    @RequestMapping("/getServiceComment")
    public Result<?> getServiceComment(@RequestParam("id") int serviceId,
                                       @RequestParam(value = "index", required = false, defaultValue = "1") int index,
                                       @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        if (serviceId <= 0) {
            error("服务ID不能为空");
        }

        return Result
                .successData(communityServiceCommentService.getCommunityServiceCommentList(serviceId, index, size));
    }

    /**
     * @author:fukangwen
     * @Description: 服务联系
     * @return Result<?>
     * @throws
     */
    @RequestMapping("/getServiceContacts")
    public Result<?> getServiceContacts(
            @RequestParam(value = "cityId", required = false, defaultValue = "0") int cityId,
            @RequestParam(value = "communityIds", required = true) String communityIds,
            @RequestParam("id") int serviceId) {
        // Integer commid = getCommunityId();

        // 现在只能查询一个社区,2017-12-15
        Integer commid = Integer.valueOf(communityIds);
        return Result.successData(communityServiceRelaService.getCommunityServiceRela(serviceId, commid));
    }

    /**
     * @author:fukangwen
     * @Description: 选用
     * @return Result<?>
     * @throws
     */
    @RequestMapping("/communitySelectService")
    public Result<?> communitySelectService(
            @RequestParam(value = "cityId", required = false, defaultValue = "0") int cityId,
            @RequestParam(value = "communityIds", required = true) String communityIds,
            @RequestParam("id") int serviceId) {
        // Integer commid = getCommunityId();

        // 现在只能查询一个社区,2017-12-15
        validator(StringUtils.isBlank(communityIds), "请选择社区");
        Integer commid = Integer.valueOf(communityIds);
        
        CommunityServiceRela communityServiceRela = communityServiceRelaService.getCommunityServiceRela(serviceId,
                commid);
        
        if (communityServiceRela == null) {
            //获取社区信息
            Community community = communityMapper.selectByPrimaryKey(commid);
            validator(community == null, "该社区不存在");
            
            //实体社区不能没有记录就添加
            if(Constant.CommunityCategory.ENTITY == community.getCategory().intValue()) {
            	error("社区不存在此服务");
            }
            
            //虚拟社区直接新增
            CommunityService communityService = communityServiceService.getCommunityService(serviceId);
            validator(communityService == null, "该服务不存在");
            
            //判断该虚拟社区有没有配结算账号
            CommunityPay pay = communityPayMapper.selectByPrimaryKey(commid);
            validator(pay == null || StringUtils.isBlank(pay.getOpenMerchantId()), "该社区结算账号不存在,请联系技术人员");
            
            OpenMerchantInfo merchant = openMerchantInfoMapper.selectByPrimaryKey(communityService.getMerchantId());
            communityServiceRelaService.insert(serviceId, commid, merchant.getContactPerson(),
    				merchant.getContactPhone(), merchant.getEmail());
            
            return Result.success();
        }
        
        //已有更新状态
        communityServiceRela.setSelectStatus(Constant.OpenAdmin.CommunityServiceRelaSelectStatus.ENABLE);
        communityServiceRela.setAuditComment("社区主动选用服务");
        communityServiceRela.setAuditStatus(Constant.OpenAdmin.CommunityServiceRelaAuditStatus.AUDIT_PASS);
        communityServiceRelaService.updateCommunityServiceRela(communityServiceRela);

        return Result.success();
    }

    /**
     * @author:fukangwen
     * @Description: 获取我关联的服务列表
     * @return Result<?>
     * @throws
     */
    @RequestMapping("/getMyServiceList")
    public Result<?> getMyServiceList(@RequestParam(value = "cityId", required = false, defaultValue = "0") int cityId,
                                      @RequestParam(value = "communityIds", required = true) String communityIds,
                                      @RequestParam(value = "categoryId", required = false, defaultValue = "0") int categoryId,
                                      @RequestParam(value = "merchantType", required = false, defaultValue = "0") int merchantType,
                                      @RequestParam(value = "merchantName", required = false, defaultValue = "") String merchantName,
                                      @RequestParam(value = "serviceName", required = false, defaultValue = "") String serviceName,
                                      @RequestParam(value = "communityServiceStatus", required = false, defaultValue = "0") int communityServiceStatus,
                                      @RequestParam(value = "index", required = false, defaultValue = "1") int index,
                                      @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        // Integer commid = getCommunityId();

        // 现在只能查询一个社区,2017-12-15
        Integer commid = Integer.valueOf(communityIds);
        PageList<ExtCommunityServiceAdmin> serviceList = communityServiceService.getMyServiceList(categoryId, commid,
                merchantType, merchantName, serviceName, communityServiceStatus, index, size);

        if (serviceList != null && serviceList.size() > 0) {
            for (ExtCommunityServiceAdmin extCommunityService : serviceList) {
                // 查询测试账号
                List<OpenDebugUser> userList = openDebugUserService.getOpenDebugUserList(extCommunityService.getId());

                String remark = "";

                if (extCommunityService.getType() == 1 || extCommunityService.getType() == 2) {
                    extCommunityService.setMerchantName("无");
                    extCommunityService.setMerchantType(0);
                    extCommunityService.setGroundTime(extCommunityService.getCreateTime());
                }

                if (userList != null && userList.size() > 0) {
                    for (OpenDebugUser openDebugUser : userList) {
                        remark = remark + "自在社区-" + openDebugUser.getPhone() + ";";
                    }
                }

                extCommunityService.setRemark(remark
                        + (extCommunityService.getRemark() == null ? "" : "服务-" + extCommunityService.getRemark()));
            }
        }

        return Result.successData(serviceList.convert());

    }

    /**
     * @author:fukangwen
     * @Description: 在该社区的排序
     * @return Result<?>
     * @throws
     */
    @RequestMapping("/updateServiceReorder")
    public Result<?> updateServiceReorder(
            @RequestParam(value = "cityId", required = false, defaultValue = "0") int cityId,
            @RequestParam(value = "communityIds", required = true) String communityIds,
            @RequestParam("id") int serviceId, @RequestParam("communityServiceReorder") int communityServiceReorder) {
        // Integer commid = getCommunityId();

        // 现在只能查询一个社区,2017-12-15
        validator(StringUtils.isBlank(communityIds), "请选择社区ID");
        Integer commid = Integer.valueOf(communityIds);
        CommunityServiceRela communityServiceRela = communityServiceRelaService.getCommunityServiceRela(serviceId,
                commid);

        if (communityServiceRela == null) {
            error("社区不存在此服务");
        }

        communityServiceRela.setReorder(communityServiceReorder);
        communityServiceRelaService.updateCommunityServiceRela(communityServiceRela);

        return Result.success();
    }

    /**
     * @author:fukangwen
     * @Description: 是否在社区菜单显示
     * @return Result<?>
     * @throws
     */
    @RequestMapping("/updateMenuShow")
    public Result<?> updateMenuShow(@RequestParam(value = "cityId", required = false, defaultValue = "0") int cityId,
                                    @RequestParam(value = "communityIds", required = true) String communityIds,
                                    @RequestParam("id") int serviceId, @RequestParam("isMenuShow") int isMenuShow) {
        // Integer cid = getCommunityId();
        // Integer commid = getCommunityId();

        // 现在只能查询一个社区,2017-12-15
        validator(StringUtils.isBlank(communityIds), "请选择社区ID");
        Integer commid = Integer.valueOf(communityIds);
        CommunityServiceRela communityServiceRela = communityServiceRelaService.getCommunityServiceRela(serviceId,
                commid);

        if (communityServiceRela == null) {
            error("社区不存在此服务");
        }

        validator(isMenuShow != 1 && isMenuShow != 2, "显示状态只能为1或是2");
        String msg = "";
        // 是否在社区菜单显示
        if (isMenuShow == 1) {
            validator(communityServiceRela.getStatus() != 1, "启用状态才能设置该状态");
            Long cou = extCommunityServiceMapper.countIsMenuShowByCommunityId(commid);
            validator(cou >= 9, "设置失败,已经超过9个,目前:" + cou);
            msg = cou + "  " + commid + "  " + cou + isMenuShow;
        }

        communityServiceRela.setIsMenuShow(isMenuShow);
        communityServiceRelaService.updateCommunityServiceRela(communityServiceRela);

        return Result.successData(msg);
    }

    /**
     * @author:fukangwen
     * @Description: 停用或启用该服务
     * @return Result<?>
     * @throws
     */
    @RequestMapping("/updateCommSvRelaStatus")
    public Result<?> updateCommSvRelaStatus(
            @RequestParam(value = "cityId", required = false, defaultValue = "0") int cityId,
            @RequestParam(value = "communityIds", required = true) String communityIds,
            @RequestParam("id") int serviceId, @RequestParam("communityServiceStatus") int communityServiceStatus) {
        Result<JSONObject> result = new Result<JSONObject>();
        // Integer commid = getCommunityId();

        // 现在只能查询一个社区,2017-12-15
        validator(StringUtils.isBlank(communityIds), "请选择社区ID");
        Integer commid = Integer.valueOf(communityIds);
        // 启用邀约来访的时候要检查门禁功能是否已经开通
        if (Constant.CommunityService.APPOINTMENT == serviceId && 1 == communityServiceStatus) {
            CommunityServiceRela communityServiceRela = communityServiceRelaService
                    .getCommunityServiceRela(Constant.CommunityService.GUARD_SERVICE, commid);
            if (null == communityServiceRela || 4 == communityServiceRela.getStatus()) {
                result.setStatus(CASCADE_DELETE_APPOINTMENT_SERVICE.value());
                result.setMessage("该社区需要先启用门禁功能才能启用邀约来访！");
                return result;
            }
        }

        CommunityServiceRela communityServiceRela = communityServiceRelaService.getCommunityServiceRela(serviceId,
                commid);

        if (communityServiceRela == null) {
            error("社区不存在此服务");
        }

        //  communityServiceStatus = 1 时，启用服务，发送消息
        // communityServiceStatus = 4时，停用服务，发送消息
        communityServiceRela.setStatus(communityServiceStatus);

        // 启用服务时，修改社区上架时间
        if (communityServiceStatus == 1) {
            communityServiceRela.setGroundTime(new Date());
        } else {
            communityServiceRela.setIsMenuShow(2);
        }

        communityServiceRelaService.updateCommunityServiceRela(communityServiceRela);

        // 停用门禁的时候要同时禁用邀约
        if (Constant.CommunityService.GUARD_SERVICE == serviceId && 4 == communityServiceStatus) {
            CommunityServiceRela communityServiceRelaAppoint = communityServiceRelaService
                    .getCommunityServiceRela(Constant.CommunityService.APPOINTMENT, commid);
            if (null != communityServiceRelaAppoint && 1 == communityServiceRelaAppoint.getStatus()) {
                communityServiceRelaAppoint.setStatus(communityServiceStatus);
                communityServiceRelaService.updateCommunityServiceRela(communityServiceRelaAppoint);
                result.setStatus(CASCADE_DELETE_APPOINTMENT_SERVICE.value());
                result.setMessage(CASCADE_DELETE_APPOINTMENT_SERVICE.name());
                return result;
            }
        }
        return Result.success();
    }

    /**
     * @author:fukangwen
     * @Description: 删除该服务
     * @return Result<?>
     * @throws
     */
    @RequestMapping("/deleteCommunityService")
    public Result<?> deleteCommunityService(
            @RequestParam(value = "cityId", required = false, defaultValue = "0") int cityId,
            @RequestParam(value = "communityIds", required = true) String communityIds,
            @RequestParam("id") int serviceId) {

        // 现在只能查询一个社区,2017-12-15
        validator(StringUtils.isBlank(communityIds), "请选择社区ID");
        Integer commid = Integer.valueOf(communityIds);
        CommunityServiceRela communityServiceRela = communityServiceRelaService.getCommunityServiceRela(serviceId,
                commid);

        if (communityServiceRela == null) {
            error("社区不存在此服务");
        }

        CommunityService ser = communityServiceMapper.selectByPrimaryKey(serviceId);
        validator(ser == null, "服务不存在!" + serviceId);
        validator(ser.getType() != 3 && ser.getType() != 4, "只有自在服务才能删除!" + serviceId);

        // 是否在社区菜单显示
        communityServiceRela.setIsMenuShow(2);
        communityServiceRela.setSelectStatus(Constant.OpenAdmin.CommunityServiceRelaSelectStatus.DISABLE);
        communityServiceRela.setAuditStatus(Constant.OpenAdmin.CommunityServiceRelaAuditStatus.NOTAUDIT);
        communityServiceRela.setStatus(Constant.CommunityServiceRela.Status.DISABLE);

        communityServiceRela.setAuditComment("社区主动删除!");

        communityServiceRelaService.updateCommunityServiceRela(communityServiceRela);

        return Result.success();
    }

}
