package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CardInfoOpenRela;
import com.rfchina.community.persistence.model.CardInfoOpenRelaExample;
import com.rfchina.community.persistence.model.CardInfoOpenRelaKey;
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

public interface CardInfoOpenRelaMapper extends Serializable {
    @SelectProvider(type=CardInfoOpenRelaSqlProvider.class, method="countByExample")
    long countByExample(CardInfoOpenRelaExample example);

    @DeleteProvider(type=CardInfoOpenRelaSqlProvider.class, method="deleteByExample")
    int deleteByExample(CardInfoOpenRelaExample example);

    @Delete({
        "delete from card_info_open_rela",
        "where card_id = #{cardId,jdbcType=BIGINT}",
          "and merchant_id = #{merchantId,jdbcType=BIGINT}",
          "and service_id = #{serviceId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(CardInfoOpenRelaKey key);

    @Insert({
        "insert into card_info_open_rela (card_id, merchant_id, ",
        "service_id, goods_id)",
        "values (#{cardId,jdbcType=BIGINT}, #{merchantId,jdbcType=BIGINT}, ",
        "#{serviceId,jdbcType=INTEGER}, #{goodsId,jdbcType=INTEGER})"
    })
    int insert(CardInfoOpenRela record);

    @InsertProvider(type=CardInfoOpenRelaSqlProvider.class, method="insertSelective")
    int insertSelective(CardInfoOpenRela record);

    @SelectProvider(type=CardInfoOpenRelaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="goods_id", property="goodsId", jdbcType=JdbcType.INTEGER)
    })
    List<CardInfoOpenRela> selectByExample(CardInfoOpenRelaExample example);

    @Select({
        "select",
        "card_id, merchant_id, service_id, goods_id",
        "from card_info_open_rela",
        "where card_id = #{cardId,jdbcType=BIGINT}",
          "and merchant_id = #{merchantId,jdbcType=BIGINT}",
          "and service_id = #{serviceId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="goods_id", property="goodsId", jdbcType=JdbcType.INTEGER)
    })
    CardInfoOpenRela selectByPrimaryKey(CardInfoOpenRelaKey key);

    @UpdateProvider(type=CardInfoOpenRelaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CardInfoOpenRela record, @Param("example") CardInfoOpenRelaExample example);

    @UpdateProvider(type=CardInfoOpenRelaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CardInfoOpenRela record, @Param("example") CardInfoOpenRelaExample example);

    @UpdateProvider(type=CardInfoOpenRelaSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CardInfoOpenRela record);

    @Update({
        "update card_info_open_rela",
        "set goods_id = #{goodsId,jdbcType=INTEGER}",
        "where card_id = #{cardId,jdbcType=BIGINT}",
          "and merchant_id = #{merchantId,jdbcType=BIGINT}",
          "and service_id = #{serviceId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CardInfoOpenRela record);
}