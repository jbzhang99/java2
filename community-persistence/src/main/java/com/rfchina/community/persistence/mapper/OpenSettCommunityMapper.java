package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenSettCommunity;
import com.rfchina.community.persistence.model.OpenSettCommunityExample;
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

public interface OpenSettCommunityMapper extends Serializable {
    @SelectProvider(type=OpenSettCommunitySqlProvider.class, method="countByExample")
    long countByExample(OpenSettCommunityExample example);

    @DeleteProvider(type=OpenSettCommunitySqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenSettCommunityExample example);

    @Delete({
        "delete from open_sett_community",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into open_sett_community (community_id, start_time, ",
        "end_time, mch_id, ",
        "account_id, status, ",
        "pf_status, title, ",
        "create_time, amount, ",
        "audit_comment, set_id)",
        "values (#{communityId,jdbcType=INTEGER}, #{startTime,jdbcType=TIMESTAMP}, ",
        "#{endTime,jdbcType=TIMESTAMP}, #{mchId,jdbcType=VARCHAR}, ",
        "#{accountId,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{pfStatus,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{amount,jdbcType=BIGINT}, ",
        "#{auditComment,jdbcType=VARCHAR}, #{setId,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(OpenSettCommunity record);

    @InsertProvider(type=OpenSettCommunitySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(OpenSettCommunity record);

    @SelectProvider(type=OpenSettCommunitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="mch_id", property="mchId", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="pf_status", property="pfStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="amount", property="amount", jdbcType=JdbcType.BIGINT),
        @Result(column="audit_comment", property="auditComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="set_id", property="setId", jdbcType=JdbcType.VARCHAR)
    })
    List<OpenSettCommunity> selectByExample(OpenSettCommunityExample example);

    @Select({
        "select",
        "id, community_id, start_time, end_time, mch_id, account_id, status, pf_status, ",
        "title, create_time, amount, audit_comment, set_id",
        "from open_sett_community",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="mch_id", property="mchId", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="pf_status", property="pfStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="amount", property="amount", jdbcType=JdbcType.BIGINT),
        @Result(column="audit_comment", property="auditComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="set_id", property="setId", jdbcType=JdbcType.VARCHAR)
    })
    OpenSettCommunity selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OpenSettCommunitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenSettCommunity record, @Param("example") OpenSettCommunityExample example);

    @UpdateProvider(type=OpenSettCommunitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenSettCommunity record, @Param("example") OpenSettCommunityExample example);

    @UpdateProvider(type=OpenSettCommunitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenSettCommunity record);

    @Update({
        "update open_sett_community",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "mch_id = #{mchId,jdbcType=VARCHAR},",
          "account_id = #{accountId,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "pf_status = #{pfStatus,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "amount = #{amount,jdbcType=BIGINT},",
          "audit_comment = #{auditComment,jdbcType=VARCHAR},",
          "set_id = #{setId,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenSettCommunity record);
}