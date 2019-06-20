package com.rfchina.community.open.bridge.controller.community;

import java.util.Date;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.persistence.mapper.CommunityMapper;
import com.rfchina.community.persistence.mapper.PaySettlementInfoMapper;
import com.rfchina.community.persistence.mapper.ext.ExtOpenSettCommunityAdminMapper;
import com.rfchina.community.persistence.model.PaySettlementInfo;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_COMMUNITY)
public class OpenSettlCommunityAdminController extends BaseController {

    @Autowired
    private ExtOpenSettCommunityAdminMapper extOpenSettCommunityAdminMapper;

    @Autowired
    private PaySettlementInfoMapper paySettlementInfoMapper;

    @Autowired
    private CommunityMapper communityMapper;

    @RequestMapping("/openSettCommunityList")
    public Result<?> openSettCommunityList(
            @RequestParam(value = "cityId", required = false, defaultValue = "0") int cityId,
            @RequestParam(value = "communityIds", required = false, defaultValue = "0") String communityIds,
            @RequestParam(value = "title", required = false) String title1,
            @RequestParam(value = "begin_create_time", required = false) String begin_create_time1,
            @RequestParam(value = "end_create_time", required = false) String end_create_time1,
            @RequestParam(value = "account_id", required = false) String account_id1,
            @RequestParam(value = "set_id", required = false) String set_id1,
            @RequestParam(value = "pf_status", required = false) String pf_status1,
            // @RequestParam(value = "community_id", required = false) String community_id1,
            @RequestParam(value = "index", required = false, defaultValue = "1") int index,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size) throws Exception {
        // int commid=getCommunityId();
        // Integer commid = getCommunityId();
        // 现在只能查询一个社区,2017-12-15
        Integer commid = Integer.valueOf(communityIds);
        String title = null;
        Integer pf_status = null;
        String account_id = null;
        Date end_create_time = null;
        Date begin_create_time = null;
        String set_id = null;
        Integer community_id = commid;
        if (StringUtils.isNotEmpty(begin_create_time1)) {
            begin_create_time = DateTimeUtils.parseDateTime(begin_create_time1);
        }
        if (StringUtils.isNotEmpty(end_create_time1)) {
            end_create_time = DateTimeUtils.parseDateTime(end_create_time1);
        }
        // if (StringUtils.isNotEmpty(community_id1)) {
        // community_id = Integer.valueOf(community_id1);
        // }

        if (StringUtils.isNotEmpty(pf_status1)) {
            pf_status = Integer.valueOf(pf_status1);
        }
        if (StringUtils.isNotEmpty(account_id1)) {
            account_id = account_id1;
        }
        if (StringUtils.isNotEmpty(set_id1)) {
            set_id = set_id1;
        }
        if (StringUtils.isNotEmpty(title1)) {
            title = "%" + title1 + "%";
        }

        PageBounds pageBounds = new PageBounds(index, size);

        PageList<Map<String, Object>> data = extOpenSettCommunityAdminMapper.selectByExample(community_id, pf_status,
                set_id, begin_create_time, end_create_time, title, account_id, true, pageBounds);
        for (Map<String, Object> map : data) {
            // Integer community_id2 = MapUtils.getInteger(map, "community_id", 0);
            String setid = MapUtils.getString(map, "set_id", "");
            PaySettlementInfo settl = null;
            if (StringUtils.isNotEmpty(setid)) {
                settl = paySettlementInfoMapper.selectByPrimaryKey(setid);
            } else {
                // settl = new PaySettlementInfo();
            }
            // Community community = null;
            // if (community_id2 != null && community_id2 > 0) {
            // community = communityMapper.selectByPrimaryKey(community_id2);
            // community.setIntro("");
            // } else {
            // // settl = new PaySettlementInfo();
            // }

            // map.put("community", community);
            map.put("settl", settl);
        }
        return Result.successData(data.convert());
    }

}
