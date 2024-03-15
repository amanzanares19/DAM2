package com.example.anime;

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

    private List<Animal> animals;
    private Context context;

    public MyAdapter(List<Animal> animals, Context context) {
        this.animals = animals;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.my_row, parent, false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.ttype.setText(animals.get(position).getType());
        holder.tname.setText(animals.get(position).getName());
        holder.tage.setText(String.valueOf(animals.get(position).getAge()));
        holder.tbirthday.setText(String.valueOf(animals.get(position).getBirthdateYear()));
        holder.tdescription.setText(String.valueOf(animals.get(position).getDescription()));
        holder.tmeals.setText(String.valueOf(animals.get(position).getMeals()));


        Picasso.get().load(animals.get(position).getUrlImage())
                .fit().centerCrop().into(holder.image);

        //Part 2
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("animal", animals.get(holder.getAdapterPosition()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView tname;
        private TextView ttype;
        private TextView tage;
        private TextView tbirthday;
        private TextView tmeals;
        private TextView tdescription;
        private ConstraintLayout constraintLayout;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            //hook
            image = itemView.findViewById(R.id.imageView);
            tname = itemView.findViewById(R.id.textName);
            tage = itemView.findViewById(R.id.textAge);
            ttype = itemView.findViewById(R.id.textType);
            tbirthday = itemView.findViewById(R.id.naixement);
            tmeals = itemView.findViewById(R.id.meals);
            tdescription = itemView.findViewById(R.id.description);

            constraintLayout = itemView.findViewById(R.id.constraintLayout);

        }

    }



}
