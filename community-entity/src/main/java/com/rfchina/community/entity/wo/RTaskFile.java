package com.rfchina.community.entity.wo;

import java.io.Serializable;

/**
 */
public class RTaskFile implements Serializable {

    private String tfGuid;

    private String tfGroupGuid;

    private String tfPath;

    private String tfFileName;

    private String tfAddTime;

    private String tfFrom;

    private String tfType;

    private String tfUrl;

    public String getTfGuid() {
        return tfGuid;
    }

    public void setTfGuid(String tfGuid) {
        this.tfGuid = tfGuid;
    }

    public String getTfGroupGuid() {
        return tfGroupGuid;
    }

    public void setTfGroupGuid(String tfGroupGuid) {
        this.tfGroupGuid = tfGroupGuid;
    }

    public String getTfPath() {
        return tfPath;
    }

    public void setTfPath(String tfPath) {
        this.tfPath = tfPath;
    }

    public String getTfFileName() {
        return tfFileName;
    }

    public void setTfFileName(String tfFileName) {
        this.tfFileName = tfFileName;
    }

    public String getTfAddTime() {
        return tfAddTime;
    }

    public void setTfAddTime(String tfAddTime) {
        this.tfAddTime = tfAddTime;
    }

    public String getTfFrom() {
        return tfFrom;
    }

    public void setTfFrom(String tfFrom) {
        this.tfFrom = tfFrom;
    }

    public String getTfType() {
        return tfType;
    }

    public void setTfType(String tfType) {
        this.tfType = tfType;
    }

    public String getTfUrl() {
        return tfUrl;
    }

    public void setTfUrl(String tfUrl) {
        this.tfUrl = tfUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RTaskFile rTaskFile = (RTaskFile) o;

        if (tfGuid != null ? !tfGuid.equals(rTaskFile.tfGuid) : rTaskFile.tfGuid != null) return false;
        if (tfGroupGuid != null ? !tfGroupGuid.equals(rTaskFile.tfGroupGuid) : rTaskFile.tfGroupGuid != null)
            return false;
        if (tfPath != null ? !tfPath.equals(rTaskFile.tfPath) : rTaskFile.tfPath != null) return false;
        if (tfFileName != null ? !tfFileName.equals(rTaskFile.tfFileName) : rTaskFile.tfFileName != null) return false;
        if (tfAddTime != null ? !tfAddTime.equals(rTaskFile.tfAddTime) : rTaskFile.tfAddTime != null) return false;
        if (tfFrom != null ? !tfFrom.equals(rTaskFile.tfFrom) : rTaskFile.tfFrom != null) return false;
        if (tfType != null ? !tfType.equals(rTaskFile.tfType) : rTaskFile.tfType != null) return false;
        return tfUrl != null ? tfUrl.equals(rTaskFile.tfUrl) : rTaskFile.tfUrl == null;

    }

    @Override
    public int hashCode() {
        int result = tfGuid != null ? tfGuid.hashCode() : 0;
        result = 31 * result + (tfGroupGuid != null ? tfGroupGuid.hashCode() : 0);
        result = 31 * result + (tfPath != null ? tfPath.hashCode() : 0);
        result = 31 * result + (tfFileName != null ? tfFileName.hashCode() : 0);
        result = 31 * result + (tfAddTime != null ? tfAddTime.hashCode() : 0);
        result = 31 * result + (tfFrom != null ? tfFrom.hashCode() : 0);
        result = 31 * result + (tfType != null ? tfType.hashCode() : 0);
        result = 31 * result + (tfUrl != null ? tfUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RTaskFile{" +
                "tfGuid='" + tfGuid + '\'' +
                ", tfGroupGuid='" + tfGroupGuid + '\'' +
                ", tfPath='" + tfPath + '\'' +
                ", tfFileName='" + tfFileName + '\'' +
                ", tfAddTime='" + tfAddTime + '\'' +
                ", tfFrom='" + tfFrom + '\'' +
                ", tfType='" + tfType + '\'' +
                ", tfUrl='" + tfUrl + '\'' +
                '}';
    }
}
