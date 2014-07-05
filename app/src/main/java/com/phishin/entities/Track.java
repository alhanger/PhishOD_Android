package com.phishin.entities;


import com.google.gson.annotations.Expose;
import com.phishin.PhishinClient;
import com.phishin.RequestException;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Rob Munroe on 5/10/14.
 */
public class Track {
    @Expose
    private Integer id;

    private Show show;

    @Expose
    private Integer show_id;

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

    @Expose
    private List<Song> songs = new ArrayList<Song>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Show getShow() {
        if (this.show == null) {
            if (this.show_id == null) update();
            try {
                this.show = PhishinClient.getInstance().getShow(this.show_id);
            } catch (RequestException e) {
                e.printStackTrace();
            }
        }
        return this.show;
    }

    public Integer getShow_id() {
        if (this.show_id == null) update();
        return show_id;
    }

    public void setShow_id(Integer show_id) {
        this.show_id = show_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getSet_name() {
        return set_name;
    }

    public void setSet_name(String set_name) {
        this.set_name = set_name;
    }

    public Integer getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(Integer likes_count) {
        this.likes_count = likes_count;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }

    public List<Integer> getSong_ids() {
        return song_ids;
    }

    public void setSong_ids(List<Integer> song_ids) {
        this.song_ids = song_ids;
    }

    public List<Song> getSongs() {
        if (this.songs == null || this.songs.size() == 0) update();
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return this.title;
    }

    private void update() {
        try {
            Track obj = PhishinClient.getInstance().getTrack(this.id);
            this.show_id = obj.show_id;
            this.songs = obj.songs;
        } catch (RequestException e) {
            e.printStackTrace();
        }
    }
}