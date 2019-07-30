package com.example.sportsbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class CreateEventActivity extends AppCompatActivity {
    Button post;
    EditText title,numberpeople;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_create_event );
        title=findViewById ( R.id.title );
        numberpeople=findViewById ( R.id.number_people );
        post=findViewById ( R.id.post );
        post.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                String titleValue=title.getText ().toString ().trim ();
                String number=numberpeople.getText ().toString ().trim ();

                FirebaseUser user= FirebaseAuth.getInstance ().getCurrentUser ();
                if(user!=null){
FirebaseDatabase database=FirebaseDatabase.getInstance ();
FirebaseAuth firebaseAuth=FirebaseAuth.getInstance ();



                    DatabaseReference reference=FirebaseDatabase.getInstance ().getReference ("Posts");


                     String id=reference.push ().getKey ();
                     Event eventinfo=new Event ( titleValue,user.getUid (),number );
                     reference.child ( id ).setValue ( eventinfo );














                }
            }
        } );
    }
}
