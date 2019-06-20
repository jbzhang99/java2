package com.rfchina.community.brothers.xxljob;

import com.alibaba.fastjson.JSON;
import com.rfchina.community.brothers.mapper.ExtCommunityQrcodeMapper;
import com.rfchina.community.brothers.service.BaseSettlementApplyService;
import com.rfchina.community.brothers.service.OpenOrderBroService;
import com.rfchina.community.brothers.service.PaySettlementInfoService;
import com.rfchina.community.persistence.mapper.CommunityQrcodeInfoMapper;
import com.rfchina.community.persistence.mapper.VisitCommunityMapper;
import com.rfchina.community.persistence.model.CommunityQrcodeInfo;
import com.rfchina.community.persistence.model.VisitCommunity;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;
import java.util.List;

/**
 * 社区二维码的私钥和公钥
 */
@JobHandler(value = "brothers-AutoBuilderCommunityQrcodeTask")
@Component
public class AutoBuilderCommunityQrcodeTask extends IJobHandler{

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	ExtCommunityQrcodeMapper extCommunityQrcodeMapper;
	@Autowired
	CommunityQrcodeInfoMapper communityQrcodeInfoMapper;
	@Autowired
	private VisitCommunityMapper visitCommunityMapper;

	@Value("${auto.task.builderCommunityQrcode:true}")
	private boolean builderCommunityQrcode;

	@Override
	public ReturnT<String> execute(String s) throws Exception {
		this.builderCommunityQrcode();
		return ReturnT.SUCCESS;
	}

	// 0 0/15 * * * ?
	public void builderCommunityQrcode() {
		logger.debug("Begin to run [builderCommunityQrcode] 社区二维码的私钥和公钥");
		if (!builderCommunityQrcode) {
			return;
		}

		Integer currentQrInfo  = extCommunityQrcodeMapper.communityQrcodeLimit();

		if (currentQrInfo > 1295){
			logger.info(" 已超过最大可支持的二维码门禁数量 ！");
			return;
		}

		// 定时创建
		List<Integer> list = extCommunityQrcodeMapper.communityNotCom();

		for (Integer id : list) {
			//解除1296的限制
			/*if (id > 1295) {
				logger.error(" community is big id :", id);
				continue;
			}*/
			CommunityQrcodeInfo r = new CommunityQrcodeInfo();
			r.setCommunityId(id);
			//r.setOtherCommunity(id);
			r.setIdKey(1);
			//默认开启.
			r.setStatus(1);
			genKeyPair(r);

			CommunityQrcodeInfo count = communityQrcodeInfoMapper.selectByPrimaryKey(id);
			if (count == null) {
				int i = communityQrcodeInfoMapper.insertSelective(r);
				logger.info(" CommunityQrcodeInfo create:  {} : {}", i, JSON.toJSONString(r));
			}
		}



		list = extCommunityQrcodeMapper.communityNotVisit();
		for (Integer id : list) {
			VisitCommunity r = new VisitCommunity();
			r.setClosingTime("22:00");
			r.setOpenTime("06:00");
			r.setCommunityId(id);
			r.setIsEntranceGuard(2);
			r.setEntranceGuardType(1);
			r.setFollowMax(20);
			r.setFollowMust(1);
			VisitCommunity count = visitCommunityMapper.selectByPrimaryKey(id);
			if (count == null) {
				int i = visitCommunityMapper.insertSelective(r);
				logger.info(" VisitCommunity create:  {} : {}", i, JSON.toJSONString(r));
			}
		}

		logger.debug("Finish [builderCommunityQrcode] 社区二维码的私钥和公钥");
	}

	private void genKeyPair(CommunityQrcodeInfo r) {
		// KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
		KeyPairGenerator keyPairGen = null;
		try {
			keyPairGen = KeyPairGenerator.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(), e);
		}
		// 初始化密钥对生成器，密钥大小为96-1024位
		int k = 64 * 8;
		// System.out.println(k);
		keyPairGen.initialize(k, new SecureRandom());
		// 生成一个密钥对，保存在keyPair中
		KeyPair keyPair = keyPairGen.generateKeyPair();
		// 得到私钥
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		// 得到公钥
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

		// 得到公钥字符串
		String publicKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());
		// 得到私钥字符串
		String privateKeyString = Base64.getEncoder().encodeToString(privateKey.getEncoded());
		r.setPublicKey(publicKeyString);
		r.setPrivateKey(privateKeyString);
	}


}
