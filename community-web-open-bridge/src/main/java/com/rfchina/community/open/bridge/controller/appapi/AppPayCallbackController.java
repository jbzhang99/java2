package com.rfchina.community.open.bridge.controller.appapi;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.component.JavaMailComponent;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.OpenCautionInfoMapper;
import com.rfchina.community.persistence.mapper.OpenFeeOrderMapper;
import com.rfchina.community.persistence.mapper.OpenFeeOrderPayMapper;
import com.rfchina.community.persistence.mapper.OpenFeeOrderRelaMapper;
import com.rfchina.community.persistence.mapper.OpenOrderMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJStoreMapper;
import com.rfchina.community.persistence.mapper.OpenXfsjSignUpInfoMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.OpenCautionInfo;
import com.rfchina.community.persistence.model.OpenCautionInfoExample;
import com.rfchina.community.persistence.model.OpenFeeOrderPay;
import com.rfchina.community.persistence.model.OpenFeeOrderPayExample;
import com.rfchina.community.persistence.model.OpenFeeOrderRelaExample;
import com.rfchina.community.persistence.model.OpenFeeOrderRelaKey;
import com.rfchina.community.persistence.model.OpenFeeOrderWithBLOBs;
import com.rfchina.community.persistence.model.OpenOrder;
import com.rfchina.community.persistence.model.OpenXFSJStore;
import com.rfchina.community.persistence.model.OpenXFSJStoreExample;
import com.rfchina.community.persistence.model.OpenXfsjSignUpInfo;
import com.rfchina.community.service.openser.OpenCautionInfoSerService;
import com.rfchina.community.service.openser.OpenFeeOrderService;
import com.rfchina.community.service.openser.OpenServiceBusinessService;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_APP)
public class AppPayCallbackController extends BaseController {

	@Autowired
	private OpenOrderMapper openOrderMapper;
	@Autowired
	private OpenCautionInfoMapper openCautionInfoMapper;

	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private OpenServiceBusinessService openServiceBusinessService;
	@Autowired
	private JavaMailComponent javaMailComponent;

	@Value("${balance.receive.email}")
	private String email;
	@Autowired
	private OpenCautionInfoSerService openCautionInfoSerService;
	@Autowired
	private OpenXfsjSignUpInfoMapper openXfsjSignUpInfoMapper;
	@Autowired
	private OpenFeeOrderPayMapper openFeeOrderPayMapper;
	@Autowired
	private OpenFeeOrderRelaMapper openFeeOrderRelaMapper;
	@Autowired
	private OpenFeeOrderMapper openFeeOrderMapper;
	@Autowired
	private OpenXFSJStoreMapper openXFSJStoreMapper;

	// /api/app/open/bridgeapi/pay/callback
	@RequestMapping("/pay/callback")
	public String callback(@RequestParam(value = "id") Long id, @RequestParam(value = "billstatus") int billstatus,
			@RequestParam(value = "bill_id") String bill_id, @RequestParam(value = "trade_status") String trade_status,
			@RequestParam(value = "pay_time") String pay_time) throws Exception {

		logger.info("callback: id:{}, billstatus:{}, bill_id:{}, trade_status:{}, pay_time:{}", id, billstatus, bill_id,
				trade_status, pay_time);
		OpenOrder openOrder = openOrderMapper.selectByPrimaryKey(id);

		validator(openOrder == null, "数据不存在" + id);
		validator(!openOrder.getBillId().equals(bill_id),
				"数据不安全id:" + openOrder.getId() + " bill_id :" + openOrder.getBillId() + "!=" + bill_id);

		// 判断类型作处理 2是保证金， 3是活动缴费
		if (openOrder.getType() == OpenConstant.open_order.Type.caution) {
			return this.cautionCallBack(openOrder, bill_id, id, trade_status, billstatus);
		} else if (openOrder.getType() == OpenConstant.open_order.Type.activity) {
			return this.payActivityCallBack(openOrder, bill_id, id, trade_status, billstatus);
		} else if (openOrder.getType() == OpenConstant.open_order.Type.verify) {
			return this.payFeeOrderCallBack(openOrder, bill_id, id, trade_status, billstatus);
		}
		return "failure";
	}

	/**
	 * @author:fukangwen @Description: 保证金回调处理 @return String @throws
	 */
	private String cautionCallBack(OpenOrder openOrder, String bill_id, Long id, String trade_status, int billstatus) {
		Long cautionId = openOrder.getCautionId();
		OpenCautionInfo caution = openCautionInfoMapper.selectByPrimaryKey(cautionId);
		validator(caution == null, "数据不存在" + id);
		Integer serviceId = openOrder.getServiceId();
		CommunityService ser = communityServiceMapper.selectByPrimaryKey(serviceId);

		// '1,待缴纳,2,已线上缴纳,3线下缴纳待核验,4已线下缴纳,5隐藏,6已退'
		if ("TRADE_PAID_SUCCESS".equalsIgnoreCase(trade_status)) {
			OpenCautionInfo record = new OpenCautionInfo();
			record.setBillStatus(billstatus);
			Date now = new Date();
			record.setBillPayTime(now);
			record.setPayTime(now);
			record.setId(cautionId);
			record.setBillId(bill_id);
			record.setBillCreateTime(openOrder.getBillCreateTime());
			Integer status = 2;
			record.setOpenId(id);
			record.setStatus(status);
			record.setMoneyType("qrcode");
			OpenCautionInfoExample example = new OpenCautionInfoExample();
			example.createCriteria().andIdEqualTo(cautionId).andOpenIdEqualTo(0L);
			int i = openCautionInfoMapper.updateByExampleSelective(record, example);
			if (i > 0) {
				openServiceBusinessService.sendCautionEmail(ser.getMerchantId(), new Date(),
						openOrder.getTotalAmount());
				openCautionInfoSerService.cautionHandle(serviceId, false);
			} else {
				String text = "caution:" + JSON.toJSONString(caution) + "<br><br>openOrder:"
						+ JSON.toJSONString(openOrder) + "<br><br>record:" + JSON.toJSONString(record) + "<br><br>==="
						+ i + "更新不成功!";
				javaMailComponent.sendEmail(email, "自在服务保证金提示", text);
			}

			return "success";
		}
		if ("TRADE_TIMEOUT_CLOSE".equalsIgnoreCase(trade_status)) {
			return "success";
		}

		return "failure";
	}

