package com.rfchina.community.brothers.xxljob;

import com.rfchina.community.brothers.mapper.ExtCommunityQrcodeMapper;
import com.rfchina.community.brothers.service.OpenOrderBroService;
import com.rfchina.community.persistence.mapper.CommunityQrcodeInfoMapper;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 第三方服务的社区自动结算
 */
@JobHandler(value = "brothers-AutoOpenCommunitySettlementTask")
@Component
public class AutoOpenCommunitySettlementTask extends IJobHandler{

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	ExtCommunityQrcodeMapper extCommunityQrcodeMapper;
	@Autowired
	CommunityQrcodeInfoMapper communityQrcodeInfoMapper;
	
 
	@Autowired
	private OpenOrderBroService openOrderService;
	

	public void openOrderServiceAccount() {
		//同步对应开发平台的结算状态的问题
		 //社区佣金自动结算功能
		 logger.debug("Begin to run [openOrderServiceAccount] 第三方服务的社区自动结算");
		 openOrderService.syncServiceAccountNull();
		 logger.debug("Finish [openOrderServiceAccount] 第三方服务的社区自动结算");
	}

	@Override
	public ReturnT<String> execute(String s) throws Exception {
		this.openOrderServiceAccount();
		return ReturnT.SUCCESS;
	}
}
