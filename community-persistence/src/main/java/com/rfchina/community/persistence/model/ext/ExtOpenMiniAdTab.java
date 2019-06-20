package com.rfchina.community.persistence.model.ext;

import com.rfchina.community.persistence.model.OpenMiniAdTab;

public class ExtOpenMiniAdTab extends OpenMiniAdTab {
    private  String title;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
