package com.rfchina.community.brothers.xxljob;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.persistence.mapper.OpenOrderTotalMapper;
import com.rfchina.community.persistence.model.OpenOrderTotal;
import com.rfchina.community.persistence.model.OpenOrderTotalExample;
import com.rfchina.community.service.openser.OpenServiceTotalBillSplitService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 普通订单拆单
 * 
 * @author liyicun
 *
 */
@JobHandler(value = "brothers-BillSplitTotelTask")
@Component
public class BillSplitTotelTask extends IJobHandler{

	@Autowired
	private OpenOrderTotalMapper openOrderTotalMapper;

	@Autowired
	private OpenServiceTotalBillSplitService openServiceTotalBillSplitService;

	private static transient Logger logger = LoggerFactory.getLogger(BillSplitTotelTask.class);

	@Value("${service.3.task.billsplit:false}")
	private String taskFalg;

	@Value("${app.environment}")
	private String environment;

	// 正常单据
	// @Scheduled(cron = "0 0 17 * * ?")
	public void runSplitBillTotalTask() {
		logger.debug("Begin to run [runSplitBillTotalTask] 合并支付的拆单");

		if (!"true".equalsIgnoreCase(taskFalg)) {
			logger.info(" is  not run {} , {}", taskFalg, new Date());
			return;
		} else {
			logger.info("------------BillSplitTotelTask----runTask------");
		}

		// 查询15天前的没有拆单的订单数据

		Calendar now = Calendar.getInstance();
		if ("test".equalsIgnoreCase(environment)) {
			// 测试环境修改为1天拆单
			now.set(Calendar.DATE, now.get(Calendar.DATE) - OpenConstant.TEST_BATCH_RUN_day);
		} else {
			now.set(Calendar.DATE, now.get(Calendar.DATE) - OpenConstant.public_BATCH_RUN_day);
		}
		now.set(Calendar.HOUR_OF_DAY, 23);
		now.set(Calendar.MINUTE, 59);
		now.set(Calendar.SECOND, 59);
		// logger.debug("拆单开始");

		OpenOrderTotalExample example = new OpenOrderTotalExample();
		example.createCriteria().andBillSplitStatusEqualTo(2).andTypeEqualTo(4)
				// 退款,
				.andRefundCountEqualTo(0).andCreateTimeLessThanOrEqualTo(now.getTime()).andBillStatusEqualTo(2);
		List<OpenOrderTotal> list = openOrderTotalMapper.selectByExample(example);
		logger.info("BillSplitTotelTask  is run {} , {},size:{}", taskFalg, now.getTime(), list.size());
		if (list != null && list.size() > 0) {
			// 进行拆单
			for (OpenOrderTotal openOrderTotal : list) {
				openServiceTotalBillSplitService.splitBillTotal(openOrderTotal, false);
			}
		}
		logger.debug("Finish [runSplitBillTotalTask] 合并支付的拆单");

	}


	@Override
	public ReturnT<String> execute(String s) throws Exception {
		this.runSplitBillTotalTask();
		return ReturnT.SUCCESS;
	}
}
