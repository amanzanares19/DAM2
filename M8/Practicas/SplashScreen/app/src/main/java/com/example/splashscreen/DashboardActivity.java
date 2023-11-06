package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    public static final int SPLASH_SCREEN = 1000;
    private TextView signup;
    private TextView forgotPass;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        //hooks
        signup = findViewById(R.id.login);
        forgotPass = findViewById(R.id.forgotPass);
        layout = findViewById(R.id.passwdLayout);

        float x = layout.getScaleX();
        float y = layout.getScaleY();

        layout.setScaleX(0);
        layout.setScaleY(0);

        layout.animate().scaleX(x).scaleY(y).setDuration(1000);


        signup.setOnClickListener(v -> {

            //Animations

            AnimationSet as = new AnimationSet(true);

            Animation anim = new ScaleAnimation(1.2f,0.8f,1.2f,0.8f);
            anim.setDuration(500);

            Animation anim2 = new ScaleAnimation(0.8f,1.2f,0.8f,1.2f);
            anim2.setDuration(500);
            anim2.setStartOffset(500);

            as.addAnimation(anim);
            as.addAnimation(anim2);

            signup.startAnimation(as);

            //Goto
            Runnable r = () -> {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            };

            Handler h = new Handler(Looper.getMainLooper());
            h.postDelayed(r, this.SPLASH_SCREEN);


        });

        forgotPass.setOnClickListener(v -> {

            AnimationSet as = new AnimationSet(true);

            Animation anim = new ScaleAnimation(1.2f,0.8f,1.2f,0.8f);
            anim.setDuration(500);

            Animation anim2 = new ScaleAnimation(0.8f,1.2f,0.8f,1.2f);
            anim2.setDuration(500);
            anim2.setStartOffset(500);

            as.addAnimation(anim);
            as.addAnimation(anim2);

            forgotPass.startAnimation(as);


            Runnable r = () -> {
                Intent intent = new Intent(getApplicationContext(), ForgotpasswordActivity.class);
                startActivity(intent);
            };

            Handler h = new Handler(Looper.getMainLooper());
            h.postDelayed(r, this.SPLASH_SCREEN);


        });


    }
}