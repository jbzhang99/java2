package com.rfchina.community.openweb.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.EmojiUtil;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.ValidatorUtil;
import com.rfchina.community.openweb.entity.AdminUserInfo;
import com.rfchina.community.openweb.service.CommunityServiceRelaService;
import com.rfchina.community.openweb.service.CommunityServiceService;
import com.rfchina.community.openweb.service.OpenServiceAreaService;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.mapper.OpenServiceDetailMapper;
import com.rfchina.community.persistence.mapper.OpenStoreServiceTempleteMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.CommunityServiceTemp;
import com.rfchina.community.persistence.model.OpenMerchantInfo;
import com.rfchina.community.persistence.model.OpenServiceDetail;
import com.rfchina.community.persistence.model.OpenStoreServiceTemplete;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENWEB)
public class XFSJCommunityServiceController extends BaseController {

	@Autowired
	private OpenServiceDetailMapper openServiceDetailMapper;
	@Autowired
	private CommunityServiceService communityServiceService;
	@Autowired
	private CommunityServiceRelaService communityServiceRelaService;
	@Autowired
	private OpenStoreServiceTempleteMapper openStoreServiceTempleteMapper;
	@Autowired
	private OpenServiceAreaService openServiceAreaService;
	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;
	
	// 修改基础服务
	@RequestMapping("/xfsj/modify_service_base")
	@Transactional
	public Result<?> modifyServiceBase(
			@RequestParam("service_id") int serviceId, 
			@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("sub_category_id") int subCategoryId,
			@RequestParam("community_ids") String communityIds,
			@RequestParam(value="phone", required=true) String phone
			) throws IllegalAccessException, InvocationTargetException {
		
		AdminUserInfo admin = getAdminInfo();
		validator(StringUtils.isBlank(title), "服务名称不能为空");
		title = EmojiUtil.replaceAll(title);
		validator(StringUtils.isBlank(title), "服务名称不能有表情");
		validator(StringUtils.isBlank(description), "服务描述不能为空");
		validator(subCategoryId <= 0, "服务分类不能为空");
		validator(StringUtils.isBlank(communityIds), "服务范围不能为空");
		ValidatorUtil.verify(phone, "商家联系电话", true, 1, 30);
		OpenMerchantInfo merchant = openMerchantInfoMapper.selectByPrimaryKey(admin.getUid());
		validator(merchant == null, "服务商不存在!不存在创建服务");
		
		CommunityServiceTemp communityServiceTemp = communityServiceService.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != admin.getUid(), "非法访问!");
		if (!communityServiceTemp.getTitle().equals(title)) {
			List<CommunityServiceTemp> list = communityServiceService.getCommunityServiceTemp(title);
			if (list != null && list.size() > 0) {
				error("服务名称：" + title + "，已存在");
			}
		}
		
		communityServiceTemp.setTitle(title);
		communityServiceTemp.setCategoryId(3);
		communityServiceTemp.setDescription(description);
		communityServiceTemp.setUpdateTime(new Date());
		communityServiceService.updateCommunityServiceTemp(communityServiceTemp);
		
		CommunityService service = new CommunityService();
		service.setId(serviceId);
		service.setTitle(title);
		service.setCategoryId(3);
		service.setDescription(description);
		service.setUpdateTime(new Date());
		communityServiceService.updateCommunityService(service);
		
		//更改分类
		OpenServiceDetail detail = new OpenServiceDetail();
		detail.setServiceId(serviceId);
		detail.setCategorySecondType(subCategoryId);
		openServiceDetailMapper.updateByPrimaryKeySelective(detail);
		
		//更改手机号码
		OpenStoreServiceTemplete osst = openStoreServiceTempleteMapper.selectByPrimaryKey(serviceId);
		if(osst != null) {
			osst.setPhone(phone);
		}
		openStoreServiceTempleteMapper.updateByPrimaryKeySelective(osst);
		
		// 删除原来的服务社区关系
		communityServiceRelaService.deleteCommunityServiceRelaTemp(serviceId);
		communityServiceRelaService.deleteCommunityServiceRela(serviceId);
		openServiceAreaService.deleteServiceArea(serviceId);
		// 保存服务范围信息
		communityServiceRelaService.saveByIds(communityIds, communityServiceTemp.getId(), merchant.getContactPerson(),
				merchant.getContactPhone(), merchant.getEmail(), Constant.OpenAdmin.CommunityServiceRelaAuditStatus.AUDIT_PASS,
				Constant.OpenAdmin.CommunityServiceRelaStatus.ENABLE);
		
		return Result.success();
	}
	
	/**
	 * @author:fukangwen @Description: 新增或保存店铺资料 @throws
	 */
	@RequestMapping(value = { "/xfsj/save_store_banner_url" })
	public Result<?> saveXFSJStoreBannerUrl(@RequestParam(value = "serviceId", required = true) int serviceId,
			@RequestParam(value = "bannerUrl", required = true) String bannerUrl) {
		validator(serviceId < 0, "参数有误");
		// 图片最多5张
		String[] urls = bannerUrl.split(",");
		validator(urls.length > 5, "图片最多上传5张");

		// 权限检查
		authorityCheck(serviceId);
		
		OpenStoreServiceTemplete templete = openStoreServiceTempleteMapper.selectByPrimaryKey(serviceId);
		templete.setBannerUrl(bannerUrl);
		openStoreServiceTempleteMapper.updateByPrimaryKey(templete);

		return Result.success();
	}
}
