package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.CommunityPicMapper;
import com.rfchina.community.persistence.mapper.CommunityPicSqlProvider;
import com.rfchina.community.persistence.model.CommunityPic;
import com.rfchina.community.persistence.model.CommunityPicExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.util.List;

/**
 * @ClassName ExtCommunityPicMapper
 * @Author wlrllr
 * @Date 2019/4/24 10:24
 * @Version 1.0
 **/
public interface ExtCommunityPicMapper extends CommunityPicMapper {

    @InsertProvider(type = ExtCommunityPicSqlProvider.class, method = "batchInsert")
    void batchInsert(List<CommunityPic> list);

    @Select({
            "select",
            "id, target_id, pic_url, status",
            "from community_pic",
            "where status = #{status}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="target_id", property="targetId", jdbcType=JdbcType.BIGINT),
            @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    PageList<CommunityPic> page(@Param("status") Integer status, PageBounds pageBounds);
}
