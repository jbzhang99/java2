package com.rfchina.community.openapi.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.openapi.base.Result;
import com.rfchina.community.openapi.entity.ExtOrder;
import com.rfchina.community.openapi.service.CommunityServiceInfoService;
import com.rfchina.community.persistence.mapper.OpenOrderMapper;
import com.rfchina.community.persistence.model.CommunityServiceTemp;
import com.rfchina.community.persistence.model.OpenOrder;
import com.rfchina.community.persistence.model.OpenOrderExample;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPEN)
public class OpenOrderController extends BaseController {

	@Autowired
	private OpenOrderMapper openOrderMapper;

	@Autowired
	private CommunityServiceInfoService communityServiceInfoService;

	private static transient Logger logger = LoggerFactory.getLogger(OpenOrderController.class);

	@RequestMapping("/update_order_out_status")
	public Result<?> updateOrderOutStatus(@RequestParam(value = "__app_id") Long appId,
			@RequestParam(value = "out_trade_no") String outTradeNo,
			@RequestParam(value = "out_status") Integer outStatus,
			@RequestParam(value = "out_status_content") String outStatusContent) throws Exception {

		logger.info("edit_order_out_status appId:{}, outStatusContent:{},outStatus:{}", appId, outStatusContent,
				outStatus);
		validator(appId == null, "appId 不能为空");
		validator(outStatus != 1 && outStatus != 2, "out_status 订单状态 1 进行中,2完成订单");
		validator(StringUtils.isBlank(outStatusContent), "状态标题 不能为空");
		validator(outStatusContent.length() > 20, "状态标题 长度不能超过20");
		// 服务是否为正式服务
		CommunityServiceTemp ser = communityServiceInfoService.getCommunityServiceTemp(appId);
		// 查询服务商信息
		communityServiceInfoService.getOpenMerchantInfo(ser.getMerchantId(), appId);

		OpenOrderExample example = new OpenOrderExample();
		example.createCriteria().andAppIdEqualTo(appId).andOutTradeNoEqualTo(outTradeNo);
		List<OpenOrder> list = openOrderMapper.selectByExample(example);

		validator(list.isEmpty(), "订单不存在:" + outTradeNo);
		validator(list.size() != 1, "订单重复:" + outTradeNo);
		for (OpenOrder openOrder : list) {
			OpenOrder record = new OpenOrder();
			record.setId(openOrder.getId());
			record.setOutStatus(outStatus);
			record.setOutStatusContent(outStatusContent);
			record.setUpdateTime(new Date());
			openOrderMapper.updateByPrimaryKeySelective(record);
		}

		return Result.success();
	}

	
	@RequestMapping("/order_info")
	public Result<?> getOrderInfo(@RequestParam(value = "__app_id") Long appId,
									@RequestParam("out_trade_no") String outTradeNo) throws IllegalAccessException, InvocationTargetException{
		OpenOrderExample example = new OpenOrderExample();
		example.createCriteria().andAppIdEqualTo(appId).andOutTradeNoEqualTo(outTradeNo);
		List<OpenOrder> list = openOrderMapper.selectByExample(example);
		
		validator(list == null || list.size() == 0, "订单号："+outTradeNo+",对应的订单不存在");
		
		ExtOrder extOrder = new ExtOrder();
		OpenOrder openOrder = list.get(0);
		
//		BeanUtils.copyProperties(extOrder, openOrder);
		extOrder.setBill_status(openOrder.getBillStatus());
		extOrder.setCommunity_trade_no(openOrder.getCommunityTradeNo());
		extOrder.setOut_trade_no(openOrder.getOutTradeNo());
		extOrder.setRefund_status(openOrder.getRefundStatus());
		extOrder.setTotal_amount(openOrder.getTotalAmount());
		
		return Result.successData(extOrder);
	}
}
