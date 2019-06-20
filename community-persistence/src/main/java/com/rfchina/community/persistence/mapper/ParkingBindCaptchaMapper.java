package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.ParkingBindCaptcha;
import com.rfchina.community.persistence.model.ParkingBindCaptchaExample;
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

public interface ParkingBindCaptchaMapper extends Serializable {
    @SelectProvider(type=ParkingBindCaptchaSqlProvider.class, method="countByExample")
    long countByExample(ParkingBindCaptchaExample example);

    @DeleteProvider(type=ParkingBindCaptchaSqlProvider.class, method="deleteByExample")
    int deleteByExample(ParkingBindCaptchaExample example);

    @Delete({
        "delete from parking_bind_captcha",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into parking_bind_captcha (uid, mobile, ",
        "captcha, salt, token, ",
        "type, expire_time)",
        "values (#{uid,jdbcType=BIGINT}, #{mobile,jdbcType=VARCHAR}, ",
        "#{captcha,jdbcType=VARCHAR}, #{salt,jdbcType=VARCHAR}, #{token,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=INTEGER}, #{expireTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ParkingBindCaptcha record);

    @InsertProvider(type=ParkingBindCaptchaSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ParkingBindCaptcha record);

    @SelectProvider(type=ParkingBindCaptchaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="captcha", property="captcha", jdbcType=JdbcType.VARCHAR),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
        @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="expire_time", property="expireTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ParkingBindCaptcha> selectByExample(ParkingBindCaptchaExample example);

    @Select({
        "select",
        "id, uid, mobile, captcha, salt, token, type, expire_time",
        "from parking_bind_captcha",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="captcha", property="captcha", jdbcType=JdbcType.VARCHAR),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
        @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="expire_time", property="expireTime", jdbcType=JdbcType.TIMESTAMP)
    })
    ParkingBindCaptcha selectByPrimaryKey(Long id);

    @UpdateProvider(type=ParkingBindCaptchaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ParkingBindCaptcha record, @Param("example") ParkingBindCaptchaExample example);

    @UpdateProvider(type=ParkingBindCaptchaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ParkingBindCaptcha record, @Param("example") ParkingBindCaptchaExample example);

    @UpdateProvider(type=ParkingBindCaptchaSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ParkingBindCaptcha record);

    @Update({
        "update parking_bind_captcha",
        "set uid = #{uid,jdbcType=BIGINT},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "captcha = #{captcha,jdbcType=VARCHAR},",
          "salt = #{salt,jdbcType=VARCHAR},",
          "token = #{token,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=INTEGER},",
          "expire_time = #{expireTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ParkingBindCaptcha record);
}