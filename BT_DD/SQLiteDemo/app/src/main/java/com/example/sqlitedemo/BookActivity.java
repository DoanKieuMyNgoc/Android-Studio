package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    EditText et_id, title,et_idAuthor;
    Button save, select;
    GridView GRV;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        et_id= findViewById(R.id.et_idbook);
        et_idAuthor= findViewById(R.id.et_idAuthor);
        title= findViewById(R.id.et_tieudesach);
        save = findViewById(R.id.btn_saveB);
        select= findViewById(R.id.btn_selectB);
        dbHelper= new DBHelper(this);
        GRV= findViewById(R.id.gridviewbook);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book= new Book();
                book.setId_book(Integer.parseInt(et_id.getText().toString()));
                book.setTitle(title.getText().toString());
                book.setId_author(Integer.parseInt(et_idAuthor.getText().toString()));
                if(dbHelper.insertBook(book)>0){
                    Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getApplicationContext(), "Lưu Thất Bại", Toast.LENGTH_SHORT).show();
            }
        });
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Book> books=new ArrayList<>();
                ArrayList<String> stringArrayList= new ArrayList<>();
                books=dbHelper.getAllBook();
                for (Book book:books){
                    stringArrayList.add(book.getId_book()+"");
                    stringArrayList.add(book.getTitle());
                    stringArrayList.add(book.getId_author()+"");
                }
                ArrayAdapter<String>adapter= new ArrayAdapter<>(BookActivity.this,
                        android.R.layout.simple_list_item_1,stringArrayList);
                GRV.setAdapter(adapter);
            }
        });









    }
}