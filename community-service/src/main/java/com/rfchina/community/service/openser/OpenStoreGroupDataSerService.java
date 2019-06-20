package com.rfchina.community.service.openser;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenGoodGroupConstant;
import com.rfchina.community.base.util.RadomPhoneNumberUtils;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.mapper.ext.ExtOpenStoreGroupDataPerMapper;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.service.BaseService;
import com.rfchina.community.service.SmsGlobalService;
import com.rfchina.community.service.UserInfoSerService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OpenStoreGroupDataSerService extends BaseService {
	@Autowired
	private OpenStoreGroupDataMapper openStoreGroupDataMapper;
	@Autowired
	private OpenStoreGoodGroupInfoMapper openStoreGoodGroupInfoMapper;
	@Autowired
	private ExtOpenStoreGroupDataPerMapper extOpenStoreGroupDataPerMapper;
	@Autowired
	private OpenStoreGoodStockDetailService openStoreGoodStockDetailService;
	@Autowired
	private OpenStoreOrderVirturalMapper openStoreOrderVirturalMapper;
	@Autowired
	private OpenStoreOrderMapper openStoreOrderMapper;
	@Autowired
	private UserDefaultHeadImgMapper userDefaultHeadImgMapper;
	@Autowired
	private SmsGlobalService smsGlobalService;
	@Autowired
	private UserInfoSerService userInfoSerService;
	@Autowired
	private OpenStoreGoodMapper openStoreGoodMapper;
	public static int limit = 20;

	public static String prefix = "Virtural_";
	/**
	 * @author:fukangwen
	 * @Description: 更新库存量（增加，减少）
	 * @return void
	 * @throws
	 */
	public void lockGroupDataUsableNum(int goodId, Long groupInfoId, Long groupDataId, int decNum, Integer orderId) {
		long now = System.currentTimeMillis();
		OpenStoreGroupData groupData = openStoreGroupDataMapper.selectByPrimaryKey(groupDataId);
		validator(groupData == null, "团购数据不存在");
		validator(groupData.getUsableNum() < decNum, "来慢一步！您当前参与的团已经人满成团了，您可以重新选择新的团加入或者发起团~");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("oldStock", groupData.getUsableNum());
		param.put("decNum", decNum);
		param.put("groupDataId", groupDataId);

		int row = extOpenStoreGroupDataPerMapper.lockGroupDataUsableNum(param);

		validator(row <= 0, "来慢一步！您当前参与的团已经人满成团了，您可以重新选择新的团加入或者发起团~");

		//插入记录
		openStoreGoodStockDetailService.insertGroupDataStockDetail(goodId,groupInfoId, groupDataId,(int)param.get("oldStock"),
				groupData.getUsableNum(), decNum, OpenGoodGroupConstant.stockType.groupdata, OpenConstant.StockOperate.DEC.toString(),
				OpenConstant.StockSource.CLIENT.toString(), orderId);

		logger.info("单个改变团数据可用名额的时间：商品信息={},耗时：{}", System.currentTimeMillis() - now);
	}

	/**
	 * 虚拟拼团
	 */
	public void virtualJoinInGroupPay() {
		//1获取拼团未成功，且stop_time < 当前时间，并且锁定中的人数为0的数据， 一次选择20个
		List<OpenStoreGroupData> list = extOpenStoreGroupDataPerMapper.selectUnSuccessList(limit);

		//2根据锁定数据，获取需要虚拟拼团的人数
		if(list.isEmpty()){
			logger.info("没有需要虚拟拼团的数据");
		}
		for(OpenStoreGroupData data : list){
			//3.虚拟成团
			int amount = generalVirtualOrder(data);
			//4.更新拼团数据
			data.setUsableNum(0);
			data.setSuccessNum(data.getSuccessNum() + amount);
			data.setStatus(OpenGoodGroupConstant.dataStatus.success);
			data.setSuccessTime(new Date());
			data.setType(OpenGoodGroupConstant.dataType.system);
			openStoreGroupDataMapper.updateByPrimaryKeySelective(data);
			//5.发送短信
			sendMessageByGroupDataId(data.getId());
		}

	}

	/**
	 * 生成虚拟订单
	 * @param data
	 */
	private int generalVirtualOrder(OpenStoreGroupData data) {
		int amount = data.getUsableNum();

		//生成amount 数量的虚拟订单
		Date now = new Date();
		for(int i = 0; i < amount; i++){
			OpenStoreOrderVirtural virtural = new OpenStoreOrderVirtural();
			Double seconds = Math.random()*3600;
			virtural.setCreateTime(DateUtils.addSeconds(now,seconds.intValue()));
			virtural.setGroupDataId(data.getId());
			// 生成数据
			virtural.setNickName(RadomPhoneNumberUtils.getRamNum());
			String outTradeNo = String.format("%s%d%s",prefix, System.nanoTime(),
					RandomStringUtils.randomNumeric(10));
			virtural.setOutTradeNo(outTradeNo);
			virtural.setPicUrl(this.getDefaultHeadImgRandom());
			openStoreOrderVirturalMapper.insertSelective(virtural);
		}
		return amount;
	}


	/**
	 * 随机获取一个系统默认头像
	 *
	 * @return
	 */
	public String getDefaultHeadImgRandom() {
		String defaultHeadImg = "";
		UserDefaultHeadImgExample userDefaultHeadImgExample = new UserDefaultHeadImgExample();
		List<UserDefaultHeadImg> list = userDefaultHeadImgMapper.selectByExample(userDefaultHeadImgExample);
		if (CollectionUtils.isNotEmpty(list)) {
			Collections.shuffle(list);
			defaultHeadImg = list.get(0).getUserHeadImgUrl();
		}
		return defaultHeadImg;
	}

	/**
	 * 发送短信
	 */
	public void sendMessageByGroupDataId(Long groupDataId){
		OpenStoreOrderExample example = new OpenStoreOrderExample();
		example.createCriteria().andPayStatusEqualTo(1).andGroupDataIdEqualTo(groupDataId);
		List<OpenStoreOrder> list = openStoreOrderMapper.selectByExample(example);
		logger.info("发送拼团成功短信:groupDataId:{}",groupDataId);
		for(OpenStoreOrder order : list){
			UserInfo user = userInfoSerService.getUserInfo(order.getUserId());
			if(user == null){
				logger.warn("用户不存在,userId:{}",order.getUserId());
				continue;
			}

			OpenStoreGoodGroupInfo info = openStoreGoodGroupInfoMapper.selectByPrimaryKey(order.getGroupInfoId());
			if(info == null){
				logger.warn("拼团活动不存在,GroupInfoId:{}",order.getGroupInfoId());
				continue;
			}

			OpenStoreGood good = openStoreGoodMapper.selectByPrimaryKey(info.getGoodId());
			if(good == null){
				logger.warn("商品不存在,goodId:{}",info.getGoodId());
				continue;
			}
			//组装信息发送
			smsGlobalService.sendSms(user.getPhone(), SmsGlobalService.SmsType.group_complete_success,
					good.getName(), order.getServiceId(), order.getCommunityId());

		}
	}

	public OpenStoreGroupData findById(Long groupDataId) {
		return openStoreGroupDataMapper.selectByPrimaryKey(groupDataId);
	}
}
