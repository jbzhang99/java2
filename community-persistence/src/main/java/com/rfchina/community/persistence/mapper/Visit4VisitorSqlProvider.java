package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.Visit4Visitor;
import com.rfchina.community.persistence.model.Visit4VisitorExample.Criteria;
import com.rfchina.community.persistence.model.Visit4VisitorExample.Criterion;
import com.rfchina.community.persistence.model.Visit4VisitorExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class Visit4VisitorSqlProvider {

    public String countByExample(Visit4VisitorExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("visit4_visitor");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(Visit4VisitorExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("visit4_visitor");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Visit4Visitor record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("visit4_visitor");
        
        if (record.getVisitId() != null) {
            sql.VALUES("visit_id", "#{visitId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=BIGINT}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getIdcard() != null) {
            sql.VALUES("idcard", "#{idcard,jdbcType=VARCHAR}");
        }
        
        if (record.getQrcodeId() != null) {
            sql.VALUES("qrcode_id", "#{qrcodeId,jdbcType=BIGINT}");
        }
        
        if (record.getQrcodeUuid() != null) {
            sql.VALUES("qrcode_uuid", "#{qrcodeUuid,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(Visit4VisitorExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("visit_id");
        sql.SELECT("name");
        sql.SELECT("uid");
        sql.SELECT("phone");
        sql.SELECT("idcard");
        sql.SELECT("qrcode_id");
        sql.SELECT("qrcode_uuid");
        sql.SELECT("status");
        sql.FROM("visit4_visitor");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Visit4Visitor record = (Visit4Visitor) parameter.get("record");
        Visit4VisitorExample example = (Visit4VisitorExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("visit4_visitor");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getVisitId() != null) {
            sql.SET("visit_id = #{record.visitId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getIdcard() != null) {
            sql.SET("idcard = #{record.idcard,jdbcType=VARCHAR}");
        }
        
        if (record.getQrcodeId() != null) {
            sql.SET("qrcode_id = #{record.qrcodeId,jdbcType=BIGINT}");
        }
        
        if (record.getQrcodeUuid() != null) {
            sql.SET("qrcode_uuid = #{record.qrcodeUuid,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("visit4_visitor");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("visit_id = #{record.visitId,jdbcType=BIGINT}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        sql.SET("idcard = #{record.idcard,jdbcType=VARCHAR}");
        sql.SET("qrcode_id = #{record.qrcodeId,jdbcType=BIGINT}");
        sql.SET("qrcode_uuid = #{record.qrcodeUuid,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        
        Visit4VisitorExample example = (Visit4VisitorExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Visit4Visitor record) {
        SQL sql = new SQL();
        sql.UPDATE("visit4_visitor");
        
        if (record.getVisitId() != null) {
            sql.SET("visit_id = #{visitId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=BIGINT}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getIdcard() != null) {
            sql.SET("idcard = #{idcard,jdbcType=VARCHAR}");
        }
        
        if (record.getQrcodeId() != null) {
            sql.SET("qrcode_id = #{qrcodeId,jdbcType=BIGINT}");
        }
        
        if (record.getQrcodeUuid() != null) {
            sql.SET("qrcode_uuid = #{qrcodeUuid,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, Visit4VisitorExample example, boolean includeExamplePhrase) {
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