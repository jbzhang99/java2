package com.rfchina.community.openapi.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.OpenPointRecordMapper;
import com.rfchina.community.persistence.model.OpenPointRecord;

/**
 * @author:fukangwen
 * @Description: 积分记录service
 */
@Service
public class OpenPointRecordService {
	
	@Autowired
	private OpenPointRecordMapper openPointRecordMapper;
	@Autowired
	private OpenConfService openConfService;
	
	/**
	 * @param bigDecimal 
	 * @author:fukangwen
	 * @Description: 插入积分记录，默认未发送
	 * @return void
	 * @throws
	 */
	public void insert(Long uid, Long orderId, BigDecimal totalAmount) {
		OpenPointRecord record = new OpenPointRecord();
		
		Boolean canGive = openConfService.getCodeByType(OpenConfService.Type.POINT.toString());
		record.setOpenConfCode(canGive == true ? "1" : "0");
		
		Boolean firstCanGive = openConfService.getCodeByType(OpenConfService.Type.FIRST_POINT.toString());
		record.setOpenConfFirstCode(firstCanGive == true ? "1" : "0");
		
		record.setOrderId(orderId);
		record.setUid(uid);
		record.setStatus(Status.NOT_SEND.getCode());
		record.setCreateTime(new Date());
		record.setTotalAmount(totalAmount);
//		record.setTotalAmount(totalAmount.multiply(new BigDecimal(100))); 测试使用
		openPointRecordMapper.insert(record);
		
	}
	
	public enum Status{
		
		NOT_SEND(0),SEND(1),BACK(2);
		private int code;
		Status(int code) {
			this.code = code;
		}
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
	}
}
