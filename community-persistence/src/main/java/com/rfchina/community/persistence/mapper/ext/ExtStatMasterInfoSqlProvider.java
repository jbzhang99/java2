package com.rfchina.community.persistence.mapper.ext;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 */
public class ExtStatMasterInfoSqlProvider {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public String statMasterUserInfoRegister(Map<String, Object> param) {
/*        SQL sql = new SQL();
        sql.SELECT("c.area_id");
        sql.SELECT("c.community_id");
        sql.SELECT("c.type as community_type");
        sql.SELECT("count(DISTINCT a.uid) as user_count");
        sql.SELECT("sum(case a.type when 1 then 1 else 0 end) as owner_count");
        sql.SELECT("sum(case a.type when 2 then 1 else 0 end) as tenant_count");
        sql.SELECT("sum(case a.type when 3 then 1 else 0 end) as biz_owner_count");
        sql.SELECT("sum(case a.type when 4 then 1 else 0 end) as family_count");
        sql.SELECT("sum(case a.staff_type when 1 then 1 else 0 end) as staff_count");
        sql.SELECT("sum(case a.staff_type when 2 then 1 else 0 end) as site_staff_count");
        sql.SELECT("0 as other_count");
        sql.FROM("master_child a");
        sql.LEFT_OUTER_JOIN("user_info b ON a.uid = b.id");
        sql.JOIN("master_info c ON c.id = a.master_id");
        sql.JOIN("community d ON c.community_id = d.id");

        sql.GROUP_BY("c.area_id, c.community_id, c.type");*/
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append(" select area_id, prop_type, community_id, community_type, ")
                .append(" sum(user_count) as user_count,")
                .append(" sum(room_count) as room_count,")
                .append(" sum(parking_count) as parking_count,")
                .append(" sum(owner_count) as owner_count, ")
                .append(" sum(tenant_count) as tenant_count,")
                .append(" sum(biz_owner_count) as biz_owner_count, ")
                .append(" sum(family_count) as family_count, ")
                .append(" sum(staff_count) as staff_count, ")
                .append(" sum(site_staff_count) as site_staff_count, ")
                .append(" other_count ")
                .append(" from ( ")
                .append(" SELECT d.area_id, k.prop_type, a.community_id, d.type as community_type, ")
                .append(" count(DISTINCT case when b.uid!=0 then b.uid else null end) as user_count, ")
                .append(" count(DISTINCT case when b.uid!=0 and a.type != 3 then b.uid else null end) as room_count, ")
                .append(" count(DISTINCT case when b.uid!=0 and a.type = 3 then b.uid else null end) as parking_count, ")
                .append(" count(distinct case when b.type = 1 and b.uid!=0 then b.id else null end) as owner_count, ")
                .append(" count(distinct case when b.type = 2 and b.uid!=0 then b.id else null end) as tenant_count, ")
                .append(" count(distinct case when b.type = 3 and b.uid!=0 then b.id else null end) as biz_owner_count, ")
                .append(" count(distinct case when b.type = 4 and b.uid!=0 then b.id else null end) as family_count, ")
                .append(" count(distinct case when b.staff_type = 1 and b.uid!=0 and a.type= 1 then b.id else null end) as staff_count, ")
                .append(" count(distinct case when b.staff_type = 2 and b.uid!=0 and a.type= 1 then b.id else null end) as site_staff_count, ")
                .append(" 0 as other_count ")
                .append(" FROM master_info a ")
                .append(" JOIN building_info k ON a.building_id = k.id ")
                .append(" JOIN master_child b ON a.id = b.master_id ")
                .append(" JOIN community d ON a.community_id = d.id ");
            sqlBuilder.append(" JOIN user_info e ON e.id = b.uid ")
                    .append(" WHERE a.create_time < #{statDate,jdbcType=TIMESTAMP} ")
                    .append(" AND e.create_time < #{statDate,jdbcType=TIMESTAMP} ")
                    .append(" or a.create_time is null ")
                    .append(" or e.create_time is null ");
        sqlBuilder.append(" GROUP BY d.area_id, k.prop_type, a.community_id, d.type ")
                .append(" ) k group by area_id, prop_type, community_id, community_type ");
        String sqlStr = sqlBuilder.toString();
        logger.info("statMasterUserInfoRegister:{}", sqlStr);
        return sqlStr;
    }

