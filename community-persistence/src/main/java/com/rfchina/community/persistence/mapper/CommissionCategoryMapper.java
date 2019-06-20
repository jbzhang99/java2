package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommissionCategory;
import com.rfchina.community.persistence.model.CommissionCategoryExample;
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

public interface CommissionCategoryMapper extends Serializable {
    @SelectProvider(type=CommissionCategorySqlProvider.class, method="countByExample")
    long countByExample(CommissionCategoryExample example);

    @DeleteProvider(type=CommissionCategorySqlProvider.class, method="deleteByExample")
    int deleteByExample(CommissionCategoryExample example);

    @Delete({
        "delete from commission_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into commission_category (name, value, ",
        "create_time)",
        "values (#{name,jdbcType=VARCHAR}, #{value,jdbcType=DECIMAL}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(CommissionCategory record);

    @InsertProvider(type=CommissionCategorySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(CommissionCategory record);

    @SelectProvider(type=CommissionCategorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="value", property="value", jdbcType=JdbcType.DECIMAL),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CommissionCategory> selectByExample(CommissionCategoryExample example);

    @Select({
        "select",
        "id, name, value, create_time",
        "from commission_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="value", property="value", jdbcType=JdbcType.DECIMAL),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CommissionCategory selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CommissionCategorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommissionCategory record, @Param("example") CommissionCategoryExample example);

    @UpdateProvider(type=CommissionCategorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommissionCategory record, @Param("example") CommissionCategoryExample example);

    @UpdateProvider(type=CommissionCategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommissionCategory record);

    @Update({
        "update commission_category",
        "set name = #{name,jdbcType=VARCHAR},",
          "value = #{value,jdbcType=DECIMAL},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommissionCategory record);
}