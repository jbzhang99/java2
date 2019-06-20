package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenCautionInfo;
import com.rfchina.community.persistence.model.OpenCautionInfoExample;
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

public interface OpenCautionInfoMapper extends Serializable {
    @SelectProvider(type=OpenCautionInfoSqlProvider.class, method="countByExample")
    long countByExample(OpenCautionInfoExample example);

    @DeleteProvider(type=OpenCautionInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenCautionInfoExample example);

    @Delete({
        "delete from open_caution_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_caution_info (service_id, money, ",
        "bill_id, bill_create_time, ",
        "bill_status, bill_pay_time, ",
        "create_time, status, ",
        "pay_time, create_uid, ",
        "money_type, money_pic, ",
        "open_id, remarks)",
        "values (#{serviceId,jdbcType=INTEGER}, #{money,jdbcType=DECIMAL}, ",
        "#{billId,jdbcType=VARCHAR}, #{billCreateTime,jdbcType=TIMESTAMP}, ",
        "#{billStatus,jdbcType=INTEGER}, #{billPayTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER}, ",
        "#{payTime,jdbcType=TIMESTAMP}, #{createUid,jdbcType=BIGINT}, ",
        "#{moneyType,jdbcType=CHAR}, #{moneyPic,jdbcType=VARCHAR}, ",
        "#{openId,jdbcType=BIGINT}, #{remarks,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenCautionInfo record);

    @InsertProvider(type=OpenCautionInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenCautionInfo record);

    @SelectProvider(type=OpenCautionInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="money", property="money", jdbcType=JdbcType.DECIMAL),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_create_time", property="billCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="bill_status", property="billStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_pay_time", property="billPayTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT),
        @Result(column="money_type", property="moneyType", jdbcType=JdbcType.CHAR),
        @Result(column="money_pic", property="moneyPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_id", property="openId", jdbcType=JdbcType.BIGINT),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR)
    })
    List<OpenCautionInfo> selectByExample(OpenCautionInfoExample example);

    @Select({
        "select",
        "id, service_id, money, bill_id, bill_create_time, bill_status, bill_pay_time, ",
        "create_time, status, pay_time, create_uid, money_type, money_pic, open_id, remarks",
        "from open_caution_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="money", property="money", jdbcType=JdbcType.DECIMAL),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_create_time", property="billCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="bill_status", property="billStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_pay_time", property="billPayTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT),
        @Result(column="money_type", property="moneyType", jdbcType=JdbcType.CHAR),
        @Result(column="money_pic", property="moneyPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_id", property="openId", jdbcType=JdbcType.BIGINT),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR)
    })
    OpenCautionInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenCautionInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenCautionInfo record, @Param("example") OpenCautionInfoExample example);

    @UpdateProvider(type=OpenCautionInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenCautionInfo record, @Param("example") OpenCautionInfoExample example);

    @UpdateProvider(type=OpenCautionInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenCautionInfo record);

    @Update({
        "update open_caution_info",
        "set service_id = #{serviceId,jdbcType=INTEGER},",
          "money = #{money,jdbcType=DECIMAL},",
          "bill_id = #{billId,jdbcType=VARCHAR},",
          "bill_create_time = #{billCreateTime,jdbcType=TIMESTAMP},",
          "bill_status = #{billStatus,jdbcType=INTEGER},",
          "bill_pay_time = #{billPayTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "pay_time = #{payTime,jdbcType=TIMESTAMP},",
          "create_uid = #{createUid,jdbcType=BIGINT},",
          "money_type = #{moneyType,jdbcType=CHAR},",
          "money_pic = #{moneyPic,jdbcType=VARCHAR},",
          "open_id = #{openId,jdbcType=BIGINT},",
          "remarks = #{remarks,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenCautionInfo record);
}