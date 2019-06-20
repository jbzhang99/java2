package com.rfchina.community.service.openser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.OrderPayConstant;
import com.rfchina.community.base.SysConstant;
import com.rfchina.community.persistence.mapper.BaseMapper;
import com.rfchina.community.persistence.mapper.OpenStoreGoodOrderRelMapper;
import com.rfchina.community.persistence.mapper.OpenStoreOrderMapper;
import com.rfchina.community.persistence.mapper.UserCommentReplyMapper;
import com.rfchina.community.persistence.mapper.ext.ExtUserCommentMapper;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.persistence.model.ext.ExtUserComment;
import com.rfchina.community.service.AbstractService;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.Page;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName UserCommentService
 * @Description 用户评价接口
 * @Author wlrllr
 * @Date 2019/2/18 9:44
 * @Version 1.0
 **/
@Service
public class UserCommentService extends AbstractService<UserComment, UserCommentExample, Long> {

    @Autowired
    private ExtUserCommentMapper extUserCommentMapper;
    @Autowired
    private UserCommentReplyMapper userCommentReplyMapper;
    @Autowired
    private OpenStoreOrderMapper openStoreOrderMapper;
    @Autowired
    private OpenStoreGoodOrderRelMapper openStoreGoodOrderRelMapper;
    @Autowired
    private OpenStoreOrderBaseService openStoreOrderBaseService;
    @Autowired
    private RedisService redisService;

    @Override
    public BaseMapper<UserComment, UserCommentExample, Long> getMapper() {
        return extUserCommentMapper;
    }

    /**
     * @return org.mybatis.paginator.model.PageList
     * @Author wlrllr
     * @Description //查询用户评价
     * @Date 2019/2/21
     * @Param startTime endTime
     * merchantName//店铺
     * goodsName//商品
     * goodsGrade //评分
     * status//评论状态
     * goodsType//商品分类
     * community//社区
     * serviceName//商家
     * outTradeNo //交易流水号
     * userTelephone//用户手机
     * cityId//城市
     * logisticsGrade //物流评分
     * serviceGrade //服务评分
     **/
    public Page<ExtUserComment> queryUserComment(Map param) {
        String startTime = MapUtils.getString(param, "startTime");
        String endTime = MapUtils.getString(param, "endTime");
        Integer index = MapUtils.getInteger(param, "index");
        Integer size = MapUtils.getInteger(param, "size");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = null;
        Date endDate = null;
        try {
            if (StringUtils.isNotBlank(startTime)) {
                startDate = sdf.parse(startTime.trim());
                param.put("startTime", startDate);
            }
            if (StringUtils.isNotBlank(endTime)) {
                endDate = sdf.parse(endTime.trim());
                param.put("endTime", endDate);
            }
        } catch (ParseException e) {
            error("时间格式错误");
        }
        if (startDate != null && endDate != null && startDate.after(endDate)) {
            error("开始时间不能大于结束时间");
        }
        addLike(param, "merchantName");
        addLike(param, "goodsName");
        addLike(param, "serviceName");
        PageList page = extUserCommentMapper.pageByCondition(param, new PageBounds(index, size));
        return page.convert();
    }

    /**
     * @return org.mybatis.paginator.model.Page<com.rfchina.community.persistence.model.ext.ExtUserComment>
     * @Author wlrllr
     * @Description //通过商品或店铺查询评论 商家端或者平台端使用，关联查询所有已屏蔽和未屏蔽的商家回复内容
     * @Date 2019/3/11
     * @Param [targetId, index, size]
     **/
    public Page<ExtUserComment> getByTargetId(Long targetId, Integer index, Integer size) {
        index = index == null ? 1 : index;
        size = size == null ? SysConstant.PAGE_SIZE : size;
        PageList<ExtUserComment> pageList = extUserCommentMapper.pageTargetComment(targetId, new PageBounds(index, size));
        return pageList.convert();
    }

