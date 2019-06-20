package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.Visit4Blacklist;
import com.rfchina.community.persistence.model.Visit4BlacklistExample;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface Visit4BlacklistMapper extends Serializable {
    @SelectProvider(type=Visit4BlacklistSqlProvider.class, method="countByExample")
    long countByExample(Visit4BlacklistExample example);

    @DeleteProvider(type=Visit4BlacklistSqlProvider.class, method="deleteByExample")
    int deleteByExample(Visit4BlacklistExample example);

    @Insert({
        "insert into visit4_blacklist (community_id, target_id, ",
        "target_type, target_status, ",
        "create_time)",
        "values (#{communityId,jdbcType=INTEGER}, #{targetId,jdbcType=BIGINT}, ",
        "#{targetType,jdbcType=TINYINT}, #{targetStatus,jdbcType=TINYINT}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(Visit4Blacklist record);

    @InsertProvider(type=Visit4BlacklistSqlProvider.class, method="insertSelective")
    int insertSelective(Visit4Blacklist record);

    @SelectProvider(type=Visit4BlacklistSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="target_id", property="targetId", jdbcType=JdbcType.BIGINT),
        @Result(column="target_type", property="targetType", jdbcType=JdbcType.TINYINT),
        @Result(column="target_status", property="targetStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Visit4Blacklist> selectByExample(Visit4BlacklistExample example);

    @UpdateProvider(type=Visit4BlacklistSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Visit4Blacklist record, @Param("example") Visit4BlacklistExample example);

    @UpdateProvider(type=Visit4BlacklistSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Visit4Blacklist record, @Param("example") Visit4BlacklistExample example);
}