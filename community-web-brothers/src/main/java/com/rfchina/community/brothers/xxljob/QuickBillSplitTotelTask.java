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
 * 闪付拆单
 * 
 * @author liyicun
 *
 */
@JobHandler(value = "brothers-QuickBillSplitTotelTask")
@Component
public class QuickBillSplitTotelTask extends IJobHandler{

	@Autowired
	private OpenOrderTotalMapper openOrderTotalMapper;

	@Autowired
	private OpenServiceTotalBillSplitService openServiceTotalBillSplitService;

	private static transient Logger logger = LoggerFactory.getLogger(QuickBillSplitTotelTask.class);

	@Value("${service.3.task.billsplit:false}")
	private String taskFalg;

	@Value("${app.environment}")
	private String environment;


	// 闪付的拆单
	//0 0/30 * * * ?
	public void runTaskQuickOrder() {
		logger.debug("Begin to run [runTaskQuickOrder] 闪付拆单");

		if (!"true".equalsIgnoreCase(taskFalg)) {
			logger.info(" is  not run {} , {}", taskFalg, new Date());
			return;
		} else {
			logger.info("------------runTaskQuickOrder----runTask------");
		}
		// 查询15天前的没有拆单的订单数据
		Date date = DateUtils.addHours(new Date(), -12);
		// logger.debug("拆单开始");

		OpenOrderTotalExample example = new OpenOrderTotalExample();
		example.createCriteria().andBillSplitStatusEqualTo(2).andTypeEqualTo(5)
				// 退款,
				.andRefundCountEqualTo(0).andCreateTimeLessThanOrEqualTo(date).andBillStatusEqualTo(2);
		List<OpenOrderTotal> list = openOrderTotalMapper.selectByExample(example);
		logger.info("runTaskQuickOrder  is run {} , {},size:{}", taskFalg, date, list.size());
		if (list != null && list.size() > 0) {
			// 进行拆单
			for (OpenOrderTotal openOrderTotal : list) {
				openServiceTotalBillSplitService.splitBillTotal(openOrderTotal, false);
			}
		}
		logger.debug("Finish [runTaskQuickOrder] 闪付拆单");

	}


	@Override
	public ReturnT<String> execute(String s) throws Exception {
		this.runTaskQuickOrder();
		return ReturnT.SUCCESS;
	}
}
