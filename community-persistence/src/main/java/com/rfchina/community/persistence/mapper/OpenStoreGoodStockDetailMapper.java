package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreGoodStockDetail;
import com.rfchina.community.persistence.model.OpenStoreGoodStockDetailExample;
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

public interface OpenStoreGoodStockDetailMapper extends Serializable {
    @SelectProvider(type=OpenStoreGoodStockDetailSqlProvider.class, method="countByExample")
    long countByExample(OpenStoreGoodStockDetailExample example);

    @DeleteProvider(type=OpenStoreGoodStockDetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenStoreGoodStockDetailExample example);

    @Delete({
        "delete from open_store_good_stock_detail",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_store_good_stock_detail (type, group_data_id, ",
        "group_info_id, good_id, ",
        "source, operate, ",
        "before_value, after_value, ",
        "amount, target_id, ",
        "create_time)",
        "values (#{type,jdbcType=VARCHAR}, #{groupDataId,jdbcType=BIGINT}, ",
        "#{groupInfoId,jdbcType=BIGINT}, #{goodId,jdbcType=INTEGER}, ",
        "#{source,jdbcType=VARCHAR}, #{operate,jdbcType=VARCHAR}, ",
        "#{beforeValue,jdbcType=INTEGER}, #{afterValue,jdbcType=INTEGER}, ",
        "#{amount,jdbcType=INTEGER}, #{targetId,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenStoreGoodStockDetail record);

    @InsertProvider(type=OpenStoreGoodStockDetailSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenStoreGoodStockDetail record);

    @SelectProvider(type=OpenStoreGoodStockDetailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_data_id", property="groupDataId", jdbcType=JdbcType.BIGINT),
        @Result(column="group_info_id", property="groupInfoId", jdbcType=JdbcType.BIGINT),
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
        @Result(column="source", property="source", jdbcType=JdbcType.VARCHAR),
        @Result(column="operate", property="operate", jdbcType=JdbcType.VARCHAR),
        @Result(column="before_value", property="beforeValue", jdbcType=JdbcType.INTEGER),
        @Result(column="after_value", property="afterValue", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="target_id", property="targetId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenStoreGoodStockDetail> selectByExample(OpenStoreGoodStockDetailExample example);

    @Select({
        "select",
        "id, type, group_data_id, group_info_id, good_id, source, operate, before_value, ",
        "after_value, amount, target_id, create_time",
        "from open_store_good_stock_detail",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_data_id", property="groupDataId", jdbcType=JdbcType.BIGINT),
        @Result(column="group_info_id", property="groupInfoId", jdbcType=JdbcType.BIGINT),
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
        @Result(column="source", property="source", jdbcType=JdbcType.VARCHAR),
        @Result(column="operate", property="operate", jdbcType=JdbcType.VARCHAR),
        @Result(column="before_value", property="beforeValue", jdbcType=JdbcType.INTEGER),
        @Result(column="after_value", property="afterValue", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="target_id", property="targetId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenStoreGoodStockDetail selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenStoreGoodStockDetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenStoreGoodStockDetail record, @Param("example") OpenStoreGoodStockDetailExample example);

    @UpdateProvider(type=OpenStoreGoodStockDetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenStoreGoodStockDetail record, @Param("example") OpenStoreGoodStockDetailExample example);

    @UpdateProvider(type=OpenStoreGoodStockDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenStoreGoodStockDetail record);

    @Update({
        "update open_store_good_stock_detail",
        "set type = #{type,jdbcType=VARCHAR},",
          "group_data_id = #{groupDataId,jdbcType=BIGINT},",
          "group_info_id = #{groupInfoId,jdbcType=BIGINT},",
          "good_id = #{goodId,jdbcType=INTEGER},",
          "source = #{source,jdbcType=VARCHAR},",
          "operate = #{operate,jdbcType=VARCHAR},",
          "before_value = #{beforeValue,jdbcType=INTEGER},",
          "after_value = #{afterValue,jdbcType=INTEGER},",
          "amount = #{amount,jdbcType=INTEGER},",
          "target_id = #{targetId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenStoreGoodStockDetail record);
}