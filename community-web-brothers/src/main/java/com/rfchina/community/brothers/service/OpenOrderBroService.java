package com.rfchina.community.brothers.service;

import com.alibaba.fastjson.JSON;
import com.rfchina.api.request.pay.FuPayRefundApplyV2Request.AuditData;
import com.rfchina.api.request.pay.FuPayRefundApplyV2Request.RefundItem;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.pay.*;
import com.rfchina.api.response.model.pay.base.FuPayBillModel2;
import com.rfchina.api.response.model.pay.base.FuPayRefundBillsModel;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenConstant.OpenStoreRefundStatus;
import com.rfchina.community.base.OpenRefundConstant;
import com.rfchina.community.base.OrderPayConstant;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.brothers.mapper.ExtOpenSettCommunityBroExample;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.service.openser.OpenOrderSerService;
import com.rfchina.community.service.openser.OpenServiceTotalSyncService;
import com.rfchina.community.service.openser.OpenSettCommunityGlobalService;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@Service
public class OpenOrderBroService {

	private static Logger logger = LoggerFactory.getLogger(OpenOrderBroService.class);

	@Autowired
	private OpenOrderMapper openOrderMapper;
	@Autowired
	private OpenRefundMapper openRefundMapper;
	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;
	@Autowired
	private OpenSettCommunityMapper openSettCommunityMapper;
	@Autowired
	private PaySettlementInfoMapper paySettlementInfoMapper;
	@Autowired
	private ExtOpenSettCommunityBroExample extOpenSettCommunityBroExample;
	@Autowired
	private CommunityMapper communityMapper;
	@Autowired
	private OpenSettCommunityGlobalService openSettCommunityGlobalService;
	@Autowired
	private OpenServiceTotalSyncService openServiceTotalSyncService;
	@Autowired
	private OpenStoreOrderRefundApplyMapper openStoreOrderRefundApplyMapper;
	@Autowired
	private OpenStoreOrderMapper openStoreOrderMapper;

	@Value("${app.environment}")
	private String environment;

	public void syncServiceAccountNull() {
		updateOpenOrder();

		logger.info("syncServiceAccountNull:{}  ", environment);

		Date startDate;
		Date endDate;

		Calendar now1 = Calendar.getInstance();
		if ("test".equals(environment) || "development".equals(environment)) {
			startDate = DateTimeUtils
					.date000000(DateUtils.addDays(now1.getTime(), -OpenConstant.communtiy_test_BATCH_RUN_day));
			endDate = DateTimeUtils
					.date235959(DateUtils.addDays(now1.getTime(), -OpenConstant.communtiy_test_BATCH_RUN_day));

		} else {
			int day = now1.get(Calendar.DATE);
			if (day != OpenConstant.communtiy_public_BATCH_RUN_day) {
				logger.info("没有到达跑批日,{}", day);
				return;
			}
			Date lastDate = DateUtils.addMonths(now1.getTime(), -1);
			startDate = DateUtils.truncate(lastDate, Calendar.MONTH);
			endDate = new Date(DateUtils.ceiling(lastDate, Calendar.DATE).getTime() - 1);
		}

		OpenSettCommunityExample example = new OpenSettCommunityExample();
		long count = openSettCommunityMapper.countByExample(example);
		if (count == 0) {
			// 第一次上线没有数据的时候,
			startDate = DateTimeUtils.parseDate("2015-5-15");
		}
		// 统计这个时间段有哪些社区能提现

		List<Map<String, Object>> list = extOpenSettCommunityBroExample.selectSettCommunity(startDate, endDate);

		logger.info("syncServiceAccountNull count:{}, startDate:{}, endDate:{} list:{}", count,
				DateTimeUtils.formatDateTime(startDate), DateTimeUtils.formatDateTime(endDate), list.size());
		for (Map<String, Object> map : list) {
			logger.info("syncServiceAccountNull106map:{}", JSON.toJSONString(map));
			Integer communityId = MapUtils.getIntValue(map, "community_id", 0);
			String accountId = MapUtils.getString(map, "service_account", "");
			Community community = communityMapper.selectByPrimaryKey(communityId);
			// String title = community.getName();
			String name = community.getName();
			openSettCommunityGlobalService.singleCommunitySettl(startDate, endDate, count, communityId, accountId,
					name);

			// community_id,service_account,service_account_mchid

		}
	}

