package com.example.bt1;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

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

            final  ImageView img_avt =(ImageView) convertView.findViewById(R.id.img_avt);

            String uri= nv.getPath_imge();
            img_avt.setImageURI(Uri.parse(uri));
        }
        return convertView;
    }


}

