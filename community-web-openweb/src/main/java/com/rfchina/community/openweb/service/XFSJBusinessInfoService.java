package com.rfchina.community.openweb.service;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.openweb.entity.ExtOpenXFSJBusinessInfo;
import com.rfchina.community.openweb.mapper.ext.ExtOpenXFSJBusinessInfoMapper;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.persistence.model.ext.SimXFSJInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.mybatis.paginator.model.Page;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class XFSJBusinessInfoService extends BaseService {
	@Autowired
	private OpenXFSJBusinessInfoMapper openXFSJBusinessInfoMapper;
	@Autowired
	private CommunityMapper communityMapper;
	@Autowired
	private OpenXFSJInfoMapper openXFSJInfoMapper;
	@Autowired
	private AreaMapper areaMapper;
	@Autowired
	private CommunityServiceCategoryService communityServiceCategoryService;
	@Autowired
	private ExtOpenXFSJBusinessInfoMapper extOpenXFSJBusinessInfoMapper;
	@Autowired
	private OpenXFSJInfoDetailMapper openXFSJInfoDetailMapper;
	@Autowired
	private OpenXfsjSignUpInfoMapper openXfsjSignUpInfoMapper;
	@Autowired
	private CommunityServiceCategoryMapper communityServiceCategoryMapper;


	/**
	 * @author:fukangwen
	 * @Description: 获取招商信息
	 * @return JSONObject
	 * @throws
	 */
	public JSONObject getOpenXFSJBusinessInfo(Long id, Long uid, int serviceId) {
		JSONObject json = new JSONObject();
		
		OpenXFSJInfo info = openXFSJInfoMapper.selectByPrimaryKey(id);
		json.put("info", info);
		//招商信息
		OpenXFSJBusinessInfo businessInfo = openXFSJBusinessInfoMapper.selectByPrimaryKey(id);
		ExtOpenXFSJBusinessInfo extBusinessInfo = new ExtOpenXFSJBusinessInfo();
		BeanUtils.copyProperties(businessInfo, extBusinessInfo);
		if(StringUtils.isNotBlank(businessInfo.getType())) {
			extBusinessInfo.setBusinessType(communityServiceCategoryService.getBusinessType(businessInfo.getType()));
		}
		extBusinessInfo.setActivityStatus(this.getActivityStatus(extBusinessInfo.getBeginTime(), extBusinessInfo.getEndTime()));
		extBusinessInfo.setBeginTime(info.getBeginTime());
		extBusinessInfo.setEndTime(info.getEndTime());
		
		completeExtOpenXFSJBusinessInfo(extBusinessInfo, uid, serviceId);

		json.put("businessInfo", extBusinessInfo);
		
		
		OpenXFSJInfoDetail detail = openXFSJInfoDetailMapper.selectByPrimaryKey(id);
		json.put("detail", detail);
		
		Community comm = communityMapper.selectByPrimaryKey(info.getCommunityId());
		if (comm != null) {
			Integer cityId = comm.getCityId();
			if (cityId != null && cityId > 0) {
				Area city = areaMapper.selectByPrimaryKey(cityId);
				json.put("cityName", city.getName());
			}
			json.put("communityName", comm.getName());
		}
		
		return json;
	}

	public SimXFSJInfo getActivityInfo(long xfsjId){
		OpenXFSJInfo xfsj = openXFSJInfoMapper.selectByPrimaryKey(xfsjId);
		validator(xfsj == null, "活动不存在");
		SimXFSJInfo info = new SimXFSJInfo();
		BeanUtils.copyProperties(xfsj, info);
		info.setXfsjId(xfsj.getId());
		OpenXFSJInfoDetail detail = openXFSJInfoDetailMapper.selectByPrimaryKey(xfsj.getId());
		info.setDetail(detail == null ? "" : detail.getDetail());
		Community community = communityMapper.selectByPrimaryKey(xfsj.getCommunityId());
		info.setCommunityName(community.getName());
		info.setCityId(community.getCityId());
		info.setCityName(community.getCityName());
		CommunityServiceCategory category = communityServiceCategoryMapper.selectByPrimaryKey(xfsj.getCategoryId());;
		info.setCategoryName(category == null ? "" : category.getName());
		return info;
	}

	/**
	 * @author:fukangwen
	 * @Description: 活动管理列表
	 * @return Object
	 * @throws
	 */
	public Page<JSONObject> listBusinessInfo(Long uid, int cityId, int communityId, String activityName, String beginTime,
			Integer activityStatus, int status, int serviceId, String activityType,
			int index, int size) {
		PageBounds pageBounds = new PageBounds(index, size);
		Map<String, Object> map = new HashMap<String, Object>();
		Date now = new Date();
		if(cityId > 0) {
			map.put("cityId", cityId);
		}
		if(communityId > 0) {
			map.put("communityId", communityId);
		}
		if(StringUtils.isNoneBlank(activityName)) {
			map.put("activityName", "%" + activityName + "%");
		}
		
		//暂时只要可报名
		if(status == 1 || status == 2) {
			//报名时间大于当前时间
			map.put("status", status);
			map.put("localeTime", now);
		}
		if(activityStatus != null) {
			map.put("activityStatus", activityStatus);
			map.put("nowTime", now);
		}
		
		Date startDate = null;
		Date endDate = null;
		if(StringUtils.isNoneBlank(beginTime)) {
			//活动开始时间，格式为2018-03-22，转成标准时间 2018-03-22 00:00:00
			try {
	            startDate = DateUtils.parseDate(beginTime+" 00:00:00", Constant.DEFAULT_DATETIME_FORMAT);
	            endDate = DateUtils.parseDate(beginTime+" 23:59:59", Constant.DEFAULT_DATETIME_FORMAT);
	            map.put("startDate", startDate);
	            map.put("endDate", endDate);
	        } catch (ParseException e) {
	            error("开始时间日期格式不正确");
	        }
		}
		map.put("serviceId", serviceId);
		
		//活动类型，小富市集活动跟平台拎包等活动
		map.put("activityType", activityType);
		
		PageList<ExtOpenXFSJBusinessInfo> businessInfoList = extOpenXFSJBusinessInfoMapper.listBusinessInfo(map, pageBounds);
		
		
		PageList<JSONObject> pager = new PageList<>(businessInfoList.getPaginator());
		for (ExtOpenXFSJBusinessInfo extOpenXFSJInfo : businessInfoList) {
			//补充信息，报名状态、活动状态 
			pager.add(openXFSJBusinessInfoToJson(extOpenXFSJInfo, uid, serviceId));
		}
		return pager.convert();
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 获取我的报名成功列表
	 * @return Page<JSONObject>
	 * @throws
	 */
	public Page<JSONObject> listMyBusinessInfo(long uid, int cityId, int communityId, String activityName, String beginTime,
			Integer activityStatus, int serviceId, int index, int size) {
		PageBounds pageBounds = new PageBounds(index, size);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", uid);
		
		Date now = new Date();
		if(cityId > 0) {
			map.put("cityId", cityId);
		}
		if(communityId > 0) {
			map.put("communityId", communityId);
		}
		if(StringUtils.isNoneBlank(activityName)) {
			map.put("activityName", "%" + activityName + "%");
		}
		
		if(activityStatus != null) {
			map.put("activityStatus", activityStatus);
			map.put("nowTime", now);
		}
		
		Date startDate = null;
		Date endDate = null;
		if(StringUtils.isNoneBlank(beginTime)) {
			//活动开始时间，格式为2018-03-22，转成标准时间 2018-03-22 00:00:00
			try {
	            startDate = DateUtils.parseDate(beginTime+" 00:00:00", Constant.DEFAULT_DATETIME_FORMAT);
	            endDate = DateUtils.parseDate(beginTime+" 23:59:59", Constant.DEFAULT_DATETIME_FORMAT);
	            map.put("startDate", startDate);
	            map.put("endDate", endDate);
	        } catch (ParseException e) {
	            error("开始时间日期格式不正确");
	        }
		}
		
		PageList<ExtOpenXFSJBusinessInfo> businessInfoList = extOpenXFSJBusinessInfoMapper.listMyBusinessInfo(map, pageBounds);
		PageList<JSONObject> pager = new PageList<>(businessInfoList.getPaginator());
		for (ExtOpenXFSJBusinessInfo extOpenXFSJInfo : businessInfoList) {
			//补充信息，报名状态、活动状态 
			pager.add(openXFSJBusinessInfoToJson(extOpenXFSJInfo, uid, serviceId));
		}
		return pager.convert();
	}


	/**
	 * @author:fukangwen
	 * @Description: 补充信息
	 * @return JSONObject
	 * @throws
	 */
	private JSONObject openXFSJBusinessInfoToJson(ExtOpenXFSJBusinessInfo extOpenXFSJInfo, Long uid, int serviceId) {
		
		extOpenXFSJInfo.setActivityStatus(this.getActivityStatus(extOpenXFSJInfo.getBeginTime(), extOpenXFSJInfo.getEndTime()));
		completeExtOpenXFSJBusinessInfo(extOpenXFSJInfo, uid, serviceId);
		
		JSONObject e = (JSONObject) JSONObject.toJSON(extOpenXFSJInfo);
		return e;
	}
	
	/**
	 * @author:fukangwen
	 * @Description: //报名状态  1.可报名 ,2 已报名待审核, 3报名成功待缴费, 4报名成功已缴费,5报名不通过（需要拒绝理由）, 6报名截止
	 * @return int
	 * @throws
	 */
	private void completeExtOpenXFSJBusinessInfo(ExtOpenXFSJBusinessInfo extBusinessInfo, Long uid, int serviceId) {
		int days = DateTimeUtils.daysBetween(extBusinessInfo.getBeginTime(), extBusinessInfo.getEndTime());
		BigDecimal total = extBusinessInfo.getServiceFee().multiply(new BigDecimal(days));
		extBusinessInfo.setServiceFee(total);
		
		OpenXfsjSignUpInfoExample example = new OpenXfsjSignUpInfoExample();
		example.createCriteria().andXfsjIdEqualTo(extBusinessInfo.getXfsjId()).andUidEqualTo(uid).andServiceIdEqualTo(serviceId);
		example.setOrderByClause("id desc");
		List<OpenXfsjSignUpInfo> list = openXfsjSignUpInfoMapper.selectByExample(example);
		if(list.isEmpty()) {
			Date now = new Date();
			if(extBusinessInfo.getSignUpEndTime() == null || extBusinessInfo.getSignUpEndTime().getTime() < now.getTime()) {
				extBusinessInfo.setUserSignUpStatus(OpenConstant.SignUpCheckStatus.CAN_NOT_SIGN_UP);
			}else {
				extBusinessInfo.setUserSignUpStatus(OpenConstant.SignUpCheckStatus.CAN_SIGNUP);
			}
			return;
		}
		
		OpenXfsjSignUpInfo signUpInfo = list.get(0);
		extBusinessInfo.setOrderId(signUpInfo.getBillId());
		extBusinessInfo.setUserSignUpStatus(signUpInfo.getStatus());
		extBusinessInfo.setSignUpId(signUpInfo.getId());
		extBusinessInfo.setRefuseContent(signUpInfo.getRefuseContent());
		
	}

	/**
	 * @author:fukangwen
	 * @Description: 获取活动状态
	 * @return int
	 * @throws
	 */
	private int getActivityStatus(Date beginTime, Date endTime) {
		Date now = new Date();
		if(beginTime == null || endTime == null
				|| beginTime.getTime() > now.getTime()) {
			//未开始
			return 0;
		}else if(endTime.getTime() < now.getTime()) {
			//已结束
			return 2;
		}
		//进行中
		return 1;
	}
	
}
