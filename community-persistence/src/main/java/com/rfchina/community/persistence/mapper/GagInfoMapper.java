package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.GagInfo;
import com.rfchina.community.persistence.model.GagInfoExample;
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

public interface GagInfoMapper extends Serializable {
    @SelectProvider(type=GagInfoSqlProvider.class, method="countByExample")
    long countByExample(GagInfoExample example);

    @DeleteProvider(type=GagInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(GagInfoExample example);

    @Delete({
        "delete from gag_info",
        "where uid = #{uid,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long uid);

    @Insert({
        "insert into gag_info (uid, create_time, ",
        "end_time)",
        "values (#{uid,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{endTime,jdbcType=TIMESTAMP})"
    })
    int insert(GagInfo record);

    @InsertProvider(type=GagInfoSqlProvider.class, method="insertSelective")
    int insertSelective(GagInfo record);

    @SelectProvider(type=GagInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<GagInfo> selectByExample(GagInfoExample example);

    @Select({
        "select",
        "uid, create_time, end_time",
        "from gag_info",
        "where uid = #{uid,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP)
    })
    GagInfo selectByPrimaryKey(Long uid);

    @UpdateProvider(type=GagInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") GagInfo record, @Param("example") GagInfoExample example);

    @UpdateProvider(type=GagInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") GagInfo record, @Param("example") GagInfoExample example);

    @UpdateProvider(type=GagInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GagInfo record);

    @Update({
        "update gag_info",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP}",
        "where uid = #{uid,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(GagInfo record);
}