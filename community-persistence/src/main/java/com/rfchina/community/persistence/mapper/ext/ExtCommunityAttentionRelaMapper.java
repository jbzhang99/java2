package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.entity.AttentionSim;
import com.rfchina.community.persistence.model.Community;
import com.rfchina.community.persistence.model.CommunityAttention;
import com.rfchina.community.persistence.model.CommunityAttentionExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;


/**
 */
public interface ExtCommunityAttentionRelaMapper {

    @Select({
            " select count(a.community_id) from master_child a ",
            " where a.uid = #{uid, jdbcType=BIGINT}"
    })
    Long countMasterChildAttentionByUid(@Param("uid") Long uid);

    @Select({
            " select count(a.community_id) from community_attention a ",
//            " where not exists (select b.uid from master_child b where a.uid = b.uid) ",
            " where a.uid = #{uid, jdbcType=BIGINT} "
    })
    Long countCommunityAttentionByUid(@Param("uid") Long uid);

    @SelectProvider(type=ExtCommunityAttentionSqlProvider.class, method="pageByExample")
    @Results({
            @Result(column="uid", property="uid", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="idx_seq", property="idxSeq", jdbcType=JdbcType.BIGINT),
            @Result(column="add_type", property="addType", jdbcType=JdbcType.INTEGER)
    })
    PageList<CommunityAttention> pageByExample(CommunityAttentionExample example, PageBounds pageBounds);

    @Select({
            " select a.community_id as id, concat(b.name,'(', c.loudong, '-', c.floor, '-', c.room, ')') as name, a.create_time as attention_time from master_child a ",
            " join community b on a.community_id = b .id ",
            " join master_info c on a.master_id = c.id ",
            " where a.uid = #{uid, jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="attention_time", property="attentionTime", jdbcType=JdbcType.TIMESTAMP)
    })
    PageList<AttentionSim> getMasterChildAttentionList(@Param("uid") Long uid, PageBounds pageBounds);

    @Select({
            " select a.community_id as id, b.name, a.create_time as attention_time from community_attention a ",
            " join community b on a.community_id = b .id ",
//            " where not exists (select c.id from master_child c where c.uid = a.uid and c.community_id = a.community_id)",
            " where a.uid = #{uid, jdbcType=BIGINT}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="attention_time", property="attentionTime", jdbcType=JdbcType.TIMESTAMP)
    })
    PageList<AttentionSim> getCommunityAttentionList(@Param("uid") Long uid, PageBounds pageBounds);
}

