package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.QrcodeBuildLogSync;
import com.rfchina.community.persistence.model.QrcodeBuildLogSyncExample.Criteria;
import com.rfchina.community.persistence.model.QrcodeBuildLogSyncExample.Criterion;
import com.rfchina.community.persistence.model.QrcodeBuildLogSyncExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class QrcodeBuildLogSyncSqlProvider {

    public String countByExample(QrcodeBuildLogSyncExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("qrcode_build_log_sync");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(QrcodeBuildLogSyncExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("qrcode_build_log_sync");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(QrcodeBuildLogSync record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("qrcode_build_log_sync");
        
        if (record.getMyCreateTime() != null) {
            sql.VALUES("my_create_time", "#{myCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMyCommunityId() != null) {
            sql.VALUES("my_community_id", "#{myCommunityId,jdbcType=INTEGER}");
        }
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getQrcodeDecoding() != null) {
            sql.VALUES("qrcode_decoding", "#{qrcodeDecoding,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getCanPassCount() != null) {
            sql.VALUES("can_pass_count", "#{canPassCount,jdbcType=INTEGER}");
        }
        
        if (record.getBeginTime() != null) {
            sql.VALUES("begin_time", "#{beginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.VALUES("end_time", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQrcodeId() != null) {
            sql.VALUES("qrcode_id", "#{qrcodeId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSysGroup() != null) {
            sql.VALUES("sys_group", "#{sysGroup,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(QrcodeBuildLogSyncExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("my_id");
        } else {
            sql.SELECT("my_id");
        }
        sql.SELECT("my_create_time");
        sql.SELECT("my_community_id");
        sql.SELECT("id");
        sql.SELECT("qrcode_decoding");
        sql.SELECT("community_id");
        sql.SELECT("type");
        sql.SELECT("can_pass_count");
        sql.SELECT("begin_time");
        sql.SELECT("end_time");
        sql.SELECT("qrcode_id");
        sql.SELECT("create_time");
        sql.SELECT("sys_group");
        sql.FROM("qrcode_build_log_sync");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        QrcodeBuildLogSync record = (QrcodeBuildLogSync) parameter.get("record");
        QrcodeBuildLogSyncExample example = (QrcodeBuildLogSyncExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("qrcode_build_log_sync");
        
        if (record.getMyId() != null) {
            sql.SET("my_id = #{record.myId,jdbcType=BIGINT}");
        }
        
        if (record.getMyCreateTime() != null) {
            sql.SET("my_create_time = #{record.myCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMyCommunityId() != null) {
            sql.SET("my_community_id = #{record.myCommunityId,jdbcType=INTEGER}");
        }
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getQrcodeDecoding() != null) {
            sql.SET("qrcode_decoding = #{record.qrcodeDecoding,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=INTEGER}");
        }
        
        if (record.getCanPassCount() != null) {
            sql.SET("can_pass_count = #{record.canPassCount,jdbcType=INTEGER}");
        }
        
        if (record.getBeginTime() != null) {
            sql.SET("begin_time = #{record.beginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQrcodeId() != null) {
            sql.SET("qrcode_id = #{record.qrcodeId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSysGroup() != null) {
            sql.SET("sys_group = #{record.sysGroup,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("qrcode_build_log_sync");
        
        sql.SET("my_id = #{record.myId,jdbcType=BIGINT}");
        sql.SET("my_create_time = #{record.myCreateTime,jdbcType=TIMESTAMP}");
        sql.SET("my_community_id = #{record.myCommunityId,jdbcType=INTEGER}");
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("qrcode_decoding = #{record.qrcodeDecoding,jdbcType=VARCHAR}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("type = #{record.type,jdbcType=INTEGER}");
        sql.SET("can_pass_count = #{record.canPassCount,jdbcType=INTEGER}");
        sql.SET("begin_time = #{record.beginTime,jdbcType=TIMESTAMP}");
        sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        sql.SET("qrcode_id = #{record.qrcodeId,jdbcType=BIGINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("sys_group = #{record.sysGroup,jdbcType=INTEGER}");
        
        QrcodeBuildLogSyncExample example = (QrcodeBuildLogSyncExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(QrcodeBuildLogSync record) {
        SQL sql = new SQL();
        sql.UPDATE("qrcode_build_log_sync");
        
        if (record.getMyCreateTime() != null) {
            sql.SET("my_create_time = #{myCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMyCommunityId() != null) {
            sql.SET("my_community_id = #{myCommunityId,jdbcType=INTEGER}");
        }
        
        if (record.getId() != null) {
            sql.SET("id = #{id,jdbcType=BIGINT}");
        }
        
        if (record.getQrcodeDecoding() != null) {
            sql.SET("qrcode_decoding = #{qrcodeDecoding,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getCanPassCount() != null) {
            sql.SET("can_pass_count = #{canPassCount,jdbcType=INTEGER}");
        }
        
        if (record.getBeginTime() != null) {
            sql.SET("begin_time = #{beginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQrcodeId() != null) {
            sql.SET("qrcode_id = #{qrcodeId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSysGroup() != null) {
            sql.SET("sys_group = #{sysGroup,jdbcType=INTEGER}");
        }
        
        sql.WHERE("my_id = #{myId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, QrcodeBuildLogSyncExample example, boolean includeExamplePhrase) {
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