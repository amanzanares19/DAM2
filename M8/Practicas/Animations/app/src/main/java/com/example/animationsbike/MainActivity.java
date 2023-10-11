package com.example.animationsbike;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView background;
    private RelativeLayout textCenter;

    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hook
        background = findViewById(R.id.fondo);
        textCenter = findViewById(R.id.textCenter);
        logo = findViewById(R.id.logo);

        background.animate().setDuration(1000).setStartDelay(300);
        background.animate().translationY(-2300f);

        textCenter.animate().setDuration(800).translationY(-920).setStartDelay(500);
        textCenter.animate().setDuration(800).translationX(-360).setStartDelay(500);
        textCenter.animate().alpha(0);

        logo.animate().setDuration(1000).translationX(-300).setStartDelay(500);





    }
}