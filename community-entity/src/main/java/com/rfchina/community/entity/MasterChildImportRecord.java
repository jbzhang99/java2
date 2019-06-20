package com.rfchina.community.entity;

import java.io.Serializable;

/**
 */
public class MasterChildImportRecord implements Serializable {

    private Integer successCount = 0;

    private Integer failureCount = 0;

    private Integer inputErrorCount = 0;

    private Integer repeatedCount = 0;

    public Integer getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(Integer successCount) {
        this.successCount = successCount;
    }

    public Integer getFailureCount() {
        return failureCount;
    }

    public void setFailureCount(Integer failureCount) {
        this.failureCount = failureCount;
    }

    public Integer getInputErrorCount() {
        return inputErrorCount;
    }

    public void setInputErrorCount(Integer inputErrorCount) {
        this.inputErrorCount = inputErrorCount;
    }

    public Integer getRepeatedCount() {
        return repeatedCount;
    }

    public void setRepeatedCount(Integer repeatedCount) {
        this.repeatedCount = repeatedCount;
    }
}
