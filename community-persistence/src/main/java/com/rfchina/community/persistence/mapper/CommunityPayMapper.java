package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityPay;
import com.rfchina.community.persistence.model.CommunityPayExample;
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

public interface CommunityPayMapper extends Serializable {
    @SelectProvider(type=CommunityPaySqlProvider.class, method="countByExample")
    long countByExample(CommunityPayExample example);

    @DeleteProvider(type=CommunityPaySqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityPayExample example);

    @Delete({
        "delete from community_pay",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into community_pay (id, pay_account, ",
        "merchant_id, open_pay_account, ",
        "open_merchant_id, fee_rate)",
        "values (#{id,jdbcType=INTEGER}, #{payAccount,jdbcType=VARCHAR}, ",
        "#{merchantId,jdbcType=VARCHAR}, #{openPayAccount,jdbcType=VARCHAR}, ",
        "#{openMerchantId,jdbcType=VARCHAR}, #{feeRate,jdbcType=DECIMAL})"
    })
    int insert(CommunityPay record);

    @InsertProvider(type=CommunityPaySqlProvider.class, method="insertSelective")
    int insertSelective(CommunityPay record);

    @SelectProvider(type=CommunityPaySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pay_account", property="payAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_pay_account", property="openPayAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_merchant_id", property="openMerchantId", jdbcType=JdbcType.VARCHAR),
        @Result(column="fee_rate", property="feeRate", jdbcType=JdbcType.DECIMAL)
    })
    List<CommunityPay> selectByExample(CommunityPayExample example);

    @Select({
        "select",
        "id, pay_account, merchant_id, open_pay_account, open_merchant_id, fee_rate",
        "from community_pay",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pay_account", property="payAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_pay_account", property="openPayAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_merchant_id", property="openMerchantId", jdbcType=JdbcType.VARCHAR),
        @Result(column="fee_rate", property="feeRate", jdbcType=JdbcType.DECIMAL)
    })
    CommunityPay selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CommunityPaySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityPay record, @Param("example") CommunityPayExample example);

    @UpdateProvider(type=CommunityPaySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityPay record, @Param("example") CommunityPayExample example);

    @UpdateProvider(type=CommunityPaySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityPay record);

    @Update({
        "update community_pay",
        "set pay_account = #{payAccount,jdbcType=VARCHAR},",
          "merchant_id = #{merchantId,jdbcType=VARCHAR},",
          "open_pay_account = #{openPayAccount,jdbcType=VARCHAR},",
          "open_merchant_id = #{openMerchantId,jdbcType=VARCHAR},",
          "fee_rate = #{feeRate,jdbcType=DECIMAL}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommunityPay record);
}