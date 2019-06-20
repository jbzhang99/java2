package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenFirstPointRecord;
import com.rfchina.community.persistence.model.OpenFirstPointRecordExample;
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

public interface OpenFirstPointRecordMapper extends Serializable {
    @SelectProvider(type=OpenFirstPointRecordSqlProvider.class, method="countByExample")
    long countByExample(OpenFirstPointRecordExample example);

    @DeleteProvider(type=OpenFirstPointRecordSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenFirstPointRecordExample example);

    @Delete({
        "delete from open_first_point_record",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into open_first_point_record (id, uid, ",
        "order_id, serial_number, ",
        "status, create_time)",
        "values (#{id,jdbcType=INTEGER}, #{uid,jdbcType=BIGINT}, ",
        "#{orderId,jdbcType=BIGINT}, #{serialNumber,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(OpenFirstPointRecord record);

    @InsertProvider(type=OpenFirstPointRecordSqlProvider.class, method="insertSelective")
    int insertSelective(OpenFirstPointRecord record);

    @SelectProvider(type=OpenFirstPointRecordSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT),
        @Result(column="serial_number", property="serialNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenFirstPointRecord> selectByExample(OpenFirstPointRecordExample example);

    @Select({
        "select",
        "id, uid, order_id, serial_number, status, create_time",
        "from open_first_point_record",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT),
        @Result(column="serial_number", property="serialNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenFirstPointRecord selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OpenFirstPointRecordSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenFirstPointRecord record, @Param("example") OpenFirstPointRecordExample example);

    @UpdateProvider(type=OpenFirstPointRecordSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenFirstPointRecord record, @Param("example") OpenFirstPointRecordExample example);

    @UpdateProvider(type=OpenFirstPointRecordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenFirstPointRecord record);

    @Update({
        "update open_first_point_record",
        "set uid = #{uid,jdbcType=BIGINT},",
          "order_id = #{orderId,jdbcType=BIGINT},",
          "serial_number = #{serialNumber,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenFirstPointRecord record);
}