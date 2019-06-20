package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityAdminRelaExample;
import com.rfchina.community.persistence.model.CommunityAdminRelaKey;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CommunityAdminRelaMapper extends Serializable {
    @SelectProvider(type=CommunityAdminRelaSqlProvider.class, method="countByExample")
    long countByExample(CommunityAdminRelaExample example);

    @DeleteProvider(type=CommunityAdminRelaSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityAdminRelaExample example);

    @Delete({
        "delete from community_admin_rela",
        "where community_id = #{communityId,jdbcType=INTEGER}",
          "and admin_id = #{adminId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(CommunityAdminRelaKey key);

    @Insert({
        "insert into community_admin_rela (community_id, admin_id)",
        "values (#{communityId,jdbcType=INTEGER}, #{adminId,jdbcType=BIGINT})"
    })
    int insert(CommunityAdminRelaKey record);

    @InsertProvider(type=CommunityAdminRelaSqlProvider.class, method="insertSelective")
    int insertSelective(CommunityAdminRelaKey record);

    @SelectProvider(type=CommunityAdminRelaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="admin_id", property="adminId", jdbcType=JdbcType.BIGINT, id=true)
    })
    List<CommunityAdminRelaKey> selectByExample(CommunityAdminRelaExample example);

    @UpdateProvider(type=CommunityAdminRelaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityAdminRelaKey record, @Param("example") CommunityAdminRelaExample example);

    @UpdateProvider(type=CommunityAdminRelaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityAdminRelaKey record, @Param("example") CommunityAdminRelaExample example);
}