package com.rfchina.community.openstore.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenXFSJConstant;
import com.rfchina.community.base.OpenXFSJConstant.Type;
import com.rfchina.community.openstore.entity.ext.ExtOpenStoreGood;
import com.rfchina.community.openstore.entity.ext.ExtXFSJGood;
import com.rfchina.community.openstore.entity.ext.ExtXFSJInfo;
import com.rfchina.community.openstore.entity.ext.ExtXFSJShop;
import com.rfchina.community.openstore.mapper.ext.ExtOpenXFSJStoreMapper;
import com.rfchina.community.persistence.mapper.OpenServiceDetailTabMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJAreaConfigMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJGroupConfigMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJInfoDetailMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJInfoMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJStoreGoodMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJStoreMapper;
import com.rfchina.community.persistence.mapper.OpenXfsjSignUpInfoMapper;
import com.rfchina.community.persistence.model.Community;
import com.rfchina.community.persistence.model.OpenServiceDetailTabExample;
import com.rfchina.community.persistence.model.OpenServiceDetailTabKey;
import com.rfchina.community.persistence.model.OpenStoreOrder;
import com.rfchina.community.persistence.model.OpenXFSJAreaConfig;
import com.rfchina.community.persistence.model.OpenXFSJGroupConfig;
import com.rfchina.community.persistence.model.OpenXFSJInfo;
import com.rfchina.community.persistence.model.OpenXFSJInfoDetail;
import com.rfchina.community.persistence.model.OpenXFSJInfoExample;
import com.rfchina.community.persistence.model.OpenXFSJStore;
import com.rfchina.community.persistence.model.OpenXFSJStoreExample;
import com.rfchina.community.persistence.model.OpenXFSJStoreGood;
import com.rfchina.community.persistence.model.OpenXFSJStoreGoodExample;
import com.rfchina.community.persistence.model.OpenXFSJStoreKey;
import com.rfchina.community.persistence.model.OpenXfsjSignUpInfo;
import com.rfchina.community.persistence.model.OpenXfsjSignUpInfoExample;
/**
 * @author:fukangwen
 * @Description: 小富市集service
 */
@Service
public class OpenXFSJService extends BaseService{

