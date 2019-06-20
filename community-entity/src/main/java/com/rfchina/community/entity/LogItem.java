package com.rfchina.community.entity;

import java.io.Serializable;

/**
 */
public class LogItem<T> implements Serializable {

    private String field;

    private T value;

    public LogItem(String field, T data) {
        this.field = field;
        this.value = data;
    }

    public LogItem() {
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return field + ":" + (value!=null? value:"");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogItem<?> logItem = (LogItem<?>) o;

        if (field != null ? !field.equals(logItem.field) : logItem.field != null) return false;
        return value != null ? value.equals(logItem.value) : logItem.value == null;

    }

    @Override
    public int hashCode() {
        int result = field != null ? field.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
