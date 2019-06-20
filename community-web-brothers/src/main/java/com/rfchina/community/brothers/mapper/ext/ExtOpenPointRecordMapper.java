package com.rfchina.community.brothers.mapper.ext;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.rfchina.community.persistence.model.OpenPointRecord;

/**
 */
public interface ExtOpenPointRecordMapper {

    @SelectProvider(type=ExtOpenPointRecordSqlProvider.class, method="increasePointList")
    @Results({
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER),
        @Result(column="serial_number", property="serialNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="open_conf_code", property="openConfCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_conf_first_code", property="openConfFirstCode", jdbcType=JdbcType.VARCHAR)
    })
    List<OpenPointRecord> increasePointList(@Param("lIMIT_MONEY") BigDecimal lIMIT_MONEY);
    
    @SelectProvider(type=ExtOpenPointRecordSqlProvider.class, method="decreasePointList")
    @Results({
    	@Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER, id=true),
    	@Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER),
    	@Result(column="serial_number", property="serialNumber", jdbcType=JdbcType.VARCHAR),
    	@Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
    	@Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
    	@Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
    	@Result(column="open_conf_code", property="openConfCode", jdbcType=JdbcType.VARCHAR),
    	@Result(column="open_conf_first_code", property="openConfFirstCode", jdbcType=JdbcType.VARCHAR)
    })
    List<OpenPointRecord> decreasePointList();

}
