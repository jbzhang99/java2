package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.UserInfo;
import com.rfchina.community.persistence.model.UserInfoExample.Criteria;
import com.rfchina.community.persistence.model.UserInfoExample.Criterion;
import com.rfchina.community.persistence.model.UserInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class UserInfoSqlProvider {

    public String countByExample(UserInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("user_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(UserInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("user_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(UserInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user_info");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getPic() != null) {
            sql.VALUES("pic", "#{pic,jdbcType=VARCHAR}");
        }
        
        if (record.getFullname() != null) {
            sql.VALUES("fullname", "#{fullname,jdbcType=VARCHAR}");
        }
        
        if (record.getNickname() != null) {
            sql.VALUES("nickname", "#{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getDeviceId() != null) {
            sql.VALUES("device_id", "#{deviceId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastLoginTime() != null) {
            sql.VALUES("last_login_time", "#{lastLoginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdTime() != null) {
            sql.VALUES("last_upd_time", "#{lastUpdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getCreateIp() != null) {
            sql.VALUES("create_ip", "#{createIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLastLoginIp() != null) {
            sql.VALUES("last_login_ip", "#{lastLoginIp,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getSign() != null) {
            sql.VALUES("sign", "#{sign,jdbcType=VARCHAR}");
        }
        
        if (record.getPush() != null) {
            sql.VALUES("push", "#{push,jdbcType=INTEGER}");
        }
        
        if (record.getModifyName() != null) {
            sql.VALUES("modify_name", "#{modifyName,jdbcType=TINYINT}");
        }
        
        if (record.getRegSrc() != null) {
            sql.VALUES("reg_src", "#{regSrc,jdbcType=TINYINT}");
        }
        
        if (record.getPlatformCreateTime() != null) {
            sql.VALUES("platform_create_time", "#{platformCreateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(UserInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("phone");
        sql.SELECT("pic");
        sql.SELECT("fullname");
        sql.SELECT("nickname");
        sql.SELECT("device_id");
        sql.SELECT("create_time");
        sql.SELECT("last_login_time");
        sql.SELECT("last_upd_time");
        sql.SELECT("status");
        sql.SELECT("create_ip");
        sql.SELECT("last_login_ip");
        sql.SELECT("email");
        sql.SELECT("sign");
        sql.SELECT("push");
        sql.SELECT("modify_name");
        sql.SELECT("reg_src");
        sql.SELECT("platform_create_time");
        sql.FROM("user_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        UserInfo record = (UserInfo) parameter.get("record");
        UserInfoExample example = (UserInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("user_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getPic() != null) {
            sql.SET("pic = #{record.pic,jdbcType=VARCHAR}");
        }
        
        if (record.getFullname() != null) {
            sql.SET("fullname = #{record.fullname,jdbcType=VARCHAR}");
        }
        
        if (record.getNickname() != null) {
            sql.SET("nickname = #{record.nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getDeviceId() != null) {
            sql.SET("device_id = #{record.deviceId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastLoginTime() != null) {
            sql.SET("last_login_time = #{record.lastLoginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdTime() != null) {
            sql.SET("last_upd_time = #{record.lastUpdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=TINYINT}");
        }
        
        if (record.getCreateIp() != null) {
            sql.SET("create_ip = #{record.createIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLastLoginIp() != null) {
            sql.SET("last_login_ip = #{record.lastLoginIp,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getSign() != null) {
            sql.SET("sign = #{record.sign,jdbcType=VARCHAR}");
        }
        
        if (record.getPush() != null) {
            sql.SET("push = #{record.push,jdbcType=INTEGER}");
        }
        
        if (record.getModifyName() != null) {
            sql.SET("modify_name = #{record.modifyName,jdbcType=TINYINT}");
        }
        
        if (record.getRegSrc() != null) {
            sql.SET("reg_src = #{record.regSrc,jdbcType=TINYINT}");
        }
        
        if (record.getPlatformCreateTime() != null) {
            sql.SET("platform_create_time = #{record.platformCreateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("user_info");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        sql.SET("pic = #{record.pic,jdbcType=VARCHAR}");
        sql.SET("fullname = #{record.fullname,jdbcType=VARCHAR}");
        sql.SET("nickname = #{record.nickname,jdbcType=VARCHAR}");
        sql.SET("device_id = #{record.deviceId,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("last_login_time = #{record.lastLoginTime,jdbcType=TIMESTAMP}");
        sql.SET("last_upd_time = #{record.lastUpdTime,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        sql.SET("create_ip = #{record.createIp,jdbcType=VARCHAR}");
        sql.SET("last_login_ip = #{record.lastLoginIp,jdbcType=VARCHAR}");
        sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        sql.SET("sign = #{record.sign,jdbcType=VARCHAR}");
        sql.SET("push = #{record.push,jdbcType=INTEGER}");
        sql.SET("modify_name = #{record.modifyName,jdbcType=TINYINT}");
        sql.SET("reg_src = #{record.regSrc,jdbcType=TINYINT}");
        sql.SET("platform_create_time = #{record.platformCreateTime,jdbcType=TIMESTAMP}");
        
        UserInfoExample example = (UserInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("user_info");
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getPic() != null) {
            sql.SET("pic = #{pic,jdbcType=VARCHAR}");
        }
        
        if (record.getFullname() != null) {
            sql.SET("fullname = #{fullname,jdbcType=VARCHAR}");
        }
        
        if (record.getNickname() != null) {
            sql.SET("nickname = #{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getDeviceId() != null) {
            sql.SET("device_id = #{deviceId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastLoginTime() != null) {
            sql.SET("last_login_time = #{lastLoginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdTime() != null) {
            sql.SET("last_upd_time = #{lastUpdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getCreateIp() != null) {
            sql.SET("create_ip = #{createIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLastLoginIp() != null) {
            sql.SET("last_login_ip = #{lastLoginIp,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getSign() != null) {
            sql.SET("sign = #{sign,jdbcType=VARCHAR}");
        }
        
        if (record.getPush() != null) {
            sql.SET("push = #{push,jdbcType=INTEGER}");
        }
        
        if (record.getModifyName() != null) {
            sql.SET("modify_name = #{modifyName,jdbcType=TINYINT}");
        }
        
        if (record.getRegSrc() != null) {
            sql.SET("reg_src = #{regSrc,jdbcType=TINYINT}");
        }
        
        if (record.getPlatformCreateTime() != null) {
            sql.SET("platform_create_time = #{platformCreateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, UserInfoExample example, boolean includeExamplePhrase) {
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