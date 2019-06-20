package com.rfchina.community.persistence.model.ext;

import java.io.Serializable;

/**
 */
public class BizApplyOrderApplicant implements Serializable {

    private Long masterChildId;

    private String applicant;

    private String phone;

    private Integer type;

    private Integer idType;

    private String frontImageUrl;

    private String backImageUrl;

    public Long getMasterChildId() {
        return masterChildId;
    }

    public void setMasterChildId(Long masterChildId) {
        this.masterChildId = masterChildId;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getFrontImageUrl() {
        return frontImageUrl;
    }

    public void setFrontImageUrl(String frontImageUrl) {
        this.frontImageUrl = frontImageUrl;
    }

    public String getBackImageUrl() {
        return backImageUrl;
    }

    public void setBackImageUrl(String backImageUrl) {
        this.backImageUrl = backImageUrl;
    }
}
