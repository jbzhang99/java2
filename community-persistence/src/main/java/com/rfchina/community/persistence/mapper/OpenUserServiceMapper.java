package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenUserService;
import com.rfchina.community.persistence.model.OpenUserServiceExample;
import com.rfchina.community.persistence.model.OpenUserServiceKey;
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

public interface OpenUserServiceMapper extends Serializable {
    @SelectProvider(type=OpenUserServiceSqlProvider.class, method="countByExample")
    long countByExample(OpenUserServiceExample example);

    @DeleteProvider(type=OpenUserServiceSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenUserServiceExample example);

    @Delete({
        "delete from open_user_service",
        "where uid = #{uid,jdbcType=BIGINT}",
          "and service_id = #{serviceId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(OpenUserServiceKey key);

    @Insert({
        "insert into open_user_service (uid, service_id, ",
        "last_use_community_id)",
        "values (#{uid,jdbcType=BIGINT}, #{serviceId,jdbcType=INTEGER}, ",
        "#{lastUseCommunityId,jdbcType=INTEGER})"
    })
    int insert(OpenUserService record);

    @InsertProvider(type=OpenUserServiceSqlProvider.class, method="insertSelective")
    int insertSelective(OpenUserService record);

    @SelectProvider(type=OpenUserServiceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="last_use_community_id", property="lastUseCommunityId", jdbcType=JdbcType.INTEGER)
    })
    List<OpenUserService> selectByExample(OpenUserServiceExample example);

    @Select({
        "select",
        "uid, service_id, last_use_community_id",
        "from open_user_service",
        "where uid = #{uid,jdbcType=BIGINT}",
          "and service_id = #{serviceId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="last_use_community_id", property="lastUseCommunityId", jdbcType=JdbcType.INTEGER)
    })
    OpenUserService selectByPrimaryKey(OpenUserServiceKey key);

    @UpdateProvider(type=OpenUserServiceSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenUserService record, @Param("example") OpenUserServiceExample example);

    @UpdateProvider(type=OpenUserServiceSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenUserService record, @Param("example") OpenUserServiceExample example);

    @UpdateProvider(type=OpenUserServiceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenUserService record);

    @Update({
        "update open_user_service",
        "set last_use_community_id = #{lastUseCommunityId,jdbcType=INTEGER}",
        "where uid = #{uid,jdbcType=BIGINT}",
          "and service_id = #{serviceId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenUserService record);
}