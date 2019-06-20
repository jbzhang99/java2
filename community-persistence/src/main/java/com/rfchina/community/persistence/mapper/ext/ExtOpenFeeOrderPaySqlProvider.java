package com.rfchina.community.persistence.mapper.ext;

import java.util.Map;

import com.rfchina.community.persistence.mapper.OpenFeeOrderPaySqlProvider;

/**
 */
public class ExtOpenFeeOrderPaySqlProvider extends OpenFeeOrderPaySqlProvider {

    public String pageByCondition(Map<String, Object> param) {
    	StringBuffer sql = new StringBuffer("select _pay.*, _service.title service_name, _info.title merchant_name from open_fee_order_pay _pay ");
    	sql.append(" LEFT JOIN community_service _service on _pay.service_id=_service.id ");
    	sql.append(" LEFT JOIN open_merchant_info _info on _info.id=_service.merchant_id where 1=1 and _pay.pay_status in('auditing','success','reject')");
    	if(param.get("serviceId") != null) {
    		sql.append(" and _pay.service_id=#{serviceId} ");
    	}
    	if(param.get("merchantName") != null) {
    		sql.append(" and _info.title like #{merchantName} ");
    	}
    	if(param.get("outTradeNo") != null) {
    		sql.append(" and _pay.out_trade_no like  #{outTradeNo} ");
    	}
    	if(param.get("payStatus") != null) {
    		sql.append(" and _pay.pay_status=  #{payStatus} ");
    	}
    	
    	if(param.get("startCreateTime") != null) {
    		sql.append(" and _pay.create_time > #{startCreateTime} ");
    	}
    	
    	if(param.get("endCreateTime") != null) {
    		sql.append(" and _pay.create_time <  #{endCreateTime} ");
    	}
    	
    	sql.append(" order by _pay.id desc");
    	
        return sql.toString();
    }
    
}
