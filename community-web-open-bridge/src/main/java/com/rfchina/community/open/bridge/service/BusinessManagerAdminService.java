package com.rfchina.community.open.bridge.service;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.Constant;
import com.rfchina.community.open.bridge.entity.CityCommunityEntity;
import com.rfchina.community.open.bridge.mapper.ext.ExtCommunityServiceMapper;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.service.openser.OpenServicePayService;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.Order;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BusinessManagerAdminService extends BaseService {
	@Autowired
	private OpenServiceDetailMapper openServiceDetailMapper;
	@Autowired
	private OpenServicePayService openServicePayService;
	@Autowired
	private OpenStoreServiceTempleteMapper openStoreServiceTempleteMapper;
	@Autowired
	private CommunityServiceCategoryMapper communityServiceCategoryMapper;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private CommunityServiceRelaMapper communityServiceRelaMapper;
	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;
	@Autowired
	private CommunityServiceTempMapper communityServiceTempMapper;
	@Autowired
	private ExtCommunityServiceMapper extCommunityServiceMapper;
	@Autowired
	private CommunityMapper communityMapper;
	@Autowired
	private AreaMapper areaMapper;
	@Autowired
	private OpenManagerInviteMapper openManagerInviteMapper;
    @Autowired
    private CommunityServiceCategoryService communityServiceCategoryService;
    /*@Autowired
    private CommunityBaseService communityBaseService;*/

	public JSONObject getBusinessManagerAdmin(Integer id) {
		JSONObject json = new JSONObject();
        //查询服务拓展信息
		OpenServiceDetail detail = openServiceDetailMapper.selectByPrimaryKey(id);
		//查询服务信息
		CommunityService info = communityServiceMapper.selectByPrimaryKey(id);
		//查询店铺信息
		OpenMerchantInfo merchant = openMerchantInfoMapper.selectByPrimaryKey(info.getMerchantId());
		//查询店铺信息 取店铺溢价  商品溢价幅度
		OpenStoreServiceTemplete store = openStoreServiceTempleteMapper.selectByPrimaryKey(id);
		//查询邀请信息
		OpenManagerInviteExample exa = new OpenManagerInviteExample();
		exa.createCriteria().andServiceIdEqualTo(id);
		List<OpenManagerInvite> invite = openManagerInviteMapper.selectByExample(exa);

		//费率查询
		OpenServicePay pay = openServicePayService.getOpenServicePay(id);
		json.put("pay", pay == null ? new OpenServicePay(): pay);

		//查询 服务范围
		CommunityServiceRelaExample e1 = new CommunityServiceRelaExample();
		e1.createCriteria().andServiceIdEqualTo(id).andStatusEqualTo(1);
		List<CommunityServiceRela> list = communityServiceRelaMapper.selectByExample(e1);
		CommunityExample ec = new CommunityExample();
		ec.createCriteria().andIdIn(list.stream().map(CommunityServiceRela::getCommunityId).distinct()
				.collect(Collectors.toList()));
		List<Community> listComm = communityMapper.selectByExample(ec);
		AreaExample ee = new AreaExample();
		ee.createCriteria().andIdIn(listComm.stream().map(Community::getCityId).distinct().collect(Collectors.toList()));
		List<Area> listArea = areaMapper.selectByExample(ee);

		Map<Integer, CityCommunityEntity> map = new HashMap<>();
		listComm.forEach(a -> {
			CityCommunityEntity entity = map.get(a.getCityId());
			if (entity == null) {
				entity = new CityCommunityEntity();
				entity.setId(a.getCityId());
				entity.getList().add(a);
			} else {
				entity.getList().add(a);
			}
			map.put(a.getCityId(), entity);
		});
		listArea.forEach(a -> {
			CityCommunityEntity entity = map.get(a.getId());
			if (entity == null) {
				entity = new CityCommunityEntity();
				entity.setId(a.getId());
				entity.setCityName(a.getName());
			} else {
				entity.setCityName(a.getName());
			}
			map.put(a.getId(), entity);
		});
		/*List<Integer> communityIds = list.stream().map(CommunityServiceRela::getCommunityId).distinct()
                .collect(Collectors.toList());
		if(communityIds != null && communityIds.size()>0){
            List<Map<String,String>> city = communityService.getCommunityAreaByCommunityIds(communityIds);

        }*/
        //查询服务分类
		/*CommunityServiceCategory category = communityServiceCategoryMapper.selectByPrimaryKey(info.getCategoryId());
		//查询服务二级分类
		CommunityServiceCategory categorySecond = communityServiceCategoryMapper
				.selectByPrimaryKey(detail.getCategorySecondType());
        json.put("category", category);
        json.put("categorySecond", categorySecond != null? categorySecond: new CommunityServiceCategory());*/
        //查询服务分类
        List<CommunityServiceCategory> communityServiceCategories = communityServiceCategoryService.getCommunityServiceCategoryByServiceId(info.getId());
        json.put("category", communityServiceCategories != null && communityServiceCategories.size()>0 ? communityServiceCategories.get(0) : new CommunityServiceCategory());
        json.put("categorySecond", communityServiceCategories != null && communityServiceCategories.size()>1 ? communityServiceCategories.get(1) : new CommunityServiceCategory());
		json.put("info", info);
		json.put("merchant", merchant != null ? merchant:new OpenMerchantInfo());
		json.put("detail", detail);
		json.put("store", store);
		json.put("city", map.values());
		json.put("invite", (invite == null || invite.isEmpty()) ? new OpenManagerInvite() : invite.get(0));
		return json;
	}

	public int updateServiceByCategorySecondType(int serviceId, int categorySecondType) {
		validator(communityServiceCategoryMapper.selectByPrimaryKey(categorySecondType) == null,
				"该分类不存在" + categorySecondType);
		OpenServiceDetail record = new OpenServiceDetail();
		record.setServiceId(serviceId);
		record.setCategorySecondType(categorySecondType);
		int i = openServiceDetailMapper.updateByPrimaryKeySelective(record);
		return i;
	}

	/*作废  2018-12-14 17:35:32   移动到openservice pay 上面去
	public int updateServiceByCommunityFee(int id, BigDecimal communityFee) {
		validator(communityFee.compareTo(BigDecimal.valueOf(0L)) < 0, "必须大于等于0");
		validator(communityFee.compareTo(BigDecimal.valueOf(100L)) >= 0, "必须小于100");
		CommunityService record = new CommunityService();
		record.setId(id);
		record.setCommissionRate(communityFee);
		int i = communityServiceMapper.updateByPrimaryKeySelective(record);
		CommunityServiceTemp record1 = new CommunityServiceTemp();
		record1.setId(id);
		record1.setCommissionRate(communityFee);
		i = communityServiceTempMapper.updateByPrimaryKeySelective(record1);
		return i;
	}*/

	public int updateServiceByCommunityFee(int id, BigDecimal communityFee) {
		validator(communityFee.compareTo(BigDecimal.valueOf(0L)) < 0, "必须大于等于0");
		validator(communityFee.compareTo(BigDecimal.valueOf(100L)) >= 0, "必须小于100");
		OpenServicePay data=new OpenServicePay();
		data.setServiceId(id);
		data.setCommunityRate(communityFee);
		return openServicePayService.updateOpenServicePay(data);
	}

	public int updateServiceByPremiumNum(int serviceId, int premiumNum) {
		validator(premiumNum <= 0, "必须大于等于0");
		OpenStoreServiceTemplete record = new OpenStoreServiceTemplete();
		record.setServiceId(serviceId);
		record.setPremiumNum(premiumNum);
		int i = openStoreServiceTempleteMapper.updateByPrimaryKeySelective(record);
		return i;
	}

	public int updateServiceByStatus(int id, Integer status) {
		CommunityServiceTemp temp = communityServiceTempMapper.selectByPrimaryKey(id);
		validator(temp == null, "服务不存在");
		validator(temp.getAuditStatus() != Constant.OpenAdmin.CommunityServiceAuditStatus.AUDIT_PASS_PAID
		&& temp.getAuditStatus() != Constant.OpenAdmin.CommunityServiceAuditStatus.AUDIT_PASS_UNPAID , "该服务未审核通过,不能上架");

		CommunityService record = new CommunityService();
		record.setId(id);
		record.setStatus(status);
		int i = communityServiceMapper.updateByPrimaryKeySelective(record);
		CommunityServiceTemp record1 = new CommunityServiceTemp();
		record1.setId(id);
		record1.setStatus(status);
		i = communityServiceTempMapper.updateByPrimaryKeySelective(record1);
		return i;
	}

	public PageList<Map<String, Object>> businessManagerAdminList(int category_second_type, String title,
			String merchant_title, int index, int size) {

		PageBounds pageBounds = new PageBounds(index, size, Order.formString("id.desc"));
		Map<String, Object> param = new HashMap<>();
		if (StringUtils.isNotBlank(title)) {
			param.put("service_title", "%" + title + "%");

		}
		if (StringUtils.isNotBlank(merchant_title)) {
			param.put("merchant_title","%" + merchant_title + "%");
		}
		if (category_second_type > 0) {
			param.put("category_second_type", category_second_type);
		}

		PageList<Map<String, Object>> pager = extCommunityServiceMapper.businessManagerAdminList(param, pageBounds);

		return pager;
	}
	
	
	public PageList<Map<String, Object>> businessManagerListByType(int category_id, String title,
			String merchant_title, int type, int index, int size) {

		PageBounds pageBounds = new PageBounds(index, size, Order.formString("id.desc"));
		Map<String, Object> param = new HashMap<>();
		param.put("type", type);
		if (StringUtils.isNotBlank(title)) {
			param.put("service_title", "%" + title + "%");

		}
		if (StringUtils.isNotBlank(merchant_title)) {
			param.put("merchant_title","%" + merchant_title + "%");
		}
		if (category_id > 0) {
			param.put("category_id", category_id);
		}

		PageList<Map<String, Object>> pager = extCommunityServiceMapper.businessManagerListByType(param, pageBounds);

		return pager;
	}

}
