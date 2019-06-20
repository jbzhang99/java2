package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CardCategory;
import com.rfchina.community.persistence.model.CardCategoryExample;
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

public interface CardCategoryMapper extends Serializable {
    @SelectProvider(type=CardCategorySqlProvider.class, method="countByExample")
    long countByExample(CardCategoryExample example);

    @DeleteProvider(type=CardCategorySqlProvider.class, method="deleteByExample")
    int deleteByExample(CardCategoryExample example);

    @Delete({
        "delete from card_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into card_category (parent_id, community_id, ",
        "template_id, name, ",
        "type, status, sorting, ",
        "create_time)",
        "values (#{parentId,jdbcType=INTEGER}, #{communityId,jdbcType=INTEGER}, ",
        "#{templateId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, #{sorting,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(CardCategory record);

    @InsertProvider(type=CardCategorySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(CardCategory record);

    @SelectProvider(type=CardCategorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="template_id", property="templateId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="sorting", property="sorting", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CardCategory> selectByExample(CardCategoryExample example);

    @Select({
        "select",
        "id, parent_id, community_id, template_id, name, type, status, sorting, create_time",
        "from card_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="template_id", property="templateId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="sorting", property="sorting", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CardCategory selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CardCategorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CardCategory record, @Param("example") CardCategoryExample example);

    @UpdateProvider(type=CardCategorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CardCategory record, @Param("example") CardCategoryExample example);

    @UpdateProvider(type=CardCategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CardCategory record);

    @Update({
        "update card_category",
        "set parent_id = #{parentId,jdbcType=INTEGER},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "template_id = #{templateId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "sorting = #{sorting,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CardCategory record);
}