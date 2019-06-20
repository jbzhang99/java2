package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysNotice;
import com.rfchina.community.persistence.model.SysNoticeExample.Criteria;
import com.rfchina.community.persistence.model.SysNoticeExample.Criterion;
import com.rfchina.community.persistence.model.SysNoticeExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SysNoticeSqlProvider {

    public String countByExample(SysNoticeExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_notice");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SysNoticeExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_notice");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SysNotice record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_notice");
        
        if (record.getCreateComm() != null) {
            sql.VALUES("create_comm", "#{createComm,jdbcType=INTEGER}");
        }
        
        if (record.getCreateId() != null) {
            sql.VALUES("create_id", "#{createId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getPlatformUid() != null) {
            sql.VALUES("platform_uid", "#{platformUid,jdbcType=BIGINT}");
        }
        
        if (record.getCommUid() != null) {
            sql.VALUES("comm_uid", "#{commUid,jdbcType=BIGINT}");
        }
        
        if (record.getMasterUid() != null) {
            sql.VALUES("master_uid", "#{masterUid,jdbcType=BIGINT}");
        }
        
        if (record.getSellerUid() != null) {
            sql.VALUES("seller_uid", "#{sellerUid,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(SysNoticeExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("create_comm");
        sql.SELECT("create_id");
        sql.SELECT("create_time");
        sql.SELECT("title");
        sql.SELECT("platform_uid");
        sql.SELECT("comm_uid");
        sql.SELECT("master_uid");
        sql.SELECT("seller_uid");
        sql.SELECT("status");
        sql.SELECT("content");
        sql.FROM("sys_notice");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(SysNoticeExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("create_comm");
        sql.SELECT("create_id");
        sql.SELECT("create_time");
        sql.SELECT("title");
        sql.SELECT("platform_uid");
        sql.SELECT("comm_uid");
        sql.SELECT("master_uid");
        sql.SELECT("seller_uid");
        sql.SELECT("status");
        sql.FROM("sys_notice");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysNotice record = (SysNotice) parameter.get("record");
        SysNoticeExample example = (SysNoticeExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_notice");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCreateComm() != null) {
            sql.SET("create_comm = #{record.createComm,jdbcType=INTEGER}");
        }
        
        if (record.getCreateId() != null) {
            sql.SET("create_id = #{record.createId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getPlatformUid() != null) {
            sql.SET("platform_uid = #{record.platformUid,jdbcType=BIGINT}");
        }
        
        if (record.getCommUid() != null) {
            sql.SET("comm_uid = #{record.commUid,jdbcType=BIGINT}");
        }
        
        if (record.getMasterUid() != null) {
            sql.SET("master_uid = #{record.masterUid,jdbcType=BIGINT}");
        }
        
        if (record.getSellerUid() != null) {
            sql.SET("seller_uid = #{record.sellerUid,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_notice");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("create_comm = #{record.createComm,jdbcType=INTEGER}");
        sql.SET("create_id = #{record.createId,jdbcType=BIGINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("platform_uid = #{record.platformUid,jdbcType=BIGINT}");
        sql.SET("comm_uid = #{record.commUid,jdbcType=BIGINT}");
        sql.SET("master_uid = #{record.masterUid,jdbcType=BIGINT}");
        sql.SET("seller_uid = #{record.sellerUid,jdbcType=BIGINT}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        
        SysNoticeExample example = (SysNoticeExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_notice");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("create_comm = #{record.createComm,jdbcType=INTEGER}");
        sql.SET("create_id = #{record.createId,jdbcType=BIGINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("platform_uid = #{record.platformUid,jdbcType=BIGINT}");
        sql.SET("comm_uid = #{record.commUid,jdbcType=BIGINT}");
        sql.SET("master_uid = #{record.masterUid,jdbcType=BIGINT}");
        sql.SET("seller_uid = #{record.sellerUid,jdbcType=BIGINT}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        
        SysNoticeExample example = (SysNoticeExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysNotice record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_notice");
        
        if (record.getCreateComm() != null) {
            sql.SET("create_comm = #{createComm,jdbcType=INTEGER}");
        }
        
        if (record.getCreateId() != null) {
            sql.SET("create_id = #{createId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getPlatformUid() != null) {
            sql.SET("platform_uid = #{platformUid,jdbcType=BIGINT}");
        }
        
        if (record.getCommUid() != null) {
            sql.SET("comm_uid = #{commUid,jdbcType=BIGINT}");
        }
        
        if (record.getMasterUid() != null) {
            sql.SET("master_uid = #{masterUid,jdbcType=BIGINT}");
        }
        
        if (record.getSellerUid() != null) {
            sql.SET("seller_uid = #{sellerUid,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SysNoticeExample example, boolean includeExamplePhrase) {
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