package com.example.demogridview;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<SanPham> {
    Activity context = null;
    ArrayList<SanPham> myArray = null;
    int layoutId;

    public MyAdapter(Activity context, int textViewResourceId, ArrayList<SanPham> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.layoutId = textViewResourceId;
        this.myArray = objects;
    }

//    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater inflater = context.getLayoutInflater();
//        convertView = inflater.inflate(layoutId, null);
//        if (myArray.size() > 0 && position >= 0) {
//            final TextView txtDisplay = (TextView) convertView.findViewById(R.id.tv_item);
//            final NhanVien nv = myArray.get(position);
//            txtDisplay.setText(nv.toString());
//            final ImageView imageView = (ImageView) convertView.findViewById(R.id.img_item);
//            if (nv.isGender()) {
//                imageView.setImageResource(R.drawable.nu);
//            } else {
//                imageView.setImageResource(R.drawable.nam);
//            }
//        }
//        return convertView;
//    }



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
