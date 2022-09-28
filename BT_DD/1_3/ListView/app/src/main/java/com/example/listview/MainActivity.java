package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] listItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GridView gridView_traicay= findViewById(R.id.gr_traicay);
        listItem= getResources().getStringArray(R.array.traicay_array);
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        gridView_traicay.setAdapter(adapter);
        gridView_traicay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View vietw, int i, long l) {
                Toast.makeText(MainActivity.this, listItem[i], Toast.LENGTH_SHORT).show();
            }
        });


//        ListView listView= findViewById(R.id.list_traicay);
//        listItem= getResources().getStringArray(R.array.traicay_array);
//        final ArrayAdapter<String> adapter= new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String value= adapter.getItem(i);
//                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//        Spinner spinner= findViewById(R.id.spiner_TraiCay);
//        listItem= getResources().getStringArray(R.array.traicay_array);
//        ArrayAdapter<String> adapter= new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1,
//                listItem);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),listItem[i], Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });



    }
}