package com.lzw.hrmsys.model;

import com.github.pagehelper.PageInfo;

public class QueryModel<T> {
    private T obj ;
    private Integer pageNum;
    private Integer pageSize;
    public QueryModel() {}

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "QueryModel{" +
                "obj=" + obj +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
