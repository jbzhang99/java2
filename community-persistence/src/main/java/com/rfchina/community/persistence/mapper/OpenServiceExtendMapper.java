package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenServiceExtend;
import com.rfchina.community.persistence.model.OpenServiceExtendExample;
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

public interface OpenServiceExtendMapper extends Serializable {
    @SelectProvider(type=OpenServiceExtendSqlProvider.class, method="countByExample")
    long countByExample(OpenServiceExtendExample example);

    @DeleteProvider(type=OpenServiceExtendSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenServiceExtendExample example);

    @Delete({
        "delete from open_service_extend",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into open_service_extend (id, keyword)",
        "values (#{id,jdbcType=INTEGER}, #{keyword,jdbcType=VARCHAR})"
    })
    int insert(OpenServiceExtend record);

    @InsertProvider(type=OpenServiceExtendSqlProvider.class, method="insertSelective")
    int insertSelective(OpenServiceExtend record);

    @SelectProvider(type=OpenServiceExtendSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="keyword", property="keyword", jdbcType=JdbcType.VARCHAR)
    })
    List<OpenServiceExtend> selectByExample(OpenServiceExtendExample example);

    @Select({
        "select",
        "id, keyword",
        "from open_service_extend",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="keyword", property="keyword", jdbcType=JdbcType.VARCHAR)
    })
    OpenServiceExtend selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OpenServiceExtendSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenServiceExtend record, @Param("example") OpenServiceExtendExample example);

    @UpdateProvider(type=OpenServiceExtendSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenServiceExtend record, @Param("example") OpenServiceExtendExample example);

    @UpdateProvider(type=OpenServiceExtendSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenServiceExtend record);

    @Update({
        "update open_service_extend",
        "set keyword = #{keyword,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenServiceExtend record);
}