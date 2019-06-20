package com.rfchina.community.entity;

import java.io.Serializable;

/**
 */
public class HouseType implements Serializable {

    private Integer id;
    private String name;

    public HouseType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public HouseType() {
    }

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
}
