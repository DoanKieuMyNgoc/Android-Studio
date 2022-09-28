package com.example.casestudy03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView tv_KQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_NhapThongTin= findViewById(R.id.btn_NhapThongTin);
        tv_KQ= findViewById(R.id.tv_KetQua);

        btn_NhapThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, SubActivity.class);
                startActivityForResult(intent, 9999);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==9999 && resultCode== RESULT_OK){


            String hoten= data.getExtras().getString("ht").toString();
            String namsinh= data.getExtras().getString("ns").toString();
            int namSinh= Integer.parseInt(namsinh);
            Calendar calendar= Calendar.getInstance();
            int namHientai= calendar.get(Calendar.YEAR);
            String st= "";
            st+="Họ và Tên:"+ hoten;
            st+="\n Năm Sinh:"+ namsinh;
            st+="\n Tuổi:"+ (namHientai- namSinh);
            tv_KQ.setText(st);
        }
    }
}