package com.rfchina.community.open.bridge.service;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.api.response.model.pay.PayRefundAuditLogModel;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.open.bridge.entity.ExtOpenOrder;
import com.rfchina.community.open.bridge.entity.ExtOpenOrderTotal;
import com.rfchina.community.open.bridge.entity.SimOpenOrder;
import com.rfchina.community.open.bridge.mapper.ext.ExtOpenOrderMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.mapper.OpenOrderMapper;
import com.rfchina.community.persistence.mapper.OpenStoreOrderMapper;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.persistence.model.OpenOrderExample.Criteria;
import com.rfchina.community.persistence.model.ext.EmpGuidOrderStat;
import com.rfchina.community.persistence.model.ext.OperatorOrder;
import com.rfchina.community.persistence.model.ext.TaskOrder;
import com.rfchina.community.persistence.model.ext.TaskOrderStat;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.paginator.model.Order;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OpenOrderService extends BaseService{

	@Autowired
	private OpenOrderMapper openOrderMapper;

	@Autowired
	private ExtOpenOrderMapper extOpenOrderMapper;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;
	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;
	@Autowired
	private OpenStoreOrderMapper openStoreOrderMapper;

	public PageList<ExtOpenOrderTotal> getTotalOrderList(Date startCreateTime, Date endCreateTime, int communityId,
			int billStatus, String billId, String communityTradeNo,String refundStatus, int index, int size) {
		Map<String, Object> param = getParamMap(startCreateTime, endCreateTime);
		if (communityId > 0) {
			param.put("communityId", communityId);
		}
		if (billStatus > 0) {
			param.put("billStatus", billStatus);
		}
		if (StringUtils.isNotBlank(billId)) {
			param.put("billId", billId);
		}
		if (StringUtils.isNotBlank(communityTradeNo)) {
			param.put("communityTradeNo", communityTradeNo);
		}
		if (StringUtils.isNotBlank(refundStatus)) {
			param.put("refundStatus", refundStatus);
		}
		PageBounds pageBounds = new PageBounds(index, size, Order.formString("create_time.desc"));
		PageList<ExtOpenOrderTotal> list = extOpenOrderMapper.pageByCondition(param, pageBounds);
		for (ExtOpenOrderTotal extOpenOrderTotal : list) {
			List<SimOpenOrder> orderList = this.getOrderList(extOpenOrderTotal.getCommunityTradeNo());
			extOpenOrderTotal.setOrderList(orderList);
			if (orderList != null && !orderList.isEmpty()) {
				extOpenOrderTotal.setFirstStoreName(orderList.get(0).getStoreName());
				/*UserInfo user = userInfoMapper.selectByPrimaryKey(extOpenOrderTotal.getUid());
				extOpenOrderTotal.setPhone(user == null ? "" : user.getPhone());*/
			}
		}
		return list;
	}


	public PageList<ExtOpenOrder> getOpenOrderList(Date startCreateTime, Date endCreateTime, int serviceId,
			int merchantId, String serviceName, String merchantName, int communityId, String communityName,
			int billStatus, int index, String outTradeNo, int size) {
		Map<String, Object> param = getParamMap(startCreateTime, endCreateTime);
		if (serviceId > 0) {
			param.put("serviceId", serviceId);
		}

		if (merchantId > 0) {
			param.put("merchantId", merchantId);
		}

		if (communityId > 0) {
			param.put("communityId", communityId);
		}

		if (billStatus > 0) {
			param.put("billStatus", billStatus);
		}

		if (StringUtils.isNotBlank(serviceName)) {
			param.put("serviceName", "%" + serviceName + "%");
		}

		if (StringUtils.isNotBlank(merchantName)) {
			param.put("merchantName", "%" + merchantName + "%");
		}

		if (StringUtils.isNotBlank(communityName)) {
			param.put("communityName", "%" + communityName + "%");
		}

		if (StringUtils.isNotBlank(outTradeNo)) {
			param.put("outTradeNo", outTradeNo);
		}

		PageBounds pageBounds = new PageBounds(index, size, Order.formString("create_time.desc"));

		return extOpenOrderMapper.pageByAdminCondition(param, pageBounds);
	}

	public OpenOrder getOpenOrder(Integer serviceId, String outTradeNo, String communityTradeNo) {
		OpenOrderExample example = new OpenOrderExample();
		Criteria criteria = example.createCriteria();
		if (serviceId > 0 && StringUtils.isNotBlank(outTradeNo)) {
			criteria.andServiceIdEqualTo(serviceId).andOutTradeNoEqualTo(outTradeNo);
		} else if (StringUtils.isNotBlank(communityTradeNo)) {
			criteria.andCommunityTradeNoEqualTo(communityTradeNo);
		} else {
			return new OpenOrder();
		}

		List<OpenOrder> list = openOrderMapper.selectByExample(example);
		if (list.isEmpty())
			return new OpenOrder();
		return list.get(0);
	}

	/**
	 *
	 * @param taskId
	 * @param empGuid
	 * @return
	 */
	public BigDecimal sumAmount(Long taskId, Long taskRelId, String empGuid, Boolean isContainRefund){
		Map<String, Object> param = new HashMap<>();
		if(taskId != null){
			param.put("taskId", taskId);
		}
		if(taskRelId != null){
			param.put("taskRelId", taskRelId);
		}
		if(empGuid != null){
			param.put("empGuid", empGuid);
		}
		if(isContainRefund != null){
			param.put("isContainRefund", isContainRefund);
		}
		return extOpenOrderMapper.sumAmount(param);
	}

	/**
	 *
	 * @param taskId
	 * @param empGuid
	 * @return
	 */
	public TaskOrderStat taskOrderStat(Long taskId, Long taskRelId, String empGuid){
		Map<String, Object> param = new HashMap<>();
		if(taskId != null){
			param.put("taskId", taskId);
		}
		if(taskRelId != null){
			param.put("taskRelId", taskRelId);
		}
		if(empGuid != null){
			param.put("empGuid", empGuid);
		}

		return extOpenOrderMapper.taskOrderStat(param);
	}

	/**
	 *
	 * @param taskId
	 * @param empGuid
	 * @return
	 */
	public PageList<TaskOrder> taskOrderList(Long taskId, Long taskRelId, String empGuid, int index, int size){
		Map<String, Object> param = new HashMap<>();
		if(taskId != null){
			param.put("taskId", taskId);
		}
		if(taskRelId != null){
			param.put("taskRelId", taskRelId);
		}
		if(empGuid != null){
			param.put("empGuid", empGuid);
		}
		PageBounds pageBounds = new PageBounds(index, size, Order.formString("bill_finished_time.desc"));

		return extOpenOrderMapper.taskOrderList(param, pageBounds);
	}

	public List<EmpGuidOrderStat> getOperatorStat(String empGuids){
		String[] emps = empGuids.split(",");
		List<String> empGuidList = Arrays.asList(emps);
		List<EmpGuidOrderStat> list = extOpenOrderMapper.getOperatorStat(empGuidList);
		return list;
	}

	/**
	 * 运营者记录
	 * @param empGuidName
	 * @param empGuidPhone
	 * @param outTradeNo
	 * @param beginDate
	 * @param endDate
	 * @param taskId
	 * @param refundStatus
	 * @param serviceName
	 * @param index
	 * @param size
	 * @return
	 */
	public PageList<OperatorOrder> listOperatorOrder(String empGuidName, String empGuidPhone, String outTradeNo,
		Date beginDate, Date endDate, long taskId, Integer refundStatus, String serviceName, int index, int size){
		Map<String, Object> param = new HashMap<>();
		if (StringUtils.isNotBlank(empGuidName)) {
			param.put("empGuidName","%" + empGuidName + "%");
		}
		if (StringUtils.isNotBlank(empGuidPhone)) {
			param.put("empGuidPhone","%" + empGuidPhone + "%");
		}
		if (StringUtils.isNotBlank(outTradeNo)) {
			param.put("outTradeNo","%" + outTradeNo + "%");
		}
		if(beginDate != null){
			param.put("beginDate", beginDate);
		}
		if(endDate != null){
			param.put("endDate", endDate);
		}
		if (taskId > 0) {
			param.put("taskId", taskId);
		}
		if(refundStatus != null){
			param.put("refundStatus", refundStatus);
		}
		if (StringUtils.isNotBlank(serviceName)) {
			param.put("serviceName","%" + serviceName + "%");
		}
		PageBounds pageBounds = new PageBounds(index, size);

		PageList<OperatorOrder> list = extOpenOrderMapper.listOperatorOrder(param, pageBounds);
		return list;
	}

	/**
	 * 导出运营者记录
	 * @param empGuidName
	 * @param empGuidPhone
	 * @param outTradeNo
	 * @param beginDate
	 * @param endDate
	 * @param taskId
	 * @param refundStatus
	 * @param serviceName
	 * @return
	 */
	public void exportOperatorOrder(String empGuidName, String empGuidPhone, String outTradeNo,
		Date beginDate, Date endDate, long taskId, Integer refundStatus, String serviceName,HttpServletResponse response)
	throws Exception{

		long now = System.currentTimeMillis();
		PageList<OperatorOrder> list = this.listOperatorOrder(empGuidName, empGuidPhone, outTradeNo, beginDate,
				endDate, taskId, refundStatus, serviceName, 1, Integer.MAX_VALUE);

		String fileName = "运营者销售记录" + DateTimeUtils.format(new Date(), "yyyyMMdd") + ".xlsx";
		response.setContentType("application/octet-stream;charset=utf-8");
		response.addHeader("Content-Disposition",
				"attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));

		ServletOutputStream stream = response.getOutputStream();
		Workbook workbook = new XSSFWorkbook();
		// 创建Excel工作簿
		try {
			Sheet sheet = workbook.createSheet("销售记录");
			// 创建表头数据
			Row headerRow = sheet.createRow(0);
			int i=0;
			headerRow.createCell(i++).setCellValue("运营者姓名");
			headerRow.createCell(i++).setCellValue("运营者手机");
			headerRow.createCell(i++).setCellValue("服务订单号");
			headerRow.createCell(i++).setCellValue("订单总额");
			headerRow.createCell(i++).setCellValue("退款状态");
			headerRow.createCell(i++).setCellValue("支付时间");
			headerRow.createCell(i++).setCellValue("任务ID");
			headerRow.createCell(i++).setCellValue("店铺名称");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 创建表数据
			int j = 1;
			for (OperatorOrder ext : list) {
				Row row = sheet.createRow(j);
				int g = 0;
				// 第1列 运营者姓名
				row.createCell(g++).setCellValue(ext.getEmpName());
				// 第2列 运营者手机
				row.createCell(g++).setCellValue(ext.getEmpPhone());
				// 第3列 服务订单号
				row.createCell(g++).setCellValue(ext.getOutTradeNo());
				// 第4列 订单总额
				row.createCell(g++).setCellValue(ext.getTotalAmount() == null ? "" : ext.getTotalAmount().toString());
				// 第5列 退款状态
				row.createCell(g++).setCellValue(OpenConstant.open_order.RefundStatus.translate(ext.getRefundStatus()));
				// 第6列 支付时间
				row.createCell(g++).setCellValue(ext.getBillFinishedTime()==null ? "":sdf.format(ext.getBillFinishedTime()));
				// 第7列 任务ID
				row.createCell(g++).setCellValue(ext.getTaskId());
				// 第8列 店铺名称
				row.createCell(g++).setCellValue(ext.getServiceName());
				j++;
			}
			logger.info("exportOperatorOrder time={}", System.currentTimeMillis() - now);
			workbook.write(stream);
		}finally {
			IOUtils.closeQuietly(workbook);
		}

	}


	public void exportOrder(Date startCreateTime, Date endCreateTime, Date startBillSplitDate, Date endBillSplitDate,int merchantId,
							  int serviceId, int billStatus, int refundStatus, int withdrawStatus, String platformBillId,
							  String serviceBillId,HttpServletResponse response) throws FileNotFoundException, IOException {

		Map<String, Object> param = getParamMap(startCreateTime, endCreateTime);

		if (startBillSplitDate != null) {
			param.put("startBillSplitDate", startBillSplitDate);
		}
		if (endBillSplitDate != null) {
			param.put("endBillSplitDate", endBillSplitDate);
		}
		if (merchantId > 0) {
			param.put("merchantId", merchantId);
		}
		if (serviceId > 0) {
			param.put("serviceId", serviceId);
		}
		if (billStatus > 0) {
			param.put("billStatus", billStatus);
		}
		if (refundStatus > 0) {
			param.put("refundStatus", refundStatus);
		}
		if (withdrawStatus > 0) {
			param.put("withdrawStatus", withdrawStatus);
		}
		if (StringUtils.isNotBlank(platformBillId)) {
			param.put("platformBillId", platformBillId);
		}

		if (StringUtils.isNotBlank(serviceBillId)) {
			param.put("serviceBillId", serviceBillId);
		}

		List<ExtOpenOrder> list = extOpenOrderMapper.getOpenOrderList(param);

		CommunityService service = communityServiceMapper.selectByPrimaryKey(serviceId);
		String serviceName = service == null ? "" : service.getTitle();
		String fileName = "提现明细_" + serviceName + "_" + DateTimeUtils.format(new Date(), "yyyyMMdd") + ".xlsx";
		response.setContentType("application/octet-stream;charset=utf-8");
		response.addHeader("Content-Disposition",
				"attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
		ServletOutputStream stream = response.getOutputStream();
		// 创建Excel工作簿
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("资金流水");
		// 创建表头数据
		Row headerRow = sheet.createRow(0);
		int i = 0;
		headerRow.createCell(i++).setCellValue("支付订单号");
		headerRow.createCell(i++).setCellValue("平台订单号");
		headerRow.createCell(i++).setCellValue("服务订单号");
		headerRow.createCell(i++).setCellValue("创建时间");
		headerRow.createCell(i++).setCellValue("来源服务");
		headerRow.createCell(i++).setCellValue("订单金额");
		headerRow.createCell(i++).setCellValue("平台服务费");
		headerRow.createCell(i++).setCellValue("支付手续费");
		headerRow.createCell(i++).setCellValue("平台手续费");
		headerRow.createCell(i++).setCellValue("社区服务费");
		headerRow.createCell(i++).setCellValue("退款金额");
		headerRow.createCell(i++).setCellValue("实收金额");
		headerRow.createCell(i++).setCellValue("支付状态");
		headerRow.createCell(i++).setCellValue("退款状态");
		headerRow.createCell(i++).setCellValue("入账日期");
		headerRow.createCell(i++).setCellValue("城市");
		headerRow.createCell(i++).setCellValue("社区");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

		// 创建表数据
		int j = 1;
		for (ExtOpenOrder extOpenOrder : list) {
			Row row = sheet.createRow(j);
			int g = 0;
			// 第0列
			row.createCell(g++).setCellValue(extOpenOrder.getBillId());
			// 第1列
			row.createCell(g++).setCellValue(extOpenOrder.getCommunityTradeNo());
			// 第2列
			row.createCell(g++).setCellValue(extOpenOrder.getOutTradeNo());
			// 第3列
			row.createCell(g++).setCellValue(sdf.format(extOpenOrder.getBillCreateTime()));
			// 第4列
			row.createCell(g++).setCellValue(extOpenOrder.getServiceName());
			// 第5列
			row.createCell(g++).setCellValue(str(extOpenOrder.getTotalAmount()));
			// 第6列
			if (extOpenOrder.getRefundStatus() != null && extOpenOrder.getRefundStatus() == 2) {
				row.createCell(g++).setCellValue(str(extOpenOrder.getPlatformCharge()));
			} else {
				row.createCell(g++)
						.setCellValue(str(extOpenOrder.getPlatformCharge().add(extOpenOrder.getServiceCharge()).add(extOpenOrder.getThinkCharge())));
			}
			row.createCell(g++).setCellValue(str(extOpenOrder.getPlatformCharge()));
			row.createCell(g++).setCellValue(str(extOpenOrder.getThinkCharge()));
			row.createCell(g++).setCellValue(str(extOpenOrder.getServiceCharge()));
			row.createCell(g++).setCellValue(str(extOpenOrder.getRefundMoney()));
			row.createCell(g++).setCellValue(str(extOpenOrder.getReceiptAmount()));
			row.createCell(g++).setCellValue(Constant.OpenOrder.BillStatus.translate(extOpenOrder.getBillStatus()));
			row.createCell(g++).setCellValue(Constant.OpenOrder.RefundStatus.translate(extOpenOrder.getRefundStatus()));
			row.createCell(g++)
					.setCellValue(extOpenOrder.getBillSplitTime() == null ? "" : sdf.format(extOpenOrder.getBillSplitTime()));
			row.createCell(g++).setCellValue(str(extOpenOrder.getCityName()));
			row.createCell(g++).setCellValue(str(extOpenOrder.getCommunityName()));
			j++;
		}
		workbook.write(stream);
		workbook.close();

	}

	/**
	 * @Author wlrllr
	 * @Description //FIXME 查询退款订单审核流程
	 * @Date 2019/1/4
	 * @Param [refundId]
	 * @return void
	 **/
	public List getRefundAuditList(String refundId){
       if(StringUtils.isNotBlank(refundId)){
		   List<PayRefundAuditLogModel> list = platformGlobalComponent.getRefundAuditList(refundId);
       	  //按时间降序排序
		   if(list != null && list.size()>0){
			   //查询结果是按时间升序排列，所以只需要倒序即可
			   //list.sort(Collections.reverseOrder());
			   Collections.reverse(list);
		   }
		   return list;
	   }
       return null;
	}

	private String str(Object obj) {
		if(obj==null)
			return "";
		return obj.toString();
	}

	private Map<String, Object> getParamMap(Date startCreateTime, Date endCreateTime) {
		Map<String, Object> param = new HashMap<>();
		if (startCreateTime != null) {
			param.put("startCreateTime", startCreateTime);
		}
		if (endCreateTime != null) {
			param.put("endCreateTime", endCreateTime);
		}
		return param;
	}

	/**
	 * @author:fukangwen @Description: 根据合并支付单获取订单信息 @return List<OpenOrder> @throws
	 */
	private List<SimOpenOrder> getOrderList(String communityTradeNo) {
		OpenOrderExample example = new OpenOrderExample();
		example.createCriteria().andCommunityTradeNoEqualTo(communityTradeNo);
		example.setOrderByClause("id desc");
		List<OpenOrder> list = openOrderMapper.selectByExample(example);

		List<SimOpenOrder> simList = new ArrayList<>();
		for (OpenOrder order : list) {
			SimOpenOrder simOrder = new SimOpenOrder();
			BeanUtils.copyProperties(order, simOrder);
			CommunityService communityService = communityServiceMapper.selectByPrimaryKey(order.getServiceId());
			if (communityService != null) {
				simOrder.setStoreName(communityService.getTitle());
				OpenMerchantInfo merchant = openMerchantInfoMapper.selectByPrimaryKey(communityService.getMerchantId());
				simOrder.setMerchantName(merchant == null ? "" : merchant.getTitle());
			}
			simList.add(simOrder);
		}
		return simList;
	}


	public void updateRefundStatus(String billId,String refundBillId, Integer refundStatus) {
		logger.info("更新退款状态,billId:{},refundBillId:{},refundStatus:{}",billId,refundBillId,refundStatus);
		if((StringUtils.isNotBlank(billId) || StringUtils.isNotBlank(refundBillId)) && refundStatus != null){
			OpenOrderExample example = new OpenOrderExample();
			OpenOrderExample.Criteria criteria = example.createCriteria();
			if(StringUtils.isNotBlank(billId)) criteria.andBillIdEqualTo(billId);
			if(StringUtils.isNotBlank(refundBillId)) criteria.andRefundBillIdEqualTo(refundBillId);
			List<OpenOrder> openOrders  = openOrderMapper.selectByExample(example);
			if(openOrders != null && openOrders.size()>0){
				for(OpenOrder order : openOrders){
					int updateFlag = updateOrderRefundStatus(order.getId(), refundStatus);
					int updateStoreFlag = updateStoreOrderRefundStatus(refundStatus,order.getOutTradeNo());
					logger.info("更新退款状态：openOrderFlag:{},openStoreFlag:{}",updateFlag,updateStoreFlag);
				}
			}
		}
	}

	public void updateRefundStatusById(Long orderId, Integer refundStatus) {
		logger.info("更新退款状态,orderId:{},refundStatus:{}",orderId,refundStatus);
		if(orderId != null && refundStatus != null){
			updateOrderRefundStatus(orderId, refundStatus);
		}
	}

	public void updateRefundStatus(OpenOrder openOrder) {
		logger.info("更新退款状态,openOrder:{}", JSONObject.toJSONString(openOrder));
		if(openOrder != null){
			openOrderMapper.updateByPrimaryKeySelective(openOrder);
		}
	}


	private int updateOrderRefundStatus(Long orderId, Integer refundStatus) {
		OpenOrder openOrder = new OpenOrder();
		openOrder.setId(orderId);
		openOrder.setUpdateTime(new Date());
		openOrder.setRefundStatus(refundStatus);
		return openOrderMapper.updateByPrimaryKeySelective(openOrder);
	}

	private int updateStoreOrderRefundStatus(Integer refundStatus,String outTradeNo) {
		if(StringUtils.isNotBlank(outTradeNo)){
			OpenStoreOrder openStoreOrder = new OpenStoreOrder();
			openStoreOrder.setRefundStatus(refundStatus);
			OpenStoreOrderExample openStoreOrderExample = new OpenStoreOrderExample();
			openStoreOrderExample.createCriteria().andOutTradeNoEqualTo(outTradeNo);
			return openStoreOrderMapper.updateByExampleSelective(openStoreOrder,openStoreOrderExample);
		}
		return 0;
	}
}
