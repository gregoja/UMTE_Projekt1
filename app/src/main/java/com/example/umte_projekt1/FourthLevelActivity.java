package com.example.umte_projekt1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class FourthLevelActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_level);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        TextView textView = findViewById(R.id.textLevel4Sensor);

        SensorEventListener sensorEventListener = new SensorEventListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onSensorChanged(SensorEvent event) {
                double magneticFieldStrength = Math.sqrt((event.values[0]*event.values[0])+(event.values[1]*event.values[1])+(event.values[2]*event.values[2]));
                textView.setText(String.format("%.2f",magneticFieldStrength));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        sensorManager.registerListener(sensorEventListener, sensor,SensorManager.SENSOR_DELAY_UI);
    }
}