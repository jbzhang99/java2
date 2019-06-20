package com.rfchina.community.component;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;

import com.rfchina.community.persistence.mapper.OpenAuditInfoMapper;
import com.rfchina.community.persistence.model.OpenAuditInfo;
import com.rfchina.community.persistence.model.OpenAuditInfoExample;

/**
 */
@Component
public class OpenAuditInfoComponent {

	private static Logger logger = LoggerFactory.getLogger(OpenAuditInfoComponent.class);

	@Autowired
	private OpenAuditInfoMapper openAuditInfoMapper;

	private Long addOpenAuditInfo(OpenAuditInfo record) {
		record.setCreateTime(new Date());
		record.setUpdateTime(new Date());
		record.setAuditStatus(Status.init.v);
		openAuditInfoMapper.insertSelective(record);
		return record.getId();
	}

	public Long add(ObjectType objectType, Long srcUid, String objectId, Integer serviceId) {
		OpenAuditInfo record = getOpenAuditInfo(objectType, srcUid, objectId, serviceId, null, null);
		return addOpenAuditInfo(record);
	}

	public Long add(ObjectType objectType, Long srcUid, String objectId, Integer serviceId, Long merchantId) {
		OpenAuditInfo record = getOpenAuditInfo(objectType, srcUid, objectId, serviceId, merchantId, null);
		return addOpenAuditInfo(record);
	}

	public Long add(ObjectType objectType, Long srcUid, String objectId, Integer serviceId, Long merchantId,
			PageIdType pagerid) {
		OpenAuditInfo record = getOpenAuditInfo(objectType, srcUid, objectId, serviceId, merchantId, pagerid);
		return addOpenAuditInfo(record);
	}

	public Long add(ObjectType objectType, Long srcUid, String objectId, Integer serviceId,
			PageIdType pagerid) {
		OpenAuditInfo record = getOpenAuditInfo(objectType, srcUid, objectId, serviceId, null, pagerid);
		return addOpenAuditInfo(record);
	}

	private OpenAuditInfo getOpenAuditInfo(ObjectType objectType, Long srcUid, String objectId, Integer serviceId, Long merchantId, PageIdType pagerid) {
		OpenAuditInfo record = new OpenAuditInfo();
		record.setAuditType(objectType.name());
		record.setAuditContent("");
		record.setSrcUid(srcUid);
		record.setObjectId(objectId);
		record.setServiceId(serviceId);
		if(merchantId != null){
			record.setMerchantId(merchantId);
		}
		if(pagerid != null){
			record.setPagerId(pagerid.name());
		}
		return record;
	}

	public Long add(ObjectType objectType, Long srcUid, String objectId) {
		return add(objectType, srcUid, objectId, 0);
	}

	public int canel(ObjectType objectType, Long srcUid, String objectId) {
		OpenAuditInfo record = new OpenAuditInfo();
		record.setAuditStatus(Status.canel.v);
		record.setUpdateTime(new Date());
		record.setAuditContent("用户主动撤销审批!");
		OpenAuditInfoExample example = new OpenAuditInfoExample();
		example.createCriteria().andAuditTypeEqualTo(objectType.name()).andSrcUidEqualTo(srcUid)
				.andAuditStatusEqualTo(Status.init.v).andObjectIdEqualTo(objectId);
		return openAuditInfoMapper.updateByExampleSelective(record, example);
	}

	public int disabledMerchant(Long srcUid) {
		OpenAuditInfo record = new OpenAuditInfo();
		record.setAuditStatus(Status.disabled.v);
		record.setUpdateTime(new Date());
		record.setAuditContent("服务商禁用审批作废!");
		OpenAuditInfoExample example = new OpenAuditInfoExample();
		example.createCriteria().andSrcUidEqualTo(srcUid).andAuditStatusEqualTo(Status.init.v);
		return openAuditInfoMapper.updateByExampleSelective(record, example);
	}

	public int disabledService(Long srcUid, String objectId) {
		OpenAuditInfo record = new OpenAuditInfo();
		record.setAuditStatus(Status.disabled.v);
		record.setUpdateTime(new Date());
		record.setAuditContent("该服务禁用审批作废!");
		OpenAuditInfoExample example = new OpenAuditInfoExample();
		example.createCriteria().andSrcUidEqualTo(srcUid).andAuditStatusEqualTo(Status.init.v)
				.andObjectIdEqualTo(objectId);
		return openAuditInfoMapper.updateByExampleSelective(record, example);
	}

	public int audit(Long id, Status auditStatus, String auditContent, Long auditUid) {
		OpenAuditInfo record = new OpenAuditInfo();
		record.setId(id);
		record.setAuditContent(auditContent);
		record.setUpdateTime(new Date());
		record.setAuditStatus(auditStatus.v);
		record.setAuditUid(auditUid);

		return openAuditInfoMapper.updateByPrimaryKeySelective(record);
	}

	public int audit(Long id, Status auditStatus, String auditContent, Long auditUid, String auditPhone,
			String auditName) {
		OpenAuditInfo record = new OpenAuditInfo();
		record.setId(id);
		record.setAuditContent(auditContent);
		record.setUpdateTime(new Date());
		record.setAuditStatus(auditStatus.v);
		record.setAuditUid(auditUid);
		record.setAuditName(auditName);
		record.setAuditPhone(auditPhone);
		return openAuditInfoMapper.updateByPrimaryKeySelective(record);
	}

	public enum Status {
		// 审批中
		init(1),
		// 通过
		pass(2),
		// 不通过
		unpass(3),
		// 过期
		expired(4),
		// 用户撤销
		canel(5),
		// 禁用
		disabled(6)
		//
		;

		int v;

		public int getV() {
			return v;
		}

		private Status(int v) {
			this.v = v;
		}
	}

	public enum ObjectType {
		// 服务商信息审批
		service_provider_approval,
		//
		// 服务审批
		service_approval,
		// 服务下架
		under_community_service,
		// 服务上架通知
		submit_service_audit,
		// 4.支付接口申请
		service_apply_pay,

		// 5。服务删除申请
		service_delete_apply,

		// 6.退保证金申请
		service_refund_caution,

		// 7.普通接口申请
		service_interface_apply,

		// 8.小富市集报名申请
		xfsj_sign_up_apply,

		// 9.小富市集商家申请
		xfsj_provider_apply

		;
	}

	public enum PageIdType {
		// 平台审批
		platform, xfsj_sign_up, xfsj_register;
	}
}
