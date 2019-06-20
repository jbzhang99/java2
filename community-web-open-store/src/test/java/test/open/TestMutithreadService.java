//package test.open;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.rfchina.community.openstore.CommunityOpenStoreApplication;
//import com.rfchina.community.openstore.service.OpenStoreGoodService;
//
//import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
//import net.sourceforge.groboutils.junit.v1.TestRunnable;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {CommunityOpenStoreApplication.class})
//public class TestMutithreadService {
//	@Autowired
//	private OpenStoreGoodService openStoreGoodService;
//
//
//	
//	/**
//
//	* 多线程测试用例
//
//	*
//
//	* @author lihzh(One Coder)
//
//	* @date 2012-6-12 下午9:18:11
//
//	* @blog http://www.coderli.com
//
//	*/
//
//	@Test
//
//	public void MultiRequestsTest() {
//
//		// 构造一个Runner
//	
//		TestRunnable runner = new TestRunnable() {
//			@Override
//			public void runTest() throws Throwable {
//				// 测试内容
//				openStoreGoodService.changeStock(30, "DEC", 1, null);
//			}
//		};
//
//		int runnerCount = 20;
//	
//		//Rnner数组，想当于并发多少个。
//	
//		TestRunnable[] trs = new TestRunnable[runnerCount];
//	
//		for (int i = 0; i < runnerCount; i++) {
//	
//			trs[i] = runner;
//	
//		}
//	
//		// 用于执行多线程测试用例的Runner，将前面定义的单个Runner组成的数组传入
//	
//		MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(trs);
//
//		try {
//			// 开发并发执行数组里定义的内容
//			mttr.runTestRunnables();
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//
//	}
//
//}