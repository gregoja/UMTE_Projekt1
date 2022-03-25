package com.example.umte_projekt1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;


public class FirstLevelActivity extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocationClient;
    private final int PERMISSION_REQUEST_LOCATION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_level);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }

    public void checkLocation(View view) {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            requestCoordinateUpdate();
            checkDistance();
        }else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_LOCATION);
        }
    }

    @SuppressLint("MissingPermission")
    private void requestCoordinateUpdate() {
        LocationRequest mLocationRequest = LocationRequest.create();
        mLocationRequest.setInterval(60000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationCallback mLocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {}
        };
        fusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, null);
    }

    @SuppressLint("MissingPermission")
    private void checkDistance() {
        fusedLocationClient.getLastLocation().addOnSuccessListener(this, location -> {
            // Got last known location. In some rare situations this can be null.
            if (location != null){
                // Got last known location. In some rare situations this can be null.
                Location areaOfInterest = new Location("");
                Location currentPosition = new Location("");

                // skola
                areaOfInterest.setLatitude(50.203746);
                areaOfInterest.setLongitude(15.829220);

                currentPosition.setLatitude(location.getLatitude());
                currentPosition.setLongitude(location.getLongitude());

                float dist = areaOfInterest.distanceTo(currentPosition);
                // 100km
                if(dist < 100000){
                    Toast.makeText(getApplicationContext(),"Výborně!"+dist,Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Nene, Nejsi dostatečně blízko" + dist,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
