package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysMsgRead;
import com.rfchina.community.persistence.model.SysMsgReadExample.Criteria;
import com.rfchina.community.persistence.model.SysMsgReadExample.Criterion;
import com.rfchina.community.persistence.model.SysMsgReadExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SysMsgReadSqlProvider {

    public String countByExample(SysMsgReadExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_msg_read");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SysMsgReadExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_msg_read");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SysMsgRead record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_msg_read");
        
        if (record.getAdminUid() != null) {
            sql.VALUES("admin_uid", "#{adminUid,jdbcType=BIGINT}");
        }
        
        if (record.getMsgId() != null) {
            sql.VALUES("msg_id", "#{msgId,jdbcType=BIGINT}");
        }
        
        if (record.getIsRead() != null) {
            sql.VALUES("is_read", "#{isRead,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReadTime() != null) {
            sql.VALUES("read_time", "#{readTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SysMsgReadExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("admin_uid");
        } else {
            sql.SELECT("admin_uid");
        }
        sql.SELECT("msg_id");
        sql.SELECT("is_read");
        sql.SELECT("create_time");
        sql.SELECT("read_time");
        sql.FROM("sys_msg_read");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysMsgRead record = (SysMsgRead) parameter.get("record");
        SysMsgReadExample example = (SysMsgReadExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_msg_read");
        
        if (record.getAdminUid() != null) {
            sql.SET("admin_uid = #{record.adminUid,jdbcType=BIGINT}");
        }
        
        if (record.getMsgId() != null) {
            sql.SET("msg_id = #{record.msgId,jdbcType=BIGINT}");
        }
        
        if (record.getIsRead() != null) {
            sql.SET("is_read = #{record.isRead,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReadTime() != null) {
            sql.SET("read_time = #{record.readTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_msg_read");
        
        sql.SET("admin_uid = #{record.adminUid,jdbcType=BIGINT}");
        sql.SET("msg_id = #{record.msgId,jdbcType=BIGINT}");
        sql.SET("is_read = #{record.isRead,jdbcType=TINYINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("read_time = #{record.readTime,jdbcType=TIMESTAMP}");
        
        SysMsgReadExample example = (SysMsgReadExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysMsgRead record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_msg_read");
        
        if (record.getIsRead() != null) {
            sql.SET("is_read = #{isRead,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReadTime() != null) {
            sql.SET("read_time = #{readTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("admin_uid = #{adminUid,jdbcType=BIGINT}");
        sql.WHERE("msg_id = #{msgId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SysMsgReadExample example, boolean includeExamplePhrase) {
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