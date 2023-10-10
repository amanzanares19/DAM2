package com.example.animationsbike;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hook
        background = findViewById(R.id.fondo);

        background.animate().setDuration(1000).setStartDelay(100);
        background.animate().translationY(-2200f);

    }
}