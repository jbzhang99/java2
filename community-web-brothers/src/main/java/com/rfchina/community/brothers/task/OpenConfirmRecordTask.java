package com.rfchina.community.brothers.task;

import com.alibaba.fastjson.JSONArray;
import com.rfchina.api.response.ResponseData;
import com.rfchina.community.brothers.entity.SettleConfirm;
import com.rfchina.community.brothers.mapper.ext.ExtPayConfirmRecordMapper;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.persistence.mapper.PayConfirmRecordMapper;
import com.rfchina.community.persistence.model.OpenOrder;
import com.rfchina.community.persistence.model.PayConfirmRecord;
import com.rfchina.community.persistence.model.PayConfirmRecordExample;
import com.rfchina.community.service.openser.OpenOrderSerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 确认结算
 * 
 * @author fukangwen
 *
 */
//@Component
public class OpenConfirmRecordTask {

	@Autowired
	private PayConfirmRecordMapper payConfirmRecordMapper;
	@Autowired
	private ExtPayConfirmRecordMapper extPayConfirmRecordMapper;
	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;

	@Autowired
	private OpenOrderSerService openOrderSerService;


	private static transient Logger logger = LoggerFactory.getLogger(OpenConfirmRecordTask.class);


	@Scheduled(initialDelay = 6000, fixedDelay = 2 * 60 * 1000L)
	public void runTask() throws Exception{
		logger.info("---------ConfirmRecordTask-----");
		long start = System.currentTimeMillis();
		int limit = 20;
		List<PayConfirmRecord> list = extPayConfirmRecordMapper.getPayConfirmRecordList(limit);

		List<SettleConfirm> confirmList = new ArrayList<SettleConfirm>();
		for(int i = 0; i < list.size(); i++){
			PayConfirmRecord record = list.get(i);
			SettleConfirm confirm = new SettleConfirm();
			confirm.setBill_id(record.getBillId());
			confirm.setType(record.getType());

			PayConfirmRecordExample example = new PayConfirmRecordExample();
			example.createCriteria().andOrigBillIdEqualTo(record.getBillId());
			List<PayConfirmRecord> refundList = payConfirmRecordMapper.selectByExample(example);
			if(!refundList.isEmpty()) {
				List<SettleConfirm> refundConfirmList = new ArrayList<SettleConfirm>();
				PayConfirmRecord refund = refundList.get(0);
				SettleConfirm refundConfirm = new SettleConfirm();
				refundConfirm.setBill_id(refund.getBillId());
				refundConfirm.setType(refund.getType());
				refundConfirmList.add(refundConfirm);
				confirm.setRefund_bill_list(refundConfirmList);
			}
			confirmList.add(confirm);
			String bills = JSONArray.toJSONString(confirmList);
			logger.info(bills);
			ResponseData<Map<String, Object>>  respone = platformGlobalComponent.settleConfirm(bills);
			record.setResultStatus(respone.getCode());
			record.setRemark(respone.getMsg());
			record.setScanStatus(1);
			record.setScanTime(new Date());
			payConfirmRecordMapper.updateByPrimaryKeySelective(record);



			OpenOrder openOrder = openOrderSerService.getOpenOrderByMerchantBillId(record.getBillId());
			if(openOrder != null) {
				//更新订单确认时间
				SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", java.util.Locale.US);
				Date date = sdf.parse(String.valueOf(respone.getData().get("settlable_time")));
				openOrder.setBillSplitTime(date);
				openOrderSerService.updateOpenOrderByPrimaryKey(openOrder);
			}
			confirmList.clear();
		}
		logger.info("---------ConfirmRecordTask-----end time{}", System.currentTimeMillis() - start);
	}



}
