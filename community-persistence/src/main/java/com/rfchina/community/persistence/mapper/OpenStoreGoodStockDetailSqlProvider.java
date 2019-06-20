package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreGoodStockDetail;
import com.rfchina.community.persistence.model.OpenStoreGoodStockDetailExample.Criteria;
import com.rfchina.community.persistence.model.OpenStoreGoodStockDetailExample.Criterion;
import com.rfchina.community.persistence.model.OpenStoreGoodStockDetailExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenStoreGoodStockDetailSqlProvider {

    public String countByExample(OpenStoreGoodStockDetailExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_store_good_stock_detail");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenStoreGoodStockDetailExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_store_good_stock_detail");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenStoreGoodStockDetail record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_store_good_stock_detail");
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getGroupDataId() != null) {
            sql.VALUES("group_data_id", "#{groupDataId,jdbcType=BIGINT}");
        }
        
        if (record.getGroupInfoId() != null) {
            sql.VALUES("group_info_id", "#{groupInfoId,jdbcType=BIGINT}");
        }
        
        if (record.getGoodId() != null) {
            sql.VALUES("good_id", "#{goodId,jdbcType=INTEGER}");
        }
        
        if (record.getSource() != null) {
            sql.VALUES("source", "#{source,jdbcType=VARCHAR}");
        }
        
        if (record.getOperate() != null) {
            sql.VALUES("operate", "#{operate,jdbcType=VARCHAR}");
        }
        
        if (record.getBeforeValue() != null) {
            sql.VALUES("before_value", "#{beforeValue,jdbcType=INTEGER}");
        }
        
        if (record.getAfterValue() != null) {
            sql.VALUES("after_value", "#{afterValue,jdbcType=INTEGER}");
        }
        
        if (record.getAmount() != null) {
            sql.VALUES("amount", "#{amount,jdbcType=INTEGER}");
        }
        
        if (record.getTargetId() != null) {
            sql.VALUES("target_id", "#{targetId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenStoreGoodStockDetailExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("type");
        sql.SELECT("group_data_id");
        sql.SELECT("group_info_id");
        sql.SELECT("good_id");
        sql.SELECT("source");
        sql.SELECT("operate");
        sql.SELECT("before_value");
        sql.SELECT("after_value");
        sql.SELECT("amount");
        sql.SELECT("target_id");
        sql.SELECT("create_time");
        sql.FROM("open_store_good_stock_detail");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenStoreGoodStockDetail record = (OpenStoreGoodStockDetail) parameter.get("record");
        OpenStoreGoodStockDetailExample example = (OpenStoreGoodStockDetailExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_store_good_stock_detail");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=VARCHAR}");
        }
        
        if (record.getGroupDataId() != null) {
            sql.SET("group_data_id = #{record.groupDataId,jdbcType=BIGINT}");
        }
        
        if (record.getGroupInfoId() != null) {
            sql.SET("group_info_id = #{record.groupInfoId,jdbcType=BIGINT}");
        }
        
        if (record.getGoodId() != null) {
            sql.SET("good_id = #{record.goodId,jdbcType=INTEGER}");
        }
        
        if (record.getSource() != null) {
            sql.SET("source = #{record.source,jdbcType=VARCHAR}");
        }
        
        if (record.getOperate() != null) {
            sql.SET("operate = #{record.operate,jdbcType=VARCHAR}");
        }
        
        if (record.getBeforeValue() != null) {
            sql.SET("before_value = #{record.beforeValue,jdbcType=INTEGER}");
        }
        
        if (record.getAfterValue() != null) {
            sql.SET("after_value = #{record.afterValue,jdbcType=INTEGER}");
        }
        
        if (record.getAmount() != null) {
            sql.SET("amount = #{record.amount,jdbcType=INTEGER}");
        }
        
        if (record.getTargetId() != null) {
            sql.SET("target_id = #{record.targetId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_good_stock_detail");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("type = #{record.type,jdbcType=VARCHAR}");
        sql.SET("group_data_id = #{record.groupDataId,jdbcType=BIGINT}");
        sql.SET("group_info_id = #{record.groupInfoId,jdbcType=BIGINT}");
        sql.SET("good_id = #{record.goodId,jdbcType=INTEGER}");
        sql.SET("source = #{record.source,jdbcType=VARCHAR}");
        sql.SET("operate = #{record.operate,jdbcType=VARCHAR}");
        sql.SET("before_value = #{record.beforeValue,jdbcType=INTEGER}");
        sql.SET("after_value = #{record.afterValue,jdbcType=INTEGER}");
        sql.SET("amount = #{record.amount,jdbcType=INTEGER}");
        sql.SET("target_id = #{record.targetId,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        OpenStoreGoodStockDetailExample example = (OpenStoreGoodStockDetailExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenStoreGoodStockDetail record) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_good_stock_detail");
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getGroupDataId() != null) {
            sql.SET("group_data_id = #{groupDataId,jdbcType=BIGINT}");
        }
        
        if (record.getGroupInfoId() != null) {
            sql.SET("group_info_id = #{groupInfoId,jdbcType=BIGINT}");
        }
        
        if (record.getGoodId() != null) {
            sql.SET("good_id = #{goodId,jdbcType=INTEGER}");
        }
        
        if (record.getSource() != null) {
            sql.SET("source = #{source,jdbcType=VARCHAR}");
        }
        
        if (record.getOperate() != null) {
            sql.SET("operate = #{operate,jdbcType=VARCHAR}");
        }
        
        if (record.getBeforeValue() != null) {
            sql.SET("before_value = #{beforeValue,jdbcType=INTEGER}");
        }
        
        if (record.getAfterValue() != null) {
            sql.SET("after_value = #{afterValue,jdbcType=INTEGER}");
        }
        
        if (record.getAmount() != null) {
            sql.SET("amount = #{amount,jdbcType=INTEGER}");
        }
        
        if (record.getTargetId() != null) {
            sql.SET("target_id = #{targetId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenStoreGoodStockDetailExample example, boolean includeExamplePhrase) {
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