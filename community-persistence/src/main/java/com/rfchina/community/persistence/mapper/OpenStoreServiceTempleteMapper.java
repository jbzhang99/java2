package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreServiceTemplete;
import com.rfchina.community.persistence.model.OpenStoreServiceTempleteExample;
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

public interface OpenStoreServiceTempleteMapper extends Serializable {
    @SelectProvider(type=OpenStoreServiceTempleteSqlProvider.class, method="countByExample")
    long countByExample(OpenStoreServiceTempleteExample example);

    @DeleteProvider(type=OpenStoreServiceTempleteSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenStoreServiceTempleteExample example);

    @Delete({
        "delete from open_store_service_templete",
        "where service_id = #{serviceId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer serviceId);

    @Insert({
        "insert into open_store_service_templete (service_id, express_money, ",
        "flagship, phone, ",
        "banner_url, create_time, ",
        "address_province, address_city, ",
        "address_area, address_info, ",
        "store_pic, address_all_info, ",
        "open_time, close_time, ",
        "premium_num, scan_status, ",
        "quick_pay)",
        "values (#{serviceId,jdbcType=INTEGER}, #{expressMoney,jdbcType=DECIMAL}, ",
        "#{flagship,jdbcType=INTEGER}, #{phone,jdbcType=VARCHAR}, ",
        "#{bannerUrl,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{addressProvince,jdbcType=INTEGER}, #{addressCity,jdbcType=INTEGER}, ",
        "#{addressArea,jdbcType=INTEGER}, #{addressInfo,jdbcType=VARCHAR}, ",
        "#{storePic,jdbcType=VARCHAR}, #{addressAllInfo,jdbcType=VARCHAR}, ",
        "#{openTime,jdbcType=VARCHAR}, #{closeTime,jdbcType=VARCHAR}, ",
        "#{premiumNum,jdbcType=INTEGER}, #{scanStatus,jdbcType=INTEGER}, ",
        "#{quickPay,jdbcType=INTEGER})"
    })
    int insert(OpenStoreServiceTemplete record);

    @InsertProvider(type=OpenStoreServiceTempleteSqlProvider.class, method="insertSelective")
    int insertSelective(OpenStoreServiceTemplete record);

    @SelectProvider(type=OpenStoreServiceTempleteSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="express_money", property="expressMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="flagship", property="flagship", jdbcType=JdbcType.INTEGER),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="banner_url", property="bannerUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="address_province", property="addressProvince", jdbcType=JdbcType.INTEGER),
        @Result(column="address_city", property="addressCity", jdbcType=JdbcType.INTEGER),
        @Result(column="address_area", property="addressArea", jdbcType=JdbcType.INTEGER),
        @Result(column="address_info", property="addressInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="store_pic", property="storePic", jdbcType=JdbcType.VARCHAR),
        @Result(column="address_all_info", property="addressAllInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_time", property="openTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="close_time", property="closeTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="premium_num", property="premiumNum", jdbcType=JdbcType.INTEGER),
        @Result(column="scan_status", property="scanStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="quick_pay", property="quickPay", jdbcType=JdbcType.INTEGER)
    })
    List<OpenStoreServiceTemplete> selectByExample(OpenStoreServiceTempleteExample example);

    @Select({
        "select",
        "service_id, express_money, flagship, phone, banner_url, create_time, address_province, ",
        "address_city, address_area, address_info, store_pic, address_all_info, open_time, ",
        "close_time, premium_num, scan_status, quick_pay",
        "from open_store_service_templete",
        "where service_id = #{serviceId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="express_money", property="expressMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="flagship", property="flagship", jdbcType=JdbcType.INTEGER),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="banner_url", property="bannerUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="address_province", property="addressProvince", jdbcType=JdbcType.INTEGER),
        @Result(column="address_city", property="addressCity", jdbcType=JdbcType.INTEGER),
        @Result(column="address_area", property="addressArea", jdbcType=JdbcType.INTEGER),
        @Result(column="address_info", property="addressInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="store_pic", property="storePic", jdbcType=JdbcType.VARCHAR),
        @Result(column="address_all_info", property="addressAllInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_time", property="openTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="close_time", property="closeTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="premium_num", property="premiumNum", jdbcType=JdbcType.INTEGER),
        @Result(column="scan_status", property="scanStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="quick_pay", property="quickPay", jdbcType=JdbcType.INTEGER)
    })
    OpenStoreServiceTemplete selectByPrimaryKey(Integer serviceId);

    @UpdateProvider(type=OpenStoreServiceTempleteSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenStoreServiceTemplete record, @Param("example") OpenStoreServiceTempleteExample example);

    @UpdateProvider(type=OpenStoreServiceTempleteSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenStoreServiceTemplete record, @Param("example") OpenStoreServiceTempleteExample example);

    @UpdateProvider(type=OpenStoreServiceTempleteSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenStoreServiceTemplete record);

    @Update({
        "update open_store_service_templete",
        "set express_money = #{expressMoney,jdbcType=DECIMAL},",
          "flagship = #{flagship,jdbcType=INTEGER},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "banner_url = #{bannerUrl,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "address_province = #{addressProvince,jdbcType=INTEGER},",
          "address_city = #{addressCity,jdbcType=INTEGER},",
          "address_area = #{addressArea,jdbcType=INTEGER},",
          "address_info = #{addressInfo,jdbcType=VARCHAR},",
          "store_pic = #{storePic,jdbcType=VARCHAR},",
          "address_all_info = #{addressAllInfo,jdbcType=VARCHAR},",
          "open_time = #{openTime,jdbcType=VARCHAR},",
          "close_time = #{closeTime,jdbcType=VARCHAR},",
          "premium_num = #{premiumNum,jdbcType=INTEGER},",
          "scan_status = #{scanStatus,jdbcType=INTEGER},",
          "quick_pay = #{quickPay,jdbcType=INTEGER}",
        "where service_id = #{serviceId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenStoreServiceTemplete record);
}