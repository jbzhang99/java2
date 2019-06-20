package com.rfchina.community.openapi.service;

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

import com.rfchina.community.openapi.entity.ExtOpenSettlementApply;
import com.rfchina.community.openapi.mapper.ext.ExtOpenSettlementApplyMapper;
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
	
	
	public PageList<ExtOpenSettlementApply> getSettlementApplyList(Date startCreateTime , Date endCreateTime , int type,int merchantId, int status , int invoiceStatus , String settlementId , int index, int size){
		
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
		
		PageBounds pageBounds = new PageBounds(index, size, Order.formString("create_time.desc"));
		
		return extOpenSettlementApplyMapper.pageByCondition(param, pageBounds);
	}
	
	
	public OpenSettlementApply getOpenSettlementApply(int id){
		return openSettlementApplyMapper.selectByPrimaryKey(id);
	}
	
	
	public void updateOpenSettlementApply(OpenSettlementApply openSettlementApply){
		openSettlementApplyMapper.updateByPrimaryKeySelective(openSettlementApply);
	}
	
	
	public List<OpenSettlementApply> getOpenSettlementApplyList(Date startTime , Date endTime , int serviceId){
		
		OpenSettlementApplyExample example = new OpenSettlementApplyExample();
		example.createCriteria().andSettlementStartTimeEqualTo(startTime).andSettlementEndTimeEqualTo(endTime).andServiceIdEqualTo(serviceId);
		
		return openSettlementApplyMapper.selectByExample(example);
	}
}
