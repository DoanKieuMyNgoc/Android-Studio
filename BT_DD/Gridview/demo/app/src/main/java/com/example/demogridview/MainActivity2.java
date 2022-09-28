package com.example.demogridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    ImageView anh;
    TextView gia, ten, tt;
    ImageButton ve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        anh= findViewById(R.id.ima_anh);
        gia= findViewById(R.id.tv_gia);
        ten= findViewById(R.id.tv_ten);
        tt= findViewById(R.id.tv_tt);

        Double gia1= getIntent().getExtras().getDouble("gia");
        String ten1= getIntent().getExtras().getString("ten");
        int anh1= getIntent().getExtras().getInt("anh");

        anh.setImageResource(anh1);
        gia.setText(String.valueOf(gia1));
        ten.setText(ten1);
        ve= findViewById(R.id.btn_quayve);
        ve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });




    }
}