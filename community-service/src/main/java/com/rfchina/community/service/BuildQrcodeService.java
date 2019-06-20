package com.rfchina.community.service;

import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.exception.WorkRunTimeException;
import com.rfchina.community.base.rsa.RSAEncrypt;
import com.rfchina.community.persistence.mapper.CommunityQrcodeInfoMapper;
import com.rfchina.community.persistence.mapper.QrcodeBuildLogMapper;
import com.rfchina.community.persistence.model.CommunityQrcodeInfo;
import com.rfchina.community.persistence.model.QrcodeBuildLog;

@Service
public class BuildQrcodeService {

	private static Logger logger = LoggerFactory.getLogger(BuildQrcodeService.class);

	@Autowired
	private QrcodeBuildLogMapper qrcodeBuildLogMapper;

	@Autowired
	private CommunityQrcodeInfoMapper communityQrcodeInfoMapper;

	public QrcodeBuildLog createQrcodeBuildLog(Date beginTime, Date endTime, Integer type, Integer canCount,
			Integer otherCommunity, Integer communityId, Long uid,String systype) {
		QrcodeBuildLog r = new QrcodeBuildLog();
		r.setBeginTime(beginTime);
		r.setEndTime(endTime);
		r.setType(type);
		r.setQrcode(UUID.randomUUID().toString());
		r.setCanCount(canCount);
		r.setStatus(1);
		r.setOtherCommunity(otherCommunity);
		r.setCommunityId(communityId);
		r.setCreateTime(new Date());
		r.setUid(uid);
		r.setSysType(systype);
		qrcodeBuildLogMapper.insertSelective(r);
		return r;
	}

	public String cipher(QrcodeBuildLog r) {
		CommunityQrcodeInfo aa = communityQrcodeInfoMapper.selectByPrimaryKey(r.getCommunityId());
		if (!aa.getOtherCommunity().equals(aa.getOtherCommunity())) {
			r.setOtherCommunity(aa.getOtherCommunity());
			communityQrcodeInfoMapper.updateByPrimaryKeySelective(aa);
		}

		return cipher(r, aa.getPrivateKey());
	}

	public String cipher(Long id) {
		QrcodeBuildLog r = qrcodeBuildLogMapper.selectByPrimaryKey(id);
		return cipher(r);
	}

	public String cipher(QrcodeBuildLog r, String privateKey) {
		String plainText = "";
		plainText = qrcodeBuild(r);
		byte[] cipherData = null;
		try {
			cipherData = RSAEncrypt.encrypt(RSAEncrypt.loadPrivateKeyByStr(privateKey), plainText.getBytes());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new WorkRunTimeException(e.getMessage());
		}
		String cipher = Base64.getEncoder().encodeToString(cipherData);
		return cipher;
	}

	private String qrcodeBuild(QrcodeBuildLog r) {
		String liushui = Long.toString(r.getId(), 36);
		String plainText = "";
		plainText = strPod2(r.getOtherCommunity());
		plainText += Long.toString(r.getBeginTime().getTime() / 1000, 36);
		plainText += Long.toString(r.getEndTime().getTime() / 1000, 36);

		if (r.getType() == 1) {
			plainText += liushui;
			plainText += "!";
		} else if (r.getType() == 2) {
			// int a = 22;
			plainText += strPod2(r.getCanCount());
			plainText += liushui;
			plainText += "@";
		}

		return plainText;
	}

	private static String strPod2(int a) {
		String str = Integer.toString(a, 36);

		if (str.length() == 2) {
			return str;
		}
		if (str.length() == 1) {
			return "0" + str;
		}
		if (str.length() > 2) {
			return str.substring(0, 2);
		}
		return "00";
	}

	public QrcodeBuildLog getQrcodeBuildLog(long id) {
		return qrcodeBuildLogMapper.selectByPrimaryKey(id);
	}

}