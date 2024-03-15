package com.example.anime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {


    private TextView tname;
    private TextView tage;
    private TextView ttype;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //hooks
        tname = findViewById(R.id.textView);
        tage = findViewById(R.id.textView2);
        ttype = findViewById(R.id.textView3);
        img = findViewById(R.id.imageView2);

        Intent intent = getIntent();
        Animal animal = (Animal) intent.getSerializableExtra("animal");

        tname.setText(animal.getName());
        ttype.setText(animal.getType());
        tage.setText(animal.getAge() + "");
        Picasso.get().load(animal.getUrlImage()).fit().centerCrop().into(img);


    }
}