package com.rfchina.community.entity.wo;

import java.io.Serializable;
import java.util.List;

/**
 */
public class WaitingBean implements Serializable {

    private String applicant;

    private String applicantTel;

    private String applicantIdentity;

    private String applicantIdType;

    private List<FileBean> files;

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getApplicantTel() {
        return applicantTel;
    }

    public void setApplicantTel(String applicantTel) {
        this.applicantTel = applicantTel;
    }

    public String getApplicantIdentity() {
        return applicantIdentity;
    }

    public void setApplicantIdentity(String applicantIdentity) {
        this.applicantIdentity = applicantIdentity;
    }

    public String getApplicantIdType() {
        return applicantIdType;
    }

    public void setApplicantIdType(String applicantIdType) {
        this.applicantIdType = applicantIdType;
    }

    public List<FileBean> getFiles() {
        return files;
    }

    public void setFiles(List<FileBean> files) {
        this.files = files;
    }
}
