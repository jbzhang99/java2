package com.rfchina.community.openweb.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 * @desc 生产商品商标图片
 * @author maixingnian
 * @since 3.5
 */
@Service
public class ChartGraphicsService {

	/**
	 * 生成商品标签字节
	 * @param qrCodeUrl
	 * @param goodName
	 * @param price
	 * @return
	 */
	public byte[] createGoodSellImg(String qrCodeUrl, String goodName, String price) {
		byte[] bytes = null;
		//生成商品图片标签
		BufferedImage returnImage = graphicsGeneration(qrCodeUrl, goodName, price);
		//生成字节
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(returnImage, "jpg", baos);
			bytes = baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return bytes;
	}

	/**
	 * 生成商品图片
	 * @param qrImage 商品二维码
	 * @param goodName 商品名称
	 * @param price 商品价格
	 * @return 商品标签图片
	 */
	public BufferedImage graphicsGeneration(String qrCodeUrl, String goodName, String price) {
		//商品二维码转换
		BufferedImage qrImage = qrCodeBufferedImage(qrCodeUrl);
		//分割名称说明
		List<String> goodNameList = splitString(goodName);
		//生成图片
		BufferedImage image = graphicsGeneration(qrImage, goodNameList, price);
		//创建本地图片
//		createImage("D://test11.jpg", image);
		return image;
	}

	/**
	 * 生成商品图片
	 * @param qrImage 商品二维码
	 * @param goodName 商品名称分割行
	 * @param price 商品价格
	 * @return 商品标签图片
	 */
	public BufferedImage graphicsGeneration(BufferedImage qrImage, List<String> goodNameList, String price) {
		// 背景图片
		BufferedImage image = readBackImg();
		// 商品名称
		int goodNameY = 158;
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font("宋体", Font.BOLD, 32));
		// 文字位置
		for (String goodName : goodNameList) {
			graphics.drawString(goodName, 362, goodNameY);
			goodNameY = goodNameY + 42;
		}
		// 价格
		graphics.setColor(Color.RED);
		graphics.setFont(new Font("宋体", Font.BOLD, 52));
		graphics.drawString(price, 362, 298);
		// 二维码
		int qr_x = 20;
		int qr_y = 120;
		graphics.drawImage(qrImage, qr_x, qr_y, null);
		graphics.dispose();
		return image;
	}

	/**
	 * 获取背景图
	 * @return
	 */
	private BufferedImage readBackImg() {
		BufferedImage image = null;
		try {
			// String path = System.getProperty("java.class.path") +
			// File.separator+"image"+File.separator+"background.jpg";
			String storeFilePath = System.getProperty("java.class.path");
			int firstIndex = storeFilePath.lastIndexOf(System.getProperty("path.separator")) + 1;
			int lastIndex = storeFilePath.lastIndexOf(File.separator) + 1;
			storeFilePath = storeFilePath.substring(firstIndex, lastIndex) + "image";
			File dir = new File(storeFilePath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File file = new File(storeFilePath + File.separator + "background6.jpg");
			image = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}

	/**
	 * 拆分字符串默认分两行
	 * 
	 * @param str
	 * @return
	 */
	private List<String> splitString(String str) {
		// 默认两行
		int line = 2;
		List<String> list = new ArrayList<>(line);
		Pattern p = Pattern.compile("(.{0,16})(.{0,14})");// 匹配两组数据
		Matcher m = p.matcher(str);
		if (m.find()) {
			line = m.groupCount() > line ? line : m.groupCount();
			for (int i = 1; i <= m.groupCount() & i <= line; i++) {
				if (i == line && m.group(i).length() >= 14) {
					list.add(m.group(i) + "...");
				} else if (!"".equals(m.group(i))) {
					list.add(m.group(i));
				}
				System.out.println(list);
			}
		}
		return list;
	}
	
	/**
	 * 二维码转换
	 * @param qrCodeUrl
	 * @return
	 */
	private BufferedImage qrCodeBufferedImage(String qrCodeUrl) {
		File file = QRCode.from(qrCodeUrl).to(ImageType.PNG).withSize(300, 300).file();
		InputStream in = null;
		BufferedImage image = null;
		try {
			// 将b作为输入流；
			in = new FileInputStream(file);
			// 将in作为输入流，读取图片存入image中，而这里in可以为ByteArrayInputStream();
			image = ImageIO.read(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return image;
	}

	/**
	 * 保存图片
	 * @param fileLocation
	 * @param image
	 */
	@SuppressWarnings("restriction")
	private static void createImage(String fileLocation, BufferedImage image) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream(fileLocation);
			bos = new BufferedOutputStream(fos);
//			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
//			encoder.encode(image);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(bos != null) {
					bos.close();
				}
				if(fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}