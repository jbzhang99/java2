package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.BizApplyOrderState;
import com.rfchina.community.persistence.model.BizApplyOrderStateExample;
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

public interface BizApplyOrderStateMapper extends Serializable {
    @SelectProvider(type=BizApplyOrderStateSqlProvider.class, method="countByExample")
    long countByExample(BizApplyOrderStateExample example);

    @DeleteProvider(type=BizApplyOrderStateSqlProvider.class, method="deleteByExample")
    int deleteByExample(BizApplyOrderStateExample example);

    @Delete({
        "delete from biz_apply_order_state",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into biz_apply_order_state (order_id, tsk_code, ",
        "istate, state, create_time)",
        "values (#{orderId,jdbcType=BIGINT}, #{tskCode,jdbcType=VARCHAR}, ",
        "#{istate,jdbcType=INTEGER}, #{state,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(BizApplyOrderState record);

    @InsertProvider(type=BizApplyOrderStateSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(BizApplyOrderState record);

    @SelectProvider(type=BizApplyOrderStateSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT),
        @Result(column="tsk_code", property="tskCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="istate", property="istate", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BizApplyOrderState> selectByExample(BizApplyOrderStateExample example);

    @Select({
        "select",
        "id, order_id, tsk_code, istate, state, create_time",
        "from biz_apply_order_state",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT),
        @Result(column="tsk_code", property="tskCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="istate", property="istate", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    BizApplyOrderState selectByPrimaryKey(Long id);

    @UpdateProvider(type=BizApplyOrderStateSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BizApplyOrderState record, @Param("example") BizApplyOrderStateExample example);

    @UpdateProvider(type=BizApplyOrderStateSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BizApplyOrderState record, @Param("example") BizApplyOrderStateExample example);

    @UpdateProvider(type=BizApplyOrderStateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BizApplyOrderState record);

    @Update({
        "update biz_apply_order_state",
        "set order_id = #{orderId,jdbcType=BIGINT},",
          "tsk_code = #{tskCode,jdbcType=VARCHAR},",
          "istate = #{istate,jdbcType=INTEGER},",
          "state = #{state,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BizApplyOrderState record);
}