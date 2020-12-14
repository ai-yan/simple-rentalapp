package com.myapplication.rentalapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TruckAdapter extends BaseAdapter {

    private ArrayList<TruckData> arrayList;
    private LayoutInflater mLayoutinflater;
    Context context;
    private String title_str, cost_str, mile_str;
    SharedPreferences sharedPreferences;

    public TruckAdapter(Context mcontext, ArrayList<TruckData> marrayList) {
        this.context = mcontext;
        arrayList = marrayList;
        mLayoutinflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null) {
            holder = new ViewHolder();
            convertView = mLayoutinflater.inflate(R.layout.truck_details, parent, false);

            //convertView.getLayoutParams().height = 1000;
            holder.img = (ImageView)convertView.findViewById(R.id.truck_image);
            holder.title = (TextView)convertView.findViewById(R.id.truck_title);
            holder.cost = (TextView)convertView.findViewById(R.id.truck_cost);
            holder.mile = (EditText)convertView.findViewById(R.id.mile_number);
            holder.button = (Button)convertView.findViewById(R.id.rental_button);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        //Get the data by position
        TruckData truckData = (TruckData)arrayList.get(position);

        //set the values to imageview, textview etc...
        Picasso.with(context)
                .load(truckData.getImage_link())
                .into(holder.img);
        holder.title.setText(truckData.getTruck_title());
        holder.cost.setText(truckData.getTruck_cost());

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.mile.getText().toString().equals("")){
                    Toast.makeText(context, "Please input mile", Toast.LENGTH_LONG).show();
                }else {
                    title_str = holder.title.getText().toString();
                    cost_str = holder.cost.getText().toString();
                    mile_str = holder.mile.getText().toString();

                    //set the values to sharedpreference
                    sharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("title", title_str);
                    editor.putString("link", truckData.getImage_link());
                    editor.putString("cost", cost_str);
                    editor.putString("mile", mile_str);
                    editor.commit();
                    holder.mile.setText("");

                    //start new activity
                    Intent i = new Intent(context, DetailsActivity.class);
                    context.startActivity(i);
                }
            }
        });
        return convertView;
    }

    private class ViewHolder {
        ImageView img;
        TextView title, cost;
        EditText mile;
        Button button;
    }
}