	private void updateOpenOrder() {
		// 更新第三方服务的服务账号,主要用于补充过去数据位空的情况
		OpenOrderExample example = new OpenOrderExample();
		example.createCriteria().andServiceAccountIsNull().andBillSplitStatusEqualTo(1)
				.andServiceChargeBillIdIsNotNull();
		List<OpenOrder> list = openOrderMapper.selectByExample(example);
		for (OpenOrder openOrder : list) {
			ResponseData<FuPayGetBillDetailResponseModel> bd = platformGlobalComponent
					.getBillDetail(openOrder.getServiceChargeBillId());
			if (bd.getCode() == 1001) {
				FuPayGetBillDetailResponseModel data = bd.getData();
				OpenOrder o = new OpenOrder();
				o.setId(openOrder.getId());
				o.setServiceAccount(data.getAccountId());
//				o.setBillSplitTime(data.getPayTime());
				if (StringUtils.isBlank(openOrder.getServiceAccountMchid())) {
					ResponseData<FuPayGetAccountResponseModel> model = platformGlobalComponent
							.getAccount(data.getAccountId());
					if (model.getCode() == 1001) {
						o.setServiceAccountMchid(model.getData().getMchId());
					}
				}

				openOrderMapper.updateByPrimaryKeySelective(o);
			}
		}
	}

	public void openOrderUpdateStatus() {
		// 更新支付中心的对账状态,用于退款中间的一步.必须对账成功才能发起对账
		OpenOrderExample example = new OpenOrderExample();
		example.createCriteria().andTypeEqualTo(1).andBillStatusEqualTo(2).andPfBalanceStatusNotEqualTo(2)
				.andBillFinishedTimeLessThanOrEqualTo(new Date(System.currentTimeMillis() - 10 * 3600 * 1000L));
		example.or().andTypeEqualTo(1).andBillStatusEqualTo(2).andPfBussinessBalanceStatusNotEqualTo(2)
				.andBillFinishedTimeLessThanOrEqualTo(new Date(System.currentTimeMillis() - 10 * 3600 * 1000L));
		List<OpenOrder> list = openOrderMapper.selectByExample(example);
		logger.info("openOrderUpdateStatus228OpenOrder.size:{}", list.size());
		for (OpenOrder order : list) {
			// logger.info("openOrderUpdateStatus230status id:{}:billid:{}", order.getId(),
			// order.getBillId());
			_OpenOrderUpdateStatus(order, order.getBillId());
			// orderbill_detail
		}

		example.clear();
		example.createCriteria().andBillStatusEqualTo(1)
				.andBillCreateTimeLessThan(new Date(System.currentTimeMillis() - 4 * 3600 * 1000L));
		list = openOrderMapper.selectByExample(example);
		for (OpenOrder order : list) {
			// 补刀
			logger.info("openOrderUpdateStatus239is budao id:{}:billid:{}", order.getId(), order.getBillId());
			_OpenOrderUpdateStatus(order, order.getBillId());
			// orderbill_detail
		}
	}

