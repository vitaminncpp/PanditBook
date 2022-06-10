package com.aksahyaap.panditbook.model;

import com.google.gson.annotations.SerializedName;

public class Search {
    @SerializedName("searchBy")
    private String searchBy;
    @SerializedName("searchValue")
    private String searchValue;
    @SerializedName("pageno")
    private int pageno;
    @SerializedName("pageSize")
    private int pageSize;
    @SerializedName("sortBy")
    private String sortBy;
    @SerializedName("sortOrder")
    private String sortOrder;

    public Search() {
    }

    public Search(String searchBy,String searchValue, int pageno, int pageSize, String sortBy, String sortOrder) {
        this.searchBy = searchBy;
        this.searchValue = searchValue;
        this.pageno = pageno;
        this.pageSize = pageSize;
        this.sortBy = sortBy;
        this.sortOrder = sortOrder;
    }

    public String getSearch() {
        return searchBy;
    }

    public int getPageno() {
        return pageno;
    }

    public int getPageSize() {
        return pageSize;
    }

    public String getSortBy() {
        return sortBy;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSearch(String search) {
        this.searchBy = search;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
        return "Search{" +
                "searchBy='" + searchBy + '\'' +
                ", searchValue='" + searchValue + '\'' +
                ", pageno=" + pageno +
                ", pageSize=" + pageSize +
                ", sortBy='" + sortBy + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                '}';
    }
}
