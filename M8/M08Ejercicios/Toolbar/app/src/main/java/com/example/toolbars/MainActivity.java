package com.example.toolbars;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menutoolbar, menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.accesibilidad) {
            Toast.makeText(this, "Accesibilidad", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.android) {
            Toast.makeText(this, "Android", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.rotation) {
            Toast.makeText(this, "Rotation", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(this, "HOME", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

}