package com.example.tk3;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<SanPham> {
    Activity context = null;
    ArrayList<SanPham> myArray = null;
    int layoutId;

    public MyAdapter(Context context, int textViewResourceId, ArrayList<SanPham> objects) {
        super(context, textViewResourceId, objects);
        this.context = (Activity) context;
        this.layoutId = textViewResourceId;
        this.myArray = objects;
    }



    public View getView(int position, View convertView,  ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        convertView = inflater.inflate(layoutId, null);
        if (myArray.size() > 0 && position >= 0) {
            final ImageView ha = (ImageView) convertView.findViewById(R.id.img_item);
            final TextView ten= (TextView) convertView.findViewById(R.id.tv_infoitem);
            final TextView gia= (TextView) convertView.findViewById(R.id.tv_gia);

            final SanPham sp = myArray.get(position);

            ha.setImageResource(sp.getUrl());
            ten.setText(sp.getTen());
            gia.setText(String.valueOf(sp.getGia()));

        }
        return convertView;
    }
}
