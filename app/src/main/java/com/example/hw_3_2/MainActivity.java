package com.example.hw_3_2;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textScore;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textScore = findViewById(R.id.text_score);
        getSupportFragmentManager().beginTransaction().add(R.id.container, new FragmentFirst()).commit();
    }
    public void updateTextScore(String newValue) {
        textScore.setText(newValue);
    }
}