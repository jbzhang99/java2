package com.rfchina.community.open.bridge.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import com.rfchina.community.persistence.model.*;
import com.rfchina.community.service.openser.OpenServicePayService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.component.JavaMailComponent;
import com.rfchina.community.component.JavaMailComponent.EmailType;
import com.rfchina.community.component.OpenAuditInfoComponent;
import com.rfchina.community.component.OpenAuditInfoComponent.ObjectType;
import com.rfchina.community.open.bridge.entity.ExtOpenXFSJBusinessInfo;
import com.rfchina.community.persistence.mapper.AreaMapper;
import com.rfchina.community.persistence.mapper.CommunityMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceCategoryMapper;
import com.rfchina.community.persistence.mapper.OpenAuditInfoMapper;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.mapper.OpenServiceDetailMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJBusinessInfoMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJInfoMapper;
import com.rfchina.community.persistence.mapper.OpenXfsjSignUpInfoMapper;
import com.rfchina.community.service.SmsGlobalService;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

@Service
public class OpenXFSJBusinessInfoService extends BaseService implements IOpenAuditType {
    @Autowired
    private OpenXFSJBusinessInfoMapper openXFSJBusinessInfoMapper;

    @Autowired
    private OpenServicePayService openServicePayService;
    @Autowired
    private CommunityMapper communityMapper;
    @Autowired
    private OpenXFSJInfoMapper openXFSJInfoMapper;
    @Autowired
    private AreaMapper areaMapper;
    @Autowired
    private CommunityServiceCategoryService communityServiceCategoryService;
    @Autowired
    private CommunityServiceCategoryMapper communityServiceCategoryMapper;
    @Autowired
    private OpenMerchantInfoMapper openMerchantInfoMapper;
    @Autowired
    private CommunityServicePFService communityServicePFService;
    @Autowired
    private OpenXFSJSignUpInfoService openXFSJSignUpInfoService;
    @Autowired
    private JavaMailComponent javaMailComponent;
    @Autowired
    private OpenXfsjSignUpInfoMapper openXfsjSignUpInfoMapper;
    @Autowired
    private OpenAuditInfoMapper openAuditInfoMapper;
    @Autowired
    private SmsGlobalService smsGlobalService;
    @Autowired
    private OpenServiceDetailMapper openServiceDetailMapper;
    @Autowired
    private ResourcePatrolInfoService resourcePatrolInfoService;
    @Value("${debug.communityId}")
    private int debugCommunityId;

    /**
     * @return int
     * @throws
     * @author:fukangwen
     * @Description: 更新报名状态
     */
    public int updateXFSJSignUpStatus(Long xfsjId, int status) {
        OpenXFSJBusinessInfo openXFSJBusinessInfo = openXFSJBusinessInfoMapper.selectByPrimaryKey(xfsjId);
        openXFSJBusinessInfo.setSignUpStatus(status);
        int flag = openXFSJBusinessInfoMapper.updateByPrimaryKey(openXFSJBusinessInfo);

        return flag;
    }

    /**
     * @return void
     * @throws
     * @author:fukangwen
     * @Description: 创建小富市集招商信息
     */
    public void insert(Long id, int amount, String contactPhone, String localeImg, BigDecimal serviceFee,
                       Date signUpEndDate, int i, String type, String localeDetail) {
        OpenXFSJBusinessInfo openXFSJBusinessInfo = new OpenXFSJBusinessInfo();
        openXFSJBusinessInfo.setXfsjId(id);
        openXFSJBusinessInfo.setAmount(amount);
        openXFSJBusinessInfo.setContactPhone(contactPhone);
        openXFSJBusinessInfo.setLocaleImg(localeImg);
        openXFSJBusinessInfo.setServiceFee(serviceFee);
        openXFSJBusinessInfo.setSignUpEndTime(signUpEndDate);
        openXFSJBusinessInfo.setSignUpStatus(2);//1为可报名，2为不可报名
        openXFSJBusinessInfo.setType(type);
        openXFSJBusinessInfo.setLocaleDetail(localeDetail);
        openXFSJBusinessInfoMapper.insert(openXFSJBusinessInfo);
    }

