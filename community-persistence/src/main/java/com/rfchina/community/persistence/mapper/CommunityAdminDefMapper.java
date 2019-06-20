package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityAdminDef;
import com.rfchina.community.persistence.model.CommunityAdminDefExample;
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

public interface CommunityAdminDefMapper extends Serializable {
    @SelectProvider(type=CommunityAdminDefSqlProvider.class, method="countByExample")
    long countByExample(CommunityAdminDefExample example);

    @DeleteProvider(type=CommunityAdminDefSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityAdminDefExample example);

    @Delete({
        "delete from community_admin_def",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into community_admin_def (id, def_community_id, ",
        "create_time, update_time)",
        "values (#{id,jdbcType=BIGINT}, #{defCommunityId,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(CommunityAdminDef record);

    @InsertProvider(type=CommunityAdminDefSqlProvider.class, method="insertSelective")
    int insertSelective(CommunityAdminDef record);

    @SelectProvider(type=CommunityAdminDefSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="def_community_id", property="defCommunityId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CommunityAdminDef> selectByExample(CommunityAdminDefExample example);

    @Select({
        "select",
        "id, def_community_id, create_time, update_time",
        "from community_admin_def",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="def_community_id", property="defCommunityId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CommunityAdminDef selectByPrimaryKey(Long id);

    @UpdateProvider(type=CommunityAdminDefSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityAdminDef record, @Param("example") CommunityAdminDefExample example);

    @UpdateProvider(type=CommunityAdminDefSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityAdminDef record, @Param("example") CommunityAdminDefExample example);

    @UpdateProvider(type=CommunityAdminDefSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityAdminDef record);

    @Update({
        "update community_admin_def",
        "set def_community_id = #{defCommunityId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommunityAdminDef record);
}