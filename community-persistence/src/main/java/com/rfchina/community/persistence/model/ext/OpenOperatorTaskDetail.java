package com.rfchina.community.persistence.model.ext;

import com.rfchina.community.persistence.model.OpenOperatorTask;

import java.util.List;

public class OpenOperatorTaskDetail {
    private OpenOperatorTask task;
    private SimXFSJInfo xfsjInfo;
    private SimServiceInfo serviceInfo;
    private List<ExtOperator> operatorList;

    public List<ExtOperator> getOperatorList() {
        return operatorList;
    }

    public void setOperatorList(List<ExtOperator> operatorList) {
        this.operatorList = operatorList;
    }

    public OpenOperatorTask getTask() {
        return task;
    }

    public void setTask(OpenOperatorTask task) {
        this.task = task;
    }

    public SimXFSJInfo getXfsjInfo() {
        return xfsjInfo;
    }

    public void setXfsjInfo(SimXFSJInfo xfsjInfo) {
        this.xfsjInfo = xfsjInfo;
    }

    public SimServiceInfo getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(SimServiceInfo serviceInfo) {
        this.serviceInfo = serviceInfo;
    }

}
