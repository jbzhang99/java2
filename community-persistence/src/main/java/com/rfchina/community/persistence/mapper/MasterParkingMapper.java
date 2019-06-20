package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.MasterParking;
import com.rfchina.community.persistence.model.MasterParkingExample;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface MasterParkingMapper extends Serializable {
    @SelectProvider(type=MasterParkingSqlProvider.class, method="countByExample")
    long countByExample(MasterParkingExample example);

    @DeleteProvider(type=MasterParkingSqlProvider.class, method="deleteByExample")
    int deleteByExample(MasterParkingExample example);

    @Delete({
        "delete from master_parking",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into master_parking (id, owner_master_id, ",
        "owner_master_child_id, owner_type, ",
        "tenant_master_child_id, tenant_name, ",
        "tenant_phone, tenant_start_date, ",
        "tenant_end_date, car_plate_no, ",
        "card_no, type, status, ",
        "remark, import_body, ",
        "create_time, update_time)",
        "values (#{id,jdbcType=BIGINT}, #{ownerMasterId,jdbcType=BIGINT}, ",
        "#{ownerMasterChildId,jdbcType=BIGINT}, #{ownerType,jdbcType=TINYINT}, ",
        "#{tenantMasterChildId,jdbcType=BIGINT}, #{tenantName,jdbcType=VARCHAR}, ",
        "#{tenantPhone,jdbcType=VARCHAR}, #{tenantStartDate,jdbcType=VARCHAR}, ",
        "#{tenantEndDate,jdbcType=VARCHAR}, #{carPlateNo,jdbcType=VARCHAR}, ",
        "#{cardNo,jdbcType=VARCHAR}, #{type,jdbcType=TINYINT}, #{status,jdbcType=TINYINT}, ",
        "#{remark,jdbcType=VARCHAR}, #{importBody,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(MasterParking record);

    @InsertProvider(type=MasterParkingSqlProvider.class, method="insertSelective")
    int insertSelective(MasterParking record);

    @SelectProvider(type=MasterParkingSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
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
    List<MasterParking> selectByExample(MasterParkingExample example);

    @Select({
        "select",
        "id, owner_master_id, owner_master_child_id, owner_type, tenant_master_child_id, ",
        "tenant_name, tenant_phone, tenant_start_date, tenant_end_date, car_plate_no, ",
        "card_no, type, status, remark, import_body, create_time, update_time",
        "from master_parking",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
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
    MasterParking selectByPrimaryKey(Long id);

    @UpdateProvider(type=MasterParkingSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MasterParking record, @Param("example") MasterParkingExample example);

    @UpdateProvider(type=MasterParkingSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MasterParking record, @Param("example") MasterParkingExample example);

    @UpdateProvider(type=MasterParkingSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MasterParking record);

    @Update({
        "update master_parking",
        "set owner_master_id = #{ownerMasterId,jdbcType=BIGINT},",
          "owner_master_child_id = #{ownerMasterChildId,jdbcType=BIGINT},",
          "owner_type = #{ownerType,jdbcType=TINYINT},",
          "tenant_master_child_id = #{tenantMasterChildId,jdbcType=BIGINT},",
          "tenant_name = #{tenantName,jdbcType=VARCHAR},",
          "tenant_phone = #{tenantPhone,jdbcType=VARCHAR},",
          "tenant_start_date = #{tenantStartDate,jdbcType=VARCHAR},",
          "tenant_end_date = #{tenantEndDate,jdbcType=VARCHAR},",
          "car_plate_no = #{carPlateNo,jdbcType=VARCHAR},",
          "card_no = #{cardNo,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=TINYINT},",
          "status = #{status,jdbcType=TINYINT},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "import_body = #{importBody,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MasterParking record);
}