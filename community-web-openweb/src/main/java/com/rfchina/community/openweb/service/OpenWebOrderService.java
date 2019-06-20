package com.rfchina.community.openweb.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.Constant;
import com.rfchina.community.openweb.entity.ExtOpenOrder;
import com.rfchina.community.openweb.entity.ExtOpenOrderCount;
import com.rfchina.community.openweb.mapper.ext.ExtOpenOrderMapper;
import com.rfchina.community.persistence.mapper.OpenOrderMapper;
import com.rfchina.community.persistence.model.OpenOrder;
import com.rfchina.community.persistence.model.OpenOrderExample;

@Service
public class OpenWebOrderService {

	@Autowired
	private OpenOrderMapper openOrderMapper;

	@Autowired
	private ExtOpenOrderMapper extOpenOrderMapper;
	
	private static transient Logger logger = LoggerFactory.getLogger(OpenWebOrderService.class);

	public void insertOpenOrder(OpenOrder openOrder) {
		openOrderMapper.insertSelective(openOrder);
	}

	public void updateOpenOrderByPrimaryKey(OpenOrder openOrder) {
		openOrderMapper.updateByPrimaryKeySelective(openOrder);
	}
	public OpenOrder getOpenOrder(Long id){
		return  openOrderMapper.selectByPrimaryKey(id);
		
	}
	public OpenOrder getOpenOrder(String billId){
		OpenOrderExample example = new OpenOrderExample();
		example.createCriteria().andBillIdEqualTo(billId);
		List<OpenOrder> list = openOrderMapper.selectByExample(example);
		
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		
		return null;
	}

	public PageList<ExtOpenOrder> getOpenOrderList(Date startCreateTime, Date endCreateTime, Date startBillFinishedDate, Date endBillFinishedDate, int merchantId,
			int serviceId, int billStatus, int refundStatus, int withdrawStatus, String platformBillId,
			String serviceBillId,Date startBillSplitDate, Date endBillSplitDate, int index, int size) {

		Map<String, Object> param = new HashMap<>();

		if (startCreateTime != null) {
			param.put("startCreateTime", startCreateTime);
		}

		if (endCreateTime != null) {
			param.put("endCreateTime", endCreateTime);
		}
		
		if (startBillFinishedDate != null) {
			param.put("startBillFinishedDate", startBillFinishedDate);
		}

		if (endBillFinishedDate != null) {
			param.put("endBillFinishedDate", endBillFinishedDate);
		}
		
		
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
			param.put("platformBillId", "%"+platformBillId+"%");
		}

		if (StringUtils.isNotBlank(serviceBillId)) {
			param.put("serviceBillId", serviceBillId);
		}

		PageBounds pageBounds = new PageBounds(index, size);

		return extOpenOrderMapper.pageByCondition(param, pageBounds);
	}

	public ExtOpenOrderCount getOpenOrderCount(Date startCreateTime, Date endCreateTime, int serviceId) {

		Map<String, Object> param = new HashMap<>();

		if (startCreateTime != null) {
			param.put("startCreateTime", startCreateTime);
		}

		if (endCreateTime != null) {
			param.put("endCreateTime", endCreateTime);
		}

		if (serviceId > 0) {
			param.put("serviceId", serviceId);
		}

		return extOpenOrderMapper.getOpenOrderCount(param);
	}

	public List<ExtOpenOrderCount> getPlatformChargeCount(Date startCreateTime, Date endCreateTime) {

		Map<String, Object> param = new HashMap<>();

		if (startCreateTime != null) {
			param.put("startCreateTime", startCreateTime);
		}

		if (endCreateTime != null) {
			param.put("endCreateTime", endCreateTime);
		}

		return extOpenOrderMapper.getPlatformChargeCount(param);
	}

	public List<ExtOpenOrderCount> getServiceChargeCount(Date startCreateTime, Date endCreateTime) {

		Map<String, Object> param = new HashMap<>();

		if (startCreateTime != null) {
			param.put("startCreateTime", startCreateTime);
		}

		if (endCreateTime != null) {
			param.put("endCreateTime", endCreateTime);
		}

		return extOpenOrderMapper.getServiceChargeCount(param);
	}
	
	
	public long getOpenOrderCount(long appId , int withdrawStatus, int billStatus){
		OpenOrderExample example = new OpenOrderExample();
		example.createCriteria().andAppIdEqualTo(appId).andWithdrawStatusNotEqualTo(withdrawStatus)
			.andBillStatusEqualTo(billStatus);
		
		return openOrderMapper.countByExample(example);
	}
	
	
	public String exportOrder(Date startCreateTime, Date endCreateTime, Date startBillSplitDate, Date endBillSplitDate,int merchantId,
			int serviceId, int billStatus, int refundStatus, int withdrawStatus, String platformBillId,
			String serviceBillId) throws FileNotFoundException, IOException {
		
		Map<String, Object> param = new HashMap<>();

		if (startCreateTime != null) {
			param.put("startCreateTime", startCreateTime);
		}

		if (endCreateTime != null) {
			param.put("endCreateTime", endCreateTime);
		}

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
		
		// 创建Excel工作簿
		Workbook workbook = new XSSFWorkbook();
		
		Sheet sheet = workbook.createSheet("资金流水");

		// 创建表头数据
		Row headerRow = sheet.createRow(0);
		int i=0;
		headerRow.createCell(i++).setCellValue("支付订单号");
		headerRow.createCell(i++).setCellValue("平台订单号");
		headerRow.createCell(i++).setCellValue("服务订单号");
		headerRow.createCell(i++).setCellValue("创建时间");
		headerRow.createCell(i++).setCellValue("来源服务");
		headerRow.createCell(i++).setCellValue("订单金额");
		headerRow.createCell(i++).setCellValue("平台服务费");
		headerRow.createCell(i++).setCellValue("退款金额");
		headerRow.createCell(i++).setCellValue("实收金额");
		headerRow.createCell(i++).setCellValue("支付状态");
		headerRow.createCell(i++).setCellValue("退款状态");
		headerRow.createCell(i++).setCellValue("状态");
		
		
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

			row.createCell(g++).setCellValue(str(extOpenOrder.getRefundMoney()));
			row.createCell(g++).setCellValue(str(extOpenOrder.getReceiptAmount()));
			row.createCell(g++).setCellValue(Constant.OpenOrder.BillStatus.translate(extOpenOrder.getBillStatus()));
			row.createCell(g++).setCellValue(Constant.OpenOrder.RefundStatus.translate(extOpenOrder.getRefundStatus()));
			row.createCell(g++)
					.setCellValue(Constant.OpenOrder.WithdrawStatus.translate(extOpenOrder.getWithdrawStatus()));

			j++;
		}

		String storeFilePath = System.getProperty("java.class.path");
		int firstIndex = storeFilePath.lastIndexOf(System.getProperty("path.separator")) + 1;
		int lastIndex = storeFilePath.lastIndexOf(File.separator) + 1;
		storeFilePath = storeFilePath.substring(firstIndex, lastIndex) + "/file/export";
		File dir = new File(storeFilePath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// 保存文件到服务器
		String storeFileName =  "资金流水_" + System.currentTimeMillis() + ".xlsx";
		workbook.write(new FileOutputStream(new File(storeFilePath + "/" + storeFileName)));
		workbook.close();
		logger.debug("生成excel文件到本地完成,文件保存路径为：" + storeFilePath + "/" + storeFileName);

		return storeFilePath + "/"+storeFileName;
	}
	private String str(Object obj) {if(obj==null)return 
			
			"";return obj.toString();
		
	}
}
