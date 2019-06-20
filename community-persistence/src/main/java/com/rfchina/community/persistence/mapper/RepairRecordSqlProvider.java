package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.RepairRecord;
import com.rfchina.community.persistence.model.RepairRecordExample.Criteria;
import com.rfchina.community.persistence.model.RepairRecordExample.Criterion;
import com.rfchina.community.persistence.model.RepairRecordExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class RepairRecordSqlProvider {

    public String countByExample(RepairRecordExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("repair_record");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(RepairRecordExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("repair_record");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(RepairRecord record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("repair_record");
        
        if (record.getTradeNo() != null) {
            sql.VALUES("trade_no", "#{tradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderNo() != null) {
            sql.VALUES("order_no", "#{orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=BIGINT}");
        }
        
        if (record.getMasterChildId() != null) {
            sql.VALUES("master_child_id", "#{masterChildId,jdbcType=BIGINT}");
        }
        
        if (record.getContact() != null) {
            sql.VALUES("contact", "#{contact,jdbcType=VARCHAR}");
        }
        
        if (record.getContactMobile() != null) {
            sql.VALUES("contact_mobile", "#{contactMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getProblemTypeId() != null) {
            sql.VALUES("problem_type_id", "#{problemTypeId,jdbcType=INTEGER}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getAtta() != null) {
            sql.VALUES("atta", "#{atta,jdbcType=VARCHAR}");
        }
        
        if (record.getRemimd() != null) {
            sql.VALUES("remimd", "#{remimd,jdbcType=INTEGER}");
        }
        
        if (record.getRemimdTime() != null) {
            sql.VALUES("remimd_time", "#{remimdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getScore() != null) {
            sql.VALUES("score", "#{score,jdbcType=INTEGER}");
        }
        
        if (record.getScoreContent() != null) {
            sql.VALUES("score_content", "#{scoreContent,jdbcType=VARCHAR}");
        }
        
        if (record.getScoreTime() != null) {
            sql.VALUES("score_time", "#{scoreTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=TINYINT}");
        }
        
        if (record.getFormType() != null) {
            sql.VALUES("form_type", "#{formType,jdbcType=TINYINT}");
        }
        
        if (record.getOutReason() != null) {
            sql.VALUES("out_reason", "#{outReason,jdbcType=VARCHAR}");
        }
        
        if (record.getLabourFee() != null) {
            sql.VALUES("labour_fee", "#{labourFee,jdbcType=VARCHAR}");
        }
        
        if (record.getMaterialFee() != null) {
            sql.VALUES("material_fee", "#{materialFee,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceCategory() != null) {
            sql.VALUES("service_category", "#{serviceCategory,jdbcType=INTEGER}");
        }
        
        if (record.getUrgencyLevel() != null) {
            sql.VALUES("urgency_level", "#{urgencyLevel,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(RepairRecordExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("trade_no");
        sql.SELECT("order_no");
        sql.SELECT("uid");
        sql.SELECT("master_child_id");
        sql.SELECT("contact");
        sql.SELECT("contact_mobile");
        sql.SELECT("problem_type_id");
        sql.SELECT("address");
        sql.SELECT("content");
        sql.SELECT("atta");
        sql.SELECT("remimd");
        sql.SELECT("remimd_time");
        sql.SELECT("score");
        sql.SELECT("score_content");
        sql.SELECT("score_time");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("status");
        sql.SELECT("community_id");
        sql.SELECT("type");
        sql.SELECT("form_type");
        sql.SELECT("out_reason");
        sql.SELECT("labour_fee");
        sql.SELECT("material_fee");
        sql.SELECT("service_category");
        sql.SELECT("urgency_level");
        sql.FROM("repair_record");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        RepairRecord record = (RepairRecord) parameter.get("record");
        RepairRecordExample example = (RepairRecordExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("repair_record");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getTradeNo() != null) {
            sql.SET("trade_no = #{record.tradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderNo() != null) {
            sql.SET("order_no = #{record.orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        }
        
        if (record.getMasterChildId() != null) {
            sql.SET("master_child_id = #{record.masterChildId,jdbcType=BIGINT}");
        }
        
        if (record.getContact() != null) {
            sql.SET("contact = #{record.contact,jdbcType=VARCHAR}");
        }
        
        if (record.getContactMobile() != null) {
            sql.SET("contact_mobile = #{record.contactMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getProblemTypeId() != null) {
            sql.SET("problem_type_id = #{record.problemTypeId,jdbcType=INTEGER}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{record.content,jdbcType=VARCHAR}");
        }
        
        if (record.getAtta() != null) {
            sql.SET("atta = #{record.atta,jdbcType=VARCHAR}");
        }
        
        if (record.getRemimd() != null) {
            sql.SET("remimd = #{record.remimd,jdbcType=INTEGER}");
        }
        
        if (record.getRemimdTime() != null) {
            sql.SET("remimd_time = #{record.remimdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getScore() != null) {
            sql.SET("score = #{record.score,jdbcType=INTEGER}");
        }
        
        if (record.getScoreContent() != null) {
            sql.SET("score_content = #{record.scoreContent,jdbcType=VARCHAR}");
        }
        
        if (record.getScoreTime() != null) {
            sql.SET("score_time = #{record.scoreTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=TINYINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=TINYINT}");
        }
        
        if (record.getFormType() != null) {
            sql.SET("form_type = #{record.formType,jdbcType=TINYINT}");
        }
        
        if (record.getOutReason() != null) {
            sql.SET("out_reason = #{record.outReason,jdbcType=VARCHAR}");
        }
        
        if (record.getLabourFee() != null) {
            sql.SET("labour_fee = #{record.labourFee,jdbcType=VARCHAR}");
        }
        
        if (record.getMaterialFee() != null) {
            sql.SET("material_fee = #{record.materialFee,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceCategory() != null) {
            sql.SET("service_category = #{record.serviceCategory,jdbcType=INTEGER}");
        }
        
        if (record.getUrgencyLevel() != null) {
            sql.SET("urgency_level = #{record.urgencyLevel,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("repair_record");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("trade_no = #{record.tradeNo,jdbcType=VARCHAR}");
        sql.SET("order_no = #{record.orderNo,jdbcType=VARCHAR}");
        sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        sql.SET("master_child_id = #{record.masterChildId,jdbcType=BIGINT}");
        sql.SET("contact = #{record.contact,jdbcType=VARCHAR}");
        sql.SET("contact_mobile = #{record.contactMobile,jdbcType=VARCHAR}");
        sql.SET("problem_type_id = #{record.problemTypeId,jdbcType=INTEGER}");
        sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("content = #{record.content,jdbcType=VARCHAR}");
        sql.SET("atta = #{record.atta,jdbcType=VARCHAR}");
        sql.SET("remimd = #{record.remimd,jdbcType=INTEGER}");
        sql.SET("remimd_time = #{record.remimdTime,jdbcType=TIMESTAMP}");
        sql.SET("score = #{record.score,jdbcType=INTEGER}");
        sql.SET("score_content = #{record.scoreContent,jdbcType=VARCHAR}");
        sql.SET("score_time = #{record.scoreTime,jdbcType=TIMESTAMP}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("type = #{record.type,jdbcType=TINYINT}");
        sql.SET("form_type = #{record.formType,jdbcType=TINYINT}");
        sql.SET("out_reason = #{record.outReason,jdbcType=VARCHAR}");
        sql.SET("labour_fee = #{record.labourFee,jdbcType=VARCHAR}");
        sql.SET("material_fee = #{record.materialFee,jdbcType=VARCHAR}");
        sql.SET("service_category = #{record.serviceCategory,jdbcType=INTEGER}");
        sql.SET("urgency_level = #{record.urgencyLevel,jdbcType=INTEGER}");
        
        RepairRecordExample example = (RepairRecordExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RepairRecord record) {
        SQL sql = new SQL();
        sql.UPDATE("repair_record");
        
        if (record.getTradeNo() != null) {
            sql.SET("trade_no = #{tradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderNo() != null) {
            sql.SET("order_no = #{orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=BIGINT}");
        }
        
        if (record.getMasterChildId() != null) {
            sql.SET("master_child_id = #{masterChildId,jdbcType=BIGINT}");
        }
        
        if (record.getContact() != null) {
            sql.SET("contact = #{contact,jdbcType=VARCHAR}");
        }
        
        if (record.getContactMobile() != null) {
            sql.SET("contact_mobile = #{contactMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getProblemTypeId() != null) {
            sql.SET("problem_type_id = #{problemTypeId,jdbcType=INTEGER}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getAtta() != null) {
            sql.SET("atta = #{atta,jdbcType=VARCHAR}");
        }
        
        if (record.getRemimd() != null) {
            sql.SET("remimd = #{remimd,jdbcType=INTEGER}");
        }
        
        if (record.getRemimdTime() != null) {
            sql.SET("remimd_time = #{remimdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getScore() != null) {
            sql.SET("score = #{score,jdbcType=INTEGER}");
        }
        
        if (record.getScoreContent() != null) {
            sql.SET("score_content = #{scoreContent,jdbcType=VARCHAR}");
        }
        
        if (record.getScoreTime() != null) {
            sql.SET("score_time = #{scoreTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=TINYINT}");
        }
        
        if (record.getFormType() != null) {
            sql.SET("form_type = #{formType,jdbcType=TINYINT}");
        }
        
        if (record.getOutReason() != null) {
            sql.SET("out_reason = #{outReason,jdbcType=VARCHAR}");
        }
        
        if (record.getLabourFee() != null) {
            sql.SET("labour_fee = #{labourFee,jdbcType=VARCHAR}");
        }
        
        if (record.getMaterialFee() != null) {
            sql.SET("material_fee = #{materialFee,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceCategory() != null) {
            sql.SET("service_category = #{serviceCategory,jdbcType=INTEGER}");
        }
        
        if (record.getUrgencyLevel() != null) {
            sql.SET("urgency_level = #{urgencyLevel,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, RepairRecordExample example, boolean includeExamplePhrase) {
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