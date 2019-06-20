package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SecureHost;
import com.rfchina.community.persistence.model.SecureHostExample;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SecureHostMapper extends Serializable {
    @SelectProvider(type=SecureHostSqlProvider.class, method="countByExample")
    long countByExample(SecureHostExample example);

    @DeleteProvider(type=SecureHostSqlProvider.class, method="deleteByExample")
    int deleteByExample(SecureHostExample example);

    @Delete({
        "delete from secure_host",
        "where host = #{host,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String host);

    @Insert({
        "insert into secure_host (host)",
        "values (#{host,jdbcType=VARCHAR})"
    })
    int insert(SecureHost record);

    @InsertProvider(type=SecureHostSqlProvider.class, method="insertSelective")
    int insertSelective(SecureHost record);

    @SelectProvider(type=SecureHostSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="host", property="host", jdbcType=JdbcType.VARCHAR, id=true)
    })
    List<SecureHost> selectByExample(SecureHostExample example);

    @UpdateProvider(type=SecureHostSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SecureHost record, @Param("example") SecureHostExample example);

    @UpdateProvider(type=SecureHostSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SecureHost record, @Param("example") SecureHostExample example);
}