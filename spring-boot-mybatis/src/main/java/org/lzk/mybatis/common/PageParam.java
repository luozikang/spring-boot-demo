package org.lzk.mybatis.common;

public class PageParam {
    private int beginLine;       //起始行
    private Integer pageSize = 3;
    private Integer currentPage=0;        // 当前页
    //getter setter省略
    public int getBeginLine() {
        return pageSize*currentPage;//自动计算起始行
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public void setBeginLine(int beginLine) {
        this.beginLine = beginLine;
    }

    @Override
    public String toString() {
        return "PageParam{" +
                "beginLine=" + beginLine +
                ", pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                '}';
    }
}