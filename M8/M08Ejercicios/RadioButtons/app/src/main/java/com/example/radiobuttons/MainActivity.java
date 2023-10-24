package com.example.radiobuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    private RadioButton but1;
    private RadioButton but2;
    private RadioButton but3;
    private RadioButton but4;
    private RadioButton but5;
    private RadioButton but6;
    private RadioButton but7;
    private RadioButton but8;
    private RadioButton but9;

    private Switch switchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hooks
        but1 = findViewById(R.id.radioButton);
        but4 = findViewById(R.id.radioButton4);
        switchButton = findViewById(R.id.switch1);
        but7 = findViewById(R.id.radioButton7);
        but8 = findViewById(R.id.radioButton8);
        but9 = findViewById(R.id.radioButton9);



        //Tasks
        but1.setChecked(true);
        but4.setChecked(true);

        but7.setEnabled(false);
        but8.setEnabled(false);
        but9.setEnabled(false);


        if (switchButton != null) {
            switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if (isChecked) {
                        but7.setEnabled(true);
                        but8.setEnabled(true);
                        but9.setEnabled(true);
                    } else {
                        but7.setEnabled(false);
                        but7.setChecked(false);
                        but8.setEnabled(false);
                        but8.setChecked(false);
                        but9.setEnabled(false);
                        but9.setChecked(false);
                    }

                }
            });
        }


    }
}