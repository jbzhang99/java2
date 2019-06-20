package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.UserInfo;
import com.rfchina.community.persistence.model.UserInfoExample;
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

public interface UserInfoMapper extends Serializable {
    @SelectProvider(type=UserInfoSqlProvider.class, method="countByExample")
    long countByExample(UserInfoExample example);

    @DeleteProvider(type=UserInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserInfoExample example);

    @Delete({
        "delete from user_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into user_info (id, phone, ",
        "pic, fullname, nickname, ",
        "device_id, create_time, ",
        "last_login_time, last_upd_time, ",
        "status, create_ip, ",
        "last_login_ip, email, ",
        "sign, push, modify_name, ",
        "reg_src, platform_create_time)",
        "values (#{id,jdbcType=BIGINT}, #{phone,jdbcType=VARCHAR}, ",
        "#{pic,jdbcType=VARCHAR}, #{fullname,jdbcType=VARCHAR}, #{nickname,jdbcType=VARCHAR}, ",
        "#{deviceId,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{lastLoginTime,jdbcType=TIMESTAMP}, #{lastUpdTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=TINYINT}, #{createIp,jdbcType=VARCHAR}, ",
        "#{lastLoginIp,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{sign,jdbcType=VARCHAR}, #{push,jdbcType=INTEGER}, #{modifyName,jdbcType=TINYINT}, ",
        "#{regSrc,jdbcType=TINYINT}, #{platformCreateTime,jdbcType=TIMESTAMP})"
    })
    int insert(UserInfo record);

    @InsertProvider(type=UserInfoSqlProvider.class, method="insertSelective")
    int insertSelective(UserInfo record);

    @SelectProvider(type=UserInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR),
        @Result(column="fullname", property="fullname", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="device_id", property="deviceId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_login_time", property="lastLoginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_upd_time", property="lastUpdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_ip", property="createIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_login_ip", property="lastLoginIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign", property="sign", jdbcType=JdbcType.VARCHAR),
        @Result(column="push", property="push", jdbcType=JdbcType.INTEGER),
        @Result(column="modify_name", property="modifyName", jdbcType=JdbcType.TINYINT),
        @Result(column="reg_src", property="regSrc", jdbcType=JdbcType.TINYINT),
        @Result(column="platform_create_time", property="platformCreateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserInfo> selectByExample(UserInfoExample example);

    @Select({
        "select",
        "id, phone, pic, fullname, nickname, device_id, create_time, last_login_time, ",
        "last_upd_time, status, create_ip, last_login_ip, email, sign, push, modify_name, ",
        "reg_src, platform_create_time",
        "from user_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR),
        @Result(column="fullname", property="fullname", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="device_id", property="deviceId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_login_time", property="lastLoginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_upd_time", property="lastUpdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_ip", property="createIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_login_ip", property="lastLoginIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign", property="sign", jdbcType=JdbcType.VARCHAR),
        @Result(column="push", property="push", jdbcType=JdbcType.INTEGER),
        @Result(column="modify_name", property="modifyName", jdbcType=JdbcType.TINYINT),
        @Result(column="reg_src", property="regSrc", jdbcType=JdbcType.TINYINT),
        @Result(column="platform_create_time", property="platformCreateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    UserInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserInfo record);

    @Update({
        "update user_info",
        "set phone = #{phone,jdbcType=VARCHAR},",
          "pic = #{pic,jdbcType=VARCHAR},",
          "fullname = #{fullname,jdbcType=VARCHAR},",
          "nickname = #{nickname,jdbcType=VARCHAR},",
          "device_id = #{deviceId,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "last_login_time = #{lastLoginTime,jdbcType=TIMESTAMP},",
          "last_upd_time = #{lastUpdTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT},",
          "create_ip = #{createIp,jdbcType=VARCHAR},",
          "last_login_ip = #{lastLoginIp,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "sign = #{sign,jdbcType=VARCHAR},",
          "push = #{push,jdbcType=INTEGER},",
          "modify_name = #{modifyName,jdbcType=TINYINT},",
          "reg_src = #{regSrc,jdbcType=TINYINT},",
          "platform_create_time = #{platformCreateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserInfo record);
}