    /**
     * @return org.mybatis.paginator.model.Page<com.rfchina.community.persistence.model.ext.ExtUserComment>
     * store项目无法采用paginator分页，
     * @Author wlrllr
     * @Description //通过商品或店铺查询评论 用户端使用，关联查询出未屏蔽的商家回复内容
     * @Date 2019/3/11
     * @Param [targetId, index, size]
     **/
    public List<ExtUserComment> getByGoodsId(Long goodsId, Integer index, Integer size) {
        return extUserCommentMapper.pageGoodsComment(goodsId, new PageBounds(index, size));
    }

    /**
     * @return int
     * @Author wlrllr
     * @Description //批量新增评论,全量新增，需要校验新增数据完整性
     * @Date 2019/2/18
     * @Param [list]
     **/
    @Transactional
    public int comment(JSONArray commentTarget, Long commentator, String outTradeNo, Integer orderId) {
        int num = 0;
        if (StringUtils.isBlank(outTradeNo)) {
            if (orderId != null) {
                OpenStoreOrder order = openStoreOrderMapper.selectByPrimaryKey(orderId);
                if (order != null) {
                    outTradeNo = order.getOutTradeNo();
                }
            }
        }
        validator(StringUtils.isBlank(outTradeNo), "参数异常，交易流水号为空");
        OpenStoreOrder openStoreOrder = openStoreOrderBaseService.findByOutTradeNo(outTradeNo);
        validator(openStoreOrder == null, "订单不存在");
        validator(!SysConstant.COMMON_STATUS_HIDE.equals(openStoreOrder.getCommentStatus()), "该订单不能评论");
        List<UserComment> result = validateAddParams(commentTarget, outTradeNo, commentator);
        if (result != null) {
            num = batchAdd(result);
            if (num > 0) {
                OpenStoreOrder temp = new OpenStoreOrder();
                temp.setCommentStatus(SysConstant.COMMON_STATUS_NORMAL); //已评价
                temp.setId(openStoreOrder.getId());
                openStoreOrderBaseService.updateByPrimaryKeySelective(temp);
            }
        }
        return num;
    }

