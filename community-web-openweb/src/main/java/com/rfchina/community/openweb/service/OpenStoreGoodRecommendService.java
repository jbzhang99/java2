package com.rfchina.community.openweb.service;

import com.rfchina.community.persistence.mapper.OpenStoreGoodRecommendMapper;
import com.rfchina.community.persistence.model.OpenGoodShowCategory;
import com.rfchina.community.persistence.model.OpenStoreGoodRecommend;
import com.rfchina.community.persistence.model.OpenStoreGoodRecommendExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 商品推荐
 */
@Service
public class OpenStoreGoodRecommendService extends BaseService {
	@Autowired
	private OpenStoreGoodRecommendMapper openStoreGoodRecommendMapper;

	private static final int limitRecommend = 10;
	/**
	 * 新增或修改
	 * @param serviceId
	 * @param goodId
	 * @param remark
	 * @param sorting
	 * @param showPic
	 * @param status
	 */
	public void insertOrUpdate(int serviceId, int goodId, String remark, int sorting, String showPic, int status){
		if(status == 1){
			long count = this.getStoreRecommendCount(serviceId);
			validator(count >= limitRecommend, "保存失败，最多推荐10个商品到首页。");
		}

		OpenStoreGoodRecommend record = openStoreGoodRecommendMapper.selectByPrimaryKey(goodId);

		if(record == null){
			record = new OpenStoreGoodRecommend();
			completeRecommend(record, serviceId, goodId, remark, showPic, sorting, status);
			record.setCreateTime(new Date());
			openStoreGoodRecommendMapper.insertSelective(record);
		}else{
			completeRecommend(record, serviceId, goodId, remark, showPic, sorting, status);
			openStoreGoodRecommendMapper.updateByPrimaryKeySelective(record);
		}
	}

	private long getStoreRecommendCount(int serviceId){
		OpenStoreGoodRecommendExample example = new OpenStoreGoodRecommendExample();
		example.createCriteria().andServiceIdEqualTo(serviceId).andStatusEqualTo(1);
		return openStoreGoodRecommendMapper.countByExample(example);
	}

	private void completeRecommend(OpenStoreGoodRecommend record,int serviceId, int goodId, String remark, String showPic,int sorting, int status){
		record.setGoodId(goodId);
		record.setServiceId(serviceId);
		record.setCreateTime(new Date());
		int isUseMainPic = 1;
		if(StringUtils.isNotBlank(showPic)){
			isUseMainPic = 0;
		}
		record.setIsUseMainPic(isUseMainPic);
		record.setShowPic(showPic);
		record.setRemark(remark);
		record.setSorting(sorting);
		record.setStatus(status);
		record.setUpdateTime(new Date());
	}

	public OpenStoreGoodRecommend getGoodRecomend(int goodId){
		return openStoreGoodRecommendMapper.selectByPrimaryKey(goodId);
	}

	public Boolean isRecommend(int goodId){
		OpenStoreGoodRecommend recommend = this.getGoodRecomend(goodId);
		if(recommend == null)
			return false;

		if(recommend.getStatus() == 1)
			return true;

		return false;
	}


}
