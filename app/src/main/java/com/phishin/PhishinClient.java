package com.phishin;


import android.util.Log;

import com.phishin.entities.Era;

import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;


/**
 * Created by robert on 5/3/14.
 */
public class PhishinClient
{
    private PhishinService service;


    public PhishinClient()
    {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint( "http://phish.in/api/v1" )
                .setLogLevel( RestAdapter.LogLevel.FULL )
                .setLog( new RestAdapter.Log()
                {
                    @Override
                    public void log( String msg )
                    {
                        Log.i( "PHISH_OD", msg );
                    }
                } )
                .build();

        service = restAdapter.create( PhishinService.class );
    }


    public PhishinService getService()
    {
        return service;
    }


    public List<Era> getAllEras()
    {
        List<Era> eras = new ArrayList<Era>();

        Era era1 = new Era();
        era1.setName( "1.0" );
        era1.setYears( service.getEra( 1 ).getData() );
        eras.add( era1 );

        Era era2 = new Era();
        era2.setName( "2.0" );
        era2.setYears( service.getEra( 2 ).getData() );
        eras.add( era2 );

        Era era3 = new Era();
        era3.setName( "3.0" );
        era3.setYears( service.getEra( 3 ).getData() );
        eras.add( era3 );

        return eras;
    }
}
