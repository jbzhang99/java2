package com.rfchina.community.open.bridge.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.rfchina.community.service.openser.OpenStoreGoodBaseService;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenXFSJConstant;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.entity.wo.EmpBean;
import com.rfchina.community.open.bridge.entity.ExtOpenXFSJInfo;
import com.rfchina.community.open.bridge.entity.ExtResourcePatrolInfo;
import com.rfchina.community.open.bridge.mapper.ext.ExtCommunityServiceMapper;
import com.rfchina.community.open.bridge.mapper.ext.ExtOpenStoreGoodBridgeMapper;
import com.rfchina.community.open.bridge.mapper.ext.ExtOpenXFSJInfoBridgeMapper;
import com.rfchina.community.persistence.mapper.AreaMapper;
import com.rfchina.community.persistence.mapper.CommunityMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.mapper.OpenStoreGoodMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJAreaConfigMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJGroupConfigMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJInfoDetailMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJInfoMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJStoreGoodMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJStoreMapper;
import com.rfchina.community.persistence.model.Area;
import com.rfchina.community.persistence.model.Community;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.CommunityServiceCategory;
import com.rfchina.community.persistence.model.OpenMerchantInfo;
import com.rfchina.community.persistence.model.OpenStoreGood;
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
import com.rfchina.community.persistence.model.ResourcePatrolInfo;

@Service
public class OpenXFSJActivityService extends BaseService {
	@Autowired
	private OpenXFSJInfoMapper openXFSJInfoMapper;

	@Autowired
	private ExtOpenXFSJInfoBridgeMapper extOpenXFSJInfoBridgeMapper;

	@Autowired
	private OpenXFSJInfoDetailMapper openXFSJInfoDetailMapper;
	@Autowired
	private OpenXFSJStoreGoodMapper openXFSJStoreGoodMapper;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;

	@Autowired
	private CommunityMapper communityMapper;
	@Autowired
	private AreaMapper areaMapper;
	@Autowired
	private OpenXFSJStoreMapper openXFSJStoreMapper;
	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;
	@Autowired
	private ExtCommunityServiceMapper extCommunityServiceMapper;
	@Autowired
	private ExtOpenStoreGoodBridgeMapper extOpenStoreGoodBridgeMapper;
	@Autowired
	private OpenXFSJBusinessInfoService openXFSJBusinessInfoService;
	@Autowired
	private OpenXFSJAreaConfigMapper openXFSJAreaConfigMapper;
	@Autowired
	private OpenXFSJGroupConfigMapper openXFSJGroupConfigMapper;
	@Autowired
	private OpenXFSJSignUpInfoService openXFSJSignUpInfoService;
	@Autowired
	private ResourcePatrolInfoService resourcePatrolInfoService;
	@Autowired
	private XFSJManagerInvitePerformanceService managerInvitePerformanceService;
	@Autowired
	private CommunityServiceCategoryService communityServiceCategoryService;
	@Autowired
	private OpenStoreGoodBaseService openStoreGoodBaseService;

	@Value("${open.storeapi.url}")
	private String openStoreapiUrl;

    @Autowired
    private CommunityServiceRelaService communityServiceRelaService;

	public PageList<JSONObject> listOpenXFSJInfo(int communityIds, int signUpStatus, int index, int size) {
		Map<String, Object> param = new HashMap<>();
		if (communityIds > 0) {
			param.put("communityIds", communityIds);
		}
		if (signUpStatus > 0) {
			param.put("signUpStatus", signUpStatus);
		}

		PageBounds pageBounds = new PageBounds(index, size);

		PageList<ExtOpenXFSJInfo> pager1 = extOpenXFSJInfoBridgeMapper.pageByParam(param, pageBounds);
		PageList<JSONObject> pager = new PageList<>(pager1.getPaginator());
		for (ExtOpenXFSJInfo extOpenXFSJInfo : pager1) {
			pager.add(openXFSJInfoToJson(extOpenXFSJInfo, OpenXFSJConstant.ActivityType.community));
		}

		return pager;
	}

