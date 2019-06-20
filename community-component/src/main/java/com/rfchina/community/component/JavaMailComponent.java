package com.rfchina.community.component;

import java.util.Date;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.persistence.mapper.SysEmailTemplateMapper;
import com.rfchina.community.persistence.model.SysEmailTemplate;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Component
public class JavaMailComponent {

	@Value("${spring.mail.username:test}")
	private String formEmail;

	private static Logger logger = LoggerFactory.getLogger(JavaMailComponent.class);

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private SysEmailTemplateMapper sysEmailTemplateMapper;

	@Autowired
	private Configuration configuration;

	@Value("${openweb.site.link:http://192.168.197.28:10406}")
	private String openwebSiteLink;

	@Async
	public void sendEmail(String toEmail, String subject, String text) {
		MimeMessage message = null;
		long now = System.currentTimeMillis();
		try {
			message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(formEmail);
			helper.setTo(toEmail);
			helper.setSubject(subject);
			helper.setText(text, true);
			
			mailSender.send(message);
			logger.info("---sendEmail--toEmail:{}--subject:{}---{}", toEmail, subject,
					System.currentTimeMillis() - now);
		} catch (MessagingException e) {
			logger.error(e.getMessage(), e);
		}
	}

	private void sendEmail(String toEmail, String subject, String template, Map<String, Object> model) {
		model.put("toEmail", toEmail);
		model.put("_now", DateTimeUtils.formatDateTime());
		model.put("openwebSiteLink", openwebSiteLink);
		try {
			Template t = configuration.getTemplate(template);
			String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
			sendEmail(toEmail, subject, text);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void sendEmail(EmailType emailType, String toEmail, Map<String, Object> model) {
		SysEmailTemplate temp = sysEmailTemplateMapper.selectByPrimaryKey(emailType.name());
		sendEmail(toEmail, temp.getEmailSubject(), temp.getEmailTemplate(), model);
	}

	public enum EmailType {
		// 注册
		forget_password, register_activation,
		// 服务商资质通过审批 服务商资质不通过审批
		merchant_info_unpass, merchant_info_pass,
		// 服务删除
		open_service_delete_apply_unpass, open_service_delete_apply_pass,
		//
		open_service_approval_unpass, open_service_approval_pass,
		//
		open_submit_service_audit_unpass, open_submit_service_audit_pass,
		// 服务下架审核
		open_under_community_service_pass, open_under_community_service_unpass,
		// 支付申请审核
		open_service_apply_pay_pass, open_service_apply_pay_unpass,
		// 面谈
		open_community_face_to_face,
		//确认保证金
		open_success_caution,
		//用户下单成功通知商家
		open_pay_success,
		// 小富市集报名通过审批不通过审批
		xfsj_merchant_sign_up_unpass, xfsj_merchant_sign_up_pass,
		//用户提交退款申请通知商家
		user_refund_notice
		;
	}
}
