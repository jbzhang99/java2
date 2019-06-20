package com.rfchina.community.openweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.OpenStoreGoodOrderRelMapper;
import com.rfchina.community.persistence.model.OpenStoreGoodOrderRel;
import com.rfchina.community.persistence.model.OpenStoreGoodOrderRelExample;
import com.rfchina.community.service.openser.OpenStoreVerifyCardService;
import com.rfchina.community.service.openser.entity.OpenStoreGoodOrderRelVO;
/**
 * @author:fukangwen
 * @Description: 商品-订单 关联service
 */
@Service
public class OpenStoreGoodOrderRelService {

	@Autowired
	private OpenStoreGoodOrderRelMapper openStoreGoodOrderRelMapper;
	@Autowired
	private OpenStoreGoodService openStoreGoodService;
	@Autowired
	private OpenStoreVerifyCardService openStoreVerifyCardService;
	

	/**
	 * @author:fukangwen
	 * @Description: 获取订单中商品的详情
	 * @return List<OpenStoreGoodOrderRel>
	 * @throws
	 */
	public List<OpenStoreGoodOrderRel> getList(int orderId) {
		OpenStoreGoodOrderRelExample example = new OpenStoreGoodOrderRelExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		
		return openStoreGoodOrderRelMapper.selectByExample(example);
	}
	
	public List<OpenStoreGoodOrderRelVO> getVOList(int orderId){
		List<OpenStoreGoodOrderRel> relList = getList(orderId);
		List<OpenStoreGoodOrderRelVO> voList = new ArrayList<OpenStoreGoodOrderRelVO>();
		for(OpenStoreGoodOrderRel rel : relList) {
			OpenStoreGoodOrderRelVO vo = new OpenStoreGoodOrderRelVO();
			BeanUtils.copyProperties(rel, vo);
			// 支付成功 
			vo.setVerifyCardVOList(openStoreVerifyCardService.getList(vo));
			voList.add(vo);
		}
		return voList;
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 获取订单中商品的第一个图
	 * @return List<String>
	 * @throws
	 */
	public List<String> getImgList(int orderId) {
		OpenStoreGoodOrderRelExample example = new OpenStoreGoodOrderRelExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		List<OpenStoreGoodOrderRel> list = openStoreGoodOrderRelMapper.selectByExample(example);
		List<String> imgList = new ArrayList<String>();
		for(OpenStoreGoodOrderRel rel : list) {
			imgList.add(rel.getGoodImgUrl());
		}
		return imgList;
	}
}
