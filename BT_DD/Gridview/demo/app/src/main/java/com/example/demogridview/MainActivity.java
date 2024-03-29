package com.example.demogridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SanPham sp1, sp2,sp3,sp4,sp5,sp6,sp7,sp8,sp9,sp10,sp11,sp12;
    ArrayList<SanPham> listsp;
    MyAdapter adapter= null;
    GridView GRid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listsp= new ArrayList<SanPham>();
        adapter= new MyAdapter(this, R.layout.iteminfo,listsp);

        GRid= findViewById(R.id.gridview_sanpham);

        GRid.setAdapter(adapter);


        sp1= new SanPham("Bàn học gỗ MDF, bàn học sinh đẹp hiện đại GHC-4608", 2160000, R.drawable.sp1);listsp.add(sp1);adapter.notifyDataSetChanged();
        sp2= new SanPham("Bàn làm việc gỗ hiện đại Daredevil", 5970000, R.drawable.sp2);listsp.add(sp2);adapter.notifyDataSetChanged();
        sp3= new SanPham("Bàn Làm Việc An Furniture 2 Ngăn Table", 1450000, R.drawable.sp3);listsp.add(sp3);adapter.notifyDataSetChanged();
        sp4= new SanPham("Bàn làm việc, bàn học, bàn vi tính, bàn học sinh, bàn làm việc văn phòng T-Home BAH008", 1449000, R.drawable.sp4);listsp.add(sp4);adapter.notifyDataSetChanged();
        sp5= new SanPham("BÀN GỖ TỰ NHIÊN BÀN ĂN", 790000, R.drawable.sp5);listsp.add(sp5);adapter.notifyDataSetChanged();
        sp6= new SanPham("Bàn làm việc tại nhà BLV02", 2250000, R.drawable.sp6);listsp.add(sp6);adapter.notifyDataSetChanged();
        sp7= new SanPham("Bàn học bằng gỗ kiểu dáng nhỏ gọn GHS-4925", 3780000, R.drawable.sp7);listsp.add(sp7);adapter.notifyDataSetChanged();
        sp8= new SanPham("Bàn nhân viên Athena AT120S", 814000, R.drawable.sp8);listsp.add(sp8);adapter.notifyDataSetChanged();
        sp9= new SanPham("BÀN HỌC SINH CÓ GIÁ SÁCH BHS-13-08", 1905000, R.drawable.sp9);listsp.add(sp9);adapter.notifyDataSetChanged();
        sp10= new SanPham("Bàn Làm Việc Chân Gỗ , Bàn Học Tiết Kiệm Không Gian GP121", 318000, R.drawable.sp10);listsp.add(sp10);adapter.notifyDataSetChanged();
        sp11= new SanPham("Thông tin chi tiết sản phẩm Bàn làm việc tại nhà BLV44", 2450000, R.drawable.sp11);listsp.add(sp11);adapter.notifyDataSetChanged();
        sp12= new SanPham("Bàn Gỗ Siêu Xinh Kèm Giá Sách Kiểu Mới", 504000, R.drawable.sp12);listsp.add(sp12);adapter.notifyDataSetChanged();

        GRid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent(MainActivity.this, MainActivity2.class);

                intent.putExtra("ten", listsp.get(i).getTen());
                intent.putExtra("anh", listsp.get(i).getUrl());
                intent.putExtra("gia", listsp.get(i).getGia());
                startActivity(intent);
            }
        });



    }
}