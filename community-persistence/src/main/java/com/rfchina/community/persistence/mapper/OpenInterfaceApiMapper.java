package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenInterfaceApi;
import com.rfchina.community.persistence.model.OpenInterfaceApiExample;
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

public interface OpenInterfaceApiMapper extends Serializable {
    @SelectProvider(type=OpenInterfaceApiSqlProvider.class, method="countByExample")
    long countByExample(OpenInterfaceApiExample example);

    @DeleteProvider(type=OpenInterfaceApiSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenInterfaceApiExample example);

    @Delete({
        "delete from open_interface_api",
        "where api_id = #{apiId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer apiId);

    @Insert({
        "insert into open_interface_api (api_id, service_id, ",
        "url, title, remark, ",
        "sort, status, target_url)",
        "values (#{apiId,jdbcType=INTEGER}, #{serviceId,jdbcType=INTEGER}, ",
        "#{url,jdbcType=VARCHAR}, #{title,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{sort,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, #{targetUrl,jdbcType=VARCHAR})"
    })
    int insert(OpenInterfaceApi record);

    @InsertProvider(type=OpenInterfaceApiSqlProvider.class, method="insertSelective")
    int insertSelective(OpenInterfaceApi record);

    @SelectProvider(type=OpenInterfaceApiSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="api_id", property="apiId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="target_url", property="targetUrl", jdbcType=JdbcType.VARCHAR)
    })
    List<OpenInterfaceApi> selectByExample(OpenInterfaceApiExample example);

    @Select({
        "select",
        "api_id, service_id, url, title, remark, sort, status, target_url",
        "from open_interface_api",
        "where api_id = #{apiId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="api_id", property="apiId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="target_url", property="targetUrl", jdbcType=JdbcType.VARCHAR)
    })
    OpenInterfaceApi selectByPrimaryKey(Integer apiId);

    @UpdateProvider(type=OpenInterfaceApiSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenInterfaceApi record, @Param("example") OpenInterfaceApiExample example);

    @UpdateProvider(type=OpenInterfaceApiSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenInterfaceApi record, @Param("example") OpenInterfaceApiExample example);

    @UpdateProvider(type=OpenInterfaceApiSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenInterfaceApi record);

    @Update({
        "update open_interface_api",
        "set service_id = #{serviceId,jdbcType=INTEGER},",
          "url = #{url,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "target_url = #{targetUrl,jdbcType=VARCHAR}",
        "where api_id = #{apiId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenInterfaceApi record);
}