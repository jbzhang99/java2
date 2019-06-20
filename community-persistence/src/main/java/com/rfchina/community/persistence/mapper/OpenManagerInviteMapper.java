package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenManagerInvite;
import com.rfchina.community.persistence.model.OpenManagerInviteExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface OpenManagerInviteMapper extends BaseMapper<OpenManagerInvite, OpenManagerInviteExample,Long> {
    @SelectProvider(type=OpenManagerInviteSqlProvider.class, method="countByExample")
    long countByExample(OpenManagerInviteExample example);

    @DeleteProvider(type=OpenManagerInviteSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenManagerInviteExample example);

    @Delete({
        "delete from open_manager_invite",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_manager_invite (phone, emp_guid, ",
        "emp_name, uid, merchant_id, ",
        "service_id, status, ",
        "src_business, src_city, ",
        "create_time, update_time)",
        "values (#{phone,jdbcType=VARCHAR}, #{empGuid,jdbcType=VARCHAR}, ",
        "#{empName,jdbcType=VARCHAR}, #{uid,jdbcType=BIGINT}, #{merchantId,jdbcType=BIGINT}, ",
        "#{serviceId,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{srcBusiness,jdbcType=VARCHAR}, #{srcCity,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenManagerInvite record);

    @InsertProvider(type=OpenManagerInviteSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenManagerInvite record);

    @SelectProvider(type=OpenManagerInviteSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="emp_guid", property="empGuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="emp_name", property="empName", jdbcType=JdbcType.VARCHAR),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.BIGINT),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="src_business", property="srcBusiness", jdbcType=JdbcType.VARCHAR),
        @Result(column="src_city", property="srcCity", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenManagerInvite> selectByExample(OpenManagerInviteExample example);

    @Select({
        "select",
        "id, phone, emp_guid, emp_name, uid, merchant_id, service_id, status, src_business, ",
        "src_city, create_time, update_time",
        "from open_manager_invite",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="emp_guid", property="empGuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="emp_name", property="empName", jdbcType=JdbcType.VARCHAR),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.BIGINT),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="src_business", property="srcBusiness", jdbcType=JdbcType.VARCHAR),
        @Result(column="src_city", property="srcCity", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenManagerInvite selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenManagerInviteSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenManagerInvite record, @Param("example") OpenManagerInviteExample example);

    @UpdateProvider(type=OpenManagerInviteSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenManagerInvite record, @Param("example") OpenManagerInviteExample example);

    @UpdateProvider(type=OpenManagerInviteSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenManagerInvite record);

    @Update({
        "update open_manager_invite",
        "set phone = #{phone,jdbcType=VARCHAR},",
          "emp_guid = #{empGuid,jdbcType=VARCHAR},",
          "emp_name = #{empName,jdbcType=VARCHAR},",
          "uid = #{uid,jdbcType=BIGINT},",
          "merchant_id = #{merchantId,jdbcType=BIGINT},",
          "service_id = #{serviceId,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "src_business = #{srcBusiness,jdbcType=VARCHAR},",
          "src_city = #{srcCity,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenManagerInvite record);
}