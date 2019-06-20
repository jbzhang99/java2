package com.rfchina.community.open.bridge.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.rfchina.community.persistence.model.*;
import com.rfchina.community.service.UserInfoSerService;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.paginator.model.Page;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.open.bridge.entity.ExtOpenStoreOrder;
import com.rfchina.community.open.bridge.entity.TransferChargeDetail;
import com.rfchina.community.open.bridge.mapper.ext.ExtOpenStoreOrderMapper;
import com.rfchina.community.persistence.mapper.CommunityMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.mapper.OpenStoreGoodOrderRelMapper;
import com.rfchina.community.persistence.mapper.OpenStoreOrderMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJInfoMapper;

/**
 * @author:fukangwen
 * @Description: 商城订单管理service
 */
@Service
public class OpenStoreOrderService extends BaseService {

	@Autowired
	private OpenStoreOrderMapper openStoreOrderMapper;
	@Autowired
	private OpenOrderService openOrderService;
	@Autowired
	private ExtOpenStoreOrderMapper extOpenStoreOrderMapper;
	@Autowired
	private OpenStoreGoodOrderRelMapper openStoreGoodOrderRelMapper;
	@Autowired
	private OpenXFSJInfoMapper openXFSJInfoMapper;
	@Autowired
	private CommunityMapper communityMapper;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;
	@Autowired
	private UserInfoSerService userInfoSerService;


	private final Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * @author:fukangwen @Description: 订单管理查询 @return Object @throws
	 */
	public Page<ExtOpenStoreOrder> pageQuery(Map<String, Object> param, PageBounds pageBounds) {
		PageList<ExtOpenStoreOrder> list = extOpenStoreOrderMapper.pageByCondition(param, pageBounds);
		if (!list.isEmpty()) {
			for (ExtOpenStoreOrder ext : list) {
				this.completeInfo(ext);
			}
		}
		return list.convert();
	}
	
