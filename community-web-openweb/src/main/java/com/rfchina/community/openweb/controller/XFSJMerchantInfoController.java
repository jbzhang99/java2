package com.rfchina.community.openweb.controller;

import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.mch.MchResponseModel;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.component.OpenAuditInfoComponent;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.openweb.entity.AdminUserInfo;
import com.rfchina.community.persistence.mapper.CommunityServiceTempMapper;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.CommunityServiceTemp;
import com.rfchina.community.persistence.model.CommunityServiceTempExample;
import com.rfchina.community.persistence.model.OpenMerchantInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENWEB)
public class XFSJMerchantInfoController extends BaseController {

	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;
	@Autowired
	private CommunityServiceTempMapper communityServiceTempMapper;
	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;

	@Autowired
	private OpenAuditInfoComponent openAuditInfoComponent;



	/**
	 * 重新提交审核信息
	 * @return
	 */
	@RequestMapping(value = { "/xfsj/updateAuditInfo" })
	public Result<?> saveXFSJStoreBannerUrl() throws Exception{
		AdminUserInfo adminInfo = getAdminInfo();
		Long adminid = adminInfo.getUid();
		OpenMerchantInfo merchant = openMerchantInfoMapper.selectByPrimaryKey(adminid);

		//判断支付中心商家是否审核通过,未通过的不创建审核信息
		ResponseData<MchResponseModel> resp = platformGlobalComponent.getMchDetail(adminInfo.getUserToken(), adminInfo.getMchId());
		validator(resp.getCode() != 1001, "商家资料还在审核中,请等待商家资料审核通过后再重新申请审核。");
		validator(resp.getData().getMch() == null , "商家资料还在审核中,请等待商家资料审核通过后再重新申请审核。");
		validator(resp.getData().getMchDraft().getStatus() == 2, "商家资料还在审核中,请等待商家资料审核通过后再重新申请审核。");//草稿审核状态，2为审批中
		//修改服务的状态
		CommunityServiceTempExample example = new CommunityServiceTempExample();
		example.createCriteria().andMerchantIdEqualTo(adminid);
		List<CommunityServiceTemp> list = communityServiceTempMapper.selectByExample(example);
		validator(list.isEmpty(), "审核服务不存在");
		CommunityServiceTemp serviceTemp = list.get(0);
		Integer serviceId = serviceTemp.getId();

		validator(serviceTemp.getAuditStatus() != Constant.OpenAdmin.CommunityServiceAuditStatus.AUDIT_NOTPASS, "商家资料还在审核中,请等待商家资料审核通过后再重新申请审核。");
		serviceTemp.setStatus(Constant.OpenAdmin.CommunityServiceGroundStatus.UNGROUNDING);
		serviceTemp.setAuditStatus(Constant.OpenAdmin.CommunityServiceAuditStatus.AUDIT);
		serviceTemp.setGroundAuditStatus(Constant.OpenAdmin.CommunityServiceGroundAuditStatus.AUDIT);
		communityServiceTempMapper.updateByPrimaryKeySelective(serviceTemp);

		CommunityService communityService = new CommunityService();
		communityService.setId(serviceId);
		communityService.setStatus(Constant.OpenAdmin.CommunityServiceGroundStatus.UNGROUNDING);
		communityService.setAuditStatus(Constant.OpenAdmin.CommunityServiceAuditStatus.AUDIT);
		communityService.setGroundAuditStatus(Constant.OpenAdmin.CommunityServiceGroundAuditStatus.AUDIT);
		communityServiceService.updateCommunityService(communityService);

		//添加审核信息
		openAuditInfoComponent.add(OpenAuditInfoComponent.ObjectType.xfsj_provider_apply,
				adminid, serviceId.toString(),
				serviceId, adminid, OpenAuditInfoComponent.PageIdType.xfsj_register);

		return Result.success();
	}

}
