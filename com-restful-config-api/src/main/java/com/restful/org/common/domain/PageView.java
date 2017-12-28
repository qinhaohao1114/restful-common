package com.restful.org.common.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 分页
 *
 * @author qinhaohao
 * @create 2017-12-28 16:13
 **/
public class PageView<T> implements Serializable {
    private static final long serialVersionUID = 2357242405641878344L;
    private List<T> result = Collections.emptyList();
    private int currentPage = 1;
    private int pageSize = 10;
    private long totalPages;
    private long totalSize;

    public PageView() {
    }

    public List<T> getResult() {
        return this.result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if (currentPage > 0) {
            this.currentPage = currentPage;
        }

    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
        this.setTotalPages(this.totalSize % (long)this.pageSize == 0L ? this.totalSize / (long)this.pageSize : this.totalSize / (long)this.pageSize + 1L);
    }

    public static <T> PageView<T> newPage(int page, int pageSize) {
        PageView pageView = new PageView();
        pageView.setCurrentPage(page);
        pageView.setPageSize(pageSize);
        return pageView;
    }
}
