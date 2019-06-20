package com.rfchina.community.open.bridge.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
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
import org.mybatis.paginator.model.Order;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.Constant;
import com.rfchina.community.open.bridge.entity.ExtOpenSettlementApply;
import com.rfchina.community.open.bridge.mapper.ext.ExtOpenSettlementApplyMapper;
import com.rfchina.community.persistence.mapper.OpenSettlementApplyMapper;
import com.rfchina.community.persistence.model.OpenSettlementApply;
import com.rfchina.community.persistence.model.OpenSettlementApplyExample;
import com.rfchina.community.persistence.model.OpenSettlementApplyExample.Criteria;

@Service
public class OpenSettlementApplyService {

	@Autowired
	private OpenSettlementApplyMapper openSettlementApplyMapper;

	@Autowired
	private ExtOpenSettlementApplyMapper extOpenSettlementApplyMapper;

	private static transient Logger logger = LoggerFactory.getLogger(OpenSettlementApplyService.class);

	public void addSettlementApply(OpenSettlementApply openSettlementApply) {
		openSettlementApplyMapper.insertSelective(openSettlementApply);
	}

	public PageList<ExtOpenSettlementApply> getSettlementApplyList(Date startCreateTime, Date endCreateTime, int type,
			String settlementId, int merchantId, String merchantName, int status, int serviceId, String serviceName,
			int index, int size) {

		Map<String, Object> param = new HashMap<>();

		if (startCreateTime != null) {
			param.put("startCreateTime", startCreateTime);
		}

		if (endCreateTime != null) {
			param.put("endCreateTime", endCreateTime);
		}

		if (merchantId > 0) {
			param.put("merchantId", merchantId);
		}

		if (status > 0) {
			param.put("status", status);
		}

		if (serviceId > 0) {
			param.put("serviceId", serviceId);
		}

		if (type > 0) {
			param.put("type", type);
		}

		if (StringUtils.isNotBlank(settlementId)) {
			param.put("settlementId", settlementId);
		}

		if (StringUtils.isNotBlank(serviceName)) {
			param.put("serviceName", serviceName);
		}

		if (StringUtils.isNotBlank(merchantName)) {
			param.put("merchantName", merchantName);
		}

		PageBounds pageBounds = new PageBounds(index, size, Order.formString("create_time.desc"));

		return  extOpenSettlementApplyMapper.pageByCondition(param, pageBounds);
	}

	public OpenSettlementApply getOpenSettlementApply(int id) {
		return openSettlementApplyMapper.selectByPrimaryKey(id);
	}

	public int updateOpenSettlementApply(OpenSettlementApply openSettlementApply) {
		return openSettlementApplyMapper.updateByPrimaryKeySelective(openSettlementApply);
	}

