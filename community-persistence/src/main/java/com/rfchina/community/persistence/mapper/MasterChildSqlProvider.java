package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.MasterChild;
import com.rfchina.community.persistence.model.MasterChildExample.Criteria;
import com.rfchina.community.persistence.model.MasterChildExample.Criterion;
import com.rfchina.community.persistence.model.MasterChildExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class MasterChildSqlProvider {

    public String countByExample(MasterChildExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("master_child");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(MasterChildExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("master_child");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(MasterChild record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("master_child");
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=BIGINT}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getMasterId() != null) {
            sql.VALUES("master_id", "#{masterId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.VALUES("sex", "#{sex,jdbcType=TINYINT}");
        }
        
        if (record.getPic() != null) {
            sql.VALUES("pic", "#{pic,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.VALUES("tel", "#{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getStaffType() != null) {
            sql.VALUES("staff_type", "#{staffType,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getDeptName() != null) {
            sql.VALUES("dept_name", "#{deptName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getComment() != null) {
            sql.VALUES("comment", "#{comment,jdbcType=VARCHAR}");
        }
        
        if (record.getParkingNumber() != null) {
            sql.VALUES("parking_number", "#{parkingNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getPlateNumber() != null) {
            sql.VALUES("plate_number", "#{plateNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getParkingType() != null) {
            sql.VALUES("parking_type", "#{parkingType,jdbcType=INTEGER}");
        }
        
        if (record.getStoreName() != null) {
            sql.VALUES("store_name", "#{storeName,jdbcType=VARCHAR}");
        }
        
        if (record.getStoreNumber() != null) {
            sql.VALUES("store_number", "#{storeNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getStoreType() != null) {
            sql.VALUES("store_type", "#{storeType,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFirstName() != null) {
            sql.VALUES("first_name", "#{firstName,jdbcType=VARCHAR}");
        }
        
        if (record.getFirstPhone() != null) {
            sql.VALUES("first_phone", "#{firstPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(MasterChildExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("community_id");
        sql.SELECT("uid");
        sql.SELECT("phone");
        sql.SELECT("master_id");
        sql.SELECT("name");
        sql.SELECT("sex");
        sql.SELECT("pic");
        sql.SELECT("tel");
        sql.SELECT("type");
        sql.SELECT("staff_type");
        sql.SELECT("status");
        sql.SELECT("dept_name");
        sql.SELECT("create_time");
        sql.SELECT("comment");
        sql.SELECT("parking_number");
        sql.SELECT("plate_number");
        sql.SELECT("parking_type");
        sql.SELECT("store_name");
        sql.SELECT("store_number");
        sql.SELECT("store_type");
        sql.SELECT("update_time");
        sql.SELECT("first_name");
        sql.SELECT("first_phone");
        sql.SELECT("email");
        sql.FROM("master_child");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        MasterChild record = (MasterChild) parameter.get("record");
        MasterChildExample example = (MasterChildExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("master_child");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getMasterId() != null) {
            sql.SET("master_id = #{record.masterId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.SET("sex = #{record.sex,jdbcType=TINYINT}");
        }
        
        if (record.getPic() != null) {
            sql.SET("pic = #{record.pic,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.SET("tel = #{record.tel,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=INTEGER}");
        }
        
        if (record.getStaffType() != null) {
            sql.SET("staff_type = #{record.staffType,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=TINYINT}");
        }
        
        if (record.getDeptName() != null) {
            sql.SET("dept_name = #{record.deptName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getComment() != null) {
            sql.SET("comment = #{record.comment,jdbcType=VARCHAR}");
        }
        
        if (record.getParkingNumber() != null) {
            sql.SET("parking_number = #{record.parkingNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getPlateNumber() != null) {
            sql.SET("plate_number = #{record.plateNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getParkingType() != null) {
            sql.SET("parking_type = #{record.parkingType,jdbcType=INTEGER}");
        }
        
        if (record.getStoreName() != null) {
            sql.SET("store_name = #{record.storeName,jdbcType=VARCHAR}");
        }
        
        if (record.getStoreNumber() != null) {
            sql.SET("store_number = #{record.storeNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getStoreType() != null) {
            sql.SET("store_type = #{record.storeType,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFirstName() != null) {
            sql.SET("first_name = #{record.firstName,jdbcType=VARCHAR}");
        }
        
        if (record.getFirstPhone() != null) {
            sql.SET("first_phone = #{record.firstPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("master_child");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        sql.SET("master_id = #{record.masterId,jdbcType=BIGINT}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("sex = #{record.sex,jdbcType=TINYINT}");
        sql.SET("pic = #{record.pic,jdbcType=VARCHAR}");
        sql.SET("tel = #{record.tel,jdbcType=VARCHAR}");
        sql.SET("type = #{record.type,jdbcType=INTEGER}");
        sql.SET("staff_type = #{record.staffType,jdbcType=INTEGER}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        sql.SET("dept_name = #{record.deptName,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("comment = #{record.comment,jdbcType=VARCHAR}");
        sql.SET("parking_number = #{record.parkingNumber,jdbcType=VARCHAR}");
        sql.SET("plate_number = #{record.plateNumber,jdbcType=VARCHAR}");
        sql.SET("parking_type = #{record.parkingType,jdbcType=INTEGER}");
        sql.SET("store_name = #{record.storeName,jdbcType=VARCHAR}");
        sql.SET("store_number = #{record.storeNumber,jdbcType=VARCHAR}");
        sql.SET("store_type = #{record.storeType,jdbcType=INTEGER}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("first_name = #{record.firstName,jdbcType=VARCHAR}");
        sql.SET("first_phone = #{record.firstPhone,jdbcType=VARCHAR}");
        sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        
        MasterChildExample example = (MasterChildExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(MasterChild record) {
        SQL sql = new SQL();
        sql.UPDATE("master_child");
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=BIGINT}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getMasterId() != null) {
            sql.SET("master_id = #{masterId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.SET("sex = #{sex,jdbcType=TINYINT}");
        }
        
        if (record.getPic() != null) {
            sql.SET("pic = #{pic,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.SET("tel = #{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getStaffType() != null) {
            sql.SET("staff_type = #{staffType,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getDeptName() != null) {
            sql.SET("dept_name = #{deptName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getComment() != null) {
            sql.SET("comment = #{comment,jdbcType=VARCHAR}");
        }
        
        if (record.getParkingNumber() != null) {
            sql.SET("parking_number = #{parkingNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getPlateNumber() != null) {
            sql.SET("plate_number = #{plateNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getParkingType() != null) {
            sql.SET("parking_type = #{parkingType,jdbcType=INTEGER}");
        }
        
        if (record.getStoreName() != null) {
            sql.SET("store_name = #{storeName,jdbcType=VARCHAR}");
        }
        
        if (record.getStoreNumber() != null) {
            sql.SET("store_number = #{storeNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getStoreType() != null) {
            sql.SET("store_type = #{storeType,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFirstName() != null) {
            sql.SET("first_name = #{firstName,jdbcType=VARCHAR}");
        }
        
        if (record.getFirstPhone() != null) {
            sql.SET("first_phone = #{firstPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, MasterChildExample example, boolean includeExamplePhrase) {
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