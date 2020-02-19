package org.lzk.mybatis.common;

import java.io.Serializable;
import java.util.List;

public class Page<E> implements Serializable {
    private int currentPage = 0; //当前页数
    private long totalPage;       //总页数
    private long totalNumber;    //总记录数
    private List<E> list;        //数据集

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalNumber=" + totalNumber +
                ", list=" + list +
                '}';
    }

    public Page(long totalNumber, List<E> list) {
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.totalNumber = totalNumber;
        this.list = list;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(long totalNumber) {
        this.totalNumber = totalNumber;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
