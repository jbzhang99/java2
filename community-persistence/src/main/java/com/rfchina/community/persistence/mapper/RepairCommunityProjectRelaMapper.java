package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.RepairCommunityProjectRelaExample;
import com.rfchina.community.persistence.model.RepairCommunityProjectRelaKey;
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

public interface RepairCommunityProjectRelaMapper extends Serializable {
    @SelectProvider(type=RepairCommunityProjectRelaSqlProvider.class, method="countByExample")
    long countByExample(RepairCommunityProjectRelaExample example);

    @DeleteProvider(type=RepairCommunityProjectRelaSqlProvider.class, method="deleteByExample")
    int deleteByExample(RepairCommunityProjectRelaExample example);

    @Delete({
        "delete from repair_community_project_rela",
        "where community_id = #{communityId,jdbcType=INTEGER}",
          "and project_id = #{projectId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(RepairCommunityProjectRelaKey key);

    @Insert({
        "insert into repair_community_project_rela (community_id, project_id)",
        "values (#{communityId,jdbcType=INTEGER}, #{projectId,jdbcType=VARCHAR})"
    })
    int insert(RepairCommunityProjectRelaKey record);

    @InsertProvider(type=RepairCommunityProjectRelaSqlProvider.class, method="insertSelective")
    int insertSelective(RepairCommunityProjectRelaKey record);

    @SelectProvider(type=RepairCommunityProjectRelaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="project_id", property="projectId", jdbcType=JdbcType.VARCHAR, id=true)
    })
    List<RepairCommunityProjectRelaKey> selectByExample(RepairCommunityProjectRelaExample example);

    @UpdateProvider(type=RepairCommunityProjectRelaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RepairCommunityProjectRelaKey record, @Param("example") RepairCommunityProjectRelaExample example);

    @UpdateProvider(type=RepairCommunityProjectRelaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RepairCommunityProjectRelaKey record, @Param("example") RepairCommunityProjectRelaExample example);
}