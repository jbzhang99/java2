package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.MasterInfo;
import com.rfchina.community.persistence.model.MasterInfoExample.Criteria;
import com.rfchina.community.persistence.model.MasterInfoExample.Criterion;
import com.rfchina.community.persistence.model.MasterInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class MasterInfoSqlProvider {

    public String countByExample(MasterInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("master_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(MasterInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("master_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(MasterInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("master_info");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getFloor() != null) {
            sql.VALUES("floor", "#{floor,jdbcType=VARCHAR}");
        }
        
        if (record.getRoom() != null) {
            sql.VALUES("room", "#{room,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.VALUES("tel", "#{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getAreaId() != null) {
            sql.VALUES("area_id", "#{areaId,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getChargeName() != null) {
            sql.VALUES("charge_name", "#{chargeName,jdbcType=VARCHAR}");
        }
        
        if (record.getChargePhone() != null) {
            sql.VALUES("charge_phone", "#{chargePhone,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getLoudong() != null) {
            sql.VALUES("loudong", "#{loudong,jdbcType=VARCHAR}");
        }
        
        if (record.getAgreeProtocol() != null) {
            sql.VALUES("agree_protocol", "#{agreeProtocol,jdbcType=INTEGER}");
        }
        
        if (record.getAgreeProtocolTime() != null) {
            sql.VALUES("agree_protocol_time", "#{agreeProtocolTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBuildingId() != null) {
            sql.VALUES("building_id", "#{buildingId,jdbcType=BIGINT}");
        }
        
        if (record.getFloorId() != null) {
            sql.VALUES("floor_id", "#{floorId,jdbcType=BIGINT}");
        }
        
        if (record.getUnitId() != null) {
            sql.VALUES("unit_id", "#{unitId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(MasterInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("community_id");
        sql.SELECT("floor");
        sql.SELECT("room");
        sql.SELECT("title");
        sql.SELECT("address");
        sql.SELECT("tel");
        sql.SELECT("area_id");
        sql.SELECT("status");
        sql.SELECT("charge_name");
        sql.SELECT("charge_phone");
        sql.SELECT("type");
        sql.SELECT("loudong");
        sql.SELECT("agree_protocol");
        sql.SELECT("agree_protocol_time");
        sql.SELECT("building_id");
        sql.SELECT("floor_id");
        sql.SELECT("unit_id");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("master_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        MasterInfo record = (MasterInfo) parameter.get("record");
        MasterInfoExample example = (MasterInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("master_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getFloor() != null) {
            sql.SET("floor = #{record.floor,jdbcType=VARCHAR}");
        }
        
        if (record.getRoom() != null) {
            sql.SET("room = #{record.room,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.SET("tel = #{record.tel,jdbcType=VARCHAR}");
        }
        
        if (record.getAreaId() != null) {
            sql.SET("area_id = #{record.areaId,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=TINYINT}");
        }
        
        if (record.getChargeName() != null) {
            sql.SET("charge_name = #{record.chargeName,jdbcType=VARCHAR}");
        }
        
        if (record.getChargePhone() != null) {
            sql.SET("charge_phone = #{record.chargePhone,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=INTEGER}");
        }
        
        if (record.getLoudong() != null) {
            sql.SET("loudong = #{record.loudong,jdbcType=VARCHAR}");
        }
        
        if (record.getAgreeProtocol() != null) {
            sql.SET("agree_protocol = #{record.agreeProtocol,jdbcType=INTEGER}");
        }
        
        if (record.getAgreeProtocolTime() != null) {
            sql.SET("agree_protocol_time = #{record.agreeProtocolTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBuildingId() != null) {
            sql.SET("building_id = #{record.buildingId,jdbcType=BIGINT}");
        }
        
        if (record.getFloorId() != null) {
            sql.SET("floor_id = #{record.floorId,jdbcType=BIGINT}");
        }
        
        if (record.getUnitId() != null) {
            sql.SET("unit_id = #{record.unitId,jdbcType=BIGINT}");
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
        sql.UPDATE("master_info");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("floor = #{record.floor,jdbcType=VARCHAR}");
        sql.SET("room = #{record.room,jdbcType=VARCHAR}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("tel = #{record.tel,jdbcType=VARCHAR}");
        sql.SET("area_id = #{record.areaId,jdbcType=INTEGER}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        sql.SET("charge_name = #{record.chargeName,jdbcType=VARCHAR}");
        sql.SET("charge_phone = #{record.chargePhone,jdbcType=VARCHAR}");
        sql.SET("type = #{record.type,jdbcType=INTEGER}");
        sql.SET("loudong = #{record.loudong,jdbcType=VARCHAR}");
        sql.SET("agree_protocol = #{record.agreeProtocol,jdbcType=INTEGER}");
        sql.SET("agree_protocol_time = #{record.agreeProtocolTime,jdbcType=TIMESTAMP}");
        sql.SET("building_id = #{record.buildingId,jdbcType=BIGINT}");
        sql.SET("floor_id = #{record.floorId,jdbcType=BIGINT}");
        sql.SET("unit_id = #{record.unitId,jdbcType=BIGINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        MasterInfoExample example = (MasterInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(MasterInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("master_info");
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getFloor() != null) {
            sql.SET("floor = #{floor,jdbcType=VARCHAR}");
        }
        
        if (record.getRoom() != null) {
            sql.SET("room = #{room,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.SET("tel = #{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getAreaId() != null) {
            sql.SET("area_id = #{areaId,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getChargeName() != null) {
            sql.SET("charge_name = #{chargeName,jdbcType=VARCHAR}");
        }
        
        if (record.getChargePhone() != null) {
            sql.SET("charge_phone = #{chargePhone,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getLoudong() != null) {
            sql.SET("loudong = #{loudong,jdbcType=VARCHAR}");
        }
        
        if (record.getAgreeProtocol() != null) {
            sql.SET("agree_protocol = #{agreeProtocol,jdbcType=INTEGER}");
        }
        
        if (record.getAgreeProtocolTime() != null) {
            sql.SET("agree_protocol_time = #{agreeProtocolTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBuildingId() != null) {
            sql.SET("building_id = #{buildingId,jdbcType=BIGINT}");
        }
        
        if (record.getFloorId() != null) {
            sql.SET("floor_id = #{floorId,jdbcType=BIGINT}");
        }
        
        if (record.getUnitId() != null) {
            sql.SET("unit_id = #{unitId,jdbcType=BIGINT}");
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

    protected void applyWhere(SQL sql, MasterInfoExample example, boolean includeExamplePhrase) {
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