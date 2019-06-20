package com.rfchina.community.openstore.controller;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.service.openser.ExpressCompanyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ExpressController
 * @Description 快递相关接口
 * @Author wlrllr
 * @Date 2019/2/18 15:57
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENSTORE )
public class ExpressController extends BaseController{

    @Autowired
    private ExpressCompanyService expressCompanyService;

    /**
     * @Author wlrllr
     * @Description //通过快递单号查询快递信息
     * @Date 2019/2/18
     * @Param [expressNo]
     * @return com.rfchina.community.base.Result<?>
     **/
    @PostMapping(value = "/getExpressInfo")
    public Result<?> getExpressInfo(String companyCode,String expressNo){
        return Result.successData( expressCompanyService.getExpressProgress(companyCode,expressNo));
    }

    /**
     * @Author wlrllr
     * @Description //通过快递单号查询快递公司
     * @Date 2019/2/18
     * @Param [expressNo]
     * @return com.rfchina.community.base.Result<?>
     **/
    @PostMapping(value = "/getExpressCompany")
    public Result<?> getExpressCompany(String expressNo){
        return Result.successData(expressCompanyService.findCompanyByExpressNo(expressNo));
    }

    /**
     * @Author wlrllr
     * @Description //查询店铺的常用快递信息
     * @Date 2019/2/18
     * @Param [serviceId]
     * @return com.rfchina.community.base.Result<?>
     **/
    @PostMapping(value = "/getUsageExpressCompany")
    public Result<?> getUsageExpressCompany(Long serviceId){
        return Result.successData(expressCompanyService.findExpressCompanyUsage(serviceId));
    }

    /**
     * @Author wlrllr
     * @Description //根据关键字查询快递公司
     * @Date 2019/2/18
     * @Param [key]
     * @return com.rfchina.community.base.Result<?>
     **/
    @PostMapping(value = "/getExpressCompanyByKey")
    public Result<?> findExpressCompany(String key){
        if(StringUtils.isNotBlank(key)){
            return Result.successData(expressCompanyService.findCompanyService(key));
        }
        return Result.success();
    }

    /**
     * @Author wlrllr
     * @Description //查询所有公司
     * @Date 2019/2/20
     * @Param []
     * @return com.rfchina.community.base.Result<?>
     **/
    @PostMapping(value = "/getAllExpressCompany")
    public Result<?> getAllExpressCompany(){
        return Result.successData(expressCompanyService.getAllExpressCompany());
    }

    @PostMapping(value = "/getExpressAuthorizeUrl")
    public Result<?> getExpressAuthorizeUrl(String companyCode, String expressNo){
        return Result.successData(expressCompanyService.getExpressAuthorizeUrl(companyCode,expressNo));
    }
}
