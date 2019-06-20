package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityAroundPoi;
import com.rfchina.community.persistence.model.CommunityAroundPoiExample.Criteria;
import com.rfchina.community.persistence.model.CommunityAroundPoiExample.Criterion;
import com.rfchina.community.persistence.model.CommunityAroundPoiExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CommunityAroundPoiSqlProvider {

    public String countByExample(CommunityAroundPoiExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("community_around_poi");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CommunityAroundPoiExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("community_around_poi");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CommunityAroundPoi record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("community_around_poi");
        
        if (record.getApiId() != null) {
            sql.VALUES("api_id", "#{apiId,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getApiType() != null) {
            sql.VALUES("api_type", "#{apiType,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getPicUrl() != null) {
            sql.VALUES("pic_url", "#{picUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getLongitude() != null) {
            sql.VALUES("longitude", "#{longitude,jdbcType=VARCHAR}");
        }
        
        if (record.getLatitude() != null) {
            sql.VALUES("latitude", "#{latitude,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.VALUES("tel", "#{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getPostCode() != null) {
            sql.VALUES("post_code", "#{postCode,jdbcType=VARCHAR}");
        }
        
        if (record.getWebSite() != null) {
            sql.VALUES("web_site", "#{webSite,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getProvinceCode() != null) {
            sql.VALUES("province_code", "#{provinceCode,jdbcType=VARCHAR}");
        }
        
        if (record.getProvinceName() != null) {
            sql.VALUES("province_name", "#{provinceName,jdbcType=VARCHAR}");
        }
        
        if (record.getCityCode() != null) {
            sql.VALUES("city_code", "#{cityCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCityName() != null) {
            sql.VALUES("city_name", "#{cityName,jdbcType=VARCHAR}");
        }
        
        if (record.getAdCode() != null) {
            sql.VALUES("ad_code", "#{adCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAdName() != null) {
            sql.VALUES("ad_name", "#{adName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSyncStatus() != null) {
            sql.VALUES("sync_status", "#{syncStatus,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CommunityAroundPoiExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("api_id");
        sql.SELECT("status");
        sql.SELECT("api_type");
        sql.SELECT("type");
        sql.SELECT("pic_url");
        sql.SELECT("name");
        sql.SELECT("address");
        sql.SELECT("longitude");
        sql.SELECT("latitude");
        sql.SELECT("tel");
        sql.SELECT("post_code");
        sql.SELECT("web_site");
        sql.SELECT("email");
        sql.SELECT("province_code");
        sql.SELECT("province_name");
        sql.SELECT("city_code");
        sql.SELECT("city_name");
        sql.SELECT("ad_code");
        sql.SELECT("ad_name");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("sync_status");
        sql.FROM("community_around_poi");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CommunityAroundPoi record = (CommunityAroundPoi) parameter.get("record");
        CommunityAroundPoiExample example = (CommunityAroundPoiExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("community_around_poi");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getApiId() != null) {
            sql.SET("api_id = #{record.apiId,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getApiType() != null) {
            sql.SET("api_type = #{record.apiType,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=VARCHAR}");
        }
        
        if (record.getPicUrl() != null) {
            sql.SET("pic_url = #{record.picUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getLongitude() != null) {
            sql.SET("longitude = #{record.longitude,jdbcType=VARCHAR}");
        }
        
        if (record.getLatitude() != null) {
            sql.SET("latitude = #{record.latitude,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.SET("tel = #{record.tel,jdbcType=VARCHAR}");
        }
        
        if (record.getPostCode() != null) {
            sql.SET("post_code = #{record.postCode,jdbcType=VARCHAR}");
        }
        
        if (record.getWebSite() != null) {
            sql.SET("web_site = #{record.webSite,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getProvinceCode() != null) {
            sql.SET("province_code = #{record.provinceCode,jdbcType=VARCHAR}");
        }
        
        if (record.getProvinceName() != null) {
            sql.SET("province_name = #{record.provinceName,jdbcType=VARCHAR}");
        }
        
        if (record.getCityCode() != null) {
            sql.SET("city_code = #{record.cityCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCityName() != null) {
            sql.SET("city_name = #{record.cityName,jdbcType=VARCHAR}");
        }
        
        if (record.getAdCode() != null) {
            sql.SET("ad_code = #{record.adCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAdName() != null) {
            sql.SET("ad_name = #{record.adName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSyncStatus() != null) {
            sql.SET("sync_status = #{record.syncStatus,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("community_around_poi");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("api_id = #{record.apiId,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("api_type = #{record.apiType,jdbcType=VARCHAR}");
        sql.SET("type = #{record.type,jdbcType=VARCHAR}");
        sql.SET("pic_url = #{record.picUrl,jdbcType=VARCHAR}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("longitude = #{record.longitude,jdbcType=VARCHAR}");
        sql.SET("latitude = #{record.latitude,jdbcType=VARCHAR}");
        sql.SET("tel = #{record.tel,jdbcType=VARCHAR}");
        sql.SET("post_code = #{record.postCode,jdbcType=VARCHAR}");
        sql.SET("web_site = #{record.webSite,jdbcType=VARCHAR}");
        sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        sql.SET("province_code = #{record.provinceCode,jdbcType=VARCHAR}");
        sql.SET("province_name = #{record.provinceName,jdbcType=VARCHAR}");
        sql.SET("city_code = #{record.cityCode,jdbcType=VARCHAR}");
        sql.SET("city_name = #{record.cityName,jdbcType=VARCHAR}");
        sql.SET("ad_code = #{record.adCode,jdbcType=VARCHAR}");
        sql.SET("ad_name = #{record.adName,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("sync_status = #{record.syncStatus,jdbcType=INTEGER}");
        
        CommunityAroundPoiExample example = (CommunityAroundPoiExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CommunityAroundPoi record) {
        SQL sql = new SQL();
        sql.UPDATE("community_around_poi");
        
        if (record.getApiId() != null) {
            sql.SET("api_id = #{apiId,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getApiType() != null) {
            sql.SET("api_type = #{apiType,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getPicUrl() != null) {
            sql.SET("pic_url = #{picUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getLongitude() != null) {
            sql.SET("longitude = #{longitude,jdbcType=VARCHAR}");
        }
        
        if (record.getLatitude() != null) {
            sql.SET("latitude = #{latitude,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.SET("tel = #{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getPostCode() != null) {
            sql.SET("post_code = #{postCode,jdbcType=VARCHAR}");
        }
        
        if (record.getWebSite() != null) {
            sql.SET("web_site = #{webSite,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getProvinceCode() != null) {
            sql.SET("province_code = #{provinceCode,jdbcType=VARCHAR}");
        }
        
        if (record.getProvinceName() != null) {
            sql.SET("province_name = #{provinceName,jdbcType=VARCHAR}");
        }
        
        if (record.getCityCode() != null) {
            sql.SET("city_code = #{cityCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCityName() != null) {
            sql.SET("city_name = #{cityName,jdbcType=VARCHAR}");
        }
        
        if (record.getAdCode() != null) {
            sql.SET("ad_code = #{adCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAdName() != null) {
            sql.SET("ad_name = #{adName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSyncStatus() != null) {
            sql.SET("sync_status = #{syncStatus,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CommunityAroundPoiExample example, boolean includeExamplePhrase) {
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