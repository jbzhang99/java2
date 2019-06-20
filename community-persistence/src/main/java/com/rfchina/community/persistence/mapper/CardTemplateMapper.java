package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CardTemplate;
import com.rfchina.community.persistence.model.CardTemplateExample;
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

public interface CardTemplateMapper extends Serializable {
    @SelectProvider(type=CardTemplateSqlProvider.class, method="countByExample")
    long countByExample(CardTemplateExample example);

    @DeleteProvider(type=CardTemplateSqlProvider.class, method="deleteByExample")
    int deleteByExample(CardTemplateExample example);

    @Delete({
        "delete from card_template",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into card_template (id, parent_id, ",
        "name, create_time, ",
        "template)",
        "values (#{id,jdbcType=INTEGER}, #{parentId,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{template,jdbcType=LONGVARCHAR})"
    })
    int insert(CardTemplate record);

    @InsertProvider(type=CardTemplateSqlProvider.class, method="insertSelective")
    int insertSelective(CardTemplate record);

    @SelectProvider(type=CardTemplateSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="template", property="template", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<CardTemplate> selectByExampleWithBLOBs(CardTemplateExample example);

    @SelectProvider(type=CardTemplateSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CardTemplate> selectByExample(CardTemplateExample example);

    @Select({
        "select",
        "id, parent_id, name, create_time, template",
        "from card_template",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="template", property="template", jdbcType=JdbcType.LONGVARCHAR)
    })
    CardTemplate selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CardTemplateSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CardTemplate record, @Param("example") CardTemplateExample example);

    @UpdateProvider(type=CardTemplateSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") CardTemplate record, @Param("example") CardTemplateExample example);

    @UpdateProvider(type=CardTemplateSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CardTemplate record, @Param("example") CardTemplateExample example);

    @UpdateProvider(type=CardTemplateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CardTemplate record);

    @Update({
        "update card_template",
        "set parent_id = #{parentId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "template = #{template,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(CardTemplate record);

    @Update({
        "update card_template",
        "set parent_id = #{parentId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CardTemplate record);
}