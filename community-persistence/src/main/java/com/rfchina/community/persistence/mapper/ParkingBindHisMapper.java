package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.ParkingBindHis;
import com.rfchina.community.persistence.model.ParkingBindHisExample;
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

public interface ParkingBindHisMapper extends Serializable {
    @SelectProvider(type=ParkingBindHisSqlProvider.class, method="countByExample")
    long countByExample(ParkingBindHisExample example);

    @DeleteProvider(type=ParkingBindHisSqlProvider.class, method="deleteByExample")
    int deleteByExample(ParkingBindHisExample example);

    @Delete({
        "delete from parking_bind_his",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into parking_bind_his (src_id, community_id, ",
        "car_plate_no, card_no, ",
        "uid, opt_type, parking_mobile, ",
        "create_time, update_time)",
        "values (#{srcId,jdbcType=BIGINT}, #{communityId,jdbcType=INTEGER}, ",
        "#{carPlateNo,jdbcType=VARCHAR}, #{cardNo,jdbcType=VARCHAR}, ",
        "#{uid,jdbcType=BIGINT}, #{optType,jdbcType=INTEGER}, #{parkingMobile,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ParkingBindHis record);

    @InsertProvider(type=ParkingBindHisSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ParkingBindHis record);

    @SelectProvider(type=ParkingBindHisSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="src_id", property="srcId", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="car_plate_no", property="carPlateNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_no", property="cardNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="opt_type", property="optType", jdbcType=JdbcType.INTEGER),
        @Result(column="parking_mobile", property="parkingMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ParkingBindHis> selectByExample(ParkingBindHisExample example);

    @Select({
        "select",
        "id, src_id, community_id, car_plate_no, card_no, uid, opt_type, parking_mobile, ",
        "create_time, update_time",
        "from parking_bind_his",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="src_id", property="srcId", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="car_plate_no", property="carPlateNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_no", property="cardNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="opt_type", property="optType", jdbcType=JdbcType.INTEGER),
        @Result(column="parking_mobile", property="parkingMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    ParkingBindHis selectByPrimaryKey(Long id);

    @UpdateProvider(type=ParkingBindHisSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ParkingBindHis record, @Param("example") ParkingBindHisExample example);

    @UpdateProvider(type=ParkingBindHisSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ParkingBindHis record, @Param("example") ParkingBindHisExample example);

    @UpdateProvider(type=ParkingBindHisSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ParkingBindHis record);

    @Update({
        "update parking_bind_his",
        "set src_id = #{srcId,jdbcType=BIGINT},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "car_plate_no = #{carPlateNo,jdbcType=VARCHAR},",
          "card_no = #{cardNo,jdbcType=VARCHAR},",
          "uid = #{uid,jdbcType=BIGINT},",
          "opt_type = #{optType,jdbcType=INTEGER},",
          "parking_mobile = #{parkingMobile,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ParkingBindHis record);
}