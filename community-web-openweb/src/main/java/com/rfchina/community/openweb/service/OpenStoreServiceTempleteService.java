package com.rfchina.community.openweb.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.exception.WorkRunTimeException;
import com.rfchina.community.openweb.entity.ExtOpenStoreServiceTemplete;
import com.rfchina.community.openweb.mapper.ext.ExtOpenStoreServiceTempleteMapper;
import com.rfchina.community.persistence.mapper.OpenStoreServiceTempleteMapper;
import com.rfchina.community.persistence.model.CommunityServiceTemp;
import com.rfchina.community.persistence.model.OpenServiceDetail;
import com.rfchina.community.persistence.model.OpenStoreServiceTemplete;

/**
 * @author:fukangwen
 * @Description: 服务商模板service
 */
@Service
public class OpenStoreServiceTempleteService extends com.rfchina.community.component.CommunityServiceComponent{

	@Autowired
	private OpenStoreServiceTempleteMapper openStoreServiceTempleteMapper;
	@Autowired
	private ExtOpenStoreServiceTempleteMapper extOpenStoreServiceTempleteMapper;
	@Autowired
	private CommunityServiceService communityServiceService;
	@Autowired
	private OpenStoreServiceDiscountService openStoreServiceDiscountService;
	@Autowired
	private OpenServiceDetailService openServiceDetailService;

	/**
	 * @author:fukangwen @Description: 修改或新增店铺资料 @return void @throws
	 */
	public void insertOrUpdate(int serviceId, BigDecimal expressMoney, String phone, String bannerUrl, int premiumNum) {
		OpenStoreServiceTemplete templete = openStoreServiceTempleteMapper.selectByPrimaryKey(serviceId);
		if (templete == null) {
			insert(serviceId, expressMoney, phone, bannerUrl, premiumNum);
			//新增满减信息
			openStoreServiceDiscountService.insert(serviceId);
		}else {
			update(templete, expressMoney, phone, bannerUrl);
		}

	}

	/**
	 * @author:fukangwen @Description: 新增模板 @return void @throws
	 */
	private void insert(int serviceId, BigDecimal expressMoney, String phone, String bannerUrl, int premiumNum) {
		OpenStoreServiceTemplete templete = new OpenStoreServiceTemplete();
		templete.setServiceId(serviceId);
		templete.setBannerUrl(bannerUrl);
		templete.setExpressMoney(expressMoney == null ? new BigDecimal(0) : expressMoney);
		templete.setPhone(phone);
		templete.setPremiumNum(premiumNum);
		templete.setCreateTime(new Date());
		//默认是关闭闪付功能
		templete.setQuickPay(0);
		openStoreServiceTempleteMapper.insertSelective(templete);
	}

	/**
	 * @author:fukangwen @Description: 更新模板内容 @return void @throws
	 */
	public void update(OpenStoreServiceTemplete templete, BigDecimal expressMoney, String phone, String bannerUrl) {
		if(StringUtils.isNotBlank(bannerUrl)){
			templete.setBannerUrl(bannerUrl);
		}
		if(expressMoney != null){
			templete.setExpressMoney(expressMoney);
		}
		if(StringUtils.isNotBlank(phone)){
			templete.setPhone(phone);
		}
		openStoreServiceTempleteMapper.updateByPrimaryKeySelective(templete);
	}
	

