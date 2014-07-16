package com.phishin.entities;

import com.phishin.PhishinClient;

/**
 * Created by benjamin on 7/15/14.
 */
abstract public class BaseModel {

    private PhishinClient mClient;

    public BaseModel(PhishinClient client) {
        mClient = client;
    }

    public PhishinClient getClient() {
        return mClient;
    }
}
