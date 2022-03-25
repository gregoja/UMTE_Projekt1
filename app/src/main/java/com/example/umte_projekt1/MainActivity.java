package com.example.umte_projekt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchFirstLevel(View view){
        Intent intent = new Intent(this, FirstLevelActivity.class);
        //intent.putExtra("message", editText.getText().toString());
        startActivity(intent);
    }

    public void launchSecondLevel(View view){
        Intent intent = new Intent(this, SecondLevelActivity.class);
        //intent.putExtra("message", editText.getText().toString());
        startActivity(intent);
    }

    public void launchThirdLevel(View view){
        Intent intent = new Intent(this, ThirdLevelActivity.class);
        //intent.putExtra("message", editText.getText().toString());
        startActivity(intent);
    }

    public void launchFourthLevel(View view){
        Intent intent = new Intent(this,FourthLevelActivity.class);
        //intent.putExtra("message", editText.getText().toString());
        startActivity(intent);
    }
}