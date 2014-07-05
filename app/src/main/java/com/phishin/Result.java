package com.phishin;


import com.google.gson.annotations.Expose;

/**
 * The generic wrapper around the request's payload. See http://phish.in/api-docs for more info.
 * Created by Rob Munroe on 5/10/14.
 *
 * @param <Entity> The type of object returned by the request as the 'data' element.
 */
public class Result<Entity> {
    @Expose
    private Boolean success;

    @Expose
    private String message;

    @Expose
    private Integer total_entries;

    @Expose
    private Integer total_pages;

    @Expose
    private Integer page;

    @Expose
    private Entity data;


    /**
     * If true then the last request can be called again with an incremented pageNumber
     *
     * @return true if there are more pages
     */
    public Boolean hasMorePages() {
        return (this.page < this.total_pages);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getTotal_entries() {
        return total_entries;
    }

    public void setTotal_entries(Integer total_entries) {
        this.total_entries = total_entries;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Entity getData() {
        return data;
    }

    public void setData(Entity data) {
        this.data = data;
    }
}
