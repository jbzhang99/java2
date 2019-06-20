package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreCoupon;
import com.rfchina.community.persistence.model.OpenStoreCouponExample.Criteria;
import com.rfchina.community.persistence.model.OpenStoreCouponExample.Criterion;
import com.rfchina.community.persistence.model.OpenStoreCouponExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenStoreCouponSqlProvider {

    public String countByExample(OpenStoreCouponExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_store_coupon");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenStoreCouponExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_store_coupon");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenStoreCoupon record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_store_coupon");
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getPic() != null) {
            sql.VALUES("pic", "#{pic,jdbcType=VARCHAR}");
        }
        
        if (record.getSubTitle() != null) {
            sql.VALUES("sub_title", "#{subTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getCouponNo() != null) {
            sql.VALUES("coupon_no", "#{couponNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBeginTime() != null) {
            sql.VALUES("begin_time", "#{beginTime,jdbcType=DATE}");
        }
        
        if (record.getEndTime() != null) {
            sql.VALUES("end_time", "#{endTime,jdbcType=DATE}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDetails() != null) {
            sql.VALUES("details", "#{details,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(OpenStoreCouponExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("service_id");
        sql.SELECT("title");
        sql.SELECT("status");
        sql.SELECT("pic");
        sql.SELECT("sub_title");
        sql.SELECT("coupon_no");
        sql.SELECT("begin_time");
        sql.SELECT("end_time");
        sql.SELECT("create_time");
        sql.SELECT("details");
        sql.FROM("open_store_coupon");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenStoreCouponExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("service_id");
        sql.SELECT("title");
        sql.SELECT("status");
        sql.SELECT("pic");
        sql.SELECT("sub_title");
        sql.SELECT("coupon_no");
        sql.SELECT("begin_time");
        sql.SELECT("end_time");
        sql.SELECT("create_time");
        sql.FROM("open_store_coupon");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenStoreCoupon record = (OpenStoreCoupon) parameter.get("record");
        OpenStoreCouponExample example = (OpenStoreCouponExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_store_coupon");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getPic() != null) {
            sql.SET("pic = #{record.pic,jdbcType=VARCHAR}");
        }
        
        if (record.getSubTitle() != null) {
            sql.SET("sub_title = #{record.subTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getCouponNo() != null) {
            sql.SET("coupon_no = #{record.couponNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBeginTime() != null) {
            sql.SET("begin_time = #{record.beginTime,jdbcType=DATE}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{record.endTime,jdbcType=DATE}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDetails() != null) {
            sql.SET("details = #{record.details,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_coupon");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("pic = #{record.pic,jdbcType=VARCHAR}");
        sql.SET("sub_title = #{record.subTitle,jdbcType=VARCHAR}");
        sql.SET("coupon_no = #{record.couponNo,jdbcType=VARCHAR}");
        sql.SET("begin_time = #{record.beginTime,jdbcType=DATE}");
        sql.SET("end_time = #{record.endTime,jdbcType=DATE}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("details = #{record.details,jdbcType=LONGVARCHAR}");
        
        OpenStoreCouponExample example = (OpenStoreCouponExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_coupon");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("pic = #{record.pic,jdbcType=VARCHAR}");
        sql.SET("sub_title = #{record.subTitle,jdbcType=VARCHAR}");
        sql.SET("coupon_no = #{record.couponNo,jdbcType=VARCHAR}");
        sql.SET("begin_time = #{record.beginTime,jdbcType=DATE}");
        sql.SET("end_time = #{record.endTime,jdbcType=DATE}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        OpenStoreCouponExample example = (OpenStoreCouponExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenStoreCoupon record) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_coupon");
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getPic() != null) {
            sql.SET("pic = #{pic,jdbcType=VARCHAR}");
        }
        
        if (record.getSubTitle() != null) {
            sql.SET("sub_title = #{subTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getCouponNo() != null) {
            sql.SET("coupon_no = #{couponNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBeginTime() != null) {
            sql.SET("begin_time = #{beginTime,jdbcType=DATE}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{endTime,jdbcType=DATE}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDetails() != null) {
            sql.SET("details = #{details,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenStoreCouponExample example, boolean includeExamplePhrase) {
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