    /**
     * @return int
     * @Author wlrllr
     * @Description //批量新增评论,全量新增，需要校验新增数据完整性
     * @Date 2019/2/18
     * @Param [list]
     **/
    public int batchAdd(List<UserComment> list) {
        int num = 0;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); ) {
                int end = i + SysConstant.BATCH_INSERT;
                if (end > list.size()) {
                    end = list.size();
                }
                num += extUserCommentMapper.batchInsert(list.subList(i, end));
                i = end;
            }
        }
        return num;
    }

    /**
     * @return int
     * @Author wlrllr
     * @Description //回复评论
     * @Date 2019/2/18
     * @Param [commentId, replyTarget, comment, commentator]
     **/
    public UserCommentReply reply(Long commentId, Long replyTarget, String comment, Long commentator) {
        UserComment userComment = extUserCommentMapper.selectByPrimaryKey(commentId);
        validator(userComment == null, "评论不存在，不允许回复");
        validator(!SysConstant.COMMON_STATUS_NORMAL.equals(userComment.getReplyStatus()), "该评论不允许回复");
        UserCommentReply reply = new UserCommentReply();
        reply.setCommentator(commentator);
        reply.setCommentId(commentId);
        reply.setCreateTime(new Date());
        reply.setReplyComment(comment);
        reply.setReplyTarget(replyTarget);
        reply.setStatus(SysConstant.COMMON_STATUS_NORMAL);
        int i = userCommentReplyMapper.insert(reply);
        if (i <= 0) {
            return null;
        }
        return reply;
    }

    public int updateCommentStatus(Long commentId, String status, boolean replyFlag) {
        UserComment userComment = extUserCommentMapper.selectByPrimaryKey(commentId);
        if (userComment != null) {
            UserComment comment = new UserComment();
            comment.setId(commentId);
            if (replyFlag) {
                comment.setReplyStatus(status);
            } else {
                comment.setStatus(status);
            }
            return extUserCommentMapper.updateByPrimaryKeySelective(comment);
        }
        return 0;
    }


    public int deleteComment(Long commentId) {
        UserComment userComment = new UserComment();
        userComment.setId(commentId);
        userComment.setStatus(SysConstant.COMMON_STATUS_DISABLE);
        return extUserCommentMapper.updateByPrimaryKeySelective(userComment);
    }

    public long countByTargetId(Long targetId,String type) {
        UserCommentExample example = new UserCommentExample();
        example.createCriteria().andCommentTargetEqualTo(targetId).andCommentTargetTypeEqualTo(type);
        return extUserCommentMapper.countByExample(example);
    }

    /**
     * @return int
     * @Author wlrllr
     * @Description //屏蔽评论的回复信息
     * @Date 2019/2/20
     * @Param [commentId]
     **/
    public int maskReply(Long commentId) {
        UserCommentReplyExample example = new UserCommentReplyExample();
        example.createCriteria().andCommentIdEqualTo(commentId);
        UserCommentReply reply = new UserCommentReply();
        reply.setStatus(SysConstant.COMMON_STATUS_HIDE);
        return userCommentReplyMapper.updateByExampleSelective(reply, example);
    }


    /**
     * @return java.util.List<com.rfchina.community.persistence.model.UserComment>
     * @Author wlrllr
     * @Description //通过商品或店铺查询评论
     * @Date 2019/2/18
     * @Param [commentTarget]
     **/
    public List<ExtUserComment> getFirstGoodComment(Integer goodsId) {
        return extUserCommentMapper.getFirstGoodComment(goodsId);
    }


    /**
     * @return int
     * @Author wlrllr
     * @Description //自动评价
     * @Date 2019/3/8
     * @Param [autoCommentLength]
     **/
    public int autoComment(Long autoCommentLength) {
        OpenStoreOrderExample example = new OpenStoreOrderExample();
        example.createCriteria().andPayStatusEqualTo(OrderPayConstant.PayStatus.PAY.getCode())
                .andCommentStatusIn(Arrays.asList(SysConstant.COMMON_STATUS_HIDE, SysConstant.COMMON_STATUS_DISABLE))
                .andOutTradeNoIsNotNull().andConfirmTimeIsNotNull()
                .andConfirmTimeLessThan(new Date(System.currentTimeMillis() - autoCommentLength));
        List<OpenStoreOrder> list = openStoreOrderMapper.selectByExample(example);
        int num = 0;
        //标记订单正在处理中
        if (list != null) {
            for (OpenStoreOrder order : list) {
                lockOrderComment(order);
                String key = SysConstant.REDIS_COMMENT_ORDER_KEY + order.getId();
                String value = redisService.get(key);
                if (SysConstant.REDIS_COMMENT_ORDER_DEFAULT_VALUE.equals(value)) {
                    logger.info("该订单正在处理中...");
                    continue;
                }
                try {
                    //设置30s过期，如果执行异常，30秒后自动失效，等待下次处理
                    redisService.set(key, SysConstant.REDIS_COMMENT_ORDER_DEFAULT_VALUE, 30l);
                    comment(order);
                    num++;
                } catch (Exception e) {
                    logger.error("自动评价订单时异常...", e);
                } finally {
                    redisService.remove(key);
                }
            }
        }
        return num;
    }

    @Transactional
    public void comment(OpenStoreOrder order) {
        if (order != null) {
            List<UserComment> list = buildCommentByOrder(order);
            if (list != null && list.size() > 0) {
                if (batchAdd(list) > 0) {
                    OpenStoreOrder openStoreOrder = new OpenStoreOrder();
                    openStoreOrder.setCommentStatus(SysConstant.COMMON_STATUS_NORMAL); //已评价
                    OpenStoreOrderExample example = new OpenStoreOrderExample();
                    example.createCriteria().andOutTradeNoEqualTo(order.getOutTradeNo());
                    openStoreOrderMapper.updateByExampleSelective(openStoreOrder, example);
                }
            }
        }
    }

    /**
     * @return org.mybatis.paginator.model.Page<com.rfchina.community.persistence.model.ext.ExtUserComment>
     * @Author wlrllr
     * @Description //通过商品或店铺查询评论 商家端或者平台端使用，关联查询所有已屏蔽和未屏蔽的商家回复内容
     * @Date 2019/3/11
     * @Param [targetId, index, size]
     **/
    public ExtUserComment getByCommentId(Long commentId) {
        return extUserCommentMapper.getCommentById(commentId);
    }


    /**
     * @return int
     * @Author wlrllr
     * @Description //批量新增评论,全量新增，需要校验新增数据完整性
     * @Date 2019/2/18
     * @Param [list]
     **/
    public UserComment getByOutTradeNo(String outTradeNo) {
        if (StringUtils.isNotBlank(outTradeNo)) {
            UserCommentExample example = new UserCommentExample();
            example.createCriteria().andOutTradeNoEqualTo(outTradeNo).andCommentTargetTypeEqualTo(SysConstant.COMMENT_TARGET_TYPE_GOODS);
            List<UserComment> list = extUserCommentMapper.selectByExample(example);
            if (list != null && list.size() > 0) {
                return list.get(0);
            }
        }
        return null;
    }

    /**
     * @return long
     * @Author wlrllr
     * @Description //计算商品评论总数
     * @Date 2019/3/19
     * @Param [goodsId]
     **/
    public long countByGoodsId(Integer goodsId) {
        UserCommentExample example = new UserCommentExample();
        example.createCriteria().andCommentTargetTypeEqualTo(SysConstant.COMMENT_TARGET_TYPE_GOODS).andCommentTargetEqualTo((long) goodsId).andStatusEqualTo(SysConstant.COMMON_STATUS_NORMAL);
        return extUserCommentMapper.countByExample(example);
    }

    public PageList<ExtUserComment> pageComment(Long targetId, String targetType, Integer index, Integer size) {
        index = index == null ? 1 : index;
        size = size == null ? SysConstant.PAGE_SIZE : size;
        return extUserCommentMapper.pageComment(targetId, targetType, new PageBounds(index, size));
    }

    private void addLike(Map param, Object key) {
        Object value = param.get(key);
        if (value != null && StringUtils.isNotBlank(value.toString())) {
            param.put(key, "%" + value + "%");
        }
    }

    private List<UserComment> validateAddParams(JSONArray commentTarget, String outTradeNo, Long commentator) {
        if (commentTarget != null && !commentTarget.isEmpty()) {
            List<UserComment> list = new ArrayList<>();
            Date now = new Date();
            commentTarget.stream().forEach(obj -> buildComment(commentator, outTradeNo, list, now, (JSONObject) obj));
            return list;
        }
        return null;
    }

    private void buildComment(Long commentator, String outTradeNo, List<UserComment> list, Date now, JSONObject obj) {
        UserComment userComment = new UserComment();
        String targetType = obj.getString("targetType");
        userComment.setCreateTime(now);
        userComment.setOutTradeNo(outTradeNo);
        userComment.setCommentTargetType(targetType);
        userComment.setCommentator(commentator);
        userComment.setStatus(SysConstant.COMMON_STATUS_NORMAL);
        userComment.setReplyStatus(SysConstant.COMMON_STATUS_NORMAL);
        if (SysConstant.COMMENT_TARGET_TYPE_GOODS.equals(targetType)) {
            Long targetId = obj.getLong("goodId");
            validator(targetId == null, "参数异常，商品ID为空");
            userComment.setCommentTarget(targetId);
            String picUrl = obj.getString("picUrl");
            Integer goodsGrade = obj.getInteger("goodsGrade");
            String comment = obj.getString("comment");
            //validator(StringUtils.isBlank(picUrl), "参数异常，图片不能为空");
            validator(goodsGrade == null, "请进行商品评星");
            validator(StringUtils.isBlank(comment), "商品评价内容为空");
            userComment.setPicUrl(picUrl);
            userComment.setGoodsGrade(goodsGrade);
            userComment.setComment(comment);
            if (goodsGrade <= 3) {
                userComment.setStatus(SysConstant.COMMON_STATUS_HIDE);
            }
        } else if (SysConstant.COMMENT_TARGET_TYPE_MERCHANT.equals(targetType)) {
            Long targetId = obj.getLong("serviceId");
            validator(targetId == null, "参数异常，商家ID为空");
            userComment.setCommentTarget(targetId);
            Integer serviceGrade = obj.getInteger("serviceGrade");
            Integer logisticsGrade = obj.getInteger("logisticsGrade");
            validator(serviceGrade == null, "请进行服务评星");
            validator(logisticsGrade == null, "请进行物流评星");
            userComment.setServiceGrade(serviceGrade);
            userComment.setLogisticsGrade(logisticsGrade);
        } else {
            logger.error("用户评价时，参数异常", JSONObject.toJSONString(list));
            error("参数异常");
        }
        list.add(userComment);
    }

    private List<UserComment> buildCommentByOrder(OpenStoreOrder order) {
        List<UserComment> list = new ArrayList<>();
        // 构建对订单商家服务的评价
        UserComment userCommentMerchant = new UserComment();
        Date now = new Date();
        userCommentMerchant.setCreateTime(now);
        userCommentMerchant.setOutTradeNo(order.getOutTradeNo());
        userCommentMerchant.setCommentTargetType(SysConstant.COMMENT_TARGET_TYPE_MERCHANT);
        userCommentMerchant.setCommentTarget(order.getServiceId().longValue());
        userCommentMerchant.setCommentator(order.getUserId());
        userCommentMerchant.setStatus(SysConstant.COMMON_STATUS_NORMAL);
        userCommentMerchant.setReplyStatus(SysConstant.COMMON_STATUS_NORMAL);
        userCommentMerchant.setServiceGrade(SysConstant.COMMENT_GRADE_5);
        userCommentMerchant.setLogisticsGrade(SysConstant.COMMENT_GRADE_5);
        list.add(userCommentMerchant);
        // 构建对订单商品的评价
        OpenStoreGoodOrderRelExample example = new OpenStoreGoodOrderRelExample();
        example.createCriteria().andOrderIdEqualTo(order.getId());
        List<OpenStoreGoodOrderRel> openStoreGoodOrderRelList = openStoreGoodOrderRelMapper.selectByExample(example);
        if (openStoreGoodOrderRelList != null && openStoreGoodOrderRelList.size() > 0) {
            for (OpenStoreGoodOrderRel rel : openStoreGoodOrderRelList) {
                UserComment userCommentGoods = new UserComment();
                BeanUtils.copyProperties(userCommentMerchant, userCommentGoods);
                userCommentGoods.setServiceGrade(null);
                userCommentGoods.setLogisticsGrade(null);
                userCommentGoods.setCommentTargetType(SysConstant.COMMENT_TARGET_TYPE_GOODS);
                userCommentGoods.setGoodsGrade(SysConstant.COMMENT_GRADE_5);
                userCommentGoods.setCommentTarget(rel.getGoodId().longValue());
                list.add(userCommentGoods);
            }
        }
        return list;
    }

    /**
     * @return void
     * @Author wlrllr
     * @Description //锁定订单标记为逾期未评价
     * @Date 2019/3/11
     * @Param [order]
     **/
    private void lockOrderComment(OpenStoreOrder order) {
        OpenStoreOrder temp = new OpenStoreOrder();
        temp.setId(order.getId());
        temp.setCommentStatus(SysConstant.COMMON_STATUS_DISABLE);
        //标记订单不可评价，防止用户端用户进行评价
        openStoreOrderMapper.updateByPrimaryKeySelective(temp);
    }
}
