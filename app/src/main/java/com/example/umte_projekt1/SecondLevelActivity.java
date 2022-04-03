package com.example.umte_projekt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class SecondLevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_level);
    }

    public void checkRiddleAnswer(View view) {
        EditText editTxtRiddleAnswer = findViewById(R.id.editTxtRiddleAnswer);
        String riddleAnswer = editTxtRiddleAnswer.getText().toString();
        if ("drak".equals(riddleAnswer.toLowerCase(Locale.ROOT))) {
            Intent intent = new Intent();
            intent.putExtra("data", 2);
            setResult(RESULT_OK, intent);
            finish();
        } else {
            Toast.makeText(this, "Špatná odpověď", Toast.LENGTH_SHORT).show();
        }
    }
}