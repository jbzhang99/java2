package com.rfchina.community.brothers.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.brothers.mapper.ext.ExtOpenPointRecordMapper;
import com.rfchina.community.persistence.mapper.OpenFirstPointRecordMapper;
import com.rfchina.community.persistence.mapper.OpenPointRecordMapper;
import com.rfchina.community.persistence.model.OpenFirstPointRecord;
import com.rfchina.community.persistence.model.OpenPointRecord;
import com.rfchina.community.persistence.model.OpenPointRecordExample;
import com.rfchina.platform.common.utils.DateUtil;
import com.rfchina.platform.common.http.HttpUtil;

/**
 * @author:fukangwen
 * @Description: 积分记录service
 */
@Service
public class OpenPointRecordService {
	
	@Autowired
	private OpenPointRecordMapper openPointRecordMapper;
	@Autowired
	private ExtOpenPointRecordMapper extOpenPointRecordMapper;
	@Autowired
	private OpenFirstPointRecordService openFirstPointRecordService;
	@Autowired
	private OpenFirstPointRecordMapper openFirstPointRecordMapper;
	@Value("${community.app.api}")
	private String serverUrl;
	@Value("${point.limit.money}")
	private String LIMIT_MONEY;//超过10元才送积分 
	private static Logger logger = LoggerFactory.getLogger(OpenPointRecordService.class);
	
	//private String changeBonusPoint = serverUrl + "/api/community/changeBonusPoint";
	//private String reverseBonusPoint = serverUrl + "/api/community/reverseBonusPoint";
	
//	private String changeBonusPoint = "http://192.168.197.28:10401/api/community/changeBonusPoint";
//	private String reverseBonusPoint = "http://192.168.197.28:10401/api/community/reverseBonusPoint";
	
