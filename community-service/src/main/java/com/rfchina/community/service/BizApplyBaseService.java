package com.rfchina.community.service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rfchina.community.base.Constant;
import com.rfchina.community.component.AreaComponent;
import com.rfchina.community.component.WorkOrderComponent;
import com.rfchina.community.entity.wo.*;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.mapper.ext.ExtBizApplyOrderMapper;
import com.rfchina.community.persistence.mapper.ext.ExtMasterInfoGlobalMapper;
import com.rfchina.community.persistence.model.BizApplyConf;
import com.rfchina.community.persistence.model.BizApplyOrder;
import com.rfchina.community.persistence.model.RepairCommunityProjectRelaExample;
import com.rfchina.community.persistence.model.RepairCommunityProjectRelaKey;
import com.rfchina.community.persistence.model.ext.BizApplyOrderApplicant;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.tuple.Triple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 */
public class BizApplyBaseService {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    static {
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    @Autowired
    protected MasterInfoMapper masterInfoMapper;

    @Autowired
    protected ExtMasterInfoGlobalMapper extMasterInfoMapper;

    @Autowired
    protected MasterChildMapper masterChildMapper;

    @Autowired
    protected BizApplyConfMapper bizApplyConfMapper;

    @Autowired
    protected BizApplyOrderMapper bizApplyOrderMapper;

    @Autowired
    protected ExtBizApplyOrderMapper extBizApplyOrderMapper;

    @Autowired
    protected UserInfoMapper userInfoMapper;

    @Autowired
    protected CommunityMapper communityMapper;

    @Autowired
    protected CommunityPayMapper communityPayMapper;

    @Autowired
    protected SmsGlobalService smsGlobalService;

    @Autowired
    protected WorkOrderComponent workOrderComponent;

    @Autowired
    protected BizApplyOrderStateMapper bizApplyOrderStateMapper;

    @Autowired
    protected RepairCommunityProjectRelaMapper repairCommunityProjectRelaMapper;

    @Autowired
    protected AreaComponent areaComponent;

    protected Optional<String> getProjectIdOptional(Integer communityId) {
        RepairCommunityProjectRelaExample example = new RepairCommunityProjectRelaExample();
        example.createCriteria().andCommunityIdEqualTo(communityId);
        Optional<String> optional = repairCommunityProjectRelaMapper.selectByExample(example)
                .stream()
                .map(RepairCommunityProjectRelaKey::getProjectId)
                .findFirst();
        return optional;
    }

    public List<BizApplyOrderApplicant> jsonToBizApplyOrderApplicantList(String json, boolean throwException) {
        try {
            if(StringUtils.isNotBlank(json)) {
                List<BizApplyOrderApplicant> list = JSON.parseArray(json, BizApplyOrderApplicant.class);
                return list;
            }
        } catch (Exception e) {
            logger.error("Cannot parse json for: ", json);
            if(throwException) {
                throw e;
            }
        }
        return Collections.EMPTY_LIST;
    }

    protected String createTradeNo() {
        String tradeNo = "1009" + DateFormatUtils.format(new Date(), "yyMMdd") + RandomStringUtils.randomNumeric(5);
        return tradeNo;
    }

    protected List<FileBean> mediaToFileBeanList(BizApplyOrderApplicant applicant) {
        List<FileBean> list = new ArrayList<>();
        if(null != applicant) {
            String tfPath = DateFormatUtils.format(new Date(), Constant.SHORT_DATE_FORMAT);

            if(StringUtils.isNotBlank(applicant.getFrontImageUrl())) {
                String guid1 = UUID.randomUUID().toString();
                String fileName1 = WorkOrderComponent.getFileNameFromUrl(applicant.getFrontImageUrl());
                String newFileName1 = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(fileName1);

                FileBean file1 = new FileBean();
                file1.setTfGuid(guid1);
                file1.setTfGroupGuid(guid1);
                file1.setTfFrom("APP");
                file1.setTfType("JPG");
                file1.setTfPath(tfPath);
                file1.setTfFileName(newFileName1);
                file1.setTfUrl(applicant.getFrontImageUrl());
                //
                list.add(file1);
            }

            if(StringUtils.isNotBlank(applicant.getBackImageUrl())) {
                String guid2 = UUID.randomUUID().toString();
                String fileName2 = WorkOrderComponent.getFileNameFromUrl(applicant.getBackImageUrl());
                String newFileName2 = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(fileName2);

                FileBean file2 = new FileBean();
                file2.setTfGuid(guid2);
                file2.setTfGroupGuid(guid2);
                file2.setTfFrom("APP");
                file2.setTfType("JPG");
                file2.setTfPath(tfPath);
                file2.setTfFileName(newFileName2);
                file2.setTfUrl(applicant.getBackImageUrl());
                //
                list.add(file2);
            }
        }
        return list;
    }

