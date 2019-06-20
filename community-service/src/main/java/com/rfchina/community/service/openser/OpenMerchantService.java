package com.rfchina.community.service.openser;

import com.rfchina.api.response.model.mch.MchModel;
import com.rfchina.api.response.model.mch.MchResponseModel;
import com.rfchina.community.persistence.mapper.BaseMapper;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.model.OpenMerchantInfo;
import com.rfchina.community.persistence.model.OpenMerchantInfoExample;
import com.rfchina.community.service.AbstractService;
import org.apache.ibatis.annotations.Param;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName OpenMerchantService
 * @Description 商家相关service
 * @Author wlrllr
 * @Date 2018/12/20 9:30
 * @Version 1.0
 **/
@Service
public class OpenMerchantService extends AbstractService<OpenMerchantInfo,OpenMerchantInfoExample,Long> {

    @Autowired
    protected OpenMerchantInfoMapper openMerchantInfoMapper;

    @Override
    public BaseMapper<OpenMerchantInfo, OpenMerchantInfoExample, Long> getMapper() {
        return openMerchantInfoMapper;
    }

    public OpenMerchantInfo getMerchantByMchId(String merchantId){
        OpenMerchantInfoExample example = new OpenMerchantInfoExample();
        example.createCriteria().andMchIdEqualTo(merchantId);
        List<OpenMerchantInfo> records = selectByExample(example);
        if (records != null && records.size() > 0) {
            return records.get(0);
        }
        return new OpenMerchantInfo();
    }

    public boolean addMerchantInfo(OpenMerchantInfo openMerchantInfo){
        try{
            if(openMerchantInfo != null){
                return 1 == insertSelective(openMerchantInfo);
            }
        }catch (Exception e){
            logger.error("新增商家失败",e);
        }
        return false;
    }

    public boolean updateMerchantInfo(OpenMerchantInfo openMerchantInfo){
        if(openMerchantInfo != null && openMerchantInfo.getId() != null){
            return 1 == updateByPrimaryKeySelective(openMerchantInfo);
        }
        return false;
    }

    public Boolean isExist(Long uid) {
        OpenMerchantInfo record = selectByPrimaryKey(uid);
        if(record == null)
            return false;
        return true;
    }

    /**
     * @Author wlrllr
     * @Description 复制属性
     * @Date 2018/12/24
     * @Param [OpenMerchantInfo, MchResponseModel]
     **/
    public void copyProperties(OpenMerchantInfo record, MchModel model){
        record.setRegistrationNumber(model.getBusinessLicense());
        record.setLegalName(model.getLegalPerName());
        record.setIdNumber(model.getRespPerIdNo());
        record.setContactPerson(model.getRespPerName());
        record.setContactPhone(model.getRespPerTelephoneNo());
        record.setUpdateTime(model.getLastUpdTime());
        record.setCreateTime(model.getCreateTime());
        record.setEmail(model.getRespPerEmail());
        record.setOrganizationCode(model.getOrganizationCode());
        record.setTexRegistrationNo(model.getTexRegistrationNo());
        record.setBusinessLicense(model.getBusinessLicensePic());
        record.setIdPositive(model.getRespPerIdPositive());
        record.setIdObverse(model.getRespPerIdOpposite());
        record.setAreaInfo(model.getBusinessAddress());
        record.setTel(model.getTel());
    }

    public PageList<OpenMerchantInfo> pageByExample(OpenMerchantInfoExample example, PageBounds pageBounds){
        return openMerchantInfoMapper.pageByExample(example,pageBounds);
    }
}
