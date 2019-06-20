package com.rfchina.community.open.bridge.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.model.*;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.Page;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.open.bridge.entity.KeyValueDomain;
import com.rfchina.community.open.bridge.mapper.ext.ExtCommunityServiceMapper;

@Service
public class CommunityServiceInfoService extends BaseService {

	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private CommunityServiceTempMapper communityServiceTempMapper;
	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;

//	@Autowired
//	private OpenMerchantInfoTempMapper openMerchantInfoTempMapper;
	@Autowired
	private CommunityServiceRelaMapper communityServiceRelaMapper;

	@Autowired
	private OpenServiceDetailMapper openServiceDetailMapper;
	@Autowired
	private CommunityServiceCategoryMapper communityServiceCategoryMapper;
	@Autowired
	private CommunityServiceCountMapper communityServiceCountMapper;
	@Autowired
	private OpenServiceExtendMapper openServiceExtendMapper;
	@Autowired
	private OpenServiceExtendTempMapper openServiceExtendTempMapper;
	@Autowired
	private ExtCommunityServiceMapper extCommunityServiceMapper;
	@Autowired
	private OpenDebugUserMapper openDebugUserMapper;

	public JSONObject getCommunityServiceInfo(Integer id) {

		JSONObject json = new JSONObject();
		CommunityService cs = communityServiceMapper.selectByPrimaryKey(id);
		validator(cs == null, "服务不存在!");
		CommunityServiceTemp csTemp = communityServiceTempMapper.selectByPrimaryKey(id);
		validator(csTemp == null, "审批数据不存在!");
		OpenServiceDetail osd = openServiceDetailMapper.selectByPrimaryKey(id);
		if (osd == null) {
			osd = new OpenServiceDetail();
			osd.setDevelopType(OpenConstant.open_service_detail.develop_type.SELF.name());
		}
		CommunityServiceCategory category = communityServiceCategoryMapper.selectByPrimaryKey(cs.getCategoryId());
		if (category == null) {
			category = new CommunityServiceCategory();
		}
		CommunityServiceCount count = communityServiceCountMapper.selectByPrimaryKey(id);
		if (count == null) {
			count = new CommunityServiceCount();
			count.setLikeCount(0);
			count.setUnlikeCount(0);
		}
		CommunityServiceRelaExample example = new CommunityServiceRelaExample();
		example.createCriteria().andServiceIdEqualTo(id);
		long communityCount = communityServiceRelaMapper.countByExample(example);
		example.clear();
		example.createCriteria().andServiceIdEqualTo(id).andStatusEqualTo(1);
		long communityAddedCount = communityServiceRelaMapper.countByExample(example);
		/*//统计 FIXME wlrllr
		List<Map> counts = communityServiceRelaMapper.countCommunityServiceRelaByKey(1,id);
		if(counts != null && counts.size()>0){
			Map countMap = counts.get(0);
			json.put("communityCount", countMap.get("allCount"));
			json.put("communityAddedCount", countMap.get("count"));
		}*/
		//查询测试账号
		OpenDebugUserExample openDebugUserExample = new OpenDebugUserExample();
		openDebugUserExample.createCriteria().andServiceIdEqualTo(id);
		List<OpenDebugUser> openDebugUserList = openDebugUserMapper.selectByExample(openDebugUserExample);
		OpenDebugUser openDebugUser = new OpenDebugUser();
        if(openDebugUserList != null && openDebugUserList.size()>0){
			openDebugUser = openDebugUserList.get(0);
		}
		json.put("communityCount", communityCount);
		json.put("communityAddedCount", communityAddedCount);
		json.put("detail", osd);
		json.put("category", category);
		json.put("count", count);
		JSONObject formal = new JSONObject();
		formal.put("service", cs);
        formal.put("debugUser", openDebugUser);
		Long mid = cs.getMerchantId();
		OpenMerchantInfo openMerchantInfo = openMerchantInfoMapper.selectByPrimaryKey(mid);
		if(openMerchantInfo == null){
			openMerchantInfo = new OpenMerchantInfo();
		}
		formal.put("merchant", openMerchantInfo);
		formal.put("category", category);
		OpenServiceExtend openServiceExtend = openServiceExtendMapper.selectByPrimaryKey(id);
		//为空校验
		if(openServiceExtend == null){
			openServiceExtend = new OpenServiceExtend();
		}
		formal.put("openServiceExtend", openServiceExtend);
		json.put("formal", formal);

		/**
		 * 组装temp数据  平台服务管理用到
		 */
		JSONObject temp = new JSONObject();
		CommunityServiceCategory categoryTemp = communityServiceCategoryMapper.selectByPrimaryKey(csTemp.getCategoryId());
		if (categoryTemp == null) {
			categoryTemp = new CommunityServiceCategory();
		}
		temp.put("debugUser", openDebugUser);
		temp.put("service", csTemp);
		temp.put("category", categoryTemp);
		temp.put("merchant", openMerchantInfo);
		OpenServiceExtendTemp openServiceExtendTemp = openServiceExtendTempMapper.selectByPrimaryKey(id);
		if(openServiceExtendTemp == null){
			openServiceExtendTemp = new OpenServiceExtendTemp();
		}
		temp.put("openServiceExtend", openServiceExtendTemp);
		json.put("temp", temp);
		return json;
	}
	
	public Page<Map<String, Object>> listStore(String storeName,int type, int index, int size) {
		Map<String, Object> param = new HashMap<>();
		if(StringUtils.isNotBlank(storeName)){
			param.put("storeName", "%" + storeName + "%");
		}
		if(type>0){
			param.put("type", type);
		}
		PageBounds pageBounds = new PageBounds(index, size);
		
		PageList<Map<String, Object>> list = extCommunityServiceMapper.searchStoreName(param, pageBounds);
		return list.convert();
	}
	
	public List<KeyValueDomain> searchCommunityServiceList(String keyword){
		String likeKeyWord = "%" + keyword + "%";
		CommunityServiceExample example = new CommunityServiceExample();
		example.createCriteria().andTitleLike(likeKeyWord).andStatusEqualTo(1);
		List<CommunityService> list = communityServiceMapper.selectByExample(example);
		List<KeyValueDomain> returnList =  new ArrayList<>();
		for(CommunityService info : list) {
			KeyValueDomain domain = new KeyValueDomain();
			domain.setKey(info.getId());
			domain.setValue(info.getTitle());
			returnList.add(domain);
		}
		return returnList;
	}

}
