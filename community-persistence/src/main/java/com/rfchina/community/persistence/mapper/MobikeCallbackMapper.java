package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.MobikeCallback;
import com.rfchina.community.persistence.model.MobikeCallbackExample;
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

public interface MobikeCallbackMapper extends Serializable {
    @SelectProvider(type=MobikeCallbackSqlProvider.class, method="countByExample")
    long countByExample(MobikeCallbackExample example);

    @DeleteProvider(type=MobikeCallbackSqlProvider.class, method="deleteByExample")
    int deleteByExample(MobikeCallbackExample example);

    @Delete({
        "delete from mobike_callback",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into mobike_callback (order_id, status, ",
        "src, sign, create_time, ",
        "detail)",
        "values (#{orderId,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR}, ",
        "#{src,jdbcType=VARCHAR}, #{sign,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{detail,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(MobikeCallback record);

    @InsertProvider(type=MobikeCallbackSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(MobikeCallback record);

    @SelectProvider(type=MobikeCallbackSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="src", property="src", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign", property="sign", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="detail", property="detail", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<MobikeCallback> selectByExampleWithBLOBs(MobikeCallbackExample example);

    @SelectProvider(type=MobikeCallbackSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="src", property="src", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign", property="sign", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<MobikeCallback> selectByExample(MobikeCallbackExample example);

    @Select({
        "select",
        "id, order_id, status, src, sign, create_time, detail",
        "from mobike_callback",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="src", property="src", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign", property="sign", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="detail", property="detail", jdbcType=JdbcType.LONGVARCHAR)
    })
    MobikeCallback selectByPrimaryKey(Long id);

    @UpdateProvider(type=MobikeCallbackSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MobikeCallback record, @Param("example") MobikeCallbackExample example);

    @UpdateProvider(type=MobikeCallbackSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") MobikeCallback record, @Param("example") MobikeCallbackExample example);

    @UpdateProvider(type=MobikeCallbackSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MobikeCallback record, @Param("example") MobikeCallbackExample example);

    @UpdateProvider(type=MobikeCallbackSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MobikeCallback record);

    @Update({
        "update mobike_callback",
        "set order_id = #{orderId,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "src = #{src,jdbcType=VARCHAR},",
          "sign = #{sign,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "detail = #{detail,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(MobikeCallback record);

    @Update({
        "update mobike_callback",
        "set order_id = #{orderId,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "src = #{src,jdbcType=VARCHAR},",
          "sign = #{sign,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MobikeCallback record);
}