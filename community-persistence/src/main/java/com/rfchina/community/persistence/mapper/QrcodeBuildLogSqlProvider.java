package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.QrcodeBuildLog;
import com.rfchina.community.persistence.model.QrcodeBuildLogExample.Criteria;
import com.rfchina.community.persistence.model.QrcodeBuildLogExample.Criterion;
import com.rfchina.community.persistence.model.QrcodeBuildLogExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class QrcodeBuildLogSqlProvider {

    public String countByExample(QrcodeBuildLogExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("qrcode_build_log");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(QrcodeBuildLogExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("qrcode_build_log");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(QrcodeBuildLog record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("qrcode_build_log");
        
        if (record.getQrcode() != null) {
            sql.VALUES("qrcode", "#{qrcode,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getOtherCommunity() != null) {
            sql.VALUES("other_community", "#{otherCommunity,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getBeginTime() != null) {
            sql.VALUES("begin_time", "#{beginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.VALUES("end_time", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCanCount() != null) {
            sql.VALUES("can_count", "#{canCount,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getAdminId() != null) {
            sql.VALUES("admin_id", "#{adminId,jdbcType=BIGINT}");
        }
        
        if (record.getOtherId() != null) {
            sql.VALUES("other_id", "#{otherId,jdbcType=BIGINT}");
        }
        
        if (record.getSysType() != null) {
            sql.VALUES("sys_type", "#{sysType,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(QrcodeBuildLogExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("qrcode");
        sql.SELECT("uid");
        sql.SELECT("community_id");
        sql.SELECT("other_community");
        sql.SELECT("create_time");
        sql.SELECT("type");
        sql.SELECT("begin_time");
        sql.SELECT("end_time");
        sql.SELECT("can_count");
        sql.SELECT("status");
        sql.SELECT("admin_id");
        sql.SELECT("other_id");
        sql.SELECT("sys_type");
        sql.FROM("qrcode_build_log");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        QrcodeBuildLog record = (QrcodeBuildLog) parameter.get("record");
        QrcodeBuildLogExample example = (QrcodeBuildLogExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("qrcode_build_log");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getQrcode() != null) {
            sql.SET("qrcode = #{record.qrcode,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getOtherCommunity() != null) {
            sql.SET("other_community = #{record.otherCommunity,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=INTEGER}");
        }
        
        if (record.getBeginTime() != null) {
            sql.SET("begin_time = #{record.beginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCanCount() != null) {
            sql.SET("can_count = #{record.canCount,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getAdminId() != null) {
            sql.SET("admin_id = #{record.adminId,jdbcType=BIGINT}");
        }
        
        if (record.getOtherId() != null) {
            sql.SET("other_id = #{record.otherId,jdbcType=BIGINT}");
        }
        
        if (record.getSysType() != null) {
            sql.SET("sys_type = #{record.sysType,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("qrcode_build_log");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("qrcode = #{record.qrcode,jdbcType=VARCHAR}");
        sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("other_community = #{record.otherCommunity,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("type = #{record.type,jdbcType=INTEGER}");
        sql.SET("begin_time = #{record.beginTime,jdbcType=TIMESTAMP}");
        sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        sql.SET("can_count = #{record.canCount,jdbcType=INTEGER}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("admin_id = #{record.adminId,jdbcType=BIGINT}");
        sql.SET("other_id = #{record.otherId,jdbcType=BIGINT}");
        sql.SET("sys_type = #{record.sysType,jdbcType=VARCHAR}");
        
        QrcodeBuildLogExample example = (QrcodeBuildLogExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(QrcodeBuildLog record) {
        SQL sql = new SQL();
        sql.UPDATE("qrcode_build_log");
        
        if (record.getQrcode() != null) {
            sql.SET("qrcode = #{qrcode,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getOtherCommunity() != null) {
            sql.SET("other_community = #{otherCommunity,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getBeginTime() != null) {
            sql.SET("begin_time = #{beginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCanCount() != null) {
            sql.SET("can_count = #{canCount,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getAdminId() != null) {
            sql.SET("admin_id = #{adminId,jdbcType=BIGINT}");
        }
        
        if (record.getOtherId() != null) {
            sql.SET("other_id = #{otherId,jdbcType=BIGINT}");
        }
        
        if (record.getSysType() != null) {
            sql.SET("sys_type = #{sysType,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, QrcodeBuildLogExample example, boolean includeExamplePhrase) {
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