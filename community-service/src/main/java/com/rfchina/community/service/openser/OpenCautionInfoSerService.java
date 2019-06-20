package com.rfchina.community.service.openser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceTempMapper;
import com.rfchina.community.persistence.mapper.OpenCautionInfoMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.CommunityServiceExample;
import com.rfchina.community.persistence.model.CommunityServiceTemp;
import com.rfchina.community.persistence.model.CommunityServiceTempExample;
import com.rfchina.community.persistence.model.OpenCautionInfo;
import com.rfchina.community.persistence.model.OpenCautionInfoExample;
import com.rfchina.community.service.BaseService;

@Service
public class OpenCautionInfoSerService extends BaseService {
	private static Logger logger = LoggerFactory.getLogger(OpenCautionInfoSerService.class);

	@Autowired
	private OpenCautionInfoMapper openCautionInfoMapper;

	@Autowired
	private CommunityServiceTempMapper communityServiceTempMapper;

	@Autowired
	private CommunityServiceMapper communityServiceMapper;

	public JSONObject cautionHandle(Integer serviceId, boolean audit) {
		// int PAID = 1; //已缴
		// int UNPAID = 2; //未缴
		// int REFUND = 3; //已退保证金
		// int EXPERIENCING=4;//服务体验中
		// int REPLENISH=5;//待补交
		// 权限检查
		// authorityCheck(serviceId);
		// 验证参数

		// '1,待缴纳,2,已线上缴纳,3线下缴纳待核验,4已线下缴纳,5隐藏,6已退'
		OpenCautionInfoExample example = new OpenCautionInfoExample();
		example.createCriteria().andServiceIdEqualTo(serviceId).andStatusNotEqualTo(5);
		example.setOrderByClause("id desc");
		List<OpenCautionInfo> list = openCautionInfoMapper.selectByExample(example);

		CommunityService cs = communityServiceMapper.selectByPrimaryKey(serviceId);
		if(cs==null) {
			logger.error("serviceId:{}",serviceId);
			return null;
		}
		if (cs.getCautionMoneyStatus() == 2 && !audit) {
			JSONObject json = new JSONObject();
			json.put("caution", new ArrayList<>());
			int cautionMoneyStatus = 2;
			json.put("cautionMoneyStatus", cautionMoneyStatus);
			json.put("cautionMoneyStatusTitle", OpenConstant.CautionMoneyStatus.translate(cautionMoneyStatus));
			json.put("paidCautionMoney", 0);
			json.put("receivableCautionMoney", 0);
			return json;
		}

		// 0初始化 1已缴 //2未缴//3已退保证金(没有这个自己一个属性)//4服务体验中//5待补交
		int cautionMoneyStatus = 4;
		// 已缴保证金：
		BigDecimal paidCautionMoney = new BigDecimal(0);
		// 应缴保证金：
		BigDecimal receivableCautionMoney = new BigDecimal(0);

		for (OpenCautionInfo coution : list) {
			if (cautionMoneyStatus == 4) {
				cautionMoneyStatus = 2;
			}
			if (coution.getStatus() == 2 || coution.getStatus() == 4) {
				paidCautionMoney = paidCautionMoney.add(coution.getMoney());
				cautionMoneyStatus = 5;
			}
			receivableCautionMoney = receivableCautionMoney.add(coution.getMoney());
		}
		//
		if (receivableCautionMoney.compareTo(new BigDecimal(0)) == 0) {
			// if (paidCautionMoney.compareTo(new BigDecimal(0)) == 0) {
			cautionMoneyStatus = 4;
			// } else {
			// cautionMoneyStatus = 2;
			// }
		} else {
			if (receivableCautionMoney.compareTo(paidCautionMoney) == 0) {
				cautionMoneyStatus = 1;
			} else {
				cautionMoneyStatus = 5;
			}
		}

		CommunityService record = new CommunityService();
		record.setId(serviceId);
		record.setCautionMoneyStatus(cautionMoneyStatus);
		record.setPaidCautionMoney(paidCautionMoney);
		record.setReceivableCautionMoney(receivableCautionMoney);
		CommunityServiceExample exam = new CommunityServiceExample();
		exam.createCriteria().andIdEqualTo(serviceId);
		communityServiceMapper.updateByExampleSelective(record, exam);
		CommunityServiceTemp record1 = new CommunityServiceTemp();
		record1.setId(serviceId);
		record1.setCautionMoneyStatus(cautionMoneyStatus);
		record1.setPaidCautionMoney(paidCautionMoney);
		record1.setReceivableCautionMoney(receivableCautionMoney);
		CommunityServiceTempExample example1 = new CommunityServiceTempExample();
		// 0初始化 1已缴 //2未缴//3已退保证金(没有这个自己一个属性)//4服务体验中//5待补交
		example1.createCriteria().andIdEqualTo(serviceId);
		communityServiceTempMapper.updateByExampleSelective(record1, example1);

		JSONObject json = new JSONObject();
		json.put("caution", list);
		json.put("cautionMoneyStatus", cautionMoneyStatus);
		json.put("cautionMoneyStatusTitle", OpenConstant.CautionMoneyStatus.translate(cautionMoneyStatus));
		json.put("paidCautionMoney", paidCautionMoney);
		json.put("receivableCautionMoney", receivableCautionMoney);
		return json;
	}
}
