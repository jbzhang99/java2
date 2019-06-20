package com.rfchina.community.service.openser;

import com.alibaba.fastjson.JSON;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.pay.FuPayGetAccountResponseModel;
import com.rfchina.api.response.model.settle.SettlecApplyResponseModel;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.model.OpenSettCommunity;
import com.rfchina.community.persistence.model.PaySettlementInfo;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

//社区结算服务
@Service
public class OpenSettCommunityGlobalService {

	private static Logger logger = LoggerFactory.getLogger(OpenSettCommunityGlobalService.class);

	@Autowired
	private OpenOrderMapper openOrderMapper;
	@Autowired
	private OpenRefundMapper openRefundMapper;
	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;
	@Autowired
	private OpenSettCommunityMapper openSettCommunityMapper;
	@Autowired
	private PaySettlementInfoMapper paySettlementInfoMapper; 
	@Autowired
	private CommunityMapper communityMapper;

	@Value("${app.environment}")
	private String environment;

	public Integer singleCommunitySettl(Date startDate, Date endDate, long count, Integer communityId,
			String accountId, String name) {
		String title = name;
		OpenSettCommunity r = new OpenSettCommunity();
		r.setAccountId(accountId);
		r.setAuditComment("");
		r.setCommunityId(communityId);
		r.setCreateTime(new Date());
		r.setStartTime(startDate);
		r.setEndTime(endDate);
		// r.setMchId(mchId);
		r.setPfStatus(0);
		r.setStatus(0);
		r.setTitle(name);

		openSettCommunityMapper.insertSelective(r);
		Integer myid = r.getId();
		ResponseData<FuPayGetAccountResponseModel> model = platformGlobalComponent.getAccount(accountId);
		logger.info("syncServiceAccountNull count:{}, startDate:{}, endDate:{},model:{}", count,
				DateTimeUtils.formatDateTime(startDate), DateTimeUtils.formatDateTime(endDate),
				JSON.toJSONString(model));
		r = new OpenSettCommunity();
		r.setId(myid);
		if (model.getCode() == 1001) {
			FuPayGetAccountResponseModel data = model.getData();
			String mchId = data.getMchId();
			startDate = DateUtils.addDays(data.getLastSettleTime(), 1);
			title = name + "_[" + DateTimeUtils.formatDate(startDate) + "-" + DateTimeUtils.formatDate(endDate)
					+ "]自在服务社区服务费结算";
			if (startDate.after(endDate)) {

			}
			// bug5770 @李一村 @鱼蛋大叔 @冯小刚
			// 自在服务的结算标题，现在统一一下
			// 1、商家：
			// 【商家名称】_[【结算开始日期】-【结算截止日期】]_自在服务商家实收结算
			// 如：汕头发展有限公司_[2017-08-02-2017-08-17]_自在服务社区服务费结算
			//
			// 2、社区：
			// 【社区名称】_[【结算开始日期】-【结算截止日期】]_自在服务社区服务费结算
			// 如：富力金港城自_[2017-08-02-2017-08-17]_在服务社区服务费结算

			ResponseData<Map<String, Object>> responseModel = platformGlobalComponent.settlementApply(
					mchId, title, accountId, DateTimeUtils.formatDate(startDate), DateTimeUtils.formatDate(endDate));
			Integer pfStatus = 0;
			Map<String, Object> data1 = responseModel.getData();
			if (responseModel.getCode() == 1001) {

//				pfStatus = data1.getConfirmStatus();
				pfStatus = 3;//写死？？
				r.setSetId(String.valueOf(data1.get("sid")));
				r.setStatus(2);
			} else {
				r.setStatus(3);
				r.setAuditComment(responseModel.getCode() + ":" + responseModel.getMsg());
			}
			r.setTitle(title);
			r.setMchId(mchId);
			r.setPfStatus(pfStatus);
			r.setStartTime(startDate);
			r.setEndTime(endDate);
			openSettCommunityMapper.updateByPrimaryKeySelective(r);

			if (responseModel.getCode() == 1001) {
				PaySettlementInfo rs = new PaySettlementInfo();
				rs.setMyStatus(1);
				rs.setMyType("open_community");
				rs.setMyId(myid + "");
				rs.setMyCreateTime(new Date());
				rs.setId(String.valueOf(data1.get("sid")));
				rs.setConfirmStatus(1);//未确认
//				BeanUtils.copyProperties(responseModel.getData(), rs);
				paySettlementInfoMapper.insertSelective(rs);
			}
		} else {
			r.setStatus(4);
			r.setAuditComment(model.getCode() + ":" + model.getMsg());
			openSettCommunityMapper.updateByPrimaryKeySelective(r);
		}
		return myid;
	}
}
