package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreGoodOrderRel;
import com.rfchina.community.persistence.model.OpenStoreGoodOrderRelExample.Criteria;
import com.rfchina.community.persistence.model.OpenStoreGoodOrderRelExample.Criterion;
import com.rfchina.community.persistence.model.OpenStoreGoodOrderRelExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenStoreGoodOrderRelSqlProvider {

    public String countByExample(OpenStoreGoodOrderRelExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_store_good_order_rel");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenStoreGoodOrderRelExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_store_good_order_rel");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenStoreGoodOrderRel record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_store_good_order_rel");
        
        if (record.getOrderId() != null) {
            sql.VALUES("order_id", "#{orderId,jdbcType=INTEGER}");
        }
        
        if (record.getGoodId() != null) {
            sql.VALUES("good_id", "#{goodId,jdbcType=INTEGER}");
        }
        
        if (record.getCurrentSinglePrice() != null) {
            sql.VALUES("current_single_price", "#{currentSinglePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getAmount() != null) {
            sql.VALUES("amount", "#{amount,jdbcType=INTEGER}");
        }
        
        if (record.getGoodName() != null) {
            sql.VALUES("good_name", "#{goodName,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodCode() != null) {
            sql.VALUES("good_code", "#{goodCode,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodImgUrl() != null) {
            sql.VALUES("good_img_url", "#{goodImgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getVerifyTimes() != null) {
            sql.VALUES("verify_times", "#{verifyTimes,jdbcType=INTEGER}");
        }
        
        if (record.getVerifyStartTime() != null) {
            sql.VALUES("verify_start_time", "#{verifyStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyEndTime() != null) {
            sql.VALUES("verify_end_time", "#{verifyEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayStatus() != null) {
            sql.VALUES("pay_status", "#{payStatus,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenStoreGoodOrderRelExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("order_id");
        sql.SELECT("good_id");
        sql.SELECT("current_single_price");
        sql.SELECT("amount");
        sql.SELECT("good_name");
        sql.SELECT("good_code");
        sql.SELECT("good_img_url");
        sql.SELECT("verify_times");
        sql.SELECT("verify_start_time");
        sql.SELECT("verify_end_time");
        sql.SELECT("pay_status");
        sql.FROM("open_store_good_order_rel");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenStoreGoodOrderRel record = (OpenStoreGoodOrderRel) parameter.get("record");
        OpenStoreGoodOrderRelExample example = (OpenStoreGoodOrderRelExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_store_good_order_rel");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getOrderId() != null) {
            sql.SET("order_id = #{record.orderId,jdbcType=INTEGER}");
        }
        
        if (record.getGoodId() != null) {
            sql.SET("good_id = #{record.goodId,jdbcType=INTEGER}");
        }
        
        if (record.getCurrentSinglePrice() != null) {
            sql.SET("current_single_price = #{record.currentSinglePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getAmount() != null) {
            sql.SET("amount = #{record.amount,jdbcType=INTEGER}");
        }
        
        if (record.getGoodName() != null) {
            sql.SET("good_name = #{record.goodName,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodCode() != null) {
            sql.SET("good_code = #{record.goodCode,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodImgUrl() != null) {
            sql.SET("good_img_url = #{record.goodImgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getVerifyTimes() != null) {
            sql.SET("verify_times = #{record.verifyTimes,jdbcType=INTEGER}");
        }
        
        if (record.getVerifyStartTime() != null) {
            sql.SET("verify_start_time = #{record.verifyStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyEndTime() != null) {
            sql.SET("verify_end_time = #{record.verifyEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayStatus() != null) {
            sql.SET("pay_status = #{record.payStatus,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_good_order_rel");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("order_id = #{record.orderId,jdbcType=INTEGER}");
        sql.SET("good_id = #{record.goodId,jdbcType=INTEGER}");
        sql.SET("current_single_price = #{record.currentSinglePrice,jdbcType=DECIMAL}");
        sql.SET("amount = #{record.amount,jdbcType=INTEGER}");
        sql.SET("good_name = #{record.goodName,jdbcType=VARCHAR}");
        sql.SET("good_code = #{record.goodCode,jdbcType=VARCHAR}");
        sql.SET("good_img_url = #{record.goodImgUrl,jdbcType=VARCHAR}");
        sql.SET("verify_times = #{record.verifyTimes,jdbcType=INTEGER}");
        sql.SET("verify_start_time = #{record.verifyStartTime,jdbcType=TIMESTAMP}");
        sql.SET("verify_end_time = #{record.verifyEndTime,jdbcType=TIMESTAMP}");
        sql.SET("pay_status = #{record.payStatus,jdbcType=INTEGER}");
        
        OpenStoreGoodOrderRelExample example = (OpenStoreGoodOrderRelExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenStoreGoodOrderRel record) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_good_order_rel");
        
        if (record.getOrderId() != null) {
            sql.SET("order_id = #{orderId,jdbcType=INTEGER}");
        }
        
        if (record.getGoodId() != null) {
            sql.SET("good_id = #{goodId,jdbcType=INTEGER}");
        }
        
        if (record.getCurrentSinglePrice() != null) {
            sql.SET("current_single_price = #{currentSinglePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getAmount() != null) {
            sql.SET("amount = #{amount,jdbcType=INTEGER}");
        }
        
        if (record.getGoodName() != null) {
            sql.SET("good_name = #{goodName,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodCode() != null) {
            sql.SET("good_code = #{goodCode,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodImgUrl() != null) {
            sql.SET("good_img_url = #{goodImgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getVerifyTimes() != null) {
            sql.SET("verify_times = #{verifyTimes,jdbcType=INTEGER}");
        }
        
        if (record.getVerifyStartTime() != null) {
            sql.SET("verify_start_time = #{verifyStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyEndTime() != null) {
            sql.SET("verify_end_time = #{verifyEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayStatus() != null) {
            sql.SET("pay_status = #{payStatus,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenStoreGoodOrderRelExample example, boolean includeExamplePhrase) {
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