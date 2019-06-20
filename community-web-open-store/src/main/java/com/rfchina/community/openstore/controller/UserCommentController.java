package com.rfchina.community.openstore.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.service.openser.UserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserCommentController
 * @Description 用户评价接口
 * @Author wlrllr
 * @Date 2019/2/18 9:50
 * @Version 1.0
 **/
@RestController
@RequestMapping(value= Constant.ROOT_PATH_OPENSTORE)
public class UserCommentController extends BaseController {

    @Autowired
    private UserCommentService userCommentService;

    /**
     * @Author wlrllr
     * @Description //查询某个服务或者商品的所有评论
     * @Date 2019/2/18
     * @Param [commentTarget]
     * @return java.util.List<com.rfchina.community.persistence.model.UserComment>
     **/
    @PostMapping("/comment_get")
    public Result<?> getComments(Long commentTarget,Integer index,Integer size){
        Page page = PageHelper.startPage(index, size);
        userCommentService.getByGoodsId(commentTarget,index,size);
        PageInfo pageInfo = new PageInfo(page);
        return Result.successData(pageInfo);
    }

    @PostMapping("/pageComment")
    public Result<?> pageComment(Long commentTarget,String commentTargetType,Integer index,Integer size){
        Page page = PageHelper.startPage(index, size);
        userCommentService.pageComment(commentTarget,commentTargetType,index,size);
        PageInfo pageInfo = new PageInfo(page);
        return Result.successData(pageInfo);
    }

    /**
     * @Author wlrllr
     * @Description //评论
     * @Date 2019/2/20
     * @Param [commentTarget, outTradeNo,commentator]
     * @return com.rfchina.community.base.Result
     **/
    @PostMapping("/comment_add")
    public Result add(@RequestParam String commentTarget,
                      @RequestParam(value = "clientType", required = false, defaultValue = "APP") String clientType,
                      @RequestParam(value = "access_token", required = false) String accessToken,
                      @RequestParam(value = "outTradeNo", required = false) String outTradeNo,
                      @RequestParam(value = "orderId", required = false) Integer orderId){
        logger.info("订单评价...");
        Long userId = validateAndGetUid(clientType, accessToken);
        validator(userId == null, "参数异常，用户ID为空");
        userCommentService.comment(JSONObject.parseArray(commentTarget),userId,outTradeNo,orderId);
        return Result.success();
    }

    /**
     * @Author wlrllr
     * @Description //评论回复
     * @Date 2019/2/18
     * @Param [commentId, commentator, comment]
     * @return com.rfchina.community.base.Result
     **/
    @PostMapping("/comment_reply")
    public Result reply(Long commentId,Long commentator,String comment){
        userCommentService.reply(commentId,null,comment,commentator);
        return Result.success();
    }
}
