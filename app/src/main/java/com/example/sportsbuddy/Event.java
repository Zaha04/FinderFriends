package com.example.sportsbuddy;

import com.google.firebase.database.PropertyName;

public class Event {
    String title;

    public Event (String title, String author, String contPeople) {
        this.title = title;
        this.author = author;
        this.contPeople = contPeople;
    }
    @PropertyName( "author" )
    public String getAuthor () {
        return author;
    }
    @PropertyName( "author" )
    public void setAuthor (String author) {
        this.author = author;
    }

    String author;


    public Event(){

    }
    @PropertyName( "title" )
    public String getTitle () {
        return title;
    }
    @PropertyName( "title" )
    public void setTitle (String title) {
        this.title = title;
    }
    @PropertyName ( "contPeople" )
    public String getContPeople () {
        return contPeople;
    }
    @PropertyName ( "contPeople" )
    public void setContPeople (String contPeople) {
        this.contPeople = contPeople;
    }

 String contPeople;

}
