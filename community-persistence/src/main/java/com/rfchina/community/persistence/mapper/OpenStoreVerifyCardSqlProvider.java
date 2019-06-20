package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreVerifyCard;
import com.rfchina.community.persistence.model.OpenStoreVerifyCardExample.Criteria;
import com.rfchina.community.persistence.model.OpenStoreVerifyCardExample.Criterion;
import com.rfchina.community.persistence.model.OpenStoreVerifyCardExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenStoreVerifyCardSqlProvider {

    public String countByExample(OpenStoreVerifyCardExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_store_verify_card");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenStoreVerifyCardExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_store_verify_card");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenStoreVerifyCard record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_store_verify_card");
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getOrderId() != null) {
            sql.VALUES("order_id", "#{orderId,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=BIGINT}");
        }
        
        if (record.getGoodId() != null) {
            sql.VALUES("good_id", "#{goodId,jdbcType=INTEGER}");
        }
        
        if (record.getGoodOrderRelId() != null) {
            sql.VALUES("good_order_rel_id", "#{goodOrderRelId,jdbcType=INTEGER}");
        }
        
        if (record.getGoodCode() != null) {
            sql.VALUES("good_code", "#{goodCode,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodName() != null) {
            sql.VALUES("good_name", "#{goodName,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getVerifyStartTime() != null) {
            sql.VALUES("verify_start_time", "#{verifyStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyEndTime() != null) {
            sql.VALUES("verify_end_time", "#{verifyEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyStatus() != null) {
            sql.VALUES("verify_status", "#{verifyStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyTime() != null) {
            sql.VALUES("verify_time", "#{verifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSingleScalePrice() != null) {
            sql.VALUES("single_scale_price", "#{singleScalePrice,jdbcType=DECIMAL}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenStoreVerifyCardExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("service_id");
        sql.SELECT("order_id");
        sql.SELECT("uid");
        sql.SELECT("good_id");
        sql.SELECT("good_order_rel_id");
        sql.SELECT("good_code");
        sql.SELECT("good_name");
        sql.SELECT("code");
        sql.SELECT("verify_start_time");
        sql.SELECT("verify_end_time");
        sql.SELECT("verify_status");
        sql.SELECT("create_time");
        sql.SELECT("verify_time");
        sql.SELECT("single_scale_price");
        sql.FROM("open_store_verify_card");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenStoreVerifyCard record = (OpenStoreVerifyCard) parameter.get("record");
        OpenStoreVerifyCardExample example = (OpenStoreVerifyCardExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_store_verify_card");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getOrderId() != null) {
            sql.SET("order_id = #{record.orderId,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        }
        
        if (record.getGoodId() != null) {
            sql.SET("good_id = #{record.goodId,jdbcType=INTEGER}");
        }
        
        if (record.getGoodOrderRelId() != null) {
            sql.SET("good_order_rel_id = #{record.goodOrderRelId,jdbcType=INTEGER}");
        }
        
        if (record.getGoodCode() != null) {
            sql.SET("good_code = #{record.goodCode,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodName() != null) {
            sql.SET("good_name = #{record.goodName,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.SET("code = #{record.code,jdbcType=VARCHAR}");
        }
        
        if (record.getVerifyStartTime() != null) {
            sql.SET("verify_start_time = #{record.verifyStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyEndTime() != null) {
            sql.SET("verify_end_time = #{record.verifyEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyStatus() != null) {
            sql.SET("verify_status = #{record.verifyStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyTime() != null) {
            sql.SET("verify_time = #{record.verifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSingleScalePrice() != null) {
            sql.SET("single_scale_price = #{record.singleScalePrice,jdbcType=DECIMAL}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_verify_card");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("order_id = #{record.orderId,jdbcType=INTEGER}");
        sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        sql.SET("good_id = #{record.goodId,jdbcType=INTEGER}");
        sql.SET("good_order_rel_id = #{record.goodOrderRelId,jdbcType=INTEGER}");
        sql.SET("good_code = #{record.goodCode,jdbcType=VARCHAR}");
        sql.SET("good_name = #{record.goodName,jdbcType=VARCHAR}");
        sql.SET("code = #{record.code,jdbcType=VARCHAR}");
        sql.SET("verify_start_time = #{record.verifyStartTime,jdbcType=TIMESTAMP}");
        sql.SET("verify_end_time = #{record.verifyEndTime,jdbcType=TIMESTAMP}");
        sql.SET("verify_status = #{record.verifyStatus,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("verify_time = #{record.verifyTime,jdbcType=TIMESTAMP}");
        sql.SET("single_scale_price = #{record.singleScalePrice,jdbcType=DECIMAL}");
        
        OpenStoreVerifyCardExample example = (OpenStoreVerifyCardExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenStoreVerifyCard record) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_verify_card");
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getOrderId() != null) {
            sql.SET("order_id = #{orderId,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=BIGINT}");
        }
        
        if (record.getGoodId() != null) {
            sql.SET("good_id = #{goodId,jdbcType=INTEGER}");
        }
        
        if (record.getGoodOrderRelId() != null) {
            sql.SET("good_order_rel_id = #{goodOrderRelId,jdbcType=INTEGER}");
        }
        
        if (record.getGoodCode() != null) {
            sql.SET("good_code = #{goodCode,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodName() != null) {
            sql.SET("good_name = #{goodName,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getVerifyStartTime() != null) {
            sql.SET("verify_start_time = #{verifyStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyEndTime() != null) {
            sql.SET("verify_end_time = #{verifyEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyStatus() != null) {
            sql.SET("verify_status = #{verifyStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyTime() != null) {
            sql.SET("verify_time = #{verifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSingleScalePrice() != null) {
            sql.SET("single_scale_price = #{singleScalePrice,jdbcType=DECIMAL}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenStoreVerifyCardExample example, boolean includeExamplePhrase) {
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