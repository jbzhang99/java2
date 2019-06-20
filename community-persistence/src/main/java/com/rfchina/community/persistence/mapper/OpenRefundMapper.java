package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenRefund;
import com.rfchina.community.persistence.model.OpenRefundExample;
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

public interface OpenRefundMapper extends Serializable {
    @SelectProvider(type=OpenRefundSqlProvider.class, method="countByExample")
    long countByExample(OpenRefundExample example);

    @DeleteProvider(type=OpenRefundSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenRefundExample example);

    @Delete({
        "delete from open_refund",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_refund (open_id, bill_id, ",
        "refund_id, create_time, ",
        "update_time, status, ",
        "revoke_code, refund_bill_id, ",
        "refund_account_id)",
        "values (#{openId,jdbcType=BIGINT}, #{billId,jdbcType=VARCHAR}, ",
        "#{refundId,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER}, ",
        "#{revokeCode,jdbcType=VARCHAR}, #{refundBillId,jdbcType=VARCHAR}, ",
        "#{refundAccountId,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenRefund record);

    @InsertProvider(type=OpenRefundSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenRefund record);

    @SelectProvider(type=OpenRefundSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="open_id", property="openId", jdbcType=JdbcType.BIGINT),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="refund_id", property="refundId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="revoke_code", property="revokeCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="refund_bill_id", property="refundBillId", jdbcType=JdbcType.VARCHAR),
        @Result(column="refund_account_id", property="refundAccountId", jdbcType=JdbcType.VARCHAR)
    })
    List<OpenRefund> selectByExample(OpenRefundExample example);

    @Select({
        "select",
        "id, open_id, bill_id, refund_id, create_time, update_time, status, revoke_code, ",
        "refund_bill_id, refund_account_id",
        "from open_refund",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="open_id", property="openId", jdbcType=JdbcType.BIGINT),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="refund_id", property="refundId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="revoke_code", property="revokeCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="refund_bill_id", property="refundBillId", jdbcType=JdbcType.VARCHAR),
        @Result(column="refund_account_id", property="refundAccountId", jdbcType=JdbcType.VARCHAR)
    })
    OpenRefund selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenRefundSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenRefund record, @Param("example") OpenRefundExample example);

    @UpdateProvider(type=OpenRefundSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenRefund record, @Param("example") OpenRefundExample example);

    @UpdateProvider(type=OpenRefundSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenRefund record);

    @Update({
        "update open_refund",
        "set open_id = #{openId,jdbcType=BIGINT},",
          "bill_id = #{billId,jdbcType=VARCHAR},",
          "refund_id = #{refundId,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "revoke_code = #{revokeCode,jdbcType=VARCHAR},",
          "refund_bill_id = #{refundBillId,jdbcType=VARCHAR},",
          "refund_account_id = #{refundAccountId,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenRefund record);
}