	private void _OpenOrderUpdateStatus(OpenOrder order, String billId) {
		if (order.getType() != 1) {
			logger.info("order{},billId:{}", JSON.toJSON(order), billId);
			return;
		}

		// String billId = order.getBillId();
		ResponseData<FuPayGetBillDetailResponseModel2> detail = platformGlobalComponent.getBillDetail2(billId);
		if (detail.getCode() != 1001) {
			logger.error("detail:{}", JSON.toJSONString(detail));
			return;
		}

		FuPayGetBillDetailResponseModel2 model = detail.getData();
		OpenOrder o = new OpenOrder();
		o.setId(order.getId());
		// o.setId(id);
		Integer bs = new Integer(model.getBalanceStatus());
		Integer bbs = new Integer(model.getBussinessBalanceStatus());
		o.setPfBalanceStatus(new Integer(model.getBalanceStatus()));
		o.setPfBussinessBalanceStatus(new Integer(model.getBussinessBalanceStatus()));
		o.setPfRefundStatus(new Integer(model.getRefundStatus()));
		// o.setPfRefundTime(model.getRefundTime());

		// "bussiness_balance_status":"",//业务对账状态, 1:未对账, 2:已对账, 3:对账出错
		if (o.getPfBussinessBalanceStatus() == 2) {
			o.setBalanceStatus(2);
		}

		// 退款状态, 1:退款申请中, 2:退款申请失败, 3:退款申请成功, 4:退款进行中, 5:退款失败, 6:退款成功
		if (new Integer(model.getRefundStatus()) == 6) {
			o.setRefundMoney(order.getTotalAmount());
			o.setRefundStatus(OrderPayConstant.RefundStatus.SUCCESS.getCode());
			o.setWithdrawStatus(2);// 可以提现
			o.setRefundId(model.getRefundId());
			// 退款成功 社区佣金清空
			o.setServiceCharge(BigDecimal.valueOf(0));
			o.setThinkCharge(BigDecimal.valueOf(0));
			o.setReceiptAmount(order.getPlatformCharge() == null ? BigDecimal.valueOf(0)
					: order.getPlatformCharge().multiply(BigDecimal.valueOf(-1)));
		} else {
			o.setRefundMoney(BigDecimal.valueOf(0));
			o.setReceiptAmount(
					order.getTotalAmount().subtract(order.getPlatformCharge()).subtract(order.getServiceCharge()));
		}
		if (bs == 2 && bbs == 2) {
			o.setBillFinishedTime(model.getSuccessTime());
		}

		//// 支付状态, 1:待付款, 2:支付成功, 3:交易关闭(未付款交易超时关闭), 4:交易结束
		if (new Integer(model.getPayStatus()) == 2) {
			o.setBillStatus(2);
			if (order.getWithdrawStatus() == 6) {
				o.setWithdrawStatus(1);
			}
			o.setBillFinishedTime(model.getSuccessTime());
		}
		//// 支付状态, 1:待付款, 2:支付成功, 3:交易关闭(未付款交易超时关闭), 4:交易结束
		if (new Integer(model.getPayStatus()) == 3) {
			o.setBillStatus(6);
			o.setWithdrawStatus(6);
		}

		o.setSettleId(model.getSellerId());

		openOrderMapper.updateByPrimaryKeySelective(o);
	}

