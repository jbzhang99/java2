package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenXFSJStore;
import com.rfchina.community.persistence.model.OpenXFSJStoreExample;
import com.rfchina.community.persistence.model.OpenXFSJStoreKey;
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

public interface OpenXFSJStoreMapper extends Serializable {
    @SelectProvider(type=OpenXFSJStoreSqlProvider.class, method="countByExample")
    long countByExample(OpenXFSJStoreExample example);

    @DeleteProvider(type=OpenXFSJStoreSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenXFSJStoreExample example);

    @Delete({
        "delete from open_xfsj_store",
        "where xfsj_id = #{xfsjId,jdbcType=BIGINT}",
          "and store_id = #{storeId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(OpenXFSJStoreKey key);

    @Insert({
        "insert into open_xfsj_store (xfsj_id, store_id, ",
        "cover_img, orderby, ",
        "create_time)",
        "values (#{xfsjId,jdbcType=BIGINT}, #{storeId,jdbcType=INTEGER}, ",
        "#{coverImg,jdbcType=VARCHAR}, #{orderby,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(OpenXFSJStore record);

    @InsertProvider(type=OpenXFSJStoreSqlProvider.class, method="insertSelective")
    int insertSelective(OpenXFSJStore record);

    @SelectProvider(type=OpenXFSJStoreSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="xfsj_id", property="xfsjId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="store_id", property="storeId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="cover_img", property="coverImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="orderby", property="orderby", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenXFSJStore> selectByExample(OpenXFSJStoreExample example);

    @Select({
        "select",
        "xfsj_id, store_id, cover_img, orderby, create_time",
        "from open_xfsj_store",
        "where xfsj_id = #{xfsjId,jdbcType=BIGINT}",
          "and store_id = #{storeId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="xfsj_id", property="xfsjId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="store_id", property="storeId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="cover_img", property="coverImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="orderby", property="orderby", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenXFSJStore selectByPrimaryKey(OpenXFSJStoreKey key);

    @UpdateProvider(type=OpenXFSJStoreSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenXFSJStore record, @Param("example") OpenXFSJStoreExample example);

    @UpdateProvider(type=OpenXFSJStoreSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenXFSJStore record, @Param("example") OpenXFSJStoreExample example);

    @UpdateProvider(type=OpenXFSJStoreSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenXFSJStore record);

    @Update({
        "update open_xfsj_store",
        "set cover_img = #{coverImg,jdbcType=VARCHAR},",
          "orderby = #{orderby,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where xfsj_id = #{xfsjId,jdbcType=BIGINT}",
          "and store_id = #{storeId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenXFSJStore record);
}