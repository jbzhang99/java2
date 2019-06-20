package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenXFSJStore;
import com.rfchina.community.persistence.model.OpenXFSJStoreExample.Criteria;
import com.rfchina.community.persistence.model.OpenXFSJStoreExample.Criterion;
import com.rfchina.community.persistence.model.OpenXFSJStoreExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenXFSJStoreSqlProvider {

    public String countByExample(OpenXFSJStoreExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_xfsj_store");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenXFSJStoreExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_xfsj_store");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenXFSJStore record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_xfsj_store");
        
        if (record.getXfsjId() != null) {
            sql.VALUES("xfsj_id", "#{xfsjId,jdbcType=BIGINT}");
        }
        
        if (record.getStoreId() != null) {
            sql.VALUES("store_id", "#{storeId,jdbcType=INTEGER}");
        }
        
        if (record.getCoverImg() != null) {
            sql.VALUES("cover_img", "#{coverImg,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderby() != null) {
            sql.VALUES("orderby", "#{orderby,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenXFSJStoreExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("xfsj_id");
        } else {
            sql.SELECT("xfsj_id");
        }
        sql.SELECT("store_id");
        sql.SELECT("cover_img");
        sql.SELECT("orderby");
        sql.SELECT("create_time");
        sql.FROM("open_xfsj_store");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenXFSJStore record = (OpenXFSJStore) parameter.get("record");
        OpenXFSJStoreExample example = (OpenXFSJStoreExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_xfsj_store");
        
        if (record.getXfsjId() != null) {
            sql.SET("xfsj_id = #{record.xfsjId,jdbcType=BIGINT}");
        }
        
        if (record.getStoreId() != null) {
            sql.SET("store_id = #{record.storeId,jdbcType=INTEGER}");
        }
        
        if (record.getCoverImg() != null) {
            sql.SET("cover_img = #{record.coverImg,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderby() != null) {
            sql.SET("orderby = #{record.orderby,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_xfsj_store");
        
        sql.SET("xfsj_id = #{record.xfsjId,jdbcType=BIGINT}");
        sql.SET("store_id = #{record.storeId,jdbcType=INTEGER}");
        sql.SET("cover_img = #{record.coverImg,jdbcType=VARCHAR}");
        sql.SET("orderby = #{record.orderby,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        OpenXFSJStoreExample example = (OpenXFSJStoreExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenXFSJStore record) {
        SQL sql = new SQL();
        sql.UPDATE("open_xfsj_store");
        
        if (record.getCoverImg() != null) {
            sql.SET("cover_img = #{coverImg,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderby() != null) {
            sql.SET("orderby = #{orderby,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("xfsj_id = #{xfsjId,jdbcType=BIGINT}");
        sql.WHERE("store_id = #{storeId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenXFSJStoreExample example, boolean includeExamplePhrase) {
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