    public String statMasterUserInfoImport(Map<String, Object> param) {
/*        SQL sql = new SQL();
        sql.SELECT("c.area_id");
        sql.SELECT("c.community_id");
        sql.SELECT("c.type as community_type");
        sql.SELECT("count(DISTINCT a.uid) as user_count");
        sql.SELECT("sum(case a.type when 1 then 1 else 0 end) as owner_count");
        sql.SELECT("sum(case a.type when 2 then 1 else 0 end) as tenant_count");
        sql.SELECT("sum(case a.type when 3 then 1 else 0 end) as biz_owner_count");
        sql.SELECT("sum(case a.type when 4 then 1 else 0 end) as family_count");
        sql.SELECT("sum(case a.staff_type when 1 then 1 else 0 end) as staff_count");
        sql.SELECT("sum(case a.staff_type when 2 then 1 else 0 end) as site_staff_count");
        sql.SELECT("0 as other_count");
        sql.FROM("master_child a");
        sql.LEFT_OUTER_JOIN("user_info b ON a.uid = b.id");
        sql.JOIN("master_info c ON c.id = a.master_id");
        sql.JOIN("community d ON c.community_id = d.id");

        sql.GROUP_BY("c.area_id, c.community_id, c.type");*/
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append(" select area_id, prop_type, community_id, community_type, ")
                .append(" 0 as room_coumt,")
                .append(" 0 as parking_count,")
                .append(" sum(user_count) as user_count,")
                .append(" sum(owner_count) as owner_count, ")
                .append(" sum(tenant_count) as tenant_count,")
                .append(" sum(biz_owner_count) as biz_owner_count, ")
                .append(" sum(family_count) as family_count, ")
                .append(" sum(staff_count) as staff_count, ")
                .append(" sum(site_staff_count) as site_staff_count, ")
                .append(" other_count ")
                .append(" from ( ")
                .append(" SELECT d.area_id, k.prop_type, a.community_id, d.type as community_type, ")
                .append(" count(DISTINCT case when b.uid!=0 then b.uid else null end) as user_count, ")
                .append(" count(distinct case when b.type = 1 and b.uid!=0 then b.id else null end) as owner_count, ")
                .append(" count(distinct case when b.type = 2 and b.uid!=0 then b.id else null end) as tenant_count, ")
                .append(" count(distinct case when b.type = 3 and b.uid!=0 then b.id else null end) as biz_owner_count, ")
                .append(" count(distinct case when b.type = 4 and b.uid!=0 then b.id else null end) as family_count, ")
                .append(" count(distinct case when b.staff_type = 1 and b.uid!=0 and a.type= 1 then b.id else null end) as staff_count, ")
                .append(" count(distinct case when b.staff_type = 2 and b.uid!=0 and a.type= 1 then b.id else null end) as site_staff_count, ")
                .append(" 0 as other_count ")
                .append(" FROM master_info a ")
                .append(" JOIN master_child b ON a.id = b.master_id ")
                .append(" JOIN building_info k ON a.building_id = k.id ")
                .append(" JOIN community d ON a.community_id = d.id ");
            sqlBuilder.append(" WHERE a.create_time < #{statDate,jdbcType=TIMESTAMP} ")
                    .append(" AND b.create_time < #{statDate,jdbcType=TIMESTAMP} ")
                    .append(" or b.create_time is null ")
                    .append(" or a.create_time is null ");
        sqlBuilder.append(" GROUP BY d.area_id, k.prop_type, a.community_id, d.type ")
                .append(" ) k group by area_id, prop_type, community_id, community_type ");
        String sqlStr = sqlBuilder.toString();
        logger.info("statMasterUserInfoImport:{}", sqlStr);
        return sqlStr;
    }

