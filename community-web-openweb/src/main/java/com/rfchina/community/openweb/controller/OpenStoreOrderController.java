package com.rfchina.community.openweb.controller;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant.OpenStoreExpressType;
import com.rfchina.community.base.OrderPayConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.SysConstant;
import com.rfchina.community.openweb.service.OpenStoreOrderService;
import com.rfchina.community.openweb.service.CommunityServiceService;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.OpenStoreOrder;
import com.rfchina.community.service.openser.ExpressCompanyService;
import com.rfchina.platform.common.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.paginator.model.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 */
@RestController
@RequestMapping(value = { Constant.ROOT_PATH_OPENWEB })
public class OpenStoreOrderController extends BaseController {

	@Autowired
	private OpenStoreOrderService openStoreOrderService;
	@Autowired
	private ExpressCompanyService expressCompanyService;
	@Autowired
	private CommunityServiceService communityServiceService;

	@Value("${app.environment}")
	private String environment;

	/**
	 * @throws ParseException
	 * @author:fukangwen @Description: 订单管理 @return Result<?> @throws
	 */
	@RequestMapping(value = { "/store_order_page_query" })
	public Result<?> getServiceTemplete(@RequestParam(value = "serviceId", required = true) int serviceId,
			@RequestParam(value = "sendStatus", required = false) Integer sendStatus,
			@RequestParam(value = "orderCode", required = false) String orderCode,
			@RequestParam(value = "outTradeNo", required = false) String outTradeNo,
			@RequestParam(value = "userName", required = false, defaultValue = "") String userName,
			@RequestParam(value = "mobile", required = false, defaultValue = "") String mobile,
			@RequestParam(value = "startCreateTime", required = false, defaultValue = "") String startCreateTime,
			@RequestParam(value = "endCreateTime", required = false, defaultValue = "") String endCreateTime,
			@RequestParam(value = "verifyStatus", required = false, defaultValue = "") String verifyStatus,
			@RequestParam(value = "refundStatus", required = false) Integer refundStatus,
			@RequestParam(value = "commentStatus", required = false) Integer commentStatus,
			@RequestParam(value = "isRefundOrder", required = false) Integer isRefundOrder,
			@RequestParam(value = "groupStatus", required = false) Integer groupStatus,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws ParseException {
		Map<String, Object> param = buildQueryParam(serviceId, sendStatus, orderCode, outTradeNo, userName, mobile, startCreateTime, endCreateTime,
				verifyStatus, refundStatus, commentStatus, isRefundOrder, groupStatus);
		PageBounds pageBounds = new PageBounds(index, size);
		return Result.successData(openStoreOrderService.pageQuery(param, pageBounds));
	}

	private Map<String, Object> buildQueryParam(int serviceId, Integer sendStatus, String orderCode, String outTradeNo, String userName, String mobile,
			String startCreateTime,  String endCreateTime, String verifyStatus, Integer refundStatus,  Integer commentStatus, Integer isRefundOrder,Integer groupStatus) throws ParseException {
		Long adminId = getAdminId();
		if (adminId < 0) {
			error("参数有误");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startCreateDate = null;
		Date endCreateDate = null;
		if (StringUtils.isNotBlank(startCreateTime)) {
			startCreateDate = sdf.parse(startCreateTime);
		}
		if (StringUtils.isNotBlank(endCreateTime)) {
			endCreateDate = sdf.parse(endCreateTime);
		}

		Map<String, Object> param = new HashMap<>();
		validator(serviceId <= 0, "服务不存在");
		param.put("serviceId", serviceId);

		if (sendStatus != null) {
			param.put("sendStatus", sendStatus);
		}
		if (StringUtils.isNotBlank(orderCode)) {
			param.put("orderCode", "%" + orderCode + "%");
		}
		if (StringUtils.isNotBlank(outTradeNo)) {
			param.put("outTradeNo", "%" + outTradeNo + "%");
		}
		if (StringUtils.isNotBlank(userName)) {
			param.put("userName", "%" + userName + "%");
		}
		if (StringUtils.isNotBlank(mobile)) {
			param.put("mobile", "%" + mobile + "%");
		}

		if (StringUtils.isNotBlank(verifyStatus)) {
			param.put("verifyStatus", verifyStatus);
		}
		if (refundStatus != null) {
			param.put("refundStatus", refundStatus);
		}
		if (isRefundOrder != null && isRefundOrder.intValue() == 1) {
			param.put("isRefundOrder", isRefundOrder);
		}
		if (startCreateDate != null) {
			param.put("startCreateDate", startCreateDate);
		}
		if (endCreateDate != null) {
			param.put("endCreateDate", endCreateDate);
		}
		if (commentStatus != null) {
			param.put("commentStatus", commentStatus);
		}
		if (groupStatus != null) {
			param.put("groupStatus", groupStatus);
		}
		
		return param;
	}

	/**
	 * @Author wlrllr
	 * @Description 导出订单
	 * @Date 2019/4/15
	 * @return void
	 **/
	@RequestMapping(value = { "/store_order_export" })
	public void exportOrder(@RequestParam(value = "serviceId") int serviceId,
										@RequestParam(value = "sendStatus", required = false) Integer sendStatus,
										@RequestParam(value = "orderCode", required = false) String orderCode,
										@RequestParam(value = "outTradeNo", required = false) String outTradeNo,
										@RequestParam(value = "userName", required = false, defaultValue = "") String userName,
										@RequestParam(value = "mobile", required = false, defaultValue = "") String mobile,
										@RequestParam(value = "startCreateTime", required = false, defaultValue = "") String startCreateTime,
										@RequestParam(value = "endCreateTime", required = false, defaultValue = "") String endCreateTime,
										@RequestParam(value = "verifyStatus", required = false, defaultValue = "") String verifyStatus,
										@RequestParam(value = "refundStatus", required = false) Integer refundStatus,
										@RequestParam(value = "commentStatus", required = false) Integer commentStatus,
							            @RequestParam(value = "groupStatus", required = false) Integer groupStatus,
										@RequestParam(value = "isRefundOrder", required = false) Integer isRefundOrder) throws ParseException {
		Map<String, Object> param = buildQueryParam(serviceId, sendStatus, orderCode, outTradeNo, userName, mobile, startCreateTime, endCreateTime,
				verifyStatus, refundStatus, commentStatus, isRefundOrder, groupStatus);
		StringBuilder fileName = new StringBuilder("订单明细_");
		try (XSSFWorkbook wb = openStoreOrderService.exportOrder(param); OutputStream outputStream = response.getOutputStream()) {
			CommunityService communityService = communityServiceService.getCommunityServiceByPrimaryKey(serviceId);
			if (communityService != null) {
				fileName.append(communityService.getTitle()).append("_");
			}
			fileName.append(DateUtil.formatDate(new Date(), "yyyyMMdd")).append(".xlsx");
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName.toString(), "UTF-8"));
			wb.write(outputStream);
			outputStream.flush();
		} catch (IOException e) {
			error("下载文件失败");
		}
	}

