package com.rfchina.community.openweb.service;

import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.mch.MchModel;
import com.rfchina.api.response.model.mch.MchResponseModel;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenXFSJConstant;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.persistence.model.OpenMerchantInfo;
import com.rfchina.community.service.openser.OpenMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MerchantInfoService extends OpenMerchantService{

	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;

	/**
	 * 同步商家信息
	 */
	public void sysMerchantInfo(String userToken, String mchId, Long uid, String remark){
		ResponseData<MchResponseModel> responseData = platformGlobalComponent.getMchDetail(userToken, mchId);
		if(responseData.getCode() != 1001){
			logger.error("同步信息出错,原因为：{}", responseData.getCode());
			return;
		}
		MchModel model = responseData.getData().getMch();
		OpenMerchantInfo record = openMerchantInfoMapper.selectByPrimaryKey(uid);
		if(record == null){
			record = new OpenMerchantInfo();
			if(OpenXFSJConstant.XFSJPlatformType.xfsj.equals(remark)){
				record.setXfsjStatus(1);
			}else{
				record.setXfsjStatus(0);
			}
			record.setId(uid);
			record.setMchId(model.getId());
		}
		copyProperties(record,model);
		record.setStatus(this.translateStatus(record.getStatus()));
		updateMerchantInfo(record);
	}

	//平台1:审批中, 2:审批通过, 3:审批失败, 4:禁用
	private int translateStatus(int status){
		if(status == 1){
			return Constant.merchantInfo.status.approval;
		}else if(status == 2){
			return Constant.merchantInfo.status.normal;
		}else if(status == 3){
			return Constant.merchantInfo.status.unpass;
		}else if(status == 4){
			return Constant.merchantInfo.status.disabled;
		}
		return 0;
	}


	public Long createMerchantIfNoExist(String mchId, String remark, String userName){
		OpenMerchantInfo record = new OpenMerchantInfo();
			if(OpenXFSJConstant.XFSJPlatformType.xfsj.equals(remark)){
				record.setXfsjStatus(1);
			}else{
				record.setXfsjStatus(0);
			}
			record.setType(0);//默认都不是
			record.setMchId(mchId);
			record.setTitle(userName);
			record.setCreateTime(new Date());
			record.setUpdateTime(record.getCreateTime());
			// 1正常 2审批中,3审批不通过,4草稿,5禁用
			record.setStatus(Constant.merchantInfo.status.approval);
			record.setUserName(userName);
			record.setAuditStatus(String.valueOf(Constant.merchantInfo.auditStatus.approval));
		    openMerchantInfoMapper.insertSelective(record);
			return record.getId();
	}
}
