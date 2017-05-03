package com.orainteractive.orachallenge.model;

import com.google.gson.JsonObject;

/**
 * Created by Jorge Vivas on 5/3/17.
 */

public class PaginationModel {

    private static final String KEY_TOTAL_COUNT = "total_count";
    private static final String KEY_PER_PAGE = "per_page";
    private static final String KEY_CURRENT_PAGE = "current_page";
    private static final String KEY_PAGE_COUNT = "page_count";

    private int currentPage;
    private int perPage;
    private int pageCount;
    private int totalCount;

    public PaginationModel(JsonObject json) {
        if (json.has(KEY_CURRENT_PAGE))
            this.currentPage = json.get(KEY_CURRENT_PAGE).getAsInt();
        if (json.has(KEY_TOTAL_COUNT))
            this.totalCount = json.get(KEY_TOTAL_COUNT).getAsInt();
        if (json.has(KEY_PER_PAGE))
            this.perPage = json.get(KEY_PER_PAGE).getAsInt();
        if (json.has(KEY_PAGE_COUNT))
            this.pageCount = json.get(KEY_PAGE_COUNT).getAsInt();
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPerPage() {
        return perPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
