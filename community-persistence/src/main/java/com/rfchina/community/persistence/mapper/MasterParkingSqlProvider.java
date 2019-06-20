package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.MasterParking;
import com.rfchina.community.persistence.model.MasterParkingExample.Criteria;
import com.rfchina.community.persistence.model.MasterParkingExample.Criterion;
import com.rfchina.community.persistence.model.MasterParkingExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class MasterParkingSqlProvider {

    public String countByExample(MasterParkingExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("master_parking");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(MasterParkingExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("master_parking");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(MasterParking record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("master_parking");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getOwnerMasterId() != null) {
            sql.VALUES("owner_master_id", "#{ownerMasterId,jdbcType=BIGINT}");
        }
        
        if (record.getOwnerMasterChildId() != null) {
            sql.VALUES("owner_master_child_id", "#{ownerMasterChildId,jdbcType=BIGINT}");
        }
        
        if (record.getOwnerType() != null) {
            sql.VALUES("owner_type", "#{ownerType,jdbcType=TINYINT}");
        }
        
        if (record.getTenantMasterChildId() != null) {
            sql.VALUES("tenant_master_child_id", "#{tenantMasterChildId,jdbcType=BIGINT}");
        }
        
        if (record.getTenantName() != null) {
            sql.VALUES("tenant_name", "#{tenantName,jdbcType=VARCHAR}");
        }
        
        if (record.getTenantPhone() != null) {
            sql.VALUES("tenant_phone", "#{tenantPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getTenantStartDate() != null) {
            sql.VALUES("tenant_start_date", "#{tenantStartDate,jdbcType=VARCHAR}");
        }
        
        if (record.getTenantEndDate() != null) {
            sql.VALUES("tenant_end_date", "#{tenantEndDate,jdbcType=VARCHAR}");
        }
        
        if (record.getCarPlateNo() != null) {
            sql.VALUES("car_plate_no", "#{carPlateNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCardNo() != null) {
            sql.VALUES("card_no", "#{cardNo,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=TINYINT}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getImportBody() != null) {
            sql.VALUES("import_body", "#{importBody,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(MasterParkingExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("owner_master_id");
        sql.SELECT("owner_master_child_id");
        sql.SELECT("owner_type");
        sql.SELECT("tenant_master_child_id");
        sql.SELECT("tenant_name");
        sql.SELECT("tenant_phone");
        sql.SELECT("tenant_start_date");
        sql.SELECT("tenant_end_date");
        sql.SELECT("car_plate_no");
        sql.SELECT("card_no");
        sql.SELECT("type");
        sql.SELECT("status");
        sql.SELECT("remark");
        sql.SELECT("import_body");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("master_parking");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        MasterParking record = (MasterParking) parameter.get("record");
        MasterParkingExample example = (MasterParkingExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("master_parking");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getOwnerMasterId() != null) {
            sql.SET("owner_master_id = #{record.ownerMasterId,jdbcType=BIGINT}");
        }
        
        if (record.getOwnerMasterChildId() != null) {
            sql.SET("owner_master_child_id = #{record.ownerMasterChildId,jdbcType=BIGINT}");
        }
        
        if (record.getOwnerType() != null) {
            sql.SET("owner_type = #{record.ownerType,jdbcType=TINYINT}");
        }
        
        if (record.getTenantMasterChildId() != null) {
            sql.SET("tenant_master_child_id = #{record.tenantMasterChildId,jdbcType=BIGINT}");
        }
        
        if (record.getTenantName() != null) {
            sql.SET("tenant_name = #{record.tenantName,jdbcType=VARCHAR}");
        }
        
        if (record.getTenantPhone() != null) {
            sql.SET("tenant_phone = #{record.tenantPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getTenantStartDate() != null) {
            sql.SET("tenant_start_date = #{record.tenantStartDate,jdbcType=VARCHAR}");
        }
        
        if (record.getTenantEndDate() != null) {
            sql.SET("tenant_end_date = #{record.tenantEndDate,jdbcType=VARCHAR}");
        }
        
        if (record.getCarPlateNo() != null) {
            sql.SET("car_plate_no = #{record.carPlateNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCardNo() != null) {
            sql.SET("card_no = #{record.cardNo,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=TINYINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=TINYINT}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getImportBody() != null) {
            sql.SET("import_body = #{record.importBody,jdbcType=VARCHAR}");
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
        sql.UPDATE("master_parking");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("owner_master_id = #{record.ownerMasterId,jdbcType=BIGINT}");
        sql.SET("owner_master_child_id = #{record.ownerMasterChildId,jdbcType=BIGINT}");
        sql.SET("owner_type = #{record.ownerType,jdbcType=TINYINT}");
        sql.SET("tenant_master_child_id = #{record.tenantMasterChildId,jdbcType=BIGINT}");
        sql.SET("tenant_name = #{record.tenantName,jdbcType=VARCHAR}");
        sql.SET("tenant_phone = #{record.tenantPhone,jdbcType=VARCHAR}");
        sql.SET("tenant_start_date = #{record.tenantStartDate,jdbcType=VARCHAR}");
        sql.SET("tenant_end_date = #{record.tenantEndDate,jdbcType=VARCHAR}");
        sql.SET("car_plate_no = #{record.carPlateNo,jdbcType=VARCHAR}");
        sql.SET("card_no = #{record.cardNo,jdbcType=VARCHAR}");
        sql.SET("type = #{record.type,jdbcType=TINYINT}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("import_body = #{record.importBody,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        MasterParkingExample example = (MasterParkingExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(MasterParking record) {
        SQL sql = new SQL();
        sql.UPDATE("master_parking");
        
        if (record.getOwnerMasterId() != null) {
            sql.SET("owner_master_id = #{ownerMasterId,jdbcType=BIGINT}");
        }
        
        if (record.getOwnerMasterChildId() != null) {
            sql.SET("owner_master_child_id = #{ownerMasterChildId,jdbcType=BIGINT}");
        }
        
        if (record.getOwnerType() != null) {
            sql.SET("owner_type = #{ownerType,jdbcType=TINYINT}");
        }
        
        if (record.getTenantMasterChildId() != null) {
            sql.SET("tenant_master_child_id = #{tenantMasterChildId,jdbcType=BIGINT}");
        }
        
        if (record.getTenantName() != null) {
            sql.SET("tenant_name = #{tenantName,jdbcType=VARCHAR}");
        }
        
        if (record.getTenantPhone() != null) {
            sql.SET("tenant_phone = #{tenantPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getTenantStartDate() != null) {
            sql.SET("tenant_start_date = #{tenantStartDate,jdbcType=VARCHAR}");
        }
        
        if (record.getTenantEndDate() != null) {
            sql.SET("tenant_end_date = #{tenantEndDate,jdbcType=VARCHAR}");
        }
        
        if (record.getCarPlateNo() != null) {
            sql.SET("car_plate_no = #{carPlateNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCardNo() != null) {
            sql.SET("card_no = #{cardNo,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=TINYINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getImportBody() != null) {
            sql.SET("import_body = #{importBody,jdbcType=VARCHAR}");
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

    protected void applyWhere(SQL sql, MasterParkingExample example, boolean includeExamplePhrase) {
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