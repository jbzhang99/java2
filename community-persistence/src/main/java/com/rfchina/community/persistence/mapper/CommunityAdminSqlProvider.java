package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityAdmin;
import com.rfchina.community.persistence.model.CommunityAdminExample.Criteria;
import com.rfchina.community.persistence.model.CommunityAdminExample.Criterion;
import com.rfchina.community.persistence.model.CommunityAdminExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CommunityAdminSqlProvider {

    public String countByExample(CommunityAdminExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("community_admin");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CommunityAdminExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("community_admin");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CommunityAdmin record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("community_admin");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getPassportId() != null) {
            sql.VALUES("passport_id", "#{passportId,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getRealname() != null) {
            sql.VALUES("realname", "#{realname,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.VALUES("tel", "#{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getIntro() != null) {
            sql.VALUES("intro", "#{intro,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getPosition() != null) {
            sql.VALUES("position", "#{position,jdbcType=VARCHAR}");
        }
        
        if (record.getDept() != null) {
            sql.VALUES("dept", "#{dept,jdbcType=VARCHAR}");
        }
        
        if (record.getDeleteFlag() != null) {
            sql.VALUES("delete_flag", "#{deleteFlag,jdbcType=TINYINT}");
        }
        
        if (record.getLatestLoginTime() != null) {
            sql.VALUES("latest_login_time", "#{latestLoginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAgreeProtocol() != null) {
            sql.VALUES("agree_protocol", "#{agreeProtocol,jdbcType=TINYINT}");
        }
        
        if (record.getCommunityIds() != null) {
            sql.VALUES("community_ids", "#{communityIds,jdbcType=VARCHAR}");
        }
        
        if (record.getDefCommunityIds() != null) {
            sql.VALUES("def_community_ids", "#{defCommunityIds,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CommunityAdminExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("passport_id");
        sql.SELECT("community_id");
        sql.SELECT("realname");
        sql.SELECT("phone");
        sql.SELECT("tel");
        sql.SELECT("email");
        sql.SELECT("intro");
        sql.SELECT("status");
        sql.SELECT("position");
        sql.SELECT("dept");
        sql.SELECT("delete_flag");
        sql.SELECT("latest_login_time");
        sql.SELECT("agree_protocol");
        sql.SELECT("community_ids");
        sql.SELECT("def_community_ids");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("community_admin");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CommunityAdmin record = (CommunityAdmin) parameter.get("record");
        CommunityAdminExample example = (CommunityAdminExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("community_admin");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getPassportId() != null) {
            sql.SET("passport_id = #{record.passportId,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getRealname() != null) {
            sql.SET("realname = #{record.realname,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.SET("tel = #{record.tel,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getIntro() != null) {
            sql.SET("intro = #{record.intro,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=TINYINT}");
        }
        
        if (record.getPosition() != null) {
            sql.SET("position = #{record.position,jdbcType=VARCHAR}");
        }
        
        if (record.getDept() != null) {
            sql.SET("dept = #{record.dept,jdbcType=VARCHAR}");
        }
        
        if (record.getDeleteFlag() != null) {
            sql.SET("delete_flag = #{record.deleteFlag,jdbcType=TINYINT}");
        }
        
        if (record.getLatestLoginTime() != null) {
            sql.SET("latest_login_time = #{record.latestLoginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAgreeProtocol() != null) {
            sql.SET("agree_protocol = #{record.agreeProtocol,jdbcType=TINYINT}");
        }
        
        if (record.getCommunityIds() != null) {
            sql.SET("community_ids = #{record.communityIds,jdbcType=VARCHAR}");
        }
        
        if (record.getDefCommunityIds() != null) {
            sql.SET("def_community_ids = #{record.defCommunityIds,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("community_admin");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("passport_id = #{record.passportId,jdbcType=BIGINT}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("realname = #{record.realname,jdbcType=VARCHAR}");
        sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        sql.SET("tel = #{record.tel,jdbcType=VARCHAR}");
        sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        sql.SET("intro = #{record.intro,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        sql.SET("position = #{record.position,jdbcType=VARCHAR}");
        sql.SET("dept = #{record.dept,jdbcType=VARCHAR}");
        sql.SET("delete_flag = #{record.deleteFlag,jdbcType=TINYINT}");
        sql.SET("latest_login_time = #{record.latestLoginTime,jdbcType=TIMESTAMP}");
        sql.SET("agree_protocol = #{record.agreeProtocol,jdbcType=TINYINT}");
        sql.SET("community_ids = #{record.communityIds,jdbcType=VARCHAR}");
        sql.SET("def_community_ids = #{record.defCommunityIds,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        CommunityAdminExample example = (CommunityAdminExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CommunityAdmin record) {
        SQL sql = new SQL();
        sql.UPDATE("community_admin");
        
        if (record.getPassportId() != null) {
            sql.SET("passport_id = #{passportId,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getRealname() != null) {
            sql.SET("realname = #{realname,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.SET("tel = #{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getIntro() != null) {
            sql.SET("intro = #{intro,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getPosition() != null) {
            sql.SET("position = #{position,jdbcType=VARCHAR}");
        }
        
        if (record.getDept() != null) {
            sql.SET("dept = #{dept,jdbcType=VARCHAR}");
        }
        
        if (record.getDeleteFlag() != null) {
            sql.SET("delete_flag = #{deleteFlag,jdbcType=TINYINT}");
        }
        
        if (record.getLatestLoginTime() != null) {
            sql.SET("latest_login_time = #{latestLoginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAgreeProtocol() != null) {
            sql.SET("agree_protocol = #{agreeProtocol,jdbcType=TINYINT}");
        }
        
        if (record.getCommunityIds() != null) {
            sql.SET("community_ids = #{communityIds,jdbcType=VARCHAR}");
        }
        
        if (record.getDefCommunityIds() != null) {
            sql.SET("def_community_ids = #{defCommunityIds,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CommunityAdminExample example, boolean includeExamplePhrase) {
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