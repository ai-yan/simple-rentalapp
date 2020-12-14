package com.myapplication.rentalapp;

public class TruckData {
    private String truck_title, image_link, truck_cost, mile_num;

    public TruckData(String truck_title, String image_link, String truck_cost) {
        this.truck_title = truck_title;
        this.image_link = image_link;
        this.truck_cost = truck_cost;
    }

    public String getTruck_title() {
        return truck_title;
    }

    public void setTruck_title(String truck_title) {
        this.truck_title = truck_title;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public String getTruck_cost() {
        return truck_cost;
    }

    public void setTruck_cost(String truck_cost) {
        this.truck_cost = truck_cost;
    }

    public String getMile_num() {
        return mile_num;
    }

    public void setMile_num(String mile_num) {
        this.mile_num = mile_num;
    }
}
