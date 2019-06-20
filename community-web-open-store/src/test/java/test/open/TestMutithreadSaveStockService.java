package test.open;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rfchina.community.openstore.CommunityOpenStoreApplication;
import com.rfchina.community.openstore.entity.ext.ParamOpenStoreGood;
import com.rfchina.community.openstore.service.FuPayService;
import com.rfchina.community.openstore.service.OpenServiceDetailService;
import com.rfchina.community.openstore.service.OpenStoreGoodService;
import com.rfchina.community.openstore.service.OpenStoreOrderService;
import com.rfchina.community.openstore.service.OpenStoreShoppingCartService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CommunityOpenStoreApplication.class})
public class TestMutithreadSaveStockService {
	@Autowired
	private OpenStoreGoodService openStoreGoodService;


	private int i = 5;
	/*
	 * 线程计数器
	 * 	将线程数量初始化
	 * 	每执行完成一条线程，调用countDown()使计数器减1
	 * 	主线程调用方法await()使其等待，当计数器为0时才被执行
	 */
	private CountDownLatch latch = new CountDownLatch(i);

	@Test
	public void test() {
		
		for (int i = 0; i < this.i; i ++) {
			new Thread(new Runner()).start();
		}
		
		try {
			latch.await(); // 主线程等待
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	class Runner implements Runnable {
		
		@Override
		public void run() {
			ParamOpenStoreGood good = new ParamOpenStoreGood();
			good.setStock(1);
			good.setGoodId(30);
			openStoreGoodService.reduceStock(good, 1, null);
			latch.countDown(); // 执行完毕，计数器减1
		}
	}
}