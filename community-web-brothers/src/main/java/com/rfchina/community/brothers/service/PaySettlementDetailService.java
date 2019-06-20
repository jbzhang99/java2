package com.rfchina.community.brothers.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.pay.FuPayGetSettlementApplyDataListResponseModel;
import com.rfchina.api.response.model.pay.FuPayGetSettlementApplyDetailResponseModel;
import com.rfchina.api.response.model.pay.base.FuPaySettlementDetailModel;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.persistence.mapper.PaySettlementDetailMapper;
import com.rfchina.community.persistence.mapper.PaySettlementInfoMapper;
import com.rfchina.community.persistence.model.PaySettlementDetail;
import com.rfchina.community.persistence.model.PaySettlementDetailExample;
import com.rfchina.community.persistence.model.PaySettlementInfo;
import com.rfchina.community.persistence.model.PaySettlementInfoExample;
import com.rfchina.community.service.IPaySettlement;
import com.rfchina.community.service.IPaySettlementDetail;

@Service
public class PaySettlementDetailService implements ApplicationContextAware {

	private static Logger logger = LoggerFactory.getLogger(PaySettlementDetailService.class);

	@Autowired
	private PaySettlementDetailMapper paySettlementDetailMapper;

	@Autowired
	private PaySettlementInfoMapper paySettlementInfoMapper;
	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;

	/// v1/pay/settle/apply
	// 发起结算
	public void syncSettlement() {
		// 拿回全部订单.
		PaySettlementInfoExample example = new PaySettlementInfoExample();
		List<Integer> values = new ArrayList<>();
		values.add(1);
		values.add(4);
		example.createCriteria().andMyStatusIn(values);
		example.setOrderByClause("my_create_time");
		List<PaySettlementInfo> datas = paySettlementInfoMapper.selectByExample(example);
		for (PaySettlementInfo apply : datas) {
			String sid = apply.getId();
			String myId = apply.getMyId();
			int myStatus = apply.getMyStatus();
			updatePaySettlementDetail(apply.getMyType(), sid, myId, myStatus);
		}

	}

	public void updatePaySettlementDetail(String type, String sid, String myId, int myStatus) {

		if (myStatus == 4) {
			PaySettlementDetailExample ele = new PaySettlementDetailExample();
			ele.createCriteria().andSidEqualTo(sid);
			paySettlementDetailMapper.deleteByExample(ele);
		}

		PaySettlementInfo record = new PaySettlementInfo();
		record.setMyStatus(2);
		record.setId(sid);
		paySettlementInfoMapper.updateByPrimaryKeySelective(record);

		int limit = 50;
		Boolean stat = false;
		record = new PaySettlementInfo();
		record.setMyStatus(3);
		record.setId(sid);
		for (int i = 0;; i++) {
			ResponseData<FuPayGetSettlementApplyDataListResponseModel> data = platformGlobalComponent
					.fuPayGetSettlementApplyDataListRequest(sid, limit, i * limit, stat);
			if (data.getCode() != 1001) {
				record.setMyStatus(4);
				break;
			}
			for (FuPaySettlementDetailModel model : data.getData().getList()) {
				logger.info("98564154897,type:{},myId:{},sid:{},json{}", type, myId, sid, JSON.toJSONString(model));
				PaySettlementDetail r = new PaySettlementDetail();
				Map<String, IPaySettlementDetail> maps = applicationContext.getBeansOfType(IPaySettlementDetail.class);
				r.setMyCompare(1);
				for (Entry<String, IPaySettlementDetail> bill : maps.entrySet()) {
					boolean aaa = bill.getValue().settlemetDetail(type, myId, model);
					if (aaa) {
						r.setMyCompare(2);
					}
				}
				r.setMyCreateTime(new Date());
				BeanUtils.copyProperties(model, r);
				paySettlementDetailMapper.insertSelective(r);
			}
			if (data.getData().getList().size() < limit) {
				break;
			}
		}
		paySettlementInfoMapper.updateByPrimaryKeySelective(record);
	}

	ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}

}
