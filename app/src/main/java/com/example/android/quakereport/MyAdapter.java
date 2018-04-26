package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by Mostafa on 4/4/2018.
 */

public class MyAdapter extends ArrayAdapter <Earthquake>{

    public MyAdapter(@NonNull Context context, @NonNull ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }


    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view=convertView;
        if (view==null)
        {
            LayoutInflater inflater=(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.list_item,parent,false);
        }
        Earthquake earthquake=getItem(position);
        TextView mag= (TextView) view.findViewById(R.id.mag);
        TextView primary_location= (TextView) view.findViewById(R.id.primary_location);
        TextView ofsset_location= (TextView) view.findViewById(R.id.location_offset);
        TextView date_format= (TextView) view.findViewById(R.id.date);
        TextView time_format= (TextView) view.findViewById(R.id.time);
        double magnitude=earthquake.getMag();
        mag.setText(new DecimalFormat().format(magnitude));
        primary_location.setText(earthquake.getPrimary_location());
        ofsset_location.setText(earthquake.getOfsset_location());
        Date date=new Date(earthquake.getDate());
        String stringDate = DateFormat.getDateInstance().format(date);
        date_format.setText(stringDate);
        String stringTime = DateFormat.getTimeInstance(DateFormat.SHORT).format(date);
        time_format.setText(stringTime);

        GradientDrawable magnitudeCircle = (GradientDrawable) mag.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(earthquake.getMag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        return view;
    }
}
