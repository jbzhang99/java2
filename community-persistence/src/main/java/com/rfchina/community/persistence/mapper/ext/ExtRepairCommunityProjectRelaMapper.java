package com.rfchina.community.persistence.mapper.ext;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 */

public interface ExtRepairCommunityProjectRelaMapper {

    @Select({
        " SELECT a.phone, a.name, c.project_id as projectId, ",
        " d.name as projectName, b.loudong, b.floor, b.room ",
        " FROM master_child a ",
        " JOIN master_info b ON a.master_id = b.id ",
        " JOIN repair_community_project_rela c on c.community_id = b.community_id ",
        " JOIN community d on d.id = c.community_id  ",
        " where a.phone=#{phone,jdbcType=VARCHAR}"
    })
    public List<Map<String, String>> getRepairUserInfo(@Param("phone") String phone);
}
