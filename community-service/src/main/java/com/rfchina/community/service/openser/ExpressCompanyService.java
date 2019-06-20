package com.rfchina.community.service.openser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.api.response.model.express.ExpressAuthorizeUrlResponse;
import com.rfchina.api.response.model.express.ExpressCompany;
import com.rfchina.api.response.model.express.ExpressProgressResponse;
import com.rfchina.api.response.model.express.QueryCommCodeByNumberResponse;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.SysConstant;
import com.rfchina.community.base.util.PingYinUtils;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.persistence.mapper.BaseMapper;
import com.rfchina.community.persistence.mapper.ExpressCompanyUsageMapper;
import com.rfchina.community.persistence.mapper.ext.ExtExpressCompanyUsageMapper;
import com.rfchina.community.persistence.model.ExpressCompanyUsage;
import com.rfchina.community.persistence.model.ExpressCompanyUsageExample;
import com.rfchina.community.service.AbstractService;
import com.rfchina.community.service.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName ExpressCompanyService
 * @Description 快递公司相关接口，
 * @Author wlrllr
 * @Date 2019/1/30 17:38
 * @Version 1.0
 **/
@Service
public class ExpressCompanyService extends AbstractService<ExpressCompanyUsage, ExpressCompanyUsageExample, Long> {

    @Autowired
    private RedisService redisService;
    @Autowired
    private ExtExpressCompanyUsageMapper expressCompanyUsageMapper;

    @Autowired
    private PlatformGlobalComponent platformGlobalComponent;

    private static final Long TIMEOUT = 7*24*60* 70L;

    @Override
    public BaseMapper<ExpressCompanyUsage, ExpressCompanyUsageExample, Long> getMapper() {
        return expressCompanyUsageMapper;
    }

    /**
     * @return java.util.List<com.rfchina.community.persistence.model.ExpressCompanyUsage>
     * @Author wlrllr
     * @Description //查找某个服务常用的快递
     * @Date 2019/2/2
     * @Param [serviceId]
     **/
    public List<ExpressCompanyUsage> findExpressCompanyUsage(Long serviceId) {
        ExpressCompanyUsageExample example = new ExpressCompanyUsageExample();
        example.createCriteria().andServiceIdEqualTo(serviceId).andStatusEqualTo(SysConstant.COMMON_STATUS_NORMAL);
        example.setOrderByClause("create_time DESC,usage_count DESC");
        return expressCompanyUsageMapper.selectByExample(example);
    }

    /**
     * @return int
     * @Author wlrllr
     * @Description //商家快递公司使用次数+1
     * @Date 2019/2/3
     * @Param [serviceId, comCode]
     **/
    public int addExpressUsage(Long serviceId, String comCode,String comName) {
        if (serviceId != null && StringUtils.isNotBlank(comCode)){
            ExpressCompanyUsageExample example = new ExpressCompanyUsageExample();
            example.createCriteria().andServiceIdEqualTo(serviceId).andComCodeEqualTo(comCode);
            List<ExpressCompanyUsage> list = expressCompanyUsageMapper.selectByExample(example);
            if(list != null && list.size()>0){
                return expressCompanyUsageMapper.addUsage(serviceId, comCode, 1);
            }else{
                ExpressCompanyUsage usage = new ExpressCompanyUsage();
                usage.setComCode(comCode);
                usage.setComName(comName);
                usage.setCreateTime(new Date());
                usage.setServiceId(serviceId);
                usage.setUsageCount(1);
                usage.setStatus(SysConstant.COMMON_STATUS_NORMAL);
                return expressCompanyUsageMapper.insert(usage);
            }
        }
        return 0;
    }

    public List findCompanyService(String key) {
        JSONArray companyArray = getAllExpressCompany();
        if (companyArray != null && !companyArray.isEmpty()) {
            return companyArray.stream().filter(o -> {
                JSONObject obj = (JSONObject) o;
                String py = obj.getString("py");
                String pyFirst = obj.getString("pyFirst");
                String comName = obj.getString("comName");
                String comCode = obj.getString("comCode");
                if (comName.contains(key) || py.contains(key) || pyFirst.contains(key) ||comCode.contains(key)) {
                    return true;
                }
                return false;
            }).collect(Collectors.toList());
        }
        return new ArrayList();
    }

    /**
     * @return java.util.List
     * @Author wlrllr
     * @Description //通过快递单号查询快递公司
     * @Date 2019/2/2
     * @Param [expressNo]
     **/
    public List findCompanyByExpressNo(String expressNo) {
        if (StringUtils.isNotBlank(expressNo)) {
            QueryCommCodeByNumberResponse response = platformGlobalComponent.queryExpressCompany(expressNo);
            if (response != null && !response.isEmpty()) {
                JSONArray companyArray = getAllExpressCompany();
                List result = new ArrayList(response.size());
                for (String comCode : response) {
                    for (int i = 0; i < companyArray.size(); i++) {
                        JSONObject obj = companyArray.getJSONObject(i);
                        if (comCode.equals(obj.getString("comCode"))) {
                            result.add(obj);
                        }
                    }
                }
                return result;
            }
        }
        return new ArrayList(0);
    }

    public JSONArray getAllExpressCompany() {
        String companyStr = redisService.get(SysConstant.REDIS_EXPRESS_COMPANY_KEY);
        if (StringUtils.isNotBlank(companyStr)) {
            return JSONObject.parseArray(companyStr);
        }
        return null;
    }

    /**
     * @Author wlrllr
     * @Description //刷新快递公司到redis
     * @Date 2019/2/19
     * @Param []
     * @return void
     **/
    public void syncCompanyInfo(){
        List<ExpressCompany> list = platformGlobalComponent.queryExpressCompany();
        JSONArray array = new JSONArray();
        if(list != null && list.size()>0){
            for(ExpressCompany company : list){
                JSONObject obj = (JSONObject)JSONObject.toJSON(company);
                obj.remove("remark");
                JSONObject py = PingYinUtils.getPingYinAll(company.getComName());
                obj.putAll(py);
                obj.put("first",py.getString("py").charAt(0));
                array.add(obj);
            }
        }
        if(!array.isEmpty()){
            redisService.set(SysConstant.REDIS_EXPRESS_COMPANY_KEY,JSONObject.toJSONString(array),TIMEOUT);
        }
    }


    public ExpressProgressResponse getExpressProgress(String companyCode, String expressNo){
        return platformGlobalComponent.queryExpressProgress(companyCode,expressNo);
    }

    public String getExpressAuthorizeUrl(String companyCode, String expressNo){
        ExpressAuthorizeUrlResponse response = platformGlobalComponent.queryExpressAuthorizeUrl(companyCode,expressNo);
        if(response != null){
            return response.getAuthorizeUrl();
        }
        return null;
    }

}
