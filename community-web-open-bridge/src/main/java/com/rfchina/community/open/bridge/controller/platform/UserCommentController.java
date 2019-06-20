package com.rfchina.community.open.bridge.controller.platform;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.SysConstant;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.service.openser.UserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @ClassName UserCommentController
 * @Description 用户评价接口
 * @Author wlrllr
 * @Date 2019/2/18 9:50
 * @Version 1.0
 **/
@RestController
@RequestMapping(value= OpenConstant.ROOT_PATH_PLATFORM)
public class UserCommentController extends BaseController {

    @Autowired
    private UserCommentService userCommentService;

    /**
     * @Author wlrllr
     * @Description //评价列表查询
     * @Date 2019/2/22
     * @Param [params]
     * @return com.rfchina.community.base.Result<?>
     **/
    @RequestMapping("/comment_query")
    public Result<?> queryComment(@RequestParam HashMap<String,Object> params) {
        return Result.successData(userCommentService.queryUserComment(params));
    }

    /**
     * @Author wlrllr
     * @Description //查询某个服务或者商品的所有评论
     * @Date 2019/2/18
     * @Param [commentTarget]
     * @return java.util.List<com.rfchina.community.persistence.model.UserComment>
     **/
    @RequestMapping("/comment_get")
    public Result<?> getComments(Long commentTarget,Integer index,Integer size){
        return Result.successData(userCommentService.getByTargetId(commentTarget,index,size));
    }

    /**
     * @Author wlrllr
     * @Description //评论上架
     * @Date 2019/2/20  
     * @Param [commentId, status]
     * @return com.rfchina.community.base.Result
     **/
    @RequestMapping("/comment_onShelves")
    public Result commentOnShelves(Long commentId){
        userCommentService.updateCommentStatus(commentId,SysConstant.COMMON_STATUS_NORMAL,false);
        return Result.success();
    }
    /**
     * @Author wlrllr
     * @Description //评论下架
     * @Date 2019/2/20
     * @Param [commentId, status]
     * @return com.rfchina.community.base.Result
     **/
    @RequestMapping("/comment_offShelves")
    public Result commentOffShelves(Long commentId){
        userCommentService.updateCommentStatus(commentId,SysConstant.COMMON_STATUS_HIDE,false);
        return Result.success();
    }

    /**
     * @Author wlrllr
     * @Description //评论允许回复
     * @Date 2019/2/20
     * @Param [commentId, status]
     * @return com.rfchina.community.base.Result
     **/
    @PostMapping("/comment_allowReply")
    public Result allowReply(Long commentId){
        userCommentService.updateCommentStatus(commentId,SysConstant.COMMON_STATUS_NORMAL,false);
        return Result.success();
    }

    /**
     * @Author wlrllr
     * @Description //评论禁止回复
     * @Date 2019/2/20
     * @Param [commentId, status]
     * @return com.rfchina.community.base.Result
     **/
    @RequestMapping("/comment_forbidReply")
    public Result forbidReply(Long commentId){
        userCommentService.updateCommentStatus(commentId,SysConstant.COMMON_STATUS_HIDE,true);
        return Result.success();
    }

    /**
     * @Author wlrllr
     * @Description //屏蔽评论的回复信息
     * @Date 2019/2/20
     * @Param [commentId]
     * @return com.rfchina.community.base.Result
     **/
    @RequestMapping("/comment_reply_offShelves")
    public Result maskReply(Long commentId){
        userCommentService.maskReply(commentId);
        return Result.success();
    }

    /**
     * @Author wlrllr
     * @Description //删除评论
     * @Date 2019/2/20
     * @Param [commentId, status]
     * @return com.rfchina.community.base.Result
     **/
    @RequestMapping("/comment_del")
    public Result deleteComment(Long commentId){
        userCommentService.deleteComment(commentId);
        return Result.success();
    }


    /**
     * @Author wlrllr
     * @Description //评论回复
     * @Date 2019/2/18
     * @Param [commentId, commentator, comment]
     * @return com.rfchina.community.base.Result
     **/
    @RequestMapping("/comment_reply")
    public Result reply(Long commentId,Long commentator,String comment){
        userCommentService.reply(commentId,null,comment,commentator);
        return Result.success();
    }

}
