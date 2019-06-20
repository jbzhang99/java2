package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VenueInfo;
import com.rfchina.community.persistence.model.VenueInfoExample.Criteria;
import com.rfchina.community.persistence.model.VenueInfoExample.Criterion;
import com.rfchina.community.persistence.model.VenueInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class VenueInfoSqlProvider {

    public String countByExample(VenueInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("venue_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(VenueInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("venue_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(VenueInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("venue_info");
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getServiceType() != null) {
            sql.VALUES("service_type", "#{serviceType,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getChargeType() != null) {
            sql.VALUES("charge_type", "#{chargeType,jdbcType=INTEGER}");
        }
        
        if (record.getReorder() != null) {
            sql.VALUES("reorder", "#{reorder,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getBusinessBegin() != null) {
            sql.VALUES("business_begin", "#{businessBegin,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessEnd() != null) {
            sql.VALUES("business_end", "#{businessEnd,jdbcType=VARCHAR}");
        }
        
        if (record.getWeekPart() != null) {
            sql.VALUES("week_part", "#{weekPart,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getIntro() != null) {
            sql.VALUES("intro", "#{intro,jdbcType=VARCHAR}");
        }
        
        if (record.getDefPrice() != null) {
            sql.VALUES("def_price", "#{defPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPpv() != null) {
            sql.VALUES("ppv", "#{ppv,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(VenueInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("community_id");
        sql.SELECT("service_type");
        sql.SELECT("title");
        sql.SELECT("charge_type");
        sql.SELECT("reorder");
        sql.SELECT("status");
        sql.SELECT("business_begin");
        sql.SELECT("business_end");
        sql.SELECT("week_part");
        sql.SELECT("address");
        sql.SELECT("intro");
        sql.SELECT("def_price");
        sql.SELECT("ppv");
        sql.FROM("venue_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(VenueInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("community_id");
        sql.SELECT("service_type");
        sql.SELECT("title");
        sql.SELECT("charge_type");
        sql.SELECT("reorder");
        sql.SELECT("status");
        sql.SELECT("business_begin");
        sql.SELECT("business_end");
        sql.SELECT("week_part");
        sql.SELECT("address");
        sql.SELECT("intro");
        sql.SELECT("def_price");
        sql.FROM("venue_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        VenueInfo record = (VenueInfo) parameter.get("record");
        VenueInfoExample example = (VenueInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("venue_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getServiceType() != null) {
            sql.SET("service_type = #{record.serviceType,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getChargeType() != null) {
            sql.SET("charge_type = #{record.chargeType,jdbcType=INTEGER}");
        }
        
        if (record.getReorder() != null) {
            sql.SET("reorder = #{record.reorder,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getBusinessBegin() != null) {
            sql.SET("business_begin = #{record.businessBegin,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessEnd() != null) {
            sql.SET("business_end = #{record.businessEnd,jdbcType=VARCHAR}");
        }
        
        if (record.getWeekPart() != null) {
            sql.SET("week_part = #{record.weekPart,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getIntro() != null) {
            sql.SET("intro = #{record.intro,jdbcType=VARCHAR}");
        }
        
        if (record.getDefPrice() != null) {
            sql.SET("def_price = #{record.defPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPpv() != null) {
            sql.SET("ppv = #{record.ppv,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("venue_info");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("service_type = #{record.serviceType,jdbcType=INTEGER}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("charge_type = #{record.chargeType,jdbcType=INTEGER}");
        sql.SET("reorder = #{record.reorder,jdbcType=INTEGER}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("business_begin = #{record.businessBegin,jdbcType=VARCHAR}");
        sql.SET("business_end = #{record.businessEnd,jdbcType=VARCHAR}");
        sql.SET("week_part = #{record.weekPart,jdbcType=VARCHAR}");
        sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("intro = #{record.intro,jdbcType=VARCHAR}");
        sql.SET("def_price = #{record.defPrice,jdbcType=DECIMAL}");
        sql.SET("ppv = #{record.ppv,jdbcType=LONGVARCHAR}");
        
        VenueInfoExample example = (VenueInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("venue_info");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("service_type = #{record.serviceType,jdbcType=INTEGER}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("charge_type = #{record.chargeType,jdbcType=INTEGER}");
        sql.SET("reorder = #{record.reorder,jdbcType=INTEGER}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("business_begin = #{record.businessBegin,jdbcType=VARCHAR}");
        sql.SET("business_end = #{record.businessEnd,jdbcType=VARCHAR}");
        sql.SET("week_part = #{record.weekPart,jdbcType=VARCHAR}");
        sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("intro = #{record.intro,jdbcType=VARCHAR}");
        sql.SET("def_price = #{record.defPrice,jdbcType=DECIMAL}");
        
        VenueInfoExample example = (VenueInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(VenueInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("venue_info");
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getServiceType() != null) {
            sql.SET("service_type = #{serviceType,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getChargeType() != null) {
            sql.SET("charge_type = #{chargeType,jdbcType=INTEGER}");
        }
        
        if (record.getReorder() != null) {
            sql.SET("reorder = #{reorder,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getBusinessBegin() != null) {
            sql.SET("business_begin = #{businessBegin,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessEnd() != null) {
            sql.SET("business_end = #{businessEnd,jdbcType=VARCHAR}");
        }
        
        if (record.getWeekPart() != null) {
            sql.SET("week_part = #{weekPart,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getIntro() != null) {
            sql.SET("intro = #{intro,jdbcType=VARCHAR}");
        }
        
        if (record.getDefPrice() != null) {
            sql.SET("def_price = #{defPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPpv() != null) {
            sql.SET("ppv = #{ppv,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, VenueInfoExample example, boolean includeExamplePhrase) {
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