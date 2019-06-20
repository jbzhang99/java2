package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.PlatformAdmin;
import com.rfchina.community.persistence.model.PlatformAdminExample;
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

public interface PlatformAdminMapper extends Serializable {
    @SelectProvider(type=PlatformAdminSqlProvider.class, method="countByExample")
    long countByExample(PlatformAdminExample example);

    @DeleteProvider(type=PlatformAdminSqlProvider.class, method="deleteByExample")
    int deleteByExample(PlatformAdminExample example);

    @Delete({
        "delete from platform_admin",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into platform_admin (id, realname, ",
        "phone, tel, email, ",
        "address, status, ",
        "intro, dept, latest_login_time, ",
        "create_time, update_time)",
        "values (#{id,jdbcType=BIGINT}, #{realname,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{tel,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{intro,jdbcType=VARCHAR}, #{dept,jdbcType=VARCHAR}, #{latestLoginTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(PlatformAdmin record);

    @InsertProvider(type=PlatformAdminSqlProvider.class, method="insertSelective")
    int insertSelective(PlatformAdmin record);

    @SelectProvider(type=PlatformAdminSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept", property="dept", jdbcType=JdbcType.VARCHAR),
        @Result(column="latest_login_time", property="latestLoginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PlatformAdmin> selectByExample(PlatformAdminExample example);

    @Select({
        "select",
        "id, realname, phone, tel, email, address, status, intro, dept, latest_login_time, ",
        "create_time, update_time",
        "from platform_admin",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept", property="dept", jdbcType=JdbcType.VARCHAR),
        @Result(column="latest_login_time", property="latestLoginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    PlatformAdmin selectByPrimaryKey(Long id);

    @UpdateProvider(type=PlatformAdminSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PlatformAdmin record, @Param("example") PlatformAdminExample example);

    @UpdateProvider(type=PlatformAdminSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PlatformAdmin record, @Param("example") PlatformAdminExample example);

    @UpdateProvider(type=PlatformAdminSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PlatformAdmin record);

    @Update({
        "update platform_admin",
        "set realname = #{realname,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "intro = #{intro,jdbcType=VARCHAR},",
          "dept = #{dept,jdbcType=VARCHAR},",
          "latest_login_time = #{latestLoginTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PlatformAdmin record);
}