package com.rfchina.community.brothers.mapper.ext;

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
public class ExtAdSqlProvider extends AdSqlProvider {

    public String pageByExample(Map<String, Object> param) {
        AdExample example = (AdExample) param.get("example");
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("category_id");
        sql.SELECT("community_id");
        sql.SELECT("name");
        sql.SELECT("img_url");
        sql.SELECT("link");
        sql.SELECT("sorting");
        sql.SELECT("status");
        sql.SELECT("src_type");
        sql.SELECT("click_count");
        sql.SELECT("intro");
        sql.SELECT("reason");
        sql.SELECT("platform_reason");
        sql.SELECT("leader_reason");
        sql.SELECT("start_time");
        sql.SELECT("end_time");
        sql.SELECT("create_time");
        sql.SELECT("audit_time");
        sql.SELECT("leader_audit_time");
        sql.SELECT("platform_audit_time");
        sql.SELECT("publish_time");
        sql.SELECT("auto_publish");
        sql.SELECT("auto_publish_time");
        sql.SELECT("auto_repeal");
        sql.SELECT("auto_repeal_time");
        sql.SELECT("apply_admin_id");
        sql.SELECT("apply_time");
        sql.FROM("ad");
        applyWhere(sql, example, true);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String pageByExampleWithJoin(Map<String, Object> param) {
        SQL sql = new SQL();
        sql.SELECT("a.id");
        sql.SELECT("a.category_id");
        sql.SELECT("a.community_id");
        sql.SELECT("a.name");
        sql.SELECT("a.img_url");
        sql.SELECT("a.link");
        sql.SELECT("a.sorting");
        sql.SELECT("a.status");
        sql.SELECT("a.src_type");
        sql.SELECT("a.click_count");
        sql.SELECT("a.intro");
        sql.SELECT("a.reason");
        sql.SELECT("a.platform_reason");
        sql.SELECT("a.leader_reason");
        sql.SELECT("a.start_time");
        sql.SELECT("a.end_time");
        sql.SELECT("a.create_time");
        sql.SELECT("a.audit_time");
        sql.SELECT("a.leader_audit_time");
        sql.SELECT("a.platform_audit_time");
        sql.SELECT("a.publish_time");
        sql.SELECT("a.auto_publish");
        sql.SELECT("a.auto_publish_time");
        sql.SELECT("a.auto_repeal");
        sql.SELECT("a.auto_repeal_time");
        sql.SELECT("a.apply_admin_id");
        sql.SELECT("a.apply_time");
        sql.SELECT("b.name as community_name");
/*        sql.SELECT(" (case when src_type=1 then select d.realname from community_admin d where d.id = a.apply_admin_id "
                + " when src_type=2 then select e.realname from platform_admin e where e.id = a.apply_admin_id "
                + " else '' end) as apply_admin_name");*/
        sql.SELECT("d.username as apply_admin_name");
        sql.SELECT("c.name as category_name");
        sql.FROM("ad a");
        sql.LEFT_OUTER_JOIN("community b on b.id = a.community_id");
        sql.LEFT_OUTER_JOIN("ad_category c on c.id = a.category_id");
        sql.LEFT_OUTER_JOIN("rf_passport d on d.id = a.apply_admin_id");

        sql.WHERE("a.status not in (" + Constant.Ad.Status.AUDIT_NOT_PASS + "," + Constant.Ad.Status.UNAUDIT + "," + Constant.Ad.Status.AUDITING + ")");

        String  applyAdminName = MapUtils.getString(param, "applyAdminName", "");
        if(StringUtils.isNotBlank(applyAdminName)) {
            sql.WHERE("d.username like #{applyAdminName, jdbcType=VARCHAR}");
        }

        String  communityName = MapUtils.getString(param, "communityName", "");
        if(StringUtils.isNotBlank(communityName)) {
            sql.WHERE("b.name like #{communityName, jdbcType=VARCHAR}");
        }

        Date startAuditTime = (Date)MapUtils.getObject(param, "startAuditTime");
        if(null != startAuditTime) {
            sql.WHERE("a.platform_audit_time >= #{startAuditTime, jdbcType=TIMESTAMP}");
        }

        Date endAuditTime = (Date)MapUtils.getObject(param, "endAuditTime");
        if(null != endAuditTime) {
            sql.WHERE("a.platform_audit_time <= #{endAuditTime, jdbcType=TIMESTAMP}");
        }

        Date startPublishTime = (Date)MapUtils.getObject(param, "startPublishTime");
        if(null != startPublishTime) {
            sql.WHERE("a.publish_time >= #{startPublishTime, jdbcType=TIMESTAMP}");
        }

        Date endPublishTime = (Date)MapUtils.getObject(param, "endPublishTime");
        if(null != endPublishTime) {
            sql.WHERE("a.publish_time <= #{endPublishTime, jdbcType=TIMESTAMP}");
        }

        Date startApplyTime = (Date)MapUtils.getObject(param, "startApplyTime");
        if(null != startPublishTime) {
            sql.WHERE("a.apply_time >= #{startApplyTime, jdbcType=TIMESTAMP}");
        }

        Date endApplyTime = (Date)MapUtils.getObject(param, "endApplyTime");
        if(null != endPublishTime) {
            sql.WHERE("a.apply_time <= #{endApplyTime, jdbcType=TIMESTAMP}");
        }

        Integer status = MapUtils.getInteger(param, "status", 0);
        if(null != status && 0 != status) {
            sql.WHERE("a.status = #{status, jdbcType=INTEGER}");
        }

        sql.ORDER_BY("sorting asc, create_time desc");

        return sql.toString();
    }
}