    /**
     * @return JSONObject
     * @throws
     * @author:fukangwen
     * @Description: 获取招商信息
     */
    public JSONObject getOpenXFSJBusinessInfo(Long id) {
        JSONObject json = new JSONObject();
        //招商信息
        OpenXFSJBusinessInfo businessInfo = openXFSJBusinessInfoMapper.selectByPrimaryKey(id);
        ExtOpenXFSJBusinessInfo extBusinessInfo = new ExtOpenXFSJBusinessInfo();
        BeanUtils.copyProperties(businessInfo, extBusinessInfo);
        if (StringUtils.isNotBlank(businessInfo.getType())) {
            extBusinessInfo.setBusinessType(communityServiceCategoryService.getBusinessType(businessInfo.getType()));
        }
        json.put("businessInfo", extBusinessInfo);

        OpenXFSJInfo info = openXFSJInfoMapper.selectByPrimaryKey(id);
        Community comm = communityMapper.selectByPrimaryKey(info.getCommunityId());
        if (comm != null) {
            Integer cityId = comm.getCityId();
            if (cityId != null && cityId > 0) {
                Area city = areaMapper.selectByPrimaryKey(cityId);
                json.put("cityName", city.getName());
            }
            json.put("communityName", comm.getName());
        }

        return json;
    }

    public JSONObject getOpenXFSJBusinessAuditInfo(Long id) {
        JSONObject json = new JSONObject();
        //报名信息
        OpenXfsjSignUpInfo openXfsjSignUpInfo = openXfsjSignUpInfoMapper.selectByPrimaryKey(id);
        validator(openXfsjSignUpInfo == null, "审核信息不存在");

        //招商信息
        OpenXFSJBusinessInfo businessInfo = openXFSJBusinessInfoMapper.selectByPrimaryKey(openXfsjSignUpInfo.getXfsjId());
        json.put("amount", businessInfo.getAmount());
        json.put("auditPassAmount", openXFSJSignUpInfoService.getSignUpNum(businessInfo.getXfsjId()));

        OpenXFSJInfo info = openXFSJInfoMapper.selectByPrimaryKey(openXfsjSignUpInfo.getXfsjId());
        json.put("acitivityName", info.getActTitile());
        Community comm = communityMapper.selectByPrimaryKey(info.getCommunityId());
        if (comm != null) {
            Integer cityId = comm.getCityId();
            if (cityId != null && cityId > 0) {
                Area city = areaMapper.selectByPrimaryKey(cityId);
                json.put("cityName", city.getName());
            }
            json.put("communityName", comm.getName());
        }

        //获取商家信息
        OpenMerchantInfo openMerchantInfo = openMerchantInfoMapper.selectByPrimaryKey(openXfsjSignUpInfo.getUid());
        json.put("openMerchantInfo", openMerchantInfo);
        CommunityService communityService = communityServicePFService.getCommunityServiceByPrimaryKey(openXfsjSignUpInfo.getServiceId());
        json.put("storeName", communityService.getTitle());

        int categoryId = 0;
        OpenServiceDetail detail = openServiceDetailMapper.selectByPrimaryKey(communityService.getId());
        if (detail.getCategorySecondType() != null && detail.getCategorySecondType() > 0) {
            categoryId = detail.getCategorySecondType();
        } else {
            categoryId = communityService.getCategoryId();
        }
        json.put("storeType", communityServiceCategoryMapper.selectByPrimaryKey(categoryId).getName());
        json.put("storeDescription", communityService.getDescription());
        json.put("qrCode", getQrBase64(communityService.getLink()));
        json.put("registerPhone", openMerchantInfo.getContactPhone());
        return json;
    }

    public String getQrBase64(String url) {
        if (StringUtils.isBlank(url))
            return "";
        ServletOutputStream sos = null;
        File file;
        try {
            file = QRCode.from(url).to(ImageType.PNG).withSize(350, 350).file();
        } finally {
            if (sos != null) {
                try {
                    sos.close();
                } catch (IOException e) {
                    error("生成二维码失败");
                }
            }
        }
        return fileToBase64(file);
    }

