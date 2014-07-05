package com.phishin.entities;


import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rob Munroe on 5/10/14.
 */
public class Tour {
    @Expose
    private Integer id;

    @Expose
    private String name;

    @Expose
    private Integer shows_count;

    @Expose
    private String slug;

    @Expose
    private String starts_on;

    @Expose
    private String ends_on;

    @Expose
    private List<Show> shows = new ArrayList<Show>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getShows_count() {
        return shows_count;
    }

    public void setShows_count(Integer shows_count) {
        this.shows_count = shows_count;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getStarts_on() {
        return starts_on;
    }

    public void setStarts_on(String starts_on) {
        this.starts_on = starts_on;
    }

    public String getEnds_on() {
        return ends_on;
    }

    public void setEnds_on(String ends_on) {
        this.ends_on = ends_on;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
