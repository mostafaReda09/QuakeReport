package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by Mostafa on 4/8/2018.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    private  String url;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        this.url=url;
    }
    @Override
    protected void onStartLoading() {
        forceLoad();
    }



    @Override
    public List<Earthquake> loadInBackground() {


        if(this.url==null) {
            return null;
        }
        List<Earthquake> earthquake = QueryUtils.fetchEarthquakeData(this.url);
        return earthquake;
    }

}

