package com.rfchina.community.brothers.task;

import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.brothers.mapper.ext.OpenStatsBroMapper;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * 第三方服务统计
 * 
 * @author liyicun
 *
 */
//@Component
public class OpenStatsTask {

	@Autowired
	private OpenStatsBroMapper openStatsBroMapper;

	private static transient Logger logger = LoggerFactory.getLogger(OpenStatsTask.class);

	// 正常单据
	@Scheduled(cron = "20 30 0 * * ?")
	public void runTask() {

		Date statDate = new Date();
		statDate = DateUtils.addDays(statDate, -1);
		int i = 0;
		i = openStatsBroMapper.deleteOpenStatsOrder(statDate);
		logger.info("deleteOpenStatsOrder:{},i:{}", DateTimeUtils.formatDateTime(statDate), i);
		i = openStatsBroMapper.updataOpenStatsOrder(statDate);
		logger.info("updataOpenStatsOrder:{},i:{}", DateTimeUtils.formatDateTime(statDate), i);
		//更新到当前日期订单数
		
		//更新到当前日期
		
		i = openStatsBroMapper.deleteOpenStatsMerchant(statDate);
		logger.info("deleteOpenStatsMerchant:{},i:{}", DateTimeUtils.formatDateTime(statDate), i);
		i = openStatsBroMapper.updateOpenStatsMerchant(statDate);
		logger.info("updateOpenStatsMerchant:{},i:{}", DateTimeUtils.formatDateTime(statDate), i);
		i = openStatsBroMapper.updateOpenStatsMerchant11(statDate);
		logger.info("updateOpenStatsMerchant11:{},i:{}", DateTimeUtils.formatDateTime(statDate), i);
		i = openStatsBroMapper.updateOpenStatsMerchant12(statDate);
		logger.info("updateOpenStatsMerchant12:{},i:{}", DateTimeUtils.formatDateTime(statDate), i);
		i = openStatsBroMapper.updateOpenStatsMerchant21(statDate);
		logger.info("updateOpenStatsMerchant21:{},i:{}", DateTimeUtils.formatDateTime(statDate), i);
		i = openStatsBroMapper.updateOpenStatsMerchant22(statDate);
		logger.info("updateOpenStatsMerchant22:{},i:{}", DateTimeUtils.formatDateTime(statDate), i);
	}

}
