package com.example.sportsbuddy;

public class LocationModel {
    private double lat,lng;
    LocationModel(){}


    public double getLat () {
        return lat;
    }

    public void setLat (double lat) {
        this.lat = lat;
    }

    public double getLng () {
        return lng;
    }

    public void setLng (double lng) {
        this.lng = lng;
    }

    public LocationModel (double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }
}
