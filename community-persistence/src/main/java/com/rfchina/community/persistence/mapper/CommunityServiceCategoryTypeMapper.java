package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityServiceCategoryType;
import com.rfchina.community.persistence.model.CommunityServiceCategoryTypeExample;
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

public interface CommunityServiceCategoryTypeMapper extends Serializable {
    @SelectProvider(type=CommunityServiceCategoryTypeSqlProvider.class, method="countByExample")
    long countByExample(CommunityServiceCategoryTypeExample example);

    @DeleteProvider(type=CommunityServiceCategoryTypeSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityServiceCategoryTypeExample example);

    @Delete({
        "delete from community_service_category_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into community_service_category_type (id, name, ",
        "valid_status)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{validStatus,jdbcType=INTEGER})"
    })
    int insert(CommunityServiceCategoryType record);

    @InsertProvider(type=CommunityServiceCategoryTypeSqlProvider.class, method="insertSelective")
    int insertSelective(CommunityServiceCategoryType record);

    @SelectProvider(type=CommunityServiceCategoryTypeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="valid_status", property="validStatus", jdbcType=JdbcType.INTEGER)
    })
    List<CommunityServiceCategoryType> selectByExample(CommunityServiceCategoryTypeExample example);

    @Select({
        "select",
        "id, name, valid_status",
        "from community_service_category_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="valid_status", property="validStatus", jdbcType=JdbcType.INTEGER)
    })
    CommunityServiceCategoryType selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CommunityServiceCategoryTypeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityServiceCategoryType record, @Param("example") CommunityServiceCategoryTypeExample example);

    @UpdateProvider(type=CommunityServiceCategoryTypeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityServiceCategoryType record, @Param("example") CommunityServiceCategoryTypeExample example);

    @UpdateProvider(type=CommunityServiceCategoryTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityServiceCategoryType record);

    @Update({
        "update community_service_category_type",
        "set name = #{name,jdbcType=VARCHAR},",
          "valid_status = #{validStatus,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommunityServiceCategoryType record);
}