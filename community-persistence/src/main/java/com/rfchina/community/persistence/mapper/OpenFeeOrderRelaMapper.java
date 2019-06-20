package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenFeeOrderRelaExample;
import com.rfchina.community.persistence.model.OpenFeeOrderRelaKey;
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

public interface OpenFeeOrderRelaMapper extends Serializable {
    @SelectProvider(type=OpenFeeOrderRelaSqlProvider.class, method="countByExample")
    long countByExample(OpenFeeOrderRelaExample example);

    @DeleteProvider(type=OpenFeeOrderRelaSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenFeeOrderRelaExample example);

    @Delete({
        "delete from open_fee_order_rela",
        "where fee_id = #{feeId,jdbcType=BIGINT}",
          "and pay_id = #{payId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(OpenFeeOrderRelaKey key);

    @Insert({
        "insert into open_fee_order_rela (fee_id, pay_id)",
        "values (#{feeId,jdbcType=BIGINT}, #{payId,jdbcType=BIGINT})"
    })
    int insert(OpenFeeOrderRelaKey record);

    @InsertProvider(type=OpenFeeOrderRelaSqlProvider.class, method="insertSelective")
    int insertSelective(OpenFeeOrderRelaKey record);

    @SelectProvider(type=OpenFeeOrderRelaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="fee_id", property="feeId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="pay_id", property="payId", jdbcType=JdbcType.BIGINT, id=true)
    })
    List<OpenFeeOrderRelaKey> selectByExample(OpenFeeOrderRelaExample example);

    @UpdateProvider(type=OpenFeeOrderRelaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenFeeOrderRelaKey record, @Param("example") OpenFeeOrderRelaExample example);

    @UpdateProvider(type=OpenFeeOrderRelaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenFeeOrderRelaKey record, @Param("example") OpenFeeOrderRelaExample example);
}