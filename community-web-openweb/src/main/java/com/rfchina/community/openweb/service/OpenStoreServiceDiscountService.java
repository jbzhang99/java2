package com.rfchina.community.openweb.service;

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
	
	/**
	 * @author:fukangwen
	 * @Description: 新增下单满减信息
	 * @return void
	 * @throws
	 */
	public void insert(int serviceId) {
		OpenStoreServiceDiscount domain = new OpenStoreServiceDiscount();
		domain.setServiceId(serviceId);
		BigDecimal initData = new BigDecimal(0);
		domain.setDiscountMoney(initData);
		domain.setDiscountPrice(initData);
		domain.setEachMoneyTop(initData);
		domain.setValidStatus(OpenConstant.DiscountStatus.invalid_status);
		openStoreServiceDiscountMapper.insert(domain);
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 更新下单满减信息
	 * @return void
	 * @throws
	 */
	public void update(int serviceId, BigDecimal discountPrice, BigDecimal discountMoney, BigDecimal eachMoneyTop, int status) {
		OpenStoreServiceDiscount domain = openStoreServiceDiscountMapper.selectByPrimaryKey(serviceId);
		validator(domain == null, "更新满减信息出错");
		domain.setDiscountPrice(discountPrice);
		domain.setDiscountMoney(discountMoney);
		domain.setEachMoneyTop(eachMoneyTop);
		domain.setValidStatus(status);
		openStoreServiceDiscountMapper.updateByPrimaryKeySelective(domain);
	}

	/**
	 * @author:fukangwen
	 * @Description: 
	 * @return OpenStoreServiceDiscount
	 * @throws
	 */
	public OpenStoreServiceDiscount getDiscount(int serviceId) {
		return openStoreServiceDiscountMapper.selectByPrimaryKey(serviceId);
	}

	public void updateStatus(int serviceId, int status) {
		OpenStoreServiceDiscount domain = openStoreServiceDiscountMapper.selectByPrimaryKey(serviceId);
		validator(domain == null, "更新满减信息出错");
		domain.setValidStatus(status);
		openStoreServiceDiscountMapper.updateByPrimaryKeySelective(domain);
		
	}
	
	
	
}
