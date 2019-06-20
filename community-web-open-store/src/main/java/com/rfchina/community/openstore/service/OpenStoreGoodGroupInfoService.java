package com.rfchina.community.openstore.service;

import com.rfchina.community.base.OpenGoodGroupConstant;
import com.rfchina.community.persistence.mapper.OpenStoreGoodGroupInfoMapper;
import com.rfchina.community.persistence.model.OpenStoreGoodGroupInfo;
import com.rfchina.community.persistence.model.OpenStoreGoodGroupInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OpenStoreGoodGroupInfoService extends BaseService {
	@Autowired
	private OpenStoreGoodGroupInfoMapper openStoreGoodGroupInfoMapper;

	/**
	 * 获取有效的商品团购信息
	 * @param goodId
	 * @return
	 */
	public OpenStoreGoodGroupInfo getValidGoodGroupInfo(int goodId){
		Date now = new Date();
		OpenStoreGoodGroupInfoExample example = new OpenStoreGoodGroupInfoExample();
		example.createCriteria().andGoodIdEqualTo(goodId)
				.andStatusEqualTo(OpenGoodGroupConstant.status.start)
				.andStartTimeLessThan(now)
				.andEndTimeGreaterThan(now);
		List<OpenStoreGoodGroupInfo> list = openStoreGoodGroupInfoMapper.selectByExample(example);
		if(list.isEmpty()) {
			return null;
		}

		return list.get(0);
	}

	public OpenStoreGoodGroupInfo getById(Long infoId){
		return openStoreGoodGroupInfoMapper.selectByPrimaryKey(infoId);
	}

	public int getGroupSuccessHour(Long infoId){
		if(infoId == null || infoId <= 0){
			return 0;
		}
		OpenStoreGoodGroupInfo info =  openStoreGoodGroupInfoMapper.selectByPrimaryKey(infoId);
		if(info == null){
			return 0;
		}
		Integer hour = info.getVirturalSuccessHour();
		return hour % 24 > 0 ? (hour / 24) * 24 + 24 : hour;
	}

	public OpenStoreGoodGroupInfo getUnStartGroupInfo(Integer goodId) {
		Date now = new Date();
		OpenStoreGoodGroupInfoExample example = new OpenStoreGoodGroupInfoExample();
		example.createCriteria().andGoodIdEqualTo(goodId)
				.andStatusEqualTo(OpenGoodGroupConstant.status.start)
				.andStartTimeGreaterThan(now);
		example.setOrderByClause("start_time");
		List<OpenStoreGoodGroupInfo> list = openStoreGoodGroupInfoMapper.selectByExample(example);
		if(list.isEmpty()) {
			return null;
		}

		return list.get(0);
	}

	/**
	 *
	 * @param goodId
	 * @return
	 */
	public OpenStoreGoodGroupInfo getRecentGroupInfo(Integer goodId) {
		Date now = new Date();
		OpenStoreGoodGroupInfoExample example = new OpenStoreGoodGroupInfoExample();
		example.createCriteria().andGoodIdEqualTo(goodId)
				.andStatusEqualTo(OpenGoodGroupConstant.status.start)
				.andEndTimeLessThan(now);
		example.setOrderByClause("end_time desc");
		List<OpenStoreGoodGroupInfo> list = openStoreGoodGroupInfoMapper.selectByExample(example);
		if(list.isEmpty()) {
			return null;
		}

		return list.get(0);
	}
}
