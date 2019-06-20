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
 * 退单但是被拒绝的需要拆单
 * @author liyicun
 *
 */
@JobHandler(value = "brothers-BillSplitRefundTotelOrderTask")
@Component
public class BillSplitRefundTotelOrderTask extends IJobHandler{

	@Autowired
	private OpenOrderTotalMapper openOrderTotalMapper;

	@Autowired
	private OpenServiceTotalBillSplitService openServiceTotalBillSplitService;

	private static transient Logger logger = LoggerFactory.getLogger(BillSplitRefundTotelOrderTask.class);

	@Value("${service.3.task.billsplit:false}")
	private String taskFalg;

	@Value("${app.environment}")
	private String environment;

	// 退单但是被拒绝的需要拆单

	// 每一个一个小时才拆一次 退单但是被拒绝的需要拆单
	// 0 0/4 * * * ?
	public void runTaskRefund() {
		logger.debug("Begin to run [runTaskRefund] 退单但是被拒绝的需要拆单");

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
		logger.debug("Finish [runTaskRefund] 退单但是被拒绝的需要拆单");
	}

	@Override
	public ReturnT<String> execute(String s) throws Exception {
		this.runTaskRefund();
		return ReturnT.SUCCESS;
	}
}
