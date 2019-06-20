package com.rfchina.community.entity.wo;

import java.util.List;

/**
 */
public class ClientGetRTaskDetailRsp extends WoCommonRsp {

    private RTaskBean taskBean;

    private List<CtRTaskDetailFileBean> beans;

    public RTaskBean getTaskBean() {
        return taskBean;
    }

    public void setTaskBean(RTaskBean taskBean) {
        this.taskBean = taskBean;
    }

    public List<CtRTaskDetailFileBean> getBeans() {
        return beans;
    }

    public void setBeans(List<CtRTaskDetailFileBean> beans) {
        this.beans = beans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientGetRTaskDetailRsp that = (ClientGetRTaskDetailRsp) o;

        if (taskBean != null ? !taskBean.equals(that.taskBean) : that.taskBean != null) return false;
        return beans != null ? beans.equals(that.beans) : that.beans == null;

    }

    @Override
    public int hashCode() {
        int result = taskBean != null ? taskBean.hashCode() : 0;
        result = 31 * result + (beans != null ? beans.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientGetRTaskDetailRsp{" +
                "taskBean=" + taskBean +
                ", beans=" + beans +
                '}';
    }
}
