package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.ParkingBind;
import com.rfchina.community.persistence.model.ParkingBindExample;
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

public interface ParkingBindMapper extends Serializable {
    @SelectProvider(type=ParkingBindSqlProvider.class, method="countByExample")
    long countByExample(ParkingBindExample example);

    @DeleteProvider(type=ParkingBindSqlProvider.class, method="deleteByExample")
    int deleteByExample(ParkingBindExample example);

    @Delete({
        "delete from parking_bind",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into parking_bind (community_id, car_plate_no, ",
        "card_no, uid, parking_mobile, ",
        "create_time, update_time)",
        "values (#{communityId,jdbcType=INTEGER}, #{carPlateNo,jdbcType=VARCHAR}, ",
        "#{cardNo,jdbcType=VARCHAR}, #{uid,jdbcType=BIGINT}, #{parkingMobile,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ParkingBind record);

    @InsertProvider(type=ParkingBindSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ParkingBind record);

    @SelectProvider(type=ParkingBindSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="car_plate_no", property="carPlateNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_no", property="cardNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="parking_mobile", property="parkingMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ParkingBind> selectByExample(ParkingBindExample example);

    @Select({
        "select",
        "id, community_id, car_plate_no, card_no, uid, parking_mobile, create_time, update_time",
        "from parking_bind",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="car_plate_no", property="carPlateNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_no", property="cardNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="parking_mobile", property="parkingMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    ParkingBind selectByPrimaryKey(Long id);

    @UpdateProvider(type=ParkingBindSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ParkingBind record, @Param("example") ParkingBindExample example);

    @UpdateProvider(type=ParkingBindSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ParkingBind record, @Param("example") ParkingBindExample example);

    @UpdateProvider(type=ParkingBindSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ParkingBind record);

    @Update({
        "update parking_bind",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "car_plate_no = #{carPlateNo,jdbcType=VARCHAR},",
          "card_no = #{cardNo,jdbcType=VARCHAR},",
          "uid = #{uid,jdbcType=BIGINT},",
          "parking_mobile = #{parkingMobile,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ParkingBind record);
}