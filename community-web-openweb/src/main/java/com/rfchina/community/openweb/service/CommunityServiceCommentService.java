package com.rfchina.community.openweb.service;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.paginator.model.Order;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.openweb.entity.ExtCommunityServiceComment;
import com.rfchina.community.openweb.mapper.ext.ExtCommunityServiceCommentMapper;

@Service
public class CommunityServiceCommentService {

	@Autowired
	private ExtCommunityServiceCommentMapper extCommunityServiceCommentMapper;
	
	public PageList<ExtCommunityServiceComment> getCommunityServiceCommentList(int serviceId , int index, int size){
		
		Map<String, Object> param = new HashMap<>();
		
		param.put("serviceId", serviceId);
		
		PageBounds pageBounds = new PageBounds(index, size, Order.formString(" create_time.desc "));
		
		return extCommunityServiceCommentMapper.pageCommunityServiceCommnet(param, pageBounds);
	}
}
