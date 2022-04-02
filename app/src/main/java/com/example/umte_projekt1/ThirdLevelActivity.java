package com.example.umte_projekt1;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ThirdLevelActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_level);

        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if(result.getResultCode() == RESULT_OK && result.getData() != null){
                        Bundle bundle = result.getData().getExtras();
                        String s = (String) bundle.get("data");
                        if("http://en.m.wikipedia.org".equals(s)) {
                            Intent intent = new Intent();
                            intent.putExtra("data",3);
                            setResult(RESULT_OK,intent);
                            finish();
                        }else{
                            Toast.makeText(this, "Toto je špatný QR, Zkus to znovu", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void launchQrActivity(View view){
        Intent intent = new Intent(this, QrReaderActivity.class);
        activityResultLauncher.launch(intent);
    }

}