package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private ImageView image;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.imageView);
        text = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int imageId = R.drawable.paisaje;
                Bundle bun = new Bundle();
                bun.putString("text", (String) text.getText());
                bun.putInt("img", imageId);
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtras(bun);
                startActivity(intent);

            }
        });

    }
}