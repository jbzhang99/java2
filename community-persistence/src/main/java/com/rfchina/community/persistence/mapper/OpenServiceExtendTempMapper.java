package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenServiceExtendTemp;
import com.rfchina.community.persistence.model.OpenServiceExtendTempExample;
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

public interface OpenServiceExtendTempMapper extends Serializable {
    @SelectProvider(type=OpenServiceExtendTempSqlProvider.class, method="countByExample")
    long countByExample(OpenServiceExtendTempExample example);

    @DeleteProvider(type=OpenServiceExtendTempSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenServiceExtendTempExample example);

    @Delete({
        "delete from open_service_extend_temp",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into open_service_extend_temp (id, keyword)",
        "values (#{id,jdbcType=INTEGER}, #{keyword,jdbcType=VARCHAR})"
    })
    int insert(OpenServiceExtendTemp record);

    @InsertProvider(type=OpenServiceExtendTempSqlProvider.class, method="insertSelective")
    int insertSelective(OpenServiceExtendTemp record);

    @SelectProvider(type=OpenServiceExtendTempSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="keyword", property="keyword", jdbcType=JdbcType.VARCHAR)
    })
    List<OpenServiceExtendTemp> selectByExample(OpenServiceExtendTempExample example);

    @Select({
        "select",
        "id, keyword",
        "from open_service_extend_temp",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="keyword", property="keyword", jdbcType=JdbcType.VARCHAR)
    })
    OpenServiceExtendTemp selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OpenServiceExtendTempSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenServiceExtendTemp record, @Param("example") OpenServiceExtendTempExample example);

    @UpdateProvider(type=OpenServiceExtendTempSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenServiceExtendTemp record, @Param("example") OpenServiceExtendTempExample example);

    @UpdateProvider(type=OpenServiceExtendTempSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenServiceExtendTemp record);

    @Update({
        "update open_service_extend_temp",
        "set keyword = #{keyword,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenServiceExtendTemp record);
}