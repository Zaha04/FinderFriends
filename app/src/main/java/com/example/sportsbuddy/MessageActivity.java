package com.example.sportsbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MessageActivity extends AppCompatActivity {
    TextView username;
    FirebaseUser fuser;
    DatabaseReference reference;
    Intent intent;
    ImageButton btn_send;
    EditText text_send;
    MessageAdapter messageAdapter;
    List<Chat> mchat;
    RecyclerView recyclerView;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_message );
        btn_send=findViewById ( R.id.btn_send );
        text_send=findViewById ( R.id.editText );
        recyclerView=findViewById ( R.id.recycler_view1 );
        recyclerView.setHasFixedSize ( true );
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager ( getApplicationContext () );

        recyclerView.setLayoutManager ( linearLayoutManager );







            username=findViewById ( R.id.username6 );


            intent=getIntent ();

           final String userId=intent.getStringExtra ( "userid" );




        fuser= FirebaseAuth.getInstance ().getCurrentUser ();
        reference= FirebaseDatabase.getInstance ().getReference ("users");
        reference.addValueEventListener ( new ValueEventListener () {
            @Override
            public void onDataChange (@NonNull DataSnapshot dataSnapshot) {



                for(DataSnapshot snapshot:dataSnapshot.getChildren ()){
                    User user=snapshot.getValue (User.class);


                    assert user!=null;
                    assert fuser!=null;
                    if(!fuser.getUid ().equals ( user.getFirstName () )){
                        username.setText ( user.getFirstName () );



                    }

                }

readMessages ( fuser.getUid (),userId );
            }

            @Override
            public void onCancelled (@NonNull DatabaseError databaseError) {

            }
        } );


        btn_send.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                String msg=text_send.getText ().toString ();
                if(!msg.equals ( "" )){
                    sendMessage ( fuser.getUid (),userId,msg );
                } else{
                    Toast.makeText ( MessageActivity.this,"You can't send empty",Toast.LENGTH_SHORT ).show ();
                }
                text_send.setText ( "" );
            }

        } );
        }
private void sendMessage(String sender, String receiver, String message)
{
    DatabaseReference reference=FirebaseDatabase.getInstance ().getReference ();
    HashMap<String,Object> hashMap=new HashMap<> (  );
    hashMap.put ( "sender",sender );
    hashMap.put ( "receiver",receiver );
    hashMap.put ( "message",message );
    reference.child ( "Chats" ).push ().setValue ( hashMap );

}
private void readMessages(final String myid, final String userId)
{
    mchat=new ArrayList<> (  );
    reference=FirebaseDatabase.getInstance ().getReference ("Chats");
    reference.addValueEventListener ( new ValueEventListener () {
        @Override
        public void onDataChange (@NonNull DataSnapshot dataSnapshot) {
            mchat.clear ();
            for(DataSnapshot snapshot:dataSnapshot.getChildren ()){
                Chat chat=snapshot.getValue (Chat.class);


                if(chat.getReceiver ().equals ( myid )&& chat.getSender ().equals ( userId) || chat.getReceiver ().equals ( userId )&& chat.getSender ().equals ( myid )) {
                    mchat.add ( chat );
                }
                messageAdapter=new MessageAdapter ( MessageActivity.this,mchat );
                recyclerView.setAdapter ( messageAdapter );
            }
        }

        @Override
        public void onCancelled (@NonNull DatabaseError databaseError) {

        }
    } );
}
    }

