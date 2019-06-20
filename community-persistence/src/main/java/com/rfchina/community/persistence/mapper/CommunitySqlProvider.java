package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.Community;
import com.rfchina.community.persistence.model.CommunityExample.Criteria;
import com.rfchina.community.persistence.model.CommunityExample.Criterion;
import com.rfchina.community.persistence.model.CommunityExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CommunitySqlProvider {

    public String countByExample(CommunityExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("community");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CommunityExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("community");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Community record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("community");
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.VALUES("tel", "#{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getCityId() != null) {
            sql.VALUES("city_id", "#{cityId,jdbcType=INTEGER}");
        }
        
        if (record.getCityName() != null) {
            sql.VALUES("city_name", "#{cityName,jdbcType=VARCHAR}");
        }
        
        if (record.getAreaId() != null) {
            sql.VALUES("area_id", "#{areaId,jdbcType=INTEGER}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getIntro() != null) {
            sql.VALUES("intro", "#{intro,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getProjectGuid() != null) {
            sql.VALUES("project_guid", "#{projectGuid,jdbcType=VARCHAR}");
        }
        
        if (record.getCategory() != null) {
            sql.VALUES("category", "#{category,jdbcType=INTEGER}");
        }
        
        if (record.getSort() != null) {
            sql.VALUES("sort", "#{sort,jdbcType=INTEGER}");
        }
        
        if (record.getSyncFlag() != null) {
            sql.VALUES("sync_flag", "#{syncFlag,jdbcType=TINYINT}");
        }
        
        if (record.getQrcodeUrl() != null) {
            sql.VALUES("qrcode_url", "#{qrcodeUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getLongitude() != null) {
            sql.VALUES("longitude", "#{longitude,jdbcType=VARCHAR}");
        }
        
        if (record.getLatitude() != null) {
            sql.VALUES("latitude", "#{latitude,jdbcType=VARCHAR}");
        }
        
        if (record.getAdminId() != null) {
            sql.VALUES("admin_id", "#{adminId,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getBuildingArea() != null) {
            sql.VALUES("building_area", "#{buildingArea,jdbcType=VARCHAR}");
        }
        
        if (record.getPracticalArea() != null) {
            sql.VALUES("practical_area", "#{practicalArea,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeDesc() != null) {
            sql.VALUES("type_desc", "#{typeDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getLogoUrl() != null) {
            sql.VALUES("logo_url", "#{logoUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getBackgroundUrl() != null) {
            sql.VALUES("background_url", "#{backgroundUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getTopicAudit() != null) {
            sql.VALUES("topic_audit", "#{topicAudit,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCid() != null) {
            sql.VALUES("cid", "#{cid,jdbcType=BIGINT}");
        }
        
        if (record.getWeixin() != null) {
            sql.VALUES("weixin", "#{weixin,jdbcType=VARCHAR}");
        }
        
        if (record.getPropertyCompany() != null) {
            sql.VALUES("property_company", "#{propertyCompany,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessPerson() != null) {
            sql.VALUES("business_person", "#{businessPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessPhone() != null) {
            sql.VALUES("business_phone", "#{businessPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessEmail() != null) {
            sql.VALUES("business_email", "#{businessEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getPinyin() != null) {
            sql.VALUES("pinyin", "#{pinyin,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CommunityExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("name");
        sql.SELECT("phone");
        sql.SELECT("tel");
        sql.SELECT("city_id");
        sql.SELECT("city_name");
        sql.SELECT("area_id");
        sql.SELECT("address");
        sql.SELECT("intro");
        sql.SELECT("status");
        sql.SELECT("project_guid");
        sql.SELECT("category");
        sql.SELECT("sort");
        sql.SELECT("sync_flag");
        sql.SELECT("qrcode_url");
        sql.SELECT("longitude");
        sql.SELECT("latitude");
        sql.SELECT("admin_id");
        sql.SELECT("type");
        sql.SELECT("building_area");
        sql.SELECT("practical_area");
        sql.SELECT("type_desc");
        sql.SELECT("logo_url");
        sql.SELECT("background_url");
        sql.SELECT("topic_audit");
        sql.SELECT("create_time");
        sql.SELECT("cid");
        sql.SELECT("weixin");
        sql.SELECT("property_company");
        sql.SELECT("business_person");
        sql.SELECT("business_phone");
        sql.SELECT("business_email");
        sql.SELECT("pinyin");
        sql.SELECT("update_time");
        sql.FROM("community");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Community record = (Community) parameter.get("record");
        CommunityExample example = (CommunityExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("community");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.SET("tel = #{record.tel,jdbcType=VARCHAR}");
        }
        
        if (record.getCityId() != null) {
            sql.SET("city_id = #{record.cityId,jdbcType=INTEGER}");
        }
        
        if (record.getCityName() != null) {
            sql.SET("city_name = #{record.cityName,jdbcType=VARCHAR}");
        }
        
        if (record.getAreaId() != null) {
            sql.SET("area_id = #{record.areaId,jdbcType=INTEGER}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getIntro() != null) {
            sql.SET("intro = #{record.intro,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getProjectGuid() != null) {
            sql.SET("project_guid = #{record.projectGuid,jdbcType=VARCHAR}");
        }
        
        if (record.getCategory() != null) {
            sql.SET("category = #{record.category,jdbcType=INTEGER}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{record.sort,jdbcType=INTEGER}");
        }
        
        if (record.getSyncFlag() != null) {
            sql.SET("sync_flag = #{record.syncFlag,jdbcType=TINYINT}");
        }
        
        if (record.getQrcodeUrl() != null) {
            sql.SET("qrcode_url = #{record.qrcodeUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getLongitude() != null) {
            sql.SET("longitude = #{record.longitude,jdbcType=VARCHAR}");
        }
        
        if (record.getLatitude() != null) {
            sql.SET("latitude = #{record.latitude,jdbcType=VARCHAR}");
        }
        
        if (record.getAdminId() != null) {
            sql.SET("admin_id = #{record.adminId,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=INTEGER}");
        }
        
        if (record.getBuildingArea() != null) {
            sql.SET("building_area = #{record.buildingArea,jdbcType=VARCHAR}");
        }
        
        if (record.getPracticalArea() != null) {
            sql.SET("practical_area = #{record.practicalArea,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeDesc() != null) {
            sql.SET("type_desc = #{record.typeDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getLogoUrl() != null) {
            sql.SET("logo_url = #{record.logoUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getBackgroundUrl() != null) {
            sql.SET("background_url = #{record.backgroundUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getTopicAudit() != null) {
            sql.SET("topic_audit = #{record.topicAudit,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCid() != null) {
            sql.SET("cid = #{record.cid,jdbcType=BIGINT}");
        }
        
        if (record.getWeixin() != null) {
            sql.SET("weixin = #{record.weixin,jdbcType=VARCHAR}");
        }
        
        if (record.getPropertyCompany() != null) {
            sql.SET("property_company = #{record.propertyCompany,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessPerson() != null) {
            sql.SET("business_person = #{record.businessPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessPhone() != null) {
            sql.SET("business_phone = #{record.businessPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessEmail() != null) {
            sql.SET("business_email = #{record.businessEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getPinyin() != null) {
            sql.SET("pinyin = #{record.pinyin,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("community");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        sql.SET("tel = #{record.tel,jdbcType=VARCHAR}");
        sql.SET("city_id = #{record.cityId,jdbcType=INTEGER}");
        sql.SET("city_name = #{record.cityName,jdbcType=VARCHAR}");
        sql.SET("area_id = #{record.areaId,jdbcType=INTEGER}");
        sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("intro = #{record.intro,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("project_guid = #{record.projectGuid,jdbcType=VARCHAR}");
        sql.SET("category = #{record.category,jdbcType=INTEGER}");
        sql.SET("sort = #{record.sort,jdbcType=INTEGER}");
        sql.SET("sync_flag = #{record.syncFlag,jdbcType=TINYINT}");
        sql.SET("qrcode_url = #{record.qrcodeUrl,jdbcType=VARCHAR}");
        sql.SET("longitude = #{record.longitude,jdbcType=VARCHAR}");
        sql.SET("latitude = #{record.latitude,jdbcType=VARCHAR}");
        sql.SET("admin_id = #{record.adminId,jdbcType=BIGINT}");
        sql.SET("type = #{record.type,jdbcType=INTEGER}");
        sql.SET("building_area = #{record.buildingArea,jdbcType=VARCHAR}");
        sql.SET("practical_area = #{record.practicalArea,jdbcType=VARCHAR}");
        sql.SET("type_desc = #{record.typeDesc,jdbcType=VARCHAR}");
        sql.SET("logo_url = #{record.logoUrl,jdbcType=VARCHAR}");
        sql.SET("background_url = #{record.backgroundUrl,jdbcType=VARCHAR}");
        sql.SET("topic_audit = #{record.topicAudit,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("cid = #{record.cid,jdbcType=BIGINT}");
        sql.SET("weixin = #{record.weixin,jdbcType=VARCHAR}");
        sql.SET("property_company = #{record.propertyCompany,jdbcType=VARCHAR}");
        sql.SET("business_person = #{record.businessPerson,jdbcType=VARCHAR}");
        sql.SET("business_phone = #{record.businessPhone,jdbcType=VARCHAR}");
        sql.SET("business_email = #{record.businessEmail,jdbcType=VARCHAR}");
        sql.SET("pinyin = #{record.pinyin,jdbcType=VARCHAR}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        CommunityExample example = (CommunityExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Community record) {
        SQL sql = new SQL();
        sql.UPDATE("community");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.SET("tel = #{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getCityId() != null) {
            sql.SET("city_id = #{cityId,jdbcType=INTEGER}");
        }
        
        if (record.getCityName() != null) {
            sql.SET("city_name = #{cityName,jdbcType=VARCHAR}");
        }
        
        if (record.getAreaId() != null) {
            sql.SET("area_id = #{areaId,jdbcType=INTEGER}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getIntro() != null) {
            sql.SET("intro = #{intro,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getProjectGuid() != null) {
            sql.SET("project_guid = #{projectGuid,jdbcType=VARCHAR}");
        }
        
        if (record.getCategory() != null) {
            sql.SET("category = #{category,jdbcType=INTEGER}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{sort,jdbcType=INTEGER}");
        }
        
        if (record.getSyncFlag() != null) {
            sql.SET("sync_flag = #{syncFlag,jdbcType=TINYINT}");
        }
        
        if (record.getQrcodeUrl() != null) {
            sql.SET("qrcode_url = #{qrcodeUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getLongitude() != null) {
            sql.SET("longitude = #{longitude,jdbcType=VARCHAR}");
        }
        
        if (record.getLatitude() != null) {
            sql.SET("latitude = #{latitude,jdbcType=VARCHAR}");
        }
        
        if (record.getAdminId() != null) {
            sql.SET("admin_id = #{adminId,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getBuildingArea() != null) {
            sql.SET("building_area = #{buildingArea,jdbcType=VARCHAR}");
        }
        
        if (record.getPracticalArea() != null) {
            sql.SET("practical_area = #{practicalArea,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeDesc() != null) {
            sql.SET("type_desc = #{typeDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getLogoUrl() != null) {
            sql.SET("logo_url = #{logoUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getBackgroundUrl() != null) {
            sql.SET("background_url = #{backgroundUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getTopicAudit() != null) {
            sql.SET("topic_audit = #{topicAudit,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCid() != null) {
            sql.SET("cid = #{cid,jdbcType=BIGINT}");
        }
        
        if (record.getWeixin() != null) {
            sql.SET("weixin = #{weixin,jdbcType=VARCHAR}");
        }
        
        if (record.getPropertyCompany() != null) {
            sql.SET("property_company = #{propertyCompany,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessPerson() != null) {
            sql.SET("business_person = #{businessPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessPhone() != null) {
            sql.SET("business_phone = #{businessPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessEmail() != null) {
            sql.SET("business_email = #{businessEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getPinyin() != null) {
            sql.SET("pinyin = #{pinyin,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CommunityExample example, boolean includeExamplePhrase) {
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