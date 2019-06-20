package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreCoupon;
import com.rfchina.community.persistence.model.OpenStoreCouponExample;
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

public interface OpenStoreCouponMapper extends Serializable {
    @SelectProvider(type=OpenStoreCouponSqlProvider.class, method="countByExample")
    long countByExample(OpenStoreCouponExample example);

    @DeleteProvider(type=OpenStoreCouponSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenStoreCouponExample example);

    @Delete({
        "delete from open_store_coupon",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_store_coupon (service_id, title, ",
        "status, pic, sub_title, ",
        "coupon_no, begin_time, ",
        "end_time, create_time, ",
        "details)",
        "values (#{serviceId,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{pic,jdbcType=VARCHAR}, #{subTitle,jdbcType=VARCHAR}, ",
        "#{couponNo,jdbcType=VARCHAR}, #{beginTime,jdbcType=DATE}, ",
        "#{endTime,jdbcType=DATE}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{details,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenStoreCoupon record);

    @InsertProvider(type=OpenStoreCouponSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenStoreCoupon record);

    @SelectProvider(type=OpenStoreCouponSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_title", property="subTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="coupon_no", property="couponNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="begin_time", property="beginTime", jdbcType=JdbcType.DATE),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="details", property="details", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<OpenStoreCoupon> selectByExampleWithBLOBs(OpenStoreCouponExample example);

    @SelectProvider(type=OpenStoreCouponSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_title", property="subTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="coupon_no", property="couponNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="begin_time", property="beginTime", jdbcType=JdbcType.DATE),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenStoreCoupon> selectByExample(OpenStoreCouponExample example);

    @Select({
        "select",
        "id, service_id, title, status, pic, sub_title, coupon_no, begin_time, end_time, ",
        "create_time, details",
        "from open_store_coupon",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_title", property="subTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="coupon_no", property="couponNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="begin_time", property="beginTime", jdbcType=JdbcType.DATE),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="details", property="details", jdbcType=JdbcType.LONGVARCHAR)
    })
    OpenStoreCoupon selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenStoreCouponSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenStoreCoupon record, @Param("example") OpenStoreCouponExample example);

    @UpdateProvider(type=OpenStoreCouponSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") OpenStoreCoupon record, @Param("example") OpenStoreCouponExample example);

    @UpdateProvider(type=OpenStoreCouponSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenStoreCoupon record, @Param("example") OpenStoreCouponExample example);

    @UpdateProvider(type=OpenStoreCouponSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenStoreCoupon record);

    @Update({
        "update open_store_coupon",
        "set service_id = #{serviceId,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "pic = #{pic,jdbcType=VARCHAR},",
          "sub_title = #{subTitle,jdbcType=VARCHAR},",
          "coupon_no = #{couponNo,jdbcType=VARCHAR},",
          "begin_time = #{beginTime,jdbcType=DATE},",
          "end_time = #{endTime,jdbcType=DATE},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "details = #{details,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(OpenStoreCoupon record);

    @Update({
        "update open_store_coupon",
        "set service_id = #{serviceId,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "pic = #{pic,jdbcType=VARCHAR},",
          "sub_title = #{subTitle,jdbcType=VARCHAR},",
          "coupon_no = #{couponNo,jdbcType=VARCHAR},",
          "begin_time = #{beginTime,jdbcType=DATE},",
          "end_time = #{endTime,jdbcType=DATE},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenStoreCoupon record);
}