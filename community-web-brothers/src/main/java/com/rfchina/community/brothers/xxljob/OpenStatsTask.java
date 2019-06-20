package com.rfchina.community.brothers.xxljob;

import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.brothers.mapper.ext.OpenStatsBroMapper;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 第三方服务统计
 * 
 * @author liyicun
 *
 */
@JobHandler(value = "brothers-OpenStatsTask")
@Component
public class OpenStatsTask extends IJobHandler{

	@Autowired
	private OpenStatsBroMapper openStatsBroMapper;

	private static transient Logger logger = LoggerFactory.getLogger(OpenStatsTask.class);

	// 正常单据
	public void runOpenStatsTask() {
		logger.debug("Begin to run [runOpenStatsTask] 第三方服务统计");

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

		logger.debug("Finish [runOpenStatsTask] 第三方服务统计");
	}

	@Override
	public ReturnT<String> execute(String s) throws Exception {
		this.runOpenStatsTask();
		return ReturnT.SUCCESS;
	}
}
