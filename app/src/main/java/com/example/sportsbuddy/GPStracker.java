package com.example.sportsbuddy;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GPStracker implements LocationListener {
    Context context;
    public GPStracker(Context c)
    {
        context=c;
    }



    public Location getLocation(){
        if(ContextCompat.checkSelfPermission ( context, Manifest.permission.ACCESS_FINE_LOCATION )!= PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText ( context,"Permission not granted",Toast.LENGTH_LONG ).show ();
            return  null;
        }
    LocationManager ls=(LocationManager) context.getSystemService ( Context.LOCATION_SERVICE );
    boolean ifGPSENABLED=ls.isProviderEnabled ( LocationManager.GPS_PROVIDER );
    if(ifGPSENABLED){
        ls.requestLocationUpdates ( LocationManager.GPS_PROVIDER,6000,10,this );
        Location l=ls.getLastKnownLocation ( LocationManager.GPS_PROVIDER );
        return l;
    }else{
        Toast.makeText ( context,"Please enable GPS",Toast.LENGTH_LONG ).show ();
    }

    return null;
}
    @Override
    public void onLocationChanged (Location location) {
        FirebaseUser user=FirebaseAuth.getInstance ().getCurrentUser ();
        DatabaseReference re=FirebaseDatabase.getInstance ().getReference ("user-location").child ( user.getUid () );
        GeoFire geoFire=new GeoFire ( re );
        geoFire.setLocation("location", new GeoLocation( location.getLatitude (), location.getLongitude ()));


    }

    @Override
    public void onStatusChanged (String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled (String s) {

    }

    @Override
    public void onProviderDisabled (String s) {

    }
}
