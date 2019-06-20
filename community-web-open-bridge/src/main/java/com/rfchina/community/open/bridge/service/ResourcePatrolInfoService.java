package com.rfchina.community.open.bridge.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.OpenXFSJConstant;
import com.rfchina.community.open.bridge.entity.ExtResourcePatrolResult;
import com.rfchina.community.persistence.mapper.OpenXFSJInfoMapper;
import com.rfchina.community.persistence.mapper.ResourcePatrolInfoMapper;
import com.rfchina.community.persistence.mapper.ResourcePatrolResultMapper;
import com.rfchina.community.persistence.mapper.ResourcePatrolTypeMapper;
import com.rfchina.community.persistence.model.OpenXFSJInfo;
import com.rfchina.community.persistence.model.ResourcePatrolInfo;
import com.rfchina.community.persistence.model.ResourcePatrolInfoExample;
import com.rfchina.community.persistence.model.ResourcePatrolResult;
import com.rfchina.community.persistence.model.ResourcePatrolResultExample;
import com.rfchina.community.persistence.model.ResourcePatrolType;
import com.rfchina.community.persistence.model.ResourcePatrolTypeExample;

/**
 * @author:fukangwen
 * @Description: 巡查信息
 */
@Service
public class ResourcePatrolInfoService extends BaseService {
	@Autowired
	private ResourcePatrolInfoMapper resourcePatrolInfoMapper;
	@Autowired
	private ResourcePatrolResultMapper resourcePatrolResultMapper;
	@Autowired
	private ResourcePatrolTypeMapper resourcePatrolTypeMapper;
	@Autowired
	private OpenXFSJInfoMapper openXFSJInfoMapper;
	/**
	 * @author:fukangwen
	 * @Description: 获取巡查信息
	 * @return void
	 * @throws
	 */
	public List<ResourcePatrolInfo> listPatrolInfo(long xfsjId) {
		ResourcePatrolInfoExample example = new ResourcePatrolInfoExample();
		example.createCriteria().andXfsjIdEqualTo(xfsjId);
		example.setOrderByClause("patrol_id");
		return resourcePatrolInfoMapper.selectByExample(example);
	}

	/**
	 * @author:fukangwen
	 * @Description: 根据巡查id获取巡查结果
	 * @return List<ResourcePatrolResult>
	 * @throws
	 */
	public List<ExtResourcePatrolResult> getPatrolResult(Long patrolId) {
		ResourcePatrolResultExample example = new ResourcePatrolResultExample();
		example.createCriteria().andPatrolIdEqualTo(patrolId);
		example.setOrderByClause("patrol_type");
		List<ResourcePatrolResult> list = resourcePatrolResultMapper.selectByExample(example);
		List<ExtResourcePatrolResult> extList = new ArrayList<>();
		for(ResourcePatrolResult result : list) {
			ExtResourcePatrolResult extResult = new ExtResourcePatrolResult();
			BeanUtils.copyProperties(result, extResult);
			ResourcePatrolType type = resourcePatrolTypeMapper.selectByPrimaryKey(result.getPatrolType());
			extResult.setPatrolTypeName(type == null ? "" : type.getTypeName());
			extList.add(extResult);
		}
		return extList;
	}

	/**
	 * @author:fukangwen
	 * @Description: 初始化 
	 * @return void
	 * @throws
	 */
	public void initPatrolInfo(Long xfsjId, int communityId) {
		if(!hadInit(xfsjId)) {
			ResourcePatrolInfo info = new ResourcePatrolInfo();
			info.setCreateTime(new Date());
			info.setPatrolStatus(OpenXFSJConstant.PatrolStatus.STATUS_INVALID);
			info.setStatus(OpenXFSJConstant.Status.ACT_STATUS_INVALID);
			info.setXfsjId(xfsjId);
			info.setCommunityId(communityId);
			resourcePatrolInfoMapper.insertSelective(info);
			
			//初始化结果不用做
//			ResourcePatrolTypeExample example = new ResourcePatrolTypeExample();
//			example.createCriteria().andStatusEqualTo(OpenXFSJConstant.Status.ACT_STATUS_VALID);
//			example.setOrderByClause("patrol_type");
//			List<ResourcePatrolType> typeList = resourcePatrolTypeMapper.selectByExample(example);
//			
//			for(ResourcePatrolType type : typeList) {
//				ResourcePatrolResult result = new ResourcePatrolResult();
//				result.setPatrolId(info.getPatrolId());
//				result.setPatrolType(type.getPatrolType());
//				result.setPatrolResult("");
//				resourcePatrolResultMapper.insertSelective(result);
//			}
		}
	}
	

	/**
	 * @author:fukangwen
	 * @Description: 更新巡查状态
	 * @return void
	 * @throws
	 */
	public void updatePatrolInfoStatus(Long xfsjId, int communityId, int status) {
		
		if(!hadInit(xfsjId)) {
			//旧数据没有巡查数据
			initPatrolInfo(xfsjId, communityId);
		}
		
		ResourcePatrolInfoExample example = new ResourcePatrolInfoExample();
		example.createCriteria().andXfsjIdEqualTo(xfsjId);
		
		ResourcePatrolInfo info = new ResourcePatrolInfo();
		info.setStatus(status);
		info.setUpdateTime(new Date());
		
		resourcePatrolInfoMapper.updateByExampleSelective(info, example);
	}

	
	private boolean hadInit(Long xfsjId) {
		ResourcePatrolInfoExample example = new ResourcePatrolInfoExample();
		example.createCriteria().andXfsjIdEqualTo(xfsjId);
		long count = resourcePatrolInfoMapper.countByExample(example);
		if(count > 0)
			return true;
		return false;
	}
	
	
}
