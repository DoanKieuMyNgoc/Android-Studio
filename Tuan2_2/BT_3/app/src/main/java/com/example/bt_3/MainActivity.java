package com.example.bt_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> myList;
    private ArrayAdapter<String> adapter;
    private ListView list;
    private Button btnNhap;
    private TextView tvNhap;
    private TextView tvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNhap = findViewById(R.id.ed_ten);
        myList = new ArrayList<String>();
        list = findViewById(R.id.lv_danhsach);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);
        list.setAdapter(adapter);
        btnNhap = findViewById(R.id.bt_nhap);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myList.add(tvNhap.getText() + "");
                adapter.notifyDataSetChanged();
            }
        });
        tvKetQua= findViewById(R.id.tv_ketqua);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg= "position : "+position;
                msg+="; value : "+ parent.getItemAtPosition(position).toString();
                tvKetQua.setText(msg);
            }
        });
    }
}