    public String fileToBase64(File file) {
        String base64 = null;
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            byte[] bytes = new byte[in.available()];
            int length = in.read(bytes);
            base64 = java.util.Base64.getEncoder().encodeToString(bytes);
        } catch (FileNotFoundException e) {
            error("生成二维码失败");
        } catch (IOException e) {
            error("生成二维码失败");
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                error("生成二维码失败");
                e.printStackTrace();
            }
        }
        return base64;
    }

    @Override
    public IOpenAuditTypeReturn audit(ObjectType type) {
        if (type.compareTo(ObjectType.xfsj_sign_up_apply) == 0) {
            return new IOpenAuditTypeReturn() {

                @Override
                public void passAudit(Long uid, String objectId, Map<String, String> parameter) throws Exception {
                    OpenXfsjSignUpInfo openXfsjSignUpInfo = openXfsjSignUpInfoMapper.selectByPrimaryKey(Long.parseLong(objectId));
                    openXfsjSignUpInfo.setStatus(OpenConstant.SignUpCheckStatus.PASS);
                    openXfsjSignUpInfoMapper.updateByPrimaryKeySelective(openXfsjSignUpInfo);

                    OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(uid);
                    OpenXFSJInfo xfsjInfo = openXFSJInfoMapper.selectByPrimaryKey(openXfsjSignUpInfo.getXfsjId());
                    OpenXFSJBusinessInfo xfsjBusinessInfo = openXFSJBusinessInfoMapper.selectByPrimaryKey(openXfsjSignUpInfo.getXfsjId());
                    String phone = xfsjBusinessInfo.getContactPhone() == null ? "" : xfsjBusinessInfo.getContactPhone();
                    // sms
                    smsGlobalService.sendSms(info.getContactPhone(), SmsGlobalService.SmsType.xfsj_sign_up_success, xfsjInfo.getActTitile(), phone);

                    //email
                    Map<String, Object> model = new HashMap<>();
                    model.put("title", info.getTitle());
                    model.put("actTitle", xfsjInfo.getActTitile());
                    model.put("phone", phone);
                    javaMailComponent.sendEmail(EmailType.xfsj_merchant_sign_up_pass, info.getEmail(), model);
                }

                @Override
                public void unpassAudit(Long uid, String objectId, String reason) throws Exception {
                    OpenXfsjSignUpInfo openXfsjSignUpInfo = openXfsjSignUpInfoMapper.selectByPrimaryKey(Long.parseLong(objectId));
                    openXfsjSignUpInfo.setStatus(OpenConstant.SignUpCheckStatus.NO_PASS);
                    openXfsjSignUpInfo.setRefuseContent(reason);
                    openXfsjSignUpInfoMapper.updateByPrimaryKeySelective(openXfsjSignUpInfo);

                    OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(uid);
                    OpenXFSJInfo xfsjInfo = openXFSJInfoMapper.selectByPrimaryKey(openXfsjSignUpInfo.getXfsjId());
                    OpenXFSJBusinessInfo xfsjBusinessInfo = openXFSJBusinessInfoMapper.selectByPrimaryKey(openXfsjSignUpInfo.getXfsjId());
                    String phone = xfsjBusinessInfo.getContactPhone() == null ? "" : xfsjBusinessInfo.getContactPhone();

                    // sms
                    smsGlobalService.sendSms(info.getContactPhone(), SmsGlobalService.SmsType.xfsj_sign_up_failed, xfsjInfo.getActTitile(), phone);

                    //email
                    Map<String, Object> model = new HashMap<>();
                    model.put("title", info.getTitle());
                    model.put("actTitle", xfsjInfo.getActTitile());
                    model.put("phone", phone);
                    model.put("reason", reason);
                    javaMailComponent.sendEmail(EmailType.xfsj_merchant_sign_up_unpass, info.getEmail(), model);

                }

            };
        }
        return null;
    }

    /**
     * @return Object
     * @throws
     * @author:fukangwen
     * @Description: 获取该活动的报名信息列表
     */
    public List<JSONObject> getSignUpList(Long xfsjId) {
        List<Integer> statusList = new ArrayList<>();
        statusList.add(OpenConstant.SignUpCheckStatus.PASS);
        statusList.add(OpenConstant.SignUpCheckStatus.PAID);

        OpenXfsjSignUpInfoExample example = new OpenXfsjSignUpInfoExample();
        example.createCriteria().andXfsjIdEqualTo(xfsjId).andStatusIn(statusList);
        example.setOrderByClause("id desc");
        List<OpenXfsjSignUpInfo> list = openXfsjSignUpInfoMapper.selectByExample(example);
        List<JSONObject> jsonList = new ArrayList<>();
        for (OpenXfsjSignUpInfo signUpInfo : list) {
            JSONObject json = new JSONObject();
            //获取商家信息
            OpenMerchantInfo openMerchantInfo = openMerchantInfoMapper.selectByPrimaryKey(signUpInfo.getUid());
            json.put("openMerchantInfo", openMerchantInfo);
            json.put("id", signUpInfo.getId());
            json.put("serviceFee", signUpInfo.getServiceFee());//服务费
            json.put("status", signUpInfo.getStatus()); //报名状态

            CommunityService communityService = communityServicePFService.getCommunityServiceByPrimaryKey(signUpInfo.getServiceId());
            validator(communityService == null, "店铺信息不存在");
            json.put("storeName", communityService.getTitle()); //商店名
            int categoryId = 0;
            OpenServiceDetail detail = openServiceDetailMapper.selectByPrimaryKey(communityService.getId());
            if (detail.getCategorySecondType() != null && detail.getCategorySecondType() > 0) {
                categoryId = detail.getCategorySecondType();
            } else {
                categoryId = communityService.getCategoryId();
            }
            json.put("storeType", communityServiceCategoryMapper.selectByPrimaryKey(categoryId).getName());//店铺类型


            OpenServicePay pay = openServicePayService.getOpenServicePay(signUpInfo.getServiceId());
            json.put("pay", pay);
            json.put("commissionRate", pay.getCommunityRate());//社区服务费
            jsonList.add(json);
        }

        return jsonList;
    }

    /**
     * @return Object
     * @throws
     * @author:fukangwen
     * @Description: 删除该报名信息
     */
    public void deleteSignUpUser(Long signUpId) {
        OpenXfsjSignUpInfo openXfsjSignUpInfo = openXfsjSignUpInfoMapper.selectByPrimaryKey(signUpId);
        validator(openXfsjSignUpInfo == null, "报名信息不存在");
        validator(openXfsjSignUpInfo.getStatus() != OpenConstant.SignUpCheckStatus.PASS, "报名成功状态的才可以删除");

        //状态致为不通过
        String refuseContent = "社区拒绝了你的报名申请";
        openXfsjSignUpInfo.setStatus(OpenConstant.SignUpCheckStatus.NO_PASS);
        openXfsjSignUpInfo.setRefuseContent(refuseContent);
        openXfsjSignUpInfoMapper.updateByPrimaryKeySelective(openXfsjSignUpInfo);

        //更改审核表内容
        OpenAuditInfoExample example = new OpenAuditInfoExample();
        example.createCriteria().andAuditTypeEqualTo(OpenAuditInfoComponent.ObjectType.xfsj_provider_apply.toString())
                .andObjectIdEqualTo(String.valueOf(signUpId));
        List<OpenAuditInfo> auditList = openAuditInfoMapper.selectByExample(example);
        if (auditList.isEmpty() || auditList.size() > 1)
            return;

        OpenAuditInfo auditInfo = auditList.get(0);
        auditInfo.setAuditContent(refuseContent);
        auditInfo.setAuditStatus(OpenAuditInfoComponent.Status.unpass.getV());

        openAuditInfoMapper.updateByPrimaryKey(auditInfo);
    }


}
