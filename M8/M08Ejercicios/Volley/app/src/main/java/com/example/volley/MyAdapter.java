package com.example.volley;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Peak> peaks;
    private Context context;

    public MyAdapter(List<Peak> animals, Context context) {
        this.peaks = animals;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.myrow, parent, false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tcountry.setText(peaks.get(position).getCountry());
        holder.tname.setText(peaks.get(position).getName());
        holder.theight.setText(String.valueOf(peaks.get(position).getHeight()));

        Picasso.get().load(peaks.get(position).getUrl())
                .fit().centerCrop().into(holder.image);
    }

    @Override
    public int getItemCount() {
        return peaks.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView tname;
        private TextView tcountry;
        private TextView theight;
        private ConstraintLayout constraintLayout;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            //hook
            image = itemView.findViewById(R.id.imageView);
            tname = itemView.findViewById(R.id.textView);
            tcountry = itemView.findViewById(R.id.textView2);
            theight = itemView.findViewById(R.id.textView3);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);

        }

    }



}
