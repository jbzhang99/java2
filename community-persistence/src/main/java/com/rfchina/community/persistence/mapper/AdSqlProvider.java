package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.Ad;
import com.rfchina.community.persistence.model.AdExample.Criteria;
import com.rfchina.community.persistence.model.AdExample.Criterion;
import com.rfchina.community.persistence.model.AdExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class AdSqlProvider {

    public String countByExample(AdExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("ad");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(AdExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("ad");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Ad record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ad");
        
        if (record.getCategoryId() != null) {
            sql.VALUES("category_id", "#{categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getImgUrl() != null) {
            sql.VALUES("img_url", "#{imgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getLink() != null) {
            sql.VALUES("link", "#{link,jdbcType=VARCHAR}");
        }
        
        if (record.getSorting() != null) {
            sql.VALUES("sorting", "#{sorting,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getSrcType() != null) {
            sql.VALUES("src_type", "#{srcType,jdbcType=INTEGER}");
        }
        
        if (record.getClickCount() != null) {
            sql.VALUES("click_count", "#{clickCount,jdbcType=INTEGER}");
        }
        
        if (record.getIntro() != null) {
            sql.VALUES("intro", "#{intro,jdbcType=VARCHAR}");
        }
        
        if (record.getReason() != null) {
            sql.VALUES("reason", "#{reason,jdbcType=VARCHAR}");
        }
        
        if (record.getPlatformReason() != null) {
            sql.VALUES("platform_reason", "#{platformReason,jdbcType=VARCHAR}");
        }
        
        if (record.getLeaderReason() != null) {
            sql.VALUES("leader_reason", "#{leaderReason,jdbcType=VARCHAR}");
        }
        
        if (record.getStartTime() != null) {
            sql.VALUES("start_time", "#{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.VALUES("end_time", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditTime() != null) {
            sql.VALUES("audit_time", "#{auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLeaderAuditTime() != null) {
            sql.VALUES("leader_audit_time", "#{leaderAuditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPlatformAuditTime() != null) {
            sql.VALUES("platform_audit_time", "#{platformAuditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPublishTime() != null) {
            sql.VALUES("publish_time", "#{publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAutoPublish() != null) {
            sql.VALUES("auto_publish", "#{autoPublish,jdbcType=TINYINT}");
        }
        
        if (record.getAutoPublishTime() != null) {
            sql.VALUES("auto_publish_time", "#{autoPublishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAutoRepeal() != null) {
            sql.VALUES("auto_repeal", "#{autoRepeal,jdbcType=TINYINT}");
        }
        
        if (record.getAutoRepealTime() != null) {
            sql.VALUES("auto_repeal_time", "#{autoRepealTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApplyAdminId() != null) {
            sql.VALUES("apply_admin_id", "#{applyAdminId,jdbcType=BIGINT}");
        }
        
        if (record.getApplyTime() != null) {
            sql.VALUES("apply_time", "#{applyTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(AdExample example) {
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
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Ad record = (Ad) parameter.get("record");
        AdExample example = (AdExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("ad");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getCategoryId() != null) {
            sql.SET("category_id = #{record.categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getImgUrl() != null) {
            sql.SET("img_url = #{record.imgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getLink() != null) {
            sql.SET("link = #{record.link,jdbcType=VARCHAR}");
        }
        
        if (record.getSorting() != null) {
            sql.SET("sorting = #{record.sorting,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getSrcType() != null) {
            sql.SET("src_type = #{record.srcType,jdbcType=INTEGER}");
        }
        
        if (record.getClickCount() != null) {
            sql.SET("click_count = #{record.clickCount,jdbcType=INTEGER}");
        }
        
        if (record.getIntro() != null) {
            sql.SET("intro = #{record.intro,jdbcType=VARCHAR}");
        }
        
        if (record.getReason() != null) {
            sql.SET("reason = #{record.reason,jdbcType=VARCHAR}");
        }
        
        if (record.getPlatformReason() != null) {
            sql.SET("platform_reason = #{record.platformReason,jdbcType=VARCHAR}");
        }
        
        if (record.getLeaderReason() != null) {
            sql.SET("leader_reason = #{record.leaderReason,jdbcType=VARCHAR}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditTime() != null) {
            sql.SET("audit_time = #{record.auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLeaderAuditTime() != null) {
            sql.SET("leader_audit_time = #{record.leaderAuditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPlatformAuditTime() != null) {
            sql.SET("platform_audit_time = #{record.platformAuditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPublishTime() != null) {
            sql.SET("publish_time = #{record.publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAutoPublish() != null) {
            sql.SET("auto_publish = #{record.autoPublish,jdbcType=TINYINT}");
        }
        
        if (record.getAutoPublishTime() != null) {
            sql.SET("auto_publish_time = #{record.autoPublishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAutoRepeal() != null) {
            sql.SET("auto_repeal = #{record.autoRepeal,jdbcType=TINYINT}");
        }
        
        if (record.getAutoRepealTime() != null) {
            sql.SET("auto_repeal_time = #{record.autoRepealTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApplyAdminId() != null) {
            sql.SET("apply_admin_id = #{record.applyAdminId,jdbcType=BIGINT}");
        }
        
        if (record.getApplyTime() != null) {
            sql.SET("apply_time = #{record.applyTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("ad");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("category_id = #{record.categoryId,jdbcType=INTEGER}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("img_url = #{record.imgUrl,jdbcType=VARCHAR}");
        sql.SET("link = #{record.link,jdbcType=VARCHAR}");
        sql.SET("sorting = #{record.sorting,jdbcType=INTEGER}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("src_type = #{record.srcType,jdbcType=INTEGER}");
        sql.SET("click_count = #{record.clickCount,jdbcType=INTEGER}");
        sql.SET("intro = #{record.intro,jdbcType=VARCHAR}");
        sql.SET("reason = #{record.reason,jdbcType=VARCHAR}");
        sql.SET("platform_reason = #{record.platformReason,jdbcType=VARCHAR}");
        sql.SET("leader_reason = #{record.leaderReason,jdbcType=VARCHAR}");
        sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("audit_time = #{record.auditTime,jdbcType=TIMESTAMP}");
        sql.SET("leader_audit_time = #{record.leaderAuditTime,jdbcType=TIMESTAMP}");
        sql.SET("platform_audit_time = #{record.platformAuditTime,jdbcType=TIMESTAMP}");
        sql.SET("publish_time = #{record.publishTime,jdbcType=TIMESTAMP}");
        sql.SET("auto_publish = #{record.autoPublish,jdbcType=TINYINT}");
        sql.SET("auto_publish_time = #{record.autoPublishTime,jdbcType=TIMESTAMP}");
        sql.SET("auto_repeal = #{record.autoRepeal,jdbcType=TINYINT}");
        sql.SET("auto_repeal_time = #{record.autoRepealTime,jdbcType=TIMESTAMP}");
        sql.SET("apply_admin_id = #{record.applyAdminId,jdbcType=BIGINT}");
        sql.SET("apply_time = #{record.applyTime,jdbcType=TIMESTAMP}");
        
        AdExample example = (AdExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Ad record) {
        SQL sql = new SQL();
        sql.UPDATE("ad");
        
        if (record.getCategoryId() != null) {
            sql.SET("category_id = #{categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getImgUrl() != null) {
            sql.SET("img_url = #{imgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getLink() != null) {
            sql.SET("link = #{link,jdbcType=VARCHAR}");
        }
        
        if (record.getSorting() != null) {
            sql.SET("sorting = #{sorting,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getSrcType() != null) {
            sql.SET("src_type = #{srcType,jdbcType=INTEGER}");
        }
        
        if (record.getClickCount() != null) {
            sql.SET("click_count = #{clickCount,jdbcType=INTEGER}");
        }
        
        if (record.getIntro() != null) {
            sql.SET("intro = #{intro,jdbcType=VARCHAR}");
        }
        
        if (record.getReason() != null) {
            sql.SET("reason = #{reason,jdbcType=VARCHAR}");
        }
        
        if (record.getPlatformReason() != null) {
            sql.SET("platform_reason = #{platformReason,jdbcType=VARCHAR}");
        }
        
        if (record.getLeaderReason() != null) {
            sql.SET("leader_reason = #{leaderReason,jdbcType=VARCHAR}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditTime() != null) {
            sql.SET("audit_time = #{auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLeaderAuditTime() != null) {
            sql.SET("leader_audit_time = #{leaderAuditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPlatformAuditTime() != null) {
            sql.SET("platform_audit_time = #{platformAuditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPublishTime() != null) {
            sql.SET("publish_time = #{publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAutoPublish() != null) {
            sql.SET("auto_publish = #{autoPublish,jdbcType=TINYINT}");
        }
        
        if (record.getAutoPublishTime() != null) {
            sql.SET("auto_publish_time = #{autoPublishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAutoRepeal() != null) {
            sql.SET("auto_repeal = #{autoRepeal,jdbcType=TINYINT}");
        }
        
        if (record.getAutoRepealTime() != null) {
            sql.SET("auto_repeal_time = #{autoRepealTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApplyAdminId() != null) {
            sql.SET("apply_admin_id = #{applyAdminId,jdbcType=BIGINT}");
        }
        
        if (record.getApplyTime() != null) {
            sql.SET("apply_time = #{applyTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, AdExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}