	private void completeInfo(ExtOpenStoreOrder ext) {
		ext.setGoodList(this.getRelList(ext.getId()));
		//退款成功显示退款订单号
		OpenOrder order = openOrderService.getOpenOrder(ext.getServiceId(), ext.getOutTradeNo(), null);
		ext.setRefundId(order.getRefundId());
		ext.setBillFinishTime(order.getBillFinishedTime());
		ext.setPlatformCharge(order.getPlatformCharge());
		ext.setServiceCharge(order.getServiceCharge());
		ext.setRefundMoney(order.getRefundMoney() == null || order.getRefundMoney().compareTo(new BigDecimal(0)) <= 0
				? order.getTotalAmount() : order.getRefundMoney());
		ext.setType(OpenConstant.OpenStoreOrderType.getTypeLabel(ext.getType()));
		ext.setReceiptAmount(order.getReceiptAmount());
		ext.setCommunityTradeNo(order.getCommunityTradeNo());
		ext.setBillId(order.getBillId());
		UserInfo userInfo = userInfoSerService.getUserInfo(ext.getUserId());
		ext.setUserPhone(userInfo == null ? "" : userInfo.getPhone());
		if(ext.getXfsjId() > 0) {
			OpenXFSJInfo info = openXFSJInfoMapper.selectByPrimaryKey(ext.getXfsjId());
			ext.setActivityTitle(info.getActTitile() == null ? "" : info.getActTitile());
		}
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 获取订单中商品的详情
	 * @return List<OpenStoreGoodOrderRel>
	 * @throws
	 */
	public List<OpenStoreGoodOrderRel> getRelList(int orderId) {
		OpenStoreGoodOrderRelExample example = new OpenStoreGoodOrderRelExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		return openStoreGoodOrderRelMapper.selectByExample(example);
	}

	public BigDecimal getSuccessTotalMoney(Map<String, Object> param) {
		return extOpenStoreOrderMapper.getSuccessTotalMoney(param);
	}

	/**
	 * @author:fukangwen
	 * @Description: 获取手续费详情
	 * @return Object
	 * @throws
	 */
	public OpenOrder getTransferChargeDetail(int openStoreOrderId) {
		OpenStoreOrder openStoreOrder = openStoreOrderMapper.selectByPrimaryKey(openStoreOrderId);
		validator(openStoreOrder == null, "订单不存在");
		return openOrderService.getOpenOrder(openStoreOrder.getServiceId(), openStoreOrder.getOutTradeNo(), null);
		/*TransferChargeDetail detail = new TransferChargeDetail();
		BeanUtils.copyProperties(openOrder, detail);
		return detail;*/
	}

	
	/**
	 * @author:fukangwen @Description: 获取订单详情 @return ExtOpenStoreOrder @throws
	 */
	public ExtOpenStoreOrder getOpenStoreOrderDetail(int openStoreOrderId) {
		//
		OpenStoreOrder openStoreOrder = openStoreOrderMapper.selectByPrimaryKey(openStoreOrderId);
		validator(openStoreOrder == null, "订单不存在");

		ExtOpenStoreOrder extOpenStoreOrder = new ExtOpenStoreOrder();
		BeanUtils.copyProperties(openStoreOrder, extOpenStoreOrder);
		this.completeInfo(extOpenStoreOrder);
		CommunityService service = communityServiceMapper.selectByPrimaryKey(openStoreOrder.getServiceId());
		extOpenStoreOrder.setServiceTitle(service.getTitle());
		
		OpenMerchantInfo merchant = openMerchantInfoMapper.selectByPrimaryKey(service.getMerchantId());
		extOpenStoreOrder.setMerchantTitle(merchant.getTitle());
		
		Community community = communityMapper.selectByPrimaryKey(openStoreOrder.getCommunityId().intValue());
		extOpenStoreOrder.setCommunityTitle(community.getName());
		
		return extOpenStoreOrder;
	}
	
	
	public void createOpenOrderWorkBook(Map<String, Object> param, HttpServletResponse response) throws IOException {
		long now = System.currentTimeMillis();
		PageList<ExtOpenStoreOrder> list = extOpenStoreOrderMapper.pageByExportCondition(param, new PageBounds());
		logger.info("createOpenOrderWorkBook pageQuery time={}", System.currentTimeMillis() - now);
		String fileName = "第三方订单" + DateTimeUtils.format(new Date(), "_yyyyMMdd_HHmmss") + ".xlsx";
		response.setContentType("application/octet-stream;charset=utf-8");
		response.addHeader("Content-Disposition",
				"attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
		
		ServletOutputStream stream = response.getOutputStream();
		Workbook workbook = new XSSFWorkbook();
		// 创建Excel工作簿
		try {
			Sheet sheet = workbook.createSheet("订单列表");
			// 创建表头数据
			Row headerRow = sheet.createRow(0);
			int i=0;
			headerRow.createCell(i++).setCellValue("服务订单号");
			headerRow.createCell(i++).setCellValue("支付订单号");
			headerRow.createCell(i++).setCellValue("平台订单号");
			headerRow.createCell(i++).setCellValue("订单类型");
			headerRow.createCell(i++).setCellValue("用户手机");
			headerRow.createCell(i++).setCellValue("订单总价");
			headerRow.createCell(i++).setCellValue("满减金额");
			headerRow.createCell(i++).setCellValue("优惠券金额");
			headerRow.createCell(i++).setCellValue("用户实付金额");
			headerRow.createCell(i++).setCellValue("支付手续费");
			headerRow.createCell(i++).setCellValue("平台手续费");
			headerRow.createCell(i++).setCellValue("社区服务费");
			headerRow.createCell(i++).setCellValue("订单备注");
			headerRow.createCell(i++).setCellValue("收货人手机");
			headerRow.createCell(i++).setCellValue("收货姓名");
			headerRow.createCell(i++).setCellValue("收货地址");
			headerRow.createCell(i++).setCellValue("发货状态");
			headerRow.createCell(i++).setCellValue("支付状态");
			headerRow.createCell(i++).setCellValue("退款状态");
			headerRow.createCell(i++).setCellValue("退款金额");
			headerRow.createCell(i++).setCellValue("商家实收");
			headerRow.createCell(i++).setCellValue("店铺名称");
			headerRow.createCell(i++).setCellValue("所属社区");
			headerRow.createCell(i++).setCellValue("所属业务");
			headerRow.createCell(i++).setCellValue("所属活动");
			headerRow.createCell(i++).setCellValue("下单时间");
			headerRow.createCell(i++).setCellValue("支付时间");
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 创建表数据
			int j = 1;
			for (ExtOpenStoreOrder extOpenStoreOrder : list) {
				Row row = sheet.createRow(j);
				int g = 0;
				// 第1列 服务订单号
				row.createCell(g++).setCellValue(extOpenStoreOrder.getOutTradeNo());
				// 第2列 支付订单号
				row.createCell(g++).setCellValue(extOpenStoreOrder.getBillId());
				// 第3列 平台订单号
				row.createCell(g++).setCellValue(extOpenStoreOrder.getCommunityTradeNo());
				// 第4.0列 订单类型
				row.createCell(g++).setCellValue((extOpenStoreOrder.getGroupStatus() == null || extOpenStoreOrder.getGroupStatus() == 0) ? "普通订单" : "拼团订单");
				// 第4.1列 用户手机
				row.createCell(g++).setCellValue(extOpenStoreOrder.getUserPhone());
				// 第5列 订单总价
				row.createCell(g++).setCellValue(str(extOpenStoreOrder.getOriginalPrice()));
				// 第6列 满减金额
				row.createCell(g++).setCellValue(str(extOpenStoreOrder.getDiscountPrice()));
				// 第7列 优惠券金额
				row.createCell(g++).setCellValue(str(extOpenStoreOrder.getCouponPrice()));
				// 第8列 用户实付金额
				row.createCell(g++).setCellValue(str(extOpenStoreOrder.getTotalAmount()));
				// 第9列 平台手续费
				row.createCell(g++).setCellValue(str(extOpenStoreOrder.getPlatformCharge()));
				row.createCell(g++).setCellValue(str(extOpenStoreOrder.getThinkCharge()));
				// 第10列 社区手续费
				row.createCell(g++).setCellValue(str(extOpenStoreOrder.getServiceCharge()));

				// 第11列 订单备注
				row.createCell(g++).setCellValue(extOpenStoreOrder.getRemark());
				// 第12列 收货信息
				row.createCell(g++).setCellValue(str(extOpenStoreOrder.getMobile()));
				row.createCell(g++).setCellValue(str(extOpenStoreOrder.getUserName()));
				row.createCell(g++).setCellValue(str(extOpenStoreOrder.getAddrDetail()));

				// 第13列 发货状态
				row.createCell(g++).setCellValue(OpenConstant.OpenStoreSendStatus.getLabel(extOpenStoreOrder.getSendStatus()));
				// 第14列 支付状态
				row.createCell(g++).setCellValue(OpenConstant.OpenStorePayStatus.getLabel(extOpenStoreOrder.getPayStatus()));
				// 第15列 退款状态
				row.createCell(g++).setCellValue(OpenConstant.OpenStoreRefundStatus.getLabel(extOpenStoreOrder.getRefundStatus()));
				// 第16列 退款金额
				row.createCell(g++).setCellValue(str(extOpenStoreOrder.getRefundMoney()));
				// 第17列 商家实收
				row.createCell(g++).setCellValue(str(extOpenStoreOrder.getReceiptAmount()));
				// 第18列 店铺名称
				row.createCell(g++).setCellValue(extOpenStoreOrder.getServiceTitle());
				// 第19列 所属社区
				row.createCell(g++).setCellValue(extOpenStoreOrder.getCommunityTitle());
				// 第20列 所属业务
				row.createCell(g++).setCellValue(OpenConstant.OpenStoreOrderType.getTypeLabel(extOpenStoreOrder.getType()));
				// 第21列 所属活动
				row.createCell(g++).setCellValue(extOpenStoreOrder.getActivityTitle());
				// 第20列 下单时间
				row.createCell(g++).setCellValue(sdf.format(extOpenStoreOrder.getCreateTime()));
				// 第21列 支付时间
				row.createCell(g++).setCellValue(extOpenStoreOrder.getBillFinishTime()==null ? "":sdf.format(extOpenStoreOrder.getBillFinishTime()));
				j++;
			}
			logger.info("createOpenOrderWorkBook pageQuery time={}", System.currentTimeMillis() - now);
			workbook.write(stream);
		}finally {
			IOUtils.closeQuietly(workbook);
		}
	}

	private String getGoodInfoStr(List<OpenStoreGoodOrderRel> goodList, BigDecimal expressMoney) {
		StringBuilder sb = new StringBuilder("");
		for(OpenStoreGoodOrderRel rel : goodList) {
			sb.append(rel.getGoodName() + "   ￥" + rel.getCurrentSinglePrice() + "x" + rel.getAmount() + "\n");
		}
		sb.append("运费：  ￥" + expressMoney);
		return sb.toString();
	}

	private String str(Object obj) {
		if(obj==null)return "";
		return obj.toString();
	}

}
