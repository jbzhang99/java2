package com.rfchina.community.service.openser;

import com.rfchina.community.base.OpenGoodGroupConstant;
import com.rfchina.community.persistence.mapper.OpenStoreGoodStockDetailMapper;
import com.rfchina.community.persistence.model.OpenStoreGoodStockDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author:fukangwen
 * @Description: 服务扩展service
 */
@Service
public class OpenStoreGoodStockDetailService {

	@Autowired
	private OpenStoreGoodStockDetailMapper openStoreGoodStockDetailMapper;
	
	/**
	 * @author:fukangwen
	 * @Description: 新增
	 * @return void
	 * @throws
	 */
	public void insert(int goodId, long groupInfoId, int before, int after, int amount, String type, String operate, String source, Integer targetId) {
		OpenStoreGoodStockDetail detail = new OpenStoreGoodStockDetail();
		detail.setGoodId(goodId);
		detail.setBeforeValue(before);
		detail.setAfterValue(after);
		detail.setGroupInfoId(groupInfoId);
		detail.setGroupDataId(0L);
		detail.setType(type);
		detail.setOperate(operate);
		detail.setAmount(amount);
		detail.setSource(source);
		detail.setCreateTime(new Date());
		detail.setTargetId(targetId);
		openStoreGoodStockDetailMapper.insert(detail);
	}

	/**
	 * @author:fukangwen
	 * @Description: 新增
	 * @return void
	 * @throws
	 */
	public void insertGroupDataStockDetail(int goodId, long groupInfoId, long groupDataId,
										   int before, int after, int amount, String type, String operate, String source, Integer targetId) {
		OpenStoreGoodStockDetail detail = new OpenStoreGoodStockDetail();
		detail.setGoodId(goodId);
		detail.setBeforeValue(before);
		detail.setAfterValue(after);
		detail.setGroupInfoId(groupInfoId);
		detail.setGroupDataId(groupDataId);
		detail.setType(type);
		detail.setOperate(operate);
		detail.setAmount(amount);
		detail.setSource(source);
		detail.setCreateTime(new Date());
		detail.setTargetId(targetId);
		openStoreGoodStockDetailMapper.insert(detail);
	}

	public void insert(int goodId, int before, int after, String operate, String source, Integer targetId) {
		OpenStoreGoodStockDetail detail = new OpenStoreGoodStockDetail();
		detail.setGoodId(goodId);
		detail.setBeforeValue(before);
		detail.setAfterValue(after);
		detail.setOperate(operate);
		detail.setSource(source);
		detail.setCreateTime(new Date());
		detail.setTargetId(targetId);
		openStoreGoodStockDetailMapper.insert(detail);
	}
}