	/**
	 * @author:fukangwen @Description: 平台活动列表 @return PageList<JSONObject> @throws
	 */
	public PageList<JSONObject> listPlatformActivity(Integer cityId,String communityId, String activityName, int categoryId, int status,
			int index, int size) {
		Map<String, Object> param = new HashMap<>();
		if (StringUtils.isNotBlank(communityId)) {
			param.put("communityId", communityId);
		}
		if (cityId != null && cityId > 0) {
			param.put("cityId", cityId);
		}
		if (status > 0) {
			param.put("status", status);
		}
		if (StringUtils.isNotBlank(activityName)) {
			param.put("activityName", "%" + activityName + "%");
		}

		if (categoryId > 0) {
			param.put("categoryId", categoryId);
		}

		PageBounds pageBounds = new PageBounds(index, size);

		PageList<ExtOpenXFSJInfo> pager1 = extOpenXFSJInfoBridgeMapper.listPlatformActivity(param, pageBounds);
		PageList<JSONObject> pager = new PageList<>(pager1.getPaginator());
		for (ExtOpenXFSJInfo extOpenXFSJInfo : pager1) {
			pager.add(openXFSJInfoToJson(extOpenXFSJInfo, OpenXFSJConstant.ActivityType.platform));
		}
		return pager;
	}

	/**
	 * @author:fukangwen @Description: 平台活动列表 @return PageList<JSONObject> @throws
	 */
	public PageList<JSONObject> listValidActivity(String activityName,int status, int index, int size) {
		Map<String, Object> param = new HashMap<>();

		if (status > 0) {
			param.put("status", status);
		}
		if (StringUtils.isNotBlank(activityName)) {
			param.put("activityName", "%" + activityName + "%");
		}

		PageBounds pageBounds = new PageBounds(index, size);

		PageList<ExtOpenXFSJInfo> pager1 = extOpenXFSJInfoBridgeMapper.listValidActivity(param, pageBounds);
		PageList<JSONObject> pager = new PageList<>(pager1.getPaginator());
		for (ExtOpenXFSJInfo extOpenXFSJInfo : pager1) {
			CommunityServiceCategory category = communityServiceCategoryService.getCommunityServiceCategory(extOpenXFSJInfo.getCategoryId());
			extOpenXFSJInfo.setCategoryName(category == null ? "" : category.getName());
			JSONObject e = (JSONObject) JSONObject.toJSON(extOpenXFSJInfo);
			Community comm = communityMapper.selectByPrimaryKey(extOpenXFSJInfo.getCommunityId());
			if (comm != null) {
				Integer cityId = comm.getCityId();
				if (cityId != null && cityId > 0) {
					Area city = areaMapper.selectByPrimaryKey(cityId);
					e.put("cityName", city.getName());
					e.put("cityId", city.getId());
				}
				e.put("communityName", comm.getName());
			}
			pager.add(e);
		}
		return pager;
	}

	private JSONObject openXFSJInfoToJson(ExtOpenXFSJInfo extOpenXFSJInfo, String activityType) {
		JSONObject e = (JSONObject) JSONObject.toJSON(extOpenXFSJInfo);
		Community comm = communityMapper.selectByPrimaryKey(extOpenXFSJInfo.getCommunityId());
		if (comm != null) {
			Integer cityId = comm.getCityId();
			if (cityId != null && cityId > 0) {
				Area city = areaMapper.selectByPrimaryKey(cityId);
				e.put("cityName", city.getName());
			}
			e.put("communityName", comm.getName());
		}

		// 有平台活动类型id
		if (extOpenXFSJInfo.getCategoryId() != null && extOpenXFSJInfo.getCategoryId() > 0) {
			CommunityServiceCategory category = communityServiceCategoryService
					.getCommunityServiceCategory(extOpenXFSJInfo.getCategoryId());
			e.put("categoryName", category == null ? "" : category.getName());
		}

		// 小富市集才需要
		if (OpenXFSJConstant.ActivityType.community.equals(activityType)) {
			// 已缴费/待缴费
			e.put("paidAmount", openXFSJSignUpInfoService.getSignUpNumByStatus(extOpenXFSJInfo.getId(),
					OpenConstant.SignUpCheckStatus.PAID));
			e.put("unPaidAmount", openXFSJSignUpInfoService.getSignUpNumByStatus(extOpenXFSJInfo.getId(),
					OpenConstant.SignUpCheckStatus.PASS));
		} else {
			String actTime = DateTimeUtils.format(extOpenXFSJInfo.getBeginTime(), DateTimeUtils.DATETIME_FORMAT) + " - "
					+ DateTimeUtils.format(extOpenXFSJInfo.getEndTime(), DateTimeUtils.DATETIME_FORMAT);
			e.put("actTime", actTime);
		}

		return e;
	}

