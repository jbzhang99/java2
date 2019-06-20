package com.rfchina.community.service;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.persistence.mapper.SysSmsTemplateMapper;
import com.rfchina.community.persistence.model.SysSmsTemplate;

@Service
public class SmsGlobalService {

	private static Logger logger = LoggerFactory.getLogger(SmsGlobalService.class);

	@Autowired
	private SysSmsTemplateMapper sysSmsTemplateMapper;

	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;

	public String getSmsTemplate(String smsType) {
		SysSmsTemplate temp = sysSmsTemplateMapper.selectByPrimaryKey(smsType);
		return temp.getSmsTemp();
	}

	public String formatSms(SmsType smsType, Object... args) {
		String temp = getSmsTemplate(smsType.name());
		if (args == null || args.length == 0) {
			return temp;
		}
		String[] st = { "" };
		return MessageFormat.format(temp, Stream.concat(Arrays.stream(st), Arrays.stream(args)).toArray());
		// return MessageFormat.format(temp,stooges.toArray());
	}

	public int sendSms(String phone, SmsType smsType, Object... args) {
		String msgContent = formatSms(smsType, args);
		return platformGlobalComponent.sendSms(phone, msgContent);
	}

	public enum SmsType {
		zizai_comm_passwd, zizai_3f_interview, zizai_vernue_ok, zizai_parking_bind, zizai_parking_bind_ok, zizai_api_visit,zizai_api_visit4, zizai_3f_phone_check,
		//
		zizai_api_acc_1, zizai_api_acc_2, zizai_api_acc_3, zizai_api_acc_4, zizai_api_acc_6
		//
		, zizai_parking_yueka, zizai_parking_yueka_unbind, biz_apply_vcode,zizai_lucky_draw, xfsj_sign_up_success, xfsj_sign_up_failed
		,user_refund_notice, group_complete_success;
	}
}