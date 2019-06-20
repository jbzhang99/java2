package com.rfchina.community.brothers.task;

import com.rfchina.community.brothers.mapper.ExtCommunityQrcodeMapper;
import com.rfchina.community.brothers.service.OpenOrderBroService;
import com.rfchina.community.persistence.mapper.CommunityQrcodeInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 第三方服务的社区自动结算
 */
//@Component
public class AutoOpenCommunitySettlementTask {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	ExtCommunityQrcodeMapper extCommunityQrcodeMapper;
	@Autowired
	CommunityQrcodeInfoMapper communityQrcodeInfoMapper;
	
 
	@Autowired
	private OpenOrderBroService openOrderService;
	
//	@Value("${auto.task.builderCommunityQrcode:true}")
//	private boolean builderCommunityQrcode;

	 
 
 
	 @Scheduled(cron = "0 30 12 * * ?")
	public void openOrderServiceAccount() {
		//同步对应开发平台的结算状态的问题
		 //社区佣金自动结算功能
		openOrderService.syncServiceAccountNull();
	}
	
}
