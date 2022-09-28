package com.example.bt;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView tv_kq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_kq= findViewById(R.id.tv_KetQua);
        Button btn_giai= findViewById(R.id.btn_giai);
        btn_giai.setOnClickListener(new View.OnClickListener() {
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
            String st="";
            String nghiem= data.getExtras().getString("nghiem").toString();
            st+= "Nghiệm của phương trình là: "+ nghiem;
            tv_kq.setText(st);
        }
    }
}