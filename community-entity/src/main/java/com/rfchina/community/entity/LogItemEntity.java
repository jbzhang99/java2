package com.rfchina.community.entity;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class LogItemEntity<T> {

    private String moduleName;

    private List<LogItem<T>> logItemList = new ArrayList<>();

    public LogItemEntity(String moduleName) {
        this.moduleName = moduleName;
    }

    public LogItemEntity<T> add(String field, T value) {
        logItemList.add(new LogItem<T>(field, value));
        return this;
    }

    public static final <T> LogItemEntity<T> create(String moduleName) {
        return new LogItemEntity<T>(moduleName);
    }


    public List<LogItem<T>> getLogItemList() {
        return logItemList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogItemEntity<?> entity = (LogItemEntity<?>) o;

        if (!moduleName.equals(entity.moduleName)) return false;
        return logItemList.equals(entity.logItemList);

    }

    @Override
    public int hashCode() {
        int result = moduleName.hashCode();
        result = 31 * result + logItemList.hashCode();
        return result;
    }
}
