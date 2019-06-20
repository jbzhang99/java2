package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SensitiveWords;
import com.rfchina.community.persistence.model.SensitiveWordsExample;
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

public interface SensitiveWordsMapper extends Serializable {
    @SelectProvider(type=SensitiveWordsSqlProvider.class, method="countByExample")
    long countByExample(SensitiveWordsExample example);

    @DeleteProvider(type=SensitiveWordsSqlProvider.class, method="deleteByExample")
    int deleteByExample(SensitiveWordsExample example);

    @Delete({
        "delete from sensitive_words",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sensitive_words (community_id, words, ",
        "rpl_words, create_time, ",
        "update_time)",
        "values (#{communityId,jdbcType=INTEGER}, #{words,jdbcType=VARCHAR}, ",
        "#{rplWords,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(SensitiveWords record);

    @InsertProvider(type=SensitiveWordsSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(SensitiveWords record);

    @SelectProvider(type=SensitiveWordsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="words", property="words", jdbcType=JdbcType.VARCHAR),
        @Result(column="rpl_words", property="rplWords", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SensitiveWords> selectByExample(SensitiveWordsExample example);

    @Select({
        "select",
        "id, community_id, words, rpl_words, create_time, update_time",
        "from sensitive_words",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="words", property="words", jdbcType=JdbcType.VARCHAR),
        @Result(column="rpl_words", property="rplWords", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SensitiveWords selectByPrimaryKey(Long id);

    @UpdateProvider(type=SensitiveWordsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SensitiveWords record, @Param("example") SensitiveWordsExample example);

    @UpdateProvider(type=SensitiveWordsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SensitiveWords record, @Param("example") SensitiveWordsExample example);

    @UpdateProvider(type=SensitiveWordsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SensitiveWords record);

    @Update({
        "update sensitive_words",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "words = #{words,jdbcType=VARCHAR},",
          "rpl_words = #{rplWords,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SensitiveWords record);
}