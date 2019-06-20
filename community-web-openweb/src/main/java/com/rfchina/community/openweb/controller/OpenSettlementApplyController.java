package com.rfchina.community.openweb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.pay.FuPayGetAccountResponseModel;
import com.rfchina.api.response.model.pay.FuPayGetSettlementApplyDetailResponseModel;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.component.SysMsgInfoComponent;
import com.rfchina.community.openweb.entity.AdminUserInfo;
import com.rfchina.community.openweb.entity.ExtOpenSettlementApply;
import com.rfchina.community.openweb.mapper.ext.ExtOpenSettlementApplyMapper;
import com.rfchina.community.openweb.service.CommunityServiceService;
import com.rfchina.community.openweb.service.OpenSettlementApplyService;
import com.rfchina.community.openweb.service.OpenWebOrderService;
import com.rfchina.community.openweb.service.PlatformService;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.mapper.OpenSettlementApplyMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.OpenMerchantInfo;
import com.rfchina.community.persistence.model.OpenSettlementApply;
import com.rfchina.community.persistence.model.OpenSettlementApplyExample;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENWEB)
public class OpenSettlementApplyController extends BaseController {

	@Autowired
	private OpenWebOrderService openOrderService;

	@Autowired
	private CommunityServiceService communityServiceService;

	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private OpenSettlementApplyService openSettlementApplyService;

	@Autowired
	private SysMsgInfoComponent sysMsgInfoComponent;

	@Autowired
	private PlatformService platformService;

	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;
	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;
	@Autowired
	private ExtOpenSettlementApplyMapper extOpenSettlementApplyMapper;

	@Autowired
	private OpenSettlementApplyMapper openSettlementApplyMapper;
	@Value("${app.environment}")
	private String environment;

	@RequestMapping("/settlement_date")
	public Result<?> getSettlementDate(@RequestParam("service_id") int serviceId) {
		AdminUserInfo adminInfo = getAdminInfo();
		Long uid = adminInfo.getUid();

		CommunityService cs = communityServiceMapper.selectByPrimaryKey(serviceId);
		validator(cs == null, "服务不存在");
		//先看看账号是否绑定了结算账号
		Boolean isBind = platformGlobalComponent.getAccountBindStatus(adminInfo.getMchId(), cs.getAccountId());
		validator(!isBind, "该收款账号未绑定结算账号,请去银行卡管理绑定");

		Date lastSettleTime = getLastSettleTime(uid, cs);
		JSONObject json = new JSONObject();
		json.put("lastSettleTime", DateTimeUtils.formatDate(lastSettleTime));
		Set<String> array = getEndDates(lastSettleTime);
		json.put("endDates", array);
		json.put("environment", environment);
		return Result.successData(json);
	}

	private Date getLastSettleTime(long uid, CommunityService cs) {

		validator(cs == null, "申请失败，该服务不存在!");
		validator(cs.getMerchantId() != uid, "非法操作!");
		String accid = cs.getAccountId();
		//还未生成账号
		validator(StringUtils.isBlank(accid), "您的店铺还没有订单，不能申请提现");
		
		ResponseData<FuPayGetAccountResponseModel> res = platformService.getAccount(accid);
		validator(res.getCode() != 1001, JSON.toJSONString(res));
		FuPayGetAccountResponseModel acc = res.getData();
		// 账号结算状态, 1:存在进行中的结算申请, 2:不存在进行中的结算申请
//		validator(acc.getSettle() != 2, "失败，该服务有正在审批中的提现申请，请等待提现申请完成后再发起新的提现申请。"+accid);
		validator(acc.getStatus() != 1, "申请失败，账号已冻结!"+accid);
		return DateUtils.addDays(acc.getLastSettleTime(), 1);
	}

