package com.rfchina.community.open.bridge.controller.community;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.OpenCautionInfoMapper;
import com.rfchina.community.persistence.mapper.OpenServiceDetailMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.CommunityServiceExample;
import com.rfchina.community.persistence.model.OpenCautionInfo;
import com.rfchina.community.persistence.model.OpenCautionInfoExample;
import com.rfchina.community.persistence.model.OpenServiceDetail;
import com.rfchina.community.service.openser.OpenCautionInfoSerService;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_COMMUNITY)
public class OpenCautionInfoAdminController extends BaseController {

	@Autowired
	private OpenCautionInfoSerService openCautionInfoSerService;

	@Autowired
	private OpenCautionInfoMapper openCautionInfoMapper;

	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private OpenServiceDetailMapper openServiceDetailMapper;

	/**
	 * 保证金列表
	 * 
	 * @param serviceId
	 * @return
	 */
	@RequestMapping(value = { "/listOpenCautionInfo" })
	public Result<?> listOpenCautionInfo(@RequestParam(value = "serviceId", required = true) Integer serviceId) {

		OpenCautionInfoExample example = new OpenCautionInfoExample();
		example.createCriteria().andServiceIdEqualTo(serviceId);
		example.setOrderByClause("id desc");
		List<OpenCautionInfo> list = openCautionInfoMapper.selectByExample(example);
		return Result.successData(list);
	}

	@RequestMapping(value = { "/addOpenCautionInfo" })
	public Result<?> addOpenCautionInfo(@RequestParam(value = "serviceId", required = true) Integer serviceId,
			@RequestParam(value = "money", required = true) BigDecimal money,
			@RequestParam(value = "remarks", required = false, defaultValue = "") String remarks,
			@RequestParam(value = "__admin_id", required = true) Long adminId) {
		validator(money.compareTo(new BigDecimal(0)) <= 0, "money必须大于0");
		OpenCautionInfo caution = new OpenCautionInfo();
		caution.setMoney(money);
		caution.setServiceId(serviceId);
		caution.setCreateTime(new Date());
		caution.setOpenId(0L);
		caution.setStatus(1);
		caution.setRemarks(remarks);
		caution.setCreateUid(adminId);

		OpenServiceDetail detail = openServiceDetailMapper.selectByPrimaryKey(serviceId);
		validator(detail == null, "没有数据" + serviceId);
		validator(detail.getCautionRefundStatus() == 1, "该服务已经退款不能操作" + serviceId);

		int i = openCautionInfoMapper.insertSelective(caution);
		if (i > 0) {

			// OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(uid);
			// Map<String, Object> model = new HashMap<>();
			// model.put("title", info.getTitle());
			// model.put("serviceTitle", communityServiceTemp.getTitle());
			// // model.put("reason", reason);
			// model.put("cautionMoney", cautionMoney);
			// javaMailComponent.sendEmail(EmailType.open_service_approval_pass,
			// info.getEmail(), model);

			// '1,待缴纳,2,已线上缴纳,3线下缴纳待核验,4已线下缴纳,5隐藏,6已退'
			openCautionInfoSerService.cautionHandle(serviceId, false);

		}
		return Result.successData(caution);
	}

	@RequestMapping(value = { "/statusOpenCautionInfo" })
	public Result<?> statusOpenCautionInfo(@RequestParam(value = "id", required = true) Long id,
			@RequestParam(value = "status", required = true) int status) {
		validator(status != 4 && status != 5, "status不对,只能是4线下缴纳,5无需缴纳");

		OpenCautionInfo caution = openCautionInfoMapper.selectByPrimaryKey(id);
		validator(caution == null, "没有数据" + id);
		validator(caution.getStatus() == 2, "已经线上缴纳不能操作" + id);
		validator(caution.getStatus() == 4, "已经线下缴纳不能操作" + id);
		validator(status == 4 && caution.getStatus() != 3, "没有上传,不能确定");

		Integer serviceId = caution.getServiceId();
		OpenServiceDetail detail = openServiceDetailMapper.selectByPrimaryKey(serviceId);
		validator(detail == null, "没有数据" + serviceId);
		validator(detail.getCautionRefundStatus() == 1, "该服务已经退款不能操作" + serviceId);

		OpenCautionInfo record = new OpenCautionInfo();
		record.setId(id);
		record.setStatus(status);

		if (status == 4) {
			record.setPayTime(new Date());
		}

		int i = openCautionInfoMapper.updateByPrimaryKeySelective(record);
		if (i > 0) {
			// '1,待缴纳,2,已线上缴纳,3线下缴纳待核验,4已线下缴纳,5隐藏,6已退'
			openCautionInfoSerService.cautionHandle(serviceId, false);

			if (status == 4) {
				// openServiceBusinessService.sendCautionEmail(ser.getMerchantId(), new Date(),
				// openOrder.getTotalAmount());
			}
		}
		return Result.successData(i);
	}

	@RequestMapping(value = { "/refreshCautionHandle" })
	public Result<?> refreshCautionHandle(@RequestParam(value = "id", required = true) Integer serviceId,
			boolean audit) {
		JSONObject data = openCautionInfoSerService.cautionHandle(serviceId, audit);
		return Result.successData(data);
	}

	@RequestMapping(value = { "/cautionRefundReason" })
	public Result<?> cautionRefundReason(@RequestParam(value = "serviceId", required = true) Integer serviceId,
			@RequestParam(value = "caution_refund_reason", required = true) String caution_refund_reason) {
		validator(StringUtils.isBlank(caution_refund_reason), "原因不能为空");
		if (caution_refund_reason.length() > 100) {
			caution_refund_reason = caution_refund_reason.substring(0, 100);
		}
		caution_refund_reason += ",操作时间:" + DateTimeUtils.formatDateTime();
		OpenServiceDetail detail = openServiceDetailMapper.selectByPrimaryKey(serviceId);
		validator(detail == null, "没有数据" + serviceId);
		validator(detail.getCautionRefundStatus() == 1, "已经退款不要重复操作" + serviceId);

		// 判断服务是否删除状态
		CommunityService communityService = communityServiceMapper.selectByPrimaryKey(serviceId);
		validator(communityService.getStatus() != Constant.OpenAdmin.CommunityServiceGroundStatus.DELETE,
				"服务删除后才能确认退款");

		OpenServiceDetail record = new OpenServiceDetail();
		record.setServiceId(serviceId);
		record.setCautionRefundStatus(1);
		record.setCautionRefundReason(caution_refund_reason);
		int i = openServiceDetailMapper.updateByPrimaryKeySelective(record);
		return Result.successData(i);
	}

	@RequestMapping(value = { "/initCautionInfo" })
	public Result<?> initCaution() {
		OpenCautionInfoExample example1 = new OpenCautionInfoExample();
		example1.createCriteria().andStatusEqualTo(2);

		List<OpenCautionInfo> list = openCautionInfoMapper.selectByExample(example1);
		List<Integer> lis1t = new ArrayList<>();
		for (OpenCautionInfo communityService : list) {
			Integer serviceId = communityService.getServiceId();
			openCautionInfoSerService.cautionHandle(serviceId, false);
			lis1t.add(serviceId);
		}
		return Result.successData(lis1t);
	}
}
