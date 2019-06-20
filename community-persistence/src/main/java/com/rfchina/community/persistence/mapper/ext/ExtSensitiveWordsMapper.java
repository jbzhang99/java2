package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.model.SensitiveWords;
import com.rfchina.community.persistence.model.SensitiveWordsExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.util.List;

public interface ExtSensitiveWordsMapper {

    @SelectProvider(type=ExtSensitiveWordsSqlProvider.class, method="pageByExample")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
            @Result(column="words", property="words", jdbcType=JdbcType.VARCHAR),
            @Result(column="rpl_words", property="rplWords", jdbcType=JdbcType.VARCHAR)
    })
    PageList<SensitiveWords> pageByExample(@Param("example") SensitiveWordsExample example, PageBounds pageBounds);

    @Select("SELECT DISTINCT community_id FROM sensitive_words ")
    List<Integer> selectCommunityIdList();
}
