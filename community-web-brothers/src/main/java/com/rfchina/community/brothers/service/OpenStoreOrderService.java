package com.rfchina.community.brothers.service;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenGoodGroupConstant;
import com.rfchina.community.base.OrderPayConstant;
import com.rfchina.community.base.SysConstant;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.service.BaseService;
import com.rfchina.community.service.openser.CmStoreCouponRecordService;
import com.rfchina.community.service.openser.OpenStoreGoodOrderRelBaseService;
import com.rfchina.community.service.openser.OpenStoreGoodStockDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OpenStoreOrderService extends BaseService {

	@Autowired
	private OpenStoreOrderMapper openStoreOrderMapper;
	@Autowired
	private OpenStoreGoodOrderRelBaseService openStoreGoodOrderRelBaseService;
	@Autowired
	private CmStoreCouponRecordService cmStoreCouponRecordService;
	@Autowired
	private OpenStoreGroupDataMapper openStoreGroupDataMapper;
	@Autowired
	private OpenStoreGoodMapper openStoreGoodMapper;
	@Autowired
	private OpenStoreGoodStockDetailMapper openStoreGoodStockDetailMapper;
	@Autowired
	private OpenStoreGoodGroupInfoMapper openStoreGoodGroupInfoMapper;
	@Autowired
	private OpenStoreGoodStockDetailService openStoreGoodStockDetailService;
	/**
	 * @author:fukangwen
	 * @Description: 查看发送状态，并更新状态
	 * @return int
	 * @throws
	 */
	public int checkSendStatusAndUpdate(long automaticPraiseLength) {
		OpenStoreOrderExample example = new OpenStoreOrderExample();
		example.createCriteria().andPayStatusEqualTo(OrderPayConstant.PayStatus.PAY.getCode())
			.andSendStatusEqualTo(OrderPayConstant.SendStatus.SEND.getCode())
			.andExpressCompanyCodeIsNull()
			.andSendTimeLessThan(new Date(System.currentTimeMillis() - automaticPraiseLength));
		example.or().andPayStatusEqualTo(OrderPayConstant.PayStatus.PAY.getCode())
				.andSendStatusEqualTo(OrderPayConstant.SendStatus.SEND.getCode())
				.andExpressCompanyCodeIsNotNull()
				.andExpressStatusEqualTo(SysConstant.EXPRESS_STATUS_FINISH)
				.andSignForTimeLessThan(new Date(System.currentTimeMillis() - automaticPraiseLength));
		OpenStoreOrder order = new OpenStoreOrder();
		order.setSendStatus(OrderPayConstant.SendStatus.COMPLETE.getCode());
		order.setCommentStatus(SysConstant.COMMON_STATUS_HIDE); //评论状态设置为待评论
		order.setConfirmTime(new Date());
		return openStoreOrderMapper.updateByExampleSelective(order, example);
		
	}
	
	
	/**
	 * @author:fukangwen
	 * @Description: 超过15分钟未支付，关闭订单
	 * @return int
	 * @throws
	 */
	public int checkInvalidPayAndUpdate(long expireTime) {
		OpenStoreOrderExample example = new OpenStoreOrderExample();
		example.createCriteria().andPayStatusEqualTo(OrderPayConstant.PayStatus.NO_PAYMENT.getCode()).
			andCreateTimeLessThan(new Date(System.currentTimeMillis() - expireTime));
		List<OpenStoreOrder> list = openStoreOrderMapper.selectByExample(example);
		long now = System.currentTimeMillis();
		for(OpenStoreOrder openStoreOrder : list) {
			openStoreOrder.setPayStatus(OrderPayConstant.PayStatus.INVALID.getCode());
			openStoreOrderMapper.updateByPrimaryKey(openStoreOrder);

//			List<OpenStoreGoodOrderRel> relList = openStoreGoodOrderRelBaseService.getList(openStoreOrder.getId());
			//超时，更新商品库存
			this.rebackStock(openStoreOrder.getId());
			//超时取消优惠券锁定
			cmStoreCouponRecordService.unlockCardCouponRecord(openStoreOrder.getOrderCode());
			
		}
		logger.info("定时改变库存的总时间：耗时：{}", System.currentTimeMillis() - now);
		return list.size();
	}
	


	public void rebackStock(Integer orderId) {
		long now = System.currentTimeMillis();

		OpenStoreGoodStockDetailExample example = new OpenStoreGoodStockDetailExample();
		example.createCriteria().andTargetIdEqualTo(orderId).andOperateEqualTo("DEC");
		List<OpenStoreGoodStockDetail> list = openStoreGoodStockDetailMapper.selectByExample(example);

		for(OpenStoreGoodStockDetail detail : list) {
			if(OpenGoodGroupConstant.stockType.good.equals(detail.getType())) {
				rebackGoodStock(detail.getGoodId(), detail.getAmount(), orderId);
			}else if(OpenGoodGroupConstant.stockType.group.equals(detail.getType())){
				rebackGroupStock(detail.getGoodId(),detail.getGroupInfoId(), detail.getAmount(), orderId);
			}else{
				rebackGroupDataStock(detail.getGoodId(),detail.getGroupDataId(), detail.getAmount(), orderId);
			}

		}

	}

	/**
	 * 团数据可用锁
	 * @param goodId
	 * @param groupDataId
	 * @param amount
	 * @param orderId
	 */
	private void rebackGroupDataStock(Integer goodId, Long groupDataId, Integer amount, Integer orderId) {
		OpenStoreGroupData data = openStoreGroupDataMapper.selectByPrimaryKey(groupDataId);
		if (data == null)
			return;
		int before = data.getUsableNum();
		//增加
		data.setUsableNum(data.getUsableNum() + amount);
		data.setLockNum(data.getLockNum() - amount);
		openStoreGroupDataMapper.updateByPrimaryKey(data);
		openStoreGoodStockDetailService.insertGroupDataStockDetail(goodId, data.getGoodGroupId(),groupDataId, before, data.getUsableNum(), amount,
				OpenGoodGroupConstant.stockType.groupdata, OpenConstant.StockOperate.ADD.toString(),
				OpenConstant.StockSource.CLIENT.toString(), orderId);
	}

	/**
	 * 释放商品库存锁
	 * @param goodId
	 * @param amount
	 * @param orderId
	 */
	private void rebackGoodStock(Integer goodId, int amount, int orderId){
		OpenStoreGood openStoreGood = openStoreGoodMapper.selectByPrimaryKey(goodId);
		if (openStoreGood == null)
			return;
		int before = openStoreGood.getStock();
		//增加
		openStoreGood.setStock(openStoreGood.getStock() + amount);
		openStoreGoodMapper.updateByPrimaryKey(openStoreGood);

		openStoreGoodStockDetailService.insert(goodId, 0, before, openStoreGood.getStock(), amount,
				OpenGoodGroupConstant.stockType.good, OpenConstant.StockOperate.ADD.toString(),
				OpenConstant.StockSource.CLIENT.toString(), orderId);
	}

	private void rebackGroupStock(int goodId, Long groupInfoId, int amount, int orderId){
		OpenStoreGoodGroupInfo groupInfo = openStoreGoodGroupInfoMapper.selectByPrimaryKey(groupInfoId);
		if (groupInfo == null)
			return;
		int before = groupInfo.getStock();
		//增加
		groupInfo.setStock(groupInfo.getStock() + amount);
		openStoreGoodGroupInfoMapper.updateByPrimaryKey(groupInfo);
		openStoreGoodStockDetailService.insert(goodId, groupInfoId, before, groupInfo.getStock(), amount,
				OpenGoodGroupConstant.stockType.group, OpenConstant.StockOperate.ADD.toString(),
				OpenConstant.StockSource.CLIENT.toString(), orderId);
	}

}
