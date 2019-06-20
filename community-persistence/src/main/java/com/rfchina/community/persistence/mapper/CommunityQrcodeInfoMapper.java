package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityQrcodeInfo;
import com.rfchina.community.persistence.model.CommunityQrcodeInfoExample;
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

public interface CommunityQrcodeInfoMapper extends Serializable {
    @SelectProvider(type=CommunityQrcodeInfoSqlProvider.class, method="countByExample")
    long countByExample(CommunityQrcodeInfoExample example);

    @DeleteProvider(type=CommunityQrcodeInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityQrcodeInfoExample example);

    @Delete({
        "delete from community_qrcode_info",
        "where community_id = #{communityId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer communityId);

    @Insert({
        "insert into community_qrcode_info (community_id, other_community, ",
        "status, type, can_count, ",
        "id_key, private_key, ",
        "public_key, sync_time)",
        "values (#{communityId,jdbcType=INTEGER}, #{otherCommunity,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{type,jdbcType=INTEGER}, #{canCount,jdbcType=INTEGER}, ",
        "#{idKey,jdbcType=INTEGER}, #{privateKey,jdbcType=VARCHAR}, ",
        "#{publicKey,jdbcType=VARCHAR}, #{syncTime,jdbcType=TIMESTAMP})"
    })
    int insert(CommunityQrcodeInfo record);

    @InsertProvider(type=CommunityQrcodeInfoSqlProvider.class, method="insertSelective")
    int insertSelective(CommunityQrcodeInfo record);

    @SelectProvider(type=CommunityQrcodeInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="other_community", property="otherCommunity", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="can_count", property="canCount", jdbcType=JdbcType.INTEGER),
        @Result(column="id_key", property="idKey", jdbcType=JdbcType.INTEGER),
        @Result(column="private_key", property="privateKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="public_key", property="publicKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="sync_time", property="syncTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CommunityQrcodeInfo> selectByExample(CommunityQrcodeInfoExample example);

    //仅仅匹配了门禁服务，serverid=11是门禁在服务表里的id
    @Select({
        "select" +
        " cqi.community_id as community_id, cqi.other_community as other_community, cqi.type as type," +
        " cqi.can_count as can_count, cqi.id_key as id_key, cqi.private_key as private_key," +
        " cqi.public_key as public_key, cqi.sync_time as sync_time, csr.status as status " +
        " from community_qrcode_info cqi join community_service_rela csr on cqi.community_id = csr.community_id" +
        " where csr.service_id = 11 and cqi.community_id = #{communityId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="other_community", property="otherCommunity", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="can_count", property="canCount", jdbcType=JdbcType.INTEGER),
        @Result(column="id_key", property="idKey", jdbcType=JdbcType.INTEGER),
        @Result(column="private_key", property="privateKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="public_key", property="publicKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="sync_time", property="syncTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CommunityQrcodeInfo selectByPrimaryKey(Integer communityId);

    @UpdateProvider(type=CommunityQrcodeInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityQrcodeInfo record, @Param("example") CommunityQrcodeInfoExample example);

    @UpdateProvider(type=CommunityQrcodeInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityQrcodeInfo record, @Param("example") CommunityQrcodeInfoExample example);

    @UpdateProvider(type=CommunityQrcodeInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityQrcodeInfo record);

    @Update({
        "update community_qrcode_info",
        "set other_community = #{otherCommunity,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "type = #{type,jdbcType=INTEGER},",
          "can_count = #{canCount,jdbcType=INTEGER},",
          "id_key = #{idKey,jdbcType=INTEGER},",
          "private_key = #{privateKey,jdbcType=VARCHAR},",
          "public_key = #{publicKey,jdbcType=VARCHAR},",
          "sync_time = #{syncTime,jdbcType=TIMESTAMP}",
        "where community_id = #{communityId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommunityQrcodeInfo record);
}