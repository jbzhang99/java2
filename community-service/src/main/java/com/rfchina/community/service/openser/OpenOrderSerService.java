package com.rfchina.community.service.openser;

import com.alibaba.fastjson.JSON;
import com.rfchina.api.response.model.express.ExpressProgressResponse;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OrderPayConstant;
import com.rfchina.community.base.SysConstant;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.persistence.mapper.OpenOrderMapper;
import com.rfchina.community.persistence.mapper.OpenOrderTotalMapper;
import com.rfchina.community.persistence.mapper.OpenStoreOrderRefundApplyMapper;
import com.rfchina.community.persistence.mapper.ext.ExtBaseOpenStoreOrderMapper;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.persistence.model.ext.OpenStoreOrderRefundApplyVO;
import com.rfchina.community.service.BaseService;
import com.rfchina.platform.common.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OpenOrderSerService extends BaseService {

	@Autowired
	private OpenOrderMapper openOrderMapper;
	@Autowired
	private OpenOrderTotalMapper openOrderTotalMapper;
	@Autowired
	private ExtBaseOpenStoreOrderMapper openStoreOrderMapper;
	@Autowired
	private OpenStoreOrderRefundApplyMapper openStoreOrderRefundApplyMapper;
	@Autowired
	private ExpressCompanyService expressCompanyService;


	public void insertOpenOrder(OpenOrder openOrder) {
		openOrderMapper.insertSelective(openOrder);
	}

	public int updateOpenOrderByPrimaryKey(OpenOrder openOrder) {
		return openOrderMapper.updateByPrimaryKeySelective(openOrder);
	}

	public long uniqueOutTradeNo(String outTradeNo, Long appId) {
		OpenOrderExample example = new OpenOrderExample();
		example.createCriteria().andOutTradeNoEqualTo(outTradeNo).andAppIdEqualTo(appId);
		return openOrderMapper.countByExample(example);
	}

	public OpenOrder getOpenOrder(String outTradeNo, Long appId) {
		OpenOrderExample example = new OpenOrderExample();
		example.createCriteria().andOutTradeNoEqualTo(outTradeNo).andAppIdEqualTo(appId);
		List<OpenOrder> list = openOrderMapper.selectByExample(example);
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

	public OpenOrder getOpenOrderByMerchantBillId(String merchantBillId) {
		OpenOrderExample example = new OpenOrderExample();
		example.createCriteria().andMerchantBillIdEqualTo(merchantBillId);
		List<OpenOrder> list = openOrderMapper.selectByExample(example);
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

	public OpenOrder getOpenOrder(String outTradeNo) {
		if(StringUtils.isNotBlank(outTradeNo)){
			OpenOrderExample example = new OpenOrderExample();
			example.createCriteria().andOutTradeNoEqualTo(outTradeNo);
			List<OpenOrder> list = openOrderMapper.selectByExample(example);
			if (list.isEmpty())
				return null;
			return list.get(0);
		}
		return null;
	}

	private static Logger logger = LoggerFactory.getLogger(OpenOrderSerService.class);
	
	public int payRefund(Long appId, String outTradeNo, int day, String refund_reason, int sameWay) {
		if (appId <= 0) {
			error("发起失败,appid不能为空");
		}

		OpenOrder order = getOpenOrder(outTradeNo, appId);
        validator(order == null, "发起失败,该订单不存在:" + outTradeNo);
        logger.info("{}", JSON.toJSONString(order));
		Long totalId = order.getTotalId();

		validator(order.getBillStatus() != 2, "发起失败,该订单未支付,不能退款:" + outTradeNo);
		// 退款申请失败，订单超过可退款限期（支付成功起14天内可申请退款）。请自行联系买家解决退款事宜。
		validator(order.getBillSplitStatus() == 1, "退款申请失败，订单超过可退款限期（支付成功起" + day + "天内可申请退款）。请自行联系买家解决退款事宜。");
		validator(order.getRefundStatus() == 1, "发起失败,该订单在退款中,请不要重复发起退款:" + outTradeNo);
		validator(order.getRefundStatus() == 2, "发起失败,该订单已经完成退款:" + outTradeNo);

		// Date1.after(Date2),当Date1大于Date2时，返回TRUE，当小于等于时，返回false；
		// Date1.before(Date2)，当Date1小于Date2时，返回TRUE，当大于等于时，返回false；

		Date lastTime = new Date(order.getCreateTime().getTime() + day * 24 * 3600 * 1000L);
		Date last17 = DateTimeUtils.date(lastTime, OpenConstant.SPLIT_BATCH_TIME, 0, 0);
		logger.info("lastTime:{},last17:{},flag:{}",DateTimeUtils.formatDateTime(lastTime),DateTimeUtils.formatDateTime(last17),lastTime.after(last17));
		if (lastTime.after(last17)) {
			lastTime = last17;
		}
		logger.info("lastTime:{},now:{},before:{}",DateTimeUtils.formatDateTime(lastTime),DateTimeUtils.formatDateTime(new Date()),lastTime.before(new Date()));
		
		Long id = order.getId();
		OpenOrder oo = new OpenOrder();
		oo.setId(id);
		oo.setRefundStatus(OrderPayConstant.RefundStatus.PC_UPPING.getCode());
		//oo.setRefundStatus(1);
		oo.setRefundRemark("");
		oo.setRefundId("");
		oo.setSameWay(sameWay);
		if (StringUtils.isNotEmpty(refund_reason) && refund_reason.length() > 128) {
			refund_reason = refund_reason.substring(0, 128);
		}
		oo.setRefundCreateTime(new Date());
		oo.setRefundReason(refund_reason);
		int i = updateOpenOrderByPrimaryKey(oo);
		logger.info("i={},totalId={}", i, totalId);
		if (i > 0 && totalId > 0) {
			OpenOrderTotal oot = new OpenOrderTotal();
			oot.setId(totalId);
			oot.setRefundCount(1);
			int result = openOrderTotalMapper.updateByPrimaryKeySelective(oot);
			logger.info("result={}",result);
		}
		return i;

	}
	
	
	  /**
     * 获取退款详情
     * @param storeOrderId
     * @return
     */
	public OpenStoreOrderRefundApplyVO getRefundDetail(int storeOrderId) {
		OpenStoreOrderRefundApplyVO vo = openStoreOrderMapper.selectRefundDetail(storeOrderId);
		validator(vo == null, "订单不存在");
		//旧数据没有
		if(vo.getOpenRefundId() != null) {
			OpenStoreOrderRefundApply refundApply = openStoreOrderRefundApplyMapper.selectByPrimaryKey(vo.getOpenRefundId());
			BeanUtils.copyProperties(refundApply, vo);
		}
		return vo;
	}

	public void SyncExpressStatus(){
		OpenStoreOrderExample example = new OpenStoreOrderExample();
		example.createCriteria().andExpressCompanyCodeIsNotNull().andExpressCodeIsNotNull().andExpressStatusEqualTo(SysConstant.EXPRESS_STATUS_PROCESS);
		List<OpenStoreOrder> list = openStoreOrderMapper.selectByExample(example);
		if(list != null && !list.isEmpty()){
			for(OpenStoreOrder order : list){
				ExpressProgressResponse response = expressCompanyService.getExpressProgress(order.getExpressCompanyCode(),order.getExpressCode());
				////运单状态 0在途中、1已揽收、2疑难、3已签收、4退签、5同城派送中、6退回等状态
				if(response != null && "3".equals(response.getState())){
					OpenStoreOrder o = new OpenStoreOrder();
					o.setExpressStatus(SysConstant.EXPRESS_STATUS_FINISH);
					o.setId(order.getId());
					String time = response.getExpresInfo().get(0).getFtime();
					Date signFor = new Date();
					if(StringUtils.isNotBlank(time)){
						Date temp = DateUtil.parse(time,"yyyy-MM-dd HH:mm:ss");
						if(temp != null){
							signFor = temp;
						}
					}
					o.setSignForTime(signFor);
					openStoreOrderMapper.updateByPrimaryKeySelective(o);
				}
			}
		}
	}
}
