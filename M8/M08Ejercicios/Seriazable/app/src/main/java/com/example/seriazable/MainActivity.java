package com.example.seriazable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hooks
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        AnimeSer anime1 = new AnimeSer(1, "Anime1" , "Anime2", "Anime3", 2, "Anime4", "Anime5");
        AnimeSer anime2 = new AnimeSer(2, "Anime1" , "Anime2", "Anime3", 2, "Anime4", "Anime5");
        AnimePar anime3 = new AnimePar(3, "Anime1" , "Anime2", "Anime3", 2, "Anime4", "Anime5");

        ArrayList<AnimeSer> animeSers = new ArrayList<>();

        animeSers.add(anime1);
        animeSers.add(anime2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("button", "Serializable");
                intent.putExtra("anime", anime1);
                intent.putExtra("animes", animeSers);
                startActivity(intent);
            }
        });


        button2.setOnClickListener(v -> {

            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra("button", "Parcelable");
            intent.putExtra("anime2", anime3);
            startActivity(intent);

        });

    }
}