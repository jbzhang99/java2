package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.StatMasterInfo;
import com.rfchina.community.persistence.model.StatMasterInfoExample.Criteria;
import com.rfchina.community.persistence.model.StatMasterInfoExample.Criterion;
import com.rfchina.community.persistence.model.StatMasterInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class StatMasterInfoSqlProvider {

    public String countByExample(StatMasterInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("stat_master_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(StatMasterInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("stat_master_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(StatMasterInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("stat_master_info");
        
        if (record.getAreaId() != null) {
            sql.VALUES("area_id", "#{areaId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityType() != null) {
            sql.VALUES("community_type", "#{communityType,jdbcType=INTEGER}");
        }
        
        if (record.getUserCount() != null) {
            sql.VALUES("user_count", "#{userCount,jdbcType=INTEGER}");
        }
        
        if (record.getMasterCount() != null) {
            sql.VALUES("master_count", "#{masterCount,jdbcType=INTEGER}");
        }
        
        if (record.getRoomCount() != null) {
            sql.VALUES("room_count", "#{roomCount,jdbcType=INTEGER}");
        }
        
        if (record.getParkingCount() != null) {
            sql.VALUES("parking_count", "#{parkingCount,jdbcType=INTEGER}");
        }
        
        if (record.getMasterChildCount() != null) {
            sql.VALUES("master_child_count", "#{masterChildCount,jdbcType=INTEGER}");
        }
        
        if (record.getOwnerCount() != null) {
            sql.VALUES("owner_count", "#{ownerCount,jdbcType=INTEGER}");
        }
        
        if (record.getBizOwnerCount() != null) {
            sql.VALUES("biz_owner_count", "#{bizOwnerCount,jdbcType=INTEGER}");
        }
        
        if (record.getTenantCount() != null) {
            sql.VALUES("tenant_count", "#{tenantCount,jdbcType=INTEGER}");
        }
        
        if (record.getFamilyCount() != null) {
            sql.VALUES("family_count", "#{familyCount,jdbcType=INTEGER}");
        }
        
        if (record.getStaffCount() != null) {
            sql.VALUES("staff_count", "#{staffCount,jdbcType=INTEGER}");
        }
        
        if (record.getSiteStaffCount() != null) {
            sql.VALUES("site_staff_count", "#{siteStaffCount,jdbcType=INTEGER}");
        }
        
        if (record.getOtherCount() != null) {
            sql.VALUES("other_count", "#{otherCount,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getPropType() != null) {
            sql.VALUES("prop_type", "#{propType,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatTime() != null) {
            sql.VALUES("stat_time", "#{statTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(StatMasterInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("area_id");
        sql.SELECT("community_id");
        sql.SELECT("community_type");
        sql.SELECT("user_count");
        sql.SELECT("master_count");
        sql.SELECT("room_count");
        sql.SELECT("parking_count");
        sql.SELECT("master_child_count");
        sql.SELECT("owner_count");
        sql.SELECT("biz_owner_count");
        sql.SELECT("tenant_count");
        sql.SELECT("family_count");
        sql.SELECT("staff_count");
        sql.SELECT("site_staff_count");
        sql.SELECT("other_count");
        sql.SELECT("type");
        sql.SELECT("prop_type");
        sql.SELECT("create_time");
        sql.SELECT("stat_time");
        sql.FROM("stat_master_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        StatMasterInfo record = (StatMasterInfo) parameter.get("record");
        StatMasterInfoExample example = (StatMasterInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("stat_master_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getAreaId() != null) {
            sql.SET("area_id = #{record.areaId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityType() != null) {
            sql.SET("community_type = #{record.communityType,jdbcType=INTEGER}");
        }
        
        if (record.getUserCount() != null) {
            sql.SET("user_count = #{record.userCount,jdbcType=INTEGER}");
        }
        
        if (record.getMasterCount() != null) {
            sql.SET("master_count = #{record.masterCount,jdbcType=INTEGER}");
        }
        
        if (record.getRoomCount() != null) {
            sql.SET("room_count = #{record.roomCount,jdbcType=INTEGER}");
        }
        
        if (record.getParkingCount() != null) {
            sql.SET("parking_count = #{record.parkingCount,jdbcType=INTEGER}");
        }
        
        if (record.getMasterChildCount() != null) {
            sql.SET("master_child_count = #{record.masterChildCount,jdbcType=INTEGER}");
        }
        
        if (record.getOwnerCount() != null) {
            sql.SET("owner_count = #{record.ownerCount,jdbcType=INTEGER}");
        }
        
        if (record.getBizOwnerCount() != null) {
            sql.SET("biz_owner_count = #{record.bizOwnerCount,jdbcType=INTEGER}");
        }
        
        if (record.getTenantCount() != null) {
            sql.SET("tenant_count = #{record.tenantCount,jdbcType=INTEGER}");
        }
        
        if (record.getFamilyCount() != null) {
            sql.SET("family_count = #{record.familyCount,jdbcType=INTEGER}");
        }
        
        if (record.getStaffCount() != null) {
            sql.SET("staff_count = #{record.staffCount,jdbcType=INTEGER}");
        }
        
        if (record.getSiteStaffCount() != null) {
            sql.SET("site_staff_count = #{record.siteStaffCount,jdbcType=INTEGER}");
        }
        
        if (record.getOtherCount() != null) {
            sql.SET("other_count = #{record.otherCount,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=INTEGER}");
        }
        
        if (record.getPropType() != null) {
            sql.SET("prop_type = #{record.propType,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatTime() != null) {
            sql.SET("stat_time = #{record.statTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("stat_master_info");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("area_id = #{record.areaId,jdbcType=INTEGER}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("community_type = #{record.communityType,jdbcType=INTEGER}");
        sql.SET("user_count = #{record.userCount,jdbcType=INTEGER}");
        sql.SET("master_count = #{record.masterCount,jdbcType=INTEGER}");
        sql.SET("room_count = #{record.roomCount,jdbcType=INTEGER}");
        sql.SET("parking_count = #{record.parkingCount,jdbcType=INTEGER}");
        sql.SET("master_child_count = #{record.masterChildCount,jdbcType=INTEGER}");
        sql.SET("owner_count = #{record.ownerCount,jdbcType=INTEGER}");
        sql.SET("biz_owner_count = #{record.bizOwnerCount,jdbcType=INTEGER}");
        sql.SET("tenant_count = #{record.tenantCount,jdbcType=INTEGER}");
        sql.SET("family_count = #{record.familyCount,jdbcType=INTEGER}");
        sql.SET("staff_count = #{record.staffCount,jdbcType=INTEGER}");
        sql.SET("site_staff_count = #{record.siteStaffCount,jdbcType=INTEGER}");
        sql.SET("other_count = #{record.otherCount,jdbcType=INTEGER}");
        sql.SET("type = #{record.type,jdbcType=INTEGER}");
        sql.SET("prop_type = #{record.propType,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("stat_time = #{record.statTime,jdbcType=TIMESTAMP}");
        
        StatMasterInfoExample example = (StatMasterInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(StatMasterInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("stat_master_info");
        
        if (record.getAreaId() != null) {
            sql.SET("area_id = #{areaId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityType() != null) {
            sql.SET("community_type = #{communityType,jdbcType=INTEGER}");
        }
        
        if (record.getUserCount() != null) {
            sql.SET("user_count = #{userCount,jdbcType=INTEGER}");
        }
        
        if (record.getMasterCount() != null) {
            sql.SET("master_count = #{masterCount,jdbcType=INTEGER}");
        }
        
        if (record.getRoomCount() != null) {
            sql.SET("room_count = #{roomCount,jdbcType=INTEGER}");
        }
        
        if (record.getParkingCount() != null) {
            sql.SET("parking_count = #{parkingCount,jdbcType=INTEGER}");
        }
        
        if (record.getMasterChildCount() != null) {
            sql.SET("master_child_count = #{masterChildCount,jdbcType=INTEGER}");
        }
        
        if (record.getOwnerCount() != null) {
            sql.SET("owner_count = #{ownerCount,jdbcType=INTEGER}");
        }
        
        if (record.getBizOwnerCount() != null) {
            sql.SET("biz_owner_count = #{bizOwnerCount,jdbcType=INTEGER}");
        }
        
        if (record.getTenantCount() != null) {
            sql.SET("tenant_count = #{tenantCount,jdbcType=INTEGER}");
        }
        
        if (record.getFamilyCount() != null) {
            sql.SET("family_count = #{familyCount,jdbcType=INTEGER}");
        }
        
        if (record.getStaffCount() != null) {
            sql.SET("staff_count = #{staffCount,jdbcType=INTEGER}");
        }
        
        if (record.getSiteStaffCount() != null) {
            sql.SET("site_staff_count = #{siteStaffCount,jdbcType=INTEGER}");
        }
        
        if (record.getOtherCount() != null) {
            sql.SET("other_count = #{otherCount,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getPropType() != null) {
            sql.SET("prop_type = #{propType,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatTime() != null) {
            sql.SET("stat_time = #{statTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, StatMasterInfoExample example, boolean includeExamplePhrase) {
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