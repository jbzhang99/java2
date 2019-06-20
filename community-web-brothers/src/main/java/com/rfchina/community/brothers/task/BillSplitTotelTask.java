package com.rfchina.community.brothers.task;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.persistence.mapper.OpenOrderTotalMapper;
import com.rfchina.community.persistence.model.OpenOrderTotal;
import com.rfchina.community.persistence.model.OpenOrderTotalExample;
import com.rfchina.community.service.openser.OpenServiceTotalBillSplitService;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 拆单 合并支付的拆单
 * 
 * @author liyicun
 *
 */
//@Component
public class BillSplitTotelTask {

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
	@Scheduled(cron = "0 17 * * * ?") // test
	public void runTask() {
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

	}

	// 闪付的拆单
	@Scheduled(initialDelay = 80000, fixedDelay = 30 * 60 * 1000L)
	public void runTaskQuickOrder() {
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

	}

	// 退单但是被拒绝的需要拆单

	// 每一个一个小时才拆一次 退单但是被拒绝的需要拆单
	@Scheduled(initialDelay = 20000, fixedDelay = 4 * 60 * 1000L)
	public void runTaskRefund() {
		if (!"true".equalsIgnoreCase(taskFalg)) {
			logger.info("BillSplitTask    is  not run {} , {}", taskFalg, new Date());
			return;
		} else {
			logger.info("------------BillSplitTotelTask--runTaskRefund--------");
		}

		// 查询15天前的没有拆单的订单数据

		Calendar now = Calendar.getInstance();
		if ("test".equalsIgnoreCase(environment)) {
			// 测试环境修改为1天拆单
			now.set(Calendar.DATE, now.get(Calendar.DATE) - 1);
		} else {
			now.set(Calendar.DATE, now.get(Calendar.DATE) - 15);
		}

		// Date1.after(Date2),当Date1大于Date2时，返回TRUE，当小于等于时，返回false；
		// Date1.before(Date2)，当Date1小于Date2时，返回TRUE，当大于等于时，返回false；

		Date datetime = now.getTime();
		// 17点之后都不能退款了,所以直接全部拆单.
		if (datetime.after(DateTimeUtils.date(datetime, OpenConstant.SPLIT_BATCH_TIME, 0, 0))) {
			datetime = DateTimeUtils.date(datetime, 23, 59, 59);
		}

		// now.set(Calendar.HOUR_OF_DAY, 23);
		// now.set(Calendar.MINUTE, 59);
		// now.set(Calendar.SECOND, 59);
		// logger.debug("拆单开始");

		OpenOrderTotalExample example = new OpenOrderTotalExample();
		example.createCriteria().andBillSplitStatusEqualTo(2)
				// 退款,
				.andRefundCountGreaterThan(0).andCreateTimeLessThanOrEqualTo(now.getTime()).andBillStatusEqualTo(2);
		List<OpenOrderTotal> list = openOrderTotalMapper.selectByExample(example);
		logger.info("BillSplitTotelTask refund is run {} , {},size:{}", taskFalg,
				DateTimeUtils.formatDateTime(now.getTime()), list.size());
		if (list != null && list.size() > 0) {
			// 进行拆单
			for (OpenOrderTotal openOrderTotal : list) {
				openServiceTotalBillSplitService.splitBillTotal(openOrderTotal, false);
			}
		}

	}
}
