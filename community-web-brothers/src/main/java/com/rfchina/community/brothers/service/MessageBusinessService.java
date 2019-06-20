package com.rfchina.community.brothers.service;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.mch.MchModel;
import com.rfchina.api.response.model.mch.MchResponseModel;
import com.rfchina.community.base.Constant;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.persistence.model.OpenMerchantInfo;
import com.rfchina.community.service.BaseService;
import com.rfchina.community.service.openser.OpenMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName MessageBusinessService
 * @Description MQ消息业务处理
 * @Author wlrllr
 * @Date 2019/1/4 11:02
 * @Version 1.0
 **/
@Service
public class MessageBusinessService extends BaseService {

    @Autowired
    private OpenMerchantService openMerchantService;
    @Autowired
    private PlatformGlobalComponent platformGlobalComponent;

    /**
     * @Author wlrllr
     * @Description //审核时，修改商家状态
     * @Date 2019/1/4
     * @Param [data]
     * @return boolean
     **/
    public boolean auditStatusChange(JSONObject data) {
        try{
            if (data != null) {
                String mchId = data.getString("id");
                Integer status = data.getInteger("status");
                OpenMerchantInfo openMerchantInfo = getMerchantInfo(mchId);
                openMerchantInfo.setAuditStatus(String.valueOf(status));
                openMerchantInfo.setStatusContent(data.getString("audit_msg"));
                if (openMerchantInfo.getId() == null) {
                    logger.warn("...找不到商家，新增商家信息 param:{}", openMerchantInfo);
                    if(openMerchantInfo.getType() != null){
                        return openMerchantService.addMerchantInfo(openMerchantInfo);
                    }
                }else{
                    return openMerchantService.updateMerchantInfo(openMerchantInfo);
                }
            }
        }catch (Exception e){
            logger.error("审核商家时，同步商家信息异常",e);
        }
        return false;
    }

    private OpenMerchantInfo getMerchantInfo(String merchantId) {
        OpenMerchantInfo record = openMerchantService.getMerchantByMchId(merchantId);
        ResponseData<MchResponseModel> responseData = platformGlobalComponent.getMchDetailForBusiness(merchantId);
        if (responseData.getCode() != 1001) {
            logger.error("同步信息出错,原因为：code:{},msg:{}", responseData.getCode(),responseData.getMsg());
            return record;
        }
        MchModel model = responseData.getData().getMch();
        if(model != null){
            record.setMchId(model.getId());
            int type = model.getType().intValue();
            record.setType(type);
            if(type == 2){
                record.setTitle(model.getRespPerName());
            }else if(type == 1){
                record.setTitle(model.getMchName());
            }
            openMerchantService.copyProperties(record,model);
            record.setTel(model.getTel());
            int status = model.getStatus().intValue();
            //1:审批中, 2:审批通过, 3:审批失败, 4:禁用',
            if(status == 1){
                record.setStatus(Constant.merchantInfo.status.approval);
            }else if(status == 2){
                record.setStatus(Constant.merchantInfo.status.normal);
            }else if(status == 3){
                record.setStatus(Constant.merchantInfo.status.unpass);
            }else if(status == 4){
                record.setStatus(Constant.merchantInfo.status.disabled);
            }
        }
        return record;
    }
}
