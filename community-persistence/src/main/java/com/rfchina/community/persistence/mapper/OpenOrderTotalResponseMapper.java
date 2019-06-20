package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenOrderTotalResponse;
import com.rfchina.community.persistence.model.OpenOrderTotalResponseExample;
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

public interface OpenOrderTotalResponseMapper extends Serializable {
    @SelectProvider(type=OpenOrderTotalResponseSqlProvider.class, method="countByExample")
    long countByExample(OpenOrderTotalResponseExample example);

    @DeleteProvider(type=OpenOrderTotalResponseSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenOrderTotalResponseExample example);

    @Delete({
        "delete from open_order_total_response",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_order_total_response (id, pay_create_response)",
        "values (#{id,jdbcType=BIGINT}, #{payCreateResponse,jdbcType=LONGVARCHAR})"
    })
    int insert(OpenOrderTotalResponse record);

    @InsertProvider(type=OpenOrderTotalResponseSqlProvider.class, method="insertSelective")
    int insertSelective(OpenOrderTotalResponse record);

    @SelectProvider(type=OpenOrderTotalResponseSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="pay_create_response", property="payCreateResponse", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<OpenOrderTotalResponse> selectByExampleWithBLOBs(OpenOrderTotalResponseExample example);

    @SelectProvider(type=OpenOrderTotalResponseSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true)
    })
    List<OpenOrderTotalResponse> selectByExample(OpenOrderTotalResponseExample example);

    @Select({
        "select",
        "id, pay_create_response",
        "from open_order_total_response",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="pay_create_response", property="payCreateResponse", jdbcType=JdbcType.LONGVARCHAR)
    })
    OpenOrderTotalResponse selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenOrderTotalResponseSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenOrderTotalResponse record, @Param("example") OpenOrderTotalResponseExample example);

    @UpdateProvider(type=OpenOrderTotalResponseSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") OpenOrderTotalResponse record, @Param("example") OpenOrderTotalResponseExample example);

    @UpdateProvider(type=OpenOrderTotalResponseSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenOrderTotalResponse record, @Param("example") OpenOrderTotalResponseExample example);

    @UpdateProvider(type=OpenOrderTotalResponseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenOrderTotalResponse record);

    @Update({
        "update open_order_total_response",
        "set pay_create_response = #{payCreateResponse,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(OpenOrderTotalResponse record);
}