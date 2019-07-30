package com.example.sportsbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListEventActivity extends AppCompatActivity {
    RecyclerView list_events;
    ArrayList<Event> events;
    EventAdapter adapter;
    FirebaseDatabase database;
    DatabaseReference myref;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_list_event );
        events=new ArrayList<Event> (  );
        adapter=new EventAdapter ( events );
        database=FirebaseDatabase.getInstance ();
        FirebaseAuth user=FirebaseAuth.getInstance ();
        if(user!=null) {
            myref = database.getReference ( "Posts" );
            myref.addValueEventListener ( new ValueEventListener () {
                @Override
                public void onDataChange (@NonNull DataSnapshot dataSnapshot) {
                    events.clear ();
                    for(DataSnapshot postsnapshot:dataSnapshot.getChildren ()){
                        Event event=postsnapshot.getValue (Event.class);
                        events.add ( event );
                        adapter.notifyDataSetChanged ();
                    }

                }

                @Override
                public void onCancelled (@NonNull DatabaseError databaseError) {

                }
            } );
            list_events=findViewById ( R.id.evet_list );
            list_events.setLayoutManager ( new LinearLayoutManager ( this ) );
            list_events.setHasFixedSize ( true );
            list_events.setAdapter ( adapter );
        }
    }

}
