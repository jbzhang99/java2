package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenDebugUser;
import com.rfchina.community.persistence.model.OpenDebugUserExample;
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

public interface OpenDebugUserMapper extends Serializable {
    @SelectProvider(type=OpenDebugUserSqlProvider.class, method="countByExample")
    long countByExample(OpenDebugUserExample example);

    @DeleteProvider(type=OpenDebugUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenDebugUserExample example);

    @Delete({
        "delete from open_debug_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into open_debug_user (service_id, phone, ",
        "create_time, merchant_id)",
        "values (#{serviceId,jdbcType=INTEGER}, #{phone,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{merchantId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(OpenDebugUser record);

    @InsertProvider(type=OpenDebugUserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(OpenDebugUser record);

    @SelectProvider(type=OpenDebugUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.BIGINT)
    })
    List<OpenDebugUser> selectByExample(OpenDebugUserExample example);

    @Select({
        "select",
        "id, service_id, phone, create_time, merchant_id",
        "from open_debug_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.BIGINT)
    })
    OpenDebugUser selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OpenDebugUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenDebugUser record, @Param("example") OpenDebugUserExample example);

    @UpdateProvider(type=OpenDebugUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenDebugUser record, @Param("example") OpenDebugUserExample example);

    @UpdateProvider(type=OpenDebugUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenDebugUser record);

    @Update({
        "update open_debug_user",
        "set service_id = #{serviceId,jdbcType=INTEGER},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "merchant_id = #{merchantId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenDebugUser record);
}