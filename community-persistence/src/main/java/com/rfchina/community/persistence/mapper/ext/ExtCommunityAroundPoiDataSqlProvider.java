package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.CommunityAroundPoiDataSqlProvider;
import com.rfchina.community.persistence.mapper.CommunityPicSqlProvider;
import com.rfchina.community.persistence.model.CommunityAroundPoiData;
import com.rfchina.community.persistence.model.CommunityPic;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CommunityAroundPoiDataSqlProvider
 * @Author wlrllr
 * @Date 2019/4/24 10:24
 * @Version 1.0
 **/
public class ExtCommunityAroundPoiDataSqlProvider extends CommunityAroundPoiDataSqlProvider {

    public String batchInsert(Map map) {
        List<CommunityAroundPoiData> list = (List<CommunityAroundPoiData>) map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("insert into community_around_poi_data(id,community_id,type_id,data,status) VALUES ");
        MessageFormat mf = new MessageFormat(
                "(#'{'list[{0}].id}, #'{'list[{0}].communityId}, #'{'list[{0}].typeId}, #'{'list[{0}].data}, #'{'list[{0}].status})"
        );
        for (int i = 0; i < list.size(); i++) {
            sb.append(mf.format(new Object[]{i}));
            if (i < list.size() - 1)
                sb.append(",");
        }
        return sb.toString();
    }
}
