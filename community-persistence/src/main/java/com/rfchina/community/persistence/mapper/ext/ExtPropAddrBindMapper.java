package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.model.MasterInfo;
import com.rfchina.community.persistence.model.MasterInfoExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.util.List;

/**
 */
public interface ExtPropAddrBindMapper {

    @Select(" select distinct a.house_id from prop_addr_bind a where a.community_id = #{communityId, jdbcType=INTEGER} ")
    public List<Long> getHouseIdListByCommunityId(@Param("communityId") Integer communityId);

    @Select({
        " select a.* from master_info a join prop_addr_bind b on a.id = b.master_id where b.house_id = #{houseId, jdbcType=BIGINT} limit 1"
    })
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
            @Result(column="floor", property="floor", jdbcType=JdbcType.VARCHAR),
            @Result(column="room", property="room", jdbcType=JdbcType.VARCHAR),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
            @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
            @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
            @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
            @Result(column="charge_name", property="chargeName", jdbcType=JdbcType.VARCHAR),
            @Result(column="charge_phone", property="chargePhone", jdbcType=JdbcType.VARCHAR),
            @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
            @Result(column="loudong", property="loudong", jdbcType=JdbcType.VARCHAR),
            @Result(column="agree_protocol", property="agreeProtocol", jdbcType=JdbcType.INTEGER),
            @Result(column="agree_protocol_time", property="agreeProtocolTime", jdbcType=JdbcType.TIMESTAMP)
    })
    MasterInfo getOneRowByHouseId(@Param("houseId") Long houseId);
}
