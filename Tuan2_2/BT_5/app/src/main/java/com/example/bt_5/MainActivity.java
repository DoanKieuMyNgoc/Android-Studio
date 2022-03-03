package com.example.bt_5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edTen, edMa;
    Button btnNhap;
    RadioGroup radioGroup;
    ListView lvDanhSach;
    ArrayAdapter<Employee> arrayAdapter= null;
    ArrayList<Employee> employeeArrayList= new ArrayList<Employee>();
    Employee employee= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edMa = findViewById(R.id.et_manv);
        edTen = findViewById(R.id.et_tennv);
        btnNhap= findViewById(R.id.btn_Nhap);
        radioGroup = findViewById(R.id.radioGr);
        arrayAdapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1, employeeArrayList);
        lvDanhSach= findViewById(R.id.list);
        lvDanhSach.setAdapter(arrayAdapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nhap();
            }
            private void nhap() {
                int radid= radioGroup.getCheckedRadioButtonId();
                String id= edMa.getText()+"";
                String name= edTen.getText()+"";
                if(radid==R.id.chinhthuc){
                    employee= new EmployeePFullTime();
                }else {
                    employee= new EmployeePartTime();
                }
                employee.setId(id);
                employee.setName(name);
                employeeArrayList.add(employee);
                arrayAdapter.notifyDataSetChanged();
            }
        });

    }
}