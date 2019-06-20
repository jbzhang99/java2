package com.rfchina.community.component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

import javax.annotation.PostConstruct;

import com.rfchina.community.base.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 */
@Service
public class FastDFSGlobalService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${fastdfs.upload_host}")
    private String uploadHost;

    @Value("${fastdfs.connect_timeout:5}")
    private Integer connectTimeout;

    @Value("${fastdfs.network_timeout:30}")
    private Integer networkTimeout;

    @Value("${fastdfs.tracker_servers}")
    private String trackerServers;

    @Value("${fastdfs.charset}")
    private String charset;

    @Value("${fastdfs.http.tracker_http_port}")
    private Integer trackerHttpPort;

    @Value("${fastdfs.http.secret_key}")
    private String secretKey;

    @Value("${fastdfs.http.anti_steal_token}")
    private Boolean antiStealToken;

    private TrackerClient trackerClient;

    @PostConstruct
    public void init() throws Exception {
        initFastDFS();
        trackerClient = new TrackerClient(ClientGlobal.g_tracker_group);
    }

    public String upload(String localFilename) throws Exception {
    	
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageServer ss = trackerClient.getStoreStorage(trackerServer);
        StorageClient1 sc1 = new StorageClient1(trackerServer, ss);
        NameValuePair[] meta_list = null; // new NameValuePair[0];
        String file_ext_name = localFilename.substring(localFilename.lastIndexOf(".") + 1);
        return uploadHost + sc1.upload_file1(localFilename, file_ext_name, meta_list);
    }

    public int delete(String fileId) throws Exception {
        fileId = fileId.replaceFirst(uploadHost, "");
        TrackerServer trackerServer = this.trackerClient.getConnection();
        StorageServer ss = trackerClient.getStoreStorage(trackerServer);
        if (ss == null) {
            logger.error("getStoreStorage return null");
        } else {
            StorageClient1 sc1 = new StorageClient1(trackerServer, ss);
            logger.info("delete_file1 is file_id: {}", fileId);
            return sc1.delete_file1(fileId);
        }
        return -1;
    }

    public String upload(URL url) throws Exception {
        String imageName = downloadPicture(url);
        String picUrl = "";
        if(StringUtils.isNotBlank(imageName)){
            picUrl = upload(imageName);
            try{
                new File(imageName).delete();
            }catch (Exception e){
                logger.error("删除临时文件异常,{}",imageName);
            }
        }
        return picUrl;
    }

    private static class UploadFileSender implements UploadCallback {
        private InputStream inStream;
        public UploadFileSender(InputStream inStream) {
            this.inStream = inStream;
        }
        public int send(OutputStream out) throws IOException {
            int readBytes;
            while((readBytes = inStream.read()) > 0) {
                out.write(readBytes);
            }
            return 0;
        }
    }

    private String  downloadPicture(URL url) {
        String imageName = FileUtils.getTempDirectory() +File.separator + UUID.randomUUID()+".jpg";
        try (DataInputStream dataInputStream = new DataInputStream(url.openStream());FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName))){
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
        } catch (IOException e) {
            logger.info("下载文件异常",e);
        }
        return imageName;
    }

    private void initFastDFS() throws Exception {
        logger.info("Begin to initialize FastDFSService");
        ClientGlobal.setG_connect_timeout(connectTimeout*1000);
        ClientGlobal.setG_network_timeout(networkTimeout*1000);
        ClientGlobal.setG_charset(charset);
        ClientGlobal.setG_tracker_http_port(trackerHttpPort);
        ClientGlobal.setG_anti_steal_token(antiStealToken);
        ClientGlobal.setG_secret_key(secretKey);
        String[] szTrackerServers = trackerServers.split(",");
        if(szTrackerServers == null) {
            throw new MyException("item \"tracker_server\" not found");
        } else {
            InetSocketAddress[] tracker_servers = new InetSocketAddress[szTrackerServers.length];
            for(int i = 0; i < szTrackerServers.length; ++i) {
                String[] parts = szTrackerServers[i].split("\\:", 2);
                if(parts.length != 2) {
                    throw new MyException("the value of item \"tracker_server\" is invalid, the correct format is host:port");
                }

                tracker_servers[i] = new InetSocketAddress(parts[0].trim(), Integer.parseInt(parts[1].trim()));
            }
            TrackerGroup trackerGroup = new TrackerGroup(tracker_servers);
            ClientGlobal.setG_tracker_group(trackerGroup);
        }
    }
}