	public JSONObject getOpenXFSJInfoStatus(int communityId) {
		JSONObject json = new JSONObject();
		int status = 1;
		json.put("status", status);
		String statusTitle = "启动";
		json.put("statusTitle", statusTitle);
		// http://store.zizai.test.thinkinpower.net/index.html#/rfFair?isNew=1&communityId=1
		json.put("link", openStoreapiUrl + "index.html#/rfFair?isNew=1&communityId=" + communityId);
		return json;
	}

	public JSONObject getOpenXFSJInfo(Long id) {
		OpenXFSJInfo info = openXFSJInfoMapper.selectByPrimaryKey(id);
		JSONObject json = new JSONObject();
		ExtOpenXFSJInfo extInfo = new ExtOpenXFSJInfo();
		BeanUtils.copyProperties(info, extInfo);
		extInfo.setGroupAreaName(this.getGroupAreaNameByIds(info.getGroupConfigId(), info.getAreaConfigId()));
		// 有平台活动类型id
		if (info.getCategoryId() > 0) {
			CommunityServiceCategory category = communityServiceCategoryService
					.getCommunityServiceCategory(info.getCategoryId());
			extInfo.setCategoryName(category == null ? "" : category.getName());
		}
		json.put("info", extInfo);

		OpenXFSJInfoDetail detail = openXFSJInfoDetailMapper.selectByPrimaryKey(id);
		json.put("detail", detail);

		Community comm = communityMapper.selectByPrimaryKey(info.getCommunityId());
		if (comm != null) {
			Integer cityId = comm.getCityId();
			if (cityId != null && cityId > 0) {
				Area city = areaMapper.selectByPrimaryKey(cityId);
				json.put("cityName", city.getName());
				extInfo.setCityId(cityId);
			}
			json.put("communityName", comm.getName());
		}
		return json;
	}

	/**
	 * @author:fukangwen @Description: 获取集团地区配置 @return String @throws
	 */
	private String getGroupAreaNameByIds(Long groupConfigId, Long areaConfigId) {
		if (groupConfigId == null || areaConfigId == null)
			return null;
		OpenXFSJGroupConfig groupConfig = openXFSJGroupConfigMapper.selectByPrimaryKey(groupConfigId);
		OpenXFSJAreaConfig areaConfig = openXFSJAreaConfigMapper.selectByPrimaryKey(areaConfigId);
		if (groupConfig == null || areaConfig == null)
			return null;
		return groupConfig.getName() + " / " + areaConfig.getName();
	}

	public int updateOpenXFSJInfoStatus(Long id, int status) {
		OpenXFSJInfo info = openXFSJInfoMapper.selectByPrimaryKey(id);
		validator(info == null, "数据不存在:" + id);
		if (status == 1) {
			OpenXFSJInfoExample exa = new OpenXFSJInfoExample();
			exa.createCriteria().andCommunityIdEqualTo(info.getCommunityId())
					.andTypeEqualTo(OpenXFSJConstant.ActivityType.community).andStatusEqualTo(1);
			long count = openXFSJInfoMapper.countByExample(exa);
			validator(count > 0, "只能同时一个活动进行!");
		}

		OpenXFSJInfo record = new OpenXFSJInfo();
		record.setId(id);
		record.setStatus(status);
		int flag = openXFSJInfoMapper.updateByPrimaryKeySelective(record);
		// 更改巡查活动状态
		resourcePatrolInfoService.updatePatrolInfoStatus(id, info.getCommunityId(), status);
		return flag;
	}