	/**
	 * 退款
	 * @throws Exception 
	 */
	public void openOrderRefund() {
		OpenOrderExample example = new OpenOrderExample();
        example.createCriteria().andBillStatusEqualTo(2).andRefundStatusIn(Arrays.asList(1,5)).andPfBalanceStatusEqualTo(2)
                .andPfBussinessBalanceStatusEqualTo(2);
		List<OpenOrder> list = openOrderMapper.selectByExample(example);
		for (OpenOrder order : list) {
			String refundId = order.getRefundId();
			if (StringUtils.isBlank(refundId)) {
				logger.error("openOrderRefund254:{}", JSON.toJSONString(order));
				String title = order.getSubject();
				// String accountId = order.getAccountId();
				String billId = order.getBillId();
				ResponseData<FuPayGetBillDetailResponseModel2> data = platformGlobalComponent.getBillDetail2(billId);
				logger.info("billId:{},data:{}", billId, JSON.toJSONString(data));
				FuPayGetBillDetailResponseModel2 model2 = data.getData();
				String accountId = model2.getAccountId();

				List<AuditData> auditData = null;
				List<RefundItem> refundItem = new ArrayList<>();
				RefundItem e = new RefundItem();
				// "bill_id": "", //必需, 支付中心交易号
				// "out_trade_no": "", //必需, 业务商户订单号，最长64位字符串
				// "subject":"", //必需，商品标题，最长128位字符串
				// "body":"", //必需，商品说明，最长128位字符串
				// "refund_amount": "", //必需, 实际退款金额, 目前只能退商家应收、商家实收
				// "same_way": "1", //必需, 是否原路退款, 1: 原路退款, 2:非原路退款
				int sameWay = order.getSameWay();
				e.setBillId(billId);
				e.setOutTradeNo(order.getCommunityTradeNo());
				e.setSubject(order.getSubject());
				e.setBody(order.getBody());
				e.setRefundAmount(order.getTotalAmount().multiply(BigDecimal.valueOf(100L)).longValue());
				e.setSameWay(sameWay);
				
				//只有模板服务退款才有非原路
				if(OpenRefundConstant.SameWayStatus.no_original == sameWay) {
					OpenStoreOrderRefundApplyExample exampleApply = new OpenStoreOrderRefundApplyExample();
					exampleApply.createCriteria().andBillIdEqualTo(billId);
					exampleApply.setOrderByClause("id desc");
					List<OpenStoreOrderRefundApply> listApply = openStoreOrderRefundApplyMapper.selectByExample(exampleApply);
					if(listApply.isEmpty()) {
						logger.error("OpenStoreOrderRefundApply is null");
						continue;
					}
					OpenStoreOrderRefundApply apply = listApply.get(0);
					logger.info("apply info :{}", apply.toString());
					
					e.setAccountNo(apply.getAccountNo());
					e.setDepositBank(apply.getDepositBank());
					e.setName(apply.getName());
					e.setAccountType(1);
					//给图片生成base64的流
					try {
						e.setConfirmLetter(encodeImageToBase64(apply.getConfirmLetter()));
						
						e.setIdCardFront(encodeImageToBase64(apply.getIdCardFront()));
						
						e.setIdCardRear(encodeImageToBase64(apply.getIdCardRear()));
						
						e.setAccountPic(encodeImageToBase64(apply.getAccountPic()));
						
					}catch (Exception e2) {
						logger.error("getImageBinary is error:{}",e2);
						continue;
					}
				}
				
				refundItem.add(e);
				String refundReason = order.getRefundReason();
				ResponseData<FuPayRefundApplyResponseModel> detail = platformGlobalComponent.refundApply(title,
						accountId, auditData, refundItem, refundReason, sameWay);
				OpenOrder o = new OpenOrder();
				o.setId(order.getId());
				if (detail.getCode() != 1001) {
					logger.error("openOrderRefund267:{}", JSON.toJSONString(detail));
					o.setRefundRemark(detail.getCode() + detail.getMsg());
				} else {
					FuPayRefundApplyResponseModel model = detail.getData();
					o.setRefundRemark(detail.getMsg());
					o.setRefundId(model.getRefundId());
					OpenRefund record = new OpenRefund();
					record.setBillId(order.getBillId());
					record.setCreateTime(new Date());
					record.setOpenId(order.getId());
					record.setRefundId(model.getRefundId());
					record.setStatus(OpenRefundConstant.Status.audit_ing);
					record.setUpdateTime(new Date());
					openRefundMapper.insertSelective(record);
					//FIXME 退款申请提交成功后，修改状态为待支付中心审核
					o.setRefundStatus(OrderPayConstant.RefundStatus.PC_AUDITING.getCode());
					this.updateOpenStoreOrder(order.getServiceId(), order.getOutTradeNo(), OrderPayConstant.RefundStatus.PC_AUDITING.getCode());
				}
				o.setUpdateTime(new Date());
				openOrderMapper.updateByPrimaryKeySelective(o);

			}

		}
	}
	
	/**
     * 将网络图片编码为base64
     * @return
     */
    public  String encodeImageToBase64(String path)  {
    	URL url = null;
		try {
			url = new URL(path);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        //打开链接
    	 String base64 = null;
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            //设置请求方式为"GET"
            conn.setRequestMethod("GET");
            //超时响应时间为5秒
            conn.setConnectTimeout(10 * 1000);
            //通过输入流获取图片数据
            InputStream inStream = conn.getInputStream();
            //得到图片的二进制数据，以二进制封装得到数据，具有通用性
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            //创建一个Buffer字符串
            byte[] buffer = new byte[1024];
            //每次读取的字符串长度，如果为-1，代表全部读取完毕
            int len = 0;
            //使用一个输入流从buffer里把数据读取出来
            while ((len = inStream.read(buffer)) != -1) {
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
                outStream.write(buffer, 0, len);
            }
            //关闭输入流
            inStream.close();
            byte[] data = outStream.toByteArray();
            outStream.close();
            //对字节数组Base64编码
            BASE64Encoder encoder = new BASE64Encoder();
            base64 = encoder.encode(data);
            return base64;//返回Base64编码过的字节数组字符串
        } catch (IOException e) {
            e.printStackTrace();
        }
		return base64;
    }



