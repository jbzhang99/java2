package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CmStoreCouponExtend;
import com.rfchina.community.persistence.model.CmStoreCouponExtendExample;
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

public interface CmStoreCouponExtendMapper extends Serializable {
    @SelectProvider(type=CmStoreCouponExtendSqlProvider.class, method="countByExample")
    long countByExample(CmStoreCouponExtendExample example);

    @DeleteProvider(type=CmStoreCouponExtendSqlProvider.class, method="deleteByExample")
    int deleteByExample(CmStoreCouponExtendExample example);

    @Delete({
        "delete from cm_store_coupon_extend",
        "where card_item_id = #{cardItemId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long cardItemId);

    @Insert({
        "insert into cm_store_coupon_extend (card_item_id, service_id, ",
        "merchant_id, limit_money)",
        "values (#{cardItemId,jdbcType=BIGINT}, #{serviceId,jdbcType=INTEGER}, ",
        "#{merchantId,jdbcType=BIGINT}, #{limitMoney,jdbcType=DECIMAL})"
    })
    int insert(CmStoreCouponExtend record);

    @InsertProvider(type=CmStoreCouponExtendSqlProvider.class, method="insertSelective")
    int insertSelective(CmStoreCouponExtend record);

    @SelectProvider(type=CmStoreCouponExtendSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="card_item_id", property="cardItemId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.BIGINT),
        @Result(column="limit_money", property="limitMoney", jdbcType=JdbcType.DECIMAL)
    })
    List<CmStoreCouponExtend> selectByExample(CmStoreCouponExtendExample example);

    @Select({
        "select",
        "card_item_id, service_id, merchant_id, limit_money",
        "from cm_store_coupon_extend",
        "where card_item_id = #{cardItemId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="card_item_id", property="cardItemId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.BIGINT),
        @Result(column="limit_money", property="limitMoney", jdbcType=JdbcType.DECIMAL)
    })
    CmStoreCouponExtend selectByPrimaryKey(Long cardItemId);

    @UpdateProvider(type=CmStoreCouponExtendSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CmStoreCouponExtend record, @Param("example") CmStoreCouponExtendExample example);

    @UpdateProvider(type=CmStoreCouponExtendSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CmStoreCouponExtend record, @Param("example") CmStoreCouponExtendExample example);

    @UpdateProvider(type=CmStoreCouponExtendSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CmStoreCouponExtend record);

    @Update({
        "update cm_store_coupon_extend",
        "set service_id = #{serviceId,jdbcType=INTEGER},",
          "merchant_id = #{merchantId,jdbcType=BIGINT},",
          "limit_money = #{limitMoney,jdbcType=DECIMAL}",
        "where card_item_id = #{cardItemId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CmStoreCouponExtend record);
}