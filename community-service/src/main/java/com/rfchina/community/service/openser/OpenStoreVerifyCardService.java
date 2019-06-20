package com.rfchina.community.service.openser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.persistence.mapper.OpenStoreOrderMapper;
import com.rfchina.community.persistence.mapper.OpenStoreVerifyCardMapper;
import com.rfchina.community.persistence.model.OpenStoreGoodOrderRel;
import com.rfchina.community.persistence.model.OpenStoreOrder;
import com.rfchina.community.persistence.model.OpenStoreVerifyCard;
import com.rfchina.community.persistence.model.OpenStoreVerifyCardExample;
import com.rfchina.community.service.BaseService;
import com.rfchina.community.service.openser.entity.OpenStoreGoodOrderRelVO;
import com.rfchina.community.service.openser.entity.VerifyCardVO;
/**
 * @author:fukangwen
 * @Description: 订单券核销service
 */
@Service
public class OpenStoreVerifyCardService extends BaseService{

	@Autowired
	private OpenStoreVerifyCardMapper openStoreVerifyCardMapper;
	@Autowired
	private OpenStoreOrderMapper openStoreOrderMapper;
	
	public static int CODE_LENTH = 12;
	
	public void insertVerifyCards(long uid, OpenStoreGoodOrderRel rel, BigDecimal singleScaleValue, int serviceId) {
		int amount = rel.getAmount() * rel.getVerifyTimes();
		for(int i = 0; i < amount; i++) {
			this.insert(uid, rel, singleScaleValue,serviceId);
		}
	}
	
	private void insert(long uid, OpenStoreGoodOrderRel rel, BigDecimal singleScaleValue, int serviceId) {
		OpenStoreVerifyCard card = new OpenStoreVerifyCard();
		card.setCreateTime(new Date());
		card.setGoodId(rel.getGoodId());
		card.setGoodName(rel.getGoodName());
		card.setGoodOrderRelId(rel.getId());
		card.setOrderId(rel.getOrderId());
		card.setUid(uid);
		card.setGoodCode(rel.getGoodCode());
		card.setVerifyStartTime(rel.getVerifyStartTime());
		card.setVerifyEndTime(rel.getVerifyEndTime());
		card.setVerifyStatus(OpenConstant.VerifyStatus.UN_USE);
		card.setSingleScalePrice(singleScaleValue);
		card.setServiceId(serviceId);
		openStoreVerifyCardMapper.insertSelective(card);
		
		String code = this.generateCode(card.getId(), CODE_LENTH);
		card.setCode(code); 
		openStoreVerifyCardMapper.updateByPrimaryKeySelective(card);
	}

	/**
	 * @author:fukangwen
	 * @Description: 生成核销码
	 * @return String
	 * @throws
	 */
	public static String generateCode(Long id, int lenth) {
		String idStr = String.valueOf(id);
		int idLenth = idStr.length();
		if(lenth  <= idLenth + 1) {	//留一位随机数
			lenth = idLenth + 2;
		}
		
		//生成规则，（1~9） + “0” + id = 总共lenth位
		StringBuffer sb = new StringBuffer();
		sb.append(RandomStringUtils.random(lenth-idLenth-1, "123456789"));
		sb.append("0");
		sb.append(idStr);
		return sb.toString();
	}
	
	
	/**
	 * @author:fukangwen
	 * @Description: 
	 * @return List<VerifyCardVO>
	 * @throws
	 */
	public List<VerifyCardVO> getList(OpenStoreGoodOrderRelVO vo) {
		OpenStoreVerifyCardExample example = new OpenStoreVerifyCardExample();
		example.createCriteria().andGoodOrderRelIdEqualTo(vo.getId());
		List<OpenStoreVerifyCard> list = openStoreVerifyCardMapper.selectByExample(example);
		List<VerifyCardVO> cardList = new ArrayList<VerifyCardVO>();
		for(OpenStoreVerifyCard card : list) {
			VerifyCardVO cardVO = new VerifyCardVO();
			BeanUtils.copyProperties(card, cardVO);
			cardVO.setVerifyStatus(this.getVerifyStatus(card.getVerifyStartTime(), card.getVerifyEndTime(), card.getVerifyStatus()));
			cardList.add(cardVO);
		}
		return cardList;
	}
	
