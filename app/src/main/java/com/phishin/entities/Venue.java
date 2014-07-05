package com.phishin.entities;


import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Rob Munroe on 5/10/14.
 */
public class Venue
{
    @Expose
    private Integer id;

    @Expose
    private String name;

    @Expose
    private String past_names;

    @Expose
    private Double latitude;

    @Expose
    private Double longitude;

    @Expose
    private Integer shows_count;

    @Expose
    private String location;

    @Expose
    private String slug;

    @Expose
    private List<String> show_dates = new ArrayList<String>();

    @Expose
    private List<Integer> show_ids = new ArrayList<Integer>();


    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getPast_names()
    {
        return past_names;
    }

    public void setPast_names( String past_names )
    {
        this.past_names = past_names;
    }

    public Double getLatitude()
    {
        return latitude;
    }

    public void setLatitude( Double latitude )
    {
        this.latitude = latitude;
    }

    public Double getLongitude()
    {
        return longitude;
    }

    public void setLongitude( Double longitude )
    {
        this.longitude = longitude;
    }

    public Integer getShows_count()
    {
        return shows_count;
    }

    public void setShows_count( Integer shows_count )
    {
        this.shows_count = shows_count;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation( String location )
    {
        this.location = location;
    }

    public String getSlug()
    {
        return slug;
    }

    public void setSlug( String slug )
    {
        this.slug = slug;
    }

    public List<String> getShow_dates()
    {
        return show_dates;
    }

    public void setShow_dates( List<String> show_dates )
    {
        this.show_dates = show_dates;
    }

    public List<Integer> getShow_ids()
    {
        return show_ids;
    }

    public void setShow_ids( List<Integer> show_ids )
    {
        this.show_ids = show_ids;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
