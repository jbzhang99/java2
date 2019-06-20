package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.RepairRecordProgress;
import com.rfchina.community.persistence.model.RepairRecordProgressExample;
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

public interface RepairRecordProgressMapper extends Serializable {
    @SelectProvider(type=RepairRecordProgressSqlProvider.class, method="countByExample")
    long countByExample(RepairRecordProgressExample example);

    @DeleteProvider(type=RepairRecordProgressSqlProvider.class, method="deleteByExample")
    int deleteByExample(RepairRecordProgressExample example);

    @Delete({
        "delete from repair_record_progress",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into repair_record_progress (trade_no, order_no, ",
        "out_id, processor, ",
        "processor_mobile, processor_time, ",
        "remark, out_detail, ",
        "create_time, status)",
        "values (#{tradeNo,jdbcType=VARCHAR}, #{orderNo,jdbcType=VARCHAR}, ",
        "#{outId,jdbcType=VARCHAR}, #{processor,jdbcType=VARCHAR}, ",
        "#{processorMobile,jdbcType=VARCHAR}, #{processorTime,jdbcType=TIMESTAMP}, ",
        "#{remark,jdbcType=VARCHAR}, #{outDetail,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{status,jdbcType=TINYINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(RepairRecordProgress record);

    @InsertProvider(type=RepairRecordProgressSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(RepairRecordProgress record);

    @SelectProvider(type=RepairRecordProgressSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="trade_no", property="tradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_no", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_id", property="outId", jdbcType=JdbcType.VARCHAR),
        @Result(column="processor", property="processor", jdbcType=JdbcType.VARCHAR),
        @Result(column="processor_mobile", property="processorMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="processor_time", property="processorTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_detail", property="outDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<RepairRecordProgress> selectByExample(RepairRecordProgressExample example);

    @Select({
        "select",
        "id, trade_no, order_no, out_id, processor, processor_mobile, processor_time, ",
        "remark, out_detail, create_time, status",
        "from repair_record_progress",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="trade_no", property="tradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_no", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_id", property="outId", jdbcType=JdbcType.VARCHAR),
        @Result(column="processor", property="processor", jdbcType=JdbcType.VARCHAR),
        @Result(column="processor_mobile", property="processorMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="processor_time", property="processorTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_detail", property="outDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    RepairRecordProgress selectByPrimaryKey(Long id);

    @UpdateProvider(type=RepairRecordProgressSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RepairRecordProgress record, @Param("example") RepairRecordProgressExample example);

    @UpdateProvider(type=RepairRecordProgressSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RepairRecordProgress record, @Param("example") RepairRecordProgressExample example);

    @UpdateProvider(type=RepairRecordProgressSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RepairRecordProgress record);

    @Update({
        "update repair_record_progress",
        "set trade_no = #{tradeNo,jdbcType=VARCHAR},",
          "order_no = #{orderNo,jdbcType=VARCHAR},",
          "out_id = #{outId,jdbcType=VARCHAR},",
          "processor = #{processor,jdbcType=VARCHAR},",
          "processor_mobile = #{processorMobile,jdbcType=VARCHAR},",
          "processor_time = #{processorTime,jdbcType=TIMESTAMP},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "out_detail = #{outDetail,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(RepairRecordProgress record);
}