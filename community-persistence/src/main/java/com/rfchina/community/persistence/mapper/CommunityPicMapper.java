package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityPic;
import com.rfchina.community.persistence.model.CommunityPicExample;
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

public interface CommunityPicMapper extends BaseMapper {
    @SelectProvider(type=CommunityPicSqlProvider.class, method="countByExample")
    long countByExample(CommunityPicExample example);

    @DeleteProvider(type=CommunityPicSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityPicExample example);

    @Delete({
        "delete from community_pic",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into community_pic (target_id, pic_url, ",
        "status)",
        "values (#{targetId,jdbcType=BIGINT}, #{picUrl,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CommunityPic record);

    @InsertProvider(type=CommunityPicSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CommunityPic record);

    @SelectProvider(type=CommunityPicSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="target_id", property="targetId", jdbcType=JdbcType.BIGINT),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<CommunityPic> selectByExample(CommunityPicExample example);

    @Select({
        "select",
        "id, target_id, pic_url, status",
        "from community_pic",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="target_id", property="targetId", jdbcType=JdbcType.BIGINT),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    CommunityPic selectByPrimaryKey(Long id);

    @UpdateProvider(type=CommunityPicSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityPic record, @Param("example") CommunityPicExample example);

    @UpdateProvider(type=CommunityPicSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityPic record, @Param("example") CommunityPicExample example);

    @UpdateProvider(type=CommunityPicSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityPic record);

    @Update({
        "update community_pic",
        "set target_id = #{targetId,jdbcType=BIGINT},",
          "pic_url = #{picUrl,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommunityPic record);
}