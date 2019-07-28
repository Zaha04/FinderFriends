package com.example.sportsbuddy;

public class Event {
    String title;

    public Event (String title, int contPeople) {
        this.title = title;
        this.contPeople = contPeople;
    }
    public Event(){

    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public int getContPeople () {
        return contPeople;
    }

    public void setContPeople (int contPeople) {
        this.contPeople = contPeople;
    }

    int contPeople;

}
