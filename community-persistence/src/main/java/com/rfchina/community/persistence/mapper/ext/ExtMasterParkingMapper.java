package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.model.MasterParking;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

/**
 */
public interface ExtMasterParkingMapper {

    @Select({
            "select",
            "a.id, a.owner_master_id, a.owner_master_child_id, a.owner_type, a.tenant_master_child_id, ",
            "b.name as tenant_name, b.phone as tenant_phone, a.tenant_start_date, a.tenant_end_date, a.car_plate_no, ",
            "a.card_no, a.type, a.status, a.remark, a.import_body, a.create_time, a.update_time",
            "from master_parking a left join master_child b on a.tenant_master_child_id = b.id ",
            "where a.id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="owner_master_id", property="ownerMasterId", jdbcType=JdbcType.BIGINT),
            @Result(column="owner_master_child_id", property="ownerMasterChildId", jdbcType=JdbcType.BIGINT),
            @Result(column="owner_type", property="ownerType", jdbcType=JdbcType.TINYINT),
            @Result(column="tenant_master_child_id", property="tenantMasterChildId", jdbcType=JdbcType.BIGINT),
            @Result(column="tenant_name", property="tenantName", jdbcType=JdbcType.VARCHAR),
            @Result(column="tenant_phone", property="tenantPhone", jdbcType=JdbcType.VARCHAR),
            @Result(column="tenant_start_date", property="tenantStartDate", jdbcType=JdbcType.VARCHAR),
            @Result(column="tenant_end_date", property="tenantEndDate", jdbcType=JdbcType.VARCHAR),
            @Result(column="car_plate_no", property="carPlateNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="card_no", property="cardNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
            @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
            @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
            @Result(column="import_body", property="importBody", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    MasterParking selectWithMasterChildByPrimaryKey(Long id);
}
