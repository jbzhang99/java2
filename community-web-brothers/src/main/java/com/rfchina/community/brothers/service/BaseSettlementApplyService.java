package com.rfchina.community.brothers.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.pay.FuPayGetSettlementApplyDataListResponseModel;
import com.rfchina.api.response.model.pay.FuPayGetSettlementApplyDetailResponseModel;
import com.rfchina.api.response.model.pay.base.FuPaySettlementDetailModel;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.persistence.mapper.BaseSettlementApplyMapper;
import com.rfchina.community.persistence.mapper.CommunityMapper;
import com.rfchina.community.persistence.mapper.CommunityPayMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceRelaMapper;
import com.rfchina.community.persistence.mapper.PaySettlementDetailMapper;
import com.rfchina.community.persistence.model.BaseSettlementApply;
import com.rfchina.community.persistence.model.BaseSettlementApplyExample;
import com.rfchina.community.persistence.model.PaySettlementDetail;

/**
 * 基础服务的结算同步
 * 
 * @author liyicun
 *
 */
@Service
public class BaseSettlementApplyService {

	private static Logger logger = LoggerFactory.getLogger(BaseSettlementApplyService.class);
	@Autowired
	private CommunityPayMapper communityPayMapper;

	@Autowired
	private BaseSettlementApplyMapper baseSettlementApplyMapper;

	@Autowired
	private CommunityServiceMapper communityServiceMapper;

	@Autowired
	private CommunityMapper communityMapper;
	@Autowired
	private PaySettlementDetailMapper paySettlementDetailMapper;

	@Autowired
	private CommunityServiceRelaMapper communityServiceRelaMapper;
	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;

	/// v1/pay/settle/apply
	// 发起结算
	public void syncSettlementApply() {

		BaseSettlementApplyExample example = new BaseSettlementApplyExample();
		example.createCriteria().andStatusEqualTo(1);
		example.setOrderByClause("id");
		List<BaseSettlementApply> datas = baseSettlementApplyMapper.selectByExample(example);
		for (BaseSettlementApply apply : datas) {
			BaseSettlementApply record = new BaseSettlementApply();
			record.setStatus(2);
			record.setId(apply.getId());
			baseSettlementApplyMapper.updateByPrimaryKeySelective(record);
			String sid = apply.getSettleId();
			int limit = 50;
			Boolean stat = false;
			record = new BaseSettlementApply();
			record.setStatus(3);
			record.setId(apply.getId());
			for (int i = 0;; i++) {
				ResponseData<FuPayGetSettlementApplyDataListResponseModel> data = platformGlobalComponent
						.fuPayGetSettlementApplyDataListRequest(sid, limit, i * limit, stat);
				if (data.getCode() != 1001) {
					record.setStatus(4);
					break;
				}
				for (FuPaySettlementDetailModel d : data.getData().getList()) {
					logger.info("i:{},limit{},json{}", i, limit, JSON.toJSONString(d));
					PaySettlementDetail r = new PaySettlementDetail();
					r.setMyCompare(1);
					r.setMyCreateTime(new Date());
					BeanUtils.copyProperties(d, r);
					paySettlementDetailMapper.insertSelective(r);
				}
				if (data.getData().getList().size() < limit) {
					break;
				}
			}
			baseSettlementApplyMapper.updateByPrimaryKeySelective(record);
		}

	}

	public void syncStatus() {
		BaseSettlementApplyExample e = new BaseSettlementApplyExample();
		// '结算确认状态, 1:未确认, 2:已撤消, 3:撤消中 4:已确认, 5:确认中'
		e.createCriteria().andSettleStatusNotIn(Arrays.asList(2,4));
		List<BaseSettlementApply> list = baseSettlementApplyMapper.selectByExample(e);
		for (BaseSettlementApply baseSettlementApply : list) {
			if (StringUtils.isBlank(baseSettlementApply.getSettleId())) {
				logger.error("syncStatus baseSettlementApply:{}", JSON.toJSONString(baseSettlementApply));
				continue;
			}
			ResponseData<FuPayGetSettlementApplyDetailResponseModel> res = platformGlobalComponent
					.getSettlementApplyDetail(baseSettlementApply.getSettleId());
			if (res.getCode() == 1001) {
				FuPayGetSettlementApplyDetailResponseModel detail = res.getData();
				if (baseSettlementApply.getSettleStatus() != detail.getConfirmStatus()) {
					BaseSettlementApply base = new BaseSettlementApply();
					base.setId(baseSettlementApply.getId());
					base.setSettleStatus(detail.getConfirmStatus());
					base.setApproveComment(StringUtils.isBlank(detail.getConfirmComment()) ? detail.getRevokeComment()
							: detail.getConfirmComment());
					baseSettlementApplyMapper.updateByPrimaryKeySelective(base);
				}
			}
		}
	}

}
