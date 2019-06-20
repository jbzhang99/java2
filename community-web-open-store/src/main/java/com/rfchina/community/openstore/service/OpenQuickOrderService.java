package com.rfchina.community.openstore.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rfchina.community.openstore.mapper.ext.ExtOpenQuickOrderMapper;
import com.rfchina.community.persistence.mapper.OpenStoreServiceTempleteMapper;
import com.rfchina.community.persistence.mapper.open.OpenQuickOrderGlobalSqlProvider;
import com.rfchina.community.persistence.model.OpenStoreServiceTemplete;
import com.rfchina.community.persistence.model.UserInfo;
import com.rfchina.community.persistence.model.ext.ExtOpenQuickOrder;
import com.rfchina.community.service.BaseService;
import com.rfchina.community.service.UserInfoSerService;

@Service
public class OpenQuickOrderService extends BaseService {
 
	@Autowired
	private ExtOpenQuickOrderMapper extOpenQuickOrderMapper;
	@Autowired
	private UserInfoSerService userInfoSerService;
	@Autowired
	private OpenStoreServiceTempleteMapper openStoreServiceTempleteMapper;

	public PageInfo<ExtOpenQuickOrder> listQuickOrder(Map<String, Object> example, int page, int limit,
			boolean phoneHide) { 

		String phone = MapUtils.getString(example, "phone");
		if (StringUtils.isNotBlank(phone)) {
			example.put("uid", userInfoSerService.userInfoByPhone(phone));
		}
		PageHelper.startPage(page, limit);
		List<ExtOpenQuickOrder> pager = extOpenQuickOrderMapper.pageByExample(example);
		PageInfo pageInfo = new PageInfo(pager);
		for (ExtOpenQuickOrder order : pager) {
			Long uid = order.getUid();
			UserInfo userinfo = userInfoSerService.getUserInfo(uid);

			if (userinfo != null) {
				String phone1 = userinfo.getPhone();
				if (phoneHide) {
					phone1 = phone1.substring(0, 3) + "****" + phone1.substring(7);
				}
				order.setPhone(phone1);
			}

		}
		return pageInfo;
	}

	public ExtOpenQuickOrder getQuickOrder(Long id, int serviceId, Long uid) {
		PageHelper.startPage(1, 1);
		Map<String, Object> example = new HashMap<>();
		example.put("id", id);
		example.put("service_id", serviceId);
		example.put("uid", uid);
		logger.info("example:{}",JSON.toJSONString(example));
		List<ExtOpenQuickOrder> pager = extOpenQuickOrderMapper.pageByExample(example);
		for (ExtOpenQuickOrder order : pager) {
			uid = order.getUid();
			UserInfo userinfo = userInfoSerService.getUserInfo(uid);
			if (userinfo != null) {
				order.setPhone(userinfo.getPhone());
			}
			OpenStoreServiceTemplete templete = openStoreServiceTempleteMapper
					.selectByPrimaryKey(order.getServiceId());
			order.setStorePhone(templete == null ? "" : templete.getPhone());

		}
		if (pager.isEmpty())
			return new ExtOpenQuickOrder();
		return pager.get(0);
	}

}
