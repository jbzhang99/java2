package com.rfchina.community.openweb.service;


import net.thinkinpower.basicservice.fileservice.FileServiceClient;
import net.thinkinpower.basicservice.fileservice.UploadParameter;
import net.thinkinpower.basicservice.imageservice.ImageServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 基础线非fastDFS方式上传
 */
@Service
public class UploadFileService {

    private static final Logger logger = LoggerFactory.getLogger(UploadFileService.class);

    @Value("${endPoint}")
    private String endPoint;
    @Value("${bucket}")
    private String bucket;
    @Value("${aK}")
    private String aK;
    @Value("${sK}")
    private String sK;

    /**
     * 上传图片
     * @param file
     * @param fileKey
     * @param request
     * @return
     * @throws IOException
     */
    public String upload(File file, String fileKey, HttpServletRequest request) throws IOException {
        FileServiceClient fileServiceClient = new FileServiceClient(endPoint, bucket, aK, sK);
        FileInputStream fis = new FileInputStream(file);

        UploadParameter p = new UploadParameter(fileKey, (int) file.length(),
                "image/png");
        p.addMetadata("uploader", "admin");
        p.addMetadata("Img-Allow-Mult-Size", "m500x500,p60");
        p.setPublicRead();
        p.setSearchable();

        ByteArrayOutputStream outMessage = new ByteArrayOutputStream();

        int r = fileServiceClient.upload(p, fis, outMessage);

        logger.info("status = " + r);
        logger.info("outMessage = " + outMessage);
        outMessage.close();
        fis.close();
        String url = endPoint + "/_f/" + bucket + "/" + fileKey;
        return url;
    }

    /**
     * 获取图片信息
     * @param fileKey
     * @return
     */
    public String getImgInfo(String fileKey) throws IOException{
        ImageServiceClient imgs = new ImageServiceClient(endPoint, bucket, aK, sK);
        List<String> infoList = new ArrayList<>();
        infoList.add("avgrgb");
        ByteArrayOutputStream outMessage =new ByteArrayOutputStream();
        int r = imgs.getInfo(fileKey, infoList, outMessage);
        System.out.println(outMessage.toString());
        outMessage.close();
        return outMessage.toString();
    }


}
