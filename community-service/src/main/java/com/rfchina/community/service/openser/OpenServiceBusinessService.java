package com.rfchina.community.service.openser;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.rfchina.community.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.backoff.Sleeper;
import org.springframework.stereotype.Service;

import com.rfchina.community.component.JavaMailComponent;
import com.rfchina.community.component.JavaMailComponent.EmailType;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.model.OpenMerchantInfo;

@Service
public class OpenServiceBusinessService extends BaseService {

	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;

	@Autowired
	private JavaMailComponent javaMailComponent;

	/**
	 * 支持成功接收保证金
	 */
	public void sendCautionEmail(Long merchantId, Date successTime, BigDecimal caution) {

		OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(merchantId);
		if (info == null)
			return;
		if (caution.doubleValue() <= 0)
			return;
		String email = info.getEmail();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("title", info.getTitle());
		model.put("successTime", successTime);
		model.put("caution", caution);

		javaMailComponent.sendEmail(EmailType.open_success_caution, email, model);
	}
	
	/**
	 * 下订单成功发送邮件给商家
	 */
	public void sendPaySuccessEmail(Long merchantId, Date successTime, String serviceName) {
		try{
			OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(merchantId);
			if (info == null)
				return;

			Map<String, Object> model = new HashMap<String, Object>();
			model.put("title", info.getTitle());
			model.put("successTime", successTime);
			model.put("serviceName", serviceName);

			javaMailComponent.sendEmail(EmailType.open_pay_success, info.getEmail(), model);
		}catch (Exception e){
			logger.error("发送邮件异常",e);
		}

	}

}