	@Autowired
	private OpenXFSJInfoMapper openXFSJInfoMapper;
	@Autowired
	private OpenXFSJInfoDetailMapper openXFSJInfoDetailMapper;
	@Autowired
	private OpenXFSJStoreGoodMapper openXFSJStoreGoodMapper;
	@Autowired
	private OpenStoreServiceTempleteService openStoreServiceTempleteService;
	@Autowired
	private OpenStoreGoodService openStoreGoodService;
	@Autowired
	private ExtOpenXFSJStoreMapper extOpenXFSJStoreMapper;
	@Autowired
	private OpenXFSJStoreMapper openXFSJStoreMapper;
	@Autowired
	private OpenXFSJGroupConfigMapper openXFSJGroupConfigMapper;
	@Autowired
	private OpenXFSJAreaConfigMapper openXFSJAreaConfigMapper;
	@Autowired
	private CommunityService communityService;
	@Autowired
	private OpenXfsjSignUpInfoMapper openXfsjSignUpInfoMapper;
	@Autowired
	private OpenServiceDetailTabMapper openServiceDetailTabMapper;
	
	
	/**
	 * @author:fukangwen
	 * @Description: 根据社区，选取该社区启用的小富市集活动详情
	 * @throws
	 */
	public ExtXFSJInfo getExtXFSJInfo(int communityId) {
		List<OpenXFSJInfo> list = this.getValidOpenXFSJInfo(communityId);
		validator(list.isEmpty() , "市集活动不存在");
		validator(list.size() > 1 , "市集活动数据有误");
		
		//市集基本信息
		ExtXFSJInfo extXFSJInfo = new ExtXFSJInfo();
		BeanUtils.copyProperties(list.get(0), extXFSJInfo);
		OpenXFSJInfoDetail detail = openXFSJInfoDetailMapper.selectByPrimaryKey(extXFSJInfo.getId());
		extXFSJInfo.setDetail(detail ==  null ? "" : detail.getDetail());
		
		//生活馆信息
		extXFSJInfo.setLifeShopList(this.getXFSJShopInfoList(extXFSJInfo.getId(), Type.SHOP_LIFE));
		
		//优选馆信息
		extXFSJInfo.setBetterShopList(this.getXFSJShopInfoList(extXFSJInfo.getId(), Type.SHOP_BETTER));
		
		//主题配置名称
		extXFSJInfo.setGroupAreaName(getGroupAreaNameByIds(list.get(0).getGroupConfigId(), list.get(0).getAreaConfigId()));
		
		return extXFSJInfo;
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 获取集团地区配置
	 * @return String
	 * @throws
	 */
	private String getGroupAreaNameByIds(Long groupConfigId, Long areaConfigId) {
		if(groupConfigId == null || areaConfigId == null)
			return null;
		OpenXFSJGroupConfig groupConfig = openXFSJGroupConfigMapper.selectByPrimaryKey(groupConfigId);
		OpenXFSJAreaConfig areaConfig = openXFSJAreaConfigMapper.selectByPrimaryKey(areaConfigId);
		if(groupConfig == null || areaConfig == null)
			return null;
		return groupConfig.getName() + " / " + areaConfig.getName();
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 
	 * @return List<ExtXFSJShop>
	 * @throws
	 */
	private List<ExtXFSJShop> getXFSJShopInfoList(Long xfsjId, int type) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("xfsjId", xfsjId);
		param.put("type", type);
		List<Integer> storeIdList = extOpenXFSJStoreMapper.getStoreIdList(param);
		return this.getExtXFSJShopList(storeIdList, xfsjId, type);
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 活动详情
	 * @return
	 * @throws
	 */
	private List<ExtXFSJShop> getPlatformActivityStoreList(Long xfsjId, int type) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("xfsjId", xfsjId);
		param.put("type", type);
		List<Integer> storeIdList = extOpenXFSJStoreMapper.getPlatformActivityStoreIdList(param);
		return this.getExtXFSJShopList(storeIdList, xfsjId, type);
	}
	
	private List<ExtXFSJShop> getExtXFSJShopList(List<Integer> storeIdList, Long xfsjId, int type){
		
		List<ExtXFSJShop> extList = new ArrayList<ExtXFSJShop>();
		if(storeIdList.isEmpty())
			return extList;
		
		for(Integer storeId : storeIdList) {
			ExtXFSJShop shop = new ExtXFSJShop();
			
			OpenXFSJStoreKey key = new OpenXFSJStoreKey();
			key.setStoreId(storeId);
			key.setXfsjId(xfsjId);
			OpenXFSJStore xfsjStore = openXFSJStoreMapper.selectByPrimaryKey(key);
			BeanUtils.copyProperties(xfsjStore, shop);
			
			// 获取商铺信息
			shop.setTempletInfo(openStoreServiceTempleteService.getTempleteInfo(storeId));
			shop.setGoodList(this.getXFSJGoodInfoList(storeId, type, xfsjId));
			extList.add(shop);
		}
		
		return extList;
	}

	
	private List<ExtXFSJGood> getXFSJGoodInfoList(int storeId, int type, long xfsjId) {
		OpenXFSJStoreGoodExample example = new OpenXFSJStoreGoodExample();
		example.createCriteria().andStoreIdEqualTo(storeId).andTypeEqualTo(type).andXfsjIdEqualTo(xfsjId);
		
		example.setOrderByClause("orderby desc");
		List<OpenXFSJStoreGood> list = openXFSJStoreGoodMapper.selectByExample(example);
		List<ExtXFSJGood> extList = new ArrayList<ExtXFSJGood>();
		if(list.isEmpty())
			return extList;
		
		for(OpenXFSJStoreGood good : list) {
			ExtXFSJGood extGood = new ExtXFSJGood();
			BeanUtils.copyProperties(good, extGood);
			//未上架返回null，不加进去
			ExtOpenStoreGood goodDetail = openStoreGoodService.getSimpleGoodDetail(good.getGoodId());
			if(goodDetail == null)
				continue;
			extGood.setGoodInfo(goodDetail);
			extList.add(extGood);
			
			//只显示5个
			if(extList.size() >= 5)
				break;
		}
		return extList;
	}

	/**
	 * @author:fukangwen
	 * @Description: 获取可用的小富市集活动
	 * @return OpenXFSJInfo
	 * @throws
	 */
	public List<OpenXFSJInfo> getValidOpenXFSJInfo(int communityId) {
		OpenXFSJInfoExample example = new OpenXFSJInfoExample();
		example.createCriteria()
			.andStatusEqualTo(OpenXFSJConstant.Status.ACT_STATUS_VALID)
			.andCommunityIdEqualTo(communityId).andTypeEqualTo(OpenXFSJConstant.ActivityType.community);
		List<OpenXFSJInfo> list = openXFSJInfoMapper.selectByExample(example);
		return list;
		
	}

	public ExtXFSJInfo getPlatformActivityInfo(long xfsjId) {
		OpenXFSJInfo info = openXFSJInfoMapper.selectByPrimaryKey(xfsjId);
		
		//市集基本信息
		ExtXFSJInfo extXFSJInfo = new ExtXFSJInfo();
		BeanUtils.copyProperties(info, extXFSJInfo);
		OpenXFSJInfoDetail detail = openXFSJInfoDetailMapper.selectByPrimaryKey(extXFSJInfo.getId());
		extXFSJInfo.setDetail(detail ==  null ? "" : detail.getDetail());
		//社区名称
		Community community = communityService.getCommunity(info.getCommunityId());
		extXFSJInfo.setCommunityName(community == null ? "" : community.getName());
		//优选馆信息
		extXFSJInfo.setBetterShopList(this.getPlatformActivityStoreList(extXFSJInfo.getId(), Type.SHOP_BETTER));
		
		return extXFSJInfo;
	}

	/**
	 * @author:fukangwen
	 * @Description: 
	 * @return void
	 * @throws
	 */
	public void completeTypeInfo(OpenStoreOrder openStoreOrder) {
		int serviceId = openStoreOrder.getServiceId();
		//默认是商城模板
		openStoreOrder.setType(OpenConstant.OpenStoreOrderType.templete.toString());
		openStoreOrder.setXfsjId(0L);
		//看看有没有报名成功的活动
		List<OpenXFSJStore> list = this.getContainServiceInfoList(serviceId);
		if(list == null || list.isEmpty())
			return;
		long now = System.currentTimeMillis();
		for(OpenXFSJStore openXFSJStore : list) {
			 OpenXFSJInfo info = openXFSJInfoMapper.selectByPrimaryKey(openXFSJStore.getXfsjId());
			if (validatePurchaseTime(now, info)) continue;
			if (refreshData(openStoreOrder, serviceId, info)) break;
			//小富市集
			 if(OpenXFSJConstant.ActivityType.community.equals(info.getType())) {
				 openStoreOrder.setType(OpenConstant.OpenStoreOrderType.xfsj.toString());
				 openStoreOrder.setXfsjId(info.getId());
			 }
		}
		
	}

	/**
	 * @Author wlrllr
	 * @Description 重构方法 //平台（拎包或者自在E站）49拎包，50E站，同步生产
	 * @Date 2018/12/28
	 * @Param [openStoreOrder, serviceId, info]
	 * @return boolean
	 **/
	private boolean refreshData(OpenStoreOrder openStoreOrder, int serviceId, OpenXFSJInfo info) {
		if(OpenXFSJConstant.ActivityType.platform.equals(info.getType())){
			//被自己坑了，只能写死id了
			if(info.getCategoryId().intValue() == 49) {
			   //优先级最高，判断服务类型
			   OpenServiceDetailTabExample example = new OpenServiceDetailTabExample();
			   example.createCriteria().andServiceIdEqualTo(serviceId)
				   .andTypeEqualTo(OpenConstant.OpenServiceDetailTab.service_winter_term.getCode());
			   List<OpenServiceDetailTabKey> tabList = openServiceDetailTabMapper.selectByExample(example);
			   if(!tabList.isEmpty()) {
				   openStoreOrder.setType(OpenConstant.OpenStoreOrderType.wuye.toString());
			   }else {
				   openStoreOrder.setType(OpenConstant.OpenStoreOrderType.platform.toString());
			   }
			   openStoreOrder.setXfsjId(info.getId());
				return true;
			}
			if(info.getCategoryId().intValue() == 50
					&& OpenConstant.OpenStoreOrderType.estation.getLevel() < OpenConstant.OpenStoreOrderType.getTypeLevel(openStoreOrder.getType())) {
				   openStoreOrder.setType(OpenConstant.OpenStoreOrderType.estation.toString());
				   openStoreOrder.setXfsjId(info.getId());
			}
		}
		return false;
	}

	private boolean validatePurchaseTime(long now, OpenXFSJInfo info) {
		if(info == null || info.getStatus() != OpenXFSJConstant.Status.ACT_STATUS_VALID
				|| info.getBeginTime().getTime() > now || info.getEndTime().getTime() < now) {
			logger.info("info:{}" , JSONObject.toJSONString(info));
			//未在活动举办中
			return true;
		}
		return false;
	}


	private List<OpenXFSJStore> getContainServiceInfoList(int serviceId){
		OpenXFSJStoreExample example = new OpenXFSJStoreExample();
		example.createCriteria().andStoreIdEqualTo(serviceId);
		example.setOrderByClause("create_time desc");
		return openXFSJStoreMapper.selectByExample(example);
	}
}
