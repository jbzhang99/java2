package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenCategoryGoodRel;
import com.rfchina.community.persistence.model.OpenCategoryGoodRelExample;
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

public interface OpenCategoryGoodRelMapper extends Serializable {
    @SelectProvider(type=OpenCategoryGoodRelSqlProvider.class, method="countByExample")
    long countByExample(OpenCategoryGoodRelExample example);

    @DeleteProvider(type=OpenCategoryGoodRelSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenCategoryGoodRelExample example);

    @Delete({
        "delete from open_category_good_rel",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_category_good_rel (good_id, show_category_id, ",
        "create_time)",
        "values (#{goodId,jdbcType=INTEGER}, #{showCategoryId,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenCategoryGoodRel record);

    @InsertProvider(type=OpenCategoryGoodRelSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenCategoryGoodRel record);

    @SelectProvider(type=OpenCategoryGoodRelSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
        @Result(column="show_category_id", property="showCategoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenCategoryGoodRel> selectByExample(OpenCategoryGoodRelExample example);

    @Select({
        "select",
        "id, good_id, show_category_id, create_time",
        "from open_category_good_rel",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
        @Result(column="show_category_id", property="showCategoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenCategoryGoodRel selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenCategoryGoodRelSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenCategoryGoodRel record, @Param("example") OpenCategoryGoodRelExample example);

    @UpdateProvider(type=OpenCategoryGoodRelSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenCategoryGoodRel record, @Param("example") OpenCategoryGoodRelExample example);

    @UpdateProvider(type=OpenCategoryGoodRelSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenCategoryGoodRel record);

    @Update({
        "update open_category_good_rel",
        "set good_id = #{goodId,jdbcType=INTEGER},",
          "show_category_id = #{showCategoryId,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenCategoryGoodRel record);
}