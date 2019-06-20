package com.rfchina.community.openweb.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openweb.service.CommunityServiceService;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.model.CommunityService;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENWEB)
public class QrcodeController extends BaseController {

	@Value("${zizai.download.url}")
	private String downloadUrl;
	@Value("${debug.communityId}")
	private int debugCommunityId;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;

	@RequestMapping("/qrcode_image")
	public Result<?> getQrcodeImage(@RequestParam("content") String content, HttpServletResponse response)
			throws IOException {

		response.setContentType("image/png");
		QRCode.from(content).to(ImageType.PNG).withSize(200, 200).writeTo(response.getOutputStream());

		return Result.success();
	}

	@RequestMapping("/zizai_download_qrcode")
	public Result<?> getZiZaiDownloadQrcode(HttpServletResponse response) throws IOException {
		response.setContentType("image/png");
		QRCode.from(downloadUrl).to(ImageType.PNG).withSize(300, 300).writeTo(response.getOutputStream());
		return Result.success();
	}

	@RequestMapping("/zizai_test_qrcode")
	public Result<?> getZiZaiTestQrcode(@RequestParam(defaultValue = "0") Integer id, HttpServletResponse response)
			throws IOException {
		Long admin = getAdminId();
		CommunityService ser = communityServiceMapper.selectByPrimaryKey(id);
		String msg = "";
		if (ser == null) {
			msg = "无数据";
		} else {
			if (ser.getMerchantId() != admin.longValue()){
				msg = "非法数据";
			}else{
				StringBuffer urls = request.getRequestURL();
				URL url = new URL(urls.toString());
				URL url1 = new URL(url, "/static/jump.html?serviceId=" + id + "&test=1&communityId=" + debugCommunityId);
				msg=url1.toString();
			}
			
		}
		

		response.setContentType("image/png");
		
		QRCode.from(msg).to(ImageType.PNG).withSize(300, 300).writeTo(response.getOutputStream());
		return Result.success();
	}

}
