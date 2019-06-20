package com.rfchina.community.openweb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.Order;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.Constant;
import com.rfchina.community.openweb.entity.ExtOpenSettlementApply;
import com.rfchina.community.openweb.mapper.ext.ExtOpenSettlementApplyMapper;
import com.rfchina.community.persistence.mapper.OpenSettlementApplyMapper;
import com.rfchina.community.persistence.model.OpenSettlementApply;
import com.rfchina.community.persistence.model.OpenSettlementApplyExample;

@Service
public class OpenSettlementApplyService {

	@Autowired
	private OpenSettlementApplyMapper openSettlementApplyMapper;
	
	@Autowired
	private ExtOpenSettlementApplyMapper extOpenSettlementApplyMapper;
	
	public void addSettlementApply(OpenSettlementApply openSettlementApply){
		openSettlementApplyMapper.insertSelective(openSettlementApply);
	}
	
	
	public PageList<ExtOpenSettlementApply> getSettlementApplyList(Date startCreateTime , Date endCreateTime , int type,long merchantId, int status , int invoiceStatus , String settlementId , int index, int size){
		
		Map<String, Object> param = new HashMap<>();
		
		if(startCreateTime != null){
			param.put("startCreateTime", startCreateTime);
		}
		
		if(endCreateTime != null){
			param.put("endCreateTime", endCreateTime);
		}
		
		if(merchantId > 0){
			param.put("merchantId", merchantId);
		}
		
		if(status > 0){
			param.put("status", status);
		}
		
		if(invoiceStatus > 0){
			param.put("invoiceStatus", invoiceStatus);
		}
		
		if(StringUtils.isNotBlank(settlementId)){
			param.put("settlementId", settlementId);
		}
		
		if(type > 0){
			param.put("type", type);
		}
		
		PageBounds pageBounds = new PageBounds(index, size);
		
		return extOpenSettlementApplyMapper.pageByCondition(param, pageBounds);
	}
	
	
	public OpenSettlementApply getOpenSettlementApply(int id){
		return openSettlementApplyMapper.selectByPrimaryKey(id);
	}
	
	
	public void updateOpenSettlementApply(OpenSettlementApply openSettlementApply){
		openSettlementApplyMapper.updateByPrimaryKeySelective(openSettlementApply);
	}
	
	
	public List<OpenSettlementApply> getOpenSettlementApplyList(Date startTime , Date endTime , int serviceId , int type){
		
		OpenSettlementApplyExample example = new OpenSettlementApplyExample();
		example.createCriteria().andServiceIdEqualTo(serviceId).andTypeEqualTo(type).andStatusEqualTo(0);
		
		return openSettlementApplyMapper.selectByExample(example);
	}
	
	public List<OpenSettlementApply> getOpenSettlementApplyList(Date startTime , Date endTime , int serviceId){
		
		OpenSettlementApplyExample example = new OpenSettlementApplyExample();
		example.createCriteria().andSettlementStartTimeEqualTo(startTime).andSettlementEndTimeEqualTo(endTime).andServiceIdEqualTo(serviceId);
		
		return openSettlementApplyMapper.selectByExample(example);
	}
	
	
	public OpenSettlementApply getOpenSettlementApply(String settlementId){
		OpenSettlementApplyExample example = new OpenSettlementApplyExample();
		example.createCriteria().andSettlementIdEqualTo(settlementId);
		
		List<OpenSettlementApply> list = openSettlementApplyMapper.selectByExample(example);
		
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		
		return null;
	}
	
	
	public List<OpenSettlementApply> getSettlementDate(int serviceId , Long merchantId){
		
		List<Integer> statusList = new ArrayList<>();
		statusList.add(0);
		statusList.add(Constant.OpenAdmin.SettlementApplyStatus.CANCEL_APPLY);
		statusList.add(Constant.OpenAdmin.SettlementApplyStatus.PAY_CENTER_NOTPASS);
		statusList.add(Constant.OpenAdmin.SettlementApplyStatus.PLATFORM_NOTPASS);
		
		OpenSettlementApplyExample example = new OpenSettlementApplyExample();
		example.setOrderByClause("settlement_start_time");
		example.createCriteria().andServiceIdEqualTo(serviceId).andMerchantIdEqualTo(merchantId).andStatusIn(statusList).andTypeEqualTo(Constant.OpenAdmin.SettlementApplyType.MERCHANT);
		
		return openSettlementApplyMapper.selectByExample(example);
	}
}
