package com.rfchina.community.persistence.mapper.ext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 */
public class ExtStatAttUserSqlProvider {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public String statAttUser(Map<String, Object> param) {
        StringBuilder sqlBuilder = new StringBuilder(" select area_id, community_type, community_id, ");
        sqlBuilder.append(" sum(acc_count) as acc_count, ")
                .append(" sum(cur_count) as cur_count from (")
                .append(" select c.area_id, c.type as community_type, a.community_id, ")
                .append(" count(distinct a.uid) as acc_count, ")
                .append(" 0 as cur_count ")
                .append(" from community_attention_flow a ")
                .append(" left join community c on c.id = a.community_id ")
                .append(" where a.opt_type = 1 and a.create_time <= #{statTime,jdbcType=TIMESTAMP} ")
                .append(" group by c.area_id, c.type, a.community_id ")
                .append(" union all ")
                .append(" select d.area_id, d.type as community_type, b.community_id, ")
                .append(" 0 as acc_count, count(distinct b.uid) as cur_count ")
                .append(" from community_attention b ")
                .append(" left join community d on d.id = b.community_id ")
                .append(" where b.create_time <= #{statTime,jdbcType=TIMESTAMP} ")
                .append(" group by d.area_id, d.type, b.community_id ")
                .append(" ) k group by k.area_id, k.community_type, k.community_id ")
                .append("");

        String sql = sqlBuilder.toString();
        logger.info("statAttUser: {}", sql);
        return sql;
    }
}