	public VerifyCardVO getVerifyCardVO(String code, int serviceId) {
		OpenStoreVerifyCardExample example = new OpenStoreVerifyCardExample();
		example.createCriteria().andCodeEqualTo(code).andServiceIdEqualTo(serviceId);
		List<OpenStoreVerifyCard> list = openStoreVerifyCardMapper.selectByExample(example);
		if(list.isEmpty() || list.size() > 1) {
			return null;
		}
		OpenStoreVerifyCard card = list.get(0);
		VerifyCardVO cardVO = new VerifyCardVO();
		BeanUtils.copyProperties(card, cardVO);
		cardVO.setVerifyStatus(this.getVerifyStatus(card.getVerifyStartTime(), card.getVerifyEndTime(), card.getVerifyStatus()));
		return cardVO;
	}

	/**
	 * @author:fukangwen
	 * @Description: 获取核销状态
	 * @return Integer
	 * @throws
	 */
	public Integer getVerifyStatus(Date verifyStartTime, Date verifyEndTime, int verifyStatus) {
		if(verifyStartTime == null || verifyEndTime == null)
			return OpenConstant.VerifyStatus.INVALID;
		
		long now = System.currentTimeMillis();
		//还未核销，且未到核销时间
		if(verifyStatus == 0 && verifyStartTime.getTime() > now) {
			return OpenConstant.VerifyStatus.NEVER_START;
		}
		
		//未核销，但已过核销时间
		if(verifyStatus == 0 && verifyEndTime.getTime() < now) {
			return OpenConstant.VerifyStatus.INVALID;
		}
		return verifyStatus;
	}

	/**
	 * @author:fukangwen
	 * @Description: 该订单是否需要有核销内容
	 * @return Boolean
	 * @throws
	 */
	public Boolean isNeedVerify(int orderId) {
		OpenStoreVerifyCardExample example = new OpenStoreVerifyCardExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		long count = openStoreVerifyCardMapper.countByExample(example);
		if(count > 0)
			return true;
		
		return false;
	}

	public void verify(long id, int serviceId) {
		OpenStoreVerifyCardExample example = new OpenStoreVerifyCardExample();
		example.createCriteria().andIdEqualTo(id).andServiceIdEqualTo(serviceId);
		List<OpenStoreVerifyCard> list = openStoreVerifyCardMapper.selectByExample(example);
		validator(list.isEmpty(), "核销券不存在");
		OpenStoreVerifyCard card = list.get(0);
		
		//根据订单，看订单是否未发生退款
		OpenStoreOrder order = openStoreOrderMapper.selectByPrimaryKey(card.getOrderId());
		validator(order.getRefundStatus() == 1 ||  order.getRefundStatus() == 2, "该卡券关联的订单有退款或正在退款中，不能核销");
		
		long now = System.currentTimeMillis();
		//还未核销，且未到核销时间
		validator(card.getVerifyStartTime().getTime() > now, "还未到核销时间");
		
		//未核销，但已过核销时间,或已核销
		validator(card.getVerifyStatus() == 1 || card.getVerifyEndTime().getTime() < now, "核销失败，部分卡券已被核销或失效");
		
		card.setVerifyStatus(OpenConstant.VerifyStatus.USED);
		card.setVerifyTime(new Date());
		openStoreVerifyCardMapper.updateByPrimaryKeySelective(card);
	}
	
	public String hideCode(String str) {
		if(StringUtils.isBlank(str))
			return str;
		return str.substring(0,4)+ "****"+str.substring(8,str.length());
	}
	
	

}
