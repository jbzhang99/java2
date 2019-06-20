package com.rfchina.community.entity.wo;

import java.io.Serializable;

/**
 */
public class WoCommonRsp implements Serializable {

    private String code;

    private String content;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WoCommonRsp that = (WoCommonRsp) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        return content != null ? content.equals(that.content) : that.content == null;

    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WoCommonRsp{" +
                "code='" + code + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
