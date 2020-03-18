package com.lzw.hrmsys.model;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageModel<T> {
    private List<T> list;
    private PageInfo<T> pageInfo;

    public PageModel(){}

    public PageModel(List<T> list, PageInfo<T> pageInfo) {
        this.list = list;
        this.pageInfo = pageInfo;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public PageInfo<T> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<T> pageInfo) {
        this.pageInfo = pageInfo;
    }
}
