package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenPointRecord;
import com.rfchina.community.persistence.model.OpenPointRecordExample;
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

public interface OpenPointRecordMapper extends Serializable {
    @SelectProvider(type=OpenPointRecordSqlProvider.class, method="countByExample")
    long countByExample(OpenPointRecordExample example);

    @DeleteProvider(type=OpenPointRecordSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenPointRecordExample example);

    @Delete({
        "delete from open_point_record",
        "where order_id = #{orderId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long orderId);

    @Insert({
        "insert into open_point_record (order_id, uid, ",
        "total_amount, serial_number, ",
        "status, create_time, ",
        "open_conf_code, open_conf_first_code)",
        "values (#{orderId,jdbcType=BIGINT}, #{uid,jdbcType=BIGINT}, ",
        "#{totalAmount,jdbcType=DECIMAL}, #{serialNumber,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{openConfCode,jdbcType=VARCHAR}, #{openConfFirstCode,jdbcType=VARCHAR})"
    })
    int insert(OpenPointRecord record);

    @InsertProvider(type=OpenPointRecordSqlProvider.class, method="insertSelective")
    int insertSelective(OpenPointRecord record);

    @SelectProvider(type=OpenPointRecordSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="serial_number", property="serialNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="open_conf_code", property="openConfCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_conf_first_code", property="openConfFirstCode", jdbcType=JdbcType.VARCHAR)
    })
    List<OpenPointRecord> selectByExample(OpenPointRecordExample example);

    @Select({
        "select",
        "order_id, uid, total_amount, serial_number, status, create_time, open_conf_code, ",
        "open_conf_first_code",
        "from open_point_record",
        "where order_id = #{orderId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="serial_number", property="serialNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="open_conf_code", property="openConfCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_conf_first_code", property="openConfFirstCode", jdbcType=JdbcType.VARCHAR)
    })
    OpenPointRecord selectByPrimaryKey(Long orderId);

    @UpdateProvider(type=OpenPointRecordSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenPointRecord record, @Param("example") OpenPointRecordExample example);

    @UpdateProvider(type=OpenPointRecordSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenPointRecord record, @Param("example") OpenPointRecordExample example);

    @UpdateProvider(type=OpenPointRecordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenPointRecord record);

    @Update({
        "update open_point_record",
        "set uid = #{uid,jdbcType=BIGINT},",
          "total_amount = #{totalAmount,jdbcType=DECIMAL},",
          "serial_number = #{serialNumber,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "open_conf_code = #{openConfCode,jdbcType=VARCHAR},",
          "open_conf_first_code = #{openConfFirstCode,jdbcType=VARCHAR}",
        "where order_id = #{orderId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenPointRecord record);
}