	/**
	 * @author:fukangwen @Description: 活动缴费回调处理 @return String @throws
	 */
	private String payActivityCallBack(OpenOrder openOrder, String billId, Long id, String trade_status,
			int billstatus) {
		Long signUpInfoId = openOrder.getCautionId();
		OpenXfsjSignUpInfo signUpInfo = openXfsjSignUpInfoMapper.selectByPrimaryKey(signUpInfoId);
		validator(signUpInfo == null, "数据不存在" + id);

		// '1,待缴纳,2,已线上缴纳,3线下缴纳待核验,4已线下缴纳,5隐藏,6已退'
		if ("TRADE_PAID_SUCCESS".equalsIgnoreCase(trade_status)) {
			signUpInfo.setBillId(billId);
			signUpInfo.setBillStatus(billstatus);
			signUpInfo.setBillCreateTime(openOrder.getBillCreateTime());
			signUpInfo.setOrderId(openOrder.getId());
			signUpInfo.setStatus(OpenConstant.SignUpCheckStatus.PAID);
			openXfsjSignUpInfoMapper.updateByPrimaryKey(signUpInfo);

			// 增加小富市集商店
			OpenXFSJStoreExample example = new OpenXFSJStoreExample();
			example.createCriteria().andXfsjIdEqualTo(signUpInfo.getXfsjId())
					.andStoreIdEqualTo(signUpInfo.getServiceId());

			List<OpenXFSJStore> list = openXFSJStoreMapper.selectByExample(example);
			if (list.isEmpty()) {
				OpenXFSJStore info = new OpenXFSJStore();
				info.setOrderby(0);
				info.setStoreId(signUpInfo.getServiceId());
				info.setXfsjId(signUpInfo.getXfsjId());
				info.setCreateTime(new Date());
				openXFSJStoreMapper.insertSelective(info);
			}
			// if (i > 0) {
			// openServiceBusinessService.sendCautionEmail(ser.getMerchantId(), new Date(),
			// openOrder.getTotalAmount());
			// openCautionInfoSerService.cautionHandle(serviceId, false);
			// } else {
			// String text = "caution:" + JSON.toJSONString(caution) + "<br><br>openOrder:"
			// + JSON.toJSONString(openOrder) + "<br><br>record:" +
			// JSON.toJSONString(record) + "<br><br>==="
			// + i + "更新不成功!";
			// javaMailComponent.sendEmail(email, "自在服务保证金提示", text);
			// }
			return "success";
		}
		if ("TRADE_TIMEOUT_CLOSE".equalsIgnoreCase(trade_status)) {
			return "success";
		}

		return "failure";
	}

	private String payFeeOrderCallBack(OpenOrder openOrder, String billId, Long id, String trade_status,
			int billstatus) {

		OpenFeeOrderPayExample example = new OpenFeeOrderPayExample();
		example.createCriteria().andBillIdEqualTo(billId).andOpenIdEqualTo(id);
		List<OpenFeeOrderPay> list = openFeeOrderPayMapper.selectByExample(example);
		validator(list.isEmpty(), "不存在" + billId);
		OpenFeeOrderPay data = list.get(0);
		// '1,待缴纳,2,已线上缴纳,3线下缴纳待核验,4已线下缴纳,5隐藏,6已退'
		if ("TRADE_PAID_SUCCESS".equalsIgnoreCase(trade_status)) {
			data.setPayStatus(OpenFeeOrderService.PayStatus.success.name());
			data.setPayTime(new Date());
			openFeeOrderPayMapper.updateByPrimaryKeySelective(data);
			OpenFeeOrderRelaExample examp = new OpenFeeOrderRelaExample();
			examp.createCriteria().andPayIdEqualTo(data.getId());
			List<OpenFeeOrderRelaKey> lst = openFeeOrderRelaMapper.selectByExample(examp);
			for (OpenFeeOrderRelaKey key : lst) {
				OpenFeeOrderWithBLOBs record = new OpenFeeOrderWithBLOBs();
				record.setId(key.getFeeId());
				record.setPayStatus(OpenFeeOrderService.OrderPayStatus.success.name());
				record.setPayTime(new Date());
				record.setPayId(data.getId());
				openFeeOrderMapper.updateByPrimaryKeySelective(record);
			}

			return "success";
		}
		if ("TRADE_TIMEOUT_CLOSE".equalsIgnoreCase(trade_status)) {
			data.setPayStatus(OpenFeeOrderService.PayStatus.outtime.name());
			openFeeOrderPayMapper.updateByPrimaryKeySelective(data);
			return "success";
		}
		if ("TRADE_SCANED_CODE".equalsIgnoreCase(trade_status)) {

			data.setPayStatus(OpenFeeOrderService.PayStatus.scan.name());

			openFeeOrderPayMapper.updateByPrimaryKeySelective(data);
			return "success";
		}

		return "failure";
	}
}
