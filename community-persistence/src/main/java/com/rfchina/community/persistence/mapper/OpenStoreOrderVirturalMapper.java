package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreOrderVirtural;
import com.rfchina.community.persistence.model.OpenStoreOrderVirturalExample;
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

public interface OpenStoreOrderVirturalMapper extends Serializable {
    @SelectProvider(type=OpenStoreOrderVirturalSqlProvider.class, method="countByExample")
    long countByExample(OpenStoreOrderVirturalExample example);

    @DeleteProvider(type=OpenStoreOrderVirturalSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenStoreOrderVirturalExample example);

    @Delete({
        "delete from open_store_order_virtural",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into open_store_order_virtural (group_data_id, nick_name, ",
        "pic_url, out_trade_no, ",
        "create_time)",
        "values (#{groupDataId,jdbcType=BIGINT}, #{nickName,jdbcType=VARCHAR}, ",
        "#{picUrl,jdbcType=VARCHAR}, #{outTradeNo,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(OpenStoreOrderVirtural record);

    @InsertProvider(type=OpenStoreOrderVirturalSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(OpenStoreOrderVirtural record);

    @SelectProvider(type=OpenStoreOrderVirturalSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_data_id", property="groupDataId", jdbcType=JdbcType.BIGINT),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenStoreOrderVirtural> selectByExample(OpenStoreOrderVirturalExample example);

    @Select({
        "select",
        "id, group_data_id, nick_name, pic_url, out_trade_no, create_time",
        "from open_store_order_virtural",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_data_id", property="groupDataId", jdbcType=JdbcType.BIGINT),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenStoreOrderVirtural selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OpenStoreOrderVirturalSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenStoreOrderVirtural record, @Param("example") OpenStoreOrderVirturalExample example);

    @UpdateProvider(type=OpenStoreOrderVirturalSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenStoreOrderVirtural record, @Param("example") OpenStoreOrderVirturalExample example);

    @UpdateProvider(type=OpenStoreOrderVirturalSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenStoreOrderVirtural record);

    @Update({
        "update open_store_order_virtural",
        "set group_data_id = #{groupDataId,jdbcType=BIGINT},",
          "nick_name = #{nickName,jdbcType=VARCHAR},",
          "pic_url = #{picUrl,jdbcType=VARCHAR},",
          "out_trade_no = #{outTradeNo,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenStoreOrderVirtural record);
}