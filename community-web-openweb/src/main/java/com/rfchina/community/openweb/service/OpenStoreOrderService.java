package com.rfchina.community.openweb.service;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OrderPayConstant;
import com.rfchina.community.base.SysConstant;
import com.rfchina.community.openweb.entity.ExtOpenStoreOrder;
import com.rfchina.community.openweb.entity.ExtOpenStoreVerifyCard;
import com.rfchina.community.openweb.mapper.ext.ExtOpenStoreOrderMapper;
import com.rfchina.community.openweb.util.WorkBookUtil;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.service.openser.OpenStoreGroupDataSerService;
import com.rfchina.community.service.openser.OpenStoreVerifyCardService;
import com.rfchina.community.service.openser.UserCommentService;
import com.rfchina.community.service.openser.entity.ExtVerifyCardVO;
import com.rfchina.community.service.openser.entity.VerifyCardVO;
import com.rfchina.platform.common.utils.DateUtil;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.paginator.model.Page;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author:fukangwen
 * @Description: 模板订单管理service
 */
@Service
public class OpenStoreOrderService extends BaseService {

	@Autowired
	private OpenStoreOrderMapper openStoreOrderMapper;
	@Autowired
	private ExtOpenStoreOrderMapper extOpenStoreOrderMapper;
	@Autowired
	private OpenStoreGoodOrderRelService openStoreGoodOrderRelService;
	@Autowired
	private OpenFeeOrderMapper openFeeOrderMapper;
	@Autowired
	private OpenStoreVerifyCardService openStoreVerifyCardService;
	@Autowired
	private OpenStoreGoodOrderRelMapper openStoreGoodOrderRelMapper;
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private OpenStoreOrderRefundApplyMapper openStoreOrderRefundApplyMapper;
	@Autowired
	private UserCommentService userCommentService;
	@Autowired
	private OpenStoreGroupDataSerService openStoreGroupDataSerService;

	private String wrapTextFlag = "\r\n";

	/**
	 * @author:fukangwen @Description: 订单管理查询 @return Object @throws
	 */
	public Page<ExtOpenStoreOrder> pageQuery(Map<String, Object> param, PageBounds pageBounds) {
		PageList<ExtOpenStoreOrder> list = page(param,pageBounds);
		return list.convert();
	}

	/**
	 * @author:fukangwen @Description: 获取订单 @return OpenStoreOrder @throws
	 */
	public OpenStoreOrder getOpenStoreOrder(int orderId) {
		OpenStoreOrder openStoreOrder = openStoreOrderMapper.selectByPrimaryKey(orderId);
		validator(openStoreOrder == null, "订单不存在");
		return openStoreOrder;
	}

	/**
	 * @author:fukangwen @Description: 更新订单 @return void @throws
	 */
	public void save(OpenStoreOrder openStoreOrder) {
		openStoreOrderMapper.updateByPrimaryKeySelective(openStoreOrder);
	}

	/**
	 * @author:fukangwen @Description: 获取订单详情 @return ExtOpenStoreOrder @throws
	 */
	public ExtOpenStoreOrder getDetail(int orderId) {
		//
		OpenStoreOrder openStoreOrder = openStoreOrderMapper.selectByPrimaryKey(orderId);
		validator(openStoreOrder == null, "订单不存在");

		ExtOpenStoreOrder extOpenStoreOrder = new ExtOpenStoreOrder();
		BeanUtils.copyProperties(openStoreOrder, extOpenStoreOrder);

		//查询团购信息
		Long groupDataId = openStoreOrder.getGroupDataId();
		if(groupDataId != null && groupDataId != 0){
			OpenStoreGroupData openStoreGroupData = openStoreGroupDataSerService.findById(openStoreOrder.getGroupDataId());
			if(openStoreGroupData != null){
				extOpenStoreOrder.setGroupSuccessStatus(openStoreGroupData.getStatus());
			}
		}

		extOpenStoreOrder.setGoodList(openStoreGoodOrderRelService.getList(orderId));
		
		extOpenStoreOrder.setIsNeedVerify(openStoreVerifyCardService.isNeedVerify(orderId));
		
		OpenFeeOrderExample example = new OpenFeeOrderExample();
		example.createCriteria().andStoreOrderIdEqualTo(orderId);
		List<OpenFeeOrderWithBLOBs> FeeOrderList = openFeeOrderMapper.selectByExampleWithBLOBs(example);
		extOpenStoreOrder.setFeeOrderList(FeeOrderList);
		//查询评论
		UserComment userComment = userCommentService.getByOutTradeNo(openStoreOrder.getOutTradeNo());
		if(userComment != null){
			extOpenStoreOrder.setCommentId(userComment.getId());
		}
		return extOpenStoreOrder;
	}

