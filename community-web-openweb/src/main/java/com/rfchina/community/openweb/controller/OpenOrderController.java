package com.rfchina.community.openweb.controller;

import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.pay.FuPayGetBillDetailResponseModel;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.openweb.entity.ExtOpenOrder;
import com.rfchina.community.openweb.service.OpenWebOrderService;
import com.rfchina.community.openweb.service.PlatformService;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENWEB)
public class OpenOrderController extends BaseController {

	@Autowired
	private OpenWebOrderService openOrderService;
	@Autowired
	private PlatformService platformService;

	@Value("${app.environment}")
	private String environment;


	@RequestMapping("/order_list")
	public Result<?> getOpenOrderList(
			@RequestParam(value = "start_create_time", required = false, defaultValue = "") String startCreateTime,
			@RequestParam(value = "end_create_time", required = false, defaultValue = "") String endCreateTime,
			@RequestParam(value = "start_bill_finished_time", required = false, defaultValue = "") String startBillFinishedTime,
			@RequestParam(value = "end_bill_finished_time", required = false, defaultValue = "") String endBillFinishedTime,
			@RequestParam(value = "start_bill_split_time", required = false, defaultValue = "") String startBillSplitTime,
			@RequestParam(value = "end_bill_split_time", required = false, defaultValue = "") String endBillSplitTime,
			@RequestParam(value = "service_id", required = false, defaultValue = "0") int serviceId,
			@RequestParam(value = "bill_status", required = false, defaultValue = "0") int billStatus,
			@RequestParam(value = "refund_status", required = false, defaultValue = "0") int refundStatus,
			@RequestParam(value = "withdraw_status", required = false, defaultValue = "0") int withdrawStatus,
			@RequestParam(value = "platform_bill_id", required = false, defaultValue = "") String platformBillId,
			@RequestParam(value = "service_bill_id", required = false, defaultValue = "") String serviceBillId,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date startCreateDate = null;
		Date endCreateDate = null;
		Date startBillSplitDate = null;
		Date endBillSplitDate = null;
		if (StringUtils.isNotBlank(startBillSplitTime)) {
			startBillSplitDate = DateTimeUtils.date000000(sdf.parse(startBillSplitTime.trim()));
		}
		if (StringUtils.isNotBlank(endBillSplitTime)) {
			endBillSplitDate = DateTimeUtils.date235959(sdf.parse(endBillSplitTime.trim()));
		}
		if (StringUtils.isNotBlank(startCreateTime)) {
			startCreateDate = DateTimeUtils.date000000(sdf.parse(startCreateTime.trim()));
		}

		if (StringUtils.isNotBlank(endCreateTime)) {
			endCreateDate = DateTimeUtils.date235959(sdf.parse(endCreateTime.trim()));
		}

		if (startCreateDate != null && endCreateDate != null && startCreateDate.after(endCreateDate)) {
			error("开始时间不能大于结束时间");
		}

		Date startBillFinishedDate = null;
		Date endBillFinishedDate = null;

		if (StringUtils.isNotBlank(startBillFinishedTime)) {
			startBillFinishedDate = DateTimeUtils.date000000(sdf.parse(startBillFinishedTime.trim()));
		}

		if (StringUtils.isNotBlank(endBillFinishedTime)) {
			endBillFinishedDate = DateTimeUtils.date235959(sdf.parse(endBillFinishedTime.trim()));
		}

		if (startBillFinishedDate != null && endBillFinishedDate != null
				&& startBillFinishedDate.after(endBillFinishedDate)) {
			error("开始时间不能大于结束时间");
		}

		PageList<ExtOpenOrder> list = openOrderService.getOpenOrderList(startCreateDate, endCreateDate,
				startBillFinishedDate, endBillFinishedDate, getAdminId().intValue(), serviceId, billStatus,
				refundStatus, withdrawStatus, platformBillId, serviceBillId, startBillSplitDate, endBillSplitDate,
				index, size);
		for (ExtOpenOrder extOpenOrder : list) {
			extOpenOrder.setPlatformServiceFee(extOpenOrder.getPlatformCharge().add(extOpenOrder.getServiceCharge()).add(extOpenOrder.getThinkCharge()));
		}

		return Result.successData(list.convert());
	}

