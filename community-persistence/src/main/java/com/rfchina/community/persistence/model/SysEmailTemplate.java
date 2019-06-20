package com.rfchina.community.persistence.model;

import java.io.Serializable;

public class SysEmailTemplate implements Serializable {
    private String emailType;

    private String emailSubject;

    private String emailTemplate;

    private static final long serialVersionUID = 1L;

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailTemplate() {
        return emailTemplate;
    }

    public void setEmailTemplate(String emailTemplate) {
        this.emailTemplate = emailTemplate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", emailType=").append(emailType);
        sb.append(", emailSubject=").append(emailSubject);
        sb.append(", emailTemplate=").append(emailTemplate);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysEmailTemplate other = (SysEmailTemplate) that;
        return (this.getEmailType() == null ? other.getEmailType() == null : this.getEmailType().equals(other.getEmailType()))
            && (this.getEmailSubject() == null ? other.getEmailSubject() == null : this.getEmailSubject().equals(other.getEmailSubject()))
            && (this.getEmailTemplate() == null ? other.getEmailTemplate() == null : this.getEmailTemplate().equals(other.getEmailTemplate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEmailType() == null) ? 0 : getEmailType().hashCode());
        result = prime * result + ((getEmailSubject() == null) ? 0 : getEmailSubject().hashCode());
        result = prime * result + ((getEmailTemplate() == null) ? 0 : getEmailTemplate().hashCode());
        return result;
    }
}