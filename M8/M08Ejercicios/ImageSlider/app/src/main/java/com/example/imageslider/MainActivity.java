package com.example.imageslider;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private ImageAdapter imageAdapter;
    private ImageView next;
    private ImageView back;
    private TextView imagePos;

    private LinearLayout dotsLayout;
    private List<ImageView> dots = new ArrayList<>();
    private List<Anime> animes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewPager2 = findViewById(R.id.viewPager2);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        back = findViewById(R.id.imageBefore);
        next = findViewById(R.id.imageNext);
        imagePos = findViewById(R.id.nombre);
        dotsLayout = findViewById(R.id.dots);
        getData();

    }

    private void createDots() {

        for (int i = 0; i < imageAdapter.getItemCount(); i++) {

            dots.add(new ImageView(this));
            dots.get(i).setImageResource(R.drawable.circle);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(4,0,4,0);
            dotsLayout.addView(dots.get(i), params);

        }

    }

    private void updateDots(int position) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            for (int i = 0; i < animes.size(); i++) {
                dots.get(i).setImageResource(R.drawable.circle);
            }
            dots.get(position).setImageResource(R.drawable.selected_circle);
        }
    }

    private void setDotsListener() {
        for (int i = 0; i < dots.size(); i++) {
            int finalI = i;
            dots.get(i).setOnClickListener(view -> viewPager2.setCurrentItem(finalI));
        }
    }

    private void updateText(int position) {
        String text = (position + 1) + "/" + imageAdapter.getItemCount();
        imagePos.setText(text);
    }


    private void getData() {

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                "https://joanseculi.com/edt69/animes3.php?email=admin2@email.com",
                null,

                response -> {

                    try {
                        JSONArray jsonArray = response.getJSONArray("animes");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            Anime anime = new Anime(
                                    jsonArray.getJSONObject(i).getInt("id"),
                                    jsonObject.getString("name"),
                                    jsonObject.getString("description"),
                                    "https://www.joanseculi.com/" + jsonObject.getString("image")
                            );
                            animes.add(anime);
                        }

                        imageAdapter = new ImageAdapter(this, animes);
                        viewPager2.setAdapter(imageAdapter);
                        viewPager2.setCurrentItem(2);
                        updateText(viewPager2.getCurrentItem());

                        createDots();
                        updateDots(viewPager2.getCurrentItem());
                        setDotsListener();

                        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                            @Override
                            public void onPageSelected(int position) {
                                super.onPageSelected(position);
                                updateText(position);

                                //Arrows
                                if (position == 0) {
                                    back.setVisibility(View.GONE);
                                } else back.setVisibility(View.VISIBLE);

                                if (position == imageAdapter.getItemCount() - 1) {
                                    next.setVisibility(View.GONE);
                                } else next.setVisibility(View.VISIBLE);

                                updateDots(position);
                            }
                        });

                        next.setOnClickListener(view ->
                                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1, true));

                        back.setOnClickListener(view ->
                                viewPager2.setCurrentItem(viewPager2.getCurrentItem() - 1));

                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                },

                error -> {

                    Toast.makeText(this, "Error al cargar animes", Toast.LENGTH_SHORT).show();

                }

        );
        requestQueue.add(jsonObjectRequest);

    }

}