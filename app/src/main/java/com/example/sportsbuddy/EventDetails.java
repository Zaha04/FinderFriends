package com.example.sportsbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class EventDetails extends AppCompatActivity {
TextView title,author,nrpeople;
Button join;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_event_details );
        title=findViewById ( R.id.ui );
        author=findViewById ( R.id.author1 );
        nrpeople=findViewById ( R.id.peoplenr );
        String title1=getIntent ().getStringExtra ( "Title" );
        String auth=getIntent ().getStringExtra ( "Author" );
        String number=getIntent ().getStringExtra ( "Number of people" );
        title.setText ( title1 );
        author.setText ( auth );
        nrpeople.setText ( number );
        join.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                FirebaseAuth user=FirebaseAuth.getInstance ();
                if(user!=null){
                    DatabaseReference database= FirebaseDatabase.getInstance ().getReference ()
                }
            }
        } );

    }

}
