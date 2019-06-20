package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.AddressManage;
import com.rfchina.community.persistence.model.AddressManageExample;
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
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AddressManageMapper extends Serializable {
    @SelectProvider(type=AddressManageSqlProvider.class, method="countByExample")
    long countByExample(AddressManageExample example);

    @DeleteProvider(type=AddressManageSqlProvider.class, method="deleteByExample")
    int deleteByExample(AddressManageExample example);

    @Delete({
        "delete from address_manage",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into address_manage (uid, province_id, ",
        "city_id, area_id, ",
        "merger_name, addr_detail, ",
        "user_name, phone, ",
        "default_status, create_time, ",
        "update_time)",
        "values (#{uid,jdbcType=BIGINT}, #{provinceId,jdbcType=INTEGER}, ",
        "#{cityId,jdbcType=INTEGER}, #{areaId,jdbcType=INTEGER}, ",
        "#{mergerName,jdbcType=VARCHAR}, #{addrDetail,jdbcType=VARCHAR}, ",
        "#{userName,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, ",
        "#{defaultStatus,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(AddressManage record);

    @InsertProvider(type=AddressManageSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(AddressManage record);

    @SelectProvider(type=AddressManageSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="province_id", property="provinceId", jdbcType=JdbcType.INTEGER),
        @Result(column="city_id", property="cityId", jdbcType=JdbcType.INTEGER),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="merger_name", property="mergerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="addr_detail", property="addrDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="default_status", property="defaultStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AddressManage> selectByExample(AddressManageExample example);

    @Select({
        "select",
        "id, uid, province_id, city_id, area_id, merger_name, addr_detail, user_name, ",
        "phone, default_status, create_time, update_time",
        "from address_manage",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="province_id", property="provinceId", jdbcType=JdbcType.INTEGER),
        @Result(column="city_id", property="cityId", jdbcType=JdbcType.INTEGER),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="merger_name", property="mergerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="addr_detail", property="addrDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="default_status", property="defaultStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    AddressManage selectByPrimaryKey(Long id);

    @UpdateProvider(type=AddressManageSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AddressManage record, @Param("example") AddressManageExample example);

    @UpdateProvider(type=AddressManageSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AddressManage record, @Param("example") AddressManageExample example);

    @UpdateProvider(type=AddressManageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AddressManage record);

    @Update({
        "update address_manage",
        "set uid = #{uid,jdbcType=BIGINT},",
          "province_id = #{provinceId,jdbcType=INTEGER},",
          "city_id = #{cityId,jdbcType=INTEGER},",
          "area_id = #{areaId,jdbcType=INTEGER},",
          "merger_name = #{mergerName,jdbcType=VARCHAR},",
          "addr_detail = #{addrDetail,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "default_status = #{defaultStatus,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AddressManage record);
}