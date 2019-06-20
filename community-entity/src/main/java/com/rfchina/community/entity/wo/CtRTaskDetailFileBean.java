package com.rfchina.community.entity.wo;

import java.util.List;

/**
 */
public class CtRTaskDetailFileBean {

    private RTaskDetail taskDetail;

    private List<RTaskFile> files;

    public RTaskDetail getTaskDetail() {
        return taskDetail;
    }

    public void setTaskDetail(RTaskDetail taskDetail) {
        this.taskDetail = taskDetail;
    }

    public List<RTaskFile> getFiles() {
        return files;
    }

    public void setFiles(List<RTaskFile> files) {
        this.files = files;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CtRTaskDetailFileBean that = (CtRTaskDetailFileBean) o;

        if (taskDetail != null ? !taskDetail.equals(that.taskDetail) : that.taskDetail != null) return false;
        return files != null ? files.equals(that.files) : that.files == null;

    }

    @Override
    public int hashCode() {
        int result = taskDetail != null ? taskDetail.hashCode() : 0;
        result = 31 * result + (files != null ? files.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CtRTaskDetailFileBean{" +
                "taskDetail=" + taskDetail +
                ", files=" + files +
                '}';
    }
}
