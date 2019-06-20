package com.rfchina.community.openweb.service;

import com.alibaba.fastjson.JSON;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.app.CreateAppResponseModel;
import com.rfchina.api.response.model.pay.FuPayAddAccountResponseModel;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.exception.WorkRunTimeException;
import com.rfchina.community.entity.communityService.ExtCommunityServiceTemp;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.persistence.model.CommunityService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommunityServiceService extends com.rfchina.community.component.CommunityServiceComponent {

	@Autowired
	private CommunityServiceTempMapper communityServiceTempMapper;

	@Autowired
	private OpenServiceDetailMapper openServiceDetailMapper;

	@Autowired
	private CommunityServiceMapper communityServiceMapper;

	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;
	@Autowired
	private CommunityPayMapper communityPayMapper;

	public List<ExtCommunityServiceTemp> getCommunityServiceTempList(int merchantId) {
		return getCommunityServiceTempList(0, null, null, merchantId, 0, 0, null, null, 1, 10);
	}

	public void addCommunityServiceTemp(CommunityServiceTemp communityServiceTemp) {
		communityServiceTempMapper.insertSelective(communityServiceTemp);
	}

	public CommunityServiceTemp getCommunityServiceTempByPrimaryKey(int serviceId) {
		return communityServiceTempMapper.selectByPrimaryKey(serviceId);
	}

	public void updateCommunityServiceTemp(CommunityServiceTemp communityServiceTemp) {
		communityServiceTempMapper.updateByPrimaryKeySelective(communityServiceTemp);
	}

	public CommunityService getCommunityServiceByPrimaryKey(int serviceId) {
		return communityServiceMapper.selectByPrimaryKey(serviceId);
	}

	public void addCommunityService(CommunityService communityService) {
		communityServiceMapper.insertSelective(communityService);
	}

	public void updateCommunityService(CommunityService communityService) {
		communityServiceMapper.updateByPrimaryKeySelective(communityService);
	}

	public List<CommunityServiceTemp> getCommunityServiceTemp(String title) {
		CommunityServiceTempExample example = new CommunityServiceTempExample();
		example.createCriteria().andTitleEqualTo(title).andStatusNotEqualTo(Constant.OpenAdmin.CommunityServiceGroundStatus.DELETE);

		return communityServiceTempMapper.selectByExample(example);
	}

	public long getCommunityServiceTempCount(Long merchantId) {
		CommunityServiceTempExample example = new CommunityServiceTempExample();
		example.createCriteria().andMerchantIdEqualTo(merchantId)
				.andStatusNotEqualTo(Constant.OpenAdmin.CommunityServiceGroundStatus.DELETE);

		return communityServiceTempMapper.countByExample(example);
	}

	public ExtCommunityServiceTemp getCommunityServiceTempInfo(int serviceId) {
		List<ExtCommunityServiceTemp> list = getCommunityServiceTempList(serviceId, null, null, 0, 0, 0, null, null, 1,
				10);

		if (list != null && list.size() > 0) {
			return list.get(0);
		}

		return null;
	}

	public OpenServiceDetail getOpenServiceDetail(Integer serviceId) {
		return openServiceDetailMapper.selectByPrimaryKey(serviceId);
	}

	public void insertORUpdateOpenServiceDetail(OpenServiceDetail detail) {

		Integer serviceId = detail.getServiceId();
		OpenServiceDetail data = getOpenServiceDetail(serviceId);
		if (data == null) {
			openServiceDetailMapper.insertSelective(detail);
		} else {
			openServiceDetailMapper.updateByPrimaryKeySelective(detail);
		}
	}

	@Autowired
	private PlatformService platformService;

	private static Logger logger = LoggerFactory.getLogger(CommunityServiceService.class);

	public CreateAppResponseModel createAppResponseModel(String title, String description, String link) {
//		URL url;
//		try {
//			url = new URL(link);
//		} catch (MalformedURLException e) {
//			logger.error(e.getMessage(), e);
//			throw new WorkRunTimeException("错误:" + link + e.getMessage());
//		}
//	domain=url.getHost();
		CreateAppResponseModel createAppResponseModel = platformService.createApp("自在-开放-" + title, 3, "1002", "0101",
				description, 120 * 60, 4, 1, null, null, "", "", 1, 1);
		return createAppResponseModel;
	}

	//
	public void createAppidAndSecret(Integer serviceId, String title, String description, String link) {
		CreateAppResponseModel createAppResponseModel = createAppResponseModel(title, description, link);
		validator(createAppResponseModel == null, "创建平台应用失败");
		CommunityServiceTemp communityServiceTemp = new CommunityServiceTemp();
		communityServiceTemp.setAppId(createAppResponseModel.getAppId());
		communityServiceTemp.setAppSecret(createAppResponseModel.getAppSecret());
		communityServiceTemp.setId(serviceId);
		communityServiceTemp.setLink(link);
		communityServiceTemp.setUpdateTime(new Date());
		updateCommunityServiceTemp(communityServiceTemp);
		//
		CommunityService communityService1 = new CommunityService();
		communityService1.setId(serviceId);
		communityService1.setLink(link);
		communityService1.setUpdateTime(new Date());
		communityService1.setAppId(createAppResponseModel.getAppId());
		communityService1.setAppSecret(createAppResponseModel.getAppSecret());
		updateCommunityService(communityService1);
		// 审核应用

	}

	public void completeNotifyUrl(Integer serviceId, Long mid, String title, String notifyUrl) {

		OpenMerchantInfo minfo = openMerchantInfoMapper.selectByPrimaryKey(mid);
		validator(minfo == null, "没有数据!");
		String mchid = minfo.getMchId();
		validator(StringUtils.isBlank(mchid), "请联系管理员!" + mid);

		CommunityServiceTemp communityServiceTemp = new CommunityServiceTemp();
		communityServiceTemp.setId(serviceId);
		communityServiceTemp.setUpdateTime(new Date());
		communityServiceTemp.setAccountReceivableProject("模板服务");
		communityServiceTemp.setNotifyUrl(notifyUrl);
		updateCommunityServiceTemp(communityServiceTemp);
		//
		CommunityService communityService1 = new CommunityService();
		communityService1.setId(serviceId);
		communityService1.setUpdateTime(new Date());
		communityService1.setAccountReceivableProject("模板服务");
		communityService1.setNotifyUrl(notifyUrl);
		updateCommunityService(communityService1);

	}

	void validator(boolean fag, String msg) {
		if (fag) {
			throw new WorkRunTimeException(msg);
		}
	}

	//判断该收款账号是否被用了

	public Boolean getAccountHadUse(String account){
		CommunityServiceExample serviceExample = new CommunityServiceExample();
		serviceExample.createCriteria().andAccountIdEqualTo(account);
		long count = communityServiceMapper.countByExample(serviceExample);
		if(count > 0){
			return true;
		}
		CommunityPayExample payExample = new CommunityPayExample();
		payExample.createCriteria().andPayAccountEqualTo(account);
		payExample.or(new CommunityPayExample().createCriteria().andOpenPayAccountEqualTo(account));
		count = communityPayMapper.countByExample(payExample);
		if(count > 0){
			return true;
		}
		return false;
	}
}
