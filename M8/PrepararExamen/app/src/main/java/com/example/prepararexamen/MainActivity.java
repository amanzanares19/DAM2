package com.example.prepararexamen;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //Date
    private DatePickerDialog datePicker;
    private EditText textDate;

    //Animaciones
    private ImageView img;
    private ImageView img3;
    private ImageView img4;
    private int image = 0;

    //    Spinner
    private Spinner spinner;

    //    SpinnerClass
    private Spinner spinnerClass;
    private ArrayList<DavidBowie> mDavidBowie;
    private DavidBowieAdapter mAdapter;

    //Serializable
    private Button serializable;
//    parcelable
    private Button parcelable;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textDate = findViewById(R.id.textdate);
        img = findViewById(R.id.imageView2);
        img3 = findViewById(R.id.morado);
        img4 = findViewById(R.id.panda);
        spinner = findViewById(R.id.spinner);
        spinnerClass = findViewById(R.id.spinnerClass);
        serializable = findViewById(R.id.serializable);
        parcelable = findViewById(R.id.parcelable);

        textDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar cldr = Calendar.getInstance();
                final int year = cldr.get(Calendar.YEAR);
                final int month = cldr.get(Calendar.MONTH);
                final int day = cldr.get(Calendar.DAY_OF_MONTH);

                datePicker = new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_Holo_Dialog,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                                textDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);

                            }
                        }, year, month, day);
                datePicker.show();

            }
        });


        //Animator
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animator set = AnimatorInflater.loadAnimator(getApplicationContext(),
                        R.animator.frontanimation);
                //Only one animation
                set.setTarget(v);
                set.start();

            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (image == 0) {
                    //                Multiple animations
                    Animator set = AnimatorInflater.loadAnimator(getApplicationContext(),
                            R.animator.frontanimation);
                    Animator set2 = AnimatorInflater.loadAnimator(getApplicationContext(),
                            R.animator.frontanimation2);
                    set.setTarget(img3);
                    set2.setTarget(img4);

                    AnimatorSet animSet = new AnimatorSet();
                    animSet.playTogether(set, set2);
                    animSet.start();
                    image++;
                } else {
                    //                Multiple animations
                    Animator set = AnimatorInflater.loadAnimator(getApplicationContext(),
                            R.animator.backanimation);
                    Animator set2 = AnimatorInflater.loadAnimator(getApplicationContext(),
                            R.animator.backanimation2);
                    set.setTarget(img4);
                    set2.setTarget(img3);

                    AnimatorSet animSet = new AnimatorSet();
                    animSet.playTogether(set, set2);
                    animSet.start();
                    image--;
                }
            }
        });

        //Spinner basic
        /*spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "Nothing selected", Toast.LENGTH_SHORT).show();
            }
        });*/

        //Spinner with style
        /* distintos estilos predefinidos
        android.R.layout.simple_spinner_item
        android.R.layout.simple_dropdown_item_1line
        android.R.layout.simple_list_item_checked

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_activated_1,
                getResources().getStringArray(R.array.cursos));

        spinner.setAdapter(dataAdapter);

         */

        //Spinner con layouts
        /*ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                R.layout.spinner_layout,
                getResources().getStringArray(R.array.cursos));

        spinner.setAdapter(dataAdapter);
        dataAdapter.setDropDownViewResource(R.layout.spinner_layout2);*/

        //Spinner class
        initList();
        mAdapter = new DavidBowieAdapter(this, mDavidBowie);
        spinnerClass.setAdapter(mAdapter);

        spinnerClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DavidBowie selectedPosition = (DavidBowie) parent.getItemAtPosition(position);
                String text = selectedPosition.getCoverName();
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "nothing", Toast.LENGTH_SHORT).show();
            }
        });

        //Serializable

        Anime anime = new Anime(1, "Anime1" , "Anime2", "Anime3", 2, "Anime4", "Anime5");
        serializable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("anime", anime);
                startActivity(intent);
            }
        });

        //Parcelable
        AnimePar animepar = new AnimePar(1, "Anime1" , "Anime2", "Anime3", 2, "Anime4", "Anime5");
        parcelable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("animepar", animepar);
                startActivity(intent);
            }
        });

    }

    private void initList() {
        mDavidBowie = new ArrayList<>();
        mDavidBowie.add(new DavidBowie("DB6", R.drawable.db6));
        mDavidBowie.add(new DavidBowie("DB7", R.drawable.db7));
        mDavidBowie.add(new DavidBowie("DB8", R.drawable.db8));
        mDavidBowie.add(new DavidBowie("DB9", R.drawable.db9));
        mDavidBowie.add(new DavidBowie("DB10", R.drawable.db10));
    }

}