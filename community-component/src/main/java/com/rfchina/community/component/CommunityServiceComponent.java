package com.rfchina.community.component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.rfchina.community.persistence.mapper.OpenServicePayMapper;
import com.rfchina.community.persistence.model.OpenServicePay;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.Order;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.entity.communityService.ExtCommunityServiceTemp;
import com.rfchina.community.persistence.mapper.CommunityServiceCategoryMapper;
import com.rfchina.community.persistence.mapper.OpenServiceDetailMapper;
import com.rfchina.community.persistence.mapper.OpenTempletInfoMapper;
import com.rfchina.community.persistence.mapper.ext.ExtCommunityServiceTempMapper;
import com.rfchina.community.persistence.model.CommunityServiceCategory;
import com.rfchina.community.persistence.model.OpenServiceDetail;
import com.rfchina.community.persistence.model.OpenTempletInfo;

public class CommunityServiceComponent {

	@Autowired
	private ExtCommunityServiceTempMapper extCommunityServiceTempMapper;

	@Autowired
	private OpenServiceDetailMapper openServiceDetailMapper;
	@Autowired
	private OpenServicePayMapper openServicePayMapper;
	@Autowired
	private OpenTempletInfoMapper openTempletInfoMapper;
	@Autowired
	private CommunityServiceCategoryMapper communityServiceCategoryMapper;

	public PageList<ExtCommunityServiceTemp> getCommunityServiceTempList(int id, String title, String merchantName,
			int merchantId, int categoryId, int status, Date startCreateTime, Date endCreateTime, int index, int size) {

		Map<String, Object> param = new HashMap<>();

		if (id > 0) {
			param.put("id", id);
		}

		if (StringUtils.isNotBlank(title)) {
			param.put("title", title);
		}

		if (StringUtils.isNotBlank(merchantName)) {
			param.put("merchantName", merchantName);
		}

		if (merchantId > 0) {
			param.put("merchantId", merchantId);
		}

		if (categoryId > 0) {
			param.put("categoryId", categoryId);
		}

		if (status > 0) {
			param.put("status", status);
		}

		if (startCreateTime != null) {
			param.put("startCreateTime", startCreateTime);
		}

		if (endCreateTime != null) {
			param.put("endCreateTime", endCreateTime);
		}

		PageBounds pageBounds = new PageBounds(index, size, Order.formString("create_time.desc"));

		PageList<ExtCommunityServiceTemp> pager = extCommunityServiceTempMapper.getCommunityServiceTemp(param,
				pageBounds);
		for (ExtCommunityServiceTemp extCommunityServiceTemp : pager) {

			OpenServiceDetail detail = openServiceDetailMapper.selectByPrimaryKey(extCommunityServiceTemp.getId());
			OpenTempletInfo openTempletInfo = null;
			if (detail == null) {
				detail = new OpenServiceDetail();
				detail.setDevelopType(OpenConstant.open_service_detail.develop_type.SELF.name());
				detail.setServiceId(extCommunityServiceTemp.getId());
				detail.setTempleteStatus(0);
				detail.setTempleteName("");
			}else {
				openTempletInfo = openTempletInfoMapper.selectByPrimaryKey(detail.getTempleteName());
			}
			JSONObject jsonObj = (JSONObject) JSON.toJSON(detail);


			//获得社区服务
			OpenServicePay pay = openServicePayMapper.selectByPrimaryKey(extCommunityServiceTemp.getId());
			if(pay!=null) {
				extCommunityServiceTemp.setCommunityRate(pay.getCommunityRate());
			}

			jsonObj.put("templeteLabel",
					openTempletInfo == null ? "" : openTempletInfo.getTitle());

			extCommunityServiceTemp.setOpenServiceDetail(jsonObj);
			extCommunityServiceTemp.setSubCategoryId(detail.getCategorySecondType());
			if(detail.getCategorySecondType() != null && detail.getCategorySecondType() > 0) {
				CommunityServiceCategory category = communityServiceCategoryMapper.selectByPrimaryKey(detail.getCategorySecondType());
				extCommunityServiceTemp.setSubCategoryName(category == null ? "" : category.getName());
			}
			// extCommunityServiceTemp.setDevelopType(developType);
		}
		return pager;
	}
}
