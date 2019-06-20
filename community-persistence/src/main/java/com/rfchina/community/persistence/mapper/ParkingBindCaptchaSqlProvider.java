package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.ParkingBindCaptcha;
import com.rfchina.community.persistence.model.ParkingBindCaptchaExample.Criteria;
import com.rfchina.community.persistence.model.ParkingBindCaptchaExample.Criterion;
import com.rfchina.community.persistence.model.ParkingBindCaptchaExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ParkingBindCaptchaSqlProvider {

    public String countByExample(ParkingBindCaptchaExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("parking_bind_captcha");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ParkingBindCaptchaExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("parking_bind_captcha");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ParkingBindCaptcha record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("parking_bind_captcha");
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=BIGINT}");
        }
        
        if (record.getMobile() != null) {
            sql.VALUES("mobile", "#{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getCaptcha() != null) {
            sql.VALUES("captcha", "#{captcha,jdbcType=VARCHAR}");
        }
        
        if (record.getSalt() != null) {
            sql.VALUES("salt", "#{salt,jdbcType=VARCHAR}");
        }
        
        if (record.getToken() != null) {
            sql.VALUES("token", "#{token,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getExpireTime() != null) {
            sql.VALUES("expire_time", "#{expireTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ParkingBindCaptchaExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("uid");
        sql.SELECT("mobile");
        sql.SELECT("captcha");
        sql.SELECT("salt");
        sql.SELECT("token");
        sql.SELECT("type");
        sql.SELECT("expire_time");
        sql.FROM("parking_bind_captcha");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ParkingBindCaptcha record = (ParkingBindCaptcha) parameter.get("record");
        ParkingBindCaptchaExample example = (ParkingBindCaptchaExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("parking_bind_captcha");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        }
        
        if (record.getMobile() != null) {
            sql.SET("mobile = #{record.mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getCaptcha() != null) {
            sql.SET("captcha = #{record.captcha,jdbcType=VARCHAR}");
        }
        
        if (record.getSalt() != null) {
            sql.SET("salt = #{record.salt,jdbcType=VARCHAR}");
        }
        
        if (record.getToken() != null) {
            sql.SET("token = #{record.token,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=INTEGER}");
        }
        
        if (record.getExpireTime() != null) {
            sql.SET("expire_time = #{record.expireTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("parking_bind_captcha");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        sql.SET("mobile = #{record.mobile,jdbcType=VARCHAR}");
        sql.SET("captcha = #{record.captcha,jdbcType=VARCHAR}");
        sql.SET("salt = #{record.salt,jdbcType=VARCHAR}");
        sql.SET("token = #{record.token,jdbcType=VARCHAR}");
        sql.SET("type = #{record.type,jdbcType=INTEGER}");
        sql.SET("expire_time = #{record.expireTime,jdbcType=TIMESTAMP}");
        
        ParkingBindCaptchaExample example = (ParkingBindCaptchaExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ParkingBindCaptcha record) {
        SQL sql = new SQL();
        sql.UPDATE("parking_bind_captcha");
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=BIGINT}");
        }
        
        if (record.getMobile() != null) {
            sql.SET("mobile = #{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getCaptcha() != null) {
            sql.SET("captcha = #{captcha,jdbcType=VARCHAR}");
        }
        
        if (record.getSalt() != null) {
            sql.SET("salt = #{salt,jdbcType=VARCHAR}");
        }
        
        if (record.getToken() != null) {
            sql.SET("token = #{token,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getExpireTime() != null) {
            sql.SET("expire_time = #{expireTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ParkingBindCaptchaExample example, boolean includeExamplePhrase) {
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