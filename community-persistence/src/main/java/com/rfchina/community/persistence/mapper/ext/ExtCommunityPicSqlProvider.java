package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.CommunityPicMapper;
import com.rfchina.community.persistence.mapper.CommunityPicSqlProvider;
import com.rfchina.community.persistence.model.CommunityPic;
import com.rfchina.community.persistence.model.UserComment;
import org.apache.ibatis.annotations.Insert;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ExtCommunityAroundPoiTagMapper
 * @Author wlrllr
 * @Date 2019/4/24 10:24
 * @Version 1.0
 **/
public class ExtCommunityPicSqlProvider extends CommunityPicSqlProvider {

    public String batchInsert(Map map) {
        List<CommunityPic> list = (List<CommunityPic>) map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("insert into community_pic(target_id,pic_url,status) VALUES ");
        MessageFormat mf = new MessageFormat(
                "(#'{'list[{0}].targetId}, #'{'list[{0}].picUrl}, #'{'list[{0}].status})"
        );
        for (int i = 0; i < list.size(); i++) {
            sb.append(mf.format(new Object[]{i}));
            if (i < list.size() - 1)
                sb.append(",");
        }
        return sb.toString();
    }
}
