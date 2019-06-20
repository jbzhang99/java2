package com.rfchina.community.openstore.controller;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.StatusCode;
import com.rfchina.community.base.util.FileUtil;
import com.rfchina.community.component.FastDFSGlobalService;
import com.rfchina.community.persistence.mapper.SysUploadImageMapper;
import com.rfchina.community.persistence.model.SysUploadImage;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 */
@RestController
@RequestMapping(value = { Constant.ROOT_PATH_OPENSTORE})
public class UploadFileController extends BaseController {

	@Autowired
	private FastDFSGlobalService fastDFSGlobalService;

	@Autowired
	private SysUploadImageMapper sysUploadImageMapper;
	
	public static final long TEN_M = 10 * 1024 * 1024L;
	public static final long THREE_M = 3 * 1024 * 1024L;
	public static final long TWO_M = 2 * 1024 * 1024L;

	@RequestMapping(value = { "/upload_image" })
	public Result<?> uploadImage(@RequestParam("upload_file") MultipartFile multipartFile,
			@RequestParam(required = true) String type,
			@RequestParam(required = false, defaultValue="0") int isThumbnail
			) throws IOException {
		validator(type.length() > 40, "type长度太长:" + type);
		String data = "";
		long size = multipartFile.getBytes().length;
		logger.info("upload_image size:{}", size);
		try {
			if (size > TEN_M && isThumbnail == 1) {
				return Result.create(StatusCode.FAILURE_INFO.value(), "文件上传失败: 图片大小超过10MB");
			}else if(size > THREE_M && isThumbnail != 1){
				return Result.create(StatusCode.FAILURE_INFO.value(), "文件上传失败: 图片大小超过3MB");
			}
			String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
			if (!"jpg".equalsIgnoreCase(extension) && !"png".equalsIgnoreCase(extension)
					&& !"jpeg".equalsIgnoreCase(extension)) {
				return Result.create(StatusCode.FAILURE_INFO.value(), "文件上传失败: 仅支持jpg;png;jpeg");
			}
			String hashedFileName = DigestUtils.sha1Hex(multipartFile.getBytes());
			String storeFilePath = FileUtils.getTempDirectory() +File.separator + hashedFileName
					+ (StringUtils.isNotBlank(extension) ? "." + extension.toLowerCase() : "");
			
			//看是否需要压缩
			if(isThumbnail != 1) {
				multipartFile.transferTo(new File(storeFilePath));
	        }else {
		        //图片尺寸不变，压缩图片文件大小outputQuality实现,参数1为最高质量
		        if(storeFilePath.contains(".png")){
        	    	storeFilePath = storeFilePath.replace(".png", ".jpg");
                }
		        
		        if(size >= TWO_M){//大于2M才压缩
					double quality = Double.valueOf(TWO_M) / size ;
		            Thumbnails.of(multipartFile.getInputStream()).scale(1f).outputQuality(quality).outputFormat("jpg").toFile(storeFilePath);
		        }else{
		        	Thumbnails.of(multipartFile.getInputStream()).scale(1f).outputFormat("jpg").toFile(storeFilePath);
		        }
	        }
	        
			data = fastDFSGlobalService.upload(storeFilePath);
		} catch (Exception e) {
			logger.error("Method[uploadImg] error {} ", e.getMessage(), e);
			return Result.create(StatusCode.FAILURE_INFO.value(), "文件保存失败, 请稍后再试!");
		}
		SysUploadImage record = new SysUploadImage();
		record.setCreateIp(getIp2());
		record.setCreateTime(new Date());
		record.setLink(data);
		record.setUid(-1L);//用户上传
		record.setType(type);
		record.setSysType("open");
		sysUploadImageMapper.insertSelective(record);
		JSONObject o = new JSONObject();
		o.put("link", data);
		o.put("id", record.getId());
		return Result.successData(o);
	}


	@RequestMapping(value = {"/uploadBase64Img"})
	public Result<String> uploadBase64Img(@RequestParam("uploadFile") String uploadFile) {
		MultipartFile multipartFile = FileUtil.base64ToMultipart(uploadFile);
		Result<String> result = new Result<>();
		result.setStatus(StatusCode.SUCCESS);
		result.setMessage("图片上传成功");
		try {
			logger.info("Upload image: {}", multipartFile.getOriginalFilename());
			String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
			String hashedFileName = DigestUtils.sha1Hex(multipartFile.getBytes());
			String storeFilePath = FileUtils.getTempDirectory() + File.separator + hashedFileName + (StringUtils.isNotBlank(extension) ? "." + extension : "");
			multipartFile.transferTo(new File(storeFilePath));
			String url = fastDFSGlobalService.upload(storeFilePath);
			result.setData(url);
		} catch (Exception e) {
			logger.error("Method[uploadImg] error ", e);
			result.setStatus(StatusCode.FAILURE);
			result.setMessage("文件保存失败, 请稍后再试!");
		}
		return result;
	}
}
