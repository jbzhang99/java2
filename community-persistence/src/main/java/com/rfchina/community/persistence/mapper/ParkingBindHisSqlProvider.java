package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.ParkingBindHis;
import com.rfchina.community.persistence.model.ParkingBindHisExample.Criteria;
import com.rfchina.community.persistence.model.ParkingBindHisExample.Criterion;
import com.rfchina.community.persistence.model.ParkingBindHisExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ParkingBindHisSqlProvider {

    public String countByExample(ParkingBindHisExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("parking_bind_his");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ParkingBindHisExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("parking_bind_his");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ParkingBindHis record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("parking_bind_his");
        
        if (record.getSrcId() != null) {
            sql.VALUES("src_id", "#{srcId,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getCarPlateNo() != null) {
            sql.VALUES("car_plate_no", "#{carPlateNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCardNo() != null) {
            sql.VALUES("card_no", "#{cardNo,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=BIGINT}");
        }
        
        if (record.getOptType() != null) {
            sql.VALUES("opt_type", "#{optType,jdbcType=INTEGER}");
        }
        
        if (record.getParkingMobile() != null) {
            sql.VALUES("parking_mobile", "#{parkingMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ParkingBindHisExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("src_id");
        sql.SELECT("community_id");
        sql.SELECT("car_plate_no");
        sql.SELECT("card_no");
        sql.SELECT("uid");
        sql.SELECT("opt_type");
        sql.SELECT("parking_mobile");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("parking_bind_his");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ParkingBindHis record = (ParkingBindHis) parameter.get("record");
        ParkingBindHisExample example = (ParkingBindHisExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("parking_bind_his");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getSrcId() != null) {
            sql.SET("src_id = #{record.srcId,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getCarPlateNo() != null) {
            sql.SET("car_plate_no = #{record.carPlateNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCardNo() != null) {
            sql.SET("card_no = #{record.cardNo,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        }
        
        if (record.getOptType() != null) {
            sql.SET("opt_type = #{record.optType,jdbcType=INTEGER}");
        }
        
        if (record.getParkingMobile() != null) {
            sql.SET("parking_mobile = #{record.parkingMobile,jdbcType=VARCHAR}");
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
        sql.UPDATE("parking_bind_his");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("src_id = #{record.srcId,jdbcType=BIGINT}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("car_plate_no = #{record.carPlateNo,jdbcType=VARCHAR}");
        sql.SET("card_no = #{record.cardNo,jdbcType=VARCHAR}");
        sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        sql.SET("opt_type = #{record.optType,jdbcType=INTEGER}");
        sql.SET("parking_mobile = #{record.parkingMobile,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        ParkingBindHisExample example = (ParkingBindHisExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ParkingBindHis record) {
        SQL sql = new SQL();
        sql.UPDATE("parking_bind_his");
        
        if (record.getSrcId() != null) {
            sql.SET("src_id = #{srcId,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getCarPlateNo() != null) {
            sql.SET("car_plate_no = #{carPlateNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCardNo() != null) {
            sql.SET("card_no = #{cardNo,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=BIGINT}");
        }
        
        if (record.getOptType() != null) {
            sql.SET("opt_type = #{optType,jdbcType=INTEGER}");
        }
        
        if (record.getParkingMobile() != null) {
            sql.SET("parking_mobile = #{parkingMobile,jdbcType=VARCHAR}");
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

    protected void applyWhere(SQL sql, ParkingBindHisExample example, boolean includeExamplePhrase) {
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