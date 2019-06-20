package com.rfchina.community.component;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.persistence.mapper.PassportMapper;
import com.rfchina.community.persistence.mapper.SysMsgInfoMapper;
import com.rfchina.community.persistence.mapper.SysMsgObjectTypeMapper;
import com.rfchina.community.persistence.mapper.SysMsgReadMapper;
import com.rfchina.community.persistence.mapper.ext.ExtSysMsgInfoGlobalMapper;
import com.rfchina.community.persistence.mapper.ext.ExtSysRoleGlobalMapper;
import com.rfchina.community.persistence.model.Passport;
import com.rfchina.community.persistence.model.PassportExample;
import com.rfchina.community.persistence.model.SysMsgInfo;
import com.rfchina.community.persistence.model.SysMsgObjectType;
import com.rfchina.community.persistence.model.SysMsgRead;
/**
 */
@Component
public class SysMsgInfoComponent {

	private static Logger logger = LoggerFactory.getLogger(SysMsgInfoComponent.class);

	@Autowired
	private SysMsgInfoMapper sysMsgInfoMapper;

	@Autowired
	private SysMsgObjectTypeMapper sysMsgObjectTypeMapper;

	@Autowired
	private SysMsgReadMapper sysMsgReadMapper;

	@Autowired
	private PassportMapper passportMapper;

	@Autowired
	private ExtSysRoleGlobalMapper extSysRoleGlobalMapper;

	@Autowired
	private ExtSysMsgInfoGlobalMapper extSysMsgInfoGlobalMapper;

	private void addSysMsgInfo(SysMsgInfo record) {
		record.setCreateTime(new Date());
		sysMsgInfoMapper.insertSelective(record);
	}

	public void taskEmptyData() {
		Date now = new Date();
		logger.info("----taskEmptyData-----begin--------" + DateTimeUtils.formatDateTime(now));
		String date90 = DateTimeUtils.formatDateTime(DateUtils.addDays(now, -90));
		String sql90 = "UPDATE sys_msg_read set is_read=3 where is_read=2 and read_time<'" + date90 + "'";
		extSysMsgInfoGlobalMapper.executeDDL(sql90);
		String date180 = DateTimeUtils.formatDateTime(DateUtils.addDays(now, -180));
		String sql180 = "DELETE from  sys_msg_read where is_read=3 and read_time<'" + date180 + "'";
		extSysMsgInfoGlobalMapper.executeDDL(sql180);
		logger.info("---taskEmptyData-------end-------" + DateTimeUtils.formatDateTime(now));
	}

	private void addSysMsgRead(List<Long> admins, Long msgId) {
		Set<Long> sets = new HashSet<>(admins);
		for (Long uid : sets) {
			SysMsgRead record = new SysMsgRead();
			record.setMsgId(msgId);
			record.setAdminUid(uid);
			record.setCreateTime(new Date());
			record.setIsRead(1);
			sysMsgReadMapper.insertSelective(record);
		}
	}

