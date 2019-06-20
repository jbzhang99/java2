package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreGoodDetail;
import com.rfchina.community.persistence.model.OpenStoreGoodDetailExample.Criteria;
import com.rfchina.community.persistence.model.OpenStoreGoodDetailExample.Criterion;
import com.rfchina.community.persistence.model.OpenStoreGoodDetailExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenStoreGoodDetailSqlProvider {

    public String countByExample(OpenStoreGoodDetailExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_store_good_detail");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenStoreGoodDetailExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_store_good_detail");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenStoreGoodDetail record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_store_good_detail");
        
        if (record.getGoodId() != null) {
            sql.VALUES("good_id", "#{goodId,jdbcType=INTEGER}");
        }
        
        if (record.getDetail() != null) {
            sql.VALUES("detail", "#{detail,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(OpenStoreGoodDetailExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("good_id");
        } else {
            sql.SELECT("good_id");
        }
        sql.SELECT("detail");
        sql.FROM("open_store_good_detail");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenStoreGoodDetailExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("good_id");
        } else {
            sql.SELECT("good_id");
        }
        sql.FROM("open_store_good_detail");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenStoreGoodDetail record = (OpenStoreGoodDetail) parameter.get("record");
        OpenStoreGoodDetailExample example = (OpenStoreGoodDetailExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_store_good_detail");
        
        if (record.getGoodId() != null) {
            sql.SET("good_id = #{record.goodId,jdbcType=INTEGER}");
        }
        
        if (record.getDetail() != null) {
            sql.SET("detail = #{record.detail,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_good_detail");
        
        sql.SET("good_id = #{record.goodId,jdbcType=INTEGER}");
        sql.SET("detail = #{record.detail,jdbcType=LONGVARCHAR}");
        
        OpenStoreGoodDetailExample example = (OpenStoreGoodDetailExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_good_detail");
        
        sql.SET("good_id = #{record.goodId,jdbcType=INTEGER}");
        
        OpenStoreGoodDetailExample example = (OpenStoreGoodDetailExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenStoreGoodDetail record) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_good_detail");
        
        if (record.getDetail() != null) {
            sql.SET("detail = #{detail,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("good_id = #{goodId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenStoreGoodDetailExample example, boolean includeExamplePhrase) {
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