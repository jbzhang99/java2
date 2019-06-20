package com.rfchina.community.openstore.service;

import com.rfchina.community.openstore.entity.ext.ExtOpenStoreServiceTemplete;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.mapper.OpenStoreServiceTempleteMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.OpenMerchantInfo;
import com.rfchina.community.persistence.model.OpenStoreServiceDiscount;
import com.rfchina.community.persistence.model.OpenStoreServiceTemplete;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author:fukangwen
 * @Description: 服务商模板service
 */
@Service
public class OpenStoreServiceTempleteService extends BaseService{

	@Autowired
	private OpenStoreServiceTempleteMapper openStoreServiceTempleteMapper;
	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;
	@Autowired
	private CommunityServiceService communityServiceService;
	@Autowired
	private OpenStoreServiceDiscountService openStoreServiceDiscountService;
	

	/**
	 * @author:fukangwen
	 * @Description: 获取店铺资料
	 * @return OpenStoreServiceTemplete
	 * @throws
	 */
	public ExtOpenStoreServiceTemplete getTempleteInfo(int serviceId) {
		OpenStoreServiceTemplete domain = openStoreServiceTempleteMapper.selectByPrimaryKey(serviceId);
		validator(domain == null, "模板不存在");
		ExtOpenStoreServiceTemplete extDomain = new ExtOpenStoreServiceTemplete();
		BeanUtils.copyProperties(domain, extDomain);
		CommunityService serviceDomain = communityServiceService.getCommunityServiceByPrimaryKey(serviceId);
		extDomain.setTitle(serviceDomain.getTitle());
		extDomain.setDescription(serviceDomain.getDescription());
		extDomain.setPng(serviceDomain.getPng());
		extDomain.setOpenStoreServiceDiscount(openStoreServiceDiscountService.getByServiceId(serviceId));
		OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(serviceDomain.getMerchantId());
		extDomain.setMerchantTitle(info == null ? "" : info.getTitle());
		return extDomain;
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 判断服务是否创建了店铺
	 * @return Boolean
	 * @throws
	 */
	public Boolean isExist(int serviceId) {
		return openStoreServiceTempleteMapper.selectByPrimaryKey(serviceId) == null ? false : true;
	}

	
	public OpenStoreServiceDiscount getOpenStoreServiceDiscount(int serviceId) {
		return openStoreServiceDiscountService.getByServiceId(serviceId);
	}
}
