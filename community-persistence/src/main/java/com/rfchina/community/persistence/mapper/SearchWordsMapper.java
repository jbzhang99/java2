package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SearchWords;
import com.rfchina.community.persistence.model.SearchWordsExample;
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
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SearchWordsMapper extends Serializable {
    @SelectProvider(type=SearchWordsSqlProvider.class, method="countByExample")
    long countByExample(SearchWordsExample example);

    @DeleteProvider(type=SearchWordsSqlProvider.class, method="deleteByExample")
    int deleteByExample(SearchWordsExample example);

    @Delete({
        "delete from search_words",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into search_words (id, words, ",
        "remark, status, ",
        "create_time)",
        "values (#{id,jdbcType=INTEGER}, #{words,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(SearchWords record);

    @InsertProvider(type=SearchWordsSqlProvider.class, method="insertSelective")
    int insertSelective(SearchWords record);

    @SelectProvider(type=SearchWordsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="words", property="words", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SearchWords> selectByExample(SearchWordsExample example);

    @Select({
        "select",
        "id, words, remark, status, create_time",
        "from search_words",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="words", property="words", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SearchWords selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SearchWordsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SearchWords record, @Param("example") SearchWordsExample example);

    @UpdateProvider(type=SearchWordsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SearchWords record, @Param("example") SearchWordsExample example);

    @UpdateProvider(type=SearchWordsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SearchWords record);

    @Update({
        "update search_words",
        "set words = #{words,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SearchWords record);
}