package com.phishin.test;

import android.os.AsyncTask;

import com.phishin.PhishinClient;
import com.phishin.RequestException;
import com.phishin.RequestParams;
import com.phishin.Result;
import com.phishin.entities.Era;
import com.phishin.entities.Search;
import com.phishin.entities.Show;
import com.phishin.entities.Song;
import com.phishin.entities.Tour;
import com.phishin.entities.Track;
import com.phishin.entities.Venue;

import java.util.List;

/**
 * Created by Rob Munroe on 7/5/14.
 */
public class PhishinClientTester extends AsyncTask<Void, Void, String> {
    @Override
    protected String doInBackground(Void... params) {

        PhishinClient client = PhishinClient.getInstance();

        try {
            RequestParams requestParams = new RequestParams(1, 5);

            Era era1 = client.getEra(1);

            List<Era> allEras = client.getAllEras();

            List<String> allYears = client.getAllYears();

            List<Show> year = client.getYear("1994");

            // Some methods will return the Result<> instance because they are paged
            Integer pageNumber = 10;
            Result<List<Song>> allSongsPaged = client.getSongs(pageNumber, RequestParams.DEFAULT_PER_PAGE); // 10th page, 20 per page
            if (allSongsPaged.hasMorePages()) {
                System.out.println("There are more pages available");
                allSongsPaged = client.getSongs(++pageNumber, RequestParams.DEFAULT_PER_PAGE); // 11th page, 20 per page
            }
            Result<List<Song>> allSongsParams = client.getSongs(requestParams);

            Song songYem = client.getSong(879); // You Enjoy Myself - most played - takes a while
            Song song555 = client.getSong(918); // 555

            List<Tour> allTours = client.getAllTours();
            Result<List<Tour>> allToursPaged = client.getTours(2, 10); // 2nd page; 10 per page
            Tour tour = client.getTour(23); // 1994 Summer Tour

            Result<List<Venue>> allVenuesPaged = client.getVenues(5, 10); // 5th page; 10 per page
            Venue mann = client.getVenue(411);
            List<Venue> top5Venues = client.topVenues(5);

            Result<List<Show>> allShowsPaged = client.getShows(10, 20); // 10th page, 20 per page
            Result<List<Show>> allShowsParams = client.getShows(requestParams);

            Show robsFirstShow = client.getShow(201); // Rob's first show
            Show randomShow = client.getRandomShow();

            Track track555 = client.getTrack(28765);

            // Search Examples:
            Search showSearch = client.doSearch("1997-12-30");
            if (showSearch.matchesShow()) {
                System.out.println("Direct Show Matched: " + showSearch.getShow().toString());
                System.out.println("First Other Show Listed: " + showSearch.getOther_shows().get(0).toString());
            }

            Search songSearch = client.doSearch("Jennifer Dances");
            if (songSearch.hasSongs()) {
                System.out.println("First Song Found: " + songSearch.getSongs().get(0).getTitle());
            }

            Search mannSearch = client.doSearch("Mann");
            if (mannSearch.hasVenues()) {
                System.out.println("First Venue Found: " + mannSearch.getVenues().get(0).getName());
            }

            Search tourSearch = client.doSearch("1994");
            if (tourSearch.hasTours()) {
                System.out.println("First Tour Found: " + tourSearch.getTours().get(0).getName());
            }

            String catchMe = "foo";

        } catch (RequestException e) {
            e.printStackTrace();
        }

        return null;
    }
}
