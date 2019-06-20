package com.rfchina.community.brothers.mapper.ext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.rfchina.community.base.Constant;
import com.rfchina.community.persistence.mapper.AdSqlProvider;
import com.rfchina.community.persistence.model.AdExample;

/**
 */
public class ExtOpenPointRecordSqlProvider extends AdSqlProvider {


	/**
	 * @author:fukangwen
	 * @Description: 支付成功，且积分记录为未送
	 * @return String
	 * @throws
	 */
    public String increasePointList(Map<String, Object> param) {
    	BigDecimal lIMIT_MONEY = (BigDecimal)param.get("lIMIT_MONEY");
    	lIMIT_MONEY = lIMIT_MONEY.setScale(2, BigDecimal.ROUND_HALF_DOWN);
    	String sql = "SELECT" + 
    			"	_record.*, _order.community_id," + 
    			"	_order.account_id," + 
    			"	_order.app_id" + 
    			" FROM" + 
    			"	open_point_record _record," + 
    			"	open_order _order" + 
    			"   WHERE" + 
    			"	_record.order_id = _order.id" + 
    			" AND _record. STATUS = 0" + 
    			" AND _order.bill_status = 2" +
    			" AND _order.total_amount >= " + lIMIT_MONEY;
    	return sql;
    }
    
    /**
     * @author:fukangwen
     * @Description: 退款成功，且积分记录为已送
     * @return String
     * @throws
     */
    public String decreasePointList() {
    	String sql = "SELECT" + 
    			"	_record.*, _order.community_id," + 
    			"	_order.account_id," + 
    			"	_order.app_id" + 
    			" FROM" + 
    			"	open_point_record _record," + 
    			"	open_order _order" + 
    			"   WHERE" + 
    			"	_record.order_id = _order.id" + 
    			" AND _record. STATUS = 1" + 
    			" AND _order.refund_status = 2";
    	return sql;
    }
}
