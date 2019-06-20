package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenXFSJStoreGood;
import com.rfchina.community.persistence.model.OpenXFSJStoreGoodExample;
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

public interface OpenXFSJStoreGoodMapper extends Serializable {
    @SelectProvider(type=OpenXFSJStoreGoodSqlProvider.class, method="countByExample")
    long countByExample(OpenXFSJStoreGoodExample example);

    @DeleteProvider(type=OpenXFSJStoreGoodSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenXFSJStoreGoodExample example);

    @Delete({
        "delete from open_xfsj_store_good",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_xfsj_store_good (xfsj_id, good_id, ",
        "type, store_id, orderby, ",
        "create_time, img, ",
        "title)",
        "values (#{xfsjId,jdbcType=BIGINT}, #{goodId,jdbcType=INTEGER}, ",
        "#{type,jdbcType=INTEGER}, #{storeId,jdbcType=INTEGER}, #{orderby,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{img,jdbcType=VARCHAR}, ",
        "#{title,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenXFSJStoreGood record);

    @InsertProvider(type=OpenXFSJStoreGoodSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenXFSJStoreGood record);

    @SelectProvider(type=OpenXFSJStoreGoodSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="xfsj_id", property="xfsjId", jdbcType=JdbcType.BIGINT),
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="store_id", property="storeId", jdbcType=JdbcType.INTEGER),
        @Result(column="orderby", property="orderby", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="img", property="img", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR)
    })
    List<OpenXFSJStoreGood> selectByExample(OpenXFSJStoreGoodExample example);

    @Select({
        "select",
        "id, xfsj_id, good_id, type, store_id, orderby, create_time, img, title",
        "from open_xfsj_store_good",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="xfsj_id", property="xfsjId", jdbcType=JdbcType.BIGINT),
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="store_id", property="storeId", jdbcType=JdbcType.INTEGER),
        @Result(column="orderby", property="orderby", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="img", property="img", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR)
    })
    OpenXFSJStoreGood selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenXFSJStoreGoodSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenXFSJStoreGood record, @Param("example") OpenXFSJStoreGoodExample example);

    @UpdateProvider(type=OpenXFSJStoreGoodSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenXFSJStoreGood record, @Param("example") OpenXFSJStoreGoodExample example);

    @UpdateProvider(type=OpenXFSJStoreGoodSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenXFSJStoreGood record);

    @Update({
        "update open_xfsj_store_good",
        "set xfsj_id = #{xfsjId,jdbcType=BIGINT},",
          "good_id = #{goodId,jdbcType=INTEGER},",
          "type = #{type,jdbcType=INTEGER},",
          "store_id = #{storeId,jdbcType=INTEGER},",
          "orderby = #{orderby,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "img = #{img,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenXFSJStoreGood record);
}