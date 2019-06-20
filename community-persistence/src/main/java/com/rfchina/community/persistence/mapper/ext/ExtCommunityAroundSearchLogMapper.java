package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.CommunityAroundSearchLogMapper;
import com.rfchina.community.persistence.model.CommunityAroundSearchLog;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ExtCommunityAroundSearchLogMapper extends CommunityAroundSearchLogMapper {

    @Select({
            "select",
            "search_key",
            "from community_around_search_log",
            "where  status = 1 and id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column="search_key", property="searchKey", jdbcType=JdbcType.VARCHAR)
    })
    List<CommunityAroundSearchLog> getUserSearchLog(Long uid);
}