package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class SignupActivity extends AppCompatActivity {

    private TextView login;

    private DatePickerDialog picker;
    private EditText textDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //hooks
        login = findViewById(R.id.login);
        textDate = (EditText) findViewById(R.id.birthdate);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Animations

                AnimationSet as = new AnimationSet(true);

                Animation anim = new ScaleAnimation(1.2f,0.8f,1.2f,0.8f);
                anim.setDuration(500);

                Animation anim2 = new ScaleAnimation(0.8f,1.2f,0.8f,1.2f);
                anim2.setDuration(500);
                anim2.setStartOffset(500);

                as.addAnimation(anim);
                as.addAnimation(anim2);

                login.startAnimation(as);

                //Goto
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                        startActivity(intent);
                    }
                };

                Handler h = new Handler(Looper.getMainLooper());
                h.postDelayed(r, DashboardActivity.SPLASH_SCREEN);

            }
        });

        //obrim la finestra DatePickerDialog i mostrem el que hem escollit
        textDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Guardem el dia actual amb Calendar.getInstance()
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(SignupActivity.this, android.R.style.Theme_Holo_Dialog,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view,int year,int monthOfYear,int dayOfMonth) {
                                textDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });


    }
}