	public String exportPlatformCharge(Date startCreateTime, Date endCreateTime, int serviceId) throws IOException {

		// 查询数据
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

		param.put("type", Constant.OpenAdmin.SettlementApplyType.PLATFORM_CHARGE);

		param.put("invoiceStatus", 1);

		List<ExtOpenSettlementApply> list = extOpenSettlementApplyMapper.getOpenSettlementApplyList(param);

		String serviceName = "";
		int id = 0;

		// 创建Excel工作簿
		Workbook workbook = new XSSFWorkbook();

		if (list != null && list.size() > 0) {
			serviceName = list.get(0).getServiceName();
			id = list.get(0).getServiceId();
		} else {
			workbook.close();
			return null;
		}

		Sheet sheet = workbook.createSheet("第三方平台手续费明细");

		// 创建表头数据
		Row headerRow = sheet.createRow(1);
		headerRow.createCell(0).setCellValue("服务ID");
		headerRow.createCell(1).setCellValue("服务名称");
		headerRow.createCell(2).setCellValue("服务类型");
		headerRow.createCell(3).setCellValue("服务商名称");
		headerRow.createCell(4).setCellValue("服务商类型");
		headerRow.createCell(5).setCellValue("统计单号");
		headerRow.createCell(6).setCellValue("统计时间段");
		headerRow.createCell(7).setCellValue("统计时间");
		headerRow.createCell(8).setCellValue("申请时间");
		headerRow.createCell(9).setCellValue("出票金额");
		headerRow.createCell(10).setCellValue("发票类型");
		headerRow.createCell(11).setCellValue("公司名称/个人姓名");
		headerRow.createCell(12).setCellValue("纳税人识别号");
		headerRow.createCell(13).setCellValue("公司地址");
		headerRow.createCell(14).setCellValue("公司电话");
		headerRow.createCell(15).setCellValue("开户银行");
		headerRow.createCell(16).setCellValue("银行账号");
		headerRow.createCell(17).setCellValue("联系人");
		headerRow.createCell(18).setCellValue("联系电话");
		headerRow.createCell(19).setCellValue("邮寄地址");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// 创建表数据
		int i = 2;
		for (ExtOpenSettlementApply extOpenSettlementApply : list) {
			Row row = sheet.createRow(i);
			// 第1列，结算单号
			row.createCell(0).setCellValue(extOpenSettlementApply.getServiceId());
			// 第2列，结算时间段
			row.createCell(1).setCellValue(extOpenSettlementApply.getServiceName());
			// 第3列，结算日期
			row.createCell(2).setCellValue(extOpenSettlementApply.getServiceCategory());
			// 第4列，订单总额
			row.createCell(3).setCellValue(extOpenSettlementApply.getMerchantName());
			// 第5列，平台手续费比例
			row.createCell(4)
					.setCellValue(Constant.merchantInfo.type.translate(extOpenSettlementApply.getMerchantType()));
			// 第6列，平台手续费
			row.createCell(5).setCellValue(extOpenSettlementApply.getSettlementId());
			row.createCell(6).setCellValue(sdf.format(extOpenSettlementApply.getSettlementStartTime()) + "至"
					+ sdf.format(extOpenSettlementApply.getSettlementEndTime()));
			row.createCell(7).setCellValue(sdf1.format(extOpenSettlementApply.getCreateTime()));
			row.createCell(8).setCellValue(sdf1.format(extOpenSettlementApply.getAuditTime()));
			row.createCell(9).setCellValue(extOpenSettlementApply.getPlatformPoundageAmount().toString());
			row.createCell(10)
					.setCellValue(Constant.OpenAdmin.InvoiceType.translate(extOpenSettlementApply.getInvoiceType()));
			row.createCell(11).setCellValue(extOpenSettlementApply.getCompanyName());
			row.createCell(12).setCellValue(extOpenSettlementApply.getTaxpayerCode());
			row.createCell(13).setCellValue(extOpenSettlementApply.getCompanyAddress());
			row.createCell(14).setCellValue(extOpenSettlementApply.getCompanyPhone());
			row.createCell(15).setCellValue(extOpenSettlementApply.getBankName());
			row.createCell(16).setCellValue(extOpenSettlementApply.getBankAccount());
			row.createCell(17).setCellValue(extOpenSettlementApply.getContactsName());
			row.createCell(18).setCellValue(extOpenSettlementApply.getContactsPhone());
			row.createCell(19).setCellValue(extOpenSettlementApply.getMailingAddress());

			i++;
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
		String storeFileName = "平台手续费_" + System.currentTimeMillis() + ".xlsx";
		workbook.write(new FileOutputStream(new File(storeFilePath + "/" + storeFileName)));
		workbook.close();
		logger.debug("生成excel文件到本地完成,文件保存路径为：" + storeFilePath + "/" + storeFileName);

		return storeFilePath + "/" + storeFileName;
	}

	public List<OpenSettlementApply> getSettlementApply(int serviceId, Date settlementStartTime, Date settlementEndTime,
			int type, int communityId) {

		OpenSettlementApplyExample example = new OpenSettlementApplyExample();

		Criteria criteria = example.createCriteria();
		criteria.andServiceIdEqualTo(serviceId).andSettlementStartTimeEqualTo(settlementStartTime)
				.andSettlementEndTimeEqualTo(settlementEndTime).andTypeEqualTo(type);

		if (communityId > 0) {
			criteria.andCommunityIdEqualTo(communityId);
		}

		return openSettlementApplyMapper.selectByExample(example);

	}
}
