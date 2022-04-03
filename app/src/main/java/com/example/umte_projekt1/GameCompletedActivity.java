package com.example.umte_projekt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class GameCompletedActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_completed);
        sharedPreferences = getSharedPreferences("pref", Context.MODE_PRIVATE);
    }

    public void resetGame(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("levelCompleted", 0);
        editor.apply();

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}