    public String statMasterInfo(Map<String, Object> param) {
/*        SQL sql = new SQL();
        sql.SELECT("d.area_id");
        sql.SELECT("a.community_id");
        sql.SELECT("d.type as community_type");
        sql.SELECT("count(DISTINCT b.uid) as user_count");
        sql.SELECT("sum(case b.type when 1 then 1 else 0 end) as owner_count");
        sql.SELECT("sum(case b.type when 2 then 1 else 0 end) as tenant_count");
        sql.SELECT("sum(case b.type when 3 then 1 else 0 end) as biz_owner_count");
        sql.SELECT("sum(case b.type when 4 then 1 else 0 end) as family_count");
        sql.SELECT("sum(case b.staff_type when 1 then 1 else 0 end) as staff_count");
        sql.SELECT("sum(case b.staff_type when 2 then 1 else 0 end) as site_staff_count");
        sql.SELECT("0 as other_count");
        sql.FROM("master_info a");
        sql.JOIN("master_child b ON a.id = b.master_id");
        sql.JOIN("community d ON a.community_id = d.id");
        sql.WHERE("b.create_time <= DATE_ADD(CURRENT_DATE(),INTERVAL -1 DAY)");
        sql.WHERE("a.create_time <= DATE_ADD(CURRENT_DATE(),INTERVAL -1 DAY)");
        sql.GROUP_BY("a.area_id, a.community_id, d.type");
        String sqlStr = sql.toString();
        logger.info("statMasterInfo:{}", sqlStr);*/
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append(" select area_id, prop_type, community_id, community_type,                                                         ")
                .append(" sum(master_count) as master_count,                                                                    ")
                .append(" sum(master_child_count) as master_child_count,                                                        ")
                .append(" sum(room_count) as room_count,                                                                    ")
                .append(" sum(parking_count) as parking_count,                                                        ")
                .append(" sum(owner_count) as owner_count,                                                                      ")
                .append(" sum(tenant_count) as tenant_count,                                                                    ")
                .append(" sum(biz_owner_count) as biz_owner_count,                                                              ")
                .append(" sum(family_count) as family_count,                                                                    ")
                .append(" sum(staff_count) as staff_count,                                                                      ")
                .append(" sum(site_staff_count) as site_staff_count,                                                            ")
                .append(" sum(other_count) as other_count                                                                       ")
                .append(" from (                                                                                                ")
                .append(" SELECT d.area_id, k.prop_type, a.community_id, d.type as community_type,                              ")
                .append(" count(distinct a.id) as master_count,                                                                 ")
                .append(" 0 as master_child_count,                                                                              ")
                .append(" count(case when a.type != 3 then 1 else null end) as room_count,                                      ")
                .append(" count(case when a.type = 3 then 1 else null end) as parking_count,                                    ")
                .append(" 0 as owner_count,                                                                                     ")
                .append(" 0 as tenant_count,                                                                                    ")
                .append(" 0 as biz_owner_count,                                                                                 ")
                .append(" 0 as family_count,                                                                                    ")
                .append(" 0 as staff_count,                                                                                     ")
                .append(" 0 as site_staff_count,                                                                                ")
                .append(" 0 as other_count                                                                                      ")
                .append(" FROM master_info a                                                                                    ")
                .append(" join community d on a.community_id = d.id                                                             ")
                .append("   JOIN building_info k                                   ")
                .append("   on a.building_id = k.id                                ")
                .append(" WHERE a.create_time < #{statDate,jdbcType=TIMESTAMP} or a.create_time is null                         ")
                .append(" group by area_id, k.prop_type, community_id, community_type                                           ")
                .append("                                                                                                       ")
                .append(" union all                                                                                             ")
                .append("                                                                                                       ")
                .append(" SELECT d.area_id, k.prop_type, b.community_id, d.type as community_type,                              ")
                .append(" 0 as master_count,                                                                                    ")
                .append(" count(distinct b.id) as master_child_count,                                                           ")
                .append(" 0 as room_count,                                                                                      ")
                .append(" 0 as parking_count,                                                                                   ")
                .append(" count(distinct case when b.type = 1 then b.id else null end) as owner_count,                          ")
                .append(" count(distinct case when b.type = 2 then b.id else null end) as tenant_count,                         ")
                .append(" count(distinct case when b.type = 3 then b.id else null end) as biz_owner_count,                      ")
                .append(" count(distinct case when b.type = 4 then b.id else null end) as family_count,                         ")
                .append(" count(distinct case when b.staff_type = 1 and a.type= 1 then b.id else null end) as staff_count,      ")
                .append(" count(distinct case when b.staff_type = 2 and a.type= 1 then b.id else null end) as site_staff_count, ")
                .append(" 0 as other_count                                                                                      ")
                .append(" FROM master_child b                                                                                   ")
                .append(" join master_info a on b.master_id = a.id                                                              ")
                .append(" join community d on b.community_id = d.id                                                             ")
                .append("   JOIN building_info k                                   ")
                .append("   on a.building_id = k.id                                ")
                .append(" WHERE b.create_time < #{statDate,jdbcType=TIMESTAMP} or b.create_time is null                         ")
                .append(" group by area_id, k.prop_type, community_id, community_type                                                        ")
                .append(" ) k group by area_id, prop_type, community_id, community_type                                                    ");
        String sqlStr = sqlBuilder.toString();
        logger.info("statMasterInfo:{}", sqlStr);
        return sqlStr;
    }

