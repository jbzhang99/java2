package com.rfchina.community.brothers.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.brothers.service.OpenPointRecordService.Status;
import com.rfchina.community.persistence.mapper.OpenFirstPointRecordMapper;
import com.rfchina.community.persistence.model.OpenFirstPointRecord;
import com.rfchina.community.persistence.model.OpenFirstPointRecordExample;
import com.rfchina.community.persistence.model.OpenPointRecordExample;

/**
 * @author:fukangwen
 * @Description: 首次送积分记录service
 */
@Service
public class OpenFirstPointRecordService {
	
	@Autowired
	private OpenFirstPointRecordMapper openFirstPointRecordMapper;
	
	private static Logger logger = LoggerFactory.getLogger(OpenFirstPointRecordService.class);
	/**
	 * @author:fukangwen
	 * @Description: 插入首次积分记录
	 * @return void
	 * @throws
	 */
	public void insert(Long uid, Long orderId, String serialNumber) {
		OpenFirstPointRecord record = new OpenFirstPointRecord();
		record.setOrderId(orderId);
		record.setStatus(Status.SEND.getCode());
		record.setCreateTime(new Date());
		record.setUid(uid);
		record.setSerialNumber(serialNumber);
		openFirstPointRecordMapper.insert(record);
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 判断该订单是不是首单
	 * @return Boolean
	 * @throws
	 */
	public Boolean isFirst(Long uid) {
		OpenFirstPointRecordExample example = new OpenFirstPointRecordExample();
		example.createCriteria().andUidEqualTo(uid);
		return openFirstPointRecordMapper.countByExample(example) > 0 ? false : true;
	}
	
//	/**
//	 * @author:fukangwen
//	 * @Description: 插入或更新
//	 * @return void
//	 * @throws
//	 */
//	public void insertOrUpdate(int uid, int orderId, String serialNumber) {
//		OpenFirstPointRecordExample example = new OpenFirstPointRecordExample();
//		example.createCriteria().andUidEqualTo(uid);
//		List<OpenFirstPointRecord> list = openFirstPointRecordMapper.selectByExample(example);
//		if(list.isEmpty()) {
//			this.insert(uid, orderId, serialNumber);
//			return;
//		}
//		
//		OpenFirstPointRecord record = list.get(0);
//		if(Status.BACK.getCode() == record.getStatus()) {//扣过积分，重置为已发送
//			record.setStatus(Status.SEND.getCode());
//			record.setSerialNumber(serialNumber);
//			openFirstPointRecordMapper.updateByPrimaryKeySelective(record);
//		}
//	}
	
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

	/**
	 * @author:fukangwen
	 * @Description: 获取该用户首次下单赠送记录,已送状态
	 * @return OpenFirstPointRecord
	 * @throws
	 */
	public OpenFirstPointRecord getByUidAndOrderId(Long uid, Long orderId) {
		OpenFirstPointRecordExample example = new OpenFirstPointRecordExample();
		example.createCriteria().andUidEqualTo(uid).andOrderIdEqualTo(orderId).andStatusEqualTo(Status.SEND.getCode());
		List<OpenFirstPointRecord> list = openFirstPointRecordMapper.selectByExample(example);
		if(list.isEmpty())
			return null;
		return list.get(0);
	}
}
