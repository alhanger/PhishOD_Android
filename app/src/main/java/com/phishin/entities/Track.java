package com.phishin.entities;


import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;


public class Track
{
    @Expose
    private Integer id;

    @Expose
    private String title;

    @Expose
    private Integer position;

    @Expose
    private Integer duration;

    @Expose
    private String set;

    @Expose
    private String set_name;

    @Expose
    private Integer likes_count;

    @Expose
    private String slug;

    @Expose
    private String mp3;

    @Expose
    private List<Integer> song_ids = new ArrayList<Integer>();


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


    public Integer getPosition()
    {
        return position;
    }


    public void setPosition( Integer position )
    {
        this.position = position;
    }


    public Integer getDuration()
    {
        return duration;
    }


    public void setDuration( Integer duration )
    {
        this.duration = duration;
    }


    public String getSet()
    {
        return set;
    }


    public void setSet( String set )
    {
        this.set = set;
    }


    public String getSet_name()
    {
        return set_name;
    }


    public void setSet_name( String set_name )
    {
        this.set_name = set_name;
    }


    public Integer getLikes_count()
    {
        return likes_count;
    }


    public void setLikes_count( Integer likes_count )
    {
        this.likes_count = likes_count;
    }


    public String getSlug()
    {
        return slug;
    }


    public void setSlug( String slug )
    {
        this.slug = slug;
    }


    public String getMp3()
    {
        return mp3;
    }


    public void setMp3( String mp3 )
    {
        this.mp3 = mp3;
    }


    public List<Integer> getSong_ids()
    {
        return song_ids;
    }


    public void setSong_ids( List<Integer> song_ids )
    {
        this.song_ids = song_ids;
    }
}