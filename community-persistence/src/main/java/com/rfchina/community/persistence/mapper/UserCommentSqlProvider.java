package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.UserComment;
import com.rfchina.community.persistence.model.UserCommentExample.Criteria;
import com.rfchina.community.persistence.model.UserCommentExample.Criterion;
import com.rfchina.community.persistence.model.UserCommentExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class UserCommentSqlProvider {

    public String countByExample(UserCommentExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("user_comment");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(UserCommentExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("user_comment");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(UserComment record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user_comment");
        
        if (record.getCommentTargetType() != null) {
            sql.VALUES("comment_target_type", "#{commentTargetType,jdbcType=VARCHAR}");
        }
        
        if (record.getCommentTarget() != null) {
            sql.VALUES("comment_target", "#{commentTarget,jdbcType=BIGINT}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.VALUES("out_trade_no", "#{outTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPicUrl() != null) {
            sql.VALUES("pic_url", "#{picUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getLogisticsGrade() != null) {
            sql.VALUES("logistics_grade", "#{logisticsGrade,jdbcType=INTEGER}");
        }
        
        if (record.getServiceGrade() != null) {
            sql.VALUES("service_grade", "#{serviceGrade,jdbcType=INTEGER}");
        }
        
        if (record.getGoodsGrade() != null) {
            sql.VALUES("goods_grade", "#{goodsGrade,jdbcType=INTEGER}");
        }
        
        if (record.getCommentator() != null) {
            sql.VALUES("commentator", "#{commentator,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getComment() != null) {
            sql.VALUES("comment", "#{comment,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getReplyStatus() != null) {
            sql.VALUES("reply_status", "#{replyStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(UserCommentExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("comment_target_type");
        sql.SELECT("comment_target");
        sql.SELECT("out_trade_no");
        sql.SELECT("pic_url");
        sql.SELECT("logistics_grade");
        sql.SELECT("service_grade");
        sql.SELECT("goods_grade");
        sql.SELECT("commentator");
        sql.SELECT("create_time");
        sql.SELECT("comment");
        sql.SELECT("status");
        sql.SELECT("reply_status");
        sql.SELECT("user_name");
        sql.FROM("user_comment");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        UserComment record = (UserComment) parameter.get("record");
        UserCommentExample example = (UserCommentExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("user_comment");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCommentTargetType() != null) {
            sql.SET("comment_target_type = #{record.commentTargetType,jdbcType=VARCHAR}");
        }
        
        if (record.getCommentTarget() != null) {
            sql.SET("comment_target = #{record.commentTarget,jdbcType=BIGINT}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.SET("out_trade_no = #{record.outTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPicUrl() != null) {
            sql.SET("pic_url = #{record.picUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getLogisticsGrade() != null) {
            sql.SET("logistics_grade = #{record.logisticsGrade,jdbcType=INTEGER}");
        }
        
        if (record.getServiceGrade() != null) {
            sql.SET("service_grade = #{record.serviceGrade,jdbcType=INTEGER}");
        }
        
        if (record.getGoodsGrade() != null) {
            sql.SET("goods_grade = #{record.goodsGrade,jdbcType=INTEGER}");
        }
        
        if (record.getCommentator() != null) {
            sql.SET("commentator = #{record.commentator,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getComment() != null) {
            sql.SET("comment = #{record.comment,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=VARCHAR}");
        }
        
        if (record.getReplyStatus() != null) {
            sql.SET("reply_status = #{record.replyStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("user_comment");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("comment_target_type = #{record.commentTargetType,jdbcType=VARCHAR}");
        sql.SET("comment_target = #{record.commentTarget,jdbcType=BIGINT}");
        sql.SET("out_trade_no = #{record.outTradeNo,jdbcType=VARCHAR}");
        sql.SET("pic_url = #{record.picUrl,jdbcType=VARCHAR}");
        sql.SET("logistics_grade = #{record.logisticsGrade,jdbcType=INTEGER}");
        sql.SET("service_grade = #{record.serviceGrade,jdbcType=INTEGER}");
        sql.SET("goods_grade = #{record.goodsGrade,jdbcType=INTEGER}");
        sql.SET("commentator = #{record.commentator,jdbcType=BIGINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("comment = #{record.comment,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=VARCHAR}");
        sql.SET("reply_status = #{record.replyStatus,jdbcType=VARCHAR}");
        sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        
        UserCommentExample example = (UserCommentExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserComment record) {
        SQL sql = new SQL();
        sql.UPDATE("user_comment");
        
        if (record.getCommentTargetType() != null) {
            sql.SET("comment_target_type = #{commentTargetType,jdbcType=VARCHAR}");
        }
        
        if (record.getCommentTarget() != null) {
            sql.SET("comment_target = #{commentTarget,jdbcType=BIGINT}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.SET("out_trade_no = #{outTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPicUrl() != null) {
            sql.SET("pic_url = #{picUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getLogisticsGrade() != null) {
            sql.SET("logistics_grade = #{logisticsGrade,jdbcType=INTEGER}");
        }
        
        if (record.getServiceGrade() != null) {
            sql.SET("service_grade = #{serviceGrade,jdbcType=INTEGER}");
        }
        
        if (record.getGoodsGrade() != null) {
            sql.SET("goods_grade = #{goodsGrade,jdbcType=INTEGER}");
        }
        
        if (record.getCommentator() != null) {
            sql.SET("commentator = #{commentator,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getComment() != null) {
            sql.SET("comment = #{comment,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getReplyStatus() != null) {
            sql.SET("reply_status = #{replyStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, UserCommentExample example, boolean includeExamplePhrase) {
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