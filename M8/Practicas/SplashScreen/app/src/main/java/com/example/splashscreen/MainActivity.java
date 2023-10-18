package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int SPLASH_SCREEN = 2000;

    private ImageView logo;
    private TextView title;
    private TextView subtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //hooks
        logo = findViewById(R.id.logo);
        title = findViewById(R.id.titulo);
        subtitle = findViewById(R.id.subtitulo);

        logo.setTranslationY(-700);
        logo.setAlpha(0f);
        title.setTranslationY(1400);
        subtitle.setTranslationY(1400);

        logo.animate().translationY(200).setDuration(2200).setStartDelay(500)
                .alpha(1.0f).setDuration(2100).setStartDelay(1000).rotation(360);

        title.animate().translationY(300).setDuration(2200).setStartDelay(500)
                .alpha(1.0f).setDuration(2100).setStartDelay(1000).rotation(360);
        subtitle.animate().translationY(300).setDuration(2200).setStartDelay(500)
                .alpha(1.0f).setDuration(2100).setStartDelay(1000).rotation(-360);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, DashboardActivity.class);

                //Create Pair and transition animation between activities
            }
        };

        Handler h = new Handler(Looper.getMainLooper());
        h.postDelayed(r, SPLASH_SCREEN);

    }
}