	/**
	 * @author:fukangwen @Description: 更改平台活动状态 @return int @throws
	 */
	public int updatePlatformActivityStatus(Long id, int status) {
		OpenXFSJInfo info = openXFSJInfoMapper.selectByPrimaryKey(id);
		validator(info == null, "数据不存在:" + id);

		OpenXFSJInfo record = new OpenXFSJInfo();
		record.setId(id);
		record.setStatus(status);
		int flag = openXFSJInfoMapper.updateByPrimaryKeySelective(record);
		return flag;
	}

	/**
	 * @author:fukangwen @Description: 创建小富市集信息 @return Long @throws
	 */
	@Transactional
	public Long createOpenXFSJInfo(String activityType, int categoryId, int communityIds, String actAddress,
			String actImg, String actTime, String actTitile, String detail, Date beginDate, Date endDate,
			Date signUpEndDate, int amount, BigDecimal serviceFee, String resource, String localeImg, String type,
			String contactPhone, String localeDetail, Long groupConfigId, Long areaConfigId) {
		return _createOpenXFSJInfo(activityType, categoryId, communityIds, actAddress, actImg, actTime, actTitile,
				detail, beginDate, endDate, signUpEndDate, amount, serviceFee, resource, localeImg, type, contactPhone,
				localeDetail, groupConfigId, areaConfigId);
	}

	public Long _createOpenXFSJInfo(String activityType, int categoryId, int communityIds, String actAddress,
			String actImg, String actTime, String actTitile, String detail, Date beginDate, Date endDate,
			Date signUpEndDate, int amount, BigDecimal serviceFee, String resource, String localeImg, String type,
			String contactPhone, String localeDetail, Long groupConfigId, Long areaConfigId) {
		OpenXFSJInfo info = new OpenXFSJInfo();
		info.setActAddress(actAddress);
		info.setActImg(actImg);
		info.setActTime(actTime);
		info.setActTitile(actTitile);
		info.setCommunityId(communityIds);
		info.setCreateTime(new Date());
		info.setStatus(2);
		info.setBeginTime(beginDate);
		info.setEndTime(endDate);
		info.setGroupConfigId(groupConfigId);
		info.setAreaConfigId(areaConfigId);
		info.setType(activityType);
		info.setCategoryId(categoryId);
		//* http://store.zizai.test.thinkinpower.net/index.html#/rfFair?isNew=1&communityId=1
		info.setActUrl(openStoreapiUrl + "index.html#/rfFair?isNew=1&communityId=" + communityIds);
		openXFSJInfoMapper.insertSelective(info);
		Long id = info.getId();

		OpenXFSJInfoDetail dtl = new OpenXFSJInfoDetail();
		dtl.setDetail(detail);
		dtl.setId(id);
		openXFSJInfoDetailMapper.insertSelective(dtl);

		// 招商信息
		openXFSJBusinessInfoService.insert(id, amount, contactPhone, localeImg, serviceFee, signUpEndDate,
				OpenXFSJConstant.SignUpStatus.BUSINESS_STATUS_NO, type, localeDetail);

		// 巡查信息初始化
		resourcePatrolInfoService.initPatrolInfo(id, communityIds);
		return id;
	}

