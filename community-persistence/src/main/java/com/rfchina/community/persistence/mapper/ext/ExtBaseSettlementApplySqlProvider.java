package com.rfchina.community.persistence.mapper.ext;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.rfchina.community.persistence.mapper.BaseSettlementApplySqlProvider;
import com.rfchina.community.persistence.model.BaseSettlementApplyExample;

public class ExtBaseSettlementApplySqlProvider extends BaseSettlementApplySqlProvider{

	public String pageByExample(Map<String, Object> param){
		BaseSettlementApplyExample example = (BaseSettlementApplyExample) param.get("example");
		SQL sql = new SQL();
        
        sql.SELECT(" * ");
        sql.FROM("base_settlement_apply");
        applyWhere(sql, example, true);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
	}
}