	// 提现申请
	@RequestMapping("/settlement_apply")
	public Result<?> settlementApply(@RequestParam("service_id") int serviceId,
			@RequestParam(value = "end_date", defaultValue = "") String endDate) {
		validator(!endDate.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"), "申请失败，日期格式不对!如:2017-06-29");
		AdminUserInfo adminInfo = getAdminInfo();
		Long uid = adminInfo.getUid();
		CommunityService cs = communityServiceMapper.selectByPrimaryKey(serviceId);
		//先看看账号是否绑定了结算账号
		Boolean isBind = platformGlobalComponent.getAccountBindStatus(adminInfo.getMchId(), cs.getAccountId());
		validator(!isBind, "该收款账号未绑定结算账号,请去银行卡管理绑定");

		Date lastSettleTime = getLastSettleTime(uid, cs);
		
		OpenSettlementApplyExample ex = new OpenSettlementApplyExample();
		List<Integer> s = new ArrayList<>();
		// 1等待平台审核
		// 2平台审核不通过
		// 3等待支付中心审核
		// 4支付中心审核不通过
		// 5提现成功
		// 8用户主动撤销提现
		s.add(1); //平台审批中的不让它发第二笔
		// s.add(2);
//		s.add(3);
		ex.createCriteria().andServiceIdEqualTo(serviceId)
				.andTypeEqualTo(Constant.OpenAdmin.SettlementApplyType.MERCHANT).andStatusIn(s);
		validator(openSettlementApplyMapper.countByExample(ex) > 0, "申请失败，该服务有正在审批中的提现申请，请等待提现申请完成后再发起新的提现申请.");

		Date startTime = DateTimeUtils.date000000(lastSettleTime);
		Date endTime = DateTimeUtils.date235959(DateTimeUtils.parseDate(endDate));
		Date nowTime = DateTimeUtils.date000000(new Date());
		//不大于当前日期就可以结
		validator(nowTime.getTime() <= endTime.getTime(), "不能大于当前日期");
		
		// 判断是否有退款的单子
		Long countRefund = extOpenSettlementApplyMapper.countServiceRefund(serviceId, startTime, endTime);
		validator(countRefund != null && countRefund > 0, "这个时间段有正在进行的退款单据不能发起结算!总:" + countRefund + " 笔");

		//拆单时间,就是入账时间,现在需要根据入账时间来查询 bill_split_time
		Map<String, Object> map = extOpenSettlementApplyMapper.totelServiceSettlementNew(serviceId, startTime, endTime);
		Integer count = MapUtils.getInteger(map, "count", 0);
		validator(count == 0, String.format("申请失败，[%d]截止到%s，该服务没有可提现的订单",serviceId, endDate));
		BigDecimal orderAmountCount = new BigDecimal(MapUtils.getString(map, "total_amount", "0"));
		BigDecimal platformPoundageAmount = new BigDecimal(MapUtils.getString(map, "platform_charge", "0"));
		BigDecimal platformCommissionAmount = new BigDecimal(MapUtils.getString(map, "service_charge", "0"));
		BigDecimal platformThinkAmount = new BigDecimal(MapUtils.getString(map, "think_charge", "0"));
		BigDecimal refund_money = new BigDecimal(MapUtils.getString(map, "refund_money", "0"));
		BigDecimal receipt_amount = new BigDecimal(MapUtils.getString(map, "receipt_amount", "0"));

		OpenMerchantInfo openMerchantInfo = openMerchantInfoMapper.selectByPrimaryKey(cs.getMerchantId());
		validator(openMerchantInfo == null, "申请失败，商家不存在");

		validator(openMerchantInfo.getStatus() != 1, "申请失败，商家暂不可用");
		OpenSettlementApply openSettlementApply1 = new OpenSettlementApply();
		openSettlementApply1.setAuditComment("");
		openSettlementApply1.setAuditTime(new Date());
		openSettlementApply1.setCreateTime(new Date());
		openSettlementApply1.setInvoiceStatus(Constant.OpenAdmin.InvoiceStatus.NOT_APPLY);
		openSettlementApply1.setAccountId(cs.getAccountId());
		openSettlementApply1.setPfStatus(0);
		openSettlementApply1.setMchId(openMerchantInfo.getMchId());
		openSettlementApply1.setTitle(cs.getTitle());
		openSettlementApply1.setRefundMoney(refund_money);
		openSettlementApply1.setOrderAmountCount(orderAmountCount);
		openSettlementApply1.setOrderCount(count);
		openSettlementApply1.setPlatformCommissionAmount(platformCommissionAmount);
		openSettlementApply1.setPlatformPoundageAmount(platformPoundageAmount);
		openSettlementApply1.setPlatformThinkAmount(platformThinkAmount);
		openSettlementApply1.setServiceId(serviceId);
		openSettlementApply1.setSettlementAmountCount(receipt_amount);
		openSettlementApply1.setSettlementEndTime(endTime);
		openSettlementApply1.setSettlementStartTime(startTime);
		openSettlementApply1.setMerchantId(getAdminId());
		openSettlementApply1
				.setSettlementId(String.format("%d%s", System.nanoTime(), RandomStringUtils.randomNumeric(10)));
		openSettlementApply1.setStatus(Constant.OpenAdmin.SettlementApplyStatus.PLATFORM_AUDIT);
		openSettlementApply1.setType(Constant.OpenAdmin.SettlementApplyType.MERCHANT);
		openSettlementApply1.setPlatformSettlementId("");
		openSettlementApplyService.addSettlementApply(openSettlementApply1);
		Integer id = openSettlementApply1.getId();

		List<String> parameter = new ArrayList<>();
		parameter.add(cs.getTitle());
		sysMsgInfoComponent.addPlatform(SysMsgInfoComponent.ObjectType.open_service_settlement_apply,
				cs.getId().toString(), parameter);
		//
		return Result.successData(id);
	}

	@RequestMapping("/settlement_apply_list")
	public Result<?> getSettlementApplyList(
			@RequestParam(value = "start_create_time", required = false, defaultValue = "") String startCreateTime,
			@RequestParam(value = "end_create_time", required = false, defaultValue = "") String endCreateTime,
			@RequestParam(value = "status", required = false, defaultValue = "0") int status,
			@RequestParam(value = "invoice_status", required = false, defaultValue = "0") int invoiceStatus,
			@RequestParam(value = "settlement_id", required = false, defaultValue = "") String settlementId,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date startCreateDate = null;
		Date endCreateDate = null;

		if (StringUtils.isNotBlank(startCreateTime)) {
			startCreateDate = sdf.parse(startCreateTime);
		}

		if (StringUtils.isNotBlank(endCreateTime)) {
			endCreateDate = sdf.parse(endCreateTime);
		}

		if (startCreateDate != null && endCreateDate != null && startCreateDate.after(endCreateDate)) {
			error("开始时间不能大于结束时间");
		}
		PageList<ExtOpenSettlementApply> list1 = openSettlementApplyService.getSettlementApplyList(startCreateDate,
				endCreateDate, Constant.OpenAdmin.SettlementApplyType.MERCHANT, getAdminId(), status, invoiceStatus,
				settlementId, index, size);

		for (ExtOpenSettlementApply extOpenSettlementApply : list1) {
			extOpenSettlementApply.setPlatformServiceFee(extOpenSettlementApply.getPlatformCommissionAmount()
					.add(extOpenSettlementApply.getPlatformPoundageAmount().add(extOpenSettlementApply.getPlatformThinkAmount())));
		}

		return Result.successData(list1.convert());
	}

	@RequestMapping("/settlement_apply_info")
	public Result<?> getSettlementApplyInfo(@RequestParam("settlement_id") String settlementId) {

		if (StringUtils.isBlank(settlementId)) {
			error("提现单号不能为空");
		}

		PageList<ExtOpenSettlementApply> list = openSettlementApplyService.getSettlementApplyList(null, null,
				Constant.OpenAdmin.SettlementApplyType.MERCHANT, 0, 0, 0, settlementId, 0, 10);

		if (list == null || list.size() == 0) {
			error("根据提现单号：" + settlementId + "查询不到提现申请信息");
		}

		return Result.successData(list.get(0));

	}

	@RequestMapping("/invoice_apply")
	public Result<?> invoiceApply(@RequestParam("id") int id, @RequestParam("invoice_type") int invoiceType,
			@RequestParam("company_name") String companyName,
			@RequestParam(value = "taxpayer_code", required = false, defaultValue = "") String taxpayerCode,
			@RequestParam(value = "company_address", required = false, defaultValue = "") String companyAddress,
			@RequestParam(value = "company_phone", required = false, defaultValue = "") String companyPhone,
			@RequestParam(value = "bank_name", required = false, defaultValue = "") String bankName,
			@RequestParam(value = "bank_account", required = false, defaultValue = "") String bankAccount,
			@RequestParam("contacts_name") String contactsName, @RequestParam("contacts_phone") String contactsPhone,
			@RequestParam("mailing_address") String mailingAddress,
			@RequestParam(value = "invoice_title", required = false, defaultValue = "") String invoiceTitle) {

		OpenSettlementApply openSettlementApply = openSettlementApplyService.getOpenSettlementApply(id);

		if (openSettlementApply == null) {
			error("此提现信息不存在");
		}

		if (openSettlementApply.getStatus() != Constant.OpenAdmin.SettlementApplyStatus.PAY_CENTER_PASS) {
			error("提现单状态不是提现成功，不能进行发票申请");
		}

		if (StringUtils.isBlank(companyName)) {
			error("公司名称或个人姓名不能为空");
		}
		// if(StringUtils.isBlank(taxpayerCode)){
		// error("纳税人识别号不能为空");
		// }
		//
		// if(StringUtils.isBlank(companyAddress)){
		// error("公司地址不能为空");
		// }
		//
		// if(StringUtils.isBlank(companyPhone)){
		// error("公司电话不能为空");
		// }
		//
		// if(StringUtils.isBlank(bankName)){
		// error("开户银行不能为空");
		// }
		//
		// if(StringUtils.isBlank(bankAccount)){
		// error("银行账号不能为空");
		// }

		if (StringUtils.isBlank(contactsName)) {
			error("联系人不能为空");
		}

		if (StringUtils.isBlank(contactsPhone)) {
			error("联系人号码不能为空");
		}

		if (StringUtils.isBlank(mailingAddress)) {
			error("邮寄地址不能为空");
		}

		// if(StringUtils.isBlank(invoiceTitle)){
		// error("发票抬头不能为空");
		// }

		openSettlementApply.setInvoiceStatus(Constant.OpenAdmin.InvoiceStatus.ALREADY_APPLY);
		openSettlementApply.setInvoiceType(invoiceType);
		openSettlementApply.setInvoiceTitle(companyName);
		openSettlementApply.setCompanyName(companyName);
		openSettlementApply.setTaxpayerCode(taxpayerCode);
		openSettlementApply.setCompanyAddress(companyAddress);
		openSettlementApply.setCompanyPhone(companyPhone);
		openSettlementApply.setBankName(bankName);
		openSettlementApply.setBankAccount(bankAccount);
		openSettlementApply.setContactsName(contactsName);
		openSettlementApply.setContactsPhone(contactsPhone);
		openSettlementApply.setMailingAddress(mailingAddress);
		openSettlementApply.setAuditTime(new Date());

		openSettlementApplyService.updateOpenSettlementApply(openSettlementApply);

		/*
		 * List<OpenSettlementApply> list =
		 * openSettlementApplyService.getOpenSettlementApplyList(
		 * openSettlementApply.getSettlementStartTime(),
		 * openSettlementApply.getSettlementEndTime(),
		 * openSettlementApply.getServiceId());
		 * 
		 * if (list != null && list.size() > 0) { for (OpenSettlementApply
		 * settlementApply : list) {
		 * settlementApply.setInvoiceStatus(Constant.OpenAdmin.InvoiceStatus.
		 * ALREADY_APPLY); settlementApply.setInvoiceType(invoiceType);
		 * settlementApply.setInvoiceTitle(companyName);
		 * settlementApply.setCompanyName(companyName);
		 * settlementApply.setTaxpayerCode(taxpayerCode);
		 * settlementApply.setCompanyAddress(companyAddress);
		 * settlementApply.setCompanyPhone(companyPhone);
		 * settlementApply.setBankName(bankName);
		 * settlementApply.setBankAccount(bankAccount);
		 * settlementApply.setContactsName(contactsName);
		 * settlementApply.setContactsPhone(contactsPhone);
		 * settlementApply.setMailingAddress(mailingAddress);
		 * settlementApply.setCreateTime(new Date());
		 * 
		 * openSettlementApplyService.updateOpenSettlementApply(settlementApply); } }
		 */

		return Result.success();
	}

	// 撤销审核
	@RequestMapping("/cancel_settlement_apply")
	public Result<?> cancelSettlementApply(@RequestParam("settlement_id") String settlementId) {
		if (StringUtils.isBlank(settlementId)) {
			error("提现单号不能为空");
		}
		OpenSettlementApply openSettlementApply = openSettlementApplyService.getOpenSettlementApply(settlementId);
		if (openSettlementApply == null) {
			error("根据提现单号：" + settlementId + "查询不到提现申请信息");
		}
		validator(openSettlementApply.getMerchantId() != getAdminId().longValue(), "非法访问!");
		CommunityService serinfo = communityServiceService
				.getCommunityServiceByPrimaryKey(openSettlementApply.getServiceId());

		// 撤销提现审核
		if (Constant.OpenAdmin.SettlementApplyStatus.PLATFORM_AUDIT == openSettlementApply.getStatus()) {
			openSettlementApply.setStatus(Constant.OpenAdmin.SettlementApplyStatus.CANCEL_APPLY);

			openSettlementApplyService.updateOpenSettlementApply(openSettlementApply);
		} else {
			error("提现单不在审核中，不能撤销审核");
		}

		///
		List<String> parameter = new ArrayList<>();
		parameter.add(serinfo.getTitle());
		sysMsgInfoComponent.addPlatform(SysMsgInfoComponent.ObjectType.open_service_settlement_cancel,
				serinfo.getId().toString(), parameter);
		//

		return Result.success();
	}

	private Set<String> getEndDates(Date lastSettleTime) {
		Set<String> array = new LinkedHashSet<>();
		for (int i = 0; i <= 12; i++) {
			Date date = DateUtils.addMonths(lastSettleTime, i);
			Calendar calendar = Calendar.getInstance();
			// 设置时间,当前时间不用设置
			calendar.setTime(date);
			// 设置日期为本月最大日期
			calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
			date = calendar.getTime();
			if (System.currentTimeMillis() - date.getTime() > 16 * 24 * 3600 * 1000L) {
				array.add(DateTimeUtils.formatDate(date));
			}
		}
		if ("test".equals(environment) || "default".equals(environment)) {
			array.add(DateTimeUtils.formatDate(DateUtils.addDays(new Date(), -2)));
		}
		return array;
	}

	@RequestMapping("/getSettlementDetail")
	public Result<?> getSettlementDetail(@RequestParam("sid") String sid) {
		FuPayGetSettlementApplyDetailResponseModel responseModel = platformService.getSettlementApplyDetail(sid);

		return Result.successData(responseModel);
	}

}
