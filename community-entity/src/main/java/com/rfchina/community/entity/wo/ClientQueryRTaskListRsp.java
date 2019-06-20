package com.rfchina.community.entity.wo;

import java.util.List;

/**
 */
public class ClientQueryRTaskListRsp extends WoCommonRsp {

    private List<RTaskBean> taskBeans;

    public List<RTaskBean> getTaskBeans() {
        return taskBeans;
    }

    public void setTaskBeans(List<RTaskBean> taskBeans) {
        this.taskBeans = taskBeans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientQueryRTaskListRsp that = (ClientQueryRTaskListRsp) o;

        return taskBeans != null ? taskBeans.equals(that.taskBeans) : that.taskBeans == null;

    }

    @Override
    public int hashCode() {
        return taskBeans != null ? taskBeans.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ClientQueryRTaskListRsp{" +
                "taskBeans=" + taskBeans +
                '}';
    }
}
