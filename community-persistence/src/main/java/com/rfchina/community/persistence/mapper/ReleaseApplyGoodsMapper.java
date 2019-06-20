package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.ReleaseApplyGoods;
import com.rfchina.community.persistence.model.ReleaseApplyGoodsExample;
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

public interface ReleaseApplyGoodsMapper extends Serializable {
    @SelectProvider(type=ReleaseApplyGoodsSqlProvider.class, method="countByExample")
    long countByExample(ReleaseApplyGoodsExample example);

    @DeleteProvider(type=ReleaseApplyGoodsSqlProvider.class, method="deleteByExample")
    int deleteByExample(ReleaseApplyGoodsExample example);

    @Delete({
        "delete from release_apply_goods",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into release_apply_goods (applicant_name, applicant_phone, ",
        "carrier_name, carrier_phone, ",
        "release_end_time, release_start_time, ",
        "create_time, status, ",
        "audit_time, audit_uid, ",
        "audit_content, create_uid, ",
        "community_id, master_id, ",
        "exe_phone, goods_json)",
        "values (#{applicantName,jdbcType=VARCHAR}, #{applicantPhone,jdbcType=VARCHAR}, ",
        "#{carrierName,jdbcType=VARCHAR}, #{carrierPhone,jdbcType=VARCHAR}, ",
        "#{releaseEndTime,jdbcType=TIMESTAMP}, #{releaseStartTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER}, ",
        "#{auditTime,jdbcType=TIMESTAMP}, #{auditUid,jdbcType=BIGINT}, ",
        "#{auditContent,jdbcType=VARCHAR}, #{createUid,jdbcType=BIGINT}, ",
        "#{communityId,jdbcType=INTEGER}, #{masterId,jdbcType=BIGINT}, ",
        "#{exePhone,jdbcType=VARCHAR}, #{goodsJson,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(ReleaseApplyGoods record);

    @InsertProvider(type=ReleaseApplyGoodsSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(ReleaseApplyGoods record);

    @SelectProvider(type=ReleaseApplyGoodsSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="applicant_name", property="applicantName", jdbcType=JdbcType.VARCHAR),
        @Result(column="applicant_phone", property="applicantPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="carrier_name", property="carrierName", jdbcType=JdbcType.VARCHAR),
        @Result(column="carrier_phone", property="carrierPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="release_end_time", property="releaseEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="release_start_time", property="releaseStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_uid", property="auditUid", jdbcType=JdbcType.BIGINT),
        @Result(column="audit_content", property="auditContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT),
        @Result(column="exe_phone", property="exePhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_json", property="goodsJson", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ReleaseApplyGoods> selectByExampleWithBLOBs(ReleaseApplyGoodsExample example);

    @SelectProvider(type=ReleaseApplyGoodsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="applicant_name", property="applicantName", jdbcType=JdbcType.VARCHAR),
        @Result(column="applicant_phone", property="applicantPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="carrier_name", property="carrierName", jdbcType=JdbcType.VARCHAR),
        @Result(column="carrier_phone", property="carrierPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="release_end_time", property="releaseEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="release_start_time", property="releaseStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_uid", property="auditUid", jdbcType=JdbcType.BIGINT),
        @Result(column="audit_content", property="auditContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT),
        @Result(column="exe_phone", property="exePhone", jdbcType=JdbcType.VARCHAR)
    })
    List<ReleaseApplyGoods> selectByExample(ReleaseApplyGoodsExample example);

    @Select({
        "select",
        "id, applicant_name, applicant_phone, carrier_name, carrier_phone, release_end_time, ",
        "release_start_time, create_time, status, audit_time, audit_uid, audit_content, ",
        "create_uid, community_id, master_id, exe_phone, goods_json",
        "from release_apply_goods",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="applicant_name", property="applicantName", jdbcType=JdbcType.VARCHAR),
        @Result(column="applicant_phone", property="applicantPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="carrier_name", property="carrierName", jdbcType=JdbcType.VARCHAR),
        @Result(column="carrier_phone", property="carrierPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="release_end_time", property="releaseEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="release_start_time", property="releaseStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_uid", property="auditUid", jdbcType=JdbcType.BIGINT),
        @Result(column="audit_content", property="auditContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT),
        @Result(column="exe_phone", property="exePhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_json", property="goodsJson", jdbcType=JdbcType.LONGVARCHAR)
    })
    ReleaseApplyGoods selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ReleaseApplyGoodsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ReleaseApplyGoods record, @Param("example") ReleaseApplyGoodsExample example);

    @UpdateProvider(type=ReleaseApplyGoodsSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") ReleaseApplyGoods record, @Param("example") ReleaseApplyGoodsExample example);

    @UpdateProvider(type=ReleaseApplyGoodsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ReleaseApplyGoods record, @Param("example") ReleaseApplyGoodsExample example);

    @UpdateProvider(type=ReleaseApplyGoodsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ReleaseApplyGoods record);

    @Update({
        "update release_apply_goods",
        "set applicant_name = #{applicantName,jdbcType=VARCHAR},",
          "applicant_phone = #{applicantPhone,jdbcType=VARCHAR},",
          "carrier_name = #{carrierName,jdbcType=VARCHAR},",
          "carrier_phone = #{carrierPhone,jdbcType=VARCHAR},",
          "release_end_time = #{releaseEndTime,jdbcType=TIMESTAMP},",
          "release_start_time = #{releaseStartTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "audit_time = #{auditTime,jdbcType=TIMESTAMP},",
          "audit_uid = #{auditUid,jdbcType=BIGINT},",
          "audit_content = #{auditContent,jdbcType=VARCHAR},",
          "create_uid = #{createUid,jdbcType=BIGINT},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "master_id = #{masterId,jdbcType=BIGINT},",
          "exe_phone = #{exePhone,jdbcType=VARCHAR},",
          "goods_json = #{goodsJson,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(ReleaseApplyGoods record);

    @Update({
        "update release_apply_goods",
        "set applicant_name = #{applicantName,jdbcType=VARCHAR},",
          "applicant_phone = #{applicantPhone,jdbcType=VARCHAR},",
          "carrier_name = #{carrierName,jdbcType=VARCHAR},",
          "carrier_phone = #{carrierPhone,jdbcType=VARCHAR},",
          "release_end_time = #{releaseEndTime,jdbcType=TIMESTAMP},",
          "release_start_time = #{releaseStartTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "audit_time = #{auditTime,jdbcType=TIMESTAMP},",
          "audit_uid = #{auditUid,jdbcType=BIGINT},",
          "audit_content = #{auditContent,jdbcType=VARCHAR},",
          "create_uid = #{createUid,jdbcType=BIGINT},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "master_id = #{masterId,jdbcType=BIGINT},",
          "exe_phone = #{exePhone,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ReleaseApplyGoods record);
}