	/**
	 * @throws ParseException
	 * @author:fukangwen @Description: 发货 @return Result<?> @throws
	 */
	@RequestMapping(value = { "/store_send_express" })
	public Result<?> sendExpress(@RequestParam(value = "orderId", required = true) int orderId,
			@RequestParam(value = "expressType", required = true) String expressType,
			@RequestParam(value = "expressName", required = false) String expressName,
			@RequestParam(value = "expressCode", required = false) String expressCode,
			 @RequestParam(value = "expressCompanyCode", required = false) String expressCompanyCode,
			@RequestParam(value = "expressTime", required = false) String expressTime,
			@RequestParam(value = "expressArea", required = false) String expressArea,
			@RequestParam(value = "expressPhone", required = false) String expressPhone) throws ParseException {
		Long adminid = getAdminId();
		if (adminid < 0) {
			error("参数有误");
		}
		OpenStoreOrder openStoreOrder = openStoreOrderService.getOpenStoreOrder(orderId);
		// 权限检查
		authorityCheck(openStoreOrder.getServiceId());

		// 判断参数
		validator(!OpenStoreExpressType.isExist(expressType), "配送方式不存在");

		if (OpenStoreExpressType.EXPRESS.getCode().equals(expressType)) {
			validator(StringUtils.isBlank(expressName), "快递名称不能为空");
			validator(StringUtils.isBlank(expressCode), "快递单号不能为空");
		} else if (OpenStoreExpressType.SELF.getCode().equals(expressType)) {
			validator(StringUtils.isBlank(expressTime), "自提时间不能为空");
			validator(StringUtils.isBlank(expressArea), "自提地点不能为空");
		} else if (OpenStoreExpressType.VISIT.getCode().equals(expressType)) {
			validator(StringUtils.isBlank(expressTime), "上门时间不能为空");
			validator(StringUtils.isBlank(expressPhone), "联系方式不能为空");
		}

		openStoreOrder.setExpressType(expressType);
		openStoreOrder.setExpressCode(expressCode);
		openStoreOrder.setExpressName(expressName);
		openStoreOrder.setExpressPhone(expressPhone);
		openStoreOrder.setExpressArea(expressArea);
		openStoreOrder.setExpressTime(expressTime);
		openStoreOrder.setSendStatus(OrderPayConstant.SendStatus.SEND.getCode());
		openStoreOrder.setSendTime(new Date());

		if(StringUtils.isNotBlank(expressCompanyCode)){
			openStoreOrder.setExpressCompanyCode(expressCompanyCode);
			openStoreOrder.setExpressStatus(SysConstant.EXPRESS_STATUS_PROCESS);
			expressCompanyService.addExpressUsage(openStoreOrder.getServiceId().longValue(),expressCompanyCode,expressName);
		}
		openStoreOrderService.save(openStoreOrder);

		return Result.success();
	}

	
	/**
	 * @author:fukangwen
	 * @Description: 订单详情
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/store_order_get_detail")
	public Result<?> getDetail(
			@RequestParam(value="order_id", required = true) int orderId){
		Long adminid = getAdminId();
		validator(adminid < 0, "参数有误");
		return Result.successData(openStoreOrderService.getDetail(orderId));
	}

}
