package com.example.bt;

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
        EditText et_a= findViewById(R.id.editT_HSA);
        EditText et_b= findViewById(R.id.editT_HSB);
        EditText et_c= findViewById(R.id.editT_HSC);
        Button btn_sub= findViewById(R.id.btn_submit);
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                int a= Integer.parseInt(et_a.getText().toString());
                int b= Integer.parseInt(et_b.getText().toString());
                int c= Integer.parseInt(et_c.getText().toString());
                PTB2 b2= new PTB2(a,b,c);
                intent.putExtra("nghiem",b2.nghiemPTB2(a,b,c));
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}