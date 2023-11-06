package com.example.seriazable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //hooks
        text = findViewById(R.id.textView);

        Intent intent = this.getIntent();


        if (intent.getStringExtra("button").equals("Serializable")) {

            AnimeSer anime = (AnimeSer) intent.getSerializableExtra("anime");
            List<AnimeSer> animes = (List<AnimeSer>) intent.getSerializableExtra("animes");

            text.setText(anime.toString());


        } else  {
            AnimePar anime = (AnimePar) intent.getParcelableExtra("anime2");
            text.setText(anime.toString());
        }

    }
}