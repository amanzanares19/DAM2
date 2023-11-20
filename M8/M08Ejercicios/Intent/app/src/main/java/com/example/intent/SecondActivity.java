package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView text2;
    private ImageView image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        text2 = findViewById(R.id.textView2);
        image2 = findViewById(R.id.imageView2);

        Bundle intent = getIntent().getExtras();
        text2.setText(intent.getString("text"));
        image2.setImageResource(intent.getInt("img"));

    }
}