package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CmActivityCardCouponItem;
import com.rfchina.community.persistence.model.CmActivityCardCouponItemExample.Criteria;
import com.rfchina.community.persistence.model.CmActivityCardCouponItemExample.Criterion;
import com.rfchina.community.persistence.model.CmActivityCardCouponItemExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CmActivityCardCouponItemSqlProvider {

    public String countByExample(CmActivityCardCouponItemExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("cm_activity_card_coupon_item");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CmActivityCardCouponItemExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("cm_activity_card_coupon_item");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CmActivityCardCouponItem record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("cm_activity_card_coupon_item");
        
        if (record.getCouponName() != null) {
            sql.VALUES("coupon_name", "#{couponName,jdbcType=VARCHAR}");
        }
        
        if (record.getCouponType() != null) {
            sql.VALUES("coupon_type", "#{couponType,jdbcType=INTEGER}");
        }
        
        if (record.getCouponNum() != null) {
            sql.VALUES("coupon_num", "#{couponNum,jdbcType=INTEGER}");
        }
        
        if (record.getStockNum() != null) {
            sql.VALUES("stock_num", "#{stockNum,jdbcType=INTEGER}");
        }
        
        if (record.getValidFromDate() != null) {
            sql.VALUES("valid_from_date", "#{validFromDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getValidToDate() != null) {
            sql.VALUES("valid_to_date", "#{validToDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAllowFromDate() != null) {
            sql.VALUES("allow_from_date", "#{allowFromDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAllowToDate() != null) {
            sql.VALUES("allow_to_date", "#{allowToDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getItemType() != null) {
            sql.VALUES("item_type", "#{itemType,jdbcType=INTEGER}");
        }
        
        if (record.getUseRule() != null) {
            sql.VALUES("use_rule", "#{useRule,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCouponAmount() != null) {
            sql.VALUES("coupon_amount", "#{couponAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayAmount() != null) {
            sql.VALUES("pay_amount", "#{payAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getOpenStatus() != null) {
            sql.VALUES("open_status", "#{openStatus,jdbcType=INTEGER}");
        }
        
        if (record.getDeliverNum() != null) {
            sql.VALUES("deliver_num", "#{deliverNum,jdbcType=INTEGER}");
        }
        
        if (record.getUserLimit() != null) {
            sql.VALUES("user_limit", "#{userLimit,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CmActivityCardCouponItemExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("coupon_name");
        sql.SELECT("coupon_type");
        sql.SELECT("coupon_num");
        sql.SELECT("stock_num");
        sql.SELECT("valid_from_date");
        sql.SELECT("valid_to_date");
        sql.SELECT("allow_from_date");
        sql.SELECT("allow_to_date");
        sql.SELECT("item_type");
        sql.SELECT("use_rule");
        sql.SELECT("remark");
        sql.SELECT("coupon_amount");
        sql.SELECT("pay_amount");
        sql.SELECT("open_status");
        sql.SELECT("deliver_num");
        sql.SELECT("user_limit");
        sql.SELECT("status");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("cm_activity_card_coupon_item");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CmActivityCardCouponItem record = (CmActivityCardCouponItem) parameter.get("record");
        CmActivityCardCouponItemExample example = (CmActivityCardCouponItemExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("cm_activity_card_coupon_item");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCouponName() != null) {
            sql.SET("coupon_name = #{record.couponName,jdbcType=VARCHAR}");
        }
        
        if (record.getCouponType() != null) {
            sql.SET("coupon_type = #{record.couponType,jdbcType=INTEGER}");
        }
        
        if (record.getCouponNum() != null) {
            sql.SET("coupon_num = #{record.couponNum,jdbcType=INTEGER}");
        }
        
        if (record.getStockNum() != null) {
            sql.SET("stock_num = #{record.stockNum,jdbcType=INTEGER}");
        }
        
        if (record.getValidFromDate() != null) {
            sql.SET("valid_from_date = #{record.validFromDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getValidToDate() != null) {
            sql.SET("valid_to_date = #{record.validToDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAllowFromDate() != null) {
            sql.SET("allow_from_date = #{record.allowFromDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAllowToDate() != null) {
            sql.SET("allow_to_date = #{record.allowToDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getItemType() != null) {
            sql.SET("item_type = #{record.itemType,jdbcType=INTEGER}");
        }
        
        if (record.getUseRule() != null) {
            sql.SET("use_rule = #{record.useRule,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCouponAmount() != null) {
            sql.SET("coupon_amount = #{record.couponAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayAmount() != null) {
            sql.SET("pay_amount = #{record.payAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getOpenStatus() != null) {
            sql.SET("open_status = #{record.openStatus,jdbcType=INTEGER}");
        }
        
        if (record.getDeliverNum() != null) {
            sql.SET("deliver_num = #{record.deliverNum,jdbcType=INTEGER}");
        }
        
        if (record.getUserLimit() != null) {
            sql.SET("user_limit = #{record.userLimit,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("cm_activity_card_coupon_item");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("coupon_name = #{record.couponName,jdbcType=VARCHAR}");
        sql.SET("coupon_type = #{record.couponType,jdbcType=INTEGER}");
        sql.SET("coupon_num = #{record.couponNum,jdbcType=INTEGER}");
        sql.SET("stock_num = #{record.stockNum,jdbcType=INTEGER}");
        sql.SET("valid_from_date = #{record.validFromDate,jdbcType=TIMESTAMP}");
        sql.SET("valid_to_date = #{record.validToDate,jdbcType=TIMESTAMP}");
        sql.SET("allow_from_date = #{record.allowFromDate,jdbcType=TIMESTAMP}");
        sql.SET("allow_to_date = #{record.allowToDate,jdbcType=TIMESTAMP}");
        sql.SET("item_type = #{record.itemType,jdbcType=INTEGER}");
        sql.SET("use_rule = #{record.useRule,jdbcType=VARCHAR}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("coupon_amount = #{record.couponAmount,jdbcType=DECIMAL}");
        sql.SET("pay_amount = #{record.payAmount,jdbcType=DECIMAL}");
        sql.SET("open_status = #{record.openStatus,jdbcType=INTEGER}");
        sql.SET("deliver_num = #{record.deliverNum,jdbcType=INTEGER}");
        sql.SET("user_limit = #{record.userLimit,jdbcType=INTEGER}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        CmActivityCardCouponItemExample example = (CmActivityCardCouponItemExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CmActivityCardCouponItem record) {
        SQL sql = new SQL();
        sql.UPDATE("cm_activity_card_coupon_item");
        
        if (record.getCouponName() != null) {
            sql.SET("coupon_name = #{couponName,jdbcType=VARCHAR}");
        }
        
        if (record.getCouponType() != null) {
            sql.SET("coupon_type = #{couponType,jdbcType=INTEGER}");
        }
        
        if (record.getCouponNum() != null) {
            sql.SET("coupon_num = #{couponNum,jdbcType=INTEGER}");
        }
        
        if (record.getStockNum() != null) {
            sql.SET("stock_num = #{stockNum,jdbcType=INTEGER}");
        }
        
        if (record.getValidFromDate() != null) {
            sql.SET("valid_from_date = #{validFromDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getValidToDate() != null) {
            sql.SET("valid_to_date = #{validToDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAllowFromDate() != null) {
            sql.SET("allow_from_date = #{allowFromDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAllowToDate() != null) {
            sql.SET("allow_to_date = #{allowToDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getItemType() != null) {
            sql.SET("item_type = #{itemType,jdbcType=INTEGER}");
        }
        
        if (record.getUseRule() != null) {
            sql.SET("use_rule = #{useRule,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCouponAmount() != null) {
            sql.SET("coupon_amount = #{couponAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayAmount() != null) {
            sql.SET("pay_amount = #{payAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getOpenStatus() != null) {
            sql.SET("open_status = #{openStatus,jdbcType=INTEGER}");
        }
        
        if (record.getDeliverNum() != null) {
            sql.SET("deliver_num = #{deliverNum,jdbcType=INTEGER}");
        }
        
        if (record.getUserLimit() != null) {
            sql.SET("user_limit = #{userLimit,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CmActivityCardCouponItemExample example, boolean includeExamplePhrase) {
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