package com.example.casestudy03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        EditText et_Hoten= findViewById(R.id.editT_HoTen);
        EditText et_Ns= findViewById(R.id.editT_NamSinh);
        Button btn_sub= findViewById(R.id.btn_Submit);
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("ht", et_Hoten.getText().toString());
                intent.putExtra("ns", et_Ns.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}