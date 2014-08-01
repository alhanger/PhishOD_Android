package com.phishod.android;

import com.phishin.PhishInApi;
import com.phishin.PhishinClient;
import com.phishod.android.ui.PhishOnDemandActivity;
import com.phishod.android.ui.VenuesFragment;
import com.phishod.android.ui.YearsFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * The PhishODModule provides the necessary dependencies for the application
 * that will be injected by Dagger at runtime.
 */

@Module (
        injects = {PhishOnDemandActivity.class, YearsFragment.class, VenuesFragment.class}
)
public class PhishODModule {

    @Provides @Singleton PhishInApi providePhishInApi(PhishinClient phishinClient) {
        return new PhishInApi(phishinClient);
    }

    @Provides @Singleton PhishinClient providePhishInClient() {
        return new PhishinClient();
    }
}
