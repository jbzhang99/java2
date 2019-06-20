package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VisitCommunityQrcode;
import com.rfchina.community.persistence.model.VisitCommunityQrcodeExample.Criteria;
import com.rfchina.community.persistence.model.VisitCommunityQrcodeExample.Criterion;
import com.rfchina.community.persistence.model.VisitCommunityQrcodeExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class VisitCommunityQrcodeSqlProvider {

    public String countByExample(VisitCommunityQrcodeExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("visit_community_qrcode");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(VisitCommunityQrcodeExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("visit_community_qrcode");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(VisitCommunityQrcode record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("visit_community_qrcode");
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpTime() != null) {
            sql.VALUES("exp_time", "#{expTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getValidDate() != null) {
            sql.VALUES("valid_date", "#{validDate,jdbcType=DATE}");
        }
        
        if (record.getAdminId() != null) {
            sql.VALUES("admin_id", "#{adminId,jdbcType=BIGINT}");
        }
        
        if (record.getUseInCount() != null) {
            sql.VALUES("use_in_count", "#{useInCount,jdbcType=INTEGER}");
        }
        
        if (record.getUseInTime() != null) {
            sql.VALUES("use_in_time", "#{useInTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUseOutCount() != null) {
            sql.VALUES("use_out_count", "#{useOutCount,jdbcType=INTEGER}");
        }
        
        if (record.getUseOutTime() != null) {
            sql.VALUES("use_out_time", "#{useOutTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateIp() != null) {
            sql.VALUES("create_ip", "#{createIp,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatePhone() != null) {
            sql.VALUES("create_phone", "#{createPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateUid() != null) {
            sql.VALUES("create_uid", "#{createUid,jdbcType=BIGINT}");
        }
        
        if (record.getIsPrint() != null) {
            sql.VALUES("is_print", "#{isPrint,jdbcType=INTEGER}");
        }
        
        if (record.getPrintTime() != null) {
            sql.VALUES("print_time", "#{printTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(VisitCommunityQrcodeExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("community_id");
        sql.SELECT("content");
        sql.SELECT("create_time");
        sql.SELECT("exp_time");
        sql.SELECT("valid_date");
        sql.SELECT("admin_id");
        sql.SELECT("use_in_count");
        sql.SELECT("use_in_time");
        sql.SELECT("use_out_count");
        sql.SELECT("use_out_time");
        sql.SELECT("create_ip");
        sql.SELECT("create_phone");
        sql.SELECT("create_uid");
        sql.SELECT("is_print");
        sql.SELECT("print_time");
        sql.FROM("visit_community_qrcode");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        VisitCommunityQrcode record = (VisitCommunityQrcode) parameter.get("record");
        VisitCommunityQrcodeExample example = (VisitCommunityQrcodeExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("visit_community_qrcode");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{record.content,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpTime() != null) {
            sql.SET("exp_time = #{record.expTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getValidDate() != null) {
            sql.SET("valid_date = #{record.validDate,jdbcType=DATE}");
        }
        
        if (record.getAdminId() != null) {
            sql.SET("admin_id = #{record.adminId,jdbcType=BIGINT}");
        }
        
        if (record.getUseInCount() != null) {
            sql.SET("use_in_count = #{record.useInCount,jdbcType=INTEGER}");
        }
        
        if (record.getUseInTime() != null) {
            sql.SET("use_in_time = #{record.useInTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUseOutCount() != null) {
            sql.SET("use_out_count = #{record.useOutCount,jdbcType=INTEGER}");
        }
        
        if (record.getUseOutTime() != null) {
            sql.SET("use_out_time = #{record.useOutTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateIp() != null) {
            sql.SET("create_ip = #{record.createIp,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatePhone() != null) {
            sql.SET("create_phone = #{record.createPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateUid() != null) {
            sql.SET("create_uid = #{record.createUid,jdbcType=BIGINT}");
        }
        
        if (record.getIsPrint() != null) {
            sql.SET("is_print = #{record.isPrint,jdbcType=INTEGER}");
        }
        
        if (record.getPrintTime() != null) {
            sql.SET("print_time = #{record.printTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("visit_community_qrcode");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("content = #{record.content,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("exp_time = #{record.expTime,jdbcType=TIMESTAMP}");
        sql.SET("valid_date = #{record.validDate,jdbcType=DATE}");
        sql.SET("admin_id = #{record.adminId,jdbcType=BIGINT}");
        sql.SET("use_in_count = #{record.useInCount,jdbcType=INTEGER}");
        sql.SET("use_in_time = #{record.useInTime,jdbcType=TIMESTAMP}");
        sql.SET("use_out_count = #{record.useOutCount,jdbcType=INTEGER}");
        sql.SET("use_out_time = #{record.useOutTime,jdbcType=TIMESTAMP}");
        sql.SET("create_ip = #{record.createIp,jdbcType=VARCHAR}");
        sql.SET("create_phone = #{record.createPhone,jdbcType=VARCHAR}");
        sql.SET("create_uid = #{record.createUid,jdbcType=BIGINT}");
        sql.SET("is_print = #{record.isPrint,jdbcType=INTEGER}");
        sql.SET("print_time = #{record.printTime,jdbcType=TIMESTAMP}");
        
        VisitCommunityQrcodeExample example = (VisitCommunityQrcodeExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(VisitCommunityQrcode record) {
        SQL sql = new SQL();
        sql.UPDATE("visit_community_qrcode");
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpTime() != null) {
            sql.SET("exp_time = #{expTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getValidDate() != null) {
            sql.SET("valid_date = #{validDate,jdbcType=DATE}");
        }
        
        if (record.getAdminId() != null) {
            sql.SET("admin_id = #{adminId,jdbcType=BIGINT}");
        }
        
        if (record.getUseInCount() != null) {
            sql.SET("use_in_count = #{useInCount,jdbcType=INTEGER}");
        }
        
        if (record.getUseInTime() != null) {
            sql.SET("use_in_time = #{useInTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUseOutCount() != null) {
            sql.SET("use_out_count = #{useOutCount,jdbcType=INTEGER}");
        }
        
        if (record.getUseOutTime() != null) {
            sql.SET("use_out_time = #{useOutTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateIp() != null) {
            sql.SET("create_ip = #{createIp,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatePhone() != null) {
            sql.SET("create_phone = #{createPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateUid() != null) {
            sql.SET("create_uid = #{createUid,jdbcType=BIGINT}");
        }
        
        if (record.getIsPrint() != null) {
            sql.SET("is_print = #{isPrint,jdbcType=INTEGER}");
        }
        
        if (record.getPrintTime() != null) {
            sql.SET("print_time = #{printTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, VisitCommunityQrcodeExample example, boolean includeExamplePhrase) {
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