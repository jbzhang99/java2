package com.rfchina.community.service.openser;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.OpenFeeOrderMapper;
import com.rfchina.community.persistence.mapper.OpenFeeOrderPayMapper;
import com.rfchina.community.persistence.mapper.OpenFeeOrderRelaMapper;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.mapper.ext.ExtOpenFeeOrderPayMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.OpenFeeOrderPay;
import com.rfchina.community.persistence.model.OpenFeeOrderRelaExample;
import com.rfchina.community.persistence.model.OpenFeeOrderRelaKey;
import com.rfchina.community.persistence.model.OpenFeeOrderWithBLOBs;
import com.rfchina.community.persistence.model.OpenMerchantInfo;
import com.rfchina.community.persistence.model.ext.ExtOpenFeeOrderPay;
import com.rfchina.community.persistence.model.ext.SimOpenFeeOrder;
import com.rfchina.community.service.BaseService;

@Service
public class OpenFeeOrderPayService extends BaseService {

	private static Logger logger = LoggerFactory.getLogger(OpenFeeOrderPayService.class);
	@Autowired
	private OpenFeeOrderPayMapper openFeeOrderPayMapper;
	@Autowired
	private OpenFeeOrderMapper openFeeOrderMapper;
	@Autowired
	private ExtOpenFeeOrderPayMapper extOpenFeeOrderPayMapper;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;
	@Autowired
	private OpenFeeOrderRelaMapper openFeeOrderRelaMapper;

	/**
	 * @param endCreateTime 
	 * @param startCreateTime 
	 * @param outTradeNo 
	 * @param payStatus 
	 * @param merchantName 
	 * @author:fukangwen
	 * @Description: 商家缴费记录,serviceId可为空
	 * @return void
	 * @throws
	 */
	public PageList<ExtOpenFeeOrderPay> listFeeOrderPay(Integer serviceId, String merchantName, String payStatus, String outTradeNo,
			Date startCreateTime, Date endCreateTime, int index, int size) {
		
		PageBounds pageBounds = new PageBounds(index, size);
		
		Map<String, Object> param = new HashMap<>();
		if(serviceId != null && serviceId > 0) {
			param.put("serviceId", serviceId);
		}
		if (StringUtils.isNotBlank(merchantName)) {
			param.put("merchantName", "%"+merchantName+"%");
		}
		if (StringUtils.isNotBlank(payStatus)) {
			param.put("payStatus", payStatus);
		}
		if (StringUtils.isNotBlank(outTradeNo)) {
			param.put("outTradeNo", "%"+outTradeNo+"%");
		}
		if (startCreateTime != null) {
			param.put("startCreateTime", startCreateTime);
		}
		if (endCreateTime != null) {
			param.put("endCreateTime", endCreateTime);
		}
		
		PageList<ExtOpenFeeOrderPay> list = extOpenFeeOrderPayMapper.pageByCondition(param, pageBounds);
		
		return list;
	}
	
	/**
	 * @author:fukangwen
	 * @Description: domain2Vo
	 * @return ExtOpenFeeOrderPay
	 * @throws
	 */
	private ExtOpenFeeOrderPay domain2Vo(OpenFeeOrderPay pay) {
		ExtOpenFeeOrderPay extPay = new ExtOpenFeeOrderPay();
		BeanUtils.copyProperties(pay, extPay);
		CommunityService service = communityServiceMapper.selectByPrimaryKey(pay.getServiceId());
		if(service != null) {
			extPay.setServiceName(service.getTitle());
			OpenMerchantInfo merchant = openMerchantInfoMapper.selectByPrimaryKey(service.getMerchantId());
			extPay.setMerchantName(merchant == null ? "" : merchant.getTitle());
		}
		return extPay;
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 商家缴费详情
	 * @return void
	 * @throws
	 */
	public ExtOpenFeeOrderPay getFeeOrderPayDetail(long feeOrderPayId) {
		OpenFeeOrderPay pay = openFeeOrderPayMapper.selectByPrimaryKey(feeOrderPayId);
		validator(pay == null, "缴费记录不存在"+feeOrderPayId);
		ExtOpenFeeOrderPay extPay = domain2Vo(pay);
		
		//TODO 增加其他属性
		extPay.setOrderList(this.getOrderList(pay.getId()));
		return extPay;
	}
	
	private List<SimOpenFeeOrder> getOrderList(long feeOrderPayId){
		OpenFeeOrderRelaExample example = new OpenFeeOrderRelaExample();
		example.createCriteria().andPayIdEqualTo(feeOrderPayId);
		example.setOrderByClause("fee_id desc");
		List<OpenFeeOrderRelaKey> relaList = openFeeOrderRelaMapper.selectByExample(example);
		
		List<SimOpenFeeOrder> simList = new ArrayList<SimOpenFeeOrder>();
		for(OpenFeeOrderRelaKey key : relaList) {
			OpenFeeOrderWithBLOBs fee = openFeeOrderMapper.selectByPrimaryKey(key.getFeeId());
			SimOpenFeeOrder sim = new SimOpenFeeOrder();
			BeanUtils.copyProperties(fee, sim);
			simList.add(sim);
		}
		return simList;
	}
}