	/**
	 * @author:fukangwen @Description: 创建平台活动 @return Long @throws
	 */
	@Transactional
	public Long createPlatformActivity(String activityType, int categoryId, int communityId, String actAddress,
			String actImg, String actTitile, String detail, Date beginDate, Date endDate) {
		OpenXFSJInfo info = new OpenXFSJInfo();
		info.setActAddress(actAddress);
		info.setActImg(actImg);
		info.setActTitile(actTitile);
		info.setCommunityId(communityId);
		info.setCreateTime(new Date());
		info.setStatus(2);
		info.setBeginTime(beginDate);
		info.setEndTime(endDate);
		info.setType(activityType);
		info.setCategoryId(categoryId);
		openXFSJInfoMapper.insertSelective(info);
		Long id = info.getId();
		// http://store.zizai.test.thinkinpower.net/index.html#/rfActivity?isNew=1&rfActivityId=1163
		info.setActUrl(openStoreapiUrl + "index.html#/rfActivity?isNew=1&rfActivityId=" + id);
		openXFSJInfoMapper.updateByPrimaryKey(info);
		OpenXFSJInfoDetail dtl = new OpenXFSJInfoDetail();
		dtl.setDetail(detail);
		dtl.setId(id);
		openXFSJInfoDetailMapper.insertSelective(dtl);

		return id;
	}

	public int updateOpenXFSJInfo(Long id, int communityId, int categoryId, String actAddress, String actImg,
			String actTime, String actTitile, String detail, Long groupConfigId, Long areaConfigId, Date beginTime,
			Date endTime) {
		OpenXFSJInfo info = openXFSJInfoMapper.selectByPrimaryKey(id);
		info.setActAddress(actAddress);
		info.setActImg(actImg);
		info.setActTime(actTime);
		info.setActTitile(actTitile);
		info.setGroupConfigId(groupConfigId);
		info.setAreaConfigId(areaConfigId);

		// 平台活动可修改时间
		if (beginTime != null && endTime != null) {
			info.setBeginTime(beginTime);
			info.setEndTime(endTime);
		}
		if (communityId > 0) {
			info.setCommunityId(communityId);
		}
		if (categoryId > 0) {
			info.setCategoryId(categoryId);
		}
		openXFSJInfoMapper.updateByPrimaryKeySelective(info);
		OpenXFSJInfoDetail dtl = new OpenXFSJInfoDetail();
		dtl.setDetail(detail);
		dtl.setId(id);
		int i = openXFSJInfoDetailMapper.updateByPrimaryKeySelective(dtl);

		return i;

	}

	private OpenXFSJStore getOpenXFSJStore(Long xfsjId, Integer storeId) {
		OpenXFSJStoreExample example = new OpenXFSJStoreExample();
		example.createCriteria().andXfsjIdEqualTo(xfsjId).andStoreIdEqualTo(storeId);
		List<OpenXFSJStore> list = openXFSJStoreMapper.selectByExample(example);
		return list.isEmpty() ? null : list.get(0);
	}

	public synchronized Long createOpenXFSJStoreGood(Long xfsjId, Integer goodId, Integer type, Integer storeId,
			String img, String title, Integer orderby) {

		OpenXFSJStoreGoodExample eple = new OpenXFSJStoreGoodExample();
		eple.createCriteria().andXfsjIdEqualTo(xfsjId).andGoodIdEqualTo(goodId);
		validator(openXFSJStoreGoodMapper.countByExample(eple) > 0, "该商品已经增加过");

		OpenXFSJStore info = getOpenXFSJStore(xfsjId, storeId);
		if (info == null) {
			info = new OpenXFSJStore();
			info.setOrderby(orderby);
			info.setStoreId(storeId);
			info.setXfsjId(xfsjId);
			info.setCreateTime(new Date());
			openXFSJStoreMapper.insertSelective(info);
		}

		OpenXFSJStoreGood good = addXFSJStoreGood(xfsjId, goodId, type, storeId, img, title, orderby);
		return good.getId();
	}

	private OpenXFSJStoreGood addXFSJStoreGood(Long xfsjId, Integer goodId, Integer type, Integer storeId, String img, String title, Integer orderby) {
		OpenXFSJStoreGood good = new OpenXFSJStoreGood();
		good.setGoodId(goodId);
		good.setImg(img);
		good.setOrderby(orderby);
		good.setStoreId(storeId);
		good.setTitle(title);
		good.setType(type);
		good.setXfsjId(xfsjId);
		good.setCreateTime(new Date());
		openXFSJStoreGoodMapper.insertSelective(good);
		return good;
	}

