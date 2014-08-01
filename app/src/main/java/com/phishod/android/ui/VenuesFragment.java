package com.phishod.android.ui;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

import com.phishin.PhishInApi;
import com.phishod.android.PhishODApplication;

import javax.inject.Inject;

/**
 * Fragment to display a list of venues in which Phish has played
 */
public class VenuesFragment extends ListFragment {

    @Inject PhishInApi mApi;

    public static VenuesFragment newInstance() {
        return new VenuesFragment();
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PhishODApplication.injectDependencies(this);
    }

    @Override public void onResume() {
        super.onResume();

    }
}
