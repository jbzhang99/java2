package com.rfchina.community.openapi.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.OpenFirstPointRecordMapper;
import com.rfchina.community.persistence.model.OpenFirstPointRecord;
import com.rfchina.community.persistence.model.OpenFirstPointRecordExample;

/**
 * @author:fukangwen
 * @Description: 首次送积分记录service
 */
@Service
public class OpenFirstPointRecordService {
	
	@Autowired
	private OpenFirstPointRecordMapper openFirstPointRecordMapper;
	@Autowired
	private OpenConfService openConfService;
	private static transient Logger logger = LoggerFactory.getLogger(OpenFirstPointRecordService.class);
	/**
	 * @author:fukangwen
	 * @Description: 插入首次积分记录
	 * @return void
	 * @throws
	 */
	private void insert(Long uid, Long orderId) {
		OpenFirstPointRecord record = new OpenFirstPointRecord();
		record.setOrderId(orderId);
		record.setStatus(Status.SEND.getCode());
		record.setCreateTime(new Date());
		record.setUid(uid);
		openFirstPointRecordMapper.insert(record);
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 插入或更新
	 * @return void
	 * @throws
	 */
	public void insertOrUpdate(Long uid, Long orderId, Boolean canGive) {
		if(!canGive) {
			logger.info("can't give point because the on/off is closed");
			return;
		}
		OpenFirstPointRecordExample example = new OpenFirstPointRecordExample();
		example.createCriteria().andUidEqualTo(uid).andOrderIdEqualTo(orderId);
		List<OpenFirstPointRecord> list = openFirstPointRecordMapper.selectByExample(example);
		if(list.isEmpty()) {
			this.insert(uid, orderId);
		}
		OpenFirstPointRecord record = list.get(0);
		if(Status.BACK.getCode() == record.getStatus()) {//扣过积分，重置为未发送
			record.setStatus(Status.SEND.getCode());
			openFirstPointRecordMapper.updateByPrimaryKeySelective(record);
		}
	}
	
	public enum Status{
		
		SEND(1),BACK(2);
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
