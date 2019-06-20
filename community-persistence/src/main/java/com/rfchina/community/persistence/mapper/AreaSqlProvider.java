package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.Area;
import com.rfchina.community.persistence.model.AreaExample.Criteria;
import com.rfchina.community.persistence.model.AreaExample.Criterion;
import com.rfchina.community.persistence.model.AreaExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class AreaSqlProvider {

    public String countByExample(AreaExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("area");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(AreaExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("area");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Area record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("area");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            sql.VALUES("parent_id", "#{parentId,jdbcType=INTEGER}");
        }
        
        if (record.getShortName() != null) {
            sql.VALUES("short_name", "#{shortName,jdbcType=VARCHAR}");
        }
        
        if (record.getLevelType() != null) {
            sql.VALUES("level_type", "#{levelType,jdbcType=TINYINT}");
        }
        
        if (record.getCityCode() != null) {
            sql.VALUES("city_code", "#{cityCode,jdbcType=VARCHAR}");
        }
        
        if (record.getZipcode() != null) {
            sql.VALUES("zipcode", "#{zipcode,jdbcType=VARCHAR}");
        }
        
        if (record.getMergerName() != null) {
            sql.VALUES("merger_name", "#{mergerName,jdbcType=VARCHAR}");
        }
        
        if (record.getLng() != null) {
            sql.VALUES("lng", "#{lng,jdbcType=DOUBLE}");
        }
        
        if (record.getLat() != null) {
            sql.VALUES("lat", "#{lat,jdbcType=DOUBLE}");
        }
        
        if (record.getPinyin() != null) {
            sql.VALUES("pinyin", "#{pinyin,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(AreaExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("name");
        sql.SELECT("parent_id");
        sql.SELECT("short_name");
        sql.SELECT("level_type");
        sql.SELECT("city_code");
        sql.SELECT("zipcode");
        sql.SELECT("merger_name");
        sql.SELECT("lng");
        sql.SELECT("lat");
        sql.SELECT("pinyin");
        sql.FROM("area");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Area record = (Area) parameter.get("record");
        AreaExample example = (AreaExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("area");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{record.parentId,jdbcType=INTEGER}");
        }
        
        if (record.getShortName() != null) {
            sql.SET("short_name = #{record.shortName,jdbcType=VARCHAR}");
        }
        
        if (record.getLevelType() != null) {
            sql.SET("level_type = #{record.levelType,jdbcType=TINYINT}");
        }
        
        if (record.getCityCode() != null) {
            sql.SET("city_code = #{record.cityCode,jdbcType=VARCHAR}");
        }
        
        if (record.getZipcode() != null) {
            sql.SET("zipcode = #{record.zipcode,jdbcType=VARCHAR}");
        }
        
        if (record.getMergerName() != null) {
            sql.SET("merger_name = #{record.mergerName,jdbcType=VARCHAR}");
        }
        
        if (record.getLng() != null) {
            sql.SET("lng = #{record.lng,jdbcType=DOUBLE}");
        }
        
        if (record.getLat() != null) {
            sql.SET("lat = #{record.lat,jdbcType=DOUBLE}");
        }
        
        if (record.getPinyin() != null) {
            sql.SET("pinyin = #{record.pinyin,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("area");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("parent_id = #{record.parentId,jdbcType=INTEGER}");
        sql.SET("short_name = #{record.shortName,jdbcType=VARCHAR}");
        sql.SET("level_type = #{record.levelType,jdbcType=TINYINT}");
        sql.SET("city_code = #{record.cityCode,jdbcType=VARCHAR}");
        sql.SET("zipcode = #{record.zipcode,jdbcType=VARCHAR}");
        sql.SET("merger_name = #{record.mergerName,jdbcType=VARCHAR}");
        sql.SET("lng = #{record.lng,jdbcType=DOUBLE}");
        sql.SET("lat = #{record.lat,jdbcType=DOUBLE}");
        sql.SET("pinyin = #{record.pinyin,jdbcType=VARCHAR}");
        
        AreaExample example = (AreaExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Area record) {
        SQL sql = new SQL();
        sql.UPDATE("area");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{parentId,jdbcType=INTEGER}");
        }
        
        if (record.getShortName() != null) {
            sql.SET("short_name = #{shortName,jdbcType=VARCHAR}");
        }
        
        if (record.getLevelType() != null) {
            sql.SET("level_type = #{levelType,jdbcType=TINYINT}");
        }
        
        if (record.getCityCode() != null) {
            sql.SET("city_code = #{cityCode,jdbcType=VARCHAR}");
        }
        
        if (record.getZipcode() != null) {
            sql.SET("zipcode = #{zipcode,jdbcType=VARCHAR}");
        }
        
        if (record.getMergerName() != null) {
            sql.SET("merger_name = #{mergerName,jdbcType=VARCHAR}");
        }
        
        if (record.getLng() != null) {
            sql.SET("lng = #{lng,jdbcType=DOUBLE}");
        }
        
        if (record.getLat() != null) {
            sql.SET("lat = #{lat,jdbcType=DOUBLE}");
        }
        
        if (record.getPinyin() != null) {
            sql.SET("pinyin = #{pinyin,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, AreaExample example, boolean includeExamplePhrase) {
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