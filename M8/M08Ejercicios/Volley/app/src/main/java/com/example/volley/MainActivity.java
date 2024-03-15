package com.example.volley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static String JSON = "https://run.mocky.io/v3/b112b721-07ce-46d7-a713-e18618c952e6";
    private List<Peak> peaks = new ArrayList<>();

    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        getPeaks();
    }

    private void getPeaks() {

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                //Method
                Request.Method.GET,
                this.JSON,
                null,
                //success
                response -> {

                    System.out.println(response.toString());
                    for (int i = 0; i < response.length(); i++) {

                        try {

                            JSONObject jsonObject = response.getJSONObject(i);

                            Peak p = new Peak();
                            p.setCountry(jsonObject.getString("country"));
                            p.setName(jsonObject.getString("name"));
                            p.setHeight(jsonObject.getString("height"));
                            p.setZone(jsonObject.getString("zone"));
                            p.setProminence(jsonObject.getString("prominence"));
                            p.setUrl(jsonObject.getString("url"));
                            System.out.println(p.getUrl());
                            peaks.add(p);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    //RECYCLERVIEW
                    MyAdapter myAdapter = new MyAdapter(peaks, getApplicationContext());
                    recyclerView.setAdapter(myAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));

                },

                //Error
                error -> {

                    Toast.makeText(this, "Error json", Toast.LENGTH_SHORT).show();
                
                }

        );


        requestQueue.add(jsonArrayRequest);

    }
}