package com.example.prepararexamen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DavidBowieAdapter extends ArrayAdapter<DavidBowie> {
    public DavidBowieAdapter(Context context, ArrayList<DavidBowie> davidBowieArrayList) {
        super(context,0, davidBowieArrayList);
    }

    public View init(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_row, parent,
                    false);
            //Recogemos datos del layout creado
            ImageView image = convertView.findViewById(R.id.davidImage);
            TextView text = convertView.findViewById(R.id.davidText);
            //Guardar item seleccionado
            DavidBowie currentItem = getItem(position);

            //Realizar setters
            if (currentItem != null) {
                image.setImageResource(currentItem.getImgCover());
                text.setText(currentItem.getCoverName());
            }
        }
        return convertView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return init(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return init(position, convertView, parent);
    }
}
