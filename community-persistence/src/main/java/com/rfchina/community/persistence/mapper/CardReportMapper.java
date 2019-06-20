package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CardReport;
import com.rfchina.community.persistence.model.CardReportExample;
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

public interface CardReportMapper extends Serializable {
    @SelectProvider(type=CardReportSqlProvider.class, method="countByExample")
    long countByExample(CardReportExample example);

    @DeleteProvider(type=CardReportSqlProvider.class, method="deleteByExample")
    int deleteByExample(CardReportExample example);

    @Delete({
        "delete from card_report",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into card_report (card_id, category_id, ",
        "community_id, ruid, ",
        "rfullname, rphone, ",
        "suid, stype, sfullname, ",
        "sphone, content, ",
        "card_content, card_attachment, ",
        "status, create_time)",
        "values (#{cardId,jdbcType=BIGINT}, #{categoryId,jdbcType=INTEGER}, ",
        "#{communityId,jdbcType=INTEGER}, #{ruid,jdbcType=BIGINT}, ",
        "#{rfullname,jdbcType=VARCHAR}, #{rphone,jdbcType=VARCHAR}, ",
        "#{suid,jdbcType=BIGINT}, #{stype,jdbcType=INTEGER}, #{sfullname,jdbcType=VARCHAR}, ",
        "#{sphone,jdbcType=VARCHAR}, #{content,jdbcType=VARCHAR}, ",
        "#{cardContent,jdbcType=VARCHAR}, #{cardAttachment,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CardReport record);

    @InsertProvider(type=CardReportSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CardReport record);

    @SelectProvider(type=CardReportSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.BIGINT),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="ruid", property="ruid", jdbcType=JdbcType.BIGINT),
        @Result(column="rfullname", property="rfullname", jdbcType=JdbcType.VARCHAR),
        @Result(column="rphone", property="rphone", jdbcType=JdbcType.VARCHAR),
        @Result(column="suid", property="suid", jdbcType=JdbcType.BIGINT),
        @Result(column="stype", property="stype", jdbcType=JdbcType.INTEGER),
        @Result(column="sfullname", property="sfullname", jdbcType=JdbcType.VARCHAR),
        @Result(column="sphone", property="sphone", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_content", property="cardContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_attachment", property="cardAttachment", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CardReport> selectByExample(CardReportExample example);

    @Select({
        "select",
        "id, card_id, category_id, community_id, ruid, rfullname, rphone, suid, stype, ",
        "sfullname, sphone, content, card_content, card_attachment, status, create_time",
        "from card_report",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.BIGINT),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="ruid", property="ruid", jdbcType=JdbcType.BIGINT),
        @Result(column="rfullname", property="rfullname", jdbcType=JdbcType.VARCHAR),
        @Result(column="rphone", property="rphone", jdbcType=JdbcType.VARCHAR),
        @Result(column="suid", property="suid", jdbcType=JdbcType.BIGINT),
        @Result(column="stype", property="stype", jdbcType=JdbcType.INTEGER),
        @Result(column="sfullname", property="sfullname", jdbcType=JdbcType.VARCHAR),
        @Result(column="sphone", property="sphone", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_content", property="cardContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_attachment", property="cardAttachment", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CardReport selectByPrimaryKey(Long id);

    @UpdateProvider(type=CardReportSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CardReport record, @Param("example") CardReportExample example);

    @UpdateProvider(type=CardReportSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CardReport record, @Param("example") CardReportExample example);

    @UpdateProvider(type=CardReportSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CardReport record);

    @Update({
        "update card_report",
        "set card_id = #{cardId,jdbcType=BIGINT},",
          "category_id = #{categoryId,jdbcType=INTEGER},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "ruid = #{ruid,jdbcType=BIGINT},",
          "rfullname = #{rfullname,jdbcType=VARCHAR},",
          "rphone = #{rphone,jdbcType=VARCHAR},",
          "suid = #{suid,jdbcType=BIGINT},",
          "stype = #{stype,jdbcType=INTEGER},",
          "sfullname = #{sfullname,jdbcType=VARCHAR},",
          "sphone = #{sphone,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "card_content = #{cardContent,jdbcType=VARCHAR},",
          "card_attachment = #{cardAttachment,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CardReport record);
}