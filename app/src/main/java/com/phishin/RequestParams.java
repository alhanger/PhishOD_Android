package com.phishin;

import java.util.HashMap;
import java.util.Map;

/**
 * Used for parameterized / paged requests
 * Created by Rob Munroe on 7/5/14.
 */
public class RequestParams {
    public static final int DEFAULT_PER_PAGE = 20;

    String sortAttribute;
    SortDirection sortDirection;
    Integer pageNumber;
    Integer perPage;


    /**
     * ctor using defaults
     */
    public RequestParams() {
        this.sortAttribute = null;
        this.sortDirection = null;
        this.perPage = DEFAULT_PER_PAGE;
        this.pageNumber = 1;
    }

    /**
     * ctor with just paging
     *
     * @param pageNumber the page number to request
     * @param perPage    the count of results per page
     */
    public RequestParams(Integer pageNumber, Integer perPage) {
        this.pageNumber = pageNumber;
        this.perPage = perPage;
    }

    /**
     * ctor with all params
     *
     * @param sortAttribute the field name, such as "title"
     * @param sortDirection the SortDirection enum value, ASC or DESC
     * @param pageNumber    the page number to request
     * @param perPage       the count of results per page
     */
    public RequestParams(String sortAttribute, SortDirection sortDirection, Integer pageNumber, Integer perPage) {
        this.sortAttribute = sortAttribute;
        this.sortDirection = sortDirection;
        this.pageNumber = pageNumber;
        this.perPage = perPage;
    }

    /**
     * Returns a Retrofit-friendly Map used for @QueryMap annotated requests (i.e. paged requests)
     *
     * @return a Retrofit-friendly Map
     */
    public Map<String, String> getQueryMap() {
        HashMap<String, String> map = new HashMap<String, String>();

        if (this.sortAttribute != null)
            map.put("sort_attr", this.sortAttribute);

        if (this.sortDirection != null)
            map.put("sort_dir", this.sortDirection.toString());

        map.put("page", this.pageNumber.toString());
        map.put("per_page", this.perPage.toString());

        return map;
    }


    public String getSortAttribute() {
        return sortAttribute;
    }

    public void setSortAttribute(String sortAttribute) {
        this.sortAttribute = sortAttribute;
    }

    public SortDirection getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(SortDirection sortDirection) {
        this.sortDirection = sortDirection;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }


    /**
     * Used for sorting requests, ASC or DESC
     */
    public enum SortDirection {
        ASC("asc"),
        DESC("desc");

        private String direction;

        SortDirection(String dirValue) {
            this.direction = dirValue;
        }

        @Override
        public String toString() {
            return this.direction;
        }
    }
}
