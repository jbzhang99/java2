package test.open;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rfchina.community.openstore.service.OpenRefundService;
import com.rfchina.community.service.openser.OpenOrderSerService;

import sun.misc.BASE64Encoder;

public class TestOpenRefundService extends TestBase{
	@Autowired
	public OpenRefundService openRefundService;
	@Autowired
	public OpenOrderSerService openOrderSerService;
	
	@Test
	@Ignore
	public void refundApply() {
		openRefundService.refundApply(1,
				"http://storage.test.rfmember.net/G1/M00/00/14/Ch39jFndxTmAAn7lAAiQfKHDaaQ221.jpg,http://storage.test.rfmember.net/G1/M00/00/14/Ch3-RFndxUCARjs_AAvqH_kipG8162.jpg", 
				"感觉是假的", "无条件退款");
	}
	
	@Test
	@Ignore
	public void getValidStoreCouponList() {
		System.out.println(openOrderSerService.getRefundDetail(1));
	}
	
	@Test
	public void getImageBinary() {
		
		try {
//			String file64 = getImageBinary2();
			URL url = new URL("http://storage.test.rfmember.net/G1/M00/00/15/Ch3-RFnoJieAAUecAAvea_OGt2M442.jpg");  
			String xx = encodeImageToBase64(url);
			 int fileLength = (xx.length()-(xx.length()/8)*2);
			 System.out.println(fileLength);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 private  String getImageBinary2() throws IOException{
//		 	File confirmLetterFile = new File("");
		 	URL url = new URL("http://storage.test.rfmember.net/G1/M00/00/14/Ch39jFndxTmAAn7lAAiQfKHDaaQ221.jpg");  
	        //打开链接  
	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
	        //设置请求方式为"GET"  
	        conn.setRequestMethod("GET");  
	        //超时响应时间为5秒  
	        conn.setConnectTimeout(10 * 1000);  
	        //通过输入流获取图片数据  
	        InputStream fis = conn.getInputStream();  
			StringBuilder str = new StringBuilder();// 不建议用String
			try
			{
				byte[] b;
				b = new byte[fis.available()];
				fis.read(b);
				for (byte bs : b)
				{
					str.append(Integer.toBinaryString(bs));// 转换为二进制
				}
				
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			return str.toString();
	    }
	 
	 	/**
	     * 将网络图片编码为base64
	     * @param url
	     * @return
	     * @throws BusinessException
	     */
	    public static String encodeImageToBase64(URL url)  {
	        //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
	        //打开链接
	    	 String base64 = null;
	        HttpURLConnection conn = null;
	        try {
	            conn = (HttpURLConnection) url.openConnection();
	            //设置请求方式为"GET"
	            conn.setRequestMethod("GET");
	            //超时响应时间为5秒
	            conn.setConnectTimeout(5 * 1000);
	            //通过输入流获取图片数据
	            InputStream inStream = conn.getInputStream();
	            System.out.println(inStream.available());
	            //得到图片的二进制数据，以二进制封装得到数据，具有通用性
	            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
	            //创建一个Buffer字符串
	            byte[] buffer = new byte[1024];
	            //每次读取的字符串长度，如果为-1，代表全部读取完毕
	            int len = 0;
	            //使用一个输入流从buffer里把数据读取出来
	            while ((len = inStream.read(buffer)) != -1) {
	            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
	                outStream.write(buffer, 0, len);
	            }
	            //关闭输入流
	            
	            inStream.close();
	            byte[] data = outStream.toByteArray();
	            //对字节数组Base64编码
	            BASE64Encoder encoder = new BASE64Encoder();
	            base64 = encoder.encode(data);
	            return base64;//返回Base64编码过的字节数组字符串
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			return base64;
	    }
	
	
}