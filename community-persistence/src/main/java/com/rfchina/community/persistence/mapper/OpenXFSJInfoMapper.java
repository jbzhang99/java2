package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenXFSJInfo;
import com.rfchina.community.persistence.model.OpenXFSJInfoExample;
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

public interface OpenXFSJInfoMapper extends Serializable {
    @SelectProvider(type=OpenXFSJInfoSqlProvider.class, method="countByExample")
    long countByExample(OpenXFSJInfoExample example);

    @DeleteProvider(type=OpenXFSJInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenXFSJInfoExample example);

    @Delete({
        "delete from open_xfsj_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_xfsj_info (type, category_id, ",
        "community_id, act_titile, ",
        "act_address, act_time, ",
        "act_img, act_url, ",
        "status, create_time, ",
        "create_uid, begin_time, ",
        "end_time, group_config_id, ",
        "area_config_id)",
        "values (#{type,jdbcType=VARCHAR}, #{categoryId,jdbcType=INTEGER}, ",
        "#{communityId,jdbcType=INTEGER}, #{actTitile,jdbcType=VARCHAR}, ",
        "#{actAddress,jdbcType=VARCHAR}, #{actTime,jdbcType=VARCHAR}, ",
        "#{actImg,jdbcType=VARCHAR}, #{actUrl,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{createUid,jdbcType=BIGINT}, #{beginTime,jdbcType=TIMESTAMP}, ",
        "#{endTime,jdbcType=TIMESTAMP}, #{groupConfigId,jdbcType=BIGINT}, ",
        "#{areaConfigId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenXFSJInfo record);

    @InsertProvider(type=OpenXFSJInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenXFSJInfo record);

    @SelectProvider(type=OpenXFSJInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="act_titile", property="actTitile", jdbcType=JdbcType.VARCHAR),
        @Result(column="act_address", property="actAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="act_time", property="actTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="act_img", property="actImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="act_url", property="actUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT),
        @Result(column="begin_time", property="beginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="group_config_id", property="groupConfigId", jdbcType=JdbcType.BIGINT),
        @Result(column="area_config_id", property="areaConfigId", jdbcType=JdbcType.BIGINT)
    })
    List<OpenXFSJInfo> selectByExample(OpenXFSJInfoExample example);

    @Select({
        "select",
        "id, type, category_id, community_id, act_titile, act_address, act_time, act_img, ",
        "act_url, status, create_time, create_uid, begin_time, end_time, group_config_id, ",
        "area_config_id",
        "from open_xfsj_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="act_titile", property="actTitile", jdbcType=JdbcType.VARCHAR),
        @Result(column="act_address", property="actAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="act_time", property="actTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="act_img", property="actImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="act_url", property="actUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT),
        @Result(column="begin_time", property="beginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="group_config_id", property="groupConfigId", jdbcType=JdbcType.BIGINT),
        @Result(column="area_config_id", property="areaConfigId", jdbcType=JdbcType.BIGINT)
    })
    OpenXFSJInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenXFSJInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenXFSJInfo record, @Param("example") OpenXFSJInfoExample example);

    @UpdateProvider(type=OpenXFSJInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenXFSJInfo record, @Param("example") OpenXFSJInfoExample example);

    @UpdateProvider(type=OpenXFSJInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenXFSJInfo record);

    @Update({
        "update open_xfsj_info",
        "set type = #{type,jdbcType=VARCHAR},",
          "category_id = #{categoryId,jdbcType=INTEGER},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "act_titile = #{actTitile,jdbcType=VARCHAR},",
          "act_address = #{actAddress,jdbcType=VARCHAR},",
          "act_time = #{actTime,jdbcType=VARCHAR},",
          "act_img = #{actImg,jdbcType=VARCHAR},",
          "act_url = #{actUrl,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_uid = #{createUid,jdbcType=BIGINT},",
          "begin_time = #{beginTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "group_config_id = #{groupConfigId,jdbcType=BIGINT},",
          "area_config_id = #{areaConfigId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenXFSJInfo record);
}