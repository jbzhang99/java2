package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityServiceComment;
import com.rfchina.community.persistence.model.CommunityServiceCommentExample;
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

public interface CommunityServiceCommentMapper extends Serializable {
    @SelectProvider(type=CommunityServiceCommentSqlProvider.class, method="countByExample")
    long countByExample(CommunityServiceCommentExample example);

    @DeleteProvider(type=CommunityServiceCommentSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityServiceCommentExample example);

    @Delete({
        "delete from community_service_comment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into community_service_comment (service_id, comment, ",
        "create_time, uid, ",
        "community_id)",
        "values (#{serviceId,jdbcType=INTEGER}, #{comment,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{uid,jdbcType=INTEGER}, ",
        "#{communityId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(CommunityServiceComment record);

    @InsertProvider(type=CommunityServiceCommentSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(CommunityServiceComment record);

    @SelectProvider(type=CommunityServiceCommentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER)
    })
    List<CommunityServiceComment> selectByExample(CommunityServiceCommentExample example);

    @Select({
        "select",
        "id, service_id, comment, create_time, uid, community_id",
        "from community_service_comment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER)
    })
    CommunityServiceComment selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CommunityServiceCommentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityServiceComment record, @Param("example") CommunityServiceCommentExample example);

    @UpdateProvider(type=CommunityServiceCommentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityServiceComment record, @Param("example") CommunityServiceCommentExample example);

    @UpdateProvider(type=CommunityServiceCommentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityServiceComment record);

    @Update({
        "update community_service_comment",
        "set service_id = #{serviceId,jdbcType=INTEGER},",
          "comment = #{comment,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "uid = #{uid,jdbcType=INTEGER},",
          "community_id = #{communityId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommunityServiceComment record);
}