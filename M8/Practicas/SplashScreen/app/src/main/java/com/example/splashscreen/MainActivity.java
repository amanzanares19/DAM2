package com.example.splashscreen;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final int SPLASH_SCREEN = 4000;

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

        Runnable r = () -> {
            Intent intent = new Intent(MainActivity.this, DashboardActivity.class);

            //Create Pair and transition animation between activities
            Pair[] pairs = new Pair[2];
            pairs[0] = new Pair<View, String>(logo, logo.getTransitionName());
            pairs[1] = new Pair<View, String>(title, title.getTransitionName());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                        pairs);
                startActivity(intent, options.toBundle());
            }
        };

        Handler h = new Handler(Looper.getMainLooper());
        h.postDelayed(r, SPLASH_SCREEN);

    }
}