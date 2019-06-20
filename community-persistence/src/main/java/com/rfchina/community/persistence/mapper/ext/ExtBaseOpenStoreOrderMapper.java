package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.OpenStoreOrderMapper;
import com.rfchina.community.persistence.model.ext.OpenStoreOrderRefundApplyVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface ExtBaseOpenStoreOrderMapper extends OpenStoreOrderMapper {

    @Select({
            "select",
            "oso.id,oso.out_trade_no, oso.refund_time, oso.refund_status,oso.open_refund_id, ",
            "oso.refund_approval,oso. refund_comment, oso.refund_remark, oso.result_status, oso.same_way, oo.refund_id ,oo.total_amount refund_money, ",
            "oso.create_time from open_store_order oso left join open_order oo on oo.out_trade_no = oso.out_trade_no where oso.id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="refund_time", property="refundTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="refund_status", property="refundStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="refund_approval", property="refundApproval", jdbcType=JdbcType.VARCHAR),
            @Result(column="refund_comment", property="refundComment", jdbcType=JdbcType.VARCHAR),
            @Result(column="refund_remark", property="refundRemark", jdbcType=JdbcType.VARCHAR),
            @Result(column="result_status", property="resultStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="same_way", property="sameWay", jdbcType=JdbcType.INTEGER),
            @Result(column="refund_id", property="refundBillId", jdbcType=JdbcType.INTEGER),
            @Result(column="refund_money", property="refundMoney", jdbcType=JdbcType.INTEGER),
            @Result(column="open_refund_id", property="openRefundId", jdbcType=JdbcType.INTEGER),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenStoreOrderRefundApplyVO selectRefundDetail(@Param("id") int id);

}