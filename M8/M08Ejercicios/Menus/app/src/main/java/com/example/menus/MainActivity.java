package com.example.menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mymenuest, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int selectedItem = item.getItemId();

        if (selectedItem == R.id.profile) {
            Toast.makeText(this, "Perfil", Toast.LENGTH_SHORT).show();
        }

        if (selectedItem == R.id.refresh) {
            Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT).show();
        }

        if (selectedItem == R.id.bluetooth) {
            Toast.makeText(this, "Bluetooth", Toast.LENGTH_SHORT).show();
        }

        return true;

    }
}