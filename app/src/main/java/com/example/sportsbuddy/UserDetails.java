package com.example.sportsbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.location.Location;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class UserDetails extends AppCompatActivity {
    private FirebaseAuth auth;
  private DatabaseReference reference;
  private FirebaseDatabase database;
  private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseUser user;
    private EditText firstnamee;
    private EditText secondNamee;
    private Button saveInfo;




    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_user_details );
        firstnamee=(EditText)findViewById ( R.id.firstname );
        secondNamee=(EditText)findViewById ( R.id.secondname );
        saveInfo=(Button)findViewById ( R.id.data );

        saveInfo.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick (View v) {
                FirebaseUser user=FirebaseAuth.getInstance ().getCurrentUser ();
                if(user!=null){
                    DatabaseReference reference=FirebaseDatabase.getInstance ().getReference ("users").child ( user.getUid () );

                   reference.child ( "FIRST NAME" ).setValue ( firstnamee.getText ().toString ().trim () );
                   reference.child ( "SECOND NAME" ).setValue ( secondNamee.getText ().toString ().trim () );
                   reference.child ( "E-MAIL" ).setValue ( user.getEmail ().toString ().trim () );
                   reference.child ( "userid" ).setValue ( user.getUid () );


            }
        }







    });

}}
