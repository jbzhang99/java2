package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenGoodShowCategory;
import com.rfchina.community.persistence.model.OpenGoodShowCategoryExample;
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

public interface OpenGoodShowCategoryMapper extends Serializable {
    @SelectProvider(type=OpenGoodShowCategorySqlProvider.class, method="countByExample")
    long countByExample(OpenGoodShowCategoryExample example);

    @DeleteProvider(type=OpenGoodShowCategorySqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenGoodShowCategoryExample example);

    @Delete({
        "delete from open_good_show_category",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_good_show_category (service_id, category_name, ",
        "pic_url, pic_info, ",
        "sorting, is_show, ",
        "remark, create_time, ",
        "update_time)",
        "values (#{serviceId,jdbcType=INTEGER}, #{categoryName,jdbcType=VARCHAR}, ",
        "#{picUrl,jdbcType=VARCHAR}, #{picInfo,jdbcType=VARCHAR}, ",
        "#{sorting,jdbcType=INTEGER}, #{isShow,jdbcType=INTEGER}, ",
        "#{remark,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenGoodShowCategory record);

    @InsertProvider(type=OpenGoodShowCategorySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenGoodShowCategory record);

    @SelectProvider(type=OpenGoodShowCategorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="category_name", property="categoryName", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic_info", property="picInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="sorting", property="sorting", jdbcType=JdbcType.INTEGER),
        @Result(column="is_show", property="isShow", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenGoodShowCategory> selectByExample(OpenGoodShowCategoryExample example);

    @Select({
        "select",
        "id, service_id, category_name, pic_url, pic_info, sorting, is_show, remark, ",
        "create_time, update_time",
        "from open_good_show_category",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="category_name", property="categoryName", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic_info", property="picInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="sorting", property="sorting", jdbcType=JdbcType.INTEGER),
        @Result(column="is_show", property="isShow", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenGoodShowCategory selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenGoodShowCategorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenGoodShowCategory record, @Param("example") OpenGoodShowCategoryExample example);

    @UpdateProvider(type=OpenGoodShowCategorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenGoodShowCategory record, @Param("example") OpenGoodShowCategoryExample example);

    @UpdateProvider(type=OpenGoodShowCategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenGoodShowCategory record);

    @Update({
        "update open_good_show_category",
        "set service_id = #{serviceId,jdbcType=INTEGER},",
          "category_name = #{categoryName,jdbcType=VARCHAR},",
          "pic_url = #{picUrl,jdbcType=VARCHAR},",
          "pic_info = #{picInfo,jdbcType=VARCHAR},",
          "sorting = #{sorting,jdbcType=INTEGER},",
          "is_show = #{isShow,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenGoodShowCategory record);
}