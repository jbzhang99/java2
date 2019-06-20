package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityFile;
import com.rfchina.community.persistence.model.CommunityFileExample;
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

public interface CommunityFileMapper extends Serializable {
    @SelectProvider(type=CommunityFileSqlProvider.class, method="countByExample")
    long countByExample(CommunityFileExample example);

    @DeleteProvider(type=CommunityFileSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityFileExample example);

    @Delete({
        "delete from community_file",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into community_file (community_id, name, ",
        "file_url, type, remark, ",
        "create_time)",
        "values (#{communityId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{fileUrl,jdbcType=VARCHAR}, #{type,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CommunityFile record);

    @InsertProvider(type=CommunityFileSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CommunityFile record);

    @SelectProvider(type=CommunityFileSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_url", property="fileUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CommunityFile> selectByExample(CommunityFileExample example);

    @Select({
        "select",
        "id, community_id, name, file_url, type, remark, create_time",
        "from community_file",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_url", property="fileUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CommunityFile selectByPrimaryKey(Long id);

    @UpdateProvider(type=CommunityFileSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityFile record, @Param("example") CommunityFileExample example);

    @UpdateProvider(type=CommunityFileSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityFile record, @Param("example") CommunityFileExample example);

    @UpdateProvider(type=CommunityFileSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityFile record);

    @Update({
        "update community_file",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "file_url = #{fileUrl,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommunityFile record);
}