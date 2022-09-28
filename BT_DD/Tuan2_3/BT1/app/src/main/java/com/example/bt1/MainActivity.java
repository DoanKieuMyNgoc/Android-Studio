package com.example.bt1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<NhanVien> arrNhanVien = null;
    MyArrayAdapter adapter = null;
    ListView lvNhaVien = null;
    Button btnNhap;
    ImageButton btnRemoveAll;
    EditText txtMa, txtTen;
    RadioGroup genderGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNhap = findViewById(R.id.btn_nhap);
        btnRemoveAll = findViewById(R.id.imgebtn);
        txtMa = (EditText) findViewById(R.id.et_ma);
        txtTen = (EditText) findViewById(R.id.et_ten);
        genderGroup = findViewById(R.id.radGr_gt);

        lvNhaVien = (ListView) findViewById(R.id.dsSinhVien);
        arrNhanVien = new ArrayList<NhanVien>();
        adapter = new MyArrayAdapter(this, R.layout.my_item_layout, arrNhanVien);
        lvNhaVien.setAdapter(adapter);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyNhap();
            }
        });
        btnRemoveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyXoa();
            }
        });


    }

    private void xulyXoa() {
        for (int i = lvNhaVien.getChildCount() - 1; i >= 0; i--) {
            View v = lvNhaVien.getChildAt(i);
            CheckBox chk = (CheckBox) v.findViewById(R.id.chk_item);
            if (chk.isChecked()) {
                arrNhanVien.remove(i);
            }
        }
        adapter.notifyDataSetChanged();

    }

    private void xulyNhap() {


        String ma = txtMa.getText() + "";
        String ten = txtTen.getText() + "";
        boolean gioitinh = false;
        if (genderGroup.getCheckedRadioButtonId() == R.id.radio_nu) {
            gioitinh = true;
        }
        NhanVien nv = new NhanVien();
        nv.setId(ma);
        nv.setName(ten);
        nv.setGender(gioitinh);

        arrNhanVien.add(nv);

        adapter.notifyDataSetChanged();

        txtTen.setText("");
        txtMa.setText("");
        txtMa.requestFocus();
    }
}