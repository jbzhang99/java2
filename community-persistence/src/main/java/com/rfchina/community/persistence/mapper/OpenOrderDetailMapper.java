package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenOrderDetail;
import com.rfchina.community.persistence.model.OpenOrderDetailExample;
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

public interface OpenOrderDetailMapper extends Serializable {
    @SelectProvider(type=OpenOrderDetailSqlProvider.class, method="countByExample")
    long countByExample(OpenOrderDetailExample example);

    @DeleteProvider(type=OpenOrderDetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenOrderDetailExample example);

    @Delete({
        "delete from open_order_detail",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_order_detail (id, pay_create_response)",
        "values (#{id,jdbcType=BIGINT}, #{payCreateResponse,jdbcType=LONGVARCHAR})"
    })
    int insert(OpenOrderDetail record);

    @InsertProvider(type=OpenOrderDetailSqlProvider.class, method="insertSelective")
    int insertSelective(OpenOrderDetail record);

    @SelectProvider(type=OpenOrderDetailSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="pay_create_response", property="payCreateResponse", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<OpenOrderDetail> selectByExampleWithBLOBs(OpenOrderDetailExample example);

    @SelectProvider(type=OpenOrderDetailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true)
    })
    List<OpenOrderDetail> selectByExample(OpenOrderDetailExample example);

    @Select({
        "select",
        "id, pay_create_response",
        "from open_order_detail",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="pay_create_response", property="payCreateResponse", jdbcType=JdbcType.LONGVARCHAR)
    })
    OpenOrderDetail selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenOrderDetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenOrderDetail record, @Param("example") OpenOrderDetailExample example);

    @UpdateProvider(type=OpenOrderDetailSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") OpenOrderDetail record, @Param("example") OpenOrderDetailExample example);

    @UpdateProvider(type=OpenOrderDetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenOrderDetail record, @Param("example") OpenOrderDetailExample example);

    @UpdateProvider(type=OpenOrderDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenOrderDetail record);

    @Update({
        "update open_order_detail",
        "set pay_create_response = #{payCreateResponse,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(OpenOrderDetail record);
}