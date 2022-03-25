package com.example.umte_projekt1;

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
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;


public class FirstLevelActivity extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocationClient;
    private final int PERMISSION_REQUEST_LOCATION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_level);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }

    public void requestCoordinates(View view){
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getCoordinates();
        } else {
            // Požádáme o práva
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_LOCATION);
        }

    }

    @SuppressLint("MissingPermission")
    private void getCoordinates() {
        fusedLocationClient.getLastLocation().addOnSuccessListener(this, location -> {
            if (location != null) Toast.makeText(getApplicationContext(),"lat: " + location.getLatitude() + ", Lon: " + location.getLongitude(),Toast.LENGTH_SHORT).show();
            else Toast.makeText(getApplicationContext(),"Poloha nezjištěna. Chyba! Chyba!",Toast.LENGTH_SHORT).show();
        });
    }

}