	public ExtOpenStoreVerifyCard getVerifyCardDetail(String code, int type, int serviceId) {
		
		ExtOpenStoreVerifyCard card = new ExtOpenStoreVerifyCard();
		
		//区别订单跟核销单
		if(code.startsWith("STORE") || code.startsWith("XFSJ")) {
			OpenStoreOrderExample example = new OpenStoreOrderExample();
			example.createCriteria().andOutTradeNoEqualTo(code).andServiceIdEqualTo(serviceId);
			List<OpenStoreOrder> list = openStoreOrderMapper.selectByExample(example);
			if(list.isEmpty() || list.size() > 1) {
				validator(type == 1, "二维码无效");
				error("输入的单号无效，请重新输入");
			}
			
			OpenStoreOrder order = list.get(0); 
			BeanUtils.copyProperties(order, card);
			card.setGoodList(openStoreGoodOrderRelService.getVOList(card.getId()));
			return card;
		}
		
		//单个核销单
		VerifyCardVO verifyCardVO = openStoreVerifyCardService.getVerifyCardVO(code, serviceId);
		if(verifyCardVO == null) {
			validator(type == 1, "二维码无效");
			error("输入的单号无效，请重新输入");
		}
		ExtVerifyCardVO extVerifyCardVO = new ExtVerifyCardVO();
		BeanUtils.copyProperties(verifyCardVO, extVerifyCardVO);
		
		OpenStoreGoodOrderRel rel = openStoreGoodOrderRelMapper.selectByPrimaryKey(verifyCardVO.getGoodOrderRelId());
		extVerifyCardVO.setVerifyStartTime(rel.getVerifyStartTime());
		extVerifyCardVO.setVerifyEndTime(rel.getVerifyEndTime());
		
		UserInfo userinfo = userInfoMapper.selectByPrimaryKey(verifyCardVO.getUid());
		validator(userinfo == null, "用户信息不存在!");
		extVerifyCardVO.setPhone(userinfo.getPhone());
		extVerifyCardVO.setNickname(userinfo.getNickname());
		extVerifyCardVO.setVerifyMoney(verifyCardVO.getSingleScalePrice()); 
		card.setExtVerifyCardVO(extVerifyCardVO);
		
		OpenStoreOrder openStoreOrder = openStoreOrderMapper.selectByPrimaryKey(verifyCardVO.getOrderId());
		validator(openStoreOrder == null, "订单不存在");
		BeanUtils.copyProperties(openStoreOrder, card);
		return card;	
	}

	/**
	 * @author:fukangwen
	 * @Description: 核销
	 * @return void
	 * @throws
	 */
	@Transactional
	public void verifyCard(String ids, int serviceId) {
		String[] idStrings = ids.split(",");
		for(String idStr : idStrings) {
			int id = Integer.parseInt(idStr);
			//核销
			openStoreVerifyCardService.verify(id, serviceId);
		}
	}

