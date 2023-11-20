package com.example.prepararexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView serializableText;
    private TextView parcelableText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        serializableText = findViewById(R.id.serializableText);
        parcelableText = findViewById(R.id.parcelableText);

        Intent intent = getIntent();
//        Anime anime = (Anime) intent.getSerializableExtra("anime");
//        serializableText.setText(anime.toString());

        AnimePar anime = intent.getParcelableExtra("animepar");
        parcelableText.setText(anime.toString());


    }
}