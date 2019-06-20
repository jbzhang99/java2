package com.rfchina.community.openweb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenXFSJConstant;
import com.rfchina.community.entity.communityService.ExtCommunityServiceTemp;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.mapper.OpenStoreGoodMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJAreaConfigMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJGroupConfigMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJStoreGoodMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJStoreMapper;
import com.rfchina.community.persistence.mapper.OpenXfsjSignUpInfoMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.OpenMerchantInfo;
import com.rfchina.community.persistence.model.OpenStoreGood;
import com.rfchina.community.persistence.model.OpenXFSJStore;
import com.rfchina.community.persistence.model.OpenXFSJStoreExample;
import com.rfchina.community.persistence.model.OpenXFSJStoreGood;
import com.rfchina.community.persistence.model.OpenXFSJStoreGoodExample;
import com.rfchina.community.persistence.model.OpenXFSJStoreKey;
import com.rfchina.community.persistence.model.OpenXfsjSignUpInfoExample;

@Service
public class OpenXFSJActivityService extends BaseService {
	@Autowired
	private OpenXFSJStoreGoodMapper openXFSJStoreGoodMapper;

	@Autowired
	private OpenStoreGoodMapper openStoreGoodMapper;
	@Autowired
	private OpenXFSJStoreMapper openXFSJStoreMapper;
	@Autowired
	private CommunityServiceService communityServiceService;
	@Autowired
	private OpenXfsjSignUpInfoMapper openXfsjSignUpInfoMapper;
	@Value("${open.storeapi.url}")
	private String openStoreapiUrl;
	
	private OpenXFSJStore getOpenXFSJStore(Long xfsjId, Integer storeId) {
		OpenXFSJStoreExample example = new OpenXFSJStoreExample();
		example.createCriteria().andXfsjIdEqualTo(xfsjId).andStoreIdEqualTo(storeId);
		List<OpenXFSJStore> list = openXFSJStoreMapper.selectByExample(example);
		return list.isEmpty() ? null : list.get(0);
	}

	public synchronized Long createOpenXFSJStoreGood(Long xfsjId, Integer goodId, Integer storeId) {
		//是否需要判断已经支付成功
		OpenXfsjSignUpInfoExample example = new OpenXfsjSignUpInfoExample();
		example.createCriteria().andXfsjIdEqualTo(xfsjId).andServiceIdEqualTo(storeId).andStatusEqualTo(OpenConstant.SignUpCheckStatus.PAID);
		long payNum = openXfsjSignUpInfoMapper.countByExample(example);
		validator(payNum < 1, "报名未支付不可配置商品");
		
		OpenXFSJStoreGoodExample eple=new OpenXFSJStoreGoodExample();
		eple.createCriteria().andXfsjIdEqualTo(xfsjId).andGoodIdEqualTo(goodId).andStoreIdEqualTo(storeId);
		validator(openXFSJStoreGoodMapper.countByExample(eple)>0,"该商品已经增加过");
		
		OpenXFSJStoreGoodExample count=new OpenXFSJStoreGoodExample();
		count.createCriteria().andXfsjIdEqualTo(xfsjId).andStoreIdEqualTo(storeId);
		validator(openXFSJStoreGoodMapper.countByExample(count)>=5,"最多可添加5件商品");
		
		OpenXFSJStore info = getOpenXFSJStore(xfsjId, storeId);
		if (info == null) {
			info = new OpenXFSJStore();
			info.setOrderby(0);
			info.setStoreId(storeId);
			info.setXfsjId(xfsjId);
			info.setCreateTime(new Date());
			openXFSJStoreMapper.insertSelective(info);
		}
		
		OpenXFSJStoreGood good = new OpenXFSJStoreGood();
		good.setGoodId(goodId);
		good.setOrderby(0);
		good.setStoreId(storeId);
		good.setType(OpenXFSJConstant.Type.SHOP_BETTER);
		good.setXfsjId(xfsjId);
		good.setCreateTime(new Date());
		openXFSJStoreGoodMapper.insertSelective(good);

		return good.getId();
	}


	public int deleteOpenXFSJStoreGood(Long id) {
		OpenXFSJStoreGood data = openXFSJStoreGoodMapper.selectByPrimaryKey(id);
		validator(data == null, "数据不存在" + id);
		int i = openXFSJStoreGoodMapper.deleteByPrimaryKey(id);
		return i;
	}

	public List<JSONObject> listOpenXFSJStoreGood(Long xfsjId, int serviceId) {
		
		//根据uid获取, int type
		CommunityService communityService = communityServiceService.getCommunityServiceByPrimaryKey(serviceId);
		
		OpenXFSJStoreExample example = new OpenXFSJStoreExample();
		example.createCriteria().andXfsjIdEqualTo(xfsjId).andStoreIdEqualTo(communityService.getId());
		List<OpenXFSJStore> list = openXFSJStoreMapper.selectByExample(example);
		if(list.isEmpty()) {
			return new ArrayList<JSONObject>();
		}
		validator(list.size() > 1, "获取店铺信息错误");
		
		int storeId = list.get(0).getStoreId();
		OpenXFSJStoreGoodExample exa = new OpenXFSJStoreGoodExample();
		exa.createCriteria().andXfsjIdEqualTo(xfsjId).andTypeEqualTo(OpenXFSJConstant.Type.SHOP_BETTER).andStoreIdEqualTo(storeId);
		example.setOrderByClause("orderby desc");
		List<OpenXFSJStoreGood> lst = openXFSJStoreGoodMapper.selectByExample(exa);
		
		List<JSONObject> array = new ArrayList<>();
		if (!lst.isEmpty()) {
			for (OpenXFSJStoreGood openXFSJStoreGood : lst) {
			    JSONObject e = new JSONObject();
				OpenStoreGood good = openStoreGoodMapper.selectByPrimaryKey(openXFSJStoreGood.getGoodId());
				e.put("good", good);
				e.put("xfsjGood", openXFSJStoreGood);
				array.add(e);
			}
		}
		return array;
	}

}
