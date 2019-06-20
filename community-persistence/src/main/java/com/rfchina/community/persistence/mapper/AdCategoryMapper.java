package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.AdCategory;
import com.rfchina.community.persistence.model.AdCategoryExample;
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

public interface AdCategoryMapper extends Serializable {
    @SelectProvider(type=AdCategorySqlProvider.class, method="countByExample")
    long countByExample(AdCategoryExample example);

    @DeleteProvider(type=AdCategorySqlProvider.class, method="deleteByExample")
    int deleteByExample(AdCategoryExample example);

    @Delete({
        "delete from ad_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ad_category (name, intro, ",
        "status, width, height, ",
        "reason, audit_time, ",
        "create_time, update_time)",
        "values (#{name,jdbcType=VARCHAR}, #{intro,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=TINYINT}, #{width,jdbcType=INTEGER}, #{height,jdbcType=INTEGER}, ",
        "#{reason,jdbcType=VARCHAR}, #{auditTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(AdCategory record);

    @InsertProvider(type=AdCategorySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(AdCategory record);

    @SelectProvider(type=AdCategorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="width", property="width", jdbcType=JdbcType.INTEGER),
        @Result(column="height", property="height", jdbcType=JdbcType.INTEGER),
        @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AdCategory> selectByExample(AdCategoryExample example);

    @Select({
        "select",
        "id, name, intro, status, width, height, reason, audit_time, create_time, update_time",
        "from ad_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="width", property="width", jdbcType=JdbcType.INTEGER),
        @Result(column="height", property="height", jdbcType=JdbcType.INTEGER),
        @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    AdCategory selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AdCategorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AdCategory record, @Param("example") AdCategoryExample example);

    @UpdateProvider(type=AdCategorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AdCategory record, @Param("example") AdCategoryExample example);

    @UpdateProvider(type=AdCategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AdCategory record);

    @Update({
        "update ad_category",
        "set name = #{name,jdbcType=VARCHAR},",
          "intro = #{intro,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "width = #{width,jdbcType=INTEGER},",
          "height = #{height,jdbcType=INTEGER},",
          "reason = #{reason,jdbcType=VARCHAR},",
          "audit_time = #{auditTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AdCategory record);
}