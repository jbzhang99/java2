package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenPointRecord;
import com.rfchina.community.persistence.model.OpenPointRecordExample.Criteria;
import com.rfchina.community.persistence.model.OpenPointRecordExample.Criterion;
import com.rfchina.community.persistence.model.OpenPointRecordExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenPointRecordSqlProvider {

    public String countByExample(OpenPointRecordExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_point_record");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenPointRecordExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_point_record");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenPointRecord record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_point_record");
        
        if (record.getOrderId() != null) {
            sql.VALUES("order_id", "#{orderId,jdbcType=BIGINT}");
        }
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=BIGINT}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.VALUES("total_amount", "#{totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getSerialNumber() != null) {
            sql.VALUES("serial_number", "#{serialNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOpenConfCode() != null) {
            sql.VALUES("open_conf_code", "#{openConfCode,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenConfFirstCode() != null) {
            sql.VALUES("open_conf_first_code", "#{openConfFirstCode,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenPointRecordExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("order_id");
        } else {
            sql.SELECT("order_id");
        }
        sql.SELECT("uid");
        sql.SELECT("total_amount");
        sql.SELECT("serial_number");
        sql.SELECT("status");
        sql.SELECT("create_time");
        sql.SELECT("open_conf_code");
        sql.SELECT("open_conf_first_code");
        sql.FROM("open_point_record");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenPointRecord record = (OpenPointRecord) parameter.get("record");
        OpenPointRecordExample example = (OpenPointRecordExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_point_record");
        
        if (record.getOrderId() != null) {
            sql.SET("order_id = #{record.orderId,jdbcType=BIGINT}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.SET("total_amount = #{record.totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getSerialNumber() != null) {
            sql.SET("serial_number = #{record.serialNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOpenConfCode() != null) {
            sql.SET("open_conf_code = #{record.openConfCode,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenConfFirstCode() != null) {
            sql.SET("open_conf_first_code = #{record.openConfFirstCode,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_point_record");
        
        sql.SET("order_id = #{record.orderId,jdbcType=BIGINT}");
        sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        sql.SET("total_amount = #{record.totalAmount,jdbcType=DECIMAL}");
        sql.SET("serial_number = #{record.serialNumber,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("open_conf_code = #{record.openConfCode,jdbcType=VARCHAR}");
        sql.SET("open_conf_first_code = #{record.openConfFirstCode,jdbcType=VARCHAR}");
        
        OpenPointRecordExample example = (OpenPointRecordExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenPointRecord record) {
        SQL sql = new SQL();
        sql.UPDATE("open_point_record");
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=BIGINT}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.SET("total_amount = #{totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getSerialNumber() != null) {
            sql.SET("serial_number = #{serialNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOpenConfCode() != null) {
            sql.SET("open_conf_code = #{openConfCode,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenConfFirstCode() != null) {
            sql.SET("open_conf_first_code = #{openConfFirstCode,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("order_id = #{orderId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenPointRecordExample example, boolean includeExamplePhrase) {
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