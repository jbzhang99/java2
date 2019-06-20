package com.rfchina.community.entity.wo;

import java.io.Serializable;

/**
 */
public class FileBean implements Serializable {

    private String tfAutoId;

    private String tfGuid;

    private String tfGroupGuid;

    private String tfPath;

    private String tfFileName;

    private String tfAddTime;

    private String tfFrom;

    private String tfType;

    private String tfUrl;


    public String getTfAutoId() {
        return tfAutoId;
    }

    public void setTfAutoId(String tfAutoId) {
        this.tfAutoId = tfAutoId;
    }

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
}
