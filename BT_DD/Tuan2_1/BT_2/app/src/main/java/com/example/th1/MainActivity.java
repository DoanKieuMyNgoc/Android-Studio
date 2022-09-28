package com.example.th1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText c, f;
    Button C, F, CL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c = findViewById(R.id.et_C);
        f = findViewById(R.id.et_F);
        C = findViewById(R.id.btn_C);
        F = findViewById(R.id.btn_F);
        CL = findViewById(R.id.btn_CL);

        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double DoC = (Double.parseDouble(f.getText().toString().trim()) - 32) * 5 / 9;
                c.setText(DoC.toString());
            }
        });
        F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c.equals("")) {

                }
                Double DoF = (Double.parseDouble(c.getText().toString().trim())) * 9 / 5 + 32;
                f.setText(DoF.toString());
            }
        });
        CL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.setText("");
                f.setText("");
            }
        });

    }


}