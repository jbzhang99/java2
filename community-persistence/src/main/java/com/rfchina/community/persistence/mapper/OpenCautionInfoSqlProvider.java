package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenCautionInfo;
import com.rfchina.community.persistence.model.OpenCautionInfoExample.Criteria;
import com.rfchina.community.persistence.model.OpenCautionInfoExample.Criterion;
import com.rfchina.community.persistence.model.OpenCautionInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenCautionInfoSqlProvider {

    public String countByExample(OpenCautionInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_caution_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenCautionInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_caution_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenCautionInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_caution_info");
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getMoney() != null) {
            sql.VALUES("money", "#{money,jdbcType=DECIMAL}");
        }
        
        if (record.getBillId() != null) {
            sql.VALUES("bill_id", "#{billId,jdbcType=VARCHAR}");
        }
        
        if (record.getBillCreateTime() != null) {
            sql.VALUES("bill_create_time", "#{billCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBillStatus() != null) {
            sql.VALUES("bill_status", "#{billStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBillPayTime() != null) {
            sql.VALUES("bill_pay_time", "#{billPayTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getPayTime() != null) {
            sql.VALUES("pay_time", "#{payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUid() != null) {
            sql.VALUES("create_uid", "#{createUid,jdbcType=BIGINT}");
        }
        
        if (record.getMoneyType() != null) {
            sql.VALUES("money_type", "#{moneyType,jdbcType=CHAR}");
        }
        
        if (record.getMoneyPic() != null) {
            sql.VALUES("money_pic", "#{moneyPic,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenId() != null) {
            sql.VALUES("open_id", "#{openId,jdbcType=BIGINT}");
        }
        
        if (record.getRemarks() != null) {
            sql.VALUES("remarks", "#{remarks,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenCautionInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("service_id");
        sql.SELECT("money");
        sql.SELECT("bill_id");
        sql.SELECT("bill_create_time");
        sql.SELECT("bill_status");
        sql.SELECT("bill_pay_time");
        sql.SELECT("create_time");
        sql.SELECT("status");
        sql.SELECT("pay_time");
        sql.SELECT("create_uid");
        sql.SELECT("money_type");
        sql.SELECT("money_pic");
        sql.SELECT("open_id");
        sql.SELECT("remarks");
        sql.FROM("open_caution_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenCautionInfo record = (OpenCautionInfo) parameter.get("record");
        OpenCautionInfoExample example = (OpenCautionInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_caution_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getMoney() != null) {
            sql.SET("money = #{record.money,jdbcType=DECIMAL}");
        }
        
        if (record.getBillId() != null) {
            sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        }
        
        if (record.getBillCreateTime() != null) {
            sql.SET("bill_create_time = #{record.billCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBillStatus() != null) {
            sql.SET("bill_status = #{record.billStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBillPayTime() != null) {
            sql.SET("bill_pay_time = #{record.billPayTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getPayTime() != null) {
            sql.SET("pay_time = #{record.payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUid() != null) {
            sql.SET("create_uid = #{record.createUid,jdbcType=BIGINT}");
        }
        
        if (record.getMoneyType() != null) {
            sql.SET("money_type = #{record.moneyType,jdbcType=CHAR}");
        }
        
        if (record.getMoneyPic() != null) {
            sql.SET("money_pic = #{record.moneyPic,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenId() != null) {
            sql.SET("open_id = #{record.openId,jdbcType=BIGINT}");
        }
        
        if (record.getRemarks() != null) {
            sql.SET("remarks = #{record.remarks,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_caution_info");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("money = #{record.money,jdbcType=DECIMAL}");
        sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        sql.SET("bill_create_time = #{record.billCreateTime,jdbcType=TIMESTAMP}");
        sql.SET("bill_status = #{record.billStatus,jdbcType=INTEGER}");
        sql.SET("bill_pay_time = #{record.billPayTime,jdbcType=TIMESTAMP}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("pay_time = #{record.payTime,jdbcType=TIMESTAMP}");
        sql.SET("create_uid = #{record.createUid,jdbcType=BIGINT}");
        sql.SET("money_type = #{record.moneyType,jdbcType=CHAR}");
        sql.SET("money_pic = #{record.moneyPic,jdbcType=VARCHAR}");
        sql.SET("open_id = #{record.openId,jdbcType=BIGINT}");
        sql.SET("remarks = #{record.remarks,jdbcType=VARCHAR}");
        
        OpenCautionInfoExample example = (OpenCautionInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenCautionInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("open_caution_info");
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getMoney() != null) {
            sql.SET("money = #{money,jdbcType=DECIMAL}");
        }
        
        if (record.getBillId() != null) {
            sql.SET("bill_id = #{billId,jdbcType=VARCHAR}");
        }
        
        if (record.getBillCreateTime() != null) {
            sql.SET("bill_create_time = #{billCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBillStatus() != null) {
            sql.SET("bill_status = #{billStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBillPayTime() != null) {
            sql.SET("bill_pay_time = #{billPayTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getPayTime() != null) {
            sql.SET("pay_time = #{payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUid() != null) {
            sql.SET("create_uid = #{createUid,jdbcType=BIGINT}");
        }
        
        if (record.getMoneyType() != null) {
            sql.SET("money_type = #{moneyType,jdbcType=CHAR}");
        }
        
        if (record.getMoneyPic() != null) {
            sql.SET("money_pic = #{moneyPic,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenId() != null) {
            sql.SET("open_id = #{openId,jdbcType=BIGINT}");
        }
        
        if (record.getRemarks() != null) {
            sql.SET("remarks = #{remarks,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenCautionInfoExample example, boolean includeExamplePhrase) {
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