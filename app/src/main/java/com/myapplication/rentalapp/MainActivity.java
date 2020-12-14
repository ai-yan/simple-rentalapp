package com.myapplication.rentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.truck_listview);

        //Define data in arraylist
        ArrayList<TruckData> arrayList = new ArrayList<TruckData>();
        arrayList.add(new TruckData("10 foot truck", "https://image.shutterstock.com/image-photo/aug-10-2019-san-francisco-600w-1576107718.jpg", "19.95"));
        arrayList.add(new TruckData("17 foot truck", "https://image.shutterstock.com/image-photo/new-york-july-6-uhaul-600w-147540425.jpg", "29.95"));
        arrayList.add(new TruckData("26 foot truck", "https://image.shutterstock.com/image-photo/ottawa-ontario-canada-september-3-600w-1808452903.jpg", "39.95"));

        TruckAdapter truckAdapter = new TruckAdapter(this,  arrayList);
        listView.setAdapter(truckAdapter);
    }
}