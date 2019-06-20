package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.RepairRemark;
import com.rfchina.community.persistence.model.RepairRemarkExample;
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

public interface RepairRemarkMapper extends Serializable {
    @SelectProvider(type=RepairRemarkSqlProvider.class, method="countByExample")
    long countByExample(RepairRemarkExample example);

    @DeleteProvider(type=RepairRemarkSqlProvider.class, method="deleteByExample")
    int deleteByExample(RepairRemarkExample example);

    @Delete({
        "delete from repair_remark",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into repair_remark (repair_record_id, score, ",
        "score_content, score_media, ",
        "score_time)",
        "values (#{repairRecordId,jdbcType=BIGINT}, #{score,jdbcType=INTEGER}, ",
        "#{scoreContent,jdbcType=VARCHAR}, #{scoreMedia,jdbcType=VARCHAR}, ",
        "#{scoreTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(RepairRemark record);

    @InsertProvider(type=RepairRemarkSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(RepairRemark record);

    @SelectProvider(type=RepairRemarkSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="repair_record_id", property="repairRecordId", jdbcType=JdbcType.BIGINT),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="score_content", property="scoreContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="score_media", property="scoreMedia", jdbcType=JdbcType.VARCHAR),
        @Result(column="score_time", property="scoreTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RepairRemark> selectByExample(RepairRemarkExample example);

    @Select({
        "select",
        "id, repair_record_id, score, score_content, score_media, score_time",
        "from repair_remark",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="repair_record_id", property="repairRecordId", jdbcType=JdbcType.BIGINT),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="score_content", property="scoreContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="score_media", property="scoreMedia", jdbcType=JdbcType.VARCHAR),
        @Result(column="score_time", property="scoreTime", jdbcType=JdbcType.TIMESTAMP)
    })
    RepairRemark selectByPrimaryKey(Long id);

    @UpdateProvider(type=RepairRemarkSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RepairRemark record, @Param("example") RepairRemarkExample example);

    @UpdateProvider(type=RepairRemarkSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RepairRemark record, @Param("example") RepairRemarkExample example);

    @UpdateProvider(type=RepairRemarkSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RepairRemark record);

    @Update({
        "update repair_remark",
        "set repair_record_id = #{repairRecordId,jdbcType=BIGINT},",
          "score = #{score,jdbcType=INTEGER},",
          "score_content = #{scoreContent,jdbcType=VARCHAR},",
          "score_media = #{scoreMedia,jdbcType=VARCHAR},",
          "score_time = #{scoreTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(RepairRemark record);
}