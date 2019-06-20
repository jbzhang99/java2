package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CardInfo;
import com.rfchina.community.persistence.model.CardInfoExample.Criteria;
import com.rfchina.community.persistence.model.CardInfoExample.Criterion;
import com.rfchina.community.persistence.model.CardInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CardInfoSqlProvider {

    public String countByExample(CardInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("card_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CardInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("card_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CardInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("card_info");
        
        if (record.getCategoryId() != null) {
            sql.VALUES("category_id", "#{categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getTemplateId() != null) {
            sql.VALUES("template_id", "#{templateId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getOperationId() != null) {
            sql.VALUES("operation_id", "#{operationId,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getAuditStatus() != null) {
            sql.VALUES("audit_status", "#{auditStatus,jdbcType=TINYINT}");
        }
        
        if (record.getAuditReason() != null) {
            sql.VALUES("audit_reason", "#{auditReason,jdbcType=VARCHAR}");
        }
        
        if (record.getSquareAuditReason() != null) {
            sql.VALUES("square_audit_reason", "#{squareAuditReason,jdbcType=VARCHAR}");
        }
        
        if (record.getSquareAuditStatus() != null) {
            sql.VALUES("square_audit_status", "#{squareAuditStatus,jdbcType=TINYINT}");
        }
        
        if (record.getSquareAuditTime() != null) {
            sql.VALUES("square_audit_time", "#{squareAuditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSquarePublishTime() != null) {
            sql.VALUES("square_publish_time", "#{squarePublishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPublishTime() != null) {
            sql.VALUES("publish_time", "#{publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAttachment() != null) {
            sql.VALUES("attachment", "#{attachment,jdbcType=VARCHAR}");
        }
        
        if (record.getSubjectId() != null) {
            sql.VALUES("subject_id", "#{subjectId,jdbcType=BIGINT}");
        }
        
        if (record.getSubjectName() != null) {
            sql.VALUES("subject_name", "#{subjectName,jdbcType=VARCHAR}");
        }
        
        if (record.getSubjectType() != null) {
            sql.VALUES("subject_type", "#{subjectType,jdbcType=INTEGER}");
        }
        
        if (record.getSubjectIcon() != null) {
            sql.VALUES("subject_icon", "#{subjectIcon,jdbcType=VARCHAR}");
        }
        
        if (record.getPubToSquare() != null) {
            sql.VALUES("pub_to_square", "#{pubToSquare,jdbcType=TINYINT}");
        }
        
        if (record.getSource() != null) {
            sql.VALUES("source", "#{source,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatorId() != null) {
            sql.VALUES("creator_id", "#{creatorId,jdbcType=BIGINT}");
        }
        
        if (record.getCid() != null) {
            sql.VALUES("cid", "#{cid,jdbcType=BIGINT}");
        }
        
        if (record.getApplyTime() != null) {
            sql.VALUES("apply_time", "#{applyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeleteTime() != null) {
            sql.VALUES("delete_time", "#{deleteTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CardInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("category_id");
        sql.SELECT("template_id");
        sql.SELECT("community_id");
        sql.SELECT("operation_id");
        sql.SELECT("title");
        sql.SELECT("content");
        sql.SELECT("status");
        sql.SELECT("audit_status");
        sql.SELECT("audit_reason");
        sql.SELECT("square_audit_reason");
        sql.SELECT("square_audit_status");
        sql.SELECT("square_audit_time");
        sql.SELECT("square_publish_time");
        sql.SELECT("publish_time");
        sql.SELECT("attachment");
        sql.SELECT("subject_id");
        sql.SELECT("subject_name");
        sql.SELECT("subject_type");
        sql.SELECT("subject_icon");
        sql.SELECT("pub_to_square");
        sql.SELECT("source");
        sql.SELECT("creator_id");
        sql.SELECT("cid");
        sql.SELECT("apply_time");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("delete_time");
        sql.FROM("card_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CardInfo record = (CardInfo) parameter.get("record");
        CardInfoExample example = (CardInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("card_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCategoryId() != null) {
            sql.SET("category_id = #{record.categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getTemplateId() != null) {
            sql.SET("template_id = #{record.templateId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getOperationId() != null) {
            sql.SET("operation_id = #{record.operationId,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{record.content,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=TINYINT}");
        }
        
        if (record.getAuditStatus() != null) {
            sql.SET("audit_status = #{record.auditStatus,jdbcType=TINYINT}");
        }
        
        if (record.getAuditReason() != null) {
            sql.SET("audit_reason = #{record.auditReason,jdbcType=VARCHAR}");
        }
        
        if (record.getSquareAuditReason() != null) {
            sql.SET("square_audit_reason = #{record.squareAuditReason,jdbcType=VARCHAR}");
        }
        
        if (record.getSquareAuditStatus() != null) {
            sql.SET("square_audit_status = #{record.squareAuditStatus,jdbcType=TINYINT}");
        }
        
        if (record.getSquareAuditTime() != null) {
            sql.SET("square_audit_time = #{record.squareAuditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSquarePublishTime() != null) {
            sql.SET("square_publish_time = #{record.squarePublishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPublishTime() != null) {
            sql.SET("publish_time = #{record.publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAttachment() != null) {
            sql.SET("attachment = #{record.attachment,jdbcType=VARCHAR}");
        }
        
        if (record.getSubjectId() != null) {
            sql.SET("subject_id = #{record.subjectId,jdbcType=BIGINT}");
        }
        
        if (record.getSubjectName() != null) {
            sql.SET("subject_name = #{record.subjectName,jdbcType=VARCHAR}");
        }
        
        if (record.getSubjectType() != null) {
            sql.SET("subject_type = #{record.subjectType,jdbcType=INTEGER}");
        }
        
        if (record.getSubjectIcon() != null) {
            sql.SET("subject_icon = #{record.subjectIcon,jdbcType=VARCHAR}");
        }
        
        if (record.getPubToSquare() != null) {
            sql.SET("pub_to_square = #{record.pubToSquare,jdbcType=TINYINT}");
        }
        
        if (record.getSource() != null) {
            sql.SET("source = #{record.source,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatorId() != null) {
            sql.SET("creator_id = #{record.creatorId,jdbcType=BIGINT}");
        }
        
        if (record.getCid() != null) {
            sql.SET("cid = #{record.cid,jdbcType=BIGINT}");
        }
        
        if (record.getApplyTime() != null) {
            sql.SET("apply_time = #{record.applyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeleteTime() != null) {
            sql.SET("delete_time = #{record.deleteTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("card_info");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("category_id = #{record.categoryId,jdbcType=INTEGER}");
        sql.SET("template_id = #{record.templateId,jdbcType=INTEGER}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("operation_id = #{record.operationId,jdbcType=VARCHAR}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("content = #{record.content,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        sql.SET("audit_status = #{record.auditStatus,jdbcType=TINYINT}");
        sql.SET("audit_reason = #{record.auditReason,jdbcType=VARCHAR}");
        sql.SET("square_audit_reason = #{record.squareAuditReason,jdbcType=VARCHAR}");
        sql.SET("square_audit_status = #{record.squareAuditStatus,jdbcType=TINYINT}");
        sql.SET("square_audit_time = #{record.squareAuditTime,jdbcType=TIMESTAMP}");
        sql.SET("square_publish_time = #{record.squarePublishTime,jdbcType=TIMESTAMP}");
        sql.SET("publish_time = #{record.publishTime,jdbcType=TIMESTAMP}");
        sql.SET("attachment = #{record.attachment,jdbcType=VARCHAR}");
        sql.SET("subject_id = #{record.subjectId,jdbcType=BIGINT}");
        sql.SET("subject_name = #{record.subjectName,jdbcType=VARCHAR}");
        sql.SET("subject_type = #{record.subjectType,jdbcType=INTEGER}");
        sql.SET("subject_icon = #{record.subjectIcon,jdbcType=VARCHAR}");
        sql.SET("pub_to_square = #{record.pubToSquare,jdbcType=TINYINT}");
        sql.SET("source = #{record.source,jdbcType=VARCHAR}");
        sql.SET("creator_id = #{record.creatorId,jdbcType=BIGINT}");
        sql.SET("cid = #{record.cid,jdbcType=BIGINT}");
        sql.SET("apply_time = #{record.applyTime,jdbcType=TIMESTAMP}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("delete_time = #{record.deleteTime,jdbcType=TIMESTAMP}");
        
        CardInfoExample example = (CardInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CardInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("card_info");
        
        if (record.getCategoryId() != null) {
            sql.SET("category_id = #{categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getTemplateId() != null) {
            sql.SET("template_id = #{templateId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getOperationId() != null) {
            sql.SET("operation_id = #{operationId,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getAuditStatus() != null) {
            sql.SET("audit_status = #{auditStatus,jdbcType=TINYINT}");
        }
        
        if (record.getAuditReason() != null) {
            sql.SET("audit_reason = #{auditReason,jdbcType=VARCHAR}");
        }
        
        if (record.getSquareAuditReason() != null) {
            sql.SET("square_audit_reason = #{squareAuditReason,jdbcType=VARCHAR}");
        }
        
        if (record.getSquareAuditStatus() != null) {
            sql.SET("square_audit_status = #{squareAuditStatus,jdbcType=TINYINT}");
        }
        
        if (record.getSquareAuditTime() != null) {
            sql.SET("square_audit_time = #{squareAuditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSquarePublishTime() != null) {
            sql.SET("square_publish_time = #{squarePublishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPublishTime() != null) {
            sql.SET("publish_time = #{publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAttachment() != null) {
            sql.SET("attachment = #{attachment,jdbcType=VARCHAR}");
        }
        
        if (record.getSubjectId() != null) {
            sql.SET("subject_id = #{subjectId,jdbcType=BIGINT}");
        }
        
        if (record.getSubjectName() != null) {
            sql.SET("subject_name = #{subjectName,jdbcType=VARCHAR}");
        }
        
        if (record.getSubjectType() != null) {
            sql.SET("subject_type = #{subjectType,jdbcType=INTEGER}");
        }
        
        if (record.getSubjectIcon() != null) {
            sql.SET("subject_icon = #{subjectIcon,jdbcType=VARCHAR}");
        }
        
        if (record.getPubToSquare() != null) {
            sql.SET("pub_to_square = #{pubToSquare,jdbcType=TINYINT}");
        }
        
        if (record.getSource() != null) {
            sql.SET("source = #{source,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatorId() != null) {
            sql.SET("creator_id = #{creatorId,jdbcType=BIGINT}");
        }
        
        if (record.getCid() != null) {
            sql.SET("cid = #{cid,jdbcType=BIGINT}");
        }
        
        if (record.getApplyTime() != null) {
            sql.SET("apply_time = #{applyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeleteTime() != null) {
            sql.SET("delete_time = #{deleteTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CardInfoExample example, boolean includeExamplePhrase) {
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