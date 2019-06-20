package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreOrderRefundApply;
import com.rfchina.community.persistence.model.OpenStoreOrderRefundApplyExample;
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

public interface OpenStoreOrderRefundApplyMapper extends Serializable {
    @SelectProvider(type=OpenStoreOrderRefundApplySqlProvider.class, method="countByExample")
    long countByExample(OpenStoreOrderRefundApplyExample example);

    @DeleteProvider(type=OpenStoreOrderRefundApplySqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenStoreOrderRefundApplyExample example);

    @Delete({
        "delete from open_store_order_refund_apply",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_store_order_refund_apply (refund_source, store_order_id, ",
        "bill_id, reason_certificate, ",
        "name, account_type, ",
        "account_no, deposit_bank, ",
        "confirm_letter, id_card_front, ",
        "id_card_rear, account_pic, ",
        "create_time)",
        "values (#{refundSource,jdbcType=CHAR}, #{storeOrderId,jdbcType=INTEGER}, ",
        "#{billId,jdbcType=VARCHAR}, #{reasonCertificate,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{accountType,jdbcType=INTEGER}, ",
        "#{accountNo,jdbcType=VARCHAR}, #{depositBank,jdbcType=VARCHAR}, ",
        "#{confirmLetter,jdbcType=VARCHAR}, #{idCardFront,jdbcType=VARCHAR}, ",
        "#{idCardRear,jdbcType=VARCHAR}, #{accountPic,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenStoreOrderRefundApply record);

    @InsertProvider(type=OpenStoreOrderRefundApplySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenStoreOrderRefundApply record);

    @SelectProvider(type=OpenStoreOrderRefundApplySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="refund_source", property="refundSource", jdbcType=JdbcType.CHAR),
        @Result(column="store_order_id", property="storeOrderId", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="reason_certificate", property="reasonCertificate", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_type", property="accountType", jdbcType=JdbcType.INTEGER),
        @Result(column="account_no", property="accountNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="deposit_bank", property="depositBank", jdbcType=JdbcType.VARCHAR),
        @Result(column="confirm_letter", property="confirmLetter", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_card_front", property="idCardFront", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_card_rear", property="idCardRear", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_pic", property="accountPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenStoreOrderRefundApply> selectByExample(OpenStoreOrderRefundApplyExample example);

    @Select({
        "select",
        "id, refund_source, store_order_id, bill_id, reason_certificate, name, account_type, ",
        "account_no, deposit_bank, confirm_letter, id_card_front, id_card_rear, account_pic, ",
        "create_time",
        "from open_store_order_refund_apply",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="refund_source", property="refundSource", jdbcType=JdbcType.CHAR),
        @Result(column="store_order_id", property="storeOrderId", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="reason_certificate", property="reasonCertificate", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_type", property="accountType", jdbcType=JdbcType.INTEGER),
        @Result(column="account_no", property="accountNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="deposit_bank", property="depositBank", jdbcType=JdbcType.VARCHAR),
        @Result(column="confirm_letter", property="confirmLetter", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_card_front", property="idCardFront", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_card_rear", property="idCardRear", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_pic", property="accountPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenStoreOrderRefundApply selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenStoreOrderRefundApplySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenStoreOrderRefundApply record, @Param("example") OpenStoreOrderRefundApplyExample example);

    @UpdateProvider(type=OpenStoreOrderRefundApplySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenStoreOrderRefundApply record, @Param("example") OpenStoreOrderRefundApplyExample example);

    @UpdateProvider(type=OpenStoreOrderRefundApplySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenStoreOrderRefundApply record);

    @Update({
        "update open_store_order_refund_apply",
        "set refund_source = #{refundSource,jdbcType=CHAR},",
          "store_order_id = #{storeOrderId,jdbcType=INTEGER},",
          "bill_id = #{billId,jdbcType=VARCHAR},",
          "reason_certificate = #{reasonCertificate,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "account_type = #{accountType,jdbcType=INTEGER},",
          "account_no = #{accountNo,jdbcType=VARCHAR},",
          "deposit_bank = #{depositBank,jdbcType=VARCHAR},",
          "confirm_letter = #{confirmLetter,jdbcType=VARCHAR},",
          "id_card_front = #{idCardFront,jdbcType=VARCHAR},",
          "id_card_rear = #{idCardRear,jdbcType=VARCHAR},",
          "account_pic = #{accountPic,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenStoreOrderRefundApply record);
}