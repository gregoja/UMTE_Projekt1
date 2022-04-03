package com.example.umte_projekt1;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> activityResultLauncher;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("pref", Context.MODE_PRIVATE);
        updateLevelImagesAndLinks();

        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Bundle bundle = result.getData().getExtras();
                        int levelCompleted = (int) bundle.get("data");

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("levelCompleted", levelCompleted);
                        editor.apply();

                        updateLevelImagesAndLinks();
                    }
                });
    }

    private void updateLevelImagesAndLinks() {
        int levelCompleted = sharedPreferences.getInt("levelCompleted", 0);
        for (int i = 1; i <= levelCompleted; i++) {
            switch (i) {
                case 1: {
                    ImageView imgPreviewLevel1 = findViewById(R.id.imgPreviewLevel1);
                    imgPreviewLevel1.setOnClickListener(null);
                    imgPreviewLevel1.setImageResource(R.drawable.done1);

                    ImageView imgPreviewLevel2 = findViewById(R.id.imgPreviewLevel2);
                    imgPreviewLevel2.setImageResource(R.drawable.level2);
                    imgPreviewLevel2.setOnClickListener(this::launchLevel2);
                    break;
                }
                case 2: {
                    ImageView imgPreviewLevel2 = findViewById(R.id.imgPreviewLevel2);
                    imgPreviewLevel2.setOnClickListener(null);
                    imgPreviewLevel2.setImageResource(R.drawable.done2);

                    ImageView imgPreviewLevel3 = findViewById(R.id.imgPreviewLevel3);
                    imgPreviewLevel3.setImageResource(R.drawable.level3);
                    imgPreviewLevel3.setOnClickListener(this::launchLevel3);
                    break;
                }
                case 3: {
                    ImageView imgPreviewLevel3 = findViewById(R.id.imgPreviewLevel3);
                    imgPreviewLevel3.setOnClickListener(null);
                    imgPreviewLevel3.setImageResource(R.drawable.done3);

                    ImageView imgPreviewLevel4 = findViewById(R.id.imgPreviewLevel4);
                    imgPreviewLevel4.setImageResource(R.drawable.level4);
                    imgPreviewLevel4.setOnClickListener(this::launchLevel4);
                    break;
                }
                case 4: {
                    Intent intent = new Intent(this, GameCompletedActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            }
        }
    }

    public void launchLevel1(View view) {
        Intent intent = new Intent(this, FirstLevelActivity.class);
        activityResultLauncher.launch(intent);
    }

    public void launchLevel2(View view) {
        Intent intent = new Intent(this, SecondLevelActivity.class);
        activityResultLauncher.launch(intent);
    }

    public void launchLevel3(View view) {
        Intent intent = new Intent(this, ThirdLevelActivity.class);
        activityResultLauncher.launch(intent);
    }

    public void launchLevel4(View view) {
        Intent intent = new Intent(this, FourthLevelActivity.class);
        activityResultLauncher.launch(intent);
    }
}