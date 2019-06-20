package com.rfchina.community.openweb.entity;

import java.io.Serializable;
import java.util.List;

/**
 */
public class Page<T> implements Serializable {

    private Integer index;

    private Integer size;

    private Long num;

    private Long total;

    private List<T> list;


    public Page(Integer index, Integer size, Long num, Long total, List<T> list) {
        this.index = index;
        this.size = size;
        this.num = num;
        this.total = total;
        this.list = list;
    }

    public Page() {
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }


}
