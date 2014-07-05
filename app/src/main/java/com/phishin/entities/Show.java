package com.phishin.entities;


import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Rob Munroe on 5/10/14.
 */
public class Show {
    @Expose
    private Integer id;

    @Expose
    private String date;

    @Expose
    private Integer duration;

    @Expose
    private Boolean incomplete;

    @Expose
    private Boolean missing;

    @Expose
    private Boolean sbd;

    @Expose
    private Boolean remastered;

    @Expose
    private List<Object> tags = new ArrayList<Object>();

    @Expose
    private Integer tour_id;

    @Expose
    private Venue venue;

    @Expose
    private List<Track> tracks = new ArrayList<Track>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Boolean getIncomplete() {
        return incomplete;
    }

    public void setIncomplete(Boolean incomplete) {
        this.incomplete = incomplete;
    }

    public Boolean getMissing() {
        return missing;
    }

    public void setMissing(Boolean missing) {
        this.missing = missing;
    }

    public Boolean getSbd() {
        return sbd;
    }

    public void setSbd(Boolean sbd) {
        this.sbd = sbd;
    }

    public Boolean getRemastered() {
        return remastered;
    }

    public void setRemastered(Boolean remastered) {
        this.remastered = remastered;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public Integer getTour_id() {
        return tour_id;
    }

    public void setTour_id(Integer tour_id) {
        this.tour_id = tour_id;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        String display = this.date.toString();
        if (this.venue != null)
            display += " " + this.venue.getName() + ", " + this.venue.getLocation();
        return display;
    }
}
