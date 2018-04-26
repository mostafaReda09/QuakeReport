package com.example.android.quakereport;

import java.util.Date;

/**
 * Created by Mostafa on 4/4/2018.
 */

public class Earthquake {
    private double mag;
    private String location;
    private String ofsset_location;
    private  String primary_location;
    private long date;
    public Earthquake(double mag,String location,long date)
    {
        this.mag=mag;
        this.location=location;
        this.date=date;
    }
    public double getMag()
    {
        return mag;
    }
    public String getLocation()
    {
        return location;
    }
    public Long getDate()
    {
        return date;
    }
public String getOfsset_location()
{

        int i=location.indexOf("of");
    if (i==-1) ofsset_location="Near the";
    else ofsset_location= location.substring(0,i+2);
    return ofsset_location;
}

    public String getPrimary_location() {
        int i=location.indexOf("of");
        if (i==-1) primary_location=location;
        else primary_location= location.substring(i+3,location.length());
        return primary_location;
    }
}
