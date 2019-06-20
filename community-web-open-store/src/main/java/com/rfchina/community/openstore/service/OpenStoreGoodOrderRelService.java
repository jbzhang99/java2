package com.rfchina.community.openstore.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.rfchina.community.base.OrderPayConstant;
import com.rfchina.community.service.openser.OpenStoreGoodOrderRelBaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.openstore.entity.ext.ParamOpenStoreGood;
import com.rfchina.community.persistence.mapper.OpenStoreGoodOrderRelMapper;
import com.rfchina.community.persistence.model.OpenStoreGood;
import com.rfchina.community.persistence.model.OpenStoreGoodOrderRel;
import com.rfchina.community.persistence.model.OpenStoreGoodOrderRelExample;
import com.rfchina.community.service.openser.OpenStoreVerifyCardService;
import com.rfchina.community.service.openser.entity.OpenStoreGoodOrderRelVO;
/**
 * @author:fukangwen
 * @Description: 商品-订单 关联service
 */
@Service
public class OpenStoreGoodOrderRelService extends OpenStoreGoodOrderRelBaseService {

	@Autowired
	private OpenStoreGoodOrderRelMapper openStoreGoodOrderRelMapper;
	@Autowired
	private OpenStoreGoodService openStoreGoodService;
	@Autowired
	private OpenStoreVerifyCardService openStoreVerifyCardService;
	
	/**
	 * @author:fukangwen
	 * @Description: 新增关联商品订单记录
	 * @return void
	 * @throws
	 */
	public void createGoodOrderRel(int orderId, List<ParamOpenStoreGood> list) {
		for(ParamOpenStoreGood good : list) {
			
			OpenStoreGoodOrderRel rel = new OpenStoreGoodOrderRel();
			BeanUtils.copyProperties(good, rel);
			OpenStoreGood openStoreGood = openStoreGoodService.getById(good.getGoodId());
			rel.setOrderId(orderId);
			rel.setCurrentSinglePrice(good.getGoodPrice());
			rel.setGoodCode(openStoreGood.getCode());
			rel.setGoodName(openStoreGood.getName());
			//新增4个状态
			rel.setPayStatus(OrderPayConstant.PayStatus.NO_PAYMENT.getCode());
			rel.setVerifyTimes(openStoreGood.getVerifyTimes()==null ? 0 : openStoreGood.getVerifyTimes());
			rel.setVerifyStartTime(openStoreGood.getVerifyStartTime());
			rel.setVerifyEndTime(openStoreGood.getVerifyEndTime());
			
			String[] urls = openStoreGood.getPicUrl().split(",");
			rel.setGoodImgUrl(urls[0]);
			openStoreGoodOrderRelMapper.insert(rel);
		}
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

	/**
	 * @author:fukangwen
	 * @Description: 更新商品订单关联表快照，生成核销单
	 * @return void
	 * @throws
	 */
	public void update(int orderId, long uid, int payStatus, BigDecimal originalPrice, BigDecimal totalAmount, int serviceId) {
		
		OpenStoreGoodOrderRelExample example = new OpenStoreGoodOrderRelExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		List<OpenStoreGoodOrderRel> list = openStoreGoodOrderRelMapper.selectByExample(example);
		if(list.isEmpty())
			return;
		
		BigDecimal scaleValue = totalAmount.divide(originalPrice, 2, BigDecimal.ROUND_HALF_UP);
		for(OpenStoreGoodOrderRel rel : list) {
			rel.setPayStatus(payStatus);
			openStoreGoodOrderRelMapper.updateByPrimaryKeySelective(rel);
			
			//可核销次数大于0，新增核销信息
			if(rel.getVerifyTimes() != null && rel.getVerifyTimes() > 0) {
				BigDecimal singleScaleValue = rel.getCurrentSinglePrice().multiply(scaleValue).
						divide(new BigDecimal(rel.getVerifyTimes()),2,BigDecimal.ROUND_DOWN);
				if(singleScaleValue.compareTo(BigDecimal.valueOf(0.01)) < 0) {
					singleScaleValue = BigDecimal.valueOf(0.00);
				}
				openStoreVerifyCardService.insertVerifyCards(uid, rel, singleScaleValue, serviceId);
			}
		}
	}

	public int getAmount(int orderId, int goodId){
		OpenStoreGoodOrderRelExample example = new OpenStoreGoodOrderRelExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		List<OpenStoreGoodOrderRel> list = openStoreGoodOrderRelMapper.selectByExample(example);
		if(list.isEmpty())
			return 0;
		for(OpenStoreGoodOrderRel rel : list) {
			if(goodId == rel.getGoodId().intValue()){
				return rel.getAmount();
			}
		}

		return 0;
	}



}
