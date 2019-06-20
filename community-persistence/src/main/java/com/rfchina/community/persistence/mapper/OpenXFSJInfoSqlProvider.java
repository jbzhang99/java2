package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenXFSJInfo;
import com.rfchina.community.persistence.model.OpenXFSJInfoExample.Criteria;
import com.rfchina.community.persistence.model.OpenXFSJInfoExample.Criterion;
import com.rfchina.community.persistence.model.OpenXFSJInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenXFSJInfoSqlProvider {

    public String countByExample(OpenXFSJInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_xfsj_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenXFSJInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_xfsj_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenXFSJInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_xfsj_info");
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getCategoryId() != null) {
            sql.VALUES("category_id", "#{categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getActTitile() != null) {
            sql.VALUES("act_titile", "#{actTitile,jdbcType=VARCHAR}");
        }
        
        if (record.getActAddress() != null) {
            sql.VALUES("act_address", "#{actAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getActTime() != null) {
            sql.VALUES("act_time", "#{actTime,jdbcType=VARCHAR}");
        }
        
        if (record.getActImg() != null) {
            sql.VALUES("act_img", "#{actImg,jdbcType=VARCHAR}");
        }
        
        if (record.getActUrl() != null) {
            sql.VALUES("act_url", "#{actUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUid() != null) {
            sql.VALUES("create_uid", "#{createUid,jdbcType=BIGINT}");
        }
        
        if (record.getBeginTime() != null) {
            sql.VALUES("begin_time", "#{beginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.VALUES("end_time", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGroupConfigId() != null) {
            sql.VALUES("group_config_id", "#{groupConfigId,jdbcType=BIGINT}");
        }
        
        if (record.getAreaConfigId() != null) {
            sql.VALUES("area_config_id", "#{areaConfigId,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenXFSJInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("type");
        sql.SELECT("category_id");
        sql.SELECT("community_id");
        sql.SELECT("act_titile");
        sql.SELECT("act_address");
        sql.SELECT("act_time");
        sql.SELECT("act_img");
        sql.SELECT("act_url");
        sql.SELECT("status");
        sql.SELECT("create_time");
        sql.SELECT("create_uid");
        sql.SELECT("begin_time");
        sql.SELECT("end_time");
        sql.SELECT("group_config_id");
        sql.SELECT("area_config_id");
        sql.FROM("open_xfsj_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenXFSJInfo record = (OpenXFSJInfo) parameter.get("record");
        OpenXFSJInfoExample example = (OpenXFSJInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_xfsj_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=VARCHAR}");
        }
        
        if (record.getCategoryId() != null) {
            sql.SET("category_id = #{record.categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getActTitile() != null) {
            sql.SET("act_titile = #{record.actTitile,jdbcType=VARCHAR}");
        }
        
        if (record.getActAddress() != null) {
            sql.SET("act_address = #{record.actAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getActTime() != null) {
            sql.SET("act_time = #{record.actTime,jdbcType=VARCHAR}");
        }
        
        if (record.getActImg() != null) {
            sql.SET("act_img = #{record.actImg,jdbcType=VARCHAR}");
        }
        
        if (record.getActUrl() != null) {
            sql.SET("act_url = #{record.actUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUid() != null) {
            sql.SET("create_uid = #{record.createUid,jdbcType=BIGINT}");
        }
        
        if (record.getBeginTime() != null) {
            sql.SET("begin_time = #{record.beginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGroupConfigId() != null) {
            sql.SET("group_config_id = #{record.groupConfigId,jdbcType=BIGINT}");
        }
        
        if (record.getAreaConfigId() != null) {
            sql.SET("area_config_id = #{record.areaConfigId,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_xfsj_info");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("type = #{record.type,jdbcType=VARCHAR}");
        sql.SET("category_id = #{record.categoryId,jdbcType=INTEGER}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("act_titile = #{record.actTitile,jdbcType=VARCHAR}");
        sql.SET("act_address = #{record.actAddress,jdbcType=VARCHAR}");
        sql.SET("act_time = #{record.actTime,jdbcType=VARCHAR}");
        sql.SET("act_img = #{record.actImg,jdbcType=VARCHAR}");
        sql.SET("act_url = #{record.actUrl,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("create_uid = #{record.createUid,jdbcType=BIGINT}");
        sql.SET("begin_time = #{record.beginTime,jdbcType=TIMESTAMP}");
        sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        sql.SET("group_config_id = #{record.groupConfigId,jdbcType=BIGINT}");
        sql.SET("area_config_id = #{record.areaConfigId,jdbcType=BIGINT}");
        
        OpenXFSJInfoExample example = (OpenXFSJInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenXFSJInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("open_xfsj_info");
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getCategoryId() != null) {
            sql.SET("category_id = #{categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getActTitile() != null) {
            sql.SET("act_titile = #{actTitile,jdbcType=VARCHAR}");
        }
        
        if (record.getActAddress() != null) {
            sql.SET("act_address = #{actAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getActTime() != null) {
            sql.SET("act_time = #{actTime,jdbcType=VARCHAR}");
        }
        
        if (record.getActImg() != null) {
            sql.SET("act_img = #{actImg,jdbcType=VARCHAR}");
        }
        
        if (record.getActUrl() != null) {
            sql.SET("act_url = #{actUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUid() != null) {
            sql.SET("create_uid = #{createUid,jdbcType=BIGINT}");
        }
        
        if (record.getBeginTime() != null) {
            sql.SET("begin_time = #{beginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGroupConfigId() != null) {
            sql.SET("group_config_id = #{groupConfigId,jdbcType=BIGINT}");
        }
        
        if (record.getAreaConfigId() != null) {
            sql.SET("area_config_id = #{areaConfigId,jdbcType=BIGINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenXFSJInfoExample example, boolean includeExamplePhrase) {
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