    protected List<RTaskFile> mediaToTaskFileList(BizApplyOrderApplicant applicant) {
        List<RTaskFile> list = new ArrayList<>();
        if(null != applicant) {
            String tfPath = DateFormatUtils.format(new Date(), Constant.SHORT_DATE_FORMAT);

            if(StringUtils.isNotBlank(applicant.getFrontImageUrl())) {
                String guid1 = UUID.randomUUID().toString();
                String fileName1 = WorkOrderComponent.getFileNameFromUrl(applicant.getFrontImageUrl());
                String newFileName1 = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(fileName1);

                RTaskFile file1 = new RTaskFile();
                file1.setTfGuid(guid1);
                file1.setTfGroupGuid(guid1);
                file1.setTfFrom("APP");
                file1.setTfType("JPG");
                file1.setTfPath(tfPath);
                file1.setTfFileName(newFileName1);
                file1.setTfUrl(applicant.getFrontImageUrl());

                list.add(file1);
            }


            if(StringUtils.isNotBlank(applicant.getBackImageUrl())) {
                String guid2 = UUID.randomUUID().toString();
                String fileName2 = WorkOrderComponent.getFileNameFromUrl(applicant.getBackImageUrl());
                String newFileName2 = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(fileName2);

                RTaskFile file2 = new RTaskFile();
                file2.setTfGuid(guid2);
                file2.setTfGroupGuid(guid2);
                file2.setTfFrom("APP");
                file2.setTfType("JPG");
                file2.setTfPath(tfPath);
                file2.setTfFileName(newFileName2);
                file2.setTfUrl(applicant.getBackImageUrl());

                list.add(file2);
            }
        }
        return list;
    }

    public Triple<Boolean, String, String> createIssueOrder(BizApplyOrder order, String projectId) {

        String contentFormat = "门禁卡办理（已缴费）。制卡结束后点击「完成」，后台会自动通知业户领取。申请人信息如下：\n%s";
        boolean flag = false;
        //
        ClientCusTaskAddReq req = new ClientCusTaskAddReq();
        req.setFrom(ClientCusTaskAddReq.From.BIZ_APPLY);
        req.setProjectGuid(projectId);
        req.setContact(order.getContact());
        req.setContactTel(order.getPhone());
        req.setAddr(order.getApplyAddress());
        req.setOrderNo(order.getTradeNo());

        List<BizApplyOrderApplicant> applicantList = jsonToBizApplyOrderApplicantList(order.getAttachment(), false);
        List<RTaskFile> taskFileList = applicantList.stream()
                .flatMap((value) -> mediaToTaskFileList(value).stream())
                .collect(Collectors.toList());

        StringBuilder applicantInfo = new StringBuilder();
        applicantList.forEach((item) -> {
            applicantInfo.append("申请人: " + item.getApplicant() + ", 手机号码: " + item.getPhone() + "\n");
        });
        String content = String.format(contentFormat, applicantInfo.toString());

        req.setMsgContent(content);
        req.setFiles(taskFileList);

        req.setMsgTypeGuid("63F348A8-1109-4130-B6CF-B756080A32BB");
        req.setMsgTypeName("管家服务");

        ClientCusTaskAddRsp rsp = workOrderComponent.clientCusTaskAdd(req);
        String tskCode = "";
        if(rsp!=null && WoCode.SUCCESS.equals(rsp.getCode())) {
            flag = true;
            tskCode = rsp.getTskCode();
        }
        logger.info("Invoke [clientCusTaskAdd], result:{}, req:{}, rsp:{}", flag, req, rsp);
        return Triple.of(flag, tskCode, JSON.toJSONString(req));
    }

    public BizApplyConf getBizApplyConf(Integer communityId) {
        BizApplyConf record = bizApplyConfMapper.selectByPrimaryKey(communityId);
        return Optional.ofNullable(record).orElseGet(() -> {
            BizApplyConf conf = new BizApplyConf();
            conf.setCardPrice(new BigDecimal(0));
            conf.setObtainAddress("");
            conf.setCommunityId(communityId);
            return conf;
        });
    }
}
