package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenServiceDetail;
import com.rfchina.community.persistence.model.OpenServiceDetailExample.Criteria;
import com.rfchina.community.persistence.model.OpenServiceDetailExample.Criterion;
import com.rfchina.community.persistence.model.OpenServiceDetailExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenServiceDetailSqlProvider {

    public String countByExample(OpenServiceDetailExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_service_detail");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenServiceDetailExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_service_detail");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenServiceDetail record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_service_detail");
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getDevelopType() != null) {
            sql.VALUES("develop_type", "#{developType,jdbcType=VARCHAR}");
        }
        
        if (record.getTempleteName() != null) {
            sql.VALUES("templete_name", "#{templeteName,jdbcType=VARCHAR}");
        }
        
        if (record.getTempleteStatus() != null) {
            sql.VALUES("templete_status", "#{templeteStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAppIndexSort() != null) {
            sql.VALUES("app_index_sort", "#{appIndexSort,jdbcType=INTEGER}");
        }
        
        if (record.getAppCatSort() != null) {
            sql.VALUES("app_cat_sort", "#{appCatSort,jdbcType=INTEGER}");
        }
        
        if (record.getRfchinaCode() != null) {
            sql.VALUES("rfchina_code", "#{rfchinaCode,jdbcType=INTEGER}");
        }
        
        if (record.getCautionRefundStatus() != null) {
            sql.VALUES("caution_refund_status", "#{cautionRefundStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCautionRefundReason() != null) {
            sql.VALUES("caution_refund_reason", "#{cautionRefundReason,jdbcType=VARCHAR}");
        }
        
        if (record.getXfsjStatus() != null) {
            sql.VALUES("xfsj_status", "#{xfsjStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCategorySecondType() != null) {
            sql.VALUES("category_second_type", "#{categorySecondType,jdbcType=INTEGER}");
        }
        
        if (record.getProtocolUrl() != null) {
            sql.VALUES("protocol_url", "#{protocolUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getVerifyRole() != null) {
            sql.VALUES("verify_role", "#{verifyRole,jdbcType=CHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenServiceDetailExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("service_id");
        } else {
            sql.SELECT("service_id");
        }
        sql.SELECT("develop_type");
        sql.SELECT("templete_name");
        sql.SELECT("templete_status");
        sql.SELECT("app_index_sort");
        sql.SELECT("app_cat_sort");
        sql.SELECT("rfchina_code");
        sql.SELECT("caution_refund_status");
        sql.SELECT("caution_refund_reason");
        sql.SELECT("xfsj_status");
        sql.SELECT("category_second_type");
        sql.SELECT("protocol_url");
        sql.SELECT("verify_role");
        sql.FROM("open_service_detail");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenServiceDetail record = (OpenServiceDetail) parameter.get("record");
        OpenServiceDetailExample example = (OpenServiceDetailExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_service_detail");
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getDevelopType() != null) {
            sql.SET("develop_type = #{record.developType,jdbcType=VARCHAR}");
        }
        
        if (record.getTempleteName() != null) {
            sql.SET("templete_name = #{record.templeteName,jdbcType=VARCHAR}");
        }
        
        if (record.getTempleteStatus() != null) {
            sql.SET("templete_status = #{record.templeteStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAppIndexSort() != null) {
            sql.SET("app_index_sort = #{record.appIndexSort,jdbcType=INTEGER}");
        }
        
        if (record.getAppCatSort() != null) {
            sql.SET("app_cat_sort = #{record.appCatSort,jdbcType=INTEGER}");
        }
        
        if (record.getRfchinaCode() != null) {
            sql.SET("rfchina_code = #{record.rfchinaCode,jdbcType=INTEGER}");
        }
        
        if (record.getCautionRefundStatus() != null) {
            sql.SET("caution_refund_status = #{record.cautionRefundStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCautionRefundReason() != null) {
            sql.SET("caution_refund_reason = #{record.cautionRefundReason,jdbcType=VARCHAR}");
        }
        
        if (record.getXfsjStatus() != null) {
            sql.SET("xfsj_status = #{record.xfsjStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCategorySecondType() != null) {
            sql.SET("category_second_type = #{record.categorySecondType,jdbcType=INTEGER}");
        }
        
        if (record.getProtocolUrl() != null) {
            sql.SET("protocol_url = #{record.protocolUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getVerifyRole() != null) {
            sql.SET("verify_role = #{record.verifyRole,jdbcType=CHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_service_detail");
        
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("develop_type = #{record.developType,jdbcType=VARCHAR}");
        sql.SET("templete_name = #{record.templeteName,jdbcType=VARCHAR}");
        sql.SET("templete_status = #{record.templeteStatus,jdbcType=INTEGER}");
        sql.SET("app_index_sort = #{record.appIndexSort,jdbcType=INTEGER}");
        sql.SET("app_cat_sort = #{record.appCatSort,jdbcType=INTEGER}");
        sql.SET("rfchina_code = #{record.rfchinaCode,jdbcType=INTEGER}");
        sql.SET("caution_refund_status = #{record.cautionRefundStatus,jdbcType=INTEGER}");
        sql.SET("caution_refund_reason = #{record.cautionRefundReason,jdbcType=VARCHAR}");
        sql.SET("xfsj_status = #{record.xfsjStatus,jdbcType=INTEGER}");
        sql.SET("category_second_type = #{record.categorySecondType,jdbcType=INTEGER}");
        sql.SET("protocol_url = #{record.protocolUrl,jdbcType=VARCHAR}");
        sql.SET("verify_role = #{record.verifyRole,jdbcType=CHAR}");
        
        OpenServiceDetailExample example = (OpenServiceDetailExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenServiceDetail record) {
        SQL sql = new SQL();
        sql.UPDATE("open_service_detail");
        
        if (record.getDevelopType() != null) {
            sql.SET("develop_type = #{developType,jdbcType=VARCHAR}");
        }
        
        if (record.getTempleteName() != null) {
            sql.SET("templete_name = #{templeteName,jdbcType=VARCHAR}");
        }
        
        if (record.getTempleteStatus() != null) {
            sql.SET("templete_status = #{templeteStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAppIndexSort() != null) {
            sql.SET("app_index_sort = #{appIndexSort,jdbcType=INTEGER}");
        }
        
        if (record.getAppCatSort() != null) {
            sql.SET("app_cat_sort = #{appCatSort,jdbcType=INTEGER}");
        }
        
        if (record.getRfchinaCode() != null) {
            sql.SET("rfchina_code = #{rfchinaCode,jdbcType=INTEGER}");
        }
        
        if (record.getCautionRefundStatus() != null) {
            sql.SET("caution_refund_status = #{cautionRefundStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCautionRefundReason() != null) {
            sql.SET("caution_refund_reason = #{cautionRefundReason,jdbcType=VARCHAR}");
        }
        
        if (record.getXfsjStatus() != null) {
            sql.SET("xfsj_status = #{xfsjStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCategorySecondType() != null) {
            sql.SET("category_second_type = #{categorySecondType,jdbcType=INTEGER}");
        }
        
        if (record.getProtocolUrl() != null) {
            sql.SET("protocol_url = #{protocolUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getVerifyRole() != null) {
            sql.SET("verify_role = #{verifyRole,jdbcType=CHAR}");
        }
        
        sql.WHERE("service_id = #{serviceId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenServiceDetailExample example, boolean includeExamplePhrase) {
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