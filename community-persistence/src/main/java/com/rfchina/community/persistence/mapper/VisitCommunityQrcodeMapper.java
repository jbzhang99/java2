package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VisitCommunityQrcode;
import com.rfchina.community.persistence.model.VisitCommunityQrcodeExample;
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

public interface VisitCommunityQrcodeMapper extends Serializable {
    @SelectProvider(type=VisitCommunityQrcodeSqlProvider.class, method="countByExample")
    long countByExample(VisitCommunityQrcodeExample example);

    @DeleteProvider(type=VisitCommunityQrcodeSqlProvider.class, method="deleteByExample")
    int deleteByExample(VisitCommunityQrcodeExample example);

    @Delete({
        "delete from visit_community_qrcode",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into visit_community_qrcode (community_id, content, ",
        "create_time, exp_time, ",
        "valid_date, admin_id, ",
        "use_in_count, use_in_time, ",
        "use_out_count, use_out_time, ",
        "create_ip, create_phone, ",
        "create_uid, is_print, ",
        "print_time)",
        "values (#{communityId,jdbcType=INTEGER}, #{content,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{expTime,jdbcType=TIMESTAMP}, ",
        "#{validDate,jdbcType=DATE}, #{adminId,jdbcType=BIGINT}, ",
        "#{useInCount,jdbcType=INTEGER}, #{useInTime,jdbcType=TIMESTAMP}, ",
        "#{useOutCount,jdbcType=INTEGER}, #{useOutTime,jdbcType=TIMESTAMP}, ",
        "#{createIp,jdbcType=VARCHAR}, #{createPhone,jdbcType=VARCHAR}, ",
        "#{createUid,jdbcType=BIGINT}, #{isPrint,jdbcType=INTEGER}, ",
        "#{printTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(VisitCommunityQrcode record);

    @InsertProvider(type=VisitCommunityQrcodeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(VisitCommunityQrcode record);

    @SelectProvider(type=VisitCommunityQrcodeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="exp_time", property="expTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="valid_date", property="validDate", jdbcType=JdbcType.DATE),
        @Result(column="admin_id", property="adminId", jdbcType=JdbcType.BIGINT),
        @Result(column="use_in_count", property="useInCount", jdbcType=JdbcType.INTEGER),
        @Result(column="use_in_time", property="useInTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="use_out_count", property="useOutCount", jdbcType=JdbcType.INTEGER),
        @Result(column="use_out_time", property="useOutTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_ip", property="createIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_phone", property="createPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT),
        @Result(column="is_print", property="isPrint", jdbcType=JdbcType.INTEGER),
        @Result(column="print_time", property="printTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<VisitCommunityQrcode> selectByExample(VisitCommunityQrcodeExample example);

    @Select({
        "select",
        "id, community_id, content, create_time, exp_time, valid_date, admin_id, use_in_count, ",
        "use_in_time, use_out_count, use_out_time, create_ip, create_phone, create_uid, ",
        "is_print, print_time",
        "from visit_community_qrcode",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="exp_time", property="expTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="valid_date", property="validDate", jdbcType=JdbcType.DATE),
        @Result(column="admin_id", property="adminId", jdbcType=JdbcType.BIGINT),
        @Result(column="use_in_count", property="useInCount", jdbcType=JdbcType.INTEGER),
        @Result(column="use_in_time", property="useInTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="use_out_count", property="useOutCount", jdbcType=JdbcType.INTEGER),
        @Result(column="use_out_time", property="useOutTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_ip", property="createIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_phone", property="createPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT),
        @Result(column="is_print", property="isPrint", jdbcType=JdbcType.INTEGER),
        @Result(column="print_time", property="printTime", jdbcType=JdbcType.TIMESTAMP)
    })
    VisitCommunityQrcode selectByPrimaryKey(Long id);

    @UpdateProvider(type=VisitCommunityQrcodeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VisitCommunityQrcode record, @Param("example") VisitCommunityQrcodeExample example);

    @UpdateProvider(type=VisitCommunityQrcodeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VisitCommunityQrcode record, @Param("example") VisitCommunityQrcodeExample example);

    @UpdateProvider(type=VisitCommunityQrcodeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VisitCommunityQrcode record);

    @Update({
        "update visit_community_qrcode",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "content = #{content,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "exp_time = #{expTime,jdbcType=TIMESTAMP},",
          "valid_date = #{validDate,jdbcType=DATE},",
          "admin_id = #{adminId,jdbcType=BIGINT},",
          "use_in_count = #{useInCount,jdbcType=INTEGER},",
          "use_in_time = #{useInTime,jdbcType=TIMESTAMP},",
          "use_out_count = #{useOutCount,jdbcType=INTEGER},",
          "use_out_time = #{useOutTime,jdbcType=TIMESTAMP},",
          "create_ip = #{createIp,jdbcType=VARCHAR},",
          "create_phone = #{createPhone,jdbcType=VARCHAR},",
          "create_uid = #{createUid,jdbcType=BIGINT},",
          "is_print = #{isPrint,jdbcType=INTEGER},",
          "print_time = #{printTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(VisitCommunityQrcode record);
}