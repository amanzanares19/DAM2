package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private ImageView img2;

    private boolean valid = false;

    private ObjectAnimator myObj;
    private ObjectAnimator myObj2;
    private ObjectAnimator myObj3;
    private ObjectAnimator myObj4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hook

        img = findViewById(R.id.imageView);
        img2 = findViewById(R.id.imageView2);

        /*
        //Darle la vuelta a una imagen mediante código V1
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!valid) {

                    myObj = ObjectAnimator.ofFloat(img, "rotationY", 0f, 180f);
                    myObj2 = ObjectAnimator.ofFloat(img2, "rotationY", 0f, 180f);
                    myObj3 = ObjectAnimator.ofFloat(img, "alpha", 1, 0);
                    myObj4 = ObjectAnimator.ofFloat(img2, "alpha", 0, 1);
                    valid = true;

                } else {

                    myObj = ObjectAnimator.ofFloat(img, "rotationY", 180f, 0f);
                    myObj2 = ObjectAnimator.ofFloat(img2, "rotationY", 180f, 0f);
                    myObj3 = ObjectAnimator.ofFloat(img, "alpha", 0, 1);
                    myObj4 = ObjectAnimator.ofFloat(img2, "alpha", 1, 0);
                    valid = false;
                }

                myObj.setDuration(1000);
                myObj2.setDuration(1000);
                myObj3.setDuration(1);
                myObj4.setDuration(1);
                myObj3.setStartDelay(500);
                myObj4.setStartDelay(500);

                AnimatorSet animationSet = new AnimatorSet();
                animationSet.playTogether(myObj, myObj2, myObj3, myObj4);
                animationSet.start();

            }
        });*/

        //Darle la vuelta a una imagen mediante código V2
        /*img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!valid) {

                    img.setAlpha(1.0f);
                    img.setRotationY(0f);
                    img.animate().setDuration(1000).rotationY(180f);
                    img.animate().alpha(0f).setStartDelay(500);

                    img2.setAlpha(0f);
                    img2.setRotationY(0f);
                    img2.animate().setDuration(1000).rotationY(180f);
                    img2.animate().alpha(1.0f).setStartDelay(500);

                    valid = true;

                } else {

                    img.setAlpha(0.0f);
                    img.setRotationY(180f);
                    img.animate().setDuration(1000).rotationY(0f);
                    img.animate().alpha(1.0f).setStartDelay(500);

                    img2.animate().setDuration(1000).rotationY(0f);
                    img2.animate().alpha(0.0f).setStartDelay(500);

                    valid = false;
                }

            }
        });*/

//        Darle la vuelta a una imagen mediante ficheros xml
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!valid) {

                    //Creación del objeto animación
                    Animator set1 = AnimatorInflater.loadAnimator(MainActivity.this,
                            R.animator.frontanimator);
                    set1.setTarget(img);


                    Animator set2 = AnimatorInflater.loadAnimator(MainActivity.this,
                            R.animator.frontanimator2);
                    set2.setTarget(img2);


                    AnimatorSet animationSet = new AnimatorSet();
                    animationSet.playTogether(set1, set2);
                    animationSet.start();
                    valid = true;

                } else {

                    //Creación del objeto animación
                    Animator set1 = AnimatorInflater.loadAnimator(MainActivity.this,
                            R.animator.backanimator);
                    set1.setTarget(img);


                    Animator set2 = AnimatorInflater.loadAnimator(MainActivity.this,
                            R.animator.backanimator2);
                    set2.setTarget(img2);

                    AnimatorSet animationSet = new AnimatorSet();
                    animationSet.playTogether(set1, set2);
                    animationSet.start();
                    valid = false;

                }

            }
        });

    }
}