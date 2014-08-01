package com.phishin;

import com.phishin.entities.Era;
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
import rx.Observable;
import rx.Subscriber;

/**
 * The interface to the Phish.in api
 */
public class PhishInApi {

    private PhishinClient mClient;

    public PhishInApi(PhishinClient client) {
        mClient = client;
    }

    public Observable<List<Era>> getEras() {
        return Observable.create(new Observable.OnSubscribe<List<Era>>() {
            @Override
            public void call(Subscriber<? super List<Era>> subscriber) {
                try {
                    subscriber.onNext(mClient.getAllEras());
                    subscriber.onCompleted();
                } catch (Exception ex) {
                    subscriber.onError(ex);
                }
            }
        });
    }
}
