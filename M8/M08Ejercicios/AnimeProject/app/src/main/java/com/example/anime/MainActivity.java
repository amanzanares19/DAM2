package com.example.anime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<Animal> animals = new ArrayList<>();

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hook
        recyclerView = findViewById(R.id.recyclerView);

        MyAdapter myAdapter = new MyAdapter(animals, this.getApplicationContext());
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));

        data();

    }

    private void data() {

        Animal animal = new Animal("https://www.joanseculi.com/images/image01.jpg",
                "Lion", "Feline", 24);
        Animal animal2 = new Animal("https://www.joanseculi.com/images/image02.jpg",
                "Tiger", "Feline", 20);
        Animal animal3 = new Animal("https://www.joanseculi.com/images/image03.jpg",
                "Elephant", "Human", 20);

        animals.add(animal);
        animals.add(animal2);
        animals.add(animal);
        animals.add(animal2);
        animals.add(animal3);


    }
}