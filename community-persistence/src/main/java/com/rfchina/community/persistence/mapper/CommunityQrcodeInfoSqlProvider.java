package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityQrcodeInfo;
import com.rfchina.community.persistence.model.CommunityQrcodeInfoExample.Criteria;
import com.rfchina.community.persistence.model.CommunityQrcodeInfoExample.Criterion;
import com.rfchina.community.persistence.model.CommunityQrcodeInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CommunityQrcodeInfoSqlProvider {

    public String countByExample(CommunityQrcodeInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("community_qrcode_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CommunityQrcodeInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("community_qrcode_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CommunityQrcodeInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("community_qrcode_info");
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getOtherCommunity() != null) {
            sql.VALUES("other_community", "#{otherCommunity,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getCanCount() != null) {
            sql.VALUES("can_count", "#{canCount,jdbcType=INTEGER}");
        }
        
        if (record.getIdKey() != null) {
            sql.VALUES("id_key", "#{idKey,jdbcType=INTEGER}");
        }
        
        if (record.getPrivateKey() != null) {
            sql.VALUES("private_key", "#{privateKey,jdbcType=VARCHAR}");
        }
        
        if (record.getPublicKey() != null) {
            sql.VALUES("public_key", "#{publicKey,jdbcType=VARCHAR}");
        }
        
        if (record.getSyncTime() != null) {
            sql.VALUES("sync_time", "#{syncTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CommunityQrcodeInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("community_id");
        } else {
            sql.SELECT("community_id");
        }
        sql.SELECT("other_community");
        sql.SELECT("status");
        sql.SELECT("type");
        sql.SELECT("can_count");
        sql.SELECT("id_key");
        sql.SELECT("private_key");
        sql.SELECT("public_key");
        sql.SELECT("sync_time");
        sql.FROM("community_qrcode_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CommunityQrcodeInfo record = (CommunityQrcodeInfo) parameter.get("record");
        CommunityQrcodeInfoExample example = (CommunityQrcodeInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("community_qrcode_info");
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getOtherCommunity() != null) {
            sql.SET("other_community = #{record.otherCommunity,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=INTEGER}");
        }
        
        if (record.getCanCount() != null) {
            sql.SET("can_count = #{record.canCount,jdbcType=INTEGER}");
        }
        
        if (record.getIdKey() != null) {
            sql.SET("id_key = #{record.idKey,jdbcType=INTEGER}");
        }
        
        if (record.getPrivateKey() != null) {
            sql.SET("private_key = #{record.privateKey,jdbcType=VARCHAR}");
        }
        
        if (record.getPublicKey() != null) {
            sql.SET("public_key = #{record.publicKey,jdbcType=VARCHAR}");
        }
        
        if (record.getSyncTime() != null) {
            sql.SET("sync_time = #{record.syncTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("community_qrcode_info");
        
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("other_community = #{record.otherCommunity,jdbcType=INTEGER}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("type = #{record.type,jdbcType=INTEGER}");
        sql.SET("can_count = #{record.canCount,jdbcType=INTEGER}");
        sql.SET("id_key = #{record.idKey,jdbcType=INTEGER}");
        sql.SET("private_key = #{record.privateKey,jdbcType=VARCHAR}");
        sql.SET("public_key = #{record.publicKey,jdbcType=VARCHAR}");
        sql.SET("sync_time = #{record.syncTime,jdbcType=TIMESTAMP}");
        
        CommunityQrcodeInfoExample example = (CommunityQrcodeInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CommunityQrcodeInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("community_qrcode_info");
        
        if (record.getOtherCommunity() != null) {
            sql.SET("other_community = #{otherCommunity,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getCanCount() != null) {
            sql.SET("can_count = #{canCount,jdbcType=INTEGER}");
        }
        
        if (record.getIdKey() != null) {
            sql.SET("id_key = #{idKey,jdbcType=INTEGER}");
        }
        
        if (record.getPrivateKey() != null) {
            sql.SET("private_key = #{privateKey,jdbcType=VARCHAR}");
        }
        
        if (record.getPublicKey() != null) {
            sql.SET("public_key = #{publicKey,jdbcType=VARCHAR}");
        }
        
        if (record.getSyncTime() != null) {
            sql.SET("sync_time = #{syncTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("community_id = #{communityId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CommunityQrcodeInfoExample example, boolean includeExamplePhrase) {
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