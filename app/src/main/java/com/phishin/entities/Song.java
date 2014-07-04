package com.phishin.entities;


import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;


public class Song
{
    @Expose
    private Integer id;

    @Expose
    private String title;

    @Expose
    private Object alias_for;

    @Expose
    private Integer tracks_count;

    @Expose
    private String slug;

    @Expose
    private List<Track> tracks = new ArrayList<Track>();


    public Integer getId()
    {
        return id;
    }


    public void setId( Integer id )
    {
        this.id = id;
    }


    public String getTitle()
    {
        return title;
    }


    public void setTitle( String title )
    {
        this.title = title;
    }


    public Object getAlias_for()
    {
        return alias_for;
    }


    public void setAlias_for( Object alias_for )
    {
        this.alias_for = alias_for;
    }


    public Integer getTracks_count()
    {
        return tracks_count;
    }


    public void setTracks_count( Integer tracks_count )
    {
        this.tracks_count = tracks_count;
    }


    public String getSlug()
    {
        return slug;
    }


    public void setSlug( String slug )
    {
        this.slug = slug;
    }


    public List<Track> getTracks()
    {
        return tracks;
    }


    public void setTracks( List<Track> tracks )
    {
        this.tracks = tracks;
    }
}
