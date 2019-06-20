package com.rfchina.community.entity;

import java.io.Serializable;
import java.util.Date;

/**
 */
public class AttentionSim implements Serializable {

    private Integer id;

    private String name;

    private Date attentionTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAttentionTime() {
        return attentionTime;
    }

    public void setAttentionTime(Date attentionTime) {
        this.attentionTime = attentionTime;
    }
}
