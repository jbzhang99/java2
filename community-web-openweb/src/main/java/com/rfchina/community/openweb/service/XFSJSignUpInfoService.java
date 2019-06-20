package com.rfchina.community.openweb.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.component.OpenAuditInfoComponent;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJBusinessInfoMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJInfoMapper;
import com.rfchina.community.persistence.mapper.OpenXfsjSignUpInfoMapper;
import com.rfchina.community.persistence.model.CommunityPay;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.OpenXFSJBusinessInfo;
import com.rfchina.community.persistence.model.OpenXFSJInfo;
import com.rfchina.community.persistence.model.OpenXfsjSignUpInfo;
import com.rfchina.community.persistence.model.OpenXfsjSignUpInfoExample;

@Service
public class XFSJSignUpInfoService extends BaseService {
	@Autowired
	private OpenXfsjSignUpInfoMapper openXfsjSignUpInfoMapper;
	@Autowired
	private OpenXFSJBusinessInfoMapper openXFSJBusinessInfoMapper;
	@Autowired
	private OpenXFSJInfoMapper openXFSJInfoMapper;
	@Autowired
	private OpenAuditInfoComponent openAuditInfoComponent;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private CommunityPayService communityPayService;
	
	/**
	 * @author:fukangwen
	 * @Description: 新增
	 * @return void
	 * @throws
	 */
	public long insert(Long uid, int serviceId, Long xfsjId, BigDecimal serviceFee
			, BigDecimal platformChargeRate, BigDecimal platformCharge, BigDecimal receiptAmount) {
		OpenXfsjSignUpInfo signUpInfo = new OpenXfsjSignUpInfo();
		signUpInfo.setCreateTime(new Date());
		signUpInfo.setUid(uid);
		signUpInfo.setServiceId(serviceId);
		signUpInfo.setXfsjId(xfsjId);
		signUpInfo.setServiceFee(serviceFee);
		signUpInfo.setStatus(OpenConstant.SignUpCheckStatus.CHECKING);//审核中
		
		signUpInfo.setPlatformChargeRate(platformChargeRate);
		signUpInfo.setPlatformCharge(platformCharge);
		signUpInfo.setReceiptAmount(receiptAmount);
		
		openXfsjSignUpInfoMapper.insert(signUpInfo);
		return signUpInfo.getId();
	}
	
	/**
	 * 报名
	 */
	@Transactional
	public void signUp(Long uid, int serviceId, Long xfsjId) {
		//判断报名时间是否已经截止
		OpenXFSJBusinessInfo openXFSJBusinessInfo = openXFSJBusinessInfoMapper.selectByPrimaryKey(xfsjId);
		validator(openXFSJBusinessInfo == null, "信息不存在");
		validator(openXFSJBusinessInfo.getSignUpEndTime() == null 
				|| openXFSJBusinessInfo.getSignUpEndTime().getTime() < (new Date()).getTime(), "报名已截止");
		
		//判断服务是否通过审核
		CommunityService communityService = communityServiceMapper.selectByPrimaryKey(serviceId);
		validator(communityService == null, "服务不存在");
		
		validator(communityService.getStatus() != Constant.OpenAdmin.CommunityServiceGroundStatus.GROUNDING,
				"您的店铺状态为下架中，无法报名活动");
		
		//判断是否报名了
		Boolean isSignUp = isSignUp(uid, serviceId, xfsjId);
		validator(isSignUp, "你已经报名");
		
		Long signUpNum = this.getSignUpNum(xfsjId);
		validator(openXFSJBusinessInfo.getAmount() == null || 
				signUpNum >= openXFSJBusinessInfo.getAmount(), "活动报名人数已满，请等待名额释放后再试,或者换个活动看看吧。");
		
		OpenXFSJInfo info = openXFSJInfoMapper.selectByPrimaryKey(xfsjId);
		
		int days = DateTimeUtils.daysBetween(info.getBeginTime(), info.getEndTime());
		BigDecimal total = openXFSJBusinessInfo.getServiceFee().multiply(new BigDecimal(days));
		
		//
		CommunityPay communityPay = communityPayService.getCommunityPay(info.getCommunityId());
		validator(communityPay == null || StringUtils.isBlank(communityPay.getPayAccount()), "社区结算账号还未生成,请联系管理员");
	
		// 平台手续费比例
		BigDecimal feeRate = communityPay.getFeeRate();
		// 平台手续费计算，单位元
		BigDecimal platformCharge = total.multiply(feeRate).setScale(2, BigDecimal.ROUND_HALF_DOWN);
		if (platformCharge.compareTo(new BigDecimal("0.01")) < 0) {
			// 手续费少于0.01元，不收取手续费
			platformCharge = new BigDecimal("0");
		}
		// 社区结算费用
		BigDecimal receiptAmount = total.subtract(platformCharge);
		
		validator(platformCharge.compareTo(total) >= 0, "系统错误");
		
		//新增
		long signUpId = this.insert(uid, serviceId, xfsjId, total, feeRate, platformCharge, receiptAmount);
		
		//加入审批列表
		openAuditInfoComponent.add(OpenAuditInfoComponent.ObjectType.xfsj_sign_up_apply, uid,
				String.valueOf(signUpId), null,OpenAuditInfoComponent.PageIdType.xfsj_sign_up);
	}
	
	
	
	/**
	 * 判断是否已经报名
	 */
	public Boolean isSignUp(Long uid, int serviceId, Long xfsjId) {
		List<Integer> statusList = new ArrayList<>();
		statusList.add(OpenConstant.SignUpCheckStatus.PASS);
		statusList.add(OpenConstant.SignUpCheckStatus.PAID);
		statusList.add(OpenConstant.SignUpCheckStatus.CHECKING);
		OpenXfsjSignUpInfoExample example = new OpenXfsjSignUpInfoExample();
		example.createCriteria().andUidEqualTo(uid).andXfsjIdEqualTo(xfsjId).andServiceIdEqualTo(serviceId)
			.andStatusIn(statusList);
		Long num = openXfsjSignUpInfoMapper.countByExample(example);
		if(num > 0)
			return true;
		return false;
	}
	
	/**
	 * 已报名数量,审核通过才报名称，才算报名数量
	 */
	public long getSignUpNum(Long xfsjId) {
		List<Integer> statusList = new ArrayList<>();
		statusList.add(OpenConstant.SignUpCheckStatus.PASS);
		statusList.add(OpenConstant.SignUpCheckStatus.PAID);
		OpenXfsjSignUpInfoExample example = new OpenXfsjSignUpInfoExample();
		example.createCriteria().andXfsjIdEqualTo(xfsjId).andStatusIn(statusList);
		return openXfsjSignUpInfoMapper.countByExample(example);
	}

}
