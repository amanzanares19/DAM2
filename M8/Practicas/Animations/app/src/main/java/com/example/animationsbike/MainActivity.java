package com.example.animationsbike;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_SCREEN = 1000;
    private ImageView background;
    private RelativeLayout textCenter;
    private ImageView logo;
    //Per text superior
    private LinearLayout linearL;

    private ImageView logo2;

    private GridLayout gLayout;

    private ImageView bici1;
    private ImageView bici2;
    private ImageView bici3;
    private ImageView bici4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hook
        background = findViewById(R.id.fondo);
        textCenter = findViewById(R.id.textCenter);
        logo = findViewById(R.id.logo);
        linearL = findViewById(R.id.linearLayout);
        logo2 = findViewById(R.id.logo2);
        gLayout = findViewById(R.id.gLayout);
        bici1 = findViewById(R.id.bici1);
        bici2 = findViewById(R.id.bici2);
        bici3 = findViewById(R.id.bici3);
        bici4 = findViewById(R.id.bici4);

        background.animate().setDuration(1000).setStartDelay(300);
        background.animate().translationY(-2300f);

        textCenter.animate().setDuration(800).translationY(-920).setStartDelay(500);
        textCenter.animate().setDuration(800).translationX(-360).setStartDelay(500);
        textCenter.animate().alpha(0);

        logo.animate().setDuration(900).translationX(-300).setStartDelay(500);

        //Animation text superior
        linearL.setAlpha(0);
        linearL.animate().alpha(1).setDuration(1000).setStartDelay(1500);

        Animation aniRotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotation360);
        linearL.startAnimation(aniRotate);

        logo2.setTranslationX(1500);
        logo2.setScaleX(0.8f);
        logo2.setScaleY(0.8f);
        logo2.animate().translationX(800).setDuration(800).setStartDelay(800);

        gLayout.setTranslationY(1000);
        gLayout.setAlpha(0f);
        gLayout.animate().translationY(600).setDuration(700).setStartDelay(1500).alpha(1);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        };
        Handler h = new Handler(Looper.getMainLooper());
        // The Runnable will be executed after the given delay time

        bici1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bici1.animate().rotation(360).setDuration(800);
                h.postDelayed(r, SPLASH_SCREEN); // will be delayed for 3 seconds
            }
        });

        bici2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bici2.animate().rotation(360).setDuration(800);
                h.postDelayed(r, SPLASH_SCREEN); // will be delayed for 3 seconds
            }
        });

        bici3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bici3.animate().rotation(360).setDuration(800);
                h.postDelayed(r, SPLASH_SCREEN); // will be delayed for 3 seconds
            }
        });

        bici4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bici4.animate().rotation(360).setDuration(800);
                h.postDelayed(r, SPLASH_SCREEN); // will be delayed for 3 seconds
            }
        });


    }
}