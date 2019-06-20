package com.rfchina.community.open.bridge.controller.platform;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.base.util.MyUtils;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.service.OpenOrderService;
import com.rfchina.community.persistence.mapper.CommunityMapper;
import com.rfchina.community.persistence.mapper.OpenOrderMapper;
import com.rfchina.community.persistence.model.Community;
import com.rfchina.community.persistence.model.OpenOrder;
import com.rfchina.community.persistence.model.OpenOrderExample;
import com.rfchina.community.persistence.model.OpenOrderExample.Criteria;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class OpenOrderDownPFController extends BaseController {

	@Autowired
	private OpenOrderMapper openOrderMapper;
	@Autowired
	private CommunityMapper communityMapper;
	@Autowired
	private OpenOrderService openOrderService;


	// 资金统计
	@RequestMapping("/downOpenOrderByService")
	public void downOpenOrderByService(@RequestParam(value = "id", required = false, defaultValue = "0") int id,
			@RequestParam(value = "communityId", required = false, defaultValue = "0") Long communityId,
			HttpServletResponse response) throws Exception {

		OpenOrderExample example = new OpenOrderExample();
		Criteria c = example.createCriteria();
		if (id > 0) {
			c.andServiceIdEqualTo(id);
		}
		if (communityId > 0) {
			c.andCommunityIdEqualTo(communityId);
		}
		c.andBillStatusEqualTo(2);
		List<Integer> typeList = new ArrayList<Integer>();
		typeList.add(1);
		typeList.add(4);
		c.andTypeIn(typeList);
		List<OpenOrder> list = openOrderMapper.selectByExample(example);

		// bill_status=2 支付状态
		// type=1 订单类型，1：正常交易单，2：保证金单
		// balance_status=2 对账状态，1:未对账, 2:已对账, 3:对账出错
		// withdraw_status=2,3,5 '提现状态 1：未到提现时间，2：可提现，3：提现审批中，4：提现成功，5：提现失败',

		String fileName = "第三方订单" + DateTimeUtils.format(new Date(), "_yyyyMMdd_HHmmss") + ".xlsx";
		response.setContentType("application/octet-stream;charset=utf-8");
		response.addHeader("Content-Disposition",
				"attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
		ServletOutputStream stream = response.getOutputStream();
		Workbook workbook = new XSSFWorkbook();
		try {
			Sheet sheet = workbook.createSheet("open");
			Integer r1 = 1;

			int cnum = 0;

			Map<Long, Community> map = new HashMap<Long, Community>();

			for (OpenOrder a : list) {
				Long key = a.getCommunityId();
				Community name = map.get(key);
				if (name == null) {
					Community community = communityMapper.selectByPrimaryKey(key.intValue());
					if (community == null) {
						community = new Community();
						community.setName("" + key);
						community.setAddress("" + key);

					}
					map.put(key, community);
				}
			}

			for (OpenOrder a : list) {

				cnum = 0;
				Row row = sheet.createRow(r1++);
				setCell(row, cnum++, a.getId());
				setCell(row, cnum++, a.getAppId());
				setCell(row, cnum++, a.getServiceId());
				setCell(row, cnum++, a.getUid());
				setCell(row, cnum++, a.getCommunityId());
				setCell(row, cnum++, map.get(a.getCommunityId()).getName());
				setCell(row, cnum++, map.get(a.getCommunityId()).getAddress());
				setCell(row, cnum++, a.getPayChannel());
				setCell(row, cnum++, a.getBillId());
				setCell(row, cnum++, a.getBillCreateTime());
				setCell(row, cnum++, a.getBillFinishedTime());
				setCell(row, cnum++, OpenConstant.open_order.BillStatus.translate(a.getBillStatus()));
				setCell(row, cnum++, a.getOutTradeNo());
				setCell(row, cnum++, a.getCommunityTradeNo());
				setCell(row, cnum++, a.getTotalAmount());
				setCell(row, cnum++, a.getReceiptAmount());
				setCell(row, cnum++, a.getPlatformChargeRate());
				setCell(row, cnum++, a.getPlatformCharge());
				setCell(row, cnum++, a.getServiceChargeRate());
				setCell(row, cnum++, a.getServiceCharge());
				setCell(row, cnum++, OpenConstant.open_order.BillSplitStatus.translate(a.getBillSplitStatus()));
				setCell(row, cnum++, a.getBillSplitTime());
				setCell(row, cnum++, a.getMerchantBillId());
				setCell(row, cnum++, a.getServiceAccount());
				setCell(row, cnum++, a.getServiceChargeBillId());
				setCell(row, cnum++, OpenConstant.open_order.ServiceChargeStatus.translate(a.getServiceChargeStatus()));
				setCell(row, cnum++, OpenConstant.open_order.WithdrawStatus.translate(a.getWithdrawStatus()));
				setCell(row, cnum++, OpenConstant.open_order.RefundStatus.translate(a.getRefundStatus()));
				setCell(row, cnum++, a.getRefundMoney());
				setCell(row, cnum++, a.getRefundId());
				setCell(row, cnum++, a.getPfBalanceStatus());
				setCell(row, cnum++, a.getPfBussinessBalanceStatus());
				setCell(row, cnum++, a.getPfRefundStatus());
				setCell(row, cnum++, a.getPfRefundTime());
				setCell(row, cnum++, a.getTixianCommunity());
				// setCell(row, cnum++, a.getTixianThrid());
				// setCell(row, cnum++, a.get);
				// setCell(row, cnum++, a.get);

			}

			if (true) {
				String titles = "ID,appid,服务id,用户UID,社区id,社区名称,社区地址,支付渠道,BILLID,订单创建时间,完成支付时间,支付状态,"
						+ "第三方账号,支付中心账号,总金额,实收金额,平台手续率,平台手续费,社区手续率,社区手续费,拆单状态,"
						+ "拆单时间,母对应的子单,社区结算账号,社区billID,社区状态,提现状态,退款状态,退款金额,退款ID,"
						+ "平台渠道对账状态,平台业务对账状态,平台退款状态,平台退款时间,社区提现单";
				String[] ts = titles.split(",");
				Row row = sheet.createRow(0);
				for (int i = 0; i < cnum; i++) {
					setCell(row, i, (ts.length <= i ? "A" + i : ts[i]));
				}
			}
			workbook.write(stream);
		} finally {
			IOUtils.closeQuietly(workbook);
		}
	}

	private void setCell(Row row, int cnum, Object obj) {
		MyUtils.setCell(row, cnum, obj);
	}


	@RequestMapping("/export_order")
	public void exportOrder(
			@RequestParam(value = "start_create_time", required = false, defaultValue = "") String startCreateTime,
			@RequestParam(value = "end_create_time", required = false, defaultValue = "") String endCreateTime,
			@RequestParam(value = "start_bill_split_time", required = false, defaultValue = "") String startBillSplitTime,
			@RequestParam(value = "end_bill_split_time", required = false, defaultValue = "") String endBillSplitTime,
			@RequestParam(value = "serviceId", required = false, defaultValue = "0") int serviceId,
			@RequestParam(value = "bill_status", required = false, defaultValue = "0") int billStatus,
			@RequestParam(value = "refund_status", required = false, defaultValue = "0") int refundStatus,
			@RequestParam(value = "withdraw_status", required = false, defaultValue = "0") int withdrawStatus,
			@RequestParam(value = "platform_bill_id", required = false, defaultValue = "") String platformBillId,
			@RequestParam(value = "service_bill_id", required = false, defaultValue = "") String serviceBillId,HttpServletResponse response)
	throws Exception{

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
			openOrderService.exportOrder(startDate, endDate,startBillSplitDate, endBillSplitDate,0, serviceId,
					billStatus, refundStatus, withdrawStatus, platformBillId, serviceBillId,response);
	}

}
