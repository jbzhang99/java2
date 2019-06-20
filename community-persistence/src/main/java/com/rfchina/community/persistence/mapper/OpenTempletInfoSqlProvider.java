package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenTempletInfo;
import com.rfchina.community.persistence.model.OpenTempletInfoExample.Criteria;
import com.rfchina.community.persistence.model.OpenTempletInfoExample.Criterion;
import com.rfchina.community.persistence.model.OpenTempletInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenTempletInfoSqlProvider {

    public String countByExample(OpenTempletInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_templet_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenTempletInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_templet_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenTempletInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_templet_info");
        
        if (record.getTempleteName() != null) {
            sql.VALUES("templete_name", "#{templeteName,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderby() != null) {
            sql.VALUES("orderby", "#{orderby,jdbcType=INTEGER}");
        }
        
        if (record.getRemarks() != null) {
            sql.VALUES("remarks", "#{remarks,jdbcType=VARCHAR}");
        }
        
        if (record.getInstallBank() != null) {
            sql.VALUES("install_bank", "#{installBank,jdbcType=CHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getPic() != null) {
            sql.VALUES("pic", "#{pic,jdbcType=VARCHAR}");
        }
        
        if (record.getQrcodPic() != null) {
            sql.VALUES("qrcod_pic", "#{qrcodPic,jdbcType=VARCHAR}");
        }
        
        if (record.getTags() != null) {
            sql.VALUES("tags", "#{tags,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenTempletInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("templete_name");
        } else {
            sql.SELECT("templete_name");
        }
        sql.SELECT("title");
        sql.SELECT("orderby");
        sql.SELECT("remarks");
        sql.SELECT("install_bank");
        sql.SELECT("status");
        sql.SELECT("pic");
        sql.SELECT("qrcod_pic");
        sql.SELECT("tags");
        sql.FROM("open_templet_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenTempletInfo record = (OpenTempletInfo) parameter.get("record");
        OpenTempletInfoExample example = (OpenTempletInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_templet_info");
        
        if (record.getTempleteName() != null) {
            sql.SET("templete_name = #{record.templeteName,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderby() != null) {
            sql.SET("orderby = #{record.orderby,jdbcType=INTEGER}");
        }
        
        if (record.getRemarks() != null) {
            sql.SET("remarks = #{record.remarks,jdbcType=VARCHAR}");
        }
        
        if (record.getInstallBank() != null) {
            sql.SET("install_bank = #{record.installBank,jdbcType=CHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getPic() != null) {
            sql.SET("pic = #{record.pic,jdbcType=VARCHAR}");
        }
        
        if (record.getQrcodPic() != null) {
            sql.SET("qrcod_pic = #{record.qrcodPic,jdbcType=VARCHAR}");
        }
        
        if (record.getTags() != null) {
            sql.SET("tags = #{record.tags,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_templet_info");
        
        sql.SET("templete_name = #{record.templeteName,jdbcType=VARCHAR}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("orderby = #{record.orderby,jdbcType=INTEGER}");
        sql.SET("remarks = #{record.remarks,jdbcType=VARCHAR}");
        sql.SET("install_bank = #{record.installBank,jdbcType=CHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("pic = #{record.pic,jdbcType=VARCHAR}");
        sql.SET("qrcod_pic = #{record.qrcodPic,jdbcType=VARCHAR}");
        sql.SET("tags = #{record.tags,jdbcType=VARCHAR}");
        
        OpenTempletInfoExample example = (OpenTempletInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenTempletInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("open_templet_info");
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderby() != null) {
            sql.SET("orderby = #{orderby,jdbcType=INTEGER}");
        }
        
        if (record.getRemarks() != null) {
            sql.SET("remarks = #{remarks,jdbcType=VARCHAR}");
        }
        
        if (record.getInstallBank() != null) {
            sql.SET("install_bank = #{installBank,jdbcType=CHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getPic() != null) {
            sql.SET("pic = #{pic,jdbcType=VARCHAR}");
        }
        
        if (record.getQrcodPic() != null) {
            sql.SET("qrcod_pic = #{qrcodPic,jdbcType=VARCHAR}");
        }
        
        if (record.getTags() != null) {
            sql.SET("tags = #{tags,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("templete_name = #{templeteName,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenTempletInfoExample example, boolean includeExamplePhrase) {
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