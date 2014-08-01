package com.phishod.android;

import android.app.Application;

import dagger.ObjectGraph;

/**
 * Override the default application to provide configuration specific to Phish On Demand.
 */
public class PhishODApplication extends Application {

    /**
     * The application's single instance of the object graph.
     */
    private static ObjectGraph sObjectGraph;

    /**
     * Inject an objects dependencies from the applications Object Graph into the
     * provided object
     *
     * @param object the object into which dependencies should be injected
     */
    public static void injectDependencies(Object object) {
        if (object != null) {
            sObjectGraph.inject(object);
        }
    }

    @Override public void onCreate() {
        super.onCreate();
        sObjectGraph = ObjectGraph.create(new PhishODModule());
    }
}
