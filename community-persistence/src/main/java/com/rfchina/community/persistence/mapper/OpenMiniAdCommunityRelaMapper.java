package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenMiniAdCommunityRela;
import com.rfchina.community.persistence.model.OpenMiniAdCommunityRelaExample;
import com.rfchina.community.persistence.model.OpenMiniAdCommunityRelaKey;
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

public interface OpenMiniAdCommunityRelaMapper extends Serializable {
    @SelectProvider(type=OpenMiniAdCommunityRelaSqlProvider.class, method="countByExample")
    long countByExample(OpenMiniAdCommunityRelaExample example);

    @DeleteProvider(type=OpenMiniAdCommunityRelaSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenMiniAdCommunityRelaExample example);

    @Delete({
        "delete from open_mini_ad_community_rela",
        "where ad_id = #{adId,jdbcType=BIGINT}",
          "and community_id = #{communityId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(OpenMiniAdCommunityRelaKey key);

    @Insert({
        "insert into open_mini_ad_community_rela (ad_id, community_id, ",
        "create_time)",
        "values (#{adId,jdbcType=BIGINT}, #{communityId,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(OpenMiniAdCommunityRela record);

    @InsertProvider(type=OpenMiniAdCommunityRelaSqlProvider.class, method="insertSelective")
    int insertSelective(OpenMiniAdCommunityRela record);

    @SelectProvider(type=OpenMiniAdCommunityRelaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ad_id", property="adId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenMiniAdCommunityRela> selectByExample(OpenMiniAdCommunityRelaExample example);

    @Select({
        "select",
        "ad_id, community_id, create_time",
        "from open_mini_ad_community_rela",
        "where ad_id = #{adId,jdbcType=BIGINT}",
          "and community_id = #{communityId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ad_id", property="adId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenMiniAdCommunityRela selectByPrimaryKey(OpenMiniAdCommunityRelaKey key);

    @UpdateProvider(type=OpenMiniAdCommunityRelaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenMiniAdCommunityRela record, @Param("example") OpenMiniAdCommunityRelaExample example);

    @UpdateProvider(type=OpenMiniAdCommunityRelaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenMiniAdCommunityRela record, @Param("example") OpenMiniAdCommunityRelaExample example);

    @UpdateProvider(type=OpenMiniAdCommunityRelaSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenMiniAdCommunityRela record);

    @Update({
        "update open_mini_ad_community_rela",
        "set create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where ad_id = #{adId,jdbcType=BIGINT}",
          "and community_id = #{communityId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenMiniAdCommunityRela record);
}