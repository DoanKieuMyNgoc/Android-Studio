package com.example.ui_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<NhanVien> nv_list = new ArrayList<>();
    String[] dv_list;
    private String donvi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText et_hoten = findViewById(R.id.et_ten);
        EditText et_Ma = findViewById(R.id.et_ma);
        ListView lv_NV = findViewById(R.id.listView_NhanVien);
        RadioGroup radGR = findViewById(R.id.rg);
        RadioButton nam = findViewById(R.id.nam);
        RadioButton nu = findViewById(R.id.nu);


        Spinner spinner = findViewById(R.id.spiner_donvi);
        dv_list = getResources().getStringArray(R.array.donvi);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                dv_list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                donvi = dv_list[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Button them = findViewById(R.id.button_Them);
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int maso = Integer.parseInt(et_Ma.getText().toString());
                String hoten = et_hoten.getText().toString();
                String gt = ((RadioButton) findViewById(radGR.getCheckedRadioButtonId())).getText().toString();
                NhanVien nv = new NhanVien(maso, hoten, gt, donvi);
                //Thêm nhân viên vào danh sách

                nv_list.add(nv);
                // đưa danh sách nhân viên vào listview

                ArrayList<String> listItem= new ArrayList<>();
                for (NhanVien nv1:nv_list)
                    listItem.add(nv1.toString());
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
                lv_NV.setAdapter(adapter);

            }
        });
        lv_NV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NhanVien nv= nv_list.get(i);
                et_Ma.setText(nv.getMaso()+"");
                et_hoten.setText(nv.getHoten());
                if(nv.getGioitinh().equals("Nam")){
                    nam.setChecked(true);
                }
                else nu.setChecked(true);
                // xử lý đơn vị
                for (int j=0; j<dv_list.length;j++){
                    if (dv_list[j].equals(nv.getDonvi()))
                        spinner.setSelection(j);
                }
                
            }
        });

        Button sua= findViewById(R.id.button_Sua);
        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}