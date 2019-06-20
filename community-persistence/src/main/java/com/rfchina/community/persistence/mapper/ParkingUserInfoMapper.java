package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.ParkingUserInfo;
import com.rfchina.community.persistence.model.ParkingUserInfoExample;
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
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface ParkingUserInfoMapper extends Serializable {
    @SelectProvider(type=ParkingUserInfoSqlProvider.class, method="countByExample")
    long countByExample(ParkingUserInfoExample example);

    @DeleteProvider(type=ParkingUserInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(ParkingUserInfoExample example);

    @Delete({
        "delete from parking_user_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into parking_user_info (parking_code, car_plate_no, ",
        "mobile, realname, ",
        "create_time, update_time, ",
        "src_type)",
        "values (#{parkingCode,jdbcType=VARCHAR}, #{carPlateNo,jdbcType=VARCHAR}, ",
        "#{mobile,jdbcType=VARCHAR}, #{realname,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{srcType,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ParkingUserInfo record);

    @InsertProvider(type=ParkingUserInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ParkingUserInfo record);

    @SelectProvider(type=ParkingUserInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parking_code", property="parkingCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_plate_no", property="carPlateNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="src_type", property="srcType", jdbcType=JdbcType.INTEGER)
    })
    List<ParkingUserInfo> selectByExampleWithRowbounds(ParkingUserInfoExample example, RowBounds rowBounds);

    @SelectProvider(type=ParkingUserInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parking_code", property="parkingCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_plate_no", property="carPlateNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="src_type", property="srcType", jdbcType=JdbcType.INTEGER)
    })
    List<ParkingUserInfo> selectByExample(ParkingUserInfoExample example);

    @Select({
        "select",
        "id, parking_code, car_plate_no, mobile, realname, create_time, update_time, ",
        "src_type",
        "from parking_user_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parking_code", property="parkingCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_plate_no", property="carPlateNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="src_type", property="srcType", jdbcType=JdbcType.INTEGER)
    })
    ParkingUserInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=ParkingUserInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ParkingUserInfo record, @Param("example") ParkingUserInfoExample example);

    @UpdateProvider(type=ParkingUserInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ParkingUserInfo record, @Param("example") ParkingUserInfoExample example);

    @UpdateProvider(type=ParkingUserInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ParkingUserInfo record);

    @Update({
        "update parking_user_info",
        "set parking_code = #{parkingCode,jdbcType=VARCHAR},",
          "car_plate_no = #{carPlateNo,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "realname = #{realname,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "src_type = #{srcType,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ParkingUserInfo record);
}