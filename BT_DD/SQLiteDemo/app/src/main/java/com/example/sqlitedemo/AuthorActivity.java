package com.example.sqlitedemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class AuthorActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
        EditText et_id= findViewById(R.id.et_id);
        EditText et_name= findViewById(R.id.et_name);
        EditText et_address= findViewById(R.id.et_address);
        EditText et_email= findViewById(R.id.et_email);
        GridView gridView= findViewById(R.id.gridview);
        DBHelper dbHelper= new DBHelper(this);

        Button save= findViewById(R.id.btn_save);
        Button select= findViewById(R.id.btn_select);
        Button delete= findViewById(R.id.btn_delete);
        Button update= findViewById(R.id.btn_update);
        Button exit= findViewById(R.id.btn_exit);
//        AlertDialog.Builder mydialog= new AlertDialog.Builder(view.getContext());



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Author author= new Author();
                author.setIdAuthor(Integer.parseInt(et_id.getText().toString()));
                author.setAddress(et_address.getText().toString());
                author.setName(et_name.getText().toString());
                author.setEmail(et_email.getText().toString());
                if(dbHelper.insertAuthor(author)>0){
                    Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getApplicationContext(), "Lưu Thất Bại", Toast.LENGTH_SHORT).show();
            }
        });
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Author> list= new ArrayList<>();
                ArrayList<String> stringArrayList= new ArrayList<>();
                list=dbHelper.getAllAuthor();
                if (et_id.getText().equals("")){
                    list = dbHelper.getAllAuthor();
                    for (Author author:list){
                        stringArrayList.add(author.getIdAuthor()+"");
                        stringArrayList.add(author.getName());
                        stringArrayList.add(author.getAddress());
                        stringArrayList.add(author.getEmail());
                    }
                    Toast.makeText(getApplicationContext(), "Chưa nhập id", Toast.LENGTH_SHORT).show();
                }else{
                    Author au= dbHelper.getIDAuthor(Integer.parseInt(et_id.getText().toString()));

                }

                ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(AuthorActivity.this, android.R.layout.simple_list_item_1, stringArrayList);
                gridView.setAdapter(arrayAdapter);
            }
        });


    }
}