package com.rfchina.community.persistence.mapper.ext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 */
public class ExtStatRepairOrderSqlProvider {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public String statRepairOrder(Map<String, Object> param) {
        StringBuilder sqlBuilder = new StringBuilder(" select area_id, community_id, community_type, ");
        sqlBuilder.append(" sum(repair_user_count) as repair_user_count, ");
        sqlBuilder.append(" sum(repair_room_count) as repair_room_count,  ");
        sqlBuilder.append(" sum(repair_order_count) as repair_order_count, ");
        sqlBuilder.append(" sum(issue_user_count) as issue_user_count, ");
        sqlBuilder.append(" sum(issue_room_count) as issue_room_count, ");
        sqlBuilder.append(" sum(issue_order_count) as issue_order_count from ( ");
        sqlBuilder.append(" select                                                            ")
                .append(" d.area_id,                                                          ")
                .append(" a.community_id as community_id,                                     ")
                .append(" d.type as community_type,                                           ")
                .append(" count(distinct a.uid) as repair_user_count,                         ")
                .append(" count(distinct c.id) as repair_room_count,                          ")
                .append(" count(a.id) as repair_order_count,                                  ")
                .append(" 0 as issue_user_count,                                              ")
                .append(" 0 as issue_room_count,                                              ")
                .append(" 0 as issue_order_count                                              ")
                .append(" from repair_record a                                                ")
                .append(" join master_child b on a.master_child_id = b.id                     ")
                .append(" join master_info c on b.master_id = c.id                            ")
                .append(" join community d on a.community_id = d.id                           ")
                .append(" where a.form_type is not null                                       ")
                .append(" and a.create_time >= #{startTime,jdbcType=TIMESTAMP}                ")
                .append(" and a.create_time <= #{endTime,jdbcType=TIMESTAMP}                  ")
                .append(" and a.form_type = 1                                                 ")
                .append(" group by area_id, community_id, community_type                      ");
        sqlBuilder.append(" union all ");
        sqlBuilder.append(" select                                                            ")
                .append(" d.area_id,                                                          ")
                .append(" a.community_id as community_id,                                     ")
                .append(" d.type as community_type,                                           ")
                .append(" 0 as repair_user_count,                                             ")
                .append(" 0 as repair_room_count,                                             ")
                .append(" 0 as repair_order_count,                                            ")
                .append(" count(distinct a.uid) as issue_user_count,                          ")
                .append(" count(distinct c.id) as issue_room_count,                           ")
                .append(" count(a.id) as issue_order_count                                    ")
                .append(" from repair_record a                                                ")
                .append(" join master_child b on a.master_child_id = b.id                     ")
                .append(" join master_info c on b.master_id = c.id                            ")
                .append(" join community d on a.community_id = d.id                           ")
                .append(" where a.form_type is not null                                       ")
                .append(" and a.create_time >= #{startTime,jdbcType=TIMESTAMP}                ")
                .append(" and a.create_time <= #{endTime,jdbcType=TIMESTAMP}                  ")
                .append(" and a.form_type = 2                                                 ")
                .append(" group by area_id, community_id, community_type                      ");
        sqlBuilder.append(" ) k group by area_id, community_id, community_type ");
        String sql = sqlBuilder.toString();
        logger.info("statRepairOrder sql: {}", sql);
        return sql;
    }
}
