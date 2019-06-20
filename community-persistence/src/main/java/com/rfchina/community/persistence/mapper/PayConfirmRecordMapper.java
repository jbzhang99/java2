package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.PayConfirmRecord;
import com.rfchina.community.persistence.model.PayConfirmRecordExample;
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

public interface PayConfirmRecordMapper extends Serializable {
    @SelectProvider(type=PayConfirmRecordSqlProvider.class, method="countByExample")
    long countByExample(PayConfirmRecordExample example);

    @DeleteProvider(type=PayConfirmRecordSqlProvider.class, method="deleteByExample")
    int deleteByExample(PayConfirmRecordExample example);

    @Delete({
        "delete from pay_confirm_record",
        "where bill_id = #{billId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String billId);

    @Insert({
        "insert into pay_confirm_record (bill_id, orig_bill_id, ",
        "type, scan_status, ",
        "result_status, remark, ",
        "scan_time, create_time)",
        "values (#{billId,jdbcType=VARCHAR}, #{origBillId,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=INTEGER}, #{scanStatus,jdbcType=INTEGER}, ",
        "#{resultStatus,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, ",
        "#{scanTime,jdbcType=TIMESTAMP}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(PayConfirmRecord record);

    @InsertProvider(type=PayConfirmRecordSqlProvider.class, method="insertSelective")
    int insertSelective(PayConfirmRecord record);

    @SelectProvider(type=PayConfirmRecordSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="orig_bill_id", property="origBillId", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="scan_status", property="scanStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="result_status", property="resultStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="scan_time", property="scanTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PayConfirmRecord> selectByExample(PayConfirmRecordExample example);

    @Select({
        "select",
        "bill_id, orig_bill_id, type, scan_status, result_status, remark, scan_time, ",
        "create_time",
        "from pay_confirm_record",
        "where bill_id = #{billId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="orig_bill_id", property="origBillId", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="scan_status", property="scanStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="result_status", property="resultStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="scan_time", property="scanTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    PayConfirmRecord selectByPrimaryKey(String billId);

    @UpdateProvider(type=PayConfirmRecordSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PayConfirmRecord record, @Param("example") PayConfirmRecordExample example);

    @UpdateProvider(type=PayConfirmRecordSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PayConfirmRecord record, @Param("example") PayConfirmRecordExample example);

    @UpdateProvider(type=PayConfirmRecordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PayConfirmRecord record);

    @Update({
        "update pay_confirm_record",
        "set orig_bill_id = #{origBillId,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=INTEGER},",
          "scan_status = #{scanStatus,jdbcType=INTEGER},",
          "result_status = #{resultStatus,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "scan_time = #{scanTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where bill_id = #{billId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(PayConfirmRecord record);
}