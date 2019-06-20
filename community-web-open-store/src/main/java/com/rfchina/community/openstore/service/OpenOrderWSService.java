package com.rfchina.community.openstore.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rfchina.community.openstore.mapper.ext.ExtOpenOrderStoreMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OpenOrderWSService extends BaseService{

	@Autowired
	private ExtOpenOrderStoreMapper extOpenOrderStoreMapper;

	public PageInfo<?> listOrderThreeByUid(Long userId, int index, int size) {
		logger.info("获取我的订单列表:参数userId:{},index:{},size:{}", userId, index, size);
		PageHelper.startPage(index, size);
		List<Map<String, Object>> list = extOpenOrderStoreMapper.listOrderThreeByUid(userId);
		PageInfo pageInfo = new PageInfo(list);
		return pageInfo;
	}
	public Map<String, Object> oneOrderThreeByUid(Long userId, Long id) {
		return extOpenOrderStoreMapper.oneOrderThreeByUid(userId,id);


	}
}
