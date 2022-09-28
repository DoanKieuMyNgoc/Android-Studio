package vn.com.ngoc.app_1;

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

public class LoaiSanPhamActivity extends AppCompatActivity {

    EditText id,ten;
    Button thoat, save, tim,delete,update;
    public static final String URL="content://vn.com.ngoc.app_1/LoaiSanPham";
    List<LoaiSanPham> loaiSanPhamList= new ArrayList<>();
    ArrayAdapter<String> adapter;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loai_san_pham);

        id= findViewById(R.id.edtId);
        ten= findViewById(R.id.edtTenPhongBan);
        thoat= findViewById(R.id.btnThoat);
        save= findViewById(R.id.btnThem);
        tim= findViewById(R.id.btnTim);
        delete= findViewById(R.id.btnXoa);
        update=findViewById(R.id.btnSua);
        gridView= findViewById(R.id.gridview_PhongBan);


        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues contentValues= new ContentValues();
                contentValues.put("id", Integer.parseInt(id.getText().toString().trim()));
                contentValues.put("tenLoaiSP",ten.getText().toString().trim());
                Uri LSP_Uri= Uri.parse(URL);
                Uri isInsert= getContentResolver().insert(LSP_Uri,contentValues);

                if(isInsert!=null){
                    Toast.makeText(LoaiSanPhamActivity.this, "Luu thanh cong", Toast.LENGTH_SHORT).show();
                    loaiSanPhamList.clear();
                    load();

                }else Toast.makeText(LoaiSanPhamActivity.this, "Luu that bai", Toast.LENGTH_SHORT).show();
            }
        });




    }
    public  void load(){
        Uri LoaiSPUri= Uri.parse(URL);
        Cursor cursor= getContentResolver().query(LoaiSPUri,null,null,null,null);
        if (cursor!=null && cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                int id= cursor.getInt(0);
                String ten= cursor.getString(1);
                LoaiSanPham loaiSanPham= new LoaiSanPham(id, ten);
                loaiSanPhamList.add(loaiSanPham);
                cursor.moveToNext();
            }
            cursor.close();
        }

        List<String> LSP= new ArrayList<>();
        for (LoaiSanPham loaiSanPham: loaiSanPhamList){
            LSP.add("id :"+loaiSanPham.getId()+"-ten :"+loaiSanPham.getTenLSP());

        }
        adapter= new ArrayAdapter<>(LoaiSanPhamActivity.this, android.R.layout.simple_list_item_1,LSP);
        gridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

}