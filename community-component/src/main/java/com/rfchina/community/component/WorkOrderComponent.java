package com.rfchina.community.component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.CacheBuilder;
import com.rfchina.community.entity.wo.*;
import com.rfchina.community.entity.wo.WoCommonRsp;
import okhttp3.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 */
@Component
public class WorkOrderComponent extends IfaceComponent {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final OkHttpClient OK_HTTP_CLIENT  = new OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build();

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private static final com.google.common.cache.Cache<String, EmpBean> EMP_BEAN_CACHE = CacheBuilder.newBuilder()
            .expireAfterWrite(3, TimeUnit.MINUTES)
            .build();

    @Value("${work_order.base.url:http://localhost}")
    private String workOrderUrl;

    interface IfacePath {
        String GET_CLIENT_PTY_LIST = "getClientPtyList.shtml";
        String CLIENT_REPAIR_ADD = "clientRepairAdd.shtml";   //下单接口
        String CLIENT_REPAIR_ADD_BY_FILE = "clientRepairAddByFile.shtml";     //下单(带文件)
        String CLIENT_QUERY_RTASK_LIST = "clientQueryRTaskList.shtml";
        String CLIENT_REPAIR_TASK_VERIF = "clientRepairTaskVerif.shtml";
        String CLIENT_REPAIR_TASK_VERIF_BY_FILE = "clientRepairTaskVerifByFile.shtml";
        String TASK_REMINDER_RTASK = "taskReminderRTask.shtml";
        String GET_CLIENT_MAINTAIN_LIST = "getClientMaintainList.shtml";
        String CLIENT_GET_RTASK_DETAIL = "clientGetRTaskDetail.shtml";
        //意见反馈相关
        String CLIENT_CUS_TASK_ADD = "clientCusTaskAdd.shtml";
        String CLIENT_CUS_TASK_ADD_BY_FILE = "clientCusTaskAddByFile.shtml";
        String CLIENT_QUERY_CUR_TASK_LIST = "clientQueryCusTaskList.shtml";
        String GET_CLIENT_CUR_TYPE_LIST = "getClientCusTypeList.shtml";
        String CLIENT_CUS_TASK_VERIF = "clientCusTaskVerif.shtml";
        String CLIENT_CUS_TASK_VERIF_BY_FILE = "clientCusTaskVerifByFile.shtml";
        String CLIENT_CUS_REMINDER_TASK = "clientCusReminderTask.shtml";
        String CLIENT_GET_CUS_TASK_DETAIL = "clientGetCusTaskDetail.shtml";
        //门禁卡业务办理
        String DOOR_CARD_TRANSACT = "doorCardTransact.shtml";
        String BUSINESS_CANCEL = "businessCancel.shtml";
        String GET_BUSINESS_STATE = "getBusinessState.shtml";

        String GET_EMP_INFO = "getEmpInfo.shtml";

        String ADMIN_LOGIN = "adminLogin.shtml";

        String OPERATOR_TASK_PUSH = "sentOperatorTaskPushMsg.shtml";
    }

    public static String getFileNameFromUrl(String url) {
        if(StringUtils.isNotBlank(url)) {
            int lastIdx = StringUtils.lastIndexOf(url, "/");
            String fileName = StringUtils.substring(url, lastIdx+1);
            return fileName;
        }
        return null;
    }


