package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenInterface;
import com.rfchina.community.persistence.model.OpenInterfaceExample;
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

public interface OpenInterfaceMapper extends Serializable {
    @SelectProvider(type=OpenInterfaceSqlProvider.class, method="countByExample")
    long countByExample(OpenInterfaceExample example);

    @DeleteProvider(type=OpenInterfaceSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenInterfaceExample example);

    @Delete({
        "delete from open_interface",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into open_interface (id, title, ",
        "description, create_time, ",
        "status, zizai)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=INTEGER}, #{zizai,jdbcType=INTEGER})"
    })
    int insert(OpenInterface record);

    @InsertProvider(type=OpenInterfaceSqlProvider.class, method="insertSelective")
    int insertSelective(OpenInterface record);

    @SelectProvider(type=OpenInterfaceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="zizai", property="zizai", jdbcType=JdbcType.INTEGER)
    })
    List<OpenInterface> selectByExample(OpenInterfaceExample example);

    @Select({
        "select",
        "id, title, description, create_time, status, zizai",
        "from open_interface",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="zizai", property="zizai", jdbcType=JdbcType.INTEGER)
    })
    OpenInterface selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OpenInterfaceSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenInterface record, @Param("example") OpenInterfaceExample example);

    @UpdateProvider(type=OpenInterfaceSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenInterface record, @Param("example") OpenInterfaceExample example);

    @UpdateProvider(type=OpenInterfaceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenInterface record);

    @Update({
        "update open_interface",
        "set title = #{title,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "zizai = #{zizai,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenInterface record);
}