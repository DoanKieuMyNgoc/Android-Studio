package vn.com.ngoc.appa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PhongBanActivity extends AppCompatActivity {

    public static final String URI="content://vn.com.ngoc.appa/PHONGBAN";
    List<PhongBan> phongBanList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phong_ban);

        EditText id= findViewById(R.id.et_idPB);
        EditText tenPB= findViewById(R.id.et_tenPB);

        Button thoat= findViewById(R.id.btn_thoát);
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Button select=findViewById(R.id.btn_selectPB);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> list= new ArrayList<>();
                Uri phongban= Uri.parse(URI);
                Cursor cursor= getContentResolver().query(phongban,null,null,null,null);
                if (cursor!=null && cursor.moveToFirst()){
                    while (!cursor.isAfterLast()){
                        list.add(cursor.getInt(0)+"");
                        list.add(cursor.getString(1));
                        cursor.moveToNext();
                    }
                    ArrayAdapter<String> adapter= new ArrayAdapter<>(PhongBanActivity.this,
                            android.R.layout.simple_list_item_1,list);
                    GridView gridView= findViewById(R.id.GRV_PB);
                    gridView.setAdapter(adapter);
                }
                else
                    Toast.makeText(getApplicationContext(), "Không có kết quả", Toast.LENGTH_SHORT).show();


            }
        });
        Button save= findViewById(R.id.btn_avePb);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values= new ContentValues();
                values.put("id", id.getText().toString());
                values.put("tenPB",tenPB.getText().toString());

                Uri phongban= Uri.parse(URI);
                Uri insert_uri= getContentResolver().insert(phongban,values);
                Toast.makeText(getApplicationContext(), "Luu thanh cong", Toast.LENGTH_SHORT).show();

            }
        });
        Button delete= findViewById(R.id.btn_deletePB);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phongBanidUrl=URI+"/"+id;
                Uri PBIDUri= Uri.parse(phongBanidUrl);
                int isDelete= getContentResolver().delete(PBIDUri,null,null);
                if(isDelete>0){
                    Toast.makeText(getApplicationContext(), "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                    phongBanList.clear();





                }
                else {
                    Toast.makeText(getApplicationContext(), "Xoa that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}