package com.example.tk3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Fragmentinfo extends android.app.Fragment  {


    ImageView anh;
    TextView gia, ten;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_fragmentinfo, container, false);
        anh= view.findViewById(R.id.ima_anh);
        gia= view.findViewById(R.id.tv_gia);
        ten= view.findViewById(R.id.tv_ten);




        return view;
    }

    public void nhanSanPham(SanPham sanPham){
        anh.setImageResource(sanPham.getUrl());
        gia.setText(String.valueOf(sanPham.getGia()));
        ten.setText(sanPham.getTen());
    }


}