	public XSSFWorkbook exportOrder(Map<String, Object> param) {
		PageList<ExtOpenStoreOrder> list = page(param, new PageBounds());

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setWrapText(true);
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		Sheet sheet = workbook.createSheet("订单统计");

		Row row = sheet.createRow(0);
		String titleTops = "订单号,订单类型,下单时间,商品名称,商品数量,商品价格,运费,订单备注,总金额,满减金额,优惠券金额,实收金额,联系人,联系电话,地址,配送信息,订单状态,核销状态,评价状态,退款状态";
		String[] titles = titleTops.split(",");
		for (int i = 0; i < titles.length; i++) {
			WorkBookUtil.createCellValue(row, i, titles[i]);
		}
		int r = 1;
		for (ExtOpenStoreOrder order : list) {
			//设置单元格合并
			List<OpenStoreGoodOrderRel> goodsList = order.getGoodList();
			OpenStoreGoodOrderRel firstGoodsInfo = null;
			Boolean mergedFlag = false;
			if (goodsList != null) {
				firstGoodsInfo = goodsList.remove(0);
				if (goodsList.size() > 0) {
					int lastRow = r + goodsList.size();
					for (int i = 0; i < titles.length; i++) {
						if (i != 3 && i != 4 && i != 5) {
							sheet.addMergedRegion(new CellRangeAddress(r, lastRow, i, i));
						}
					}
					mergedFlag = true;
				}
			}
			row = sheet.createRow(r++);
			int i = 0;
			//订单号
			WorkBookUtil.createCellValue(row, i++, order.getOutTradeNo());
			//订单类型
			WorkBookUtil.createCellValue(row, i++, order.getGroupStatus()==1 ? "拼团订单" : "普通订单");
			//下单时间
			WorkBookUtil.createCellValue(row, i++, DateUtil.formatDate(order.getCreateTime()));
			//商品名称
			WorkBookUtil.createCellValue(row, i++, firstGoodsInfo != null ? firstGoodsInfo.getGoodName() : "");
			//商品数量
			WorkBookUtil.createCellValue(row, i++, firstGoodsInfo != null ? String.valueOf(firstGoodsInfo.getAmount()) : "");
			//商品价格
			WorkBookUtil.createCellValue(row, i++, firstGoodsInfo != null ? String.valueOf(firstGoodsInfo.getCurrentSinglePrice()) : "");
			//运费
			WorkBookUtil.createCellValue(row, i++, bigDecimal2String(order.getExpressMoney()));
			//订单备注
			WorkBookUtil.createCellValue(row, i++, order.getRemark());
			//总金额
			WorkBookUtil.createCellValue(row, i++, bigDecimal2String(order.getOriginalPrice()));
			//满减金额
			WorkBookUtil.createCellValue(row, i++, bigDecimal2String(order.getDiscountPrice()));
			//优惠券金额
			WorkBookUtil.createCellValue(row, i++, bigDecimal2String(order.getCouponPrice()));
			//实收金额
			WorkBookUtil.createCellValue(row, i++, bigDecimal2String(order.getTotalAmount()));
			//联系人
			WorkBookUtil.createCellValue(row, i++, order.getUserName());
			//联系电话
			WorkBookUtil.createCellValue(row, i++, order.getMobile());
			//地址
			WorkBookUtil.createCellValue(row, i++, order.getAddrDetail());
			//配送信息
			WorkBookUtil.createCellValue(row, i++, buildExpressInfo(order));
			//订单状态
			WorkBookUtil.createCellValue(row, i++, buildOrderStatus(order));
			//核销状态
			WorkBookUtil.createCellValue(row, i++, buildOrderVerifyStatus(order));
			//评价状态
			WorkBookUtil.createCellValue(row, i++, SysConstant.COMMON_STATUS_NORMAL.equals(order.getCommentStatus()) ? "已评价" : SysConstant.COMMON_STATUS_HIDE.equals(order.getCommentStatus()) ? "未评价" : "不可评价");
			//退款状态
			WorkBookUtil.createCellValue(row, i++, buildOrderRefundStatus(order));

			if (mergedFlag) {
				for (OpenStoreGoodOrderRel rel : goodsList) {
					row = sheet.createRow(r++);
					WorkBookUtil.createCellValue(row, 3, rel.getGoodName());
					WorkBookUtil.createCellValue(row, 4, String.valueOf(rel.getAmount()));
					WorkBookUtil.createCellValue(row, 5, String.valueOf(rel.getCurrentSinglePrice()));
				}
			}
		}
		return workbook;
	}

