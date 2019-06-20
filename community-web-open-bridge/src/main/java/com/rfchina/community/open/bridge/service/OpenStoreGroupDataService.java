package com.rfchina.community.open.bridge.service;

import com.rfchina.community.base.OpenGoodGroupConstant;
import com.rfchina.community.open.bridge.entity.ExtOpenStoreGroupData;
import com.rfchina.community.open.bridge.entity.SimOpenStoreOrder;
import com.rfchina.community.open.bridge.mapper.ext.ExtOpenStoreGroupDataMapper;
import com.rfchina.community.persistence.mapper.OpenStoreGroupDataMapper;
import com.rfchina.community.persistence.mapper.OpenStoreOrderMapper;
import com.rfchina.community.persistence.mapper.OpenStoreOrderVirturalMapper;
import com.rfchina.community.persistence.mapper.UserInfoMapper;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.service.UserInfoSerService;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OpenStoreGroupDataService extends BaseService {
	@Autowired
	private OpenStoreGroupDataMapper openStoreGroupDataMapper;
	@Autowired
	private ExtOpenStoreGroupDataMapper extOpenStoreGroupDataMapper;
	@Autowired
	private OpenStoreOrderMapper openStoreOrderMapper;
	@Autowired
	private OpenStoreOrderVirturalMapper openStoreOrderVirturalMapper;
	@Autowired
	private UserInfoSerService userInfoSerService;
	/**
	 * 查看团订单详情
	 */
	public List<SimOpenStoreOrder> groupDataDetailList(long id){
		OpenStoreGroupData data = openStoreGroupDataMapper.selectByPrimaryKey(id);
		validator(data == null, "团数据不存在");

		//真实订单
		OpenStoreOrderExample example = new OpenStoreOrderExample();
		example.createCriteria().andGroupDataIdEqualTo(id).andPayStatusEqualTo(1);
		List<OpenStoreOrder> list = openStoreOrderMapper.selectByExample(example);

		List<SimOpenStoreOrder> returnList = new ArrayList<SimOpenStoreOrder>();
		for(OpenStoreOrder order : list){
			SimOpenStoreOrder simOrder = new SimOpenStoreOrder();
			BeanUtils.copyProperties(order, simOrder);
			simOrder.setType(OpenGoodGroupConstant.dataOrderType.user);
			UserInfo user = userInfoSerService.getUserInfo(order.getUserId());
			if(user != null){
				simOrder.setUserName(user.getNickname());
				simOrder.setPhone(user.getPhone());
			}
			returnList.add(simOrder);
		}

		//虚拟订单
		if(OpenGoodGroupConstant.dataType.system.equals(data.getType())){
			OpenStoreOrderVirturalExample vExample = new OpenStoreOrderVirturalExample();
			vExample.createCriteria().andGroupDataIdEqualTo(data.getId());
			List<OpenStoreOrderVirtural> virturalList = openStoreOrderVirturalMapper.selectByExample(vExample);

			for(OpenStoreOrderVirtural vOrder : virturalList){
				SimOpenStoreOrder simOrder = new SimOpenStoreOrder();
				simOrder.setOutTradeNo(vOrder.getOutTradeNo());
				simOrder.setUserName(vOrder.getNickName());
				simOrder.setType(OpenGoodGroupConstant.dataOrderType.system);
				returnList.add(simOrder);
			}
		}
		return returnList;
	}


	/**
	 * 列表搜索
	 */
	public PageList<ExtOpenStoreGroupData> pageByParam(Long groupInfoId, Long id, String goodName,
													   String serviceName, String phone, Date startDate, Date endDate, Date startSuccessDate, Date endSuccessDate,
													   Integer status, int index, int size){
		Map<String, Object> param = new HashMap<>();
		if(groupInfoId != null){
			param.put("groupInfoId", groupInfoId);
		}
		if(id != null){
			param.put("id", id);
		}
		if(StringUtils.isNotBlank(goodName)){
			param.put("goodName", "%" + goodName + "%");
		}
		if(StringUtils.isNotBlank(serviceName)){
			param.put("serviceName", "%" + serviceName + "%");
		}
		if(StringUtils.isNotBlank(phone)){
			param.put("phone", "%" + phone + "%");
		}
		if(startDate != null && endDate != null){
			param.put("startDate", startDate);
			param.put("endDate", endDate);
		}
		if(startSuccessDate != null && endSuccessDate != null){
			param.put("startSuccessDate", startSuccessDate);
			param.put("endSuccessDate", endSuccessDate);
		}
		if(status != null){
			param.put("status", status);
		}

		PageBounds pageBounds = new PageBounds(index, size);

		return extOpenStoreGroupDataMapper.pageByCondition(param, pageBounds);
	}

	public long countByGoupInfoId(long groupInfoId){
		OpenStoreGroupDataExample example = new OpenStoreGroupDataExample();
		example.createCriteria().andGoodGroupIdEqualTo(groupInfoId);
		return openStoreGroupDataMapper.countByExample(example);
	}

}
