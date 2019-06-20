package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.PropAddrUnbind;
import com.rfchina.community.persistence.model.PropAddrUnbindExample;
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

public interface PropAddrUnbindMapper extends Serializable {
    @SelectProvider(type=PropAddrUnbindSqlProvider.class, method="countByExample")
    long countByExample(PropAddrUnbindExample example);

    @DeleteProvider(type=PropAddrUnbindSqlProvider.class, method="deleteByExample")
    int deleteByExample(PropAddrUnbindExample example);

    @Delete({
        "delete from prop_addr_unbind",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into prop_addr_unbind (ref_id, community_id, ",
        "master_id, master_child_id, ",
        "house_id, uid, type, ",
        "status, prop_addr, ",
        "unbind_time, create_time, ",
        "update_time)",
        "values (#{refId,jdbcType=BIGINT}, #{communityId,jdbcType=INTEGER}, ",
        "#{masterId,jdbcType=BIGINT}, #{masterChildId,jdbcType=BIGINT}, ",
        "#{houseId,jdbcType=BIGINT}, #{uid,jdbcType=BIGINT}, #{type,jdbcType=TINYINT}, ",
        "#{status,jdbcType=TINYINT}, #{propAddr,jdbcType=VARCHAR}, ",
        "#{unbindTime,jdbcType=TIMESTAMP}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(PropAddrUnbind record);

    @InsertProvider(type=PropAddrUnbindSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(PropAddrUnbind record);

    @SelectProvider(type=PropAddrUnbindSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ref_id", property="refId", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT),
        @Result(column="master_child_id", property="masterChildId", jdbcType=JdbcType.BIGINT),
        @Result(column="house_id", property="houseId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="prop_addr", property="propAddr", jdbcType=JdbcType.VARCHAR),
        @Result(column="unbind_time", property="unbindTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PropAddrUnbind> selectByExample(PropAddrUnbindExample example);

    @Select({
        "select",
        "id, ref_id, community_id, master_id, master_child_id, house_id, uid, type, status, ",
        "prop_addr, unbind_time, create_time, update_time",
        "from prop_addr_unbind",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ref_id", property="refId", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT),
        @Result(column="master_child_id", property="masterChildId", jdbcType=JdbcType.BIGINT),
        @Result(column="house_id", property="houseId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="prop_addr", property="propAddr", jdbcType=JdbcType.VARCHAR),
        @Result(column="unbind_time", property="unbindTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    PropAddrUnbind selectByPrimaryKey(Long id);

    @UpdateProvider(type=PropAddrUnbindSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PropAddrUnbind record, @Param("example") PropAddrUnbindExample example);

    @UpdateProvider(type=PropAddrUnbindSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PropAddrUnbind record, @Param("example") PropAddrUnbindExample example);

    @UpdateProvider(type=PropAddrUnbindSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PropAddrUnbind record);

    @Update({
        "update prop_addr_unbind",
        "set ref_id = #{refId,jdbcType=BIGINT},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "master_id = #{masterId,jdbcType=BIGINT},",
          "master_child_id = #{masterChildId,jdbcType=BIGINT},",
          "house_id = #{houseId,jdbcType=BIGINT},",
          "uid = #{uid,jdbcType=BIGINT},",
          "type = #{type,jdbcType=TINYINT},",
          "status = #{status,jdbcType=TINYINT},",
          "prop_addr = #{propAddr,jdbcType=VARCHAR},",
          "unbind_time = #{unbindTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PropAddrUnbind record);
}