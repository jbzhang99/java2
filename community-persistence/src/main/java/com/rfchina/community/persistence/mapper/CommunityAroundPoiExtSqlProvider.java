package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityAroundPoiExt;
import com.rfchina.community.persistence.model.CommunityAroundPoiExtExample.Criteria;
import com.rfchina.community.persistence.model.CommunityAroundPoiExtExample.Criterion;
import com.rfchina.community.persistence.model.CommunityAroundPoiExtExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CommunityAroundPoiExtSqlProvider {

    public String countByExample(CommunityAroundPoiExtExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("community_around_poi_ext");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CommunityAroundPoiExtExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("community_around_poi_ext");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CommunityAroundPoiExt record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("community_around_poi_ext");
        
        if (record.getPoiId() != null) {
            sql.VALUES("poi_id", "#{poiId,jdbcType=BIGINT}");
        }
        
        if (record.getRating() != null) {
            sql.VALUES("rating", "#{rating,jdbcType=DOUBLE}");
        }
        
        if (record.getCost() != null) {
            sql.VALUES("cost", "#{cost,jdbcType=DOUBLE}");
        }
        
        if (record.getNativeRating() != null) {
            sql.VALUES("native_rating", "#{nativeRating,jdbcType=DOUBLE}");
        }
        
        if (record.getShopHours() != null) {
            sql.VALUES("shop_hours", "#{shopHours,jdbcType=VARCHAR}");
        }
        
        if (record.getBaiduDetailUrl() != null) {
            sql.VALUES("baidu_detail_url", "#{baiduDetailUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getFeaturedService() != null) {
            sql.VALUES("featured_service", "#{featuredService,jdbcType=VARCHAR}");
        }
        
        if (record.getSyncStatus() != null) {
            sql.VALUES("sync_status", "#{syncStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBaiduUid() != null) {
            sql.VALUES("baidu_uid", "#{baiduUid,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CommunityAroundPoiExtExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("poi_id");
        } else {
            sql.SELECT("poi_id");
        }
        sql.SELECT("rating");
        sql.SELECT("cost");
        sql.SELECT("native_rating");
        sql.SELECT("shop_hours");
        sql.SELECT("baidu_detail_url");
        sql.SELECT("featured_service");
        sql.SELECT("sync_status");
        sql.SELECT("baidu_uid");
        sql.FROM("community_around_poi_ext");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CommunityAroundPoiExt record = (CommunityAroundPoiExt) parameter.get("record");
        CommunityAroundPoiExtExample example = (CommunityAroundPoiExtExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("community_around_poi_ext");
        
        if (record.getPoiId() != null) {
            sql.SET("poi_id = #{record.poiId,jdbcType=BIGINT}");
        }
        
        if (record.getRating() != null) {
            sql.SET("rating = #{record.rating,jdbcType=DOUBLE}");
        }
        
        if (record.getCost() != null) {
            sql.SET("cost = #{record.cost,jdbcType=DOUBLE}");
        }
        
        if (record.getNativeRating() != null) {
            sql.SET("native_rating = #{record.nativeRating,jdbcType=DOUBLE}");
        }
        
        if (record.getShopHours() != null) {
            sql.SET("shop_hours = #{record.shopHours,jdbcType=VARCHAR}");
        }
        
        if (record.getBaiduDetailUrl() != null) {
            sql.SET("baidu_detail_url = #{record.baiduDetailUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getFeaturedService() != null) {
            sql.SET("featured_service = #{record.featuredService,jdbcType=VARCHAR}");
        }
        
        if (record.getSyncStatus() != null) {
            sql.SET("sync_status = #{record.syncStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBaiduUid() != null) {
            sql.SET("baidu_uid = #{record.baiduUid,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("community_around_poi_ext");
        
        sql.SET("poi_id = #{record.poiId,jdbcType=BIGINT}");
        sql.SET("rating = #{record.rating,jdbcType=DOUBLE}");
        sql.SET("cost = #{record.cost,jdbcType=DOUBLE}");
        sql.SET("native_rating = #{record.nativeRating,jdbcType=DOUBLE}");
        sql.SET("shop_hours = #{record.shopHours,jdbcType=VARCHAR}");
        sql.SET("baidu_detail_url = #{record.baiduDetailUrl,jdbcType=VARCHAR}");
        sql.SET("featured_service = #{record.featuredService,jdbcType=VARCHAR}");
        sql.SET("sync_status = #{record.syncStatus,jdbcType=INTEGER}");
        sql.SET("baidu_uid = #{record.baiduUid,jdbcType=VARCHAR}");
        
        CommunityAroundPoiExtExample example = (CommunityAroundPoiExtExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CommunityAroundPoiExt record) {
        SQL sql = new SQL();
        sql.UPDATE("community_around_poi_ext");
        
        if (record.getRating() != null) {
            sql.SET("rating = #{rating,jdbcType=DOUBLE}");
        }
        
        if (record.getCost() != null) {
            sql.SET("cost = #{cost,jdbcType=DOUBLE}");
        }
        
        if (record.getNativeRating() != null) {
            sql.SET("native_rating = #{nativeRating,jdbcType=DOUBLE}");
        }
        
        if (record.getShopHours() != null) {
            sql.SET("shop_hours = #{shopHours,jdbcType=VARCHAR}");
        }
        
        if (record.getBaiduDetailUrl() != null) {
            sql.SET("baidu_detail_url = #{baiduDetailUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getFeaturedService() != null) {
            sql.SET("featured_service = #{featuredService,jdbcType=VARCHAR}");
        }
        
        if (record.getSyncStatus() != null) {
            sql.SET("sync_status = #{syncStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBaiduUid() != null) {
            sql.SET("baidu_uid = #{baiduUid,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("poi_id = #{poiId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CommunityAroundPoiExtExample example, boolean includeExamplePhrase) {
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