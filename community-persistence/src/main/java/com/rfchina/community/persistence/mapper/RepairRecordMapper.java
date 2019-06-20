package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.RepairRecord;
import com.rfchina.community.persistence.model.RepairRecordExample;
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

public interface RepairRecordMapper extends Serializable {
    @SelectProvider(type=RepairRecordSqlProvider.class, method="countByExample")
    long countByExample(RepairRecordExample example);

    @DeleteProvider(type=RepairRecordSqlProvider.class, method="deleteByExample")
    int deleteByExample(RepairRecordExample example);

    @Delete({
        "delete from repair_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into repair_record (trade_no, order_no, ",
        "uid, master_child_id, ",
        "contact, contact_mobile, ",
        "problem_type_id, address, ",
        "content, atta, remimd, ",
        "remimd_time, score, ",
        "score_content, score_time, ",
        "create_time, update_time, ",
        "status, community_id, ",
        "type, form_type, ",
        "out_reason, labour_fee, ",
        "material_fee, service_category, ",
        "urgency_level)",
        "values (#{tradeNo,jdbcType=VARCHAR}, #{orderNo,jdbcType=VARCHAR}, ",
        "#{uid,jdbcType=BIGINT}, #{masterChildId,jdbcType=BIGINT}, ",
        "#{contact,jdbcType=VARCHAR}, #{contactMobile,jdbcType=VARCHAR}, ",
        "#{problemTypeId,jdbcType=INTEGER}, #{address,jdbcType=VARCHAR}, ",
        "#{content,jdbcType=VARCHAR}, #{atta,jdbcType=VARCHAR}, #{remimd,jdbcType=INTEGER}, ",
        "#{remimdTime,jdbcType=TIMESTAMP}, #{score,jdbcType=INTEGER}, ",
        "#{scoreContent,jdbcType=VARCHAR}, #{scoreTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=TINYINT}, #{communityId,jdbcType=INTEGER}, ",
        "#{type,jdbcType=TINYINT}, #{formType,jdbcType=TINYINT}, ",
        "#{outReason,jdbcType=VARCHAR}, #{labourFee,jdbcType=VARCHAR}, ",
        "#{materialFee,jdbcType=VARCHAR}, #{serviceCategory,jdbcType=INTEGER}, ",
        "#{urgencyLevel,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(RepairRecord record);

    @InsertProvider(type=RepairRecordSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(RepairRecord record);

    @SelectProvider(type=RepairRecordSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="trade_no", property="tradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_no", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="master_child_id", property="masterChildId", jdbcType=JdbcType.BIGINT),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_mobile", property="contactMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="problem_type_id", property="problemTypeId", jdbcType=JdbcType.INTEGER),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="atta", property="atta", jdbcType=JdbcType.VARCHAR),
        @Result(column="remimd", property="remimd", jdbcType=JdbcType.INTEGER),
        @Result(column="remimd_time", property="remimdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="score_content", property="scoreContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="score_time", property="scoreTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="form_type", property="formType", jdbcType=JdbcType.TINYINT),
        @Result(column="out_reason", property="outReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="labour_fee", property="labourFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="material_fee", property="materialFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_category", property="serviceCategory", jdbcType=JdbcType.INTEGER),
        @Result(column="urgency_level", property="urgencyLevel", jdbcType=JdbcType.INTEGER)
    })
    List<RepairRecord> selectByExample(RepairRecordExample example);

    @Select({
        "select",
        "id, trade_no, order_no, uid, master_child_id, contact, contact_mobile, problem_type_id, ",
        "address, content, atta, remimd, remimd_time, score, score_content, score_time, ",
        "create_time, update_time, status, community_id, type, form_type, out_reason, ",
        "labour_fee, material_fee, service_category, urgency_level",
        "from repair_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="trade_no", property="tradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_no", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="master_child_id", property="masterChildId", jdbcType=JdbcType.BIGINT),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_mobile", property="contactMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="problem_type_id", property="problemTypeId", jdbcType=JdbcType.INTEGER),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="atta", property="atta", jdbcType=JdbcType.VARCHAR),
        @Result(column="remimd", property="remimd", jdbcType=JdbcType.INTEGER),
        @Result(column="remimd_time", property="remimdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="score_content", property="scoreContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="score_time", property="scoreTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="form_type", property="formType", jdbcType=JdbcType.TINYINT),
        @Result(column="out_reason", property="outReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="labour_fee", property="labourFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="material_fee", property="materialFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_category", property="serviceCategory", jdbcType=JdbcType.INTEGER),
        @Result(column="urgency_level", property="urgencyLevel", jdbcType=JdbcType.INTEGER)
    })
    RepairRecord selectByPrimaryKey(Long id);

    @UpdateProvider(type=RepairRecordSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RepairRecord record, @Param("example") RepairRecordExample example);

    @UpdateProvider(type=RepairRecordSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RepairRecord record, @Param("example") RepairRecordExample example);

    @UpdateProvider(type=RepairRecordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RepairRecord record);

    @Update({
        "update repair_record",
        "set trade_no = #{tradeNo,jdbcType=VARCHAR},",
          "order_no = #{orderNo,jdbcType=VARCHAR},",
          "uid = #{uid,jdbcType=BIGINT},",
          "master_child_id = #{masterChildId,jdbcType=BIGINT},",
          "contact = #{contact,jdbcType=VARCHAR},",
          "contact_mobile = #{contactMobile,jdbcType=VARCHAR},",
          "problem_type_id = #{problemTypeId,jdbcType=INTEGER},",
          "address = #{address,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "atta = #{atta,jdbcType=VARCHAR},",
          "remimd = #{remimd,jdbcType=INTEGER},",
          "remimd_time = #{remimdTime,jdbcType=TIMESTAMP},",
          "score = #{score,jdbcType=INTEGER},",
          "score_content = #{scoreContent,jdbcType=VARCHAR},",
          "score_time = #{scoreTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "type = #{type,jdbcType=TINYINT},",
          "form_type = #{formType,jdbcType=TINYINT},",
          "out_reason = #{outReason,jdbcType=VARCHAR},",
          "labour_fee = #{labourFee,jdbcType=VARCHAR},",
          "material_fee = #{materialFee,jdbcType=VARCHAR},",
          "service_category = #{serviceCategory,jdbcType=INTEGER},",
          "urgency_level = #{urgencyLevel,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(RepairRecord record);
}