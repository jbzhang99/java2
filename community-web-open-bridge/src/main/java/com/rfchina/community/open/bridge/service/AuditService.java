package com.rfchina.community.open.bridge.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.util.ValidatorUtil;
import com.rfchina.community.component.OpenAuditInfoComponent;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.OpenAuditInfoMapper;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.OpenAuditInfo;
import com.rfchina.community.persistence.model.OpenMerchantInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wlrllr
 * @Description 审核类
 * @Date 2018/12/14
 **/
@Service
public class AuditService extends  BaseService{

    @Autowired
    private OpenAuditInfoMapper openAuditInfoMapper;
    @Autowired
    private OpenAuditInfoComponent openAuditInfoComponent;
    @Autowired
    private OpenMerchantInfoMapper openMerchantInfoMapper;
    @Autowired
    private CommunityServiceMapper communityServiceMapper;

    public void audit(String phone, String realName, Long id, int status, String statusContent, String parameters,Map<String, IOpenAuditType> map , Long uid) throws Exception {
        OpenAuditInfo auditInfo = openAuditInfoMapper.selectByPrimaryKey(id);
        logger.info("AuditService start audit  adminId:{},id:{},status:{},phone:{},realName:{},statusContent:{},parameters:{},auditInfo:{}",
                uid, id, status, phone, realName, statusContent, parameters, JSON.toJSONString(auditInfo));
        ValidatorUtil.verify(status, "审批状态值 只能为 1,2", 1, 2);
        validator(auditInfo == null, "数据不存在!");
        validateMerchant(auditInfo);
        validator(auditInfo.getAuditStatus().intValue() != OpenAuditInfoComponent.Status.init.getV(), "非审批中状态不能审批!");
        for (Map.Entry<String, IOpenAuditType> string : map.entrySet()) {
            IOpenAuditTypeReturn ret = string.getValue()
                    .audit(OpenAuditInfoComponent.ObjectType.valueOf(auditInfo.getAuditType()));
            if (ret != null) {
                if (status == 1) {
                    Map<String, String> parameter = new HashMap<>();
                    if (StringUtils.isNotBlank(parameters)) {
                        parameter = JSONObject.parseObject(parameters, new TypeReference<Map<String, String>>() {
                        });
                    }
                    ret.passAudit(auditInfo.getSrcUid(), auditInfo.getObjectId(), parameter);
                    openAuditInfoComponent.audit(id, OpenAuditInfoComponent.Status.pass,
                            StringUtils.isBlank(statusContent) ? "同意!" : statusContent, uid, phone, realName);
                } else {
                    validator(StringUtils.isBlank(statusContent), "拒绝原因不能为空!");
                    ret.unpassAudit(auditInfo.getSrcUid(), auditInfo.getObjectId(), statusContent);
                    openAuditInfoComponent.audit(id, OpenAuditInfoComponent.Status.unpass, statusContent, uid, phone,
                            realName);
                }
            }
        }
        logger.info("AuditService end audit...");
    }

    private void validateMerchant(OpenAuditInfo auditinfo){
        Integer serviceId = auditinfo.getServiceId();
        Long mchId = auditinfo.getMerchantId();
        String auditType = auditinfo.getAuditType();
        if(OpenAuditInfoComponent.ObjectType.service_approval.toString().equals(auditType) ||
                OpenAuditInfoComponent.ObjectType.xfsj_provider_apply.toString().equals(auditType)){
            logger.info("审核商户信息...mchId：{}，serviceId：{}，auditType：{}",mchId,serviceId,auditType);
            OpenMerchantInfo merchantInfo = new OpenMerchantInfo();
            if(mchId != null && mchId.longValue() != 0){
                merchantInfo = openMerchantInfoMapper.selectByPrimaryKey(mchId);
            }else if(serviceId != null && serviceId.longValue() != 0){
                CommunityService communityService = communityServiceMapper.selectByPrimaryKey(serviceId);
                if(communityService != null){
                    merchantInfo = openMerchantInfoMapper.selectByPrimaryKey(communityService.getMerchantId());
                }else{
                    validator(merchantInfo.getStatus() == null, "数据不存在!");
                }
            }else{
                validator(merchantInfo.getStatus() == null, "数据不存在!");
            }
            int status = merchantInfo.getStatus();
            validator(status != Constant.merchantInfo.status.normal, "该商家资料正在富慧通审核中，请等待富慧通审批通过后再试。对审核进度有疑问请联系平台商务同事解决。");
        }
    }

}
