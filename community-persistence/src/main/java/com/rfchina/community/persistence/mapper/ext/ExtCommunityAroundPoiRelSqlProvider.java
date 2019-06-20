package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.CommunityAroundPoiRelSqlProvider;
import com.rfchina.community.persistence.model.CommunityAroundPoiRel;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CommunityAroundPoiRelSqlProvider
 * @Author wlrllr
 * @Date 2019/4/24 10:24
 * @Version 1.0
 **/
public class ExtCommunityAroundPoiRelSqlProvider extends CommunityAroundPoiRelSqlProvider {

    public String batchInsert(Map map) {
        List<CommunityAroundPoiRel> list = (List<CommunityAroundPoiRel>) map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("insert into community_around_poi_rel (community_id, poi_id,distance) VALUES ");
        MessageFormat mf = new MessageFormat(
                "(#'{'list[{0}].communityId}, #'{'list[{0}].poiId}, #'{'list[{0}].distance})"
        );
        for (int i = 0; i < list.size(); i++) {
            sb.append(mf.format(new Object[]{i}));
            if (i < list.size() - 1)
                sb.append(",");
        }
        return sb.toString();
    }
}
