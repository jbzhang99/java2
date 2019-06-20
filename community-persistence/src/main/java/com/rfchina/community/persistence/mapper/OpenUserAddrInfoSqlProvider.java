package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenUserAddrInfo;
import com.rfchina.community.persistence.model.OpenUserAddrInfoExample.Criteria;
import com.rfchina.community.persistence.model.OpenUserAddrInfoExample.Criterion;
import com.rfchina.community.persistence.model.OpenUserAddrInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenUserAddrInfoSqlProvider {

    public String countByExample(OpenUserAddrInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_user_addr_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenUserAddrInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_user_addr_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenUserAddrInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_user_addr_info");
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.VALUES("mobile", "#{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getDetailAddr() != null) {
            sql.VALUES("detail_addr", "#{detailAddr,jdbcType=VARCHAR}");
        }
        
        if (record.getIsDefault() != null) {
            sql.VALUES("is_default", "#{isDefault,jdbcType=INTEGER}");
        }
        
        if (record.getValidStatus() != null) {
            sql.VALUES("valid_status", "#{validStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProvinceAreaId() != null) {
            sql.VALUES("province_area_id", "#{provinceAreaId,jdbcType=VARCHAR}");
        }
        
        if (record.getCityAreaId() != null) {
            sql.VALUES("city_area_id", "#{cityAreaId,jdbcType=VARCHAR}");
        }
        
        if (record.getAreaId() != null) {
            sql.VALUES("area_id", "#{areaId,jdbcType=VARCHAR}");
        }
        
        if (record.getAreaInfo() != null) {
            sql.VALUES("area_info", "#{areaInfo,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenUserAddrInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("user_id");
        sql.SELECT("user_name");
        sql.SELECT("mobile");
        sql.SELECT("detail_addr");
        sql.SELECT("is_default");
        sql.SELECT("valid_status");
        sql.SELECT("create_time");
        sql.SELECT("province_area_id");
        sql.SELECT("city_area_id");
        sql.SELECT("area_id");
        sql.SELECT("area_info");
        sql.FROM("open_user_addr_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenUserAddrInfo record = (OpenUserAddrInfo) parameter.get("record");
        OpenUserAddrInfoExample example = (OpenUserAddrInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_user_addr_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.SET("mobile = #{record.mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getDetailAddr() != null) {
            sql.SET("detail_addr = #{record.detailAddr,jdbcType=VARCHAR}");
        }
        
        if (record.getIsDefault() != null) {
            sql.SET("is_default = #{record.isDefault,jdbcType=INTEGER}");
        }
        
        if (record.getValidStatus() != null) {
            sql.SET("valid_status = #{record.validStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProvinceAreaId() != null) {
            sql.SET("province_area_id = #{record.provinceAreaId,jdbcType=VARCHAR}");
        }
        
        if (record.getCityAreaId() != null) {
            sql.SET("city_area_id = #{record.cityAreaId,jdbcType=VARCHAR}");
        }
        
        if (record.getAreaId() != null) {
            sql.SET("area_id = #{record.areaId,jdbcType=VARCHAR}");
        }
        
        if (record.getAreaInfo() != null) {
            sql.SET("area_info = #{record.areaInfo,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_user_addr_info");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        sql.SET("mobile = #{record.mobile,jdbcType=VARCHAR}");
        sql.SET("detail_addr = #{record.detailAddr,jdbcType=VARCHAR}");
        sql.SET("is_default = #{record.isDefault,jdbcType=INTEGER}");
        sql.SET("valid_status = #{record.validStatus,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("province_area_id = #{record.provinceAreaId,jdbcType=VARCHAR}");
        sql.SET("city_area_id = #{record.cityAreaId,jdbcType=VARCHAR}");
        sql.SET("area_id = #{record.areaId,jdbcType=VARCHAR}");
        sql.SET("area_info = #{record.areaInfo,jdbcType=VARCHAR}");
        
        OpenUserAddrInfoExample example = (OpenUserAddrInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenUserAddrInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("open_user_addr_info");
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=BIGINT}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.SET("mobile = #{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getDetailAddr() != null) {
            sql.SET("detail_addr = #{detailAddr,jdbcType=VARCHAR}");
        }
        
        if (record.getIsDefault() != null) {
            sql.SET("is_default = #{isDefault,jdbcType=INTEGER}");
        }
        
        if (record.getValidStatus() != null) {
            sql.SET("valid_status = #{validStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProvinceAreaId() != null) {
            sql.SET("province_area_id = #{provinceAreaId,jdbcType=VARCHAR}");
        }
        
        if (record.getCityAreaId() != null) {
            sql.SET("city_area_id = #{cityAreaId,jdbcType=VARCHAR}");
        }
        
        if (record.getAreaId() != null) {
            sql.SET("area_id = #{areaId,jdbcType=VARCHAR}");
        }
        
        if (record.getAreaInfo() != null) {
            sql.SET("area_info = #{areaInfo,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenUserAddrInfoExample example, boolean includeExamplePhrase) {
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