package com.phishin.entities;


import com.google.gson.annotations.Expose;

import java.util.List;


public class Search
{
    @Expose
    private Show show;

    @Expose
    private List<Show> other_shows;

    @Expose
    private List<Song> songs;

    @Expose
    private List<Venue> venues;

    @Expose
    private List<Tour> tours;


    public Show getShow()
    {
        return show;
    }


    public void setShow( Show show )
    {
        this.show = show;
    }


    public List<Show> getOther_shows()
    {
        return other_shows;
    }


    public void setOther_shows( List<Show> other_shows )
    {
        this.other_shows = other_shows;
    }


    public List<Song> getSongs()
    {
        return songs;
    }


    public void setSongs( List<Song> songs )
    {
        this.songs = songs;
    }


    public List<Venue> getVenues()
    {
        return venues;
    }


    public void setVenues( List<Venue> venues )
    {
        this.venues = venues;
    }


    public List<Tour> getTours()
    {
        return tours;
    }


    public void setTours( List<Tour> tours )
    {
        this.tours = tours;
    }
}
