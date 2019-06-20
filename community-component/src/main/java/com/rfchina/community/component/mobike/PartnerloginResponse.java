package com.rfchina.community.component.mobike;

/**
 */
public class PartnerloginResponse extends AbstractMobikeResponse {

    private String isinvitation;

    private String userid;

    private String authtoken;

    private Integer progress;

    private String h5Url;

    private PartnerloginObject object;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAuthtoken() {
        return authtoken;
    }

    public void setAuthtoken(String authtoken) {
        this.authtoken = authtoken;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public String getH5Url() {
        return h5Url;
    }

    public void setH5Url(String h5Url) {
        this.h5Url = h5Url;
    }

    public String getIsinvitation() {
        return isinvitation;
    }

    public void setIsinvitation(String isinvitation) {
        this.isinvitation = isinvitation;
    }

    public PartnerloginObject getObject() {
        return object;
    }

    public void setObject(PartnerloginObject object) {
        this.object = object;
    }
}
