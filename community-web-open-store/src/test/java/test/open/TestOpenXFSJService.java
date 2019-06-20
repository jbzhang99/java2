package test.open;

import com.rfchina.community.base.OrderPayConstant;
import com.rfchina.community.openstore.service.OpenXFSJService;
import com.rfchina.community.persistence.model.OpenStoreOrder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;

public class TestOpenXFSJService extends TestBase {
    @Autowired
    public OpenXFSJService openXFSJService;

    @Test
    public void getExtXFSJInfo() {

        System.out.println(openXFSJService.getExtXFSJInfo(1));
    }

    @Test
    public void getValidOpenXFSJInfo() {

        System.out.println(openXFSJService.getValidOpenXFSJInfo(1));
    }

    @Test
    public void getPlatformActivityInfo(){
        System.out.println(openXFSJService.getPlatformActivityInfo(1008));}

    @Test
    public void completeTypeInfo(){
        OpenStoreOrder openStoreOrder = new OpenStoreOrder();
        openStoreOrder.setCommunityId(1L);
        openStoreOrder.setBody("1");
        openStoreOrder.setCreateTime(new Date());
        openStoreOrder.setInvalidTime(new Date());
        openStoreOrder.setDetail("1");
        openStoreOrder.setOpenId("1");
        openStoreOrder.setOrderCode("0");//默认值
        openStoreOrder.setPayStatus(OrderPayConstant.PayStatus.NO_PAYMENT.getCode());
        openStoreOrder.setSubject("1");
        openStoreOrder.setRefundStatus(0);
        openStoreOrder.setRefundComment("");
        openStoreOrder.setUserId(1l);
        openStoreOrder.setServiceId(1);
        openStoreOrder.setResourceType(1);
        openStoreOrder.setUserName("1");
        openStoreOrder.setMobile("1");
        openStoreOrder.setAddrDetail("1");
        openStoreOrder.setGoodsTotal(new BigDecimal(1));
        openStoreOrder.setAddrInfoId(1);//此字段暂时没用
        openStoreOrder.setVerifyStatus("unverified");
        openStoreOrder.setCouponPrice(new BigDecimal(1));
        openStoreOrder.setCouponRecordId(1l);
        openXFSJService.completeTypeInfo(openStoreOrder);

    }
}
