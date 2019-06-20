package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenOperatorTask;
import com.rfchina.community.persistence.model.OpenOperatorTaskExample.Criteria;
import com.rfchina.community.persistence.model.OpenOperatorTaskExample.Criterion;
import com.rfchina.community.persistence.model.OpenOperatorTaskExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenOperatorTaskSqlProvider {

    public String countByExample(OpenOperatorTaskExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_operator_task");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenOperatorTaskExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_operator_task");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenOperatorTask record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_operator_task");
        
        if (record.getCityId() != null) {
            sql.VALUES("city_id", "#{cityId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getXfsjId() != null) {
            sql.VALUES("xfsj_id", "#{xfsjId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantId() != null) {
            sql.VALUES("merchant_id", "#{merchantId,jdbcType=BIGINT}");
        }
        
        if (record.getStartTime() != null) {
            sql.VALUES("start_time", "#{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.VALUES("end_time", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReleaseStatus() != null) {
            sql.VALUES("release_status", "#{releaseStatus,jdbcType=INTEGER}");
        }
        
        if (record.getReleaseTime() != null) {
            sql.VALUES("release_time", "#{releaseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReceiveStatus() != null) {
            sql.VALUES("receive_status", "#{receiveStatus,jdbcType=INTEGER}");
        }
        
        if (record.getEmpGuid() != null) {
            sql.VALUES("emp_guid", "#{empGuid,jdbcType=VARCHAR}");
        }
        
        if (record.getEmpPhone() != null) {
            sql.VALUES("emp_phone", "#{empPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmpName() != null) {
            sql.VALUES("emp_name", "#{empName,jdbcType=VARCHAR}");
        }
        
        if (record.getBecomeTime() != null) {
            sql.VALUES("become_time", "#{becomeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getHelpDetail() != null) {
            sql.VALUES("help_detail", "#{helpDetail,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(OpenOperatorTaskExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("city_id");
        sql.SELECT("community_id");
        sql.SELECT("xfsj_id");
        sql.SELECT("service_id");
        sql.SELECT("merchant_id");
        sql.SELECT("start_time");
        sql.SELECT("end_time");
        sql.SELECT("release_status");
        sql.SELECT("release_time");
        sql.SELECT("receive_status");
        sql.SELECT("emp_guid");
        sql.SELECT("emp_phone");
        sql.SELECT("emp_name");
        sql.SELECT("become_time");
        sql.SELECT("address");
        sql.SELECT("create_time");
        sql.SELECT("help_detail");
        sql.FROM("open_operator_task");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenOperatorTaskExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("city_id");
        sql.SELECT("community_id");
        sql.SELECT("xfsj_id");
        sql.SELECT("service_id");
        sql.SELECT("merchant_id");
        sql.SELECT("start_time");
        sql.SELECT("end_time");
        sql.SELECT("release_status");
        sql.SELECT("release_time");
        sql.SELECT("receive_status");
        sql.SELECT("emp_guid");
        sql.SELECT("emp_phone");
        sql.SELECT("emp_name");
        sql.SELECT("become_time");
        sql.SELECT("address");
        sql.SELECT("create_time");
        sql.FROM("open_operator_task");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenOperatorTask record = (OpenOperatorTask) parameter.get("record");
        OpenOperatorTaskExample example = (OpenOperatorTaskExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_operator_task");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCityId() != null) {
            sql.SET("city_id = #{record.cityId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getXfsjId() != null) {
            sql.SET("xfsj_id = #{record.xfsjId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantId() != null) {
            sql.SET("merchant_id = #{record.merchantId,jdbcType=BIGINT}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReleaseStatus() != null) {
            sql.SET("release_status = #{record.releaseStatus,jdbcType=INTEGER}");
        }
        
        if (record.getReleaseTime() != null) {
            sql.SET("release_time = #{record.releaseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReceiveStatus() != null) {
            sql.SET("receive_status = #{record.receiveStatus,jdbcType=INTEGER}");
        }
        
        if (record.getEmpGuid() != null) {
            sql.SET("emp_guid = #{record.empGuid,jdbcType=VARCHAR}");
        }
        
        if (record.getEmpPhone() != null) {
            sql.SET("emp_phone = #{record.empPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmpName() != null) {
            sql.SET("emp_name = #{record.empName,jdbcType=VARCHAR}");
        }
        
        if (record.getBecomeTime() != null) {
            sql.SET("become_time = #{record.becomeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getHelpDetail() != null) {
            sql.SET("help_detail = #{record.helpDetail,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_operator_task");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("city_id = #{record.cityId,jdbcType=INTEGER}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("xfsj_id = #{record.xfsjId,jdbcType=BIGINT}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("merchant_id = #{record.merchantId,jdbcType=BIGINT}");
        sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        sql.SET("release_status = #{record.releaseStatus,jdbcType=INTEGER}");
        sql.SET("release_time = #{record.releaseTime,jdbcType=TIMESTAMP}");
        sql.SET("receive_status = #{record.receiveStatus,jdbcType=INTEGER}");
        sql.SET("emp_guid = #{record.empGuid,jdbcType=VARCHAR}");
        sql.SET("emp_phone = #{record.empPhone,jdbcType=VARCHAR}");
        sql.SET("emp_name = #{record.empName,jdbcType=VARCHAR}");
        sql.SET("become_time = #{record.becomeTime,jdbcType=TIMESTAMP}");
        sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("help_detail = #{record.helpDetail,jdbcType=LONGVARCHAR}");
        
        OpenOperatorTaskExample example = (OpenOperatorTaskExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_operator_task");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("city_id = #{record.cityId,jdbcType=INTEGER}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("xfsj_id = #{record.xfsjId,jdbcType=BIGINT}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("merchant_id = #{record.merchantId,jdbcType=BIGINT}");
        sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        sql.SET("release_status = #{record.releaseStatus,jdbcType=INTEGER}");
        sql.SET("release_time = #{record.releaseTime,jdbcType=TIMESTAMP}");
        sql.SET("receive_status = #{record.receiveStatus,jdbcType=INTEGER}");
        sql.SET("emp_guid = #{record.empGuid,jdbcType=VARCHAR}");
        sql.SET("emp_phone = #{record.empPhone,jdbcType=VARCHAR}");
        sql.SET("emp_name = #{record.empName,jdbcType=VARCHAR}");
        sql.SET("become_time = #{record.becomeTime,jdbcType=TIMESTAMP}");
        sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        OpenOperatorTaskExample example = (OpenOperatorTaskExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenOperatorTask record) {
        SQL sql = new SQL();
        sql.UPDATE("open_operator_task");
        
        if (record.getCityId() != null) {
            sql.SET("city_id = #{cityId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getXfsjId() != null) {
            sql.SET("xfsj_id = #{xfsjId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantId() != null) {
            sql.SET("merchant_id = #{merchantId,jdbcType=BIGINT}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReleaseStatus() != null) {
            sql.SET("release_status = #{releaseStatus,jdbcType=INTEGER}");
        }
        
        if (record.getReleaseTime() != null) {
            sql.SET("release_time = #{releaseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReceiveStatus() != null) {
            sql.SET("receive_status = #{receiveStatus,jdbcType=INTEGER}");
        }
        
        if (record.getEmpGuid() != null) {
            sql.SET("emp_guid = #{empGuid,jdbcType=VARCHAR}");
        }
        
        if (record.getEmpPhone() != null) {
            sql.SET("emp_phone = #{empPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmpName() != null) {
            sql.SET("emp_name = #{empName,jdbcType=VARCHAR}");
        }
        
        if (record.getBecomeTime() != null) {
            sql.SET("become_time = #{becomeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getHelpDetail() != null) {
            sql.SET("help_detail = #{helpDetail,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenOperatorTaskExample example, boolean includeExamplePhrase) {
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