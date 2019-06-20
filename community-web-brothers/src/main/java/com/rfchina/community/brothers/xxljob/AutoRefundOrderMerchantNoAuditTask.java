package com.rfchina.community.brothers.xxljob;

import com.rfchina.community.brothers.service.OpenRefundService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *  同步商家未审核的单据，三天未审核则自动提交到支付中心
 */
@JobHandler(value = "brothers-AutoRefundOrderMerchantNoAuditTask")
@Component
public class AutoRefundOrderMerchantNoAuditTask extends IJobHandler{

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private OpenRefundService openRefundService;
	/**
	 * 同步商家未审核的单据，三天未审核则自动提交到支付中心
	 * 0 0/10 * * * ?
	 */
	public void sysRefundOrderMerchantNoAudit() {
		logger.debug("Begin to run [sysRefundOrderMerchantNoAudit] 三天未审核则自动提交到支付中心");
		openRefundService.auditRefundAuditPass();
		logger.debug("Finish [sysRefundOrderMerchantNoAudit] 三天未审核则自动提交到支付中心");
	}

	@Override
	public ReturnT<String> execute(String s) throws Exception {
		this.sysRefundOrderMerchantNoAudit();
		return ReturnT.SUCCESS;
	}
}
