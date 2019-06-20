package com.rfchina.community.openstore.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.persistence.mapper.OpenStoreServiceDiscountMapper;
import com.rfchina.community.persistence.model.OpenStoreServiceDiscount;
/**
 * @author:fukangwen
 * @Description: 下单满减service
 */
@Service
public class OpenStoreServiceDiscountService extends BaseService{

	@Autowired
	private OpenStoreServiceDiscountMapper openStoreServiceDiscountMapper;
	
	public OpenStoreServiceDiscount getByServiceId(int serviceId) {
		return openStoreServiceDiscountMapper.selectByPrimaryKey(serviceId);
	}
	
	//计算满减金额
	public BigDecimal getDiscountPrice(BigDecimal serverGoodTotal, int serviceId) {
		BigDecimal sumDiscountMoney = new BigDecimal(0);
		//获取满减信息
		OpenStoreServiceDiscount discount = getByServiceId(serviceId);
		if(discount==null) {
			return sumDiscountMoney;
		}
		//满减无效
		if(discount.getValidStatus() == OpenConstant.DiscountStatus.invalid_status) {
			logger.info("满减无效:discount.getValidStatus() = {}",discount.getValidStatus());
			return sumDiscountMoney;
		}
	
		//满减生效，计算的总价要根据满减重新计算
		BigDecimal discountPrice = discount.getDiscountPrice().setScale(2, BigDecimal.ROUND_HALF_DOWN); //每满价格
		BigDecimal discountMoney = discount.getDiscountMoney().setScale(2, BigDecimal.ROUND_HALF_DOWN);	//满减价格
		BigDecimal eachMoneyTop = discount.getEachMoneyTop().setScale(2, BigDecimal.ROUND_HALF_DOWN); 	//满减上限
		
		if(serverGoodTotal.compareTo(discountPrice) < 0) {
			//1.serverGoodTotal < discountPrice 没有达到满减条件
			logger.info("没有达到满减条件:serverGoodTotal={},discountPrice={}",serverGoodTotal,
					discountPrice);
			return sumDiscountMoney;
		}else {
			sumDiscountMoney = discountMoney.multiply(
					new BigDecimal(serverGoodTotal.divide(discountPrice, 0, BigDecimal.ROUND_DOWN).intValue())
				);
			
			if(eachMoneyTop.compareTo(new BigDecimal(0)) > 0) {
				//2.有满减上限
				sumDiscountMoney = sumDiscountMoney.compareTo(eachMoneyTop) > 0 ? eachMoneyTop : sumDiscountMoney;
			}
			
			return sumDiscountMoney;
		}
	}
	
}
