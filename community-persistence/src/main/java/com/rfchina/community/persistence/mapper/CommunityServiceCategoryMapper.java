package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityServiceCategory;
import com.rfchina.community.persistence.model.CommunityServiceCategoryExample;
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

public interface CommunityServiceCategoryMapper extends BaseMapper<CommunityServiceCategory, CommunityServiceCategoryExample,Long> {
    @SelectProvider(type=CommunityServiceCategorySqlProvider.class, method="countByExample")
    long countByExample(CommunityServiceCategoryExample example);

    @DeleteProvider(type=CommunityServiceCategorySqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityServiceCategoryExample example);

    @Delete({
        "delete from community_service_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into community_service_category (name, create_time, ",
        "type, sort, exposure, ",
        "pid, link, png, ",
        "community_fee, premium_num, ",
        "valid_status)",
        "values (#{name,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{type,jdbcType=INTEGER}, #{sort,jdbcType=INTEGER}, #{exposure,jdbcType=INTEGER}, ",
        "#{pid,jdbcType=INTEGER}, #{link,jdbcType=VARCHAR}, #{png,jdbcType=VARCHAR}, ",
        "#{communityFee,jdbcType=DECIMAL}, #{premiumNum,jdbcType=INTEGER}, ",
        "#{validStatus,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(CommunityServiceCategory record);

    @InsertProvider(type=CommunityServiceCategorySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(CommunityServiceCategory record);

    @SelectProvider(type=CommunityServiceCategorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="exposure", property="exposure", jdbcType=JdbcType.INTEGER),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="link", property="link", jdbcType=JdbcType.VARCHAR),
        @Result(column="png", property="png", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_fee", property="communityFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="premium_num", property="premiumNum", jdbcType=JdbcType.INTEGER),
        @Result(column="valid_status", property="validStatus", jdbcType=JdbcType.INTEGER)
    })
    List<CommunityServiceCategory> selectByExample(CommunityServiceCategoryExample example);

    @Select({
        "select",
        "id, name, create_time, type, sort, exposure, pid, link, png, community_fee, ",
        "premium_num, valid_status",
        "from community_service_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="exposure", property="exposure", jdbcType=JdbcType.INTEGER),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="link", property="link", jdbcType=JdbcType.VARCHAR),
        @Result(column="png", property="png", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_fee", property="communityFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="premium_num", property="premiumNum", jdbcType=JdbcType.INTEGER),
        @Result(column="valid_status", property="validStatus", jdbcType=JdbcType.INTEGER)
    })
    CommunityServiceCategory selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CommunityServiceCategorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityServiceCategory record, @Param("example") CommunityServiceCategoryExample example);

    @UpdateProvider(type=CommunityServiceCategorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityServiceCategory record, @Param("example") CommunityServiceCategoryExample example);

    @UpdateProvider(type=CommunityServiceCategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityServiceCategory record);

    @Update({
        "update community_service_category",
        "set name = #{name,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "type = #{type,jdbcType=INTEGER},",
          "sort = #{sort,jdbcType=INTEGER},",
          "exposure = #{exposure,jdbcType=INTEGER},",
          "pid = #{pid,jdbcType=INTEGER},",
          "link = #{link,jdbcType=VARCHAR},",
          "png = #{png,jdbcType=VARCHAR},",
          "community_fee = #{communityFee,jdbcType=DECIMAL},",
          "premium_num = #{premiumNum,jdbcType=INTEGER},",
          "valid_status = #{validStatus,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommunityServiceCategory record);

    @Select({
            "select * from community_service_category csc where csc.id = (select cs.category_id from community_service cs where cs.id= #{serviceId,jdbcType=INTEGER}) " +
             "UNION " +
             "select * from community_service_category csc where csc.id = (select csd.category_second_type from open_service_detail csd where csd.service_id= #{serviceId,jdbcType=INTEGER}) "
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
            @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
            @Result(column="exposure", property="exposure", jdbcType=JdbcType.INTEGER),
            @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
            @Result(column="link", property="link", jdbcType=JdbcType.VARCHAR),
            @Result(column="png", property="png", jdbcType=JdbcType.VARCHAR),
            @Result(column="community_fee", property="communityFee", jdbcType=JdbcType.DECIMAL),
            @Result(column="premium_num", property="premiumNum", jdbcType=JdbcType.INTEGER),
            @Result(column="valid_status", property="validStatus", jdbcType=JdbcType.INTEGER)
    })
    List<CommunityServiceCategory> getCommunityServiceCategoryByServiceId(Integer serviceId);
}