package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //Calendar
    private DatePickerDialog datePicker;
    private EditText textDate;

    //Spinner
    private Spinner spinnerCursos;

    //DAVIDBOWIE
    private ArrayList<DavidBowie> mDavidBowie;
    private DavidBowieAdapter mDBAdapter;

    private Spinner spinnerClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hook Calendar
        textDate = findViewById(R.id.textDate);

        textDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar cdlr = Calendar.getInstance();

                int day = cdlr.get(Calendar.DAY_OF_MONTH);
                int month = cdlr.get(Calendar.MONTH);
                int year = cdlr.get(Calendar.YEAR);

                datePicker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                textDate.setText(i2 + "/" + i1 + "/" + i);
                            }
                        },year,month,day);
                datePicker.show();

            }
        });

        //hook Spinner
        spinnerCursos = findViewById(R.id.cursos);
        String[] cursos = getResources().getStringArray(R.array.cursos);


        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_checked, cursos);

        spinnerCursos.setAdapter(myAdapter);

        spinnerCursos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                String selectedItem = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Selected item: " + selectedItem,
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //Hook spinnerClass
        initList();
        spinnerClass = (Spinner) findViewById(R.id.spinnerClass);

        mDBAdapter = new DavidBowieAdapter(this, mDavidBowie);
        spinnerClass.setAdapter(mDBAdapter);
        spinnerClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                DavidBowie davidBowie = (DavidBowie) adapterView.getItemAtPosition(i);
                Toast.makeText(MainActivity.this, "Selected: " + davidBowie.getCoverName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "Nothing selected", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void initList() {
        mDavidBowie = new ArrayList<>();
        mDavidBowie.add(new DavidBowie("Stardust", R.drawable.db8));
        mDavidBowie.add(new DavidBowie("Aladdin Sane", R.drawable.db6));
        mDavidBowie.add(new DavidBowie("Low", R.drawable.db7));
        mDavidBowie.add(new DavidBowie("David Bowie", R.drawable.db3));
    }
}