	public synchronized void createPlatformActivityStoreGood(Long xfsjId, String goodIds, Integer type, Integer storeId,
			String img, String title, Integer orderby) {
		OpenXFSJStore info = getOpenXFSJStore(xfsjId, storeId);
		if (info == null) {
			addXFSJStore(xfsjId,storeId,orderby,null);
		}
		// 删除原有的
		OpenXFSJStoreGoodExample eple = new OpenXFSJStoreGoodExample();
		eple.createCriteria().andXfsjIdEqualTo(xfsjId).andStoreIdEqualTo(storeId);
		openXFSJStoreGoodMapper.deleteByExample(eple);
		if (StringUtils.isNotBlank(goodIds)) {
			String[] goodIdArr = goodIds.split(",");
			for (String goodIdStr : goodIdArr) {
				int goodId = 0;
				try {
					goodId = Integer.parseInt(goodIdStr);
				} catch (NumberFormatException e) {
					error("参数错误");
				}
				addXFSJStoreGood(xfsjId, goodId, type, storeId, img, title, orderby);
			}
		}
	}

	public int deleteOpenXFSJStore(Long xfsjId, int storeId) {
		OpenXFSJStoreKey key = new OpenXFSJStoreKey();
		key.setStoreId(storeId);
		key.setXfsjId(xfsjId);
		openXFSJStoreMapper.deleteByPrimaryKey(key);
		OpenXFSJStoreGoodExample example = new OpenXFSJStoreGoodExample();
		example.createCriteria().andStoreIdEqualTo(storeId).andXfsjIdEqualTo(xfsjId);
		int i = openXFSJStoreGoodMapper.deleteByExample(example);
		return i;
	}

	public int deleteOpenXFSJStoreGood(Long xfsjId, Long id, String activityType) {
		OpenXFSJStoreGood data = openXFSJStoreGoodMapper.selectByPrimaryKey(id);
		validator(data == null, "数据不存在" + id);
		int i = 0;
		OpenXFSJStoreGoodExample example = new OpenXFSJStoreGoodExample();
		example.createCriteria().andStoreIdEqualTo(data.getStoreId()).andXfsjIdEqualTo(xfsjId);
		long count = openXFSJStoreGoodMapper.countByExample(example);
		// 小富市集活动只有一个商品的需要把店铺也一并删除
		if (count == 1 && OpenXFSJConstant.ActivityType.community.equals(activityType)) {
			i = deleteOpenXFSJStore(xfsjId, data.getStoreId());
		} else {
			i = openXFSJStoreGoodMapper.deleteByPrimaryKey(id);
		}
		return i;
	}

	public PageList<Map<String, Object>> listStoreName(int communityIds, String title, int index, int size) {
		PageBounds pageBounds = new PageBounds(index, size);
		Map<String, Object> param = new HashMap<>();
		if (communityIds > 0) {
			param.put("community_id", communityIds);
		}
		if (StringUtils.isNotBlank(title)) {
			param.put("title", "%" + title + "%");
		}
		PageList<Map<String, Object>> pager = extCommunityServiceMapper.searchServiceName(param, pageBounds);

		return pager;
	}

	public PageList<Map<String, Object>> listStoreGood(int storeId, String goodTitle, int index, int size) {
		PageBounds pageBounds = new PageBounds(index, size);
		Map<String, Object> param = new HashMap<>();
		param.put("service_id", storeId);
		if (StringUtils.isNotBlank(goodTitle)) {
			param.put("goodTitle", "%" + goodTitle + "%");
		}
		PageList<Map<String, Object>> pager = extOpenStoreGoodBridgeMapper.listStoreGood(param, pageBounds);

		return pager;
	}

