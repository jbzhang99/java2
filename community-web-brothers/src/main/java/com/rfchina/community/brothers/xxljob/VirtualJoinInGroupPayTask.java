package com.rfchina.community.brothers.xxljob;

import com.rfchina.community.service.openser.OpenStoreGroupDataSerService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@JobHandler(value = "brothers-VirtualJoinInGroupPayTask")
@Component
public class VirtualJoinInGroupPayTask extends IJobHandler {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private OpenStoreGroupDataSerService openStoreGroupDataSerService;

	@Override
	public ReturnT<String> execute(String s) throws Exception {
		this.virtualJoinInGroupPay();
		return ReturnT.SUCCESS;
	}

	public void virtualJoinInGroupPay() {
		logger.debug("Begin to run [virtualJoinInGroupPay] 虚拟拼团");
		openStoreGroupDataSerService.virtualJoinInGroupPay();
		logger.debug("Finish [virtualJoinInGroupPay] 虚拟拼团");
	}


}
