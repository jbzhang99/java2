package com.rfchina.community.open.bridge.controller.platform;

import com.alibaba.fastjson.JSON;
import com.rfchina.api.response.ResponseData;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.component.SysMsgInfoComponent;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.mapper.ext.ExtOpenOrderFinanceMapper;
import com.rfchina.community.open.bridge.service.OpenSettlementApplyService;
import com.rfchina.community.persistence.mapper.PaySettlementInfoMapper;
import com.rfchina.community.persistence.model.OpenSettlementApply;
import com.rfchina.community.persistence.model.PaySettlementInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

//import com.rfchina.community.platform.service.PlatformService;
//社区审批结算的功能
@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class OpenSettlementApplyController extends BaseController {

	@Autowired
	private OpenSettlementApplyService openSettlementApplyService;

	@Autowired
	private PlatformGlobalComponent platformService;
	@Autowired
	private PaySettlementInfoMapper paySettlementInfoMapper;

	@Autowired
	private SysMsgInfoComponent sysMsgInfoComponent;

	@Autowired
	private ExtOpenOrderFinanceMapper extOpenOrderFinanceMapper;


	/**
	 * @Author wlrllr
	 * @Description //提现管理
	 * @Date 2019/1/7
	 * @Param [startCreateTime, endCreateTime, status, serviceId, serviceName, merchantName, merchantId, index, size]
	 * @return com.rfchina.community.base.Result<?>
	 **/
	@RequestMapping("/getSettlementApplyList")
	public Result<?> getSettlementApplyList(
			@RequestParam(value = "startCreateTime", required = false, defaultValue = "") String startCreateTime,
			@RequestParam(value = "endCreateTime", required = false, defaultValue = "") String endCreateTime,
			@RequestParam(value = "status", required = false, defaultValue = "0") int status,
			@RequestParam(value = "serviceId", required = false, defaultValue = "0") int serviceId,
			@RequestParam(value = "serviceName", required = false, defaultValue = "") String serviceName,
			@RequestParam(value = "merchantName", required = false, defaultValue = "") String merchantName,
			@RequestParam(value = "merchantId", required = false, defaultValue = "0") int merchantId,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {

		Date startCreateDate = convertDate(startCreateTime);
		Date endCreateDate = convertDate(endCreateTime);

		return Result.successData(openSettlementApplyService
				.getSettlementApplyList(startCreateDate, endCreateDate, Constant.OpenAdmin.SettlementApplyType.MERCHANT,
						null, merchantId, merchantName, status, serviceId, serviceName, index, size)
				.convert());
	}

	@RequestMapping("/settlementApplyAudit")
	@Transactional(rollbackFor = Exception.class)
	public Result<?> settlementApplyAudit(@RequestParam("id") int id, @RequestParam("status") int status,
										  @RequestParam(value = "__phone", required = false, defaultValue = "") String phone,
										  @RequestParam(value = "__realname", required = false, defaultValue = "") String realname,
			@RequestParam(value = "auditComment", required = false, defaultValue = "") String auditComment) {

		OpenSettlementApply openSettlementApply = openSettlementApplyService.getOpenSettlementApply(id);
		if (openSettlementApply == null) {
			error("此提现申请不存在");
		}
		Integer sid = openSettlementApply.getServiceId();
		OpenSettlementApply apply = new OpenSettlementApply();
		apply.setId(id);
		if (status == Constant.OpenAdmin.SettlementApplyStatus.PLATFORM_NOTPASS) {
			if (StringUtils.isBlank(auditComment)) {
				error("审核不通过时，审核意见不能为空");
			}
		}

		apply.setStatus(status);
		apply.setAuditComment(auditComment);
		apply.setAuditTime(new Date());
		apply.setAuditName(realname);
		apply.setAuditPhone(phone);
		if (status == Constant.OpenAdmin.SettlementApplyStatus.PLATFORM_PASS) {

			Long notSplitCount = extOpenOrderFinanceMapper.countServiceNotSplitNew(sid,
					openSettlementApply.getSettlementStartTime(), openSettlementApply.getSettlementEndTime());
			validator(notSplitCount != null && notSplitCount > 0,
					id + "服务:[" + sid + "]从"
							+ DateTimeUtils.formatDateTime(openSettlementApply.getSettlementStartTime()) + "到"
							+ DateTimeUtils.formatDateTime(openSettlementApply.getSettlementEndTime())
							+ "时间段有订单未转可提现状态,请联系程序员进行排查!总:" + notSplitCount + " 笔");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// 审核通过后，提交结算申请单到支付中心

			ResponseData<Map<String, Object>> response = platformService.settlementApply(
					openSettlementApply.getMchId(), openSettlementApply.getTitle(), openSettlementApply.getAccountId(),
					sdf.format(openSettlementApply.getSettlementStartTime()),
					sdf.format(openSettlementApply.getSettlementEndTime()));
			validator(response.getCode() != 1001, response.getMsg());
			Map<String, Object> responseModel = response.getData();
//			apply.setPfStatus(responseModel.getStatus());
			apply.setPfStatus(3);
			apply.setPlatformSettlementId(String.valueOf(responseModel.get("sid")));

			PaySettlementInfo r = new PaySettlementInfo();
			r.setMyStatus(1);
			r.setMyType("open_order");
			r.setMyId(id + "");
			r.setMyCreateTime(new Date());
			r.setId(String.valueOf(responseModel.get("sid")));
			r.setConfirmStatus(1);//未确认
			//BeanUtils.copyProperties(responseModel, r);
			int a = paySettlementInfoMapper.insertSelective(r);
			logger.info("a:{},data:{}", a, JSON.toJSONString(r));

			// logger.info("社区服务费申请结算成功，merchantId:{},serviceId:{},accountId:{}
			// startDate:{}, endDate:{}",openMerchantInfo.getMchId(),
			// serinfo.getId(),serinfo.getAccountId(), last.getTime(),
			// openSettlementApply.getSettlementEndTime());
			// 收到服务商提现申请
			///
			List<String> parameter = new ArrayList<>();
			parameter.add(openSettlementApply.getTitle());
			sysMsgInfoComponent.addPlatform(SysMsgInfoComponent.ObjectType.open_service_settlement_pass,
					openSettlementApply.getServiceId().toString(), parameter);
			//
		} else {

			// 更新提现的订单状态
			// OpenOrderExample example = new OpenOrderExample();
			// example.createCriteria().andCreateTimeGreaterThanOrEqualTo(DateTimeUtils.date000000(openSettlementApply.getSettlementStartTime()))
			// .andCreateTimeLessThanOrEqualTo(DateTimeUtils.date235959(openSettlementApply.getSettlementEndTime())).andTypeEqualTo(1).andBillStatusEqualTo(2).andServiceChargeBillIdIsNotNull()
			// .andServiceIdEqualTo(openSettlementApply.getServiceId());
			// List<OpenOrder> orderList = openOrderMapper.selectByExample(example);

			// 更新订单的提现状态
			// if(orderList != null && orderList.size() > 0){
			// for(OpenOrder openOrder : orderList){
			// OpenOrder o = new OpenOrder();
			//
			// o.setId(openOrder.getId());
			// o.setWithdrawStatus(5);
			//
			// openOrderService.updateOpenOrderByPrimaryKey(o);
			// }
			// }

			///
			List<String> parameter = new ArrayList<>();
			parameter.add(openSettlementApply.getTitle());
			sysMsgInfoComponent.addPlatform(SysMsgInfoComponent.ObjectType.open_service_settlement_unpass,
					openSettlementApply.getServiceId().toString(), parameter);
			//
		}

		int a = openSettlementApplyService.updateOpenSettlementApply(apply);
		logger.info("a:{},apply:{}", a, JSON.toJSONString(apply));
		return Result.success();

	}

	/// 手续费出票明细
	@RequestMapping("/getPlatformChargeList")
	public Result<?> getPlatformChargeList(
			@RequestParam(value = "startCreateTime", required = false, defaultValue = "") String startCreateTime,
			@RequestParam(value = "endCreateTime", required = false, defaultValue = "") String endCreateTime,
			@RequestParam(value = "settlementId", required = false, defaultValue = "") String settlementId,
			@RequestParam(value = "serviceId", required = false, defaultValue = "0") int serviceId,
			@RequestParam(value = "serviceName", required = false, defaultValue = "") String serviceName,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size){

		Date startCreateDate = convertDate(startCreateTime);
		Date endCreateDate = convertDate(endCreateTime);
		return Result.successData(openSettlementApplyService
				.getSettlementApplyList(startCreateDate, endCreateDate, Constant.OpenAdmin.SettlementApplyType.MERCHANT,
						settlementId, 0, null, 0, serviceId, serviceName, index, size)
				.convert());
	}



}
