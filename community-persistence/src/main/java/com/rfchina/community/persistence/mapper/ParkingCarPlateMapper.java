package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.ParkingCarPlate;
import com.rfchina.community.persistence.model.ParkingCarPlateExample;
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

public interface ParkingCarPlateMapper extends Serializable {
    @SelectProvider(type=ParkingCarPlateSqlProvider.class, method="countByExample")
    long countByExample(ParkingCarPlateExample example);

    @DeleteProvider(type=ParkingCarPlateSqlProvider.class, method="deleteByExample")
    int deleteByExample(ParkingCarPlateExample example);

    @Delete({
        "delete from parking_car_plate",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into parking_car_plate (name)",
        "values (#{name,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(ParkingCarPlate record);

    @InsertProvider(type=ParkingCarPlateSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(ParkingCarPlate record);

    @SelectProvider(type=ParkingCarPlateSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<ParkingCarPlate> selectByExample(ParkingCarPlateExample example);

    @Select({
        "select",
        "id, name",
        "from parking_car_plate",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    ParkingCarPlate selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ParkingCarPlateSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ParkingCarPlate record, @Param("example") ParkingCarPlateExample example);

    @UpdateProvider(type=ParkingCarPlateSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ParkingCarPlate record, @Param("example") ParkingCarPlateExample example);

    @UpdateProvider(type=ParkingCarPlateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ParkingCarPlate record);

    @Update({
        "update parking_car_plate",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ParkingCarPlate record);
}