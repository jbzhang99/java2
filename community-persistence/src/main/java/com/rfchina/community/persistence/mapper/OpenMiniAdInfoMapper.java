package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenMiniAdInfo;
import com.rfchina.community.persistence.model.OpenMiniAdInfoExample;
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

public interface OpenMiniAdInfoMapper extends Serializable {
    @SelectProvider(type=OpenMiniAdInfoSqlProvider.class, method="countByExample")
    long countByExample(OpenMiniAdInfoExample example);

    @DeleteProvider(type=OpenMiniAdInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenMiniAdInfoExample example);

    @Delete({
        "delete from open_mini_ad_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_mini_ad_info (title, style, ",
        "status, sorting, ",
        "create_time, update_time)",
        "values (#{title,jdbcType=VARCHAR}, #{style,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{sorting,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenMiniAdInfo record);

    @InsertProvider(type=OpenMiniAdInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenMiniAdInfo record);

    @SelectProvider(type=OpenMiniAdInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="style", property="style", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="sorting", property="sorting", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenMiniAdInfo> selectByExample(OpenMiniAdInfoExample example);

    @Select({
        "select",
        "id, title, style, status, sorting, create_time, update_time",
        "from open_mini_ad_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="style", property="style", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="sorting", property="sorting", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenMiniAdInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenMiniAdInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenMiniAdInfo record, @Param("example") OpenMiniAdInfoExample example);

    @UpdateProvider(type=OpenMiniAdInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenMiniAdInfo record, @Param("example") OpenMiniAdInfoExample example);

    @UpdateProvider(type=OpenMiniAdInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenMiniAdInfo record);

    @Update({
        "update open_mini_ad_info",
        "set title = #{title,jdbcType=VARCHAR},",
          "style = #{style,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "sorting = #{sorting,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenMiniAdInfo record);
}