	// 退款审批
	public void openOrderRefundUpdate() {
		OpenRefundExample example = new OpenRefundExample();
		example.createCriteria().andStatusIn(Arrays.asList(0, 1, 2, 4));
		List<OpenRefund> list = openRefundMapper.selectByExample(example);
		for (OpenRefund openRefund : list) {
			logger.info("{}", JSON.toJSONString(openRefund));
			extOpenRefund(openRefund);
		}

	}

	public void extOpenRefund(OpenRefund openRefund) {
		String refundId = openRefund.getRefundId();
		String refundBillId = openRefund.getRefundBillId();
		if (StringUtils.isBlank(refundBillId)) {
			ResponseData<FuPayRefundBillsModel> data = platformGlobalComponent.refundBillCallbackList(refundId);
			if (data.getCode() != 1001) {
				logger.info("refundId:{},data:{}", refundId, JSON.toJSONString(data));
				return;
			}
			FuPayRefundBillsModel d = data.getData();
			List<Map<String, String>> li1 = d.getRefundBills();
			for (Map<String, String> map : li1) {
				String pay_bill_id = MapUtils.getString(map, "pay_bill_id");
				if (Objects.equals(pay_bill_id, openRefund.getBillId())) {
					OpenRefund record = new OpenRefund();
					record.setId(openRefund.getId());
					refundBillId = MapUtils.getString(map, "refund_bill_id");
					record.setRefundBillId(refundBillId);

					openRefundMapper.updateByPrimaryKeySelective(record);
				}
			}

		}
		Long id = openRefund.getOpenId();
		OpenOrder order = openOrderMapper.selectByPrimaryKey(id);
		if (order == null) {
			logger.error("order is null,{}", JSON.toJSONString(openRefund));
			return;
		}

		Integer status = openRefund.getStatus();
		// "status":"", //'退款单状态, 1:审批中, 2:审批成功, 3:审批失败, 4:退款进行中, 5:退款处理完成,
		// 6:退款处理结束(核对出错或失败). 状态为3,6时需要调用撤消接口后才能再次发起退款申请',

		ResponseData<FuPayGetRefundApplyDetailResponseModel> detail = platformGlobalComponent.getRefundDetail(refundId);
		logger.info("openOrderRefundUpdate333:openRefund:{},data:{}", JSON.toJSONString(openRefund),
				JSON.toJSONString(detail));
		if (detail.getCode() != 1001) {
			return;
		}
		FuPayGetRefundApplyDetailResponseModel model = detail.getData();
		Integer newStatus = Integer.valueOf(model.getStatus());
		// 退款单状态, 1:审批中, 2:审批成功, 3:审批失败, 4:退款进行中, 5:退款处理完成, 6:退款处理结束(核对出错或失败) 7撤销
		if (newStatus == OpenRefundConstant.Status.refund_error
				|| newStatus == OpenRefundConstant.Status.audit_fail) {
			ResponseData<?> res = platformGlobalComponent.refundRevoke(refundId);
			logger.info("openOrderRefundUpdate349:refundId:{},newStatus:{},data:{}", refundId, newStatus,
					JSON.toJSONString(res));
			openRefund.setRevokeCode(JSON.toJSONString(res));
			if (res.getCode() == 1001) {
				OpenOrder r = new OpenOrder();
				r.setId(id);
				r.setUpdateTime(new Date());
				// '退款状态 1：退款审批中，2：退款成功，3：退款失败',
				r.setRefundBillId(refundBillId);
				r.setRefundStatus(OrderPayConstant.RefundStatus.FAILURE.getCode());
				openOrderMapper.updateByPrimaryKeySelective(r);
				//退款失败，同步open_store_order
				this.updateOpenStoreOrder(order.getServiceId(), order.getOutTradeNo(), OpenStoreRefundStatus.error.getCode());
				
				
			} else {
				logger.error("refundId:{},newStatus:{},data:{}", refundId, newStatus, JSON.toJSONString(res));
				return;
			}

			_OpenOrderUpdateStatus(order, openRefund.getBillId());
			if (order.getTotalId() > 0) {
				openServiceTotalSyncService.syncOrderTotal(order.getTotalId());
			}
		} else
		// 平台退款成功,留到我们处理退款流程
		if (newStatus == OpenRefundConstant.Status.refund_success) {
			//

			OpenOrder r = new OpenOrder();
			r.setId(id);
			r.setUpdateTime(new Date());
			// '退款状态 1：退款审批中，2：退款成功，3：退款失败',
			r.setRefundStatus(OrderPayConstant.RefundStatus.SUCCESS.getCode());
			// 退款的billId
			r.setRefundBillId(refundBillId);

			if (order.getWithdrawStatus() == 1) {
				r.setWithdrawStatus(2);

			}
			logger.info("order369,id:{}:r{},order:{}", id, JSON.toJSONString(r), JSON.toJSONString(order));

			// 拿到退款的时间
			ResponseData<FuPayBillModel2> data = platformGlobalComponent.getRefundBillDetail(refundBillId);
			logger.info("refundBillId:{},data:{}", refundBillId, JSON.toJSONString(data));
			FuPayBillModel2 model2 = data.getData();
			r.setPfRefundTime(model2.getSuccessTime());
			String refundAccountId = model2.getAccountId();
			r.setRefundAccountId(refundAccountId);
			openRefund.setRefundAccountId(refundAccountId);
			openOrderMapper.updateByPrimaryKeySelective(r);
			_OpenOrderUpdateStatus(order, openRefund.getBillId());
			if (order.getTotalId() > 0) {
				openServiceTotalSyncService.syncOrderTotal(order.getTotalId());
			}
		} else if (newStatus == OpenRefundConstant.Status.refund_reback) {
			//7 已经撤销
			OpenOrder r = new OpenOrder();
			r.setId(id);
			r.setUpdateTime(new Date());
			// '退款状态 1：退款审批中，2：退款成功，3：退款失败',
			r.setRefundBillId(refundBillId);
			r.setRefundStatus(OrderPayConstant.RefundStatus.MERCHANT_AUDITING.getCode());
			openOrderMapper.updateByPrimaryKeySelective(r);
			
			//退款失败，同步open_store_order
			this.updateOpenStoreOrder(order.getServiceId(), order.getOutTradeNo(), OpenStoreRefundStatus.error.getCode());
			
			if (order.getTotalId() > 0) {
				openServiceTotalSyncService.syncOrderTotal(order.getTotalId());
			}
		} else {

			if (StringUtils.isBlank(order.getRefundBillId())) {
				OpenOrder r = new OpenOrder();
				r.setId(id);
				r.setUpdateTime(new Date());
				r.setRefundBillId(refundBillId);
				openOrderMapper.updateByPrimaryKeySelective(r);
			}
		}
		openRefund.setUpdateTime(new Date());
		openRefund.setStatus(newStatus);
		openRefundMapper.updateByPrimaryKeySelective(openRefund);

	}

	private void updateOpenStoreOrder(Integer serviceId, String outTradeNo, int refundStatus) {
		OpenStoreOrderExample example = new OpenStoreOrderExample();
		example.createCriteria().andServiceIdEqualTo(serviceId).andOutTradeNoEqualTo(outTradeNo);
		List<OpenStoreOrder> list = openStoreOrderMapper.selectByExample(example);
		if(list.isEmpty())
			return;
		
		OpenStoreOrder storeOrder = list.get(0);
		storeOrder.setRefundStatus(refundStatus);
		openStoreOrderMapper.updateByPrimaryKeySelective(storeOrder);
	}
	
}
