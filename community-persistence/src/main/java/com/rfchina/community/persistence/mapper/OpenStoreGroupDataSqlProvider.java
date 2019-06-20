package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreGroupData;
import com.rfchina.community.persistence.model.OpenStoreGroupDataExample.Criteria;
import com.rfchina.community.persistence.model.OpenStoreGroupDataExample.Criterion;
import com.rfchina.community.persistence.model.OpenStoreGroupDataExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenStoreGroupDataSqlProvider {

    public String countByExample(OpenStoreGroupDataExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_store_group_data");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenStoreGroupDataExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_store_group_data");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenStoreGroupData record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_store_group_data");
        
        if (record.getGoodGroupId() != null) {
            sql.VALUES("good_group_id", "#{goodGroupId,jdbcType=BIGINT}");
        }
        
        if (record.getGoodId() != null) {
            sql.VALUES("good_id", "#{goodId,jdbcType=INTEGER}");
        }
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=BIGINT}");
        }
        
        if (record.getPicUrl() != null) {
            sql.VALUES("pic_url", "#{picUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getStartType() != null) {
            sql.VALUES("start_type", "#{startType,jdbcType=VARCHAR}");
        }
        
        if (record.getNickName() != null) {
            sql.VALUES("nick_name", "#{nickName,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getPeopleNum() != null) {
            sql.VALUES("people_num", "#{peopleNum,jdbcType=INTEGER}");
        }
        
        if (record.getSuccessNum() != null) {
            sql.VALUES("success_num", "#{successNum,jdbcType=INTEGER}");
        }
        
        if (record.getUsableNum() != null) {
            sql.VALUES("usable_num", "#{usableNum,jdbcType=INTEGER}");
        }
        
        if (record.getLockNum() != null) {
            sql.VALUES("lock_num", "#{lockNum,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStopTime() != null) {
            sql.VALUES("stop_time", "#{stopTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.VALUES("end_time", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getSuccessTime() != null) {
            sql.VALUES("success_time", "#{successTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenStoreGroupDataExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("good_group_id");
        sql.SELECT("good_id");
        sql.SELECT("service_id");
        sql.SELECT("uid");
        sql.SELECT("pic_url");
        sql.SELECT("start_type");
        sql.SELECT("nick_name");
        sql.SELECT("phone");
        sql.SELECT("people_num");
        sql.SELECT("success_num");
        sql.SELECT("usable_num");
        sql.SELECT("lock_num");
        sql.SELECT("create_time");
        sql.SELECT("stop_time");
        sql.SELECT("end_time");
        sql.SELECT("status");
        sql.SELECT("type");
        sql.SELECT("success_time");
        sql.FROM("open_store_group_data");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenStoreGroupData record = (OpenStoreGroupData) parameter.get("record");
        OpenStoreGroupDataExample example = (OpenStoreGroupDataExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_store_group_data");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getGoodGroupId() != null) {
            sql.SET("good_group_id = #{record.goodGroupId,jdbcType=BIGINT}");
        }
        
        if (record.getGoodId() != null) {
            sql.SET("good_id = #{record.goodId,jdbcType=INTEGER}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        }
        
        if (record.getPicUrl() != null) {
            sql.SET("pic_url = #{record.picUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getStartType() != null) {
            sql.SET("start_type = #{record.startType,jdbcType=VARCHAR}");
        }
        
        if (record.getNickName() != null) {
            sql.SET("nick_name = #{record.nickName,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getPeopleNum() != null) {
            sql.SET("people_num = #{record.peopleNum,jdbcType=INTEGER}");
        }
        
        if (record.getSuccessNum() != null) {
            sql.SET("success_num = #{record.successNum,jdbcType=INTEGER}");
        }
        
        if (record.getUsableNum() != null) {
            sql.SET("usable_num = #{record.usableNum,jdbcType=INTEGER}");
        }
        
        if (record.getLockNum() != null) {
            sql.SET("lock_num = #{record.lockNum,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStopTime() != null) {
            sql.SET("stop_time = #{record.stopTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=VARCHAR}");
        }
        
        if (record.getSuccessTime() != null) {
            sql.SET("success_time = #{record.successTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_group_data");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("good_group_id = #{record.goodGroupId,jdbcType=BIGINT}");
        sql.SET("good_id = #{record.goodId,jdbcType=INTEGER}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        sql.SET("pic_url = #{record.picUrl,jdbcType=VARCHAR}");
        sql.SET("start_type = #{record.startType,jdbcType=VARCHAR}");
        sql.SET("nick_name = #{record.nickName,jdbcType=VARCHAR}");
        sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        sql.SET("people_num = #{record.peopleNum,jdbcType=INTEGER}");
        sql.SET("success_num = #{record.successNum,jdbcType=INTEGER}");
        sql.SET("usable_num = #{record.usableNum,jdbcType=INTEGER}");
        sql.SET("lock_num = #{record.lockNum,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("stop_time = #{record.stopTime,jdbcType=TIMESTAMP}");
        sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("type = #{record.type,jdbcType=VARCHAR}");
        sql.SET("success_time = #{record.successTime,jdbcType=TIMESTAMP}");
        
        OpenStoreGroupDataExample example = (OpenStoreGroupDataExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenStoreGroupData record) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_group_data");
        
        if (record.getGoodGroupId() != null) {
            sql.SET("good_group_id = #{goodGroupId,jdbcType=BIGINT}");
        }
        
        if (record.getGoodId() != null) {
            sql.SET("good_id = #{goodId,jdbcType=INTEGER}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=BIGINT}");
        }
        
        if (record.getPicUrl() != null) {
            sql.SET("pic_url = #{picUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getStartType() != null) {
            sql.SET("start_type = #{startType,jdbcType=VARCHAR}");
        }
        
        if (record.getNickName() != null) {
            sql.SET("nick_name = #{nickName,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getPeopleNum() != null) {
            sql.SET("people_num = #{peopleNum,jdbcType=INTEGER}");
        }
        
        if (record.getSuccessNum() != null) {
            sql.SET("success_num = #{successNum,jdbcType=INTEGER}");
        }
        
        if (record.getUsableNum() != null) {
            sql.SET("usable_num = #{usableNum,jdbcType=INTEGER}");
        }
        
        if (record.getLockNum() != null) {
            sql.SET("lock_num = #{lockNum,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStopTime() != null) {
            sql.SET("stop_time = #{stopTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getSuccessTime() != null) {
            sql.SET("success_time = #{successTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenStoreGroupDataExample example, boolean includeExamplePhrase) {
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