	public static int CODE_VALID = 1;//有效 
	public static int CODE_INVALID = 0;//无效 
	/**
	 * @author:fukangwen
	 * @Description: 定时扫描加积分
	 * @return void
	 * @throws
	 */
	public void checkAndIncreasePoint(String serverUrl) {
		List<OpenPointRecord> list = extOpenPointRecordMapper.increasePointList(new BigDecimal(LIMIT_MONEY));
		logger.info("checkAndIncreasePoint and list.size = {}", list.size());
		for(OpenPointRecord record : list) {
			
			if(Integer.parseInt(record.getOpenConfCode()) == CODE_INVALID) {
				logger.info("the order : {} can't give point because the ON/OFF is closed",record.getOrderId());
				continue;
			}
			
			String serialNumber = postChangeBonusPoint(record.getUid(), Action.open_pay.toString(), 
					String.valueOf(record.getTotalAmount().intValue()), serverUrl);//调用加积分接口，
			if(StringUtils.isBlank(serialNumber)) {
				logger.info("the order : {} can't increase  point because changeBonusPoint failed");
				continue;
			}
			
			//更改该记录状态，回写流水号
			record.setSerialNumber(serialNumber);
			record.setStatus(Status.SEND.getCode());
			openPointRecordMapper.updateByPrimaryKeySelective(record);
			
			//检查首单
			checkOrIncreaseFirstPoint(record, serverUrl);
		}
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 加首单积分
	 * @return void
	 * @throws
	 */
	private void checkOrIncreaseFirstPoint(OpenPointRecord record, String serverUrl) {
		
		if(Integer.parseInt(record.getOpenConfFirstCode()) == CODE_INVALID) {
			logger.info("the order : {} can't give first point because the ON/OFF is closed",record.getOrderId());
			return;
		}
		
		//判断是不是首次下单
		if(openFirstPointRecordService.isFirst(record.getUid())) {
			//调用加积分接口，
			String serialNumber = postChangeBonusPoint(record.getUid(), Action.open_pay_first.toString(), 
					String.valueOf(record.getTotalAmount().intValue()), serverUrl);

			//调用减积分接口,更改该记录状态
			if(StringUtils.isBlank(serialNumber)) {
				logger.info("the order : {} can't increase  first point because changeBonusPoint failed");
				return;
			}
			
			//首次下单加单次积分，增加首次下单记录，包括流水号
			openFirstPointRecordService.insert(record.getUid(), record.getOrderId(), serialNumber);
		}
	}
	
	
	/**
	 * @author:fukangwen
	 * @Description: 定时扫描扣积分
	 * @return void
	 * @throws
	 */
	public void checkAndDecreasePoint(String serverUrl) {
		List<OpenPointRecord> list = extOpenPointRecordMapper.decreasePointList();
		logger.info("checkAndDecreasePoint and list.size = {}", list.size());
		for(OpenPointRecord record : list) {
			//调用减积分接口,更改该记录状态
			if(StringUtils.isBlank(record.getSerialNumber())) {
				logger.info("the order : {} can't give back point because serialNumber is blank",record.getOrderId());
				continue;
			}
			
			//调用扣积分接口
			Boolean isSuccess = postReverseBonusPoint(record.getUid(), Action.open_pay.toString(), record.getSerialNumber(),
					serverUrl);
			if(!isSuccess) {
				logger.info("the order : {} can't decrease point because reverseBonusPoint failed");
				continue;
			}
			
			//更新记录状态
			record.setStatus(Status.BACK.getCode());
			openPointRecordMapper.updateByPrimaryKeySelective(record);
			
			//扣首次积分
			this.checkOrDecreaseFirstPoint(record, serverUrl);
		}
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 扣首单积分
	 * @return void 
	 * @throws
	 */
	private void checkOrDecreaseFirstPoint(OpenPointRecord record, String serverUrl) {
		OpenFirstPointRecord openFirstPointRecord = openFirstPointRecordService.getByUidAndOrderId(record.getUid(), record.getOrderId());
		if(openFirstPointRecord != null && StringUtils.isNotBlank(openFirstPointRecord.getSerialNumber())){
			//调用扣积分接口
			Boolean isSuccess = postReverseBonusPoint(openFirstPointRecord.getUid(), Action.open_pay_first.toString(),
					openFirstPointRecord.getSerialNumber(), serverUrl);
			if(!isSuccess) {
				logger.info("the order : {} can't decrease first point because reverseBonusPoint failed");
				return;
			}
			openFirstPointRecord.setStatus(OpenFirstPointRecordService.Status.BACK.getCode());
			openFirstPointRecordMapper.updateByPrimaryKeySelective(openFirstPointRecord);
		}
		
	}
	
	
	/**
	 * @author:fukangwen
	 * @Description: 发送加积分
	 * @return String
	 * @throws
//	 */
	public String postChangeBonusPoint(Long uid, String action, String totalAmount, String serverUrl) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("uid", String.valueOf(uid));
		params.put("action", action);
		params.put("time", DateUtil.formatDate(new Date()));
		params.put("totalAmount", totalAmount);
		String responeData = HttpUtil.post(serverUrl + "/api/community/changeBonusPoint", params);
		JSONObject json = JSON.parseObject(responeData);
		if (200 != json.getIntValue("status")) {
			logger.info("加积分失败：{}", responeData);
			return null;
		}
		return String.valueOf(json.getIntValue("data"));
	}
	
	
	/**
	 * @author:fukangwen
	 * @Description: 发送减积分
	 * @return String
	 * @throws
	 */
	public Boolean postReverseBonusPoint(Long uid, String action, String pointDetailId, String serverUrl) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("uid", String.valueOf(uid));
		params.put("pointDetailId", pointDetailId);
		params.put("action", action);
		params.put("time", DateUtil.formatDate(new Date()));
		String responeData = HttpUtil.post(serverUrl + "/api/community/reverseBonusPoint", params);
		JSONObject json = JSON.parseObject(responeData);
		if (200 != json.getIntValue("status")) {
			logger.info("减积分失败：{}", responeData);
			return false;
		}
		return true;
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
	
	public enum Action{
		open_pay, open_pay_first;
	}
}
