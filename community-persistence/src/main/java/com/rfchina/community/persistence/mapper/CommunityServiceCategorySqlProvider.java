package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityServiceCategory;
import com.rfchina.community.persistence.model.CommunityServiceCategoryExample.Criteria;
import com.rfchina.community.persistence.model.CommunityServiceCategoryExample.Criterion;
import com.rfchina.community.persistence.model.CommunityServiceCategoryExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CommunityServiceCategorySqlProvider {

    public String countByExample(CommunityServiceCategoryExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("community_service_category");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CommunityServiceCategoryExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("community_service_category");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CommunityServiceCategory record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("community_service_category");
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getSort() != null) {
            sql.VALUES("sort", "#{sort,jdbcType=INTEGER}");
        }
        
        if (record.getExposure() != null) {
            sql.VALUES("exposure", "#{exposure,jdbcType=INTEGER}");
        }
        
        if (record.getPid() != null) {
            sql.VALUES("pid", "#{pid,jdbcType=INTEGER}");
        }
        
        if (record.getLink() != null) {
            sql.VALUES("link", "#{link,jdbcType=VARCHAR}");
        }
        
        if (record.getPng() != null) {
            sql.VALUES("png", "#{png,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityFee() != null) {
            sql.VALUES("community_fee", "#{communityFee,jdbcType=DECIMAL}");
        }
        
        if (record.getPremiumNum() != null) {
            sql.VALUES("premium_num", "#{premiumNum,jdbcType=INTEGER}");
        }
        
        if (record.getValidStatus() != null) {
            sql.VALUES("valid_status", "#{validStatus,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CommunityServiceCategoryExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("name");
        sql.SELECT("create_time");
        sql.SELECT("type");
        sql.SELECT("sort");
        sql.SELECT("exposure");
        sql.SELECT("pid");
        sql.SELECT("link");
        sql.SELECT("png");
        sql.SELECT("community_fee");
        sql.SELECT("premium_num");
        sql.SELECT("valid_status");
        sql.FROM("community_service_category");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CommunityServiceCategory record = (CommunityServiceCategory) parameter.get("record");
        CommunityServiceCategoryExample example = (CommunityServiceCategoryExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("community_service_category");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=INTEGER}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{record.sort,jdbcType=INTEGER}");
        }
        
        if (record.getExposure() != null) {
            sql.SET("exposure = #{record.exposure,jdbcType=INTEGER}");
        }
        
        if (record.getPid() != null) {
            sql.SET("pid = #{record.pid,jdbcType=INTEGER}");
        }
        
        if (record.getLink() != null) {
            sql.SET("link = #{record.link,jdbcType=VARCHAR}");
        }
        
        if (record.getPng() != null) {
            sql.SET("png = #{record.png,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityFee() != null) {
            sql.SET("community_fee = #{record.communityFee,jdbcType=DECIMAL}");
        }
        
        if (record.getPremiumNum() != null) {
            sql.SET("premium_num = #{record.premiumNum,jdbcType=INTEGER}");
        }
        
        if (record.getValidStatus() != null) {
            sql.SET("valid_status = #{record.validStatus,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("community_service_category");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("type = #{record.type,jdbcType=INTEGER}");
        sql.SET("sort = #{record.sort,jdbcType=INTEGER}");
        sql.SET("exposure = #{record.exposure,jdbcType=INTEGER}");
        sql.SET("pid = #{record.pid,jdbcType=INTEGER}");
        sql.SET("link = #{record.link,jdbcType=VARCHAR}");
        sql.SET("png = #{record.png,jdbcType=VARCHAR}");
        sql.SET("community_fee = #{record.communityFee,jdbcType=DECIMAL}");
        sql.SET("premium_num = #{record.premiumNum,jdbcType=INTEGER}");
        sql.SET("valid_status = #{record.validStatus,jdbcType=INTEGER}");
        
        CommunityServiceCategoryExample example = (CommunityServiceCategoryExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CommunityServiceCategory record) {
        SQL sql = new SQL();
        sql.UPDATE("community_service_category");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{sort,jdbcType=INTEGER}");
        }
        
        if (record.getExposure() != null) {
            sql.SET("exposure = #{exposure,jdbcType=INTEGER}");
        }
        
        if (record.getPid() != null) {
            sql.SET("pid = #{pid,jdbcType=INTEGER}");
        }
        
        if (record.getLink() != null) {
            sql.SET("link = #{link,jdbcType=VARCHAR}");
        }
        
        if (record.getPng() != null) {
            sql.SET("png = #{png,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityFee() != null) {
            sql.SET("community_fee = #{communityFee,jdbcType=DECIMAL}");
        }
        
        if (record.getPremiumNum() != null) {
            sql.SET("premium_num = #{premiumNum,jdbcType=INTEGER}");
        }
        
        if (record.getValidStatus() != null) {
            sql.SET("valid_status = #{validStatus,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CommunityServiceCategoryExample example, boolean includeExamplePhrase) {
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