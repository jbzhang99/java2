package test.open;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.rfchina.api.request.pay.FuPayCreateRequest.GoodsDetail;
import com.rfchina.community.openstore.entity.ext.MutiOrderCreateParam;
import com.rfchina.community.openstore.entity.ext.ParamOpenStoreGood;

public class TestOpen {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	@Ignore
	public void test() {
		BigDecimal discountPrice = new BigDecimal(0.05).setScale(2, BigDecimal.ROUND_HALF_DOWN); //每满价格
		BigDecimal discountMoney = new BigDecimal(0.01).setScale(2, BigDecimal.ROUND_HALF_DOWN);	//满减价格
		BigDecimal eachMoneyTop = new BigDecimal(0.02).setScale(2, BigDecimal.ROUND_HALF_DOWN); 	//满减上限
		BigDecimal serverGoodTotal = new BigDecimal(0.18).setScale(2, BigDecimal.ROUND_HALF_DOWN); 	//满减上限
		
		BigDecimal dis = serverGoodTotal.divide(discountPrice);
		BigDecimal muti = new BigDecimal(dis.intValue());
		
		BigDecimal sumDiscountMoney = discountMoney.multiply(muti);
		
		if(eachMoneyTop.compareTo(new BigDecimal(0)) > 0) {
			//2.有满减上限
			sumDiscountMoney = sumDiscountMoney.compareTo(eachMoneyTop) > 0 ? eachMoneyTop : sumDiscountMoney;
		}
		
		System.out.println(sumDiscountMoney);
	}
	@Test
	@Ignore
	public void test2() {
			List<GoodsDetail> goodDetails = new ArrayList<>();
			GoodsDetail detail = new GoodsDetail();
			detail.setGoodId(String.valueOf(1));
			detail.setBody("haha"+ " * " + 2);
			detail.setTotalAmount(new BigDecimal(100).multiply(new BigDecimal(2)).multiply(new BigDecimal(100)).longValue());
			detail.setName(detail.getBody());
			detail.setPrice(detail.getTotalAmount());
			detail.setReceiptAmount(detail.getTotalAmount());
			detail.setRemark(detail.getName());
			detail.setQuantity(new BigDecimal(2));
			goodDetails.add(detail);
		
			GoodsDetail detail2 = new GoodsDetail();
			detail2.setBody("运费");
			detail2.setTotalAmount(new BigDecimal(10).multiply(new BigDecimal(100)).longValue());
			detail2.setName(detail.getBody());
			detail2.setPrice(detail.getTotalAmount());
			detail2.setReceiptAmount(detail.getTotalAmount());
			detail2.setRemark(detail.getName());
			detail2.setGoodId("0");
			detail2.setQuantity(new BigDecimal(1));
			goodDetails.add(detail2);
		
			GoodsDetail detail3 = new GoodsDetail();
			detail3.setBody("满减");
			detail3.setTotalAmount(-new BigDecimal(2).multiply(new BigDecimal(100)).longValue());
			detail3.setName(detail.getBody());
			detail3.setPrice(detail.getTotalAmount());
			detail3.setReceiptAmount(detail.getTotalAmount());
			detail3.setRemark(detail.getName());
			detail3.setGoodId("0");
			detail3.setQuantity(new BigDecimal(1));
			goodDetails.add(detail3);
			String xx = JSONArray.toJSONString(goodDetails);
			String yy = JSONArray.toJSONString(goodDetails);
			System.out.println(xx);
			System.out.println(yy);
		    List<GoodsDetail> goodsDetailJson = JSON.parseArray(xx, GoodsDetail.class);
		    goodsDetailJson.toArray(new GoodsDetail[0]);
		    System.out.println(goodsDetailJson);
	}
	
	@Test
	@Ignore
	public void test3() {
		List<ParamOpenStoreGood> goodList = new ArrayList<ParamOpenStoreGood>();
		ParamOpenStoreGood good = new ParamOpenStoreGood();
		good.setAmount(1);
		good.setGoodId(39);
		goodList.add(good);
		
		ParamOpenStoreGood good2 = new ParamOpenStoreGood();
		good2.setAmount(1);
		good2.setGoodId(40);
		goodList.add(good2);
		
		List<ParamOpenStoreGood> goodList2 = new ArrayList<ParamOpenStoreGood>();
		ParamOpenStoreGood good3 = new ParamOpenStoreGood();
		good3.setAmount(1);
		good3.setGoodId(47);
		goodList2.add(good3);
		
		ParamOpenStoreGood good4 = new ParamOpenStoreGood();
		good4.setAmount(1);
		good4.setGoodId(48);
		goodList2.add(good4);
		
		List<MutiOrderCreateParam> list = new ArrayList<MutiOrderCreateParam>();
		MutiOrderCreateParam param = new MutiOrderCreateParam();
		param.setDiscountPrice(new BigDecimal(0));
		param.setExpressMoney(new BigDecimal(0));
		param.setRemark("123");
		param.setTotalAmount(new BigDecimal(0.02));
		param.setGoodList(JSONArray.toJSONString(goodList));
		param.setServiceId(413);
		list.add(param);
		
		MutiOrderCreateParam param2 = new MutiOrderCreateParam();
		param2.setDiscountPrice(new BigDecimal(0));
		param2.setExpressMoney(new BigDecimal(0));
		param2.setRemark("345");
		param2.setTotalAmount(new BigDecimal(0.02));
		param2.setGoodList(JSONArray.toJSONString(goodList2));
		param2.setServiceId(412);
		list.add(param2);
		
		String xx = JSONArray.toJSONString(list);
		System.out.println(xx);
	}
	
	@Test
	@Ignore
	public void test4() {
		BigDecimal singleScaleValue = new BigDecimal(0.02).
				divide(new BigDecimal(3),2,BigDecimal.ROUND_DOWN);
		System.out.println(singleScaleValue);
	}

}