package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.CommunityAttentionSqlProvider;
import com.rfchina.community.persistence.model.CommunityAttentionExample;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 */
public class ExtCommunityAttentionSqlProvider extends CommunityAttentionSqlProvider {

    public String pageByExample(Map<String, Object> param) {
        CommunityAttentionExample example = (CommunityAttentionExample) param.get("example");
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("uid");
        } else {
            sql.SELECT("uid");
        }
        sql.SELECT("community_id");
        sql.SELECT("create_time");
        sql.SELECT("idx_seq");
        sql.SELECT("add_type");
        sql.FROM("community_attention");
        applyWhere(sql, example, true);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }
}
