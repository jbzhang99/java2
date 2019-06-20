package com.rfchina.community.open.bridge.controller.platform;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.service.openser.ExpressCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ExpressController
 * @Description 快递相关接口
 * @Author wlrllr
 * @Date 2019/2/18 15:57
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM )
public class ExpressController extends BaseController {

    @Autowired
    private ExpressCompanyService expressCompanyService;

    @PostMapping(value = "/getExpressAuthorizeUrl")
    public Result<?> getExpressAuthorizeUrl(String companyCode, String expressNo){
        return Result.successData(expressCompanyService.getExpressAuthorizeUrl(companyCode,expressNo));
    }
}
