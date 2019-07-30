package com.example.sportsbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
private Button signin;
private Button login;
private Button details;
private Button logout;
private Button runner;
private Button profile;
private Button message;
private Button userlist;
private Button location,create_event,eventlist;

    private FirebaseAuth auth;
    private FirebaseUser user;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        signin=(Button)findViewById ( R.id.signin );
        login=(Button)findViewById ( R.id.login );
        message=(Button) findViewById ( R.id.message );
        logout=(Button)findViewById ( R.id.logout ) ;
        details=(Button)findViewById ( R.id.user );
        create_event=findViewById ( R.id.create_event );
        eventlist=findViewById ( R.id.listevent );
        eventlist.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                Intent intent=new Intent ( MainActivity.this,ListEventActivity.class );
                startActivity ( intent );

            }
        } );

        userlist=(Button) findViewById ( R.id.userlist );
        location=findViewById ( R.id.location );
        create_event.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                Intent intent=new Intent ( MainActivity.this,CreateEventActivity.class );
                startActivity ( intent );
            }
        } );
        location.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                Intent intent=new Intent ( MainActivity.this,Search.class );
                startActivity ( intent );
            }
        } );
        userlist.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick (View v) {
                Intent intent=new Intent ( MainActivity.this,UsersActivity.class );
                startActivity ( intent );
            }
        } );


        details.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent ( MainActivity.this,UserDetails.class );
                startActivity ( intent );
            }

        } );


        signin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent ( MainActivity.this,RegisterActivity.class );
               startActivity ( intent );
            }

        } );
        login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent ( MainActivity.this,LoginActivity.class );
                startActivity ( intent );

            }

        } );
        logout.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick (View v) {
                Logout();
            }
        } );
        FirebaseUser user=FirebaseAuth.getInstance ().getCurrentUser ();
        if(user!=null){
            login.setVisibility ( View.INVISIBLE );
        }else{
            login.setVisibility ( View.VISIBLE );
        }

    }

    private void Logout () {
        FirebaseAuth.getInstance ().signOut ();
        Intent intent=new Intent ( getApplicationContext (),MainActivity.class );
       intent.addFlags ( Intent.FLAG_ACTIVITY_CLEAR_TOP );
        startActivity ( intent );

    }



}
