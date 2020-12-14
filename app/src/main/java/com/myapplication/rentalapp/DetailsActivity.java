package com.myapplication.rentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class DetailsActivity extends AppCompatActivity {

    private ImageView details_img;
    private TextView details_title, details_cost;
    SharedPreferences details_sharedpreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        details_img = (ImageView)findViewById(R.id.details_image);
        details_title = (TextView)findViewById(R.id.details_title);
        details_cost = (TextView)findViewById(R.id.details_cost);

        details_sharedpreference = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor prefesEditor = details_sharedpreference.edit();
        String title = details_sharedpreference.getString("title", "");
        String link = details_sharedpreference.getString("link", "");
        String cost_string = details_sharedpreference.getString("cost", "");
        String mile_string = details_sharedpreference.getString("mile", "");

        //Calculate full cost of the rental for one day with the cost mileage included
        float cost = Float.parseFloat(cost_string);
        float mile = Float.parseFloat(mile_string);

        float full_cost = (float) (cost + mile * 0.99);

        //Set views
        Picasso.with(this)
                .load(link)
                .into(details_img);

        details_title.setText(title);
        DecimalFormat currency = new DecimalFormat("###,###.##$");
        details_cost.setText("Total Cost with mileage Per Day:  " + currency.format(full_cost));
    }
}