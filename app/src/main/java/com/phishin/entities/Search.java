package com.phishin.entities;


import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by Rob Munroe on 5/10/14.
 */
public class Search {
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


    public Boolean matchesShow() {
        return this.show != null;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Boolean hasOther_shows() {
        return (this.other_shows != null || this.other_shows.size() > 0);
    }

    public List<Show> getOther_shows() {
        return other_shows;
    }

    public void setOther_shows(List<Show> other_shows) {
        this.other_shows = other_shows;
    }

    public Boolean hasSongs() {
        return (this.songs != null || this.songs.size() > 0);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public Boolean hasVenues() {
        return (this.venues != null || this.venues.size() > 0);
    }

    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }

    public Boolean hasTours() {
        return (this.tours != null || this.tours.size() > 0);
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }
}
