package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreGood;
import com.rfchina.community.persistence.model.OpenStoreGoodExample;
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

public interface OpenStoreGoodMapper extends BaseMapper<OpenStoreGood,OpenStoreGoodExample,Integer> {
    @SelectProvider(type=OpenStoreGoodSqlProvider.class, method="countByExample")
    long countByExample(OpenStoreGoodExample example);

    @DeleteProvider(type=OpenStoreGoodSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenStoreGoodExample example);

    @Delete({
        "delete from open_store_good",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into open_store_good (service_id, code, ",
        "name, short_detail, ",
        "pre_price, price, ",
        "status, create_time, ",
        "update_time, stock, ",
        "sale_amount, virtual_sale_amount, ",
        "total_sale_amount, category_id, ",
        "verify_times, verify_start_time, ",
        "verify_end_time, sorting, ",
        "like_sorting, limit_times, ",
        "pic_url)",
        "values (#{serviceId,jdbcType=INTEGER}, #{code,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{shortDetail,jdbcType=VARCHAR}, ",
        "#{prePrice,jdbcType=DECIMAL}, #{price,jdbcType=DECIMAL}, ",
        "#{status,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{stock,jdbcType=INTEGER}, ",
        "#{saleAmount,jdbcType=INTEGER}, #{virtualSaleAmount,jdbcType=INTEGER}, ",
        "#{totalSaleAmount,jdbcType=INTEGER}, #{categoryId,jdbcType=INTEGER}, ",
        "#{verifyTimes,jdbcType=INTEGER}, #{verifyStartTime,jdbcType=TIMESTAMP}, ",
        "#{verifyEndTime,jdbcType=TIMESTAMP}, #{sorting,jdbcType=INTEGER}, ",
        "#{likeSorting,jdbcType=INTEGER}, #{limitTimes,jdbcType=INTEGER}, ",
        "#{picUrl,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(OpenStoreGood record);

    @InsertProvider(type=OpenStoreGoodSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(OpenStoreGood record);

    @SelectProvider(type=OpenStoreGoodSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="short_detail", property="shortDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="pre_price", property="prePrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="sale_amount", property="saleAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="virtual_sale_amount", property="virtualSaleAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="total_sale_amount", property="totalSaleAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.INTEGER),
        @Result(column="verify_times", property="verifyTimes", jdbcType=JdbcType.INTEGER),
        @Result(column="verify_start_time", property="verifyStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="verify_end_time", property="verifyEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sorting", property="sorting", jdbcType=JdbcType.INTEGER),
        @Result(column="like_sorting", property="likeSorting", jdbcType=JdbcType.INTEGER),
        @Result(column="limit_times", property="limitTimes", jdbcType=JdbcType.INTEGER),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<OpenStoreGood> selectByExampleWithBLOBs(OpenStoreGoodExample example);

    @SelectProvider(type=OpenStoreGoodSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="short_detail", property="shortDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="pre_price", property="prePrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="sale_amount", property="saleAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="virtual_sale_amount", property="virtualSaleAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="total_sale_amount", property="totalSaleAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.INTEGER),
        @Result(column="verify_times", property="verifyTimes", jdbcType=JdbcType.INTEGER),
        @Result(column="verify_start_time", property="verifyStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="verify_end_time", property="verifyEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sorting", property="sorting", jdbcType=JdbcType.INTEGER),
        @Result(column="like_sorting", property="likeSorting", jdbcType=JdbcType.INTEGER),
        @Result(column="limit_times", property="limitTimes", jdbcType=JdbcType.INTEGER)
    })
    List<OpenStoreGood> selectByExample(OpenStoreGoodExample example);

    @Select({
        "select",
        "id, service_id, code, name, short_detail, pre_price, price, status, create_time, ",
        "update_time, stock, sale_amount, virtual_sale_amount, total_sale_amount, category_id, ",
        "verify_times, verify_start_time, verify_end_time, sorting, like_sorting, limit_times, ",
        "pic_url",
        "from open_store_good",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="short_detail", property="shortDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="pre_price", property="prePrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="sale_amount", property="saleAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="virtual_sale_amount", property="virtualSaleAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="total_sale_amount", property="totalSaleAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.INTEGER),
        @Result(column="verify_times", property="verifyTimes", jdbcType=JdbcType.INTEGER),
        @Result(column="verify_start_time", property="verifyStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="verify_end_time", property="verifyEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sorting", property="sorting", jdbcType=JdbcType.INTEGER),
        @Result(column="like_sorting", property="likeSorting", jdbcType=JdbcType.INTEGER),
        @Result(column="limit_times", property="limitTimes", jdbcType=JdbcType.INTEGER),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.LONGVARCHAR)
    })
    OpenStoreGood selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OpenStoreGoodSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenStoreGood record, @Param("example") OpenStoreGoodExample example);

    @UpdateProvider(type=OpenStoreGoodSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") OpenStoreGood record, @Param("example") OpenStoreGoodExample example);

    @UpdateProvider(type=OpenStoreGoodSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenStoreGood record, @Param("example") OpenStoreGoodExample example);

    @UpdateProvider(type=OpenStoreGoodSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenStoreGood record);

    @Update({
        "update open_store_good",
        "set service_id = #{serviceId,jdbcType=INTEGER},",
          "code = #{code,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "short_detail = #{shortDetail,jdbcType=VARCHAR},",
          "pre_price = #{prePrice,jdbcType=DECIMAL},",
          "price = #{price,jdbcType=DECIMAL},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "stock = #{stock,jdbcType=INTEGER},",
          "sale_amount = #{saleAmount,jdbcType=INTEGER},",
          "virtual_sale_amount = #{virtualSaleAmount,jdbcType=INTEGER},",
          "total_sale_amount = #{totalSaleAmount,jdbcType=INTEGER},",
          "category_id = #{categoryId,jdbcType=INTEGER},",
          "verify_times = #{verifyTimes,jdbcType=INTEGER},",
          "verify_start_time = #{verifyStartTime,jdbcType=TIMESTAMP},",
          "verify_end_time = #{verifyEndTime,jdbcType=TIMESTAMP},",
          "sorting = #{sorting,jdbcType=INTEGER},",
          "like_sorting = #{likeSorting,jdbcType=INTEGER},",
          "limit_times = #{limitTimes,jdbcType=INTEGER},",
          "pic_url = #{picUrl,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(OpenStoreGood record);

    @Update({
        "update open_store_good",
        "set service_id = #{serviceId,jdbcType=INTEGER},",
          "code = #{code,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "short_detail = #{shortDetail,jdbcType=VARCHAR},",
          "pre_price = #{prePrice,jdbcType=DECIMAL},",
          "price = #{price,jdbcType=DECIMAL},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "stock = #{stock,jdbcType=INTEGER},",
          "sale_amount = #{saleAmount,jdbcType=INTEGER},",
          "virtual_sale_amount = #{virtualSaleAmount,jdbcType=INTEGER},",
          "total_sale_amount = #{totalSaleAmount,jdbcType=INTEGER},",
          "category_id = #{categoryId,jdbcType=INTEGER},",
          "verify_times = #{verifyTimes,jdbcType=INTEGER},",
          "verify_start_time = #{verifyStartTime,jdbcType=TIMESTAMP},",
          "verify_end_time = #{verifyEndTime,jdbcType=TIMESTAMP},",
          "sorting = #{sorting,jdbcType=INTEGER},",
          "like_sorting = #{likeSorting,jdbcType=INTEGER},",
          "limit_times = #{limitTimes,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenStoreGood record);
}