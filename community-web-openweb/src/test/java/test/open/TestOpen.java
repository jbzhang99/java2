package test.open;

import com.rfchina.community.base.Constant;
import com.rfchina.community.component.OpenAuditInfoComponent;
import com.rfchina.community.persistence.model.OpenOrder;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class TestOpen {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		BigDecimal total = new BigDecimal(0.04);
		BigDecimal feeRate = new BigDecimal(0.5);
		BigDecimal platformCharge = total.multiply(feeRate).setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println(platformCharge);
	}
	@Test
	public void test2() {
		BigDecimal total = new BigDecimal(0.019999);
		System.out.println(total);
		total = total.setScale(2, BigDecimal.ROUND_HALF_DOWN);
		System.out.println(total);

		System.out.print(OpenAuditInfoComponent.ObjectType.xfsj_provider_apply.toString().equals("xfsj_provider_apply"));
	}


	@Test
	public void test11(){
		//System.out.println(Constant.OpenOrder.BillStatus.translate(null));
		OpenOrder openOrder = new OpenOrder();
		System.out.println(Constant.OpenOrder.RefundStatus.translate(openOrder.getBillStatus()));
	}
}