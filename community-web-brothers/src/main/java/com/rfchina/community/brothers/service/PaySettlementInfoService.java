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

@Service
public class PaySettlementInfoService implements ApplicationContextAware {

	private static Logger logger = LoggerFactory.getLogger(PaySettlementInfoService.class);

	@Autowired
	private PaySettlementInfoMapper paySettlementInfoMapper;
	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;

	public void syncStatus() {
		PaySettlementInfoExample e = new PaySettlementInfoExample();
		List<Integer> v = new ArrayList<>();
		v.add(2);
		v.add(4);// '结算确认状态, 1:未确认, 2:已撤消, 3:撤消中 4:已确认, 5:确认中'
		e.createCriteria().andConfirmStatusNotIn(v);
		List<PaySettlementInfo> list = paySettlementInfoMapper.selectByExample(e);
		for (PaySettlementInfo info : list) {
			ResponseData<FuPayGetSettlementApplyDetailResponseModel> res = platformGlobalComponent
					.getSettlementApplyDetail(info.getId());
			if (res.getCode() == 1001) {
				FuPayGetSettlementApplyDetailResponseModel detail = res.getData();
				if (info.getConfirmStatus() != detail.getConfirmStatus()) {
					Map<String, IPaySettlement> maps = applicationContext.getBeansOfType(IPaySettlement.class);
					for (Entry<String, IPaySettlement> bill : maps.entrySet()) {
						logger.info("test" + bill.getValue() + info.getMyType() + info.getMyId() + detail.toString());
						boolean temp = bill.getValue().settlemetApply(info.getMyType(), info.getMyId(), detail);
						if (temp) {
							PaySettlementInfo base = new PaySettlementInfo();
							BeanUtils.copyProperties(detail, base);
							paySettlementInfoMapper.updateByPrimaryKeySelective(base);
						}
					}

				}
			}
		}
	}

	ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}

}