	@RequestMapping("/order_info")
	public Result<?> getOpenOrderInfo(@RequestParam("bill_id") String billId) {
		return Result.successData(openOrderService.getOpenOrder(billId));

	}

	@RequestMapping("/get_order_info_by_id")
	public Result<?> getOpenOrderInfoById(@RequestParam("id") Long id) {
		return Result.successData(openOrderService.getOpenOrder(id));

	}

	@RequestMapping("/export_order")
	public Result<?> exportOrder(
			@RequestParam(value = "start_create_time", required = false, defaultValue = "") String startCreateTime,
			@RequestParam(value = "end_create_time", required = false, defaultValue = "") String endCreateTime,
			@RequestParam(value = "start_bill_split_time", required = false, defaultValue = "") String startBillSplitTime,
			@RequestParam(value = "end_bill_split_time", required = false, defaultValue = "") String endBillSplitTime,
			@RequestParam(value = "service_id", required = false, defaultValue = "0") int serviceId,
			@RequestParam(value = "bill_status", required = false, defaultValue = "0") int billStatus,
			@RequestParam(value = "refund_status", required = false, defaultValue = "0") int refundStatus,
			@RequestParam(value = "withdraw_status", required = false, defaultValue = "0") int withdrawStatus,
			@RequestParam(value = "platform_bill_id", required = false, defaultValue = "") String platformBillId,
			@RequestParam(value = "service_bill_id", required = false, defaultValue = "") String serviceBillId) {

		InputStream is = null;
		OutputStream os = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Date startDate = null;
			Date endDate = null;
			Date startBillSplitDate = null;
			Date endBillSplitDate = null;
			if (StringUtils.isNotBlank(startBillSplitTime)) {
				startBillSplitDate = DateTimeUtils.date000000(sdf.parse(startBillSplitTime.trim()));
			}
			if (StringUtils.isNotBlank(endBillSplitTime)) {
				endBillSplitDate = DateTimeUtils.date235959(sdf.parse(endBillSplitTime.trim()));
			}

			if (StringUtils.isNotBlank(startCreateTime)) {
				startDate = DateTimeUtils.date000000(sdf.parse(startCreateTime));
			}

			if (StringUtils.isNotBlank(endCreateTime)) {
				endDate = DateTimeUtils.date235959(sdf.parse(endCreateTime));
			}

			if (startDate != null && endDate != null && endDate.before(startDate)) {
				error("开始时间大于结束时间");
			}

			// 生成文件
			String filePath = openOrderService.exportOrder(startDate, endDate,startBillSplitDate, endBillSplitDate,getAdminId().intValue(), serviceId,
					billStatus, refundStatus, withdrawStatus, platformBillId, serviceBillId);
			if (filePath == null) {
				error("导出资金流水失败");
			}

			// 把生成的文件进行导出
			File file = new File(filePath);
			is = new BufferedInputStream(new FileInputStream(file));
			os = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream;charset=utf-8");
			response.addHeader("Content-Disposition", "attachment;filename="
					+ new String((file.getName().split("_")[0] + ".xlsx").getBytes(), "iso-8859-1"));
			response.addHeader("Content-Length", "" + file.length());
			int len = 0;
			byte[] buffer = new byte[2048];
			while ((len = is.read(buffer, 0, buffer.length)) != -1) {
				os.write(buffer, 0, len);
			}
			logger.debug("导出资金流水完成");
		} catch (Exception e) {
			logger.error("导出资金流水异常",e);
			error("导出资金流水失败");
		} finally {
			try {
				if (os != null) {
					os.close();
				}

				if (is != null) {
					is.close();
				}
			} catch (Exception e2) {
				error("导出平台手续费出错");
			}
		}

		return Result.success();
	}

	@RequestMapping("/getBillDetail")
	public Result<?> getBillDetail(@RequestParam("bill_id") String billId) {
		if (!"test".equals(environment)) {
			return null;
		}
		ResponseData<FuPayGetBillDetailResponseModel> data = platformService.getBillDetail(billId);
		return Result.successData(data);
	}


}
