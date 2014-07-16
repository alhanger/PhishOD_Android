package com.phishin;


import android.util.Log;

import com.phishin.entities.Era;
import com.phishin.entities.Search;
import com.phishin.entities.Show;
import com.phishin.entities.Song;
import com.phishin.entities.Tour;
import com.phishin.entities.Track;
import com.phishin.entities.Venue;

import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;


/**
 * This is the main Client class for the Phish.in public API.
 * Created by Rob Munroe on 5/3/14.
 */
public class PhishinClient {

    private PhishinService service;


    /**
     * Default constructor. Instantiates the underlying Retrofit service.
     */
    public PhishinClient() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://phish.in/api/v1")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new RestAdapter.Log() {
                    @Override
                    public void log(String msg) {
                        Log.i("PHISH_OD", msg);
                    }
                })
                .build();

        service = restAdapter.create(PhishinService.class);
    }


    /**
     * Gets the given Era by integer number, eg. 1 returns the "1.0" Era
     *
     * @param id Integer era number, eg. 1, 2, or 3
     * @return the Era, eg. 1 -> "1.0" Era
     * @throws RequestException
     */
    public Era getEra(Integer id) throws RequestException {
        Result<List<String>> result = this.service.getEra(id);

        if (result.getSuccess()) {
            Era era = new Era(this);
            era.setName(id.toString() + ".0");
            era.setYears(result.getData());
            return era;
        } else {
            throw new RequestException("Request failed: " + result.getMessage(), "getEra( " + id.toString() + ")");
        }
    }

    /**
     * Returns all 3 Eras
     *
     * @return All 3 Eras
     * @throws RequestException
     */
    public List<Era> getAllEras() throws RequestException {
        List<Era> eras = new ArrayList<Era>();
        eras.add(this.getEra(1));
        eras.add(this.getEra(2));
        eras.add(this.getEra(3));
        return eras;
    }

    /**
     * Returns a List of String with all year names
     *
     * @return List of String of year names
     * @throws RequestException
     */
    public List<String> getAllYears() throws RequestException {
        Result<List<String>> result = this.service.getAllYears();

        if (result.getSuccess()) {
            return result.getData();
        } else {
            throw new RequestException("Request failed: " + result.getMessage(), "getAllYears()");
        }
    }

    /**
     * Returns the List of Shows for a given String year name.
     *
     * @param year The String year name, e.g. "1994"
     * @return List of all Shows for the given year
     * @throws RequestException
     */
    public List<Show> getYear(String year) throws RequestException {
        Result<List<Show>> result = this.service.getYear(year);

        if (result.getSuccess()) {
            return result.getData();
        } else {
            throw new RequestException("Request failed: " + result.getMessage(), "getYear(" + year + ")");
        }
    }

    /**
     * Returns the Result of a page from the List of All Songs. Use the Result to determine what the next page should be, and if there are additional pages to fetch.
     *
     * @param pageNumber the page number to request
     * @param perPage    the count of results per page
     * @return List of Song
     * @throws RequestException
     */
    public Result<List<Song>> getSongs(Integer pageNumber, Integer perPage) throws RequestException {
        RequestParams requestParams = new RequestParams("title", RequestParams.SortDirection.ASC, pageNumber, perPage);
        return this.getSongs(requestParams);
    }

    /**
     * Returns the Result of a page from the List of All Songs. Use the Result to determine what the next page should be, and if there are additional pages to fetch.
     *
     * @param requestParams a RequestParams instance
     * @return List of Song
     * @throws RequestException
     */
    public Result<List<Song>> getSongs(RequestParams requestParams) throws RequestException {
        Result<List<Song>> result = this.service.getAllSongs(requestParams.getQueryMap());

        if (result.getSuccess()) {
            return result;
        } else {
            throw new RequestException("Request failed: " + result.getMessage(), "getSongs()");
        }
    }

    /**
     * Fetches a single Song by id.
     *
     * @param id the Song's id
     * @return the Song instance
     * @throws RequestException
     */
    public Song getSong(Integer id) throws RequestException {
        Result<Song> result = this.service.getSong(id);

        if (result.getSuccess()) {
            return result.getData();
        } else {
            throw new RequestException("Request failed: " + result.getMessage(), "getSong(" + id + ")");
        }
    }

    /**
     * Returns the Result of a page from the List of All Tours. Use the Result to determine what the next page should be, and if there are additional pages to fetch.
     *
     * @param pageNumber the page number to request
     * @param perPage    the count of results per page
     * @return List of Tours
     * @throws RequestException
     */
    public Result<List<Tour>> getTours(Integer pageNumber, Integer perPage) throws RequestException {
        RequestParams requestParams = new RequestParams("starts_on", RequestParams.SortDirection.ASC, pageNumber, perPage);
        return this.getTours(requestParams);
    }

    /**
     * Returns the Result of a page from the List of All Tours. Use the Result to determine what the next page should be, and if there are additional pages to fetch.
     *
     * @param requestParams a RequestParams instance
     * @return List of Tours
     * @throws RequestException
     */
    public Result<List<Tour>> getTours(RequestParams requestParams) throws RequestException {
        Result<List<Tour>> result = this.service.getAllTours(requestParams.getQueryMap());

        if (result.getSuccess()) {
            return result;
        } else {
            throw new RequestException("Request failed: " + result.getMessage(), "getTours()");
        }
    }

    /**
     * The complete List of All Tours.
     *
     * @return List of All Tours
     * @throws RequestException
     */
    public List<Tour> getAllTours() throws RequestException {
        return this.getTours(1, 9999).getData();
    }

    /**
     * Fetches a single Tour by id.
     *
     * @param id the Tour's id
     * @return the Tour instance
     * @throws RequestException
     */
    public Tour getTour(Integer id) throws RequestException {
        Result<Tour> result = this.service.getTour(id);

        if (result.getSuccess()) {
            return result.getData();
        } else {
            throw new RequestException("Request failed: " + result.getMessage(), "getTour(" + id + ")");
        }
    }

    /**
     * Returns a List of Venues sorted by the number of times played there, descendingly.
     *
     * @param count the length of the list, eg. 5 for the top 5 most-played Venues
     * @return List of Venues
     * @throws RequestException
     */
    public List<Venue> topVenues(Integer count) throws RequestException {
        RequestParams requestParams = new RequestParams("shows_count", RequestParams.SortDirection.DESC, 1, count);
        return this.getVenues(requestParams).getData();
    }

    /**
     * Returns the Result of a page from the List of All Venues. Use the Result to determine what the next page should be, and if there are additional pages to fetch.
     *
     * @param pageNumber the page number to request
     * @param perPage    the count of results per page
     * @return List of Venues
     * @throws RequestException
     */
    public Result<List<Venue>> getVenues(Integer pageNumber, Integer perPage) throws RequestException {
        RequestParams requestParams = new RequestParams(pageNumber, perPage);
        return this.getVenues(requestParams);
    }

    /**
     * Returns the Result of a page from the List of All Venues. Use the Result to determine what the next page should be, and if there are additional pages to fetch.
     *
     * @param requestParams a RequestParams instance
     * @return List of Venues
     * @throws RequestException
     */
    public Result<List<Venue>> getVenues(RequestParams requestParams) throws RequestException {
        Result<List<Venue>> result = this.service.getAllVenues(requestParams.getQueryMap());

        if (result.getSuccess()) {
            return result;
        } else {
            throw new RequestException("Request failed: " + result.getMessage(), "getVenues()");
        }
    }

    /**
     * Fetches a single Venue by id.
     *
     * @param id the Venue's id
     * @return the Venue instance
     * @throws RequestException
     */
    public Venue getVenue(Integer id) throws RequestException {
        Result<Venue> result = this.service.getVenue(id);

        if (result.getSuccess()) {
            return result.getData();
        } else {
            throw new RequestException("Request failed: " + result.getMessage(), "getVenue(" + id + ")");
        }
    }

    /**
     * Returns the Result of a page from the List of All Shows. Use the Result to determine what the next page should be, and if there are additional pages to fetch.
     *
     * @param pageNumber the page number to request
     * @param perPage    the count of results per page
     * @return List of Shows
     * @throws RequestException
     */
    public Result<List<Show>> getShows(Integer pageNumber, Integer perPage) throws RequestException {
        RequestParams requestParams = new RequestParams("date", RequestParams.SortDirection.ASC, pageNumber, perPage);
        return this.getShows(requestParams);
    }

    /**
     * Returns the Result of a page from the List of All Shows. Use the Result to determine what the next page should be, and if there are additional pages to fetch.
     *
     * @param requestParams a RequestParams instance
     * @return List of Shows
     * @throws RequestException
     */
    public Result<List<Show>> getShows(RequestParams requestParams) throws RequestException {
        Result<List<Show>> result = this.service.getAllShows(requestParams.getQueryMap());

        if (result.getSuccess()) {
            return result;
        } else {
            throw new RequestException("Request failed: " + result.getMessage(), "getShows()");
        }
    }

    /**
     * Fetches a single Show by id.
     *
     * @param id the Show's id
     * @return the Show instance
     * @throws RequestException
     */
    public Show getShow(Integer id) throws RequestException {
        Result<Show> result = this.service.getShow(id);

        if (result.getSuccess()) {
            return result.getData();
        } else {
            throw new RequestException("Request failed: " + result.getMessage(), "getShow(" + id + ")");
        }
    }

    /**
     * Fetches a random Show
     *
     * @return the Show instance
     * @throws RequestException
     */
    public Show getRandomShow() throws RequestException {
        Result<Show> result = this.service.getRandomShow();

        if (result.getSuccess()) {
            return result.getData();
        } else {
            throw new RequestException("Request failed: " + result.getMessage(), "getRandomShow()");
        }
    }

    /**
     * Fetches a single Track by id
     *
     * @param id the Track's id
     * @return the Track instance
     * @throws RequestException
     */
    public Track getTrack(Integer id) throws RequestException {
        Result<Track> result = this.service.getTrack(id);

        if (result.getSuccess()) {
            return result.getData();
        } else {
            throw new RequestException("Request failed: " + result.getMessage(), "getTrack(" + id + ")");
        }
    }

    /**
     * Performs a search using the given term. See the Search class for more info on doSearch results.
     *
     * @param term Any String search term
     * @return A Search instance containing the search results
     * @throws RequestException
     */
    public Search doSearch(String term) throws RequestException {
        Result<Search> result = this.service.doSearch(term);

        if (result.getSuccess()) {
            return result.getData();
        } else {
            throw new RequestException("Request failed: " + result.getMessage(), "doSearch(" + term + ")");
        }
    }
}
