package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CautionMoneyCategory;
import com.rfchina.community.persistence.model.CautionMoneyCategoryExample;
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

public interface CautionMoneyCategoryMapper extends Serializable {
    @SelectProvider(type=CautionMoneyCategorySqlProvider.class, method="countByExample")
    long countByExample(CautionMoneyCategoryExample example);

    @DeleteProvider(type=CautionMoneyCategorySqlProvider.class, method="deleteByExample")
    int deleteByExample(CautionMoneyCategoryExample example);

    @Delete({
        "delete from caution_money_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into caution_money_category (name, value, ",
        "create_time)",
        "values (#{name,jdbcType=VARCHAR}, #{value,jdbcType=DECIMAL}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(CautionMoneyCategory record);

    @InsertProvider(type=CautionMoneyCategorySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(CautionMoneyCategory record);

    @SelectProvider(type=CautionMoneyCategorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="value", property="value", jdbcType=JdbcType.DECIMAL),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CautionMoneyCategory> selectByExample(CautionMoneyCategoryExample example);

    @Select({
        "select",
        "id, name, value, create_time",
        "from caution_money_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="value", property="value", jdbcType=JdbcType.DECIMAL),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CautionMoneyCategory selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CautionMoneyCategorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CautionMoneyCategory record, @Param("example") CautionMoneyCategoryExample example);

    @UpdateProvider(type=CautionMoneyCategorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CautionMoneyCategory record, @Param("example") CautionMoneyCategoryExample example);

    @UpdateProvider(type=CautionMoneyCategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CautionMoneyCategory record);

    @Update({
        "update caution_money_category",
        "set name = #{name,jdbcType=VARCHAR},",
          "value = #{value,jdbcType=DECIMAL},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CautionMoneyCategory record);
}