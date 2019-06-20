package com.rfchina.community.open.bridge.mapper.ext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ExtOpenStatsSqlProvider {

	private static transient Logger logger = LoggerFactory.getLogger(ExtOpenStatsSqlProvider.class);
	
	public String totalAmountByYear(Map<String, Object> param){
		StringBuffer sb = new StringBuffer("select IFNULL(sum(total_amount),0) from open_order  where  bill_status=2");
		if(param.get("syear") != null){
			sb.append(" and year(create_time) = #{syear}");
		}
		logger.info("SQL："+sb.toString());
		return sb.toString();
	}
	
	//线下保证金
	public String totalAmountPicCaution(Map<String, Object> param){
		StringBuffer sb = new StringBuffer("select IFNULL(sum(money),0) from open_caution_info where status=4");
		if(param.get("syear") != null){
			sb.append(" and year(pay_time) = #{syear}");
		}
		logger.info("SQL："+sb.toString());
		return sb.toString();
	}
}
