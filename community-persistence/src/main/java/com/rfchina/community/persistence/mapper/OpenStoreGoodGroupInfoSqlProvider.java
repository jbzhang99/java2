package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreGoodGroupInfo;
import com.rfchina.community.persistence.model.OpenStoreGoodGroupInfoExample.Criteria;
import com.rfchina.community.persistence.model.OpenStoreGoodGroupInfoExample.Criterion;
import com.rfchina.community.persistence.model.OpenStoreGoodGroupInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenStoreGoodGroupInfoSqlProvider {

    public String countByExample(OpenStoreGoodGroupInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_store_good_group_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenStoreGoodGroupInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_store_good_group_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenStoreGoodGroupInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_store_good_group_info");
        
        if (record.getGoodId() != null) {
            sql.VALUES("good_id", "#{goodId,jdbcType=INTEGER}");
        }
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            sql.VALUES("price", "#{price,jdbcType=DECIMAL}");
        }
        
        if (record.getGroupPrice() != null) {
            sql.VALUES("group_price", "#{groupPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPeopleNum() != null) {
            sql.VALUES("people_num", "#{peopleNum,jdbcType=INTEGER}");
        }
        
        if (record.getStock() != null) {
            sql.VALUES("stock", "#{stock,jdbcType=INTEGER}");
        }
        
        if (record.getStartTime() != null) {
            sql.VALUES("start_time", "#{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.VALUES("end_time", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLimitTimes() != null) {
            sql.VALUES("limit_times", "#{limitTimes,jdbcType=INTEGER}");
        }
        
        if (record.getVirturalSuccessHour() != null) {
            sql.VALUES("virtural_success_hour", "#{virturalSuccessHour,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenStoreGoodGroupInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("good_id");
        sql.SELECT("service_id");
        sql.SELECT("price");
        sql.SELECT("group_price");
        sql.SELECT("people_num");
        sql.SELECT("stock");
        sql.SELECT("start_time");
        sql.SELECT("end_time");
        sql.SELECT("limit_times");
        sql.SELECT("virtural_success_hour");
        sql.SELECT("create_time");
        sql.SELECT("status");
        sql.FROM("open_store_good_group_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenStoreGoodGroupInfo record = (OpenStoreGoodGroupInfo) parameter.get("record");
        OpenStoreGoodGroupInfoExample example = (OpenStoreGoodGroupInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_store_good_group_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getGoodId() != null) {
            sql.SET("good_id = #{record.goodId,jdbcType=INTEGER}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{record.price,jdbcType=DECIMAL}");
        }
        
        if (record.getGroupPrice() != null) {
            sql.SET("group_price = #{record.groupPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPeopleNum() != null) {
            sql.SET("people_num = #{record.peopleNum,jdbcType=INTEGER}");
        }
        
        if (record.getStock() != null) {
            sql.SET("stock = #{record.stock,jdbcType=INTEGER}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLimitTimes() != null) {
            sql.SET("limit_times = #{record.limitTimes,jdbcType=INTEGER}");
        }
        
        if (record.getVirturalSuccessHour() != null) {
            sql.SET("virtural_success_hour = #{record.virturalSuccessHour,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_good_group_info");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("good_id = #{record.goodId,jdbcType=INTEGER}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("price = #{record.price,jdbcType=DECIMAL}");
        sql.SET("group_price = #{record.groupPrice,jdbcType=DECIMAL}");
        sql.SET("people_num = #{record.peopleNum,jdbcType=INTEGER}");
        sql.SET("stock = #{record.stock,jdbcType=INTEGER}");
        sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        sql.SET("limit_times = #{record.limitTimes,jdbcType=INTEGER}");
        sql.SET("virtural_success_hour = #{record.virturalSuccessHour,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        
        OpenStoreGoodGroupInfoExample example = (OpenStoreGoodGroupInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenStoreGoodGroupInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_good_group_info");
        
        if (record.getGoodId() != null) {
            sql.SET("good_id = #{goodId,jdbcType=INTEGER}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{price,jdbcType=DECIMAL}");
        }
        
        if (record.getGroupPrice() != null) {
            sql.SET("group_price = #{groupPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPeopleNum() != null) {
            sql.SET("people_num = #{peopleNum,jdbcType=INTEGER}");
        }
        
        if (record.getStock() != null) {
            sql.SET("stock = #{stock,jdbcType=INTEGER}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLimitTimes() != null) {
            sql.SET("limit_times = #{limitTimes,jdbcType=INTEGER}");
        }
        
        if (record.getVirturalSuccessHour() != null) {
            sql.SET("virtural_success_hour = #{virturalSuccessHour,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenStoreGoodGroupInfoExample example, boolean includeExamplePhrase) {
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