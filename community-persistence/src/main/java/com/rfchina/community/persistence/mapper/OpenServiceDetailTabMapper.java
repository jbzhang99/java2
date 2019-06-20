package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenServiceDetailTabExample;
import com.rfchina.community.persistence.model.OpenServiceDetailTabKey;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface OpenServiceDetailTabMapper extends Serializable {
    @SelectProvider(type=OpenServiceDetailTabSqlProvider.class, method="countByExample")
    long countByExample(OpenServiceDetailTabExample example);

    @DeleteProvider(type=OpenServiceDetailTabSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenServiceDetailTabExample example);

    @Delete({
        "delete from open_service_detail_tab",
        "where service_id = #{serviceId,jdbcType=INTEGER}",
          "and type = #{type,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(OpenServiceDetailTabKey key);

    @Insert({
        "insert into open_service_detail_tab (service_id, type)",
        "values (#{serviceId,jdbcType=INTEGER}, #{type,jdbcType=INTEGER})"
    })
    int insert(OpenServiceDetailTabKey record);

    @InsertProvider(type=OpenServiceDetailTabSqlProvider.class, method="insertSelective")
    int insertSelective(OpenServiceDetailTabKey record);

    @SelectProvider(type=OpenServiceDetailTabSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<OpenServiceDetailTabKey> selectByExample(OpenServiceDetailTabExample example);

    @UpdateProvider(type=OpenServiceDetailTabSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenServiceDetailTabKey record, @Param("example") OpenServiceDetailTabExample example);

    @UpdateProvider(type=OpenServiceDetailTabSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenServiceDetailTabKey record, @Param("example") OpenServiceDetailTabExample example);
}