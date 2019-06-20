package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.RepairRecordProgress;
import com.rfchina.community.persistence.model.RepairRecordProgressExample.Criteria;
import com.rfchina.community.persistence.model.RepairRecordProgressExample.Criterion;
import com.rfchina.community.persistence.model.RepairRecordProgressExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class RepairRecordProgressSqlProvider {

    public String countByExample(RepairRecordProgressExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("repair_record_progress");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(RepairRecordProgressExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("repair_record_progress");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(RepairRecordProgress record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("repair_record_progress");
        
        if (record.getTradeNo() != null) {
            sql.VALUES("trade_no", "#{tradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderNo() != null) {
            sql.VALUES("order_no", "#{orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getOutId() != null) {
            sql.VALUES("out_id", "#{outId,jdbcType=VARCHAR}");
        }
        
        if (record.getProcessor() != null) {
            sql.VALUES("processor", "#{processor,jdbcType=VARCHAR}");
        }
        
        if (record.getProcessorMobile() != null) {
            sql.VALUES("processor_mobile", "#{processorMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getProcessorTime() != null) {
            sql.VALUES("processor_time", "#{processorTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getOutDetail() != null) {
            sql.VALUES("out_detail", "#{outDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(RepairRecordProgressExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("trade_no");
        sql.SELECT("order_no");
        sql.SELECT("out_id");
        sql.SELECT("processor");
        sql.SELECT("processor_mobile");
        sql.SELECT("processor_time");
        sql.SELECT("remark");
        sql.SELECT("out_detail");
        sql.SELECT("create_time");
        sql.SELECT("status");
        sql.FROM("repair_record_progress");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        RepairRecordProgress record = (RepairRecordProgress) parameter.get("record");
        RepairRecordProgressExample example = (RepairRecordProgressExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("repair_record_progress");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getTradeNo() != null) {
            sql.SET("trade_no = #{record.tradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderNo() != null) {
            sql.SET("order_no = #{record.orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getOutId() != null) {
            sql.SET("out_id = #{record.outId,jdbcType=VARCHAR}");
        }
        
        if (record.getProcessor() != null) {
            sql.SET("processor = #{record.processor,jdbcType=VARCHAR}");
        }
        
        if (record.getProcessorMobile() != null) {
            sql.SET("processor_mobile = #{record.processorMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getProcessorTime() != null) {
            sql.SET("processor_time = #{record.processorTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getOutDetail() != null) {
            sql.SET("out_detail = #{record.outDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=TINYINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("repair_record_progress");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("trade_no = #{record.tradeNo,jdbcType=VARCHAR}");
        sql.SET("order_no = #{record.orderNo,jdbcType=VARCHAR}");
        sql.SET("out_id = #{record.outId,jdbcType=VARCHAR}");
        sql.SET("processor = #{record.processor,jdbcType=VARCHAR}");
        sql.SET("processor_mobile = #{record.processorMobile,jdbcType=VARCHAR}");
        sql.SET("processor_time = #{record.processorTime,jdbcType=TIMESTAMP}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("out_detail = #{record.outDetail,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        
        RepairRecordProgressExample example = (RepairRecordProgressExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RepairRecordProgress record) {
        SQL sql = new SQL();
        sql.UPDATE("repair_record_progress");
        
        if (record.getTradeNo() != null) {
            sql.SET("trade_no = #{tradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderNo() != null) {
            sql.SET("order_no = #{orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getOutId() != null) {
            sql.SET("out_id = #{outId,jdbcType=VARCHAR}");
        }
        
        if (record.getProcessor() != null) {
            sql.SET("processor = #{processor,jdbcType=VARCHAR}");
        }
        
        if (record.getProcessorMobile() != null) {
            sql.SET("processor_mobile = #{processorMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getProcessorTime() != null) {
            sql.SET("processor_time = #{processorTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getOutDetail() != null) {
            sql.SET("out_detail = #{outDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, RepairRecordProgressExample example, boolean includeExamplePhrase) {
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