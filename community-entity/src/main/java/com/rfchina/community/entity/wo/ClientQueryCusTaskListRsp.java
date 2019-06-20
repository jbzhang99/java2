package com.rfchina.community.entity.wo;

import java.util.List;

/**
 */
public class ClientQueryCusTaskListRsp extends WoCommonRsp {

    private List<RTaskBean> taskBeans;

    public List<RTaskBean> getTaskBeans() {
        return taskBeans;
    }

    public void setTaskBeans(List<RTaskBean> taskBeans) {
        this.taskBeans = taskBeans;
    }
}
