package com.rfchina.community.persistence.mapper.ext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 */
public class ExtStatCommunityAttentionSqlProvider {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public String statCommunityAttention(Map<String, Object> param) {
        StringBuilder stringBuilder1 = new StringBuilder(" SELECT ");
        stringBuilder1.append(" b.area_id, a.community_id, b.type as community_type, ")
                .append(" sum(case when a.add_type = 1 then 1 else 0 end) as current_app_user_count, ")
                .append(" sum(case when a.add_type = 2 then 1 else 0 end) as current_server_user_count, ")
                .append(" 0 as incr_app_user_count, ")
                .append(" 0 as incr_server_user_count, ")
                //.append(" sum(case when a.add_type = 1 and a.create_time >=#{startTime,jdbcType=TIMESTAMP} and a.create_time <= #{endTime,jdbcType=TIMESTAMP} then 1 else 0 end) as incr_app_user_count, ")
                //.append(" sum(case when a.add_type = 2 and a.create_time >=#{startTime,jdbcType=TIMESTAMP} and a.create_time <= #{endTime,jdbcType=TIMESTAMP} then 1 else 0 end) as incr_server_user_count, ")
                .append(" 0 as del_app_user_count, ")
                .append(" 0 as del_server_user_count ")
                .append(" FROM community_attention a LEFT JOIN community b ON a.community_id = b.id ")
                .append(" WHERE a.create_time <= #{endTime,jdbcType=TIMESTAMP} ");

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(" SELECT ")
                .append(" area_id, community_id, type AS community_type, ")
                .append(" 0 as current_app_user_count, ")
                .append(" 0 as current_server_user_count, ")
                .append(" sum(CASE WHEN add_type = 1 AND opt_type = 1 THEN 1 ELSE 0 END) as incr_app_user_count,")
                .append(" sum(CASE WHEN add_type = 2 AND opt_type = 1 THEN 1 ELSE 0 END) as incr_server_user_count, ")
                .append(" sum(CASE WHEN add_type = 1 AND opt_type = 2 THEN 1 ELSE 0 END) AS del_app_user_count, ")
                .append(" sum(CASE WHEN add_type = 2 AND opt_type = 2 THEN 1 ELSE 0 END) AS del_server_user_count ")
                .append(" FROM( ")
                .append(" select distinct b.area_id, a.community_id, b.type, a.uid, a.opt_type, a.add_type  ")
                .append(" from community_attention_flow a left join community b ")
                .append(" on a.community_id = b.id ")
                .append(" where a.create_time >=#{startTime,jdbcType=TIMESTAMP} and a.create_time <= #{endTime,jdbcType=TIMESTAMP} ")
                .append(" ) k ");

        StringBuilder stringBuilder = new StringBuilder(" SELECT area_id, community_id, community_type,");
        stringBuilder.append(" sum(current_app_user_count) as current_app_user_count,")
                .append(" sum(current_server_user_count) as current_server_user_count, ")
                .append(" sum(incr_app_user_count) as incr_app_user_count, ")
                .append(" sum(incr_server_user_count) as incr_server_user_count, ")
                .append(" sum(del_app_user_count) as del_app_user_count, ")
                .append(" sum(del_server_user_count) as del_server_user_count")
                .append(" from ( ")
                .append(stringBuilder1)
                .append(" union all ")
                .append(stringBuilder2)
                .append(" ) z ");
        String sqlStr = stringBuilder.toString();
        logger.info("statCommunityAttention: {}", sqlStr);
        return sqlStr;
    }
}