    private <T extends Serializable> String jsonPost(String url, T t) throws IOException {
        String reqJsonStr = OBJECT_MAPPER.writeValueAsString(t);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), reqJsonStr);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Response response = OK_HTTP_CLIENT.newCall(request).execute();
        String rspJsonStr = null;
        if(response.isSuccessful()) {
            rspJsonStr = response.body().string();
        }
        logger.info("url: {}, req:{}, rsp:,{}", url, reqJsonStr, rspJsonStr);
        saveIfaceLog(url, reqJsonStr, rspJsonStr);
        return rspJsonStr;
    }

    private <T extends Serializable> String jsonPostWithFile2(String url, T t, List<FileBean> taskFileList) throws IOException {
        String reqJsonStr = OBJECT_MAPPER.writeValueAsString(t);
        String newUrl = url + "?parameters=" + reqJsonStr;
        MultipartBody.Builder multipartBodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
//        multipartBodyBuilder.addFormDataPart("parameters", reqJsonStr);
        int i = 0;
        for(FileBean item : taskFileList) {
            String fileName = item.getTfFileName();
            //item.setTfFileName(fileName);
            String fileUrl = item.getTfUrl();
            try {
                long startMs = System.currentTimeMillis();
                logger.info("Begin to get file[{}], at: {}ms", fileUrl, startMs);
                byte[] bytes = IOUtils.toByteArray(new URL(fileUrl));//readImage(fileUrl);
                long endMs = System.currentTimeMillis();
                logger.info("URL: {}, byte size: {}, at: {}ms, cost: {}ms", fileUrl, ArrayUtils.getLength(bytes), endMs, (endMs - startMs));
                if(!ArrayUtils.isEmpty(bytes)) {
                    RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), bytes);
                    multipartBodyBuilder.addFormDataPart(fileName, fileName, fileBody);
                    i++;
                }
            } catch (Exception e) {
                logger.error(String.format("jsonPostWithFile read file[%s] error", fileName), e);
            }
        }
        Request.Builder requestBuilder = new Request.Builder()
                .url(newUrl);
        if(i > 0) {
            requestBuilder.post(multipartBodyBuilder.build());
        }
        Response response = OK_HTTP_CLIENT.newCall(requestBuilder.build()).execute();
        String rspJsonStr = null;
        if(response.isSuccessful()) {
            rspJsonStr = response.body().string();
        }
        logger.info("url: {}, req:{}, rsp:,{}", url, reqJsonStr, rspJsonStr);
        saveIfaceLog(url, reqJsonStr, rspJsonStr);
        return rspJsonStr;
    }

    private <T extends Serializable> String jsonPostWithFile(String url, T t, List<RTaskFile> taskFileList) throws IOException {
        String reqJsonStr = OBJECT_MAPPER.writeValueAsString(t);
        String newUrl = url + "?parameters=" + reqJsonStr;
        MultipartBody.Builder multipartBodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
//        multipartBodyBuilder.addFormDataPart("parameters", reqJsonStr);
        int i = 0;
        for(RTaskFile item : taskFileList) {
            String fileName = item.getTfFileName();
            //item.setTfFileName(fileName);
            String fileUrl = item.getTfUrl();
            try {
                long startMs = System.currentTimeMillis();
                logger.info("Begin to get file[{}], at: {}ms", fileUrl, startMs);
                byte[] bytes = IOUtils.toByteArray(new URL(fileUrl));//readImage(fileUrl);
                long endMs = System.currentTimeMillis();
                logger.info("URL: {}, byte size: {}, at: {}ms, cost: {}ms", fileUrl, ArrayUtils.getLength(bytes), endMs, (endMs - startMs));
                if(!ArrayUtils.isEmpty(bytes)) {
                    RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), bytes);
                    multipartBodyBuilder.addFormDataPart(fileName, fileName, fileBody);
                    i++;
                }
            } catch (Exception e) {
                logger.error(String.format("jsonPostWithFile read file[%s] error", fileName), e);
            }
        }
        Request.Builder requestBuilder = new Request.Builder()
                .url(newUrl);
        if(i > 0) {
            requestBuilder.post(multipartBodyBuilder.build());
        }
        Response response = OK_HTTP_CLIENT.newCall(requestBuilder.build()).execute();
        String rspJsonStr = null;
        if(response.isSuccessful()) {
            rspJsonStr = response.body().string();
        }
        logger.info("Invoke [jsonPostWithFile], req:{}, rsp:,{}", reqJsonStr, rspJsonStr);
        saveIfaceLog(url, reqJsonStr, rspJsonStr);
        return rspJsonStr;
    }

    public GetClientPtyListRsp getClientPtyList(GetClientPtyListReq req) {
        String url = workOrderUrl + IfacePath.GET_CLIENT_PTY_LIST;
        try {
            String rspJsonStr = jsonPost(url, req);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                GetClientPtyListRsp rsp = OBJECT_MAPPER.readValue(rspJsonStr, GetClientPtyListRsp.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke getClientPtyList error", e);
        }
        return null;
    }

    public ClientRepairAddRsp clientRepairAdd(ClientRepairAddReq req) {
        boolean hasFiles = CollectionUtils.isNotEmpty(req.getFiles());
        String url = workOrderUrl + (hasFiles? IfacePath.CLIENT_REPAIR_ADD_BY_FILE:IfacePath.CLIENT_REPAIR_ADD);
        try {
            String rspJsonStr = hasFiles? jsonPostWithFile(url, req, req.getFiles()):jsonPost(url, req);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                ClientRepairAddRsp rsp = OBJECT_MAPPER.readValue(rspJsonStr, ClientRepairAddRsp.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke getClientPtyList error", e);
        }
        return null;
    }

    public ClientQueryRTaskListRsp clientQueryRTaskList(ClientQueryRTaskListReq req) {
        String url = workOrderUrl + IfacePath.CLIENT_QUERY_RTASK_LIST;
        try {
            String rspJsonStr = jsonPost(url, req);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                ClientQueryRTaskListRsp rsp = OBJECT_MAPPER.readValue(rspJsonStr, ClientQueryRTaskListRsp.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke clientQueryRTaskList error", e);
        }
        return null;
    }

    public WoCommonRsp clientRepairTaskVerif(ClientRepairTaskVerifReq req) {
        boolean hasFiles = CollectionUtils.isNotEmpty(req.getFiles());
        String url = workOrderUrl + (hasFiles? IfacePath.CLIENT_REPAIR_TASK_VERIF_BY_FILE:IfacePath.CLIENT_REPAIR_TASK_VERIF);
        try {
            String rspJsonStr = hasFiles? jsonPostWithFile(url, req, req.getFiles()):jsonPost(url, req);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                WoCommonRsp rsp = OBJECT_MAPPER.readValue(rspJsonStr, WoCommonRsp.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke clientRepairTaskVerif error", e);
        }
        return null;
    }

    public WoCommonRsp taskReminderRTask(TaskReminderRTaskReq req) {
        String url = workOrderUrl + IfacePath.TASK_REMINDER_RTASK;
        try {
            String rspJsonStr = jsonPost(url, req);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                WoCommonRsp rsp = OBJECT_MAPPER.readValue(rspJsonStr, WoCommonRsp.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke taskReminderRTask error", e);
        }
        return null;
    }

    public GetClientMaintainListRsp getClientMaintainList(GetClientMaintainListReq req) {
        String url = workOrderUrl + IfacePath.GET_CLIENT_MAINTAIN_LIST;
        try {
            String rspJsonStr = jsonPost(url, req);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                GetClientMaintainListRsp rsp = OBJECT_MAPPER.readValue(rspJsonStr, GetClientMaintainListRsp.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke getClientMaintainList error", e);
        }
        return null;
    }

    public ClientGetRTaskDetailRsp clientGetRTaskDetail(ClientGetRTaskDetailReq req) {
        String url = workOrderUrl + IfacePath.CLIENT_GET_RTASK_DETAIL;
        try {
            String rspJsonStr = jsonPost(url, req);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                ClientGetRTaskDetailRsp rsp = OBJECT_MAPPER.readValue(rspJsonStr, ClientGetRTaskDetailRsp.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke clientGetRTaskDetail error", e);
        }
        return null;
    }

    public  ClientCusTaskAddRsp clientCusTaskAdd(ClientCusTaskAddReq req) {
        boolean hasFiles = CollectionUtils.isNotEmpty(req.getFiles());
        String url = workOrderUrl + (hasFiles? IfacePath.CLIENT_CUS_TASK_ADD_BY_FILE:IfacePath.CLIENT_CUS_TASK_ADD);
        try {
            String rspJsonStr = hasFiles? jsonPostWithFile(url, req, req.getFiles()):jsonPost(url, req);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                ClientCusTaskAddRsp rsp = OBJECT_MAPPER.readValue(rspJsonStr, ClientCusTaskAddRsp.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke clientCusTaskAdd error", e);
        }
        return null;
    }

    public  ClientQueryCusTaskListRsp clientQueryCusTaskList(ClientQueryCusTaskListReq req) {
        String url = workOrderUrl + IfacePath.CLIENT_QUERY_CUR_TASK_LIST;
        try {
            String rspJsonStr = jsonPost(url, req);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                ClientQueryCusTaskListRsp rsp = OBJECT_MAPPER.readValue(rspJsonStr, ClientQueryCusTaskListRsp.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke clientQueryCusTaskList error", e);
        }
        return null;
    }

    public  GetClientCusTypeListRsp getClientCusTypeList(GetClientCusTypeListReq req) {
        String url = workOrderUrl + IfacePath.GET_CLIENT_CUR_TYPE_LIST;
        try {
            String rspJsonStr = jsonPost(url, req);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                GetClientCusTypeListRsp rsp = OBJECT_MAPPER.readValue(rspJsonStr, GetClientCusTypeListRsp.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke getClientCusTypeList error", e);
        }
        return null;
    }

    public WoCommonRsp clientCusTaskVerif(ClientCusTaskVerifReq req) {
        boolean hasFiles = CollectionUtils.isNotEmpty(req.getFiles());
        String url = workOrderUrl + (hasFiles? IfacePath.CLIENT_CUS_TASK_VERIF_BY_FILE:IfacePath.CLIENT_CUS_TASK_VERIF);
        try {
            String rspJsonStr = hasFiles? jsonPostWithFile(url, req, req.getFiles()):jsonPost(url, req);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                WoCommonRsp rsp = OBJECT_MAPPER.readValue(rspJsonStr, WoCommonRsp.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke clientCusTaskVerif error", e);
        }
        return null;
    }

    public WoCommonRsp clientCusReminderTask(ClientCusReminderTaskReq req) {
        String url = workOrderUrl + IfacePath.CLIENT_CUS_REMINDER_TASK;
        try {
            String rspJsonStr = jsonPost(url, req);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                WoCommonRsp rsp = OBJECT_MAPPER.readValue(rspJsonStr, WoCommonRsp.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke clientCusReminderTask error", e);
        }
        return null;
    }

    public ClientGetCusTaskDetailRsp clientGetCusTaskDetail(ClientGetCusTaskDetailReq req) {
        String url = workOrderUrl + IfacePath.CLIENT_GET_CUS_TASK_DETAIL;
        try {
            String rspJsonStr = jsonPost(url, req);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                ClientGetCusTaskDetailRsp rsp = OBJECT_MAPPER.readValue(rspJsonStr, ClientGetCusTaskDetailRsp.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke clientGetCusTaskDetail error", e);
        }
        return null;
    }

    public DoorCardTransactRsp doorCardTransact(DoorCardTransactReq req) {
        String url = workOrderUrl + IfacePath.DOOR_CARD_TRANSACT;
        try {
            List<FileBean> fileBeanList = req.getWaitingList().stream().flatMap((value) -> value.getFiles().stream()).collect(Collectors.toList());
            String rspJsonStr = jsonPostWithFile2(url, req, fileBeanList);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                DoorCardTransactRsp rsp = OBJECT_MAPPER.readValue(rspJsonStr, DoorCardTransactRsp.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke doorCardTransact error", e);
        }
        return null;
    }

    public BusinessCancelRsp businessCancel(BusinessCancelReq req) {
        String url = workOrderUrl + IfacePath.BUSINESS_CANCEL;
        try {
            String rspJsonStr = jsonPost(url, req);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                BusinessCancelRsp rsp = OBJECT_MAPPER.readValue(rspJsonStr, BusinessCancelRsp.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke businessCancel error", e);
        }
        return null;
    }

    public GetBusinessStateRsp getBusinessState(GetBusinessStateReq req) {
        String url = workOrderUrl + IfacePath.GET_BUSINESS_STATE;
        try {
            String rspJsonStr = jsonPost(url, req);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                GetBusinessStateRsp rsp = OBJECT_MAPPER.readValue(rspJsonStr, GetBusinessStateRsp.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke getBusinessState error", e);
        }
        return null;
    }

/*    public AdminLoginRsp adminLogin(AdminLoginReq req) {
        String url = workOrderUrl + IfacePath.ADMIN_LOGIN;
        try {
            String rspJsonStr = jsonPost(url, req);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                AdminLoginRsp rsp = OBJECT_MAPPER.readValue(rspJsonStr, AdminLoginRsp.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke adminLogin error", e);
        }
        return null;
    }*/

    public GetEmpInfoRsp getEmpInfo(GetEmpInfoReq req) {
        String url = workOrderUrl + IfacePath.GET_EMP_INFO;
        try {
            String rspJsonStr = jsonPost(url, req);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                GetEmpInfoRsp rsp = OBJECT_MAPPER.readValue(rspJsonStr, GetEmpInfoRsp.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke getEmpInfo error", e);
        }
        return null;
    }

    //推送,81:运营新任务82:运营新任务(重新释放)83:任务取消通知, 82,83需要传empGuid
    public void sendOperatorTaskPush(int type, Long communityId, Long tskId, Long tskdId, String activityName
        , String empGuid) {
        OperatorTaskPush req = new OperatorTaskPush();
        req.setType(type);
        req.setCommunityId(communityId);
        req.setTskId(tskId);
        req.setActivityName(activityName);
        req.setEmpGuid(empGuid);
        req.setTskdId(tskdId);
        String url = workOrderUrl + IfacePath.OPERATOR_TASK_PUSH;
        try {
            jsonPost(url, req);
        } catch (IOException e) {
            logger.error("Invoke sendOperatorTaskPush error", e);
        }
    }

    public Optional<EmpBean> getEmpInfoByGuid(String empGuid) {
        List<String> empGuids = new ArrayList<>();
        empGuids.add(empGuid);

        GetEmpInfoReq req = new GetEmpInfoReq();
        req.setEmpGuids(empGuids);

        GetEmpInfoRsp rsp = getEmpInfo(req);
        logger.info("Invoke [getEmpInfo]-for-guid, req:{}, rsp:{}", req, rsp);
        if(WoCode.SUCCESS.equals(rsp.getCode())) {
            return rsp.getEmpBeans().stream().findFirst();
        }
        return Optional.empty();
    }

    public Optional<EmpBean> getEmpInfo(String phone) {
        GetEmpInfoReq req = new GetEmpInfoReq();
        req.setMobile(phone);
        GetEmpInfoRsp rsp = getEmpInfo(req);
        logger.info("Invoke [getEmpInfo]-for-phone, req:{}, rsp:{}", req, rsp);
        if(WoCode.SUCCESS.equals(rsp.getCode())) {
            return rsp.getEmpBeans().stream().findFirst();
        }
        return Optional.empty();
    }

    public Optional<EmpBean> getCacheEmpInfo(String phone) {
        String cacheKey = String.format("emp_info_%s", phone);
        EmpBean cacheVal = EMP_BEAN_CACHE.getIfPresent(cacheKey);
        if(null == cacheVal) {
            Optional<EmpBean> empBeanOptional = getEmpInfo(phone);
            empBeanOptional.ifPresent((val) -> {
                EMP_BEAN_CACHE.put(cacheKey, val);
            });
            return empBeanOptional;
        }
        return Optional.ofNullable(cacheVal);
    }
/*
    private byte[] readImage(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = OK_HTTP_CLIENT.newCall(request).execute();
        if(response.isSuccessful()) {
            return response.body().bytes();
        }
        return new byte[0];
    }*/
}
