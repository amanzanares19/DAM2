package com.example.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class DavidBowieAdapter extends ArrayAdapter<DavidBowie> {

    public DavidBowieAdapter(@NonNull Context context, @NonNull List<DavidBowie> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup
            parent) {
        return getView1(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup
            parent) {
        return getView1(position, convertView, parent);
    }

    @NonNull
    public View getView1(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_row, parent,
                    false);
        }

        //hooks
        ImageView imgView = convertView.findViewById(R.id.db6);
        TextView textView = convertView.findViewById(R.id.textDb6);

        DavidBowie item = getItem(position);

        if (item != null) {
            imgView.setImageResource(item.getImgCover());
            textView.setText(item.getCoverName());
        }

        return convertView;
    }


}
