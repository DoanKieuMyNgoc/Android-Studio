package com.example.tk3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements FragmentGrid.sendData{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SanPham sp= (SanPham) getIntent().getSerializableExtra("sanpham");

        Fragmentinfo fragmentProductInfo = (Fragmentinfo) getFragmentManager().findFragmentById(R.id.fragmenifo);
        Configuration configuration = getResources().getConfiguration();

        if (sp!= null && fragmentProductInfo != null && configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            fragmentProductInfo.nhanSanPham(sp);
//            Toast.makeText(MainActivity.this,sp.toString(), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void sendSP(SanPham sp) {
       Fragmentinfo fragmentProductInfo = (Fragmentinfo) getFragmentManager().findFragmentById(R.id.fragmenifo);
       Configuration configuration = getResources().getConfiguration();

       if (fragmentProductInfo != null && configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            fragmentProductInfo.nhanSanPham(sp);
        }else {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("anh", String.valueOf(sp.getUrl()));
            intent.putExtra("ten", sp.getTen());
            intent.putExtra("gia", String.valueOf(sp.getGia()));
            startActivity(intent);
        }
    }
}