	public List<JSONObject> listOpenXFSJStoreGood(Long xfsjId, int type) {
		OpenXFSJStoreExample example = new OpenXFSJStoreExample();
		example.createCriteria().andXfsjIdEqualTo(xfsjId);
		example.setOrderByClause("create_time");
		List<OpenXFSJStore> list = openXFSJStoreMapper.selectByExample(example);
		List<JSONObject> array = new ArrayList<>();
		for (OpenXFSJStore openXFSJStore : list) {
			int storeId = openXFSJStore.getStoreId();
			JSONObject e = new JSONObject();
			e.put("openXFSJStore", openXFSJStore);
			CommunityService cs = communityServiceMapper.selectByPrimaryKey(storeId);
			OpenMerchantInfo merchant = openMerchantInfoMapper.selectByPrimaryKey(cs.getMerchantId());
			e.put("merchantTitle", merchant == null ? "" : merchant.getTitle());
			e.put("storeTitle", cs.getTitle());
			e.put("type", type);
			e.put("xfsjId", xfsjId);
			e.put("storeId", storeId);

			OpenXFSJStoreGoodExample exa = new OpenXFSJStoreGoodExample();
			exa.createCriteria().andXfsjIdEqualTo(xfsjId).andTypeEqualTo(type).andStoreIdEqualTo(storeId);
			List<OpenXFSJStoreGood> lst = openXFSJStoreGoodMapper.selectByExample(exa);
			List<JSONObject> goodLists = new ArrayList<>();
			if (!lst.isEmpty()) {
				for (OpenXFSJStoreGood openXFSJStoreGood : lst) {
					OpenStoreGood goods = openStoreGoodBaseService.selectByPrimaryKey(openXFSJStoreGood.getGoodId());
					JSONObject json = (JSONObject) JSONObject.toJSON(openXFSJStoreGood);
					json.put("goods", goods);
					goodLists.add(json);
				}
			}
			e.put("goodLists", goodLists);
			array.add(e);
		}
		return array;
	}

	/**
	 * @author:fukangwen @Description: 获取巡查信息 @throws
	 */
	public List<ExtResourcePatrolInfo> getPatrolInfo(long xfsjId) {
		//
		List<ResourcePatrolInfo> list = resourcePatrolInfoService.listPatrolInfo(xfsjId);
		if (list.isEmpty())
			return new ArrayList<>();

		List<ExtResourcePatrolInfo> extList = new ArrayList<>();

		// 组装list
		List<String> empGidList = new ArrayList<>();
		for (ResourcePatrolInfo eomi : list) {
			if (StringUtils.isNotBlank(eomi.getEmpGuid()))
				empGidList.add(eomi.getEmpGuid());
		}
		Map<String, EmpBean> empMap = managerInvitePerformanceService.getEmpBeanMap(empGidList);

		for (ResourcePatrolInfo info : list) {
			ExtResourcePatrolInfo extInfo = new ExtResourcePatrolInfo();
			BeanUtils.copyProperties(info, extInfo);
			extInfo.setResultList(resourcePatrolInfoService.getPatrolResult(info.getPatrolId()));

			EmpBean emp = empMap.get(info.getEmpGuid());
			if (emp != null) {
				extInfo.setEmpName(emp.getEmpName());
				extInfo.setEmpMobile(emp.getEmpMobile());
			}

			extList.add(extInfo);
		}

		return extList;
	}

	/**
	 * @author:fukangwen @Description: 更换店铺封面 @return long @throws
	 */
	public long updateCoverImg(Long xfsjId, Integer storeId, String coverImg) {
		OpenXFSJStoreKey key = new OpenXFSJStoreKey();
		key.setStoreId(storeId);
		key.setXfsjId(xfsjId);
		OpenXFSJStore openXFSJStore = openXFSJStoreMapper.selectByPrimaryKey(key);
		if (openXFSJStore == null) {
			error("店铺不存在");
		}
		openXFSJStore.setCoverImg(coverImg);
		return openXFSJStoreMapper.updateByPrimaryKeySelective(openXFSJStore);
	}

