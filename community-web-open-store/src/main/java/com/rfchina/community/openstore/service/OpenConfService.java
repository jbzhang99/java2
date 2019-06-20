package com.rfchina.community.openstore.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.BonusPointActionRuleMapper;
import com.rfchina.community.persistence.mapper.OpenConfMapper;
import com.rfchina.community.persistence.mapper.OpenFirstPointRecordMapper;
import com.rfchina.community.persistence.mapper.OpenPointRecordMapper;
import com.rfchina.community.persistence.model.BonusPointActionRule;
import com.rfchina.community.persistence.model.BonusPointActionRuleExample;
import com.rfchina.community.persistence.model.OpenConf;
import com.rfchina.community.persistence.model.OpenConfExample;
import com.rfchina.community.persistence.model.OpenFirstPointRecordExample;
import com.rfchina.community.persistence.model.OpenPointRecord;

/**
 * @author:fukangwen
 * @Description: 配置开关service
 */
@Service
public class OpenConfService {
	
	@Autowired
	private OpenConfMapper openConfMapper;
	@Autowired
	private BonusPointActionRuleMapper bonusPointActionRuleMapper;
	@Autowired
	private OpenPointRecordMapper openPointRecordMapper;
	@Autowired
	private OpenFirstPointRecordMapper openFirstPointRecordMapper;
	
	public static final int CODE_VALID = 1;//有效
	public static final int CODE_INVALID = 0;//无效
	
	@Value("${point.limit.money}")
	private String LIMIT_MONEY;//超过10元才送积分 ,测试1块
	/**
	 * @author:fukangwen
	 * @Description: 获取开关状态，
	 * @return Boolean
	 * @throws
	 */
	public Boolean getCodeByType(String type) {
		OpenConfExample example = new OpenConfExample();
		example.createCriteria().andTypeEqualTo(type);
		List<OpenConf> list = openConfMapper.selectByExample(example);
		if(list.isEmpty())
			return false;//默认关闭
		if(Integer.parseInt(list.get(0).getCode()) == CODE_VALID)
			return true;
		
		return false;
	}
	
	public enum Type{
		POINT,FIRST_POINT,POS
	}
	public enum Action{
		OPEN_PAY, OPEN_PAY_FIRST
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 获取赠送积分信息文案
	 * @return String
	 * @throws
	 */
	public int getOpenPoint(BigDecimal price) {
		int total = 0;
		if(this.getCodeByType(Type.POINT.toString()) && new BigDecimal(LIMIT_MONEY).compareTo(price) <= 0)
			total += getPoint(price, Action.OPEN_PAY.toString());
		
		if(this.getCodeByType(Type.FIRST_POINT.toString()))
			total += getPoint(price, Action.OPEN_PAY_FIRST.toString());
		
		return total;
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 获取积分
	 * @return int
	 * @throws
	 */
	private int getPoint(BigDecimal price, String type) {
		BonusPointActionRuleExample example = new BonusPointActionRuleExample();
		example.createCriteria().andActiveEqualTo(true).andActionEqualTo(type);
		List<BonusPointActionRule> list = bonusPointActionRuleMapper.selectByExample(example);
		if(list.isEmpty())
			return 0;
		BonusPointActionRule rule = list.get(0);
		if(Action.OPEN_PAY.toString().equals(type)) {
			return price.intValue() * rule.getBpValue();
		}
		
		if(Action.OPEN_PAY_FIRST.toString().equals(type)) {
			return rule.getBpValue();
		}
		return 0;
	}

	public int getOpenPointByOrderId(Long orderId, Long uid) {
		int total = 0;
		OpenPointRecord record = openPointRecordMapper.selectByPrimaryKey(orderId);
		if(record == null)
			return total;
		
		BigDecimal totalAmount = record.getTotalAmount();
		//最低起送价格
		if(new BigDecimal(LIMIT_MONEY).compareTo(totalAmount) > 0)
			return total;
		
		if(Integer.parseInt(record.getOpenConfCode()) == CODE_VALID) {
			total += getPoint(totalAmount, Action.OPEN_PAY.toString());
		}
		
		//这里要判断是不是第一次支付
		if(Integer.parseInt(record.getOpenConfFirstCode()) == CODE_VALID && isFirst(uid )) {
			total += getPoint(totalAmount, Action.OPEN_PAY_FIRST.toString());
		}
		
		return total;
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 判断该订单是不是首单
	 * @return Boolean
	 * @throws
	 */
	public Boolean isFirst(Long uid) {
		OpenFirstPointRecordExample example = new OpenFirstPointRecordExample();
		example.createCriteria().andUidEqualTo(uid);
		return openFirstPointRecordMapper.countByExample(example) > 0 ? false : true;
	}
	
}
