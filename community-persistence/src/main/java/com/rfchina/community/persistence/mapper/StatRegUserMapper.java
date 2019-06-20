package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.StatRegUser;
import com.rfchina.community.persistence.model.StatRegUserExample;
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

public interface StatRegUserMapper extends Serializable {
    @SelectProvider(type=StatRegUserSqlProvider.class, method="countByExample")
    long countByExample(StatRegUserExample example);

    @DeleteProvider(type=StatRegUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(StatRegUserExample example);

    @Delete({
        "delete from stat_reg_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into stat_reg_user (stat_time, acc_count, ",
        "app_count, other_count, ",
        "create_time)",
        "values (#{statTime,jdbcType=TIMESTAMP}, #{accCount,jdbcType=INTEGER}, ",
        "#{appCount,jdbcType=INTEGER}, #{otherCount,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(StatRegUser record);

    @InsertProvider(type=StatRegUserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(StatRegUser record);

    @SelectProvider(type=StatRegUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="stat_time", property="statTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="acc_count", property="accCount", jdbcType=JdbcType.INTEGER),
        @Result(column="app_count", property="appCount", jdbcType=JdbcType.INTEGER),
        @Result(column="other_count", property="otherCount", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<StatRegUser> selectByExample(StatRegUserExample example);

    @Select({
        "select",
        "id, stat_time, acc_count, app_count, other_count, create_time",
        "from stat_reg_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="stat_time", property="statTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="acc_count", property="accCount", jdbcType=JdbcType.INTEGER),
        @Result(column="app_count", property="appCount", jdbcType=JdbcType.INTEGER),
        @Result(column="other_count", property="otherCount", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    StatRegUser selectByPrimaryKey(Long id);

    @UpdateProvider(type=StatRegUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StatRegUser record, @Param("example") StatRegUserExample example);

    @UpdateProvider(type=StatRegUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StatRegUser record, @Param("example") StatRegUserExample example);

    @UpdateProvider(type=StatRegUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StatRegUser record);

    @Update({
        "update stat_reg_user",
        "set stat_time = #{statTime,jdbcType=TIMESTAMP},",
          "acc_count = #{accCount,jdbcType=INTEGER},",
          "app_count = #{appCount,jdbcType=INTEGER},",
          "other_count = #{otherCount,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(StatRegUser record);
}