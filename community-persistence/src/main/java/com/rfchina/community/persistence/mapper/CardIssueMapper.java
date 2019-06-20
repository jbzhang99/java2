package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CardIssue;
import com.rfchina.community.persistence.model.CardIssueExample;
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

public interface CardIssueMapper extends Serializable {
    @SelectProvider(type=CardIssueSqlProvider.class, method="countByExample")
    long countByExample(CardIssueExample example);

    @DeleteProvider(type=CardIssueSqlProvider.class, method="deleteByExample")
    int deleteByExample(CardIssueExample example);

    @Delete({
        "delete from card_issue",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into card_issue (card_id, uid, ",
        "status, issue, create_time)",
        "values (#{cardId,jdbcType=BIGINT}, #{uid,jdbcType=BIGINT}, ",
        "#{status,jdbcType=INTEGER}, #{issue,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CardIssue record);

    @InsertProvider(type=CardIssueSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CardIssue record);

    @SelectProvider(type=CardIssueSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="issue", property="issue", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CardIssue> selectByExample(CardIssueExample example);

    @Select({
        "select",
        "id, card_id, uid, status, issue, create_time",
        "from card_issue",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="issue", property="issue", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CardIssue selectByPrimaryKey(Long id);

    @UpdateProvider(type=CardIssueSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CardIssue record, @Param("example") CardIssueExample example);

    @UpdateProvider(type=CardIssueSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CardIssue record, @Param("example") CardIssueExample example);

    @UpdateProvider(type=CardIssueSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CardIssue record);

    @Update({
        "update card_issue",
        "set card_id = #{cardId,jdbcType=BIGINT},",
          "uid = #{uid,jdbcType=BIGINT},",
          "status = #{status,jdbcType=INTEGER},",
          "issue = #{issue,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CardIssue record);
}