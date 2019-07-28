package com.example.sportsbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ListEventActivity extends AppCompatActivity {
    RecyclerView list_events;
    ArrayList<Event> events;
    EventAdapter adapter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_list_event );
    }

}
