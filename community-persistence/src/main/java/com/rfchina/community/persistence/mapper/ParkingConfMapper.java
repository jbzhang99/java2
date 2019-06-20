package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.ParkingConf;
import com.rfchina.community.persistence.model.ParkingConfExample;
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

public interface ParkingConfMapper extends Serializable {
    @SelectProvider(type=ParkingConfSqlProvider.class, method="countByExample")
    long countByExample(ParkingConfExample example);

    @DeleteProvider(type=ParkingConfSqlProvider.class, method="deleteByExample")
    int deleteByExample(ParkingConfExample example);

    @Delete({
        "delete from parking_conf",
        "where community_id = #{communityId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer communityId);

    @Insert({
        "insert into parking_conf (community_id, parking_code, ",
        "vendor, account, ",
        "password, iface_url, ",
        "price_img_url, create_time, ",
        "update_time)",
        "values (#{communityId,jdbcType=INTEGER}, #{parkingCode,jdbcType=VARCHAR}, ",
        "#{vendor,jdbcType=VARCHAR}, #{account,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{ifaceUrl,jdbcType=VARCHAR}, ",
        "#{priceImgUrl,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(ParkingConf record);

    @InsertProvider(type=ParkingConfSqlProvider.class, method="insertSelective")
    int insertSelective(ParkingConf record);

    @SelectProvider(type=ParkingConfSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="parking_code", property="parkingCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="vendor", property="vendor", jdbcType=JdbcType.VARCHAR),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="iface_url", property="ifaceUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="price_img_url", property="priceImgUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ParkingConf> selectByExample(ParkingConfExample example);

    @Select({
        "select",
        "community_id, parking_code, vendor, account, password, iface_url, price_img_url, ",
        "create_time, update_time",
        "from parking_conf",
        "where community_id = #{communityId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="parking_code", property="parkingCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="vendor", property="vendor", jdbcType=JdbcType.VARCHAR),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="iface_url", property="ifaceUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="price_img_url", property="priceImgUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    ParkingConf selectByPrimaryKey(Integer communityId);

    @UpdateProvider(type=ParkingConfSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ParkingConf record, @Param("example") ParkingConfExample example);

    @UpdateProvider(type=ParkingConfSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ParkingConf record, @Param("example") ParkingConfExample example);

    @UpdateProvider(type=ParkingConfSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ParkingConf record);

    @Update({
        "update parking_conf",
        "set parking_code = #{parkingCode,jdbcType=VARCHAR},",
          "vendor = #{vendor,jdbcType=VARCHAR},",
          "account = #{account,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "iface_url = #{ifaceUrl,jdbcType=VARCHAR},",
          "price_img_url = #{priceImgUrl,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where community_id = #{communityId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ParkingConf record);
}