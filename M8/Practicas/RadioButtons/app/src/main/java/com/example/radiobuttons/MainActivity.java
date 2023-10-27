package com.example.radiobuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

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
    
    private Button checker;

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
        radioGroup1 = findViewById(R.id.radioGroup);
        radioGroup2 = findViewById(R.id.radioGroup2);
        radioGroup3 = findViewById(R.id.radioGroup3);
        checker = findViewById(R.id.button);
        
        //Show pressed buttons
        checker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioSelected1 = radioGroup1.getCheckedRadioButtonId();
                int radioSelected2 = radioGroup2.getCheckedRadioButtonId();

                RadioButton radioButton;
                radioButton = findViewById(radioSelected1);
                RadioButton radioButton2;
                radioButton2 = findViewById(radioSelected2);

                String selection = radioButton.getText() + "\n" + radioButton2.getText();

                if (switchButton.isChecked() && radioGroup3.getCheckedRadioButtonId() != -1) {
                    int radioSelected3 = radioGroup3.getCheckedRadioButtonId();
                    RadioButton radioButton3;
                    radioButton3 = findViewById(radioSelected3);
                    selection += " " + radioButton3.getText();
                } else {
                    selection += " Disabled";
                    radioGroup3.clearCheck();
                }
                Toast.makeText(MainActivity.this, selection, Toast.LENGTH_SHORT).show();
            }
        });


        //Tasks
        but1.setChecked(true);
        but4.setChecked(true);

        but7.setEnabled(false);
        but8.setEnabled(false);
        but9.setEnabled(false);

        //Función para mostrar radio button seleccionado al presionarse
        showButtonSelected(radioGroup1);
        showButtonSelected(radioGroup2);
        showButtonSelected(radioGroup3);


        //habilitar o deshabilitar radiobuttons mediante el switch
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

    private void showButtonSelected(RadioGroup rg) {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //En caso de que haya radio button seleccionado mostrár opción elegida
                if (group.getCheckedRadioButtonId() != -1){
                    int radioSelected = group.getCheckedRadioButtonId();
                    RadioButton r = findViewById(radioSelected);
                    Toast.makeText(MainActivity.this, r.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}