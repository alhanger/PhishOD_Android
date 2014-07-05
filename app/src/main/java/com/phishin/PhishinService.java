package com.phishin;


import com.phishin.entities.Search;
import com.phishin.entities.Show;
import com.phishin.entities.Song;
import com.phishin.entities.Tour;
import com.phishin.entities.Track;
import com.phishin.entities.Venue;

import java.util.List;
import java.util.Map;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.QueryMap;


public interface PhishinService {
    @GET("/eras/{era}.json")
    Result<List<String>> getEra(@Path("era") Integer id);

    @GET("/years.json")
    Result<List<String>> getAllYears();

    @GET("/years/{year}.json")
    Result<List<Show>> getYear(@Path("year") String year);

    @GET("/songs.json")
    Result<List<Song>> getAllSongs(@QueryMap Map<String, String> requestParams);

    @GET("/songs/{id}.json")
    Result<Song> getSong(@Path("id") Integer id);

    @GET("/tours.json")
    Result<List<Tour>> getAllTours(@QueryMap Map<String, String> requestParams);

    @GET("/tours/{id}.json")
    Result<Tour> getTour(@Path("id") Integer id);

    @GET("/venues.json")
    Result<List<Venue>> getAllVenues(@QueryMap Map<String, String> requestParams);

    @GET("/venues/{id}.json")
    Result<Venue> getVenue(@Path("id") Integer id);

    @GET("/shows.json")
    Result<List<Show>> getAllShows(@QueryMap Map<String, String> requestParams);

    @GET("/shows/{id}.json")
    Result<Show> getShow(@Path("id") Integer id);

    @GET("/random-show.json")
    Result<Show> getRandomShow();

    @GET("/tracks/{id}.json")
    Result<Track> getTrack(@Path("id") Integer id);

    @GET("/search/{term}.json")
    Result<Search> doSearch(@Path("term") String term);
}
