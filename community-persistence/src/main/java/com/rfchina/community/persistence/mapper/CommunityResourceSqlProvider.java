package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityResource;
import com.rfchina.community.persistence.model.CommunityResourceExample.Criteria;
import com.rfchina.community.persistence.model.CommunityResourceExample.Criterion;
import com.rfchina.community.persistence.model.CommunityResourceExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CommunityResourceSqlProvider {

    public String countByExample(CommunityResourceExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("community_resource");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CommunityResourceExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("community_resource");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CommunityResource record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("community_resource");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCityId() != null) {
            sql.VALUES("city_id", "#{cityId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getResourceTypeId() != null) {
            sql.VALUES("resource_type_id", "#{resourceTypeId,jdbcType=INTEGER}");
        }
        
        if (record.getAddrDetail() != null) {
            sql.VALUES("addr_detail", "#{addrDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getResourceDesc() != null) {
            sql.VALUES("resource_desc", "#{resourceDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getResourceTotal() != null) {
            sql.VALUES("resource_total", "#{resourceTotal,jdbcType=INTEGER}");
        }
        
        if (record.getResourceUsed() != null) {
            sql.VALUES("resource_used", "#{resourceUsed,jdbcType=INTEGER}");
        }
        
        if (record.getResourceFee() != null) {
            sql.VALUES("resource_fee", "#{resourceFee,jdbcType=DECIMAL}");
        }
        
        if (record.getImgs() != null) {
            sql.VALUES("imgs", "#{imgs,jdbcType=VARCHAR}");
        }
        
        if (record.getResourceStatus() != null) {
            sql.VALUES("resource_status", "#{resourceStatus,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreaterId() != null) {
            sql.VALUES("creater_id", "#{createrId,jdbcType=INTEGER}");
        }
        
        if (record.getModifyTime() != null) {
            sql.VALUES("modify_time", "#{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifierId() != null) {
            sql.VALUES("modifier_id", "#{modifierId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CommunityResourceExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("city_id");
        sql.SELECT("community_id");
        sql.SELECT("resource_type_id");
        sql.SELECT("addr_detail");
        sql.SELECT("resource_desc");
        sql.SELECT("resource_total");
        sql.SELECT("resource_used");
        sql.SELECT("resource_fee");
        sql.SELECT("imgs");
        sql.SELECT("resource_status");
        sql.SELECT("create_time");
        sql.SELECT("creater_id");
        sql.SELECT("modify_time");
        sql.SELECT("modifier_id");
        sql.FROM("community_resource");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CommunityResource record = (CommunityResource) parameter.get("record");
        CommunityResourceExample example = (CommunityResourceExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("community_resource");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getCityId() != null) {
            sql.SET("city_id = #{record.cityId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getResourceTypeId() != null) {
            sql.SET("resource_type_id = #{record.resourceTypeId,jdbcType=INTEGER}");
        }
        
        if (record.getAddrDetail() != null) {
            sql.SET("addr_detail = #{record.addrDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getResourceDesc() != null) {
            sql.SET("resource_desc = #{record.resourceDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getResourceTotal() != null) {
            sql.SET("resource_total = #{record.resourceTotal,jdbcType=INTEGER}");
        }
        
        if (record.getResourceUsed() != null) {
            sql.SET("resource_used = #{record.resourceUsed,jdbcType=INTEGER}");
        }
        
        if (record.getResourceFee() != null) {
            sql.SET("resource_fee = #{record.resourceFee,jdbcType=DECIMAL}");
        }
        
        if (record.getImgs() != null) {
            sql.SET("imgs = #{record.imgs,jdbcType=VARCHAR}");
        }
        
        if (record.getResourceStatus() != null) {
            sql.SET("resource_status = #{record.resourceStatus,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreaterId() != null) {
            sql.SET("creater_id = #{record.createrId,jdbcType=INTEGER}");
        }
        
        if (record.getModifyTime() != null) {
            sql.SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifierId() != null) {
            sql.SET("modifier_id = #{record.modifierId,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("community_resource");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("city_id = #{record.cityId,jdbcType=INTEGER}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("resource_type_id = #{record.resourceTypeId,jdbcType=INTEGER}");
        sql.SET("addr_detail = #{record.addrDetail,jdbcType=VARCHAR}");
        sql.SET("resource_desc = #{record.resourceDesc,jdbcType=VARCHAR}");
        sql.SET("resource_total = #{record.resourceTotal,jdbcType=INTEGER}");
        sql.SET("resource_used = #{record.resourceUsed,jdbcType=INTEGER}");
        sql.SET("resource_fee = #{record.resourceFee,jdbcType=DECIMAL}");
        sql.SET("imgs = #{record.imgs,jdbcType=VARCHAR}");
        sql.SET("resource_status = #{record.resourceStatus,jdbcType=TINYINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("creater_id = #{record.createrId,jdbcType=INTEGER}");
        sql.SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        sql.SET("modifier_id = #{record.modifierId,jdbcType=INTEGER}");
        
        CommunityResourceExample example = (CommunityResourceExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CommunityResource record) {
        SQL sql = new SQL();
        sql.UPDATE("community_resource");
        
        if (record.getCityId() != null) {
            sql.SET("city_id = #{cityId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getResourceTypeId() != null) {
            sql.SET("resource_type_id = #{resourceTypeId,jdbcType=INTEGER}");
        }
        
        if (record.getAddrDetail() != null) {
            sql.SET("addr_detail = #{addrDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getResourceDesc() != null) {
            sql.SET("resource_desc = #{resourceDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getResourceTotal() != null) {
            sql.SET("resource_total = #{resourceTotal,jdbcType=INTEGER}");
        }
        
        if (record.getResourceUsed() != null) {
            sql.SET("resource_used = #{resourceUsed,jdbcType=INTEGER}");
        }
        
        if (record.getResourceFee() != null) {
            sql.SET("resource_fee = #{resourceFee,jdbcType=DECIMAL}");
        }
        
        if (record.getImgs() != null) {
            sql.SET("imgs = #{imgs,jdbcType=VARCHAR}");
        }
        
        if (record.getResourceStatus() != null) {
            sql.SET("resource_status = #{resourceStatus,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreaterId() != null) {
            sql.SET("creater_id = #{createrId,jdbcType=INTEGER}");
        }
        
        if (record.getModifyTime() != null) {
            sql.SET("modify_time = #{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifierId() != null) {
            sql.SET("modifier_id = #{modifierId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CommunityResourceExample example, boolean includeExamplePhrase) {
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