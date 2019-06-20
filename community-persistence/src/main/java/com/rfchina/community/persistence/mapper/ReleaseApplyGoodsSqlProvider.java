package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.ReleaseApplyGoods;
import com.rfchina.community.persistence.model.ReleaseApplyGoodsExample.Criteria;
import com.rfchina.community.persistence.model.ReleaseApplyGoodsExample.Criterion;
import com.rfchina.community.persistence.model.ReleaseApplyGoodsExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ReleaseApplyGoodsSqlProvider {

    public String countByExample(ReleaseApplyGoodsExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("release_apply_goods");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ReleaseApplyGoodsExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("release_apply_goods");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ReleaseApplyGoods record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("release_apply_goods");
        
        if (record.getApplicantName() != null) {
            sql.VALUES("applicant_name", "#{applicantName,jdbcType=VARCHAR}");
        }
        
        if (record.getApplicantPhone() != null) {
            sql.VALUES("applicant_phone", "#{applicantPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getCarrierName() != null) {
            sql.VALUES("carrier_name", "#{carrierName,jdbcType=VARCHAR}");
        }
        
        if (record.getCarrierPhone() != null) {
            sql.VALUES("carrier_phone", "#{carrierPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getReleaseEndTime() != null) {
            sql.VALUES("release_end_time", "#{releaseEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReleaseStartTime() != null) {
            sql.VALUES("release_start_time", "#{releaseStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getAuditTime() != null) {
            sql.VALUES("audit_time", "#{auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditUid() != null) {
            sql.VALUES("audit_uid", "#{auditUid,jdbcType=BIGINT}");
        }
        
        if (record.getAuditContent() != null) {
            sql.VALUES("audit_content", "#{auditContent,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateUid() != null) {
            sql.VALUES("create_uid", "#{createUid,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getMasterId() != null) {
            sql.VALUES("master_id", "#{masterId,jdbcType=BIGINT}");
        }
        
        if (record.getExePhone() != null) {
            sql.VALUES("exe_phone", "#{exePhone,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsJson() != null) {
            sql.VALUES("goods_json", "#{goodsJson,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(ReleaseApplyGoodsExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("applicant_name");
        sql.SELECT("applicant_phone");
        sql.SELECT("carrier_name");
        sql.SELECT("carrier_phone");
        sql.SELECT("release_end_time");
        sql.SELECT("release_start_time");
        sql.SELECT("create_time");
        sql.SELECT("status");
        sql.SELECT("audit_time");
        sql.SELECT("audit_uid");
        sql.SELECT("audit_content");
        sql.SELECT("create_uid");
        sql.SELECT("community_id");
        sql.SELECT("master_id");
        sql.SELECT("exe_phone");
        sql.SELECT("goods_json");
        sql.FROM("release_apply_goods");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(ReleaseApplyGoodsExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("applicant_name");
        sql.SELECT("applicant_phone");
        sql.SELECT("carrier_name");
        sql.SELECT("carrier_phone");
        sql.SELECT("release_end_time");
        sql.SELECT("release_start_time");
        sql.SELECT("create_time");
        sql.SELECT("status");
        sql.SELECT("audit_time");
        sql.SELECT("audit_uid");
        sql.SELECT("audit_content");
        sql.SELECT("create_uid");
        sql.SELECT("community_id");
        sql.SELECT("master_id");
        sql.SELECT("exe_phone");
        sql.FROM("release_apply_goods");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ReleaseApplyGoods record = (ReleaseApplyGoods) parameter.get("record");
        ReleaseApplyGoodsExample example = (ReleaseApplyGoodsExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("release_apply_goods");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getApplicantName() != null) {
            sql.SET("applicant_name = #{record.applicantName,jdbcType=VARCHAR}");
        }
        
        if (record.getApplicantPhone() != null) {
            sql.SET("applicant_phone = #{record.applicantPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getCarrierName() != null) {
            sql.SET("carrier_name = #{record.carrierName,jdbcType=VARCHAR}");
        }
        
        if (record.getCarrierPhone() != null) {
            sql.SET("carrier_phone = #{record.carrierPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getReleaseEndTime() != null) {
            sql.SET("release_end_time = #{record.releaseEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReleaseStartTime() != null) {
            sql.SET("release_start_time = #{record.releaseStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getAuditTime() != null) {
            sql.SET("audit_time = #{record.auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditUid() != null) {
            sql.SET("audit_uid = #{record.auditUid,jdbcType=BIGINT}");
        }
        
        if (record.getAuditContent() != null) {
            sql.SET("audit_content = #{record.auditContent,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateUid() != null) {
            sql.SET("create_uid = #{record.createUid,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getMasterId() != null) {
            sql.SET("master_id = #{record.masterId,jdbcType=BIGINT}");
        }
        
        if (record.getExePhone() != null) {
            sql.SET("exe_phone = #{record.exePhone,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsJson() != null) {
            sql.SET("goods_json = #{record.goodsJson,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("release_apply_goods");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("applicant_name = #{record.applicantName,jdbcType=VARCHAR}");
        sql.SET("applicant_phone = #{record.applicantPhone,jdbcType=VARCHAR}");
        sql.SET("carrier_name = #{record.carrierName,jdbcType=VARCHAR}");
        sql.SET("carrier_phone = #{record.carrierPhone,jdbcType=VARCHAR}");
        sql.SET("release_end_time = #{record.releaseEndTime,jdbcType=TIMESTAMP}");
        sql.SET("release_start_time = #{record.releaseStartTime,jdbcType=TIMESTAMP}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("audit_time = #{record.auditTime,jdbcType=TIMESTAMP}");
        sql.SET("audit_uid = #{record.auditUid,jdbcType=BIGINT}");
        sql.SET("audit_content = #{record.auditContent,jdbcType=VARCHAR}");
        sql.SET("create_uid = #{record.createUid,jdbcType=BIGINT}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("master_id = #{record.masterId,jdbcType=BIGINT}");
        sql.SET("exe_phone = #{record.exePhone,jdbcType=VARCHAR}");
        sql.SET("goods_json = #{record.goodsJson,jdbcType=LONGVARCHAR}");
        
        ReleaseApplyGoodsExample example = (ReleaseApplyGoodsExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("release_apply_goods");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("applicant_name = #{record.applicantName,jdbcType=VARCHAR}");
        sql.SET("applicant_phone = #{record.applicantPhone,jdbcType=VARCHAR}");
        sql.SET("carrier_name = #{record.carrierName,jdbcType=VARCHAR}");
        sql.SET("carrier_phone = #{record.carrierPhone,jdbcType=VARCHAR}");
        sql.SET("release_end_time = #{record.releaseEndTime,jdbcType=TIMESTAMP}");
        sql.SET("release_start_time = #{record.releaseStartTime,jdbcType=TIMESTAMP}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("audit_time = #{record.auditTime,jdbcType=TIMESTAMP}");
        sql.SET("audit_uid = #{record.auditUid,jdbcType=BIGINT}");
        sql.SET("audit_content = #{record.auditContent,jdbcType=VARCHAR}");
        sql.SET("create_uid = #{record.createUid,jdbcType=BIGINT}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("master_id = #{record.masterId,jdbcType=BIGINT}");
        sql.SET("exe_phone = #{record.exePhone,jdbcType=VARCHAR}");
        
        ReleaseApplyGoodsExample example = (ReleaseApplyGoodsExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ReleaseApplyGoods record) {
        SQL sql = new SQL();
        sql.UPDATE("release_apply_goods");
        
        if (record.getApplicantName() != null) {
            sql.SET("applicant_name = #{applicantName,jdbcType=VARCHAR}");
        }
        
        if (record.getApplicantPhone() != null) {
            sql.SET("applicant_phone = #{applicantPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getCarrierName() != null) {
            sql.SET("carrier_name = #{carrierName,jdbcType=VARCHAR}");
        }
        
        if (record.getCarrierPhone() != null) {
            sql.SET("carrier_phone = #{carrierPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getReleaseEndTime() != null) {
            sql.SET("release_end_time = #{releaseEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReleaseStartTime() != null) {
            sql.SET("release_start_time = #{releaseStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getAuditTime() != null) {
            sql.SET("audit_time = #{auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditUid() != null) {
            sql.SET("audit_uid = #{auditUid,jdbcType=BIGINT}");
        }
        
        if (record.getAuditContent() != null) {
            sql.SET("audit_content = #{auditContent,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateUid() != null) {
            sql.SET("create_uid = #{createUid,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getMasterId() != null) {
            sql.SET("master_id = #{masterId,jdbcType=BIGINT}");
        }
        
        if (record.getExePhone() != null) {
            sql.SET("exe_phone = #{exePhone,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsJson() != null) {
            sql.SET("goods_json = #{goodsJson,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ReleaseApplyGoodsExample example, boolean includeExamplePhrase) {
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