	public void createOpenXFSJStore(Long xfsjId, Integer storeId, Integer orderby, String coverImg) {
		OpenXFSJStore info = getOpenXFSJStore(xfsjId, storeId);
		if (info == null) {
			addXFSJStore(xfsjId, storeId, orderby, coverImg);
		}
	}

	private void addXFSJStore(Long xfsjId, Integer storeId, Integer orderBy, String coverImg) {
		OpenXFSJStore info;
		info = new OpenXFSJStore();
		info.setOrderby(orderBy);
		info.setStoreId(storeId);
		info.setXfsjId(xfsjId);
		info.setCoverImg(coverImg);
		info.setCreateTime(new Date());
		openXFSJStoreMapper.insertSelective(info);
	}

	public Map<String, Object> getPlatformActivityQrcode(int xfsjId) {
		Map<String, Object> map = new HashMap<>();
		// http://store.zizai.test.thinkinpower.net/index.html#/rfActivity?isNew=1&rfActivityId=1163
		String url = openStoreapiUrl + "index.html#/rfActivity?isNew=1&rfActivityId=" + xfsjId;
		map.put("url", url);
		map.put("qrbase64", openXFSJBusinessInfoService.getQrBase64(url));
		return map;
	}

	public List<JSONObject> getStoreList(long xfsjId){
		OpenXFSJStoreExample example = new OpenXFSJStoreExample();
		example.createCriteria().andXfsjIdEqualTo(xfsjId);
		example.setOrderByClause("create_time");
		List<OpenXFSJStore> list = openXFSJStoreMapper.selectByExample(example);
		List<JSONObject> array = new ArrayList<>();
		for (OpenXFSJStore openXFSJStore : list) {
			int storeId = openXFSJStore.getStoreId();
			JSONObject e = new JSONObject();
			e.put("serviceId", storeId);
			CommunityService cs = communityServiceMapper.selectByPrimaryKey(storeId);
			OpenMerchantInfo merchant = openMerchantInfoMapper.selectByPrimaryKey(cs.getMerchantId());
			e.put("merchantTitle", merchant == null ? "" : merchant.getTitle());
			e.put("serviceTitle", cs.getTitle());
			e.put("categoryId", cs.getCategoryId());

			CommunityServiceCategory category = communityServiceCategoryService.getCommunityServiceCategory(cs.getCategoryId());
			e.put("categoryName", category == null ? "" : category.getName());
			array.add(e);
		}
		return array;
	}

	@Transactional
	public Long clonePlatformActivity(String activityType, int categoryId, int communityId, String actAddress,
                                      String actImg, String actTitle, String detail, Date beginDate, Date endDate, JSONArray stores) {
		Long activityId = createPlatformActivity(activityType, categoryId,
				communityId, actAddress, actImg, actTitle,detail, beginDate, endDate);
		if(stores != null && stores.size()>0){
		    for(int i=0;i<stores.size();i++){
                JSONObject obj = stores.getJSONObject(i);
                Integer serviceId = obj.getInteger("serviceId");
				boolean flag = communityServiceRelaService.check(serviceId,communityId);
				if(!flag){
					CommunityService service = communityServiceMapper.selectByPrimaryKey(serviceId);
					if(service != null){
						validator(true,"创建失败，该社区没有启动【"+service.getTitle()+"】服务!");
					}else{
						validator(true,"创建失败，找不到该服务!");
					}
				}
                createOpenXFSJStore(activityId, serviceId, i, obj.getString("img"));
                JSONArray goodsIds = obj.getJSONArray("goodsIds");
                if(goodsIds != null && goodsIds.size()>0 ){
                    List<OpenStoreGood> list = openStoreGoodBaseService.getGoodsByIds(goodsIds.toJavaList(Integer.class));
                    if(list != null && list.size()>0){
                        for(OpenStoreGood goods : list){
                            addXFSJStoreGood(activityId, goods.getId(), OpenXFSJConstant.Type.SHOP_BETTER, goods.getServiceId(), null, "", 0);
                        }
                    }
                }
            }
        }
		return activityId;
	}
}
