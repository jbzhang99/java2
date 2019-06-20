package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VisitCommunityUserQrcode;
import com.rfchina.community.persistence.model.VisitCommunityUserQrcodeExample;
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

public interface VisitCommunityUserQrcodeMapper extends Serializable {
    @SelectProvider(type=VisitCommunityUserQrcodeSqlProvider.class, method="countByExample")
    long countByExample(VisitCommunityUserQrcodeExample example);

    @DeleteProvider(type=VisitCommunityUserQrcodeSqlProvider.class, method="deleteByExample")
    int deleteByExample(VisitCommunityUserQrcodeExample example);

    @Delete({
        "delete from visit_community_user_qrcode",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into visit_community_user_qrcode (uid, community_id, ",
        "content, create_time, ",
        "exp_time, create_ip)",
        "values (#{uid,jdbcType=BIGINT}, #{communityId,jdbcType=INTEGER}, ",
        "#{content,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{expTime,jdbcType=TIMESTAMP}, #{createIp,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(VisitCommunityUserQrcode record);

    @InsertProvider(type=VisitCommunityUserQrcodeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(VisitCommunityUserQrcode record);

    @SelectProvider(type=VisitCommunityUserQrcodeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="exp_time", property="expTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_ip", property="createIp", jdbcType=JdbcType.VARCHAR)
    })
    List<VisitCommunityUserQrcode> selectByExample(VisitCommunityUserQrcodeExample example);

    @Select({
        "select",
        "id, uid, community_id, content, create_time, exp_time, create_ip",
        "from visit_community_user_qrcode",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="exp_time", property="expTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_ip", property="createIp", jdbcType=JdbcType.VARCHAR)
    })
    VisitCommunityUserQrcode selectByPrimaryKey(Long id);

    @UpdateProvider(type=VisitCommunityUserQrcodeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VisitCommunityUserQrcode record, @Param("example") VisitCommunityUserQrcodeExample example);

    @UpdateProvider(type=VisitCommunityUserQrcodeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VisitCommunityUserQrcode record, @Param("example") VisitCommunityUserQrcodeExample example);

    @UpdateProvider(type=VisitCommunityUserQrcodeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VisitCommunityUserQrcode record);

    @Update({
        "update visit_community_user_qrcode",
        "set uid = #{uid,jdbcType=BIGINT},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "content = #{content,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "exp_time = #{expTime,jdbcType=TIMESTAMP},",
          "create_ip = #{createIp,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(VisitCommunityUserQrcode record);
}