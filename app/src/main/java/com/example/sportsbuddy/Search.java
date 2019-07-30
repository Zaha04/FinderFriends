package com.example.sportsbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.app.PendingIntent.getActivity;

public class Search extends AppCompatActivity {
    Button start;

    private static final int REQUEST_CODE = 1000;




    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_search );
        ActivityCompat.requestPermissions ( Search.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},123 );
        start = findViewById ( R.id.search );



start.setOnClickListener ( new View.OnClickListener () {
    @Override
    public void onClick (View view) {

    FirebaseUser user=FirebaseAuth.getInstance ().getCurrentUser ();
    DatabaseReference re=FirebaseDatabase.getInstance ().getReference ("user-location").child ( user.getUid () );



        GPStracker g=new GPStracker ( getApplicationContext () );
        Location l=g.getLocation ();
        if(l!=null){
            double lat=l.getLatitude ();
            double lon=l.getLongitude ();
        }



}

} );

    }


}
