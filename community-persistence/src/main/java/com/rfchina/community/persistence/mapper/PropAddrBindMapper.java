package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.PropAddrBind;
import com.rfchina.community.persistence.model.PropAddrBindExample;
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

public interface PropAddrBindMapper extends Serializable {
    @SelectProvider(type=PropAddrBindSqlProvider.class, method="countByExample")
    long countByExample(PropAddrBindExample example);

    @DeleteProvider(type=PropAddrBindSqlProvider.class, method="deleteByExample")
    int deleteByExample(PropAddrBindExample example);

    @Delete({
        "delete from prop_addr_bind",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into prop_addr_bind (community_id, master_id, ",
        "master_child_id, uid, ",
        "house_id, type, status, ",
        "prop_addr, bind_time, ",
        "create_time, update_time)",
        "values (#{communityId,jdbcType=INTEGER}, #{masterId,jdbcType=BIGINT}, ",
        "#{masterChildId,jdbcType=BIGINT}, #{uid,jdbcType=BIGINT}, ",
        "#{houseId,jdbcType=BIGINT}, #{type,jdbcType=TINYINT}, #{status,jdbcType=TINYINT}, ",
        "#{propAddr,jdbcType=VARCHAR}, #{bindTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(PropAddrBind record);

    @InsertProvider(type=PropAddrBindSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(PropAddrBind record);

    @SelectProvider(type=PropAddrBindSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT),
        @Result(column="master_child_id", property="masterChildId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="house_id", property="houseId", jdbcType=JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="prop_addr", property="propAddr", jdbcType=JdbcType.VARCHAR),
        @Result(column="bind_time", property="bindTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PropAddrBind> selectByExample(PropAddrBindExample example);

    @Select({
        "select",
        "id, community_id, master_id, master_child_id, uid, house_id, type, status, prop_addr, ",
        "bind_time, create_time, update_time",
        "from prop_addr_bind",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT),
        @Result(column="master_child_id", property="masterChildId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="house_id", property="houseId", jdbcType=JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="prop_addr", property="propAddr", jdbcType=JdbcType.VARCHAR),
        @Result(column="bind_time", property="bindTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    PropAddrBind selectByPrimaryKey(Long id);

    @UpdateProvider(type=PropAddrBindSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PropAddrBind record, @Param("example") PropAddrBindExample example);

    @UpdateProvider(type=PropAddrBindSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PropAddrBind record, @Param("example") PropAddrBindExample example);

    @UpdateProvider(type=PropAddrBindSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PropAddrBind record);

    @Update({
        "update prop_addr_bind",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "master_id = #{masterId,jdbcType=BIGINT},",
          "master_child_id = #{masterChildId,jdbcType=BIGINT},",
          "uid = #{uid,jdbcType=BIGINT},",
          "house_id = #{houseId,jdbcType=BIGINT},",
          "type = #{type,jdbcType=TINYINT},",
          "status = #{status,jdbcType=TINYINT},",
          "prop_addr = #{propAddr,jdbcType=VARCHAR},",
          "bind_time = #{bindTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PropAddrBind record);
}