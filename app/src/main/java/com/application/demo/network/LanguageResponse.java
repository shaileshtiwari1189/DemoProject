package com.application.demo.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Shailesh on 24/11/17.
 */

public class LanguageResponse {

    @SerializedName("page")
    private int page;
    @SerializedName("list")
    private List<Language> results;
    @SerializedName("total_items")
    private int totalItems;
    @SerializedName("total_pages")
    private int totalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Language> getResults() {
        return results;
    }

    public void setResults(List<Language> results) {
        this.results = results;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