	/**
	 * @author:fukangwen @Description: 获取店铺资料 @return
	 *                   OpenStoreServiceTemplete @throws
	 */
	public ExtOpenStoreServiceTemplete getTemplete(int serviceId) {
		OpenStoreServiceTemplete domain = openStoreServiceTempleteMapper.selectByPrimaryKey(serviceId);
		if(domain == null) {
			throw new WorkRunTimeException("该店铺不存在");
		}
		ExtOpenStoreServiceTemplete extDomain = new ExtOpenStoreServiceTemplete();
		BeanUtils.copyProperties(domain, extDomain);
		CommunityServiceTemp serviceDomain = communityServiceService.getCommunityServiceTempByPrimaryKey(serviceId);
		extDomain.setTitle(serviceDomain.getTitle());
		OpenServiceDetail openServiceDetail = openServiceDetailService.getTemplete(domain.getServiceId());
		if(openServiceDetail == null) {
			throw new WorkRunTimeException("该店铺信息有误");
		}
		extDomain.setTempleteName(openServiceDetail.getTempleteName());
		
		return extDomain;
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 返回bannerUrl
	 * @return String
	 * @throws
	 */
	public OpenStoreServiceTemplete getTempleteDomain(int serviceId) {
		OpenStoreServiceTemplete domain = openStoreServiceTempleteMapper.selectByPrimaryKey(serviceId);
		return domain;
	}

	/**
	 * @author:fukangwen @Description: 判断服务是否创建了店铺 @return Boolean @throws
	 */
	public Boolean isExist(int serviceId) {
		return openStoreServiceTempleteMapper.selectByPrimaryKey(serviceId) == null ? false : true;
	}

	/**
	 * @author:fukangwen @Description: 根据状态获取该服务商的可用店铺 @return
	 *                   List<ExtOpenStoreServiceTemplete> @throws
	 */
	public List<ExtOpenStoreServiceTemplete> getTempleteList(Long merchantId, int status, String type) {
		Map<String, Object> param = new HashMap<>();
		param.put("merchantId", merchantId);
		param.put("templeteStatus", status);
//		if(StringUtils.isNotBlank(type)) {
//			param.put("type", type);
//		}
		return extOpenStoreServiceTempleteMapper.getTempleteList(param);
	}

	public int insertOrUpdateAddress(int serviceId, int province, int city, int area, String address_info, String address_all_info,
			String open_time, String close_time, String bannerUrl) {
		OpenStoreServiceTemplete templete = openStoreServiceTempleteMapper.selectByPrimaryKey(serviceId);
		if (templete == null)
			return insertAddress(serviceId, province, city, area, address_info, address_all_info, open_time, close_time, bannerUrl);
		else
			return updateAddress(serviceId, province, city, area, address_info, address_all_info, open_time, close_time, bannerUrl);

	}

	private int insertAddress(int serviceId, int addressProvince, int addressCity, int addressArea, String addressInfo, String addressAllInfo,
			String openTime, String closeTime, String storePic) {
		OpenStoreServiceTemplete templete = new OpenStoreServiceTemplete();
		templete.setServiceId(serviceId);
		templete.setStorePic(storePic);
		templete.setCloseTime(closeTime);
		templete.setOpenTime(openTime);
		templete.setAddressArea(addressArea);
		templete.setAddressCity(addressCity);
		templete.setAddressInfo(addressInfo);
		templete.setAddressProvince(addressProvince);
		templete.setAddressAllInfo(addressAllInfo);
		templete.setCreateTime(new Date());
		return openStoreServiceTempleteMapper.insertSelective(templete);

	}

	private int updateAddress(int serviceId, int addressProvince, int addressCity, int addressArea, String addressInfo,String addressAllInfo,
			String openTime, String closeTime, String storePic) {
		OpenStoreServiceTemplete templete = new OpenStoreServiceTemplete();
		templete.setServiceId(serviceId);
		templete.setStorePic(storePic);
		templete.setCloseTime(closeTime);
		templete.setOpenTime(openTime);
		templete.setAddressArea(addressArea);
		templete.setAddressCity(addressCity);
		templete.setAddressInfo(addressInfo);
		templete.setAddressProvince(addressProvince);
		templete.setAddressAllInfo(addressAllInfo);
		return openStoreServiceTempleteMapper.updateByPrimaryKeySelective(templete);

	}

	/**
	 * @author:fukangwen
	 * @Description: 修改运费
	 * @return void
	 * @throws
	 */
	public void saveExpressMoney(int serviceId, BigDecimal expressMoney) {
		OpenStoreServiceTemplete templete = openStoreServiceTempleteMapper.selectByPrimaryKey(serviceId);
		templete.setExpressMoney(expressMoney);
		openStoreServiceTempleteMapper.updateByPrimaryKeySelective(templete);
		
	}
}
