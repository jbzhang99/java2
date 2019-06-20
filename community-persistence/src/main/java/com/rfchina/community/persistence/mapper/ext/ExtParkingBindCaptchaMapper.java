package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.ParkingBindCaptchaSqlProvider;
import com.rfchina.community.persistence.model.ParkingBindCaptcha;
import com.rfchina.community.persistence.model.ParkingBindCaptchaExample;
import com.rfchina.community.persistence.model.ParkingBindExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

/**
 */
public interface ExtParkingBindCaptchaMapper {

    @Select(value = {" select * from parking_bind_captcha a ",
            " where a.id = (select max(b.id) from parking_bind_captcha b where b.uid = #{uid,jdbcType=BIGINT} ",
            " and b.type = #{type,jdbcType=INTEGER})"})
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
            @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
            @Result(column="captcha", property="captcha", jdbcType=JdbcType.VARCHAR),
            @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
            @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR),
            @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
            @Result(column="expire_time", property="expireTime", jdbcType=JdbcType.TIMESTAMP)
    })
    ParkingBindCaptcha getLatestParkingBindCaptcha(@Param("uid") Long uid, @Param("type") Integer type);

    @SelectProvider(type=ExtParkingBindCaptchaSqlProvider.class, method="pageByExample")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
            @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
            @Result(column="captcha", property="captcha", jdbcType=JdbcType.VARCHAR),
            @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
            @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR),
            @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
            @Result(column="expire_time", property="expireTime", jdbcType=JdbcType.TIMESTAMP)
    })
    PageList<ParkingBindCaptcha> pageByExample(@Param("example")ParkingBindCaptchaExample example, PageBounds pageBounds);
}
