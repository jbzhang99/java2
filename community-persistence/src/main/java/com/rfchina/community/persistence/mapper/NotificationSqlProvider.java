package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.Notification;
import com.rfchina.community.persistence.model.NotificationExample.Criteria;
import com.rfchina.community.persistence.model.NotificationExample.Criterion;
import com.rfchina.community.persistence.model.NotificationExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class NotificationSqlProvider {

    public String countByExample(NotificationExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("notification");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(NotificationExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("notification");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Notification record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("notification");
        
        if (record.getAppId() != null) {
            sql.VALUES("app_id", "#{appId,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateComm() != null) {
            sql.VALUES("create_comm", "#{createComm,jdbcType=INTEGER}");
        }
        
        if (record.getCreateUid() != null) {
            sql.VALUES("create_uid", "#{createUid,jdbcType=BIGINT}");
        }
        
        if (record.getThumb() != null) {
            sql.VALUES("thumb", "#{thumb,jdbcType=VARCHAR}");
        }
        
        if (record.getPushTime() != null) {
            sql.VALUES("push_time", "#{pushTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditRemark() != null) {
            sql.VALUES("audit_remark", "#{auditRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(NotificationExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("app_id");
        sql.SELECT("title");
        sql.SELECT("remark");
        sql.SELECT("status");
        sql.SELECT("type");
        sql.SELECT("create_time");
        sql.SELECT("create_comm");
        sql.SELECT("create_uid");
        sql.SELECT("thumb");
        sql.SELECT("push_time");
        sql.SELECT("audit_remark");
        sql.SELECT("content");
        sql.FROM("notification");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(NotificationExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("app_id");
        sql.SELECT("title");
        sql.SELECT("remark");
        sql.SELECT("status");
        sql.SELECT("type");
        sql.SELECT("create_time");
        sql.SELECT("create_comm");
        sql.SELECT("create_uid");
        sql.SELECT("thumb");
        sql.SELECT("push_time");
        sql.SELECT("audit_remark");
        sql.FROM("notification");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Notification record = (Notification) parameter.get("record");
        NotificationExample example = (NotificationExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("notification");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{record.appId,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateComm() != null) {
            sql.SET("create_comm = #{record.createComm,jdbcType=INTEGER}");
        }
        
        if (record.getCreateUid() != null) {
            sql.SET("create_uid = #{record.createUid,jdbcType=BIGINT}");
        }
        
        if (record.getThumb() != null) {
            sql.SET("thumb = #{record.thumb,jdbcType=VARCHAR}");
        }
        
        if (record.getPushTime() != null) {
            sql.SET("push_time = #{record.pushTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditRemark() != null) {
            sql.SET("audit_remark = #{record.auditRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("notification");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("app_id = #{record.appId,jdbcType=INTEGER}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("type = #{record.type,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("create_comm = #{record.createComm,jdbcType=INTEGER}");
        sql.SET("create_uid = #{record.createUid,jdbcType=BIGINT}");
        sql.SET("thumb = #{record.thumb,jdbcType=VARCHAR}");
        sql.SET("push_time = #{record.pushTime,jdbcType=TIMESTAMP}");
        sql.SET("audit_remark = #{record.auditRemark,jdbcType=VARCHAR}");
        sql.SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        
        NotificationExample example = (NotificationExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("notification");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("app_id = #{record.appId,jdbcType=INTEGER}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("type = #{record.type,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("create_comm = #{record.createComm,jdbcType=INTEGER}");
        sql.SET("create_uid = #{record.createUid,jdbcType=BIGINT}");
        sql.SET("thumb = #{record.thumb,jdbcType=VARCHAR}");
        sql.SET("push_time = #{record.pushTime,jdbcType=TIMESTAMP}");
        sql.SET("audit_remark = #{record.auditRemark,jdbcType=VARCHAR}");
        
        NotificationExample example = (NotificationExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Notification record) {
        SQL sql = new SQL();
        sql.UPDATE("notification");
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{appId,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateComm() != null) {
            sql.SET("create_comm = #{createComm,jdbcType=INTEGER}");
        }
        
        if (record.getCreateUid() != null) {
            sql.SET("create_uid = #{createUid,jdbcType=BIGINT}");
        }
        
        if (record.getThumb() != null) {
            sql.SET("thumb = #{thumb,jdbcType=VARCHAR}");
        }
        
        if (record.getPushTime() != null) {
            sql.SET("push_time = #{pushTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditRemark() != null) {
            sql.SET("audit_remark = #{auditRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, NotificationExample example, boolean includeExamplePhrase) {
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