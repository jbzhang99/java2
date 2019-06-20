package com.rfchina.community.persistence.mapper.ext;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.rfchina.community.persistence.model.ext.MasterInfoExt;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import com.rfchina.community.persistence.model.MasterInfo;
import com.rfchina.community.persistence.model.MasterInfoExample;

public interface ExtMasterInfoGlobalMapper extends Serializable {
   
    @SelectProvider(type=ExtMasterInfoSqlGlobalProvider.class, method="selectByExampleSelective")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="floor", property="floor", jdbcType=JdbcType.VARCHAR),
        @Result(column="room", property="room", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="charge_name", property="chargeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="charge_phone", property="chargePhone", jdbcType=JdbcType.VARCHAR)
    }) 
    List<MasterInfo> selectByExampleSelectiveWithRowbounds(MasterInfoExample example, RowBounds rowBounds);

    @Select({
        "select t.id, t.area_id from master_info t join community c on t.community_id = c.id where c.name like #{communityName, jdbcType=VARCHAR} "
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
            @Result(column="floor", property="floor", jdbcType=JdbcType.VARCHAR),
            @Result(column="room", property="room", jdbcType=JdbcType.VARCHAR),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
            @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
            @Result(column="charge_name", property="chargeName", jdbcType=JdbcType.VARCHAR),
            @Result(column="charge_phone", property="chargePhone", jdbcType=JdbcType.VARCHAR)
    })
    PageList<MasterInfo> selectByCommunityName(@Param("communityName") String communityName, PageBounds pageBounds);

    @SelectProvider(type=ExtMasterInfoSqlGlobalProvider.class, method="pageByMasterInfoValid")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
            @Result(column="floor", property="floor", jdbcType=JdbcType.VARCHAR),
            @Result(column="room", property="room", jdbcType=JdbcType.VARCHAR),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
            @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
            @Result(column="charge_name", property="chargeName", jdbcType=JdbcType.VARCHAR),
            @Result(column="charge_phone", property="chargePhone", jdbcType=JdbcType.VARCHAR)
    })
    PageList<MasterInfo> pageByMasterInfoValid(Map<String, Object> where, PageBounds pageBounds);

    @SelectProvider(type=ExtMasterInfoSqlGlobalProvider.class, method="selectByCondition")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
            @Result(column="floor", property="floor", jdbcType=JdbcType.VARCHAR),
            @Result(column="room", property="room", jdbcType=JdbcType.VARCHAR),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
            @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
            @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
            @Result(column="charge_name", property="chargeName", jdbcType=JdbcType.VARCHAR),
            @Result(column="charge_phone", property="chargePhone", jdbcType=JdbcType.VARCHAR),
            @Result(column="community_name", property="communityName", jdbcType=JdbcType.VARCHAR)
    })
    List<MasterInfoExt> selectByCondition(@Param("uid") Long uid,
                                          @Param("communityId") Integer communityId,
                                          @Param("serviceId") Integer serviceId,
                                          @Param("infoStatus") Integer infoStatus,
                                          @Param("childStatus") Integer childStatus,
                                          @Param("communityStatus") Integer communityStatus);

    @SelectProvider(type=ExtMasterInfoSqlGlobalProvider.class, method="selectPropAddrCertRoomList")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
            @Result(column="floor", property="floor", jdbcType=JdbcType.VARCHAR),
            @Result(column="room", property="room", jdbcType=JdbcType.VARCHAR),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
            @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
            @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
            @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
            @Result(column="charge_name", property="chargeName", jdbcType=JdbcType.VARCHAR),
            @Result(column="charge_phone", property="chargePhone", jdbcType=JdbcType.VARCHAR),
            @Result(column="community_name", property="communityName", jdbcType=JdbcType.VARCHAR)
    })
    List<MasterInfoExt> selectPropAddrCertRoomList(@Param("uid") Long uid,
                                          @Param("communityIds") Integer[] communityIds,
                                          @Param("infoStatus") Integer infoStatus,
                                          @Param("childStatus") Integer childStatus,
                                          @Param("communityStatus") Integer communityStatus);

    @SelectProvider(type=ExtMasterInfoSqlGlobalProvider.class, method="selectPropAddrBindRoomList")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
            @Result(column="floor", property="floor", jdbcType=JdbcType.VARCHAR),
            @Result(column="room", property="room", jdbcType=JdbcType.VARCHAR),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
            @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
            @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
            @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
            @Result(column="charge_name", property="chargeName", jdbcType=JdbcType.VARCHAR),
            @Result(column="charge_phone", property="chargePhone", jdbcType=JdbcType.VARCHAR),
            @Result(column="community_name", property="communityName", jdbcType=JdbcType.VARCHAR)
    })
    List<MasterInfoExt> selectPropAddrBindRoomList(@Param("uid") Long uid,
                                                   @Param("communityIds") Integer[] communityIds,
                                                   @Param("infoStatus") Integer infoStatus,
                                                   @Param("childStatus") Integer childStatus,
                                                   @Param("communityStatus") Integer communityStatus);

    @Select({
            "SELECT c.`name` AS community_name " +
                    ",mi.loudong AS loudong " +
                    ",mi.room AS room " +
                    ",mc.`name` AS user_name " +
                    ",mi.address AS address " +
                    ",mc.phone as phone " +
                    "FROM master_info mi " +
                    "LEFT JOIN master_child mc ON mi.id = mc.master_id " +
                    "LEFT JOIN community c ON mi.community_id = c.id " +
                    "WHERE mc.uid = #{uid, jdbcType=BIGINT}  " +
                    "AND mc.community_id = #{communityId, jdbcType=INTEGER} " +
                    "LIMIT 1 "
    })
    @Results({
            @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
            @Result(column="loudong", property="loudong", jdbcType=JdbcType.VARCHAR),
            @Result(column="room", property="room", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="community_name", property="communityName", jdbcType=JdbcType.VARCHAR)
    })
    MasterInfoExt selectCommunityInfoByUid(@Param("uid") Long uid,@Param("communityId") int communityId);

}