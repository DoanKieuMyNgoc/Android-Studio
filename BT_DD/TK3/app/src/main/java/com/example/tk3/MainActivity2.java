package com.example.tk3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity2 extends AppCompatActivity {

    ImageView anh;
    TextView gia, ten;
    Button ve;
    SanPham sanPham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        anh = findViewById(R.id.ima_anhsp);
        gia = findViewById(R.id.tv_giasp);
        ten = findViewById(R.id.tv_tensp);
        ve = findViewById(R.id.btn_back);


        String anh1 = getIntent().getExtras().getString("anh");
        String ten1 = getIntent().getExtras().getString("ten");
        String gia1 = getIntent().getExtras().getString("gia");


        anh.setImageResource(Integer.parseInt(anh1));
        ten.setText(ten1);
        gia.setText(String.valueOf(gia1));

        sanPham= new SanPham(ten1.toString(),Double.parseDouble(gia1),Integer.parseInt(anh1));


        ve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        Fragmentinfo fragmentProductInfo = (Fragmentinfo) getFragmentManager().findFragmentById(R.id.fragmenifo);
        Configuration configuration = getResources().getConfiguration();

        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            intent.putExtra("sanpham",  sanPham);

            startActivity(intent);



        }

    }
    }
