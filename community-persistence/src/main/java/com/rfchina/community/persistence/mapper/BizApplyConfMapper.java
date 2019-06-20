package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.BizApplyConf;
import com.rfchina.community.persistence.model.BizApplyConfExample;
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

public interface BizApplyConfMapper extends Serializable {
    @SelectProvider(type=BizApplyConfSqlProvider.class, method="countByExample")
    long countByExample(BizApplyConfExample example);

    @DeleteProvider(type=BizApplyConfSqlProvider.class, method="deleteByExample")
    int deleteByExample(BizApplyConfExample example);

    @Delete({
        "delete from biz_apply_conf",
        "where community_id = #{communityId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer communityId);

    @Insert({
        "insert into biz_apply_conf (community_id, card_price, ",
        "status, obtain_address, ",
        "create_time, update_time)",
        "values (#{communityId,jdbcType=INTEGER}, #{cardPrice,jdbcType=DECIMAL}, ",
        "#{status,jdbcType=INTEGER}, #{obtainAddress,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(BizApplyConf record);

    @InsertProvider(type=BizApplyConfSqlProvider.class, method="insertSelective")
    int insertSelective(BizApplyConf record);

    @SelectProvider(type=BizApplyConfSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="card_price", property="cardPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="obtain_address", property="obtainAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BizApplyConf> selectByExample(BizApplyConfExample example);

    @Select({
        "select",
        "community_id, card_price, status, obtain_address, create_time, update_time",
        "from biz_apply_conf",
        "where community_id = #{communityId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="card_price", property="cardPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="obtain_address", property="obtainAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    BizApplyConf selectByPrimaryKey(Integer communityId);

    @UpdateProvider(type=BizApplyConfSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BizApplyConf record, @Param("example") BizApplyConfExample example);

    @UpdateProvider(type=BizApplyConfSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BizApplyConf record, @Param("example") BizApplyConfExample example);

    @UpdateProvider(type=BizApplyConfSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BizApplyConf record);

    @Update({
        "update biz_apply_conf",
        "set card_price = #{cardPrice,jdbcType=DECIMAL},",
          "status = #{status,jdbcType=INTEGER},",
          "obtain_address = #{obtainAddress,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where community_id = #{communityId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BizApplyConf record);
}