	public void add(ObjectType objectType, String id, Integer comid) {
		try {
			add(objectType, id, comid, null, null);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void addPlatform(ObjectType objectType, String id, List<String> parameter) {
		try {
			add(objectType, id, null, null, parameter);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void add(ObjectType objectType, String id, Integer comid, Long touid) {
		add(objectType, id, comid, touid, null);
	}

	public void add(ObjectType objectType, String id, Integer comid, Long touid, List<String> parameter) {
		logger.info("String objectType:{}, String id:{},Integer comid:{}, Long touid:{}", objectType, id, comid, touid);
		SysMsgObjectType msgObjectType = sysMsgObjectTypeMapper.selectByPrimaryKey(objectType.name());
		if (msgObjectType == null) {
			logger.error("There is no such event:{}", objectType);
			return;
		}
		List<Long> list = new ArrayList<>();
		// 通过权限给指定的用户
		if (msgObjectType.getOtTargetPf().equals(SysMsgInfoSourceType.app.name())) {
			logger.error("There is no such method :{}", objectType);
			return;
		} else if (msgObjectType.getOtTargetPf().equals(SysMsgInfoSourceType.community.name())) {
			Integer rid = msgObjectType.getOtResource();
			list.addAll(extSysRoleGlobalMapper.findCommunityAdminUidByresourceid(comid, rid));
		} else if (msgObjectType.getOtTargetPf().equals(SysMsgInfoSourceType.platform.name())) {
			PassportExample example = new PassportExample();
			example.createCriteria().andAppIdEqualTo(Constant.App.Id.PLATFORM_ADMIN.value()).andStatusEqualTo(Constant.Passport.Status.ENABLE);
			List<Passport> list1 = passportMapper.selectByExample(example);
			for (Passport passport : list1) {
				list.add(passport.getId());
			}
		} else if (msgObjectType.getOtTargetPf().equals(SysMsgInfoSourceType.master.name())) {
			if (touid == null || touid == 0) {
				logger.error("master to admin uid is null:{},{}", objectType, touid);
				return;
			}
		} else {
			if (touid == null || touid == 0) {
				logger.error("master to admin uid is null:{},{}", objectType, touid);
				return;
			}
			// 直接给指定的用户
			list.add(touid);
		}
		if (list.isEmpty()) {
			logger.info("admin uid is Empty type:{}, id:{} ", objectType, id);
		} else {
			SysMsgInfo r = new SysMsgInfo();
			if (parameter == null) {
				r.setContent(msgObjectType.getOtContent());
			} else {
				r.setContent(String.format(msgObjectType.getOtContent(), parameter.toArray()));
			}
			r.setMsgSourceType(msgObjectType.getOtSourcePf().toString());
			r.setObjectKey(id);
			if (SysMsgInfoSourceType.platform.name().equals(msgObjectType.getOtTargetPf())) {
				r.setCreateCommunityId(comid);
			}
			r.setObjectType(objectType.name());
			addSysMsgInfo(r);
			addSysMsgRead(list, r.getId());
		}
	}

	enum SysMsgInfoSourceType {
		// app APP, community 社区 platform 平台 master 主会员
		app, community, platform, master;
	}
	public enum ObjectType {
		// 卡片举报
		card_report,
		//
		notification_comm_submit_audit, notification_comm_audit_no, notification_pf_audit, notification_comm_audit_yes, notification_pf_audit_yes, notification_pf_audit_no, notification_expired,
		//
		release_apply_goods_no, release_apply_goods_un_audit, release_apply_goods_yes
		//
		, ad_comm_audit, ad_comm_audit_yes, ad_comm_audit_no, ad_pf_audit, ad_pf_repeal, ad_pf_publish, ad_pf_not_pass, ad_pf_pass, ad_pf_sys_publish, ad_pf_sys_repeal,
		// 卡片审核
		card_comm_audit, card_comm_audit2, card_comm_audit_publish, card_comm_audit_notpass, card_comm_audit_repeal, card_pf_audit, card_pf_audit_publish, card_pf_audit_notpass, card_comm_del,
		//
		visit_long,
		// 服务商信息审批
		open_service_provider_approval,
		// 服务信息审批
		open_service_approval,
		// 服务下架
		open_under_community_service,
		// 服务上架通知
		open_submit_service_audit,
		// 4.支付接口申请
		open_service_apply_pay, open_service_delete_apply, open_service_interface_apply,
		// 开放平台服务商审批通过,不通过
		open_service_provider_pass, open_service_provider_unpass,
		// 保证金图片上传通知
		open_caution_money_pic,
		// 服务审批通过和不通过
		open_service_approval_unpass, open_service_approval_pass,
		// 服务下架审核
		open_under_community_service_unpass, open_under_community_service_pass,
		// 普通接口申请
		open_service_interface_apply_unpass, open_service_interface_apply_pass,
		// 服务上架审核
		open_submit_service_audit_pass, open_submit_service_audit_unpass,
		// 支付申请审核
		open_service_apply_pay_pass, open_service_apply_pay_unpass,
		// 退保证金审核
		open_service_refund_caution_unpass, open_service_refund_caution_pass,
		// 服务删除审核
		open_service_delete_apply_unpass, open_service_delete_apply_pass,
		// 服务提现审批
		open_service_settlement_apply, open_service_settlement_pass, open_service_settlement_unpass, open_service_settlement_cancel, open_payment_caution_money,
		//面谈
		open_community_face_to_face, open_community_audit_pass, open_community_audit_notpass,
		//
		open_pf_to_community_under,
		//自动上架
		open_pf_to_community_auto, open_openweb_to_community_under, open_merchant_disabled,
		//意见报修
		repair_issue_order_cancel, repair_work_order_cancel,
		
		// 报名审核通过不通过
		open_xfsj_provider_pass, open_xfsj_provider_unpass,
		;
		
	}
}