	private PageList<ExtOpenStoreOrder> page(Map<String, Object> param, PageBounds pageBounds){
		PageList<ExtOpenStoreOrder> list = extOpenStoreOrderMapper.pageByCondition(param, pageBounds);
		if (!list.isEmpty()) {
			for (ExtOpenStoreOrder ext : list) {
				ext.setGoodList(openStoreGoodOrderRelService.getList(ext.getId()));
				if(ext.getOpenRefundId() != null) {
					OpenStoreOrderRefundApply refundApply = openStoreOrderRefundApplyMapper.selectByPrimaryKey(ext.getOpenRefundId());
					ext.setReasonCertificate(refundApply == null ? null : refundApply.getReasonCertificate());
				}
			}
		}
		return list;
	}

	private String buildExpressInfo(ExtOpenStoreOrder order) {
		String expressType = order.getExpressType();
		StringBuilder sb = new StringBuilder();
		if (OpenConstant.OpenStoreExpressType.EXPRESS.getCode().equals(expressType)) {
			return sb.append("快递/物流").append(wrapTextFlag).append(order.getExpressName()).append(wrapTextFlag).append(order.getExpressCode()).toString();
		} else if (OpenConstant.OpenStoreExpressType.SELF.getCode().equals(expressType)) {
			return sb.append("客户自提").append(wrapTextFlag).append(order.getExpressTime()).append(wrapTextFlag).append(order.getExpressArea()).toString();
		} else if (OpenConstant.OpenStoreExpressType.VISIT.getCode().equals(expressType)) {
			return sb.append("送货上门").append(wrapTextFlag).append(order.getExpressTime()).append(wrapTextFlag).append(order.getExpressPhone()).toString();
		} else if (OpenConstant.OpenStoreExpressType.NOT_NEED.getCode().equals(expressType)) {
			return sb.append("无需快递").toString();
		}
		return "";
	}

	private String buildOrderStatus(ExtOpenStoreOrder order) {
		Integer payStatus = order.getPayStatus();
		Integer sendStatus = order.getSendStatus();
		StringBuilder sb = new StringBuilder();
		if (OrderPayConstant.PayStatus.NO_PAYMENT.getCode() == payStatus) {
			sb.append("未支付");
		} else if (OrderPayConstant.PayStatus.INVALID.getCode() == payStatus) {
			sb.append("已关闭");
		} else if (OrderPayConstant.PayStatus.PAY.getCode() == payStatus) {
			if(sendStatus == null){
				sb.append("已支付");
			}else if (OrderPayConstant.SendStatus.NOT_SEND.getCode() == sendStatus) {
				sb.append("待发货");
			} else if (OrderPayConstant.SendStatus.SEND.getCode() == sendStatus) {
				sb.append("已发货");
			} else if (OrderPayConstant.SendStatus.COMPLETE.getCode() == sendStatus) {
				sb.append("已完成");
			}
		}
		return sb.toString();
	}

	private String buildOrderVerifyStatus(ExtOpenStoreOrder order) {
		String verifyStatus = order.getVerifyStatus();
		StringBuilder sb = new StringBuilder();
		OrderPayConstant.VerifyStatus[] verifyStatuses = OrderPayConstant.VerifyStatus.values();
		for(OrderPayConstant.VerifyStatus status : verifyStatuses){
			if(status.getCode().equals(verifyStatus)){
				sb.append(status.getLabel());
				break;
			}
		}
		return sb.toString();
	}

	private String buildOrderRefundStatus(ExtOpenStoreOrder order) {
		Integer refundStatus = order.getRefundStatus();

		if (OrderPayConstant.RefundStatus.SUCCESS.getCode() == refundStatus) {
			return "退款成功";
		} else if (OrderPayConstant.RefundStatus.REFUND_AUDITING.getCode() == refundStatus ||
				OrderPayConstant.RefundStatus.PC_UPPING.getCode() == refundStatus ||
				OrderPayConstant.RefundStatus.PC_AUDITING.getCode() == refundStatus ||
				OrderPayConstant.RefundStatus.PC_CONFIRM.getCode() == refundStatus) {
			return "平台处理中";
		} else if (OrderPayConstant.RefundStatus.FAILURE.getCode() == refundStatus) {
			return "退款失败";
		} else if (OrderPayConstant.RefundStatus.MERCHANT_AUDITING.getCode() == refundStatus) {
			return "客户申请退款";
		}
		return "";
	}

	private String bigDecimal2String(BigDecimal money) {
		if (money != null) {
			return money.toString();
		}
		return "0";
	}
}
