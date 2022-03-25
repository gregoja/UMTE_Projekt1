package com.example.umte_projekt1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ThirdLevelActivity extends AppCompatActivity {

    private final int PERMISSION_REQUEST_CAMERA = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_level);
        requestCamera();
    }

    public void launchQrActivity(View view){

        StartQrActivity();
    }

    private void requestCamera() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            // Práva máme, není potřeba o ně žádat

        } else {
            // Požádáme o práva
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);

        }

    }

    private void StartQrActivity() {
        Intent intent = new Intent(this, QrReaderActivity.class);
        //intent.putExtra("message", editText.getText().toString());
        startActivity(intent);
    }

}