    public String statMasterCover(Map<String, Object> param) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append(" select area_id, prop_type, community_id, community_type,            ")
                .append(" sum(master_count) as master_count,                       ")
                .append(" sum(master_child_count) as master_child_count,            ")
                .append(" sum(room_count) as room_count,                            ")
                .append(" sum(parking_count) as parking_count                       ")
                .append(" from (                                                   ")
                .append(" SELECT                                                   ")
                .append(" 		c.area_id,                                         ")
                .append(" 		k.prop_type,                                       ")
                .append(" 		a.community_id,                                    ")
                .append(" 		c.type AS community_type,                          ")
                .append(" 		count(DISTINCT a.id) as master_count,              ")
                .append(" 		count(case when a.type != 3 then 1 else null end) as room_count, ")
                .append("       count(case when a.type = 3 then 1 else null end) as parking_count, ")
                .append(" 		0 as master_child_count                            ")
                .append(" 	FROM                                                   ")
                .append(" 		master_info a                                      ")
                .append(" 	JOIN community c                                       ")
                .append(" 	on a.community_id = c.id                               ")
                .append("   JOIN building_info k                                   ")
                .append("   on a.building_id = k.id                                ")
                .append(" 	WHERE                                                  ")
                .append(" 		a.create_time < #{statDate,jdbcType=TIMESTAMP}      ")
                .append(" 	OR a.create_time IS NULL                               ")
                .append(" 	GROUP BY                                               ")
                .append(" 		c.area_id,                                         ")
                .append(" 		k.prop_type,                                       ")
                .append(" 		a.community_id,                                    ")
                .append(" 	  c.type                                               ")
                .append(" union ALL                                                ")
                .append(" 	SELECT                                                 ")
                .append(" 		c.area_id,                                         ")
                .append(" 		k.prop_type,                                       ")
                .append(" 		a.community_id,                                    ")
                .append(" 		c.type AS community_type,                          ")
                .append(" 		0 as master_count,                                 ")
                .append(" 		0 as room_count,                                   ")
                .append(" 		0 as parking_count,                                ")
                .append(" 		count(distinct a.master_id) as master_child_count  ")
                .append(" 	FROM                                                   ")
                .append(" 		master_child a                                     ")
                 .append(" 	JOIN master_info b                                     ")
                .append(" 	on b.community_id = a.community_id and a.master_id = b.id  ")
                .append(" 	JOIN community c                                       ")
                .append(" 	on a.community_id = c.id                               ")
                .append("   JOIN building_info k                                   ")
                .append("   on b.building_id = k.id                                ")
                .append(" 	WHERE                                                  ")
                .append(" 		(a.create_time <  #{statDate,jdbcType=TIMESTAMP}    ")
                .append(" 	OR a.create_time IS NULL)                              ")
                .append(" 	AND a.uid > 0                                          ")
                .append(" 	GROUP BY                                               ")
                .append(" 		c.area_id,                                         ")
                .append(" 		k.prop_type,                                       ")
                .append(" 		a.community_id,                                    ")
                .append(" 	  c.type) m                                            ")
                .append(" group by area_id, prop_type, community_id, community_type           ");
        String sqlStr = sqlBuilder.toString();
        logger.info("statMasterCover:{}", sqlStr);
        return sqlStr;
    }

    public String statRegisterUserCount(Map<String, Object> param) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append(" select count(distinct a.id) from user_info a ")
                .append(" where not exists (select b.id from master_child b where a.id = b.uid and b.uid !=0) ")
                .append(" AND a.create_time < #{statDate,jdbcType=TIMESTAMP} ");
        String sqlStr = sqlBuilder.toString();
        logger.info("statUserCount:{}", sqlStr);
        return sqlStr;
    }

    public String statUserCount(Map<String, Object> param) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append(" select count(distinct a.id) from user_info a ")
                .append(" where a.create_time < #{statDate,jdbcType=TIMESTAMP} ");
        String sqlStr = sqlBuilder.toString();
        logger.info("statUserCount:{}", sqlStr);
        return sqlStr;
    }

    public String statMasterChildUserCount(Map<String, Object> param) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append(" select count(distinct a.uid) from master_child a ")
                .append(" where a.uid !=0 and a.create_time < #{statDate,jdbcType=TIMESTAMP} ");
        String sqlStr = sqlBuilder.toString();
        logger.info("statMasterChildUserCount:{}", sqlStr);
        return sqlStr;
    }
}
