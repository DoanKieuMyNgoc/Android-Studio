package com.example.bt1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<NhanVien> {
    Activity context = null;
    ArrayList<NhanVien> myArray = null;
    int layoutId;

    public MyArrayAdapter(Activity context, int textViewResourceId, ArrayList<NhanVien> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.layoutId = textViewResourceId;
        this.myArray = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);
        if (myArray.size() > 0 && position >= 0) {
            final TextView txtDisplay = (TextView) convertView.findViewById(R.id.tv_item);
            final NhanVien nv = myArray.get(position);
            txtDisplay.setText(nv.toString());
            final ImageView imageView = (ImageView) convertView.findViewById(R.id.img_item);
            if (nv.isGender()) {
                imageView.setImageResource(R.drawable.nu);
            } else {
                imageView.setImageResource(R.drawable.nam);
            }
        }
        return convertView;
    }

}

