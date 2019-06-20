package com.rfchina.community.openstore.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rfchina.community.base.OpenGoodGroupConstant;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.openstore.entity.UserGroupDetail;
import com.rfchina.community.openstore.entity.ext.ExtOpenStoreGroupData;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.service.UserInfoSerService;
import com.rfchina.community.service.openser.OpenStoreGroupDataSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OpenStoreGroupDataService extends BaseService {
	@Autowired
	private OpenStoreGroupDataMapper openStoreGroupDataMapper;
	@Autowired
	private OpenStoreOrderMapper openStoreOrderMapper;
	@Autowired
	private OpenStoreOrderVirturalMapper openStoreOrderVirturalMapper;
	@Autowired
	private OpenStoreGoodGroupInfoMapper openStoreGoodGroupInfoMapper;
	@Autowired
	private OpenStoreGoodStockDetailMapper openStoreGoodStockDetailMapper;
	@Autowired
	private OpenStoreGoodOrderRelService openStoreGoodOrderRelService;
	@Autowired
	private UserInfoSerService userInfoSerService;
	@Autowired
	private OpenStoreGoodMapper openStoreGoodMapper;
	@Autowired
	private OpenStoreGroupDataSerService openStoreGroupDataSerService;

	/**
	 * 团购活动有多少个团，根据状态筛选
	 * @param groupInfoId
	 * @param status
	 * @return
	 */
	public long getGroupDataCount(Long groupInfoId, int status) {
		OpenStoreGroupDataExample example = new OpenStoreGroupDataExample();
		example.createCriteria().andStatusEqualTo(status).andGoodGroupIdEqualTo(groupInfoId).andStopTimeGreaterThan(new Date());
		long l = openStoreGroupDataMapper.countByExample(example);
		return l;

	}

	/**
	 * 团购活动下团购列表
	 * @param groupInfoId
	 * @param status
	 * @param index
	 * @param size
	 * @return
	 */
	public PageInfo getOpenStoreGroupDataList(Long groupInfoId, Integer status, int index, int size) {
		OpenStoreGoodGroupInfo info = openStoreGoodGroupInfoMapper.selectByPrimaryKey(groupInfoId);
		validator(info == null, "团购活动不存在");
		PageHelper.startPage(index, size);
		OpenStoreGroupDataExample example = new OpenStoreGroupDataExample();
		example.createCriteria().andGoodGroupIdEqualTo(groupInfoId).andUsableNumGreaterThan(0)
				.andStatusEqualTo(status).andStopTimeGreaterThan(new Date());
		List<OpenStoreGroupData> list = openStoreGroupDataMapper.selectByExample(example);
		example.setOrderByClause("usable_num desc, id");
		PageInfo page = new PageInfo(list);
		List<ExtOpenStoreGroupData> returnList = new ArrayList<>();
		for(OpenStoreGroupData data : list){
			ExtOpenStoreGroupData extOpenStoreGroupData = new ExtOpenStoreGroupData();
			extOpenStoreGroupData.setId(data.getId());
			extOpenStoreGroupData.setUserName(data.getNickName());
			extOpenStoreGroupData.setPicUrl(data.getPicUrl());
			extOpenStoreGroupData.setStopTime(data.getStopTime());
			extOpenStoreGroupData.setUsableNum(data.getUsableNum());
			extOpenStoreGroupData.setGroupPrice(info.getGroupPrice());
			extOpenStoreGroupData.setEndTime(data.getEndTime());
			returnList.add(extOpenStoreGroupData);
		}
		page.setList(returnList);
		list.clear();
		return page;
	}

	public Map<String, Object> groupDataDetailList(long id, long uid) {
		Map<String, Object> map = new HashMap<String, Object>();

		OpenStoreGroupData data = openStoreGroupDataMapper.selectByPrimaryKey(id);
		validator(data == null, "团数据不存在");
		//计算倒计时
		map.put("groupData", data);

		OpenStoreGoodGroupInfo info = openStoreGoodGroupInfoMapper.selectByPrimaryKey(data.getGoodGroupId());
		map.put("groupInfo", info);

		OpenStoreGood openStoreGood = openStoreGoodMapper.selectByPrimaryKey(info.getGoodId());
		if(openStoreGood != null) {
			String[] urls = openStoreGood.getPicUrl().split(",");
			openStoreGood.setPicUrl(urls[0]);
			map.put("goodInfo", openStoreGood);
		}
			//真实订单
		OpenStoreOrderExample example = new OpenStoreOrderExample();
		example.createCriteria().andGroupDataIdEqualTo(id).andPayStatusEqualTo(1);
		List<OpenStoreOrder> list = openStoreOrderMapper.selectByExample(example);
		List<UserGroupDetail> returnList = new ArrayList<>();
		for(OpenStoreOrder order : list){
			UserGroupDetail detail = new UserGroupDetail();
			detail.setPayTime(order.getPayTime());
			UserInfo user = userInfoSerService.getUserInfo(order.getUserId());
			if(user != null){
				detail.setUserName(user.getNickname());
				detail.setPicUrl(user.getPic());
				if(user.getId().intValue() == data.getUid().intValue()){
					detail.setGroupMasterStatus(OpenGoodGroupConstant.groupMasterStatus.yes);
				}
				if(user.getId().longValue() == uid){
					detail.setMeStatus(OpenGoodGroupConstant.meStatus.yes);
				}
			}
			returnList.add(detail);
		}

		//虚拟订单
		if(OpenGoodGroupConstant.dataType.system.equals(data.getType())){
			OpenStoreOrderVirturalExample vExample = new OpenStoreOrderVirturalExample();
			vExample.createCriteria().andGroupDataIdEqualTo(data.getId());
			List<OpenStoreOrderVirtural> virturalList = openStoreOrderVirturalMapper.selectByExample(vExample);

			for(OpenStoreOrderVirtural vOrder : virturalList){
				UserGroupDetail detail = new UserGroupDetail();
				detail.setUserName(vOrder.getNickName());
				detail.setPayTime(vOrder.getCreateTime());
				detail.setPicUrl(vOrder.getPicUrl());
				detail.setGroupMasterStatus(OpenGoodGroupConstant.groupMasterStatus.no);
				returnList.add(detail);
			}
		}

		map.put("list", returnList);
		return map;
	}

	/**
	 * 新增修改
	 */
	public void insertOrUpdate(OpenStoreOrder order) {
		if(order.getGroupDataId() != null && order.getGroupDataId() > 0){
			OpenStoreGoodStockDetailExample example = new OpenStoreGoodStockDetailExample();
			example.createCriteria().andTargetIdEqualTo(order.getId())
					.andTypeEqualTo(OpenGoodGroupConstant.stockType.groupdata)
					.andGroupDataIdEqualTo(order.getGroupDataId());
			List<OpenStoreGoodStockDetail> stockDetailList = openStoreGoodStockDetailMapper.selectByExample(example);

			if(!stockDetailList.isEmpty()) {
				OpenStoreGoodStockDetail detail = stockDetailList.get(0);
				OpenStoreGroupData data = openStoreGroupDataMapper.selectByPrimaryKey(order.getGroupDataId());
				data.setSuccessNum(data.getSuccessNum() + detail.getAmount());
				data.setLockNum(data.getLockNum() - detail.getAmount());
				data.setUsableNum(data.getPeopleNum()-data.getSuccessNum());
				if(data.getUsableNum() == 0){
					data.setStatus(OpenGoodGroupConstant.dataStatus.success);
					data.setType(OpenGoodGroupConstant.dataType.user);
					data.setSuccessTime(new Date());
					//发送短信
					openStoreGroupDataSerService.sendMessageByGroupDataId(data.getId());
				}
				openStoreGroupDataMapper.updateByPrimaryKey(data);
			}
		}else{
			OpenStoreGoodGroupInfo info = openStoreGoodGroupInfoMapper.selectByPrimaryKey(order.getGroupInfoId());
			OpenStoreGroupData data = new OpenStoreGroupData();
			int successNum = 1;
			data.setLockNum(0);
			data.setSuccessNum(openStoreGoodOrderRelService.getAmount(order.getId(), info.getGoodId())); //下单数量，去关联表查
			data.setPeopleNum(info.getPeopleNum());
			data.setUsableNum(info.getPeopleNum() - successNum);
			data.setCreateTime(new Date());
			data.setGoodGroupId(order.getGroupInfoId());
			data.setUid(order.getUserId());
			data.setServiceId(order.getServiceId());
			data.setStatus(OpenGoodGroupConstant.dataStatus.un_success);
			data.setStartType(OpenGoodGroupConstant.dataType.user);
			data.setStopTime(DateTimeUtils.addHours(data.getCreateTime(), info.getVirturalSuccessHour()));
			int endDate = 1;
			if(info.getVirturalSuccessHour()>24){
				endDate = info.getVirturalSuccessHour()%24>0?info.getVirturalSuccessHour()/24+1:info.getVirturalSuccessHour()/24;
			}
            data.setEndTime(DateTimeUtils.addDay(data.getCreateTime(),endDate));
			//开团者信息
			UserInfo user = userInfoSerService.getUserInfo(order.getUserId());
			data.setGoodId(info.getGoodId());
			data.setNickName(user.getNickname());
			data.setPhone(user.getPhone());
			data.setPicUrl(user.getPic());

			openStoreGroupDataMapper.insertSelective(data);

			//openOrder
			order.setGroupDataId(data.getId());
			openStoreOrderMapper.updateByPrimaryKeySelective(order);
		}

	}

	public int getGroupDataStatus(Long groupDataId) {
		if(groupDataId <= 0){
			return OpenGoodGroupConstant.dataStatus.un_success;
		}
		OpenStoreGroupData data = openStoreGroupDataMapper.selectByPrimaryKey(groupDataId);
		if(data != null){
			return data.getStatus();
		}
		return OpenGoodGroupConstant.dataStatus.un_success;
	}
}
