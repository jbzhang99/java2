package com.rfchina.community.open.bridge.controller.platform;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.Constant;
import com.rfchina.community.persistence.mapper.CommunityServiceTempMapper;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.model.CommunityServiceTemp;
import com.rfchina.community.persistence.model.CommunityServiceTempExample;
import com.rfchina.community.persistence.model.OpenMerchantInfo;
import com.rfchina.community.persistence.model.OpenMerchantInfoExample;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.service.OpenMerchantInfoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class OpenMerchantInfoPFController extends BaseController {

	@Autowired
	private OpenMerchantInfoService openMerchantInfoService;
	@Autowired
	private CommunityServiceTempMapper communityServiceTempMapper;
	@Autowired
	protected OpenMerchantInfoMapper openMerchantInfoMapper;

	@RequestMapping(value = { "/searchMerchantInfoList" }, method = { RequestMethod.POST })
	public Result<?> getMerchantInfoList(
			@RequestParam("keyword") String keyword) {
		return Result.successData(openMerchantInfoService.searchMerchantInfoList(keyword));
	}

	@RequestMapping(value = {"/listOpenMerchantInfo"})
	public Result<?> listOpenMerchantInfo(@RequestParam(defaultValue = "1") int index, @RequestParam(defaultValue = "20") int size, String title,
										  String bankAccount, String bankAccountName, String bankTitle, String contactPhone) {
		PageBounds pageBounds = new PageBounds(index, size);
		OpenMerchantInfoExample example = new OpenMerchantInfoExample();
		OpenMerchantInfoExample.Criteria cr = example.createCriteria();
		if (StringUtils.isNotBlank(title)) {
			cr.andTitleLike("%" + title + "%");
		}
		if (StringUtils.isNotBlank(bankAccount)) {
			cr.andBankAccountLike("%" + bankAccount + "%");
		}
		if (StringUtils.isNotBlank(bankAccountName)) {
			cr.andBankAccountNameLike("%" + bankAccountName + "%");
		}
		if (StringUtils.isNotBlank(bankTitle)) {
			cr.andBankTitleLike("%" + bankTitle + "%");
		}
		if (StringUtils.isNotBlank(contactPhone)) {
			cr.andContactPhoneLike("%" + contactPhone + "%");
		}
		//
//		cr.andStatusIn(Arrays.asList(Constant.merchantInfo.status.normal, Constant.merchantInfo.status.disabled));
		example.setOrderByClause("update_time desc");
		PageList<OpenMerchantInfo> pager = openMerchantInfoMapper.pageByExample(example, pageBounds);
		List<JSONObject> list=new ArrayList<>();

		for (OpenMerchantInfo openMerchantInfo : pager) {
			JSONObject sys = (JSONObject) JSON.toJSON(openMerchantInfo);
			CommunityServiceTempExample e11 = new CommunityServiceTempExample();
			e11.createCriteria().andMerchantIdEqualTo(openMerchantInfo.getId())
					.andStatusNotEqualTo(Constant.OpenAdmin.CommunityServiceGroundStatus.DELETE);
			List<CommunityServiceTemp> list1 = communityServiceTempMapper.selectByExample(e11);
			sys.put("serviceList", list1);
			sys.put("serviceCount", list1.size());
			list.add(sys);
		}
		return Result.successData(new PageList<>(list, pager.getPaginator()).convert());
	}
}
