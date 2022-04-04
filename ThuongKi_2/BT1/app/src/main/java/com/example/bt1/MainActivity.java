package com.example.bt1;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gun0912.tedbottompicker.TedBottomPicker;

public class MainActivity extends AppCompatActivity {
    ArrayList<NhanVien> arrNhanVien = null;
    MyArrayAdapter adapter = null;
    ListView lvNhaVien = null;
    Button btnNhap, btnLuu, btnXuat;
    ImageButton btnRemoveAll;
    EditText txtMa, txtTen;
    RadioGroup genderGroup;
    Button chonanh;
    ImageView avt, image_avt_list;
    String path;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLuu = findViewById(R.id.btn_luu);
        btnXuat = findViewById(R.id.btn_load);
        btnNhap = findViewById(R.id.btn_nhap);
        btnRemoveAll = findViewById(R.id.imgebtn);
        txtMa = (EditText) findViewById(R.id.et_ma);
        txtTen = (EditText) findViewById(R.id.et_ten);
        genderGroup = findViewById(R.id.radGr_gt);
        avt = findViewById(R.id.avt);

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

        chonanh = findViewById(R.id.btn_chonanh);
        avt = findViewById(R.id.avt);
        image_avt_list = findViewById(R.id.img_avt);

        chonanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPermissions();
            }
        });


        //Lưu list view vào txt
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Xuất từ txt sang list view
        btnXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        lvNhaVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NhanVien nv= arrNhanVien.get(i);
                avt.setImageURI(Uri.parse(nv.getPath_imge()));
                txtMa.setText(nv.getId().toString());
                txtTen.setText(nv.getName().toString());
                if(nv.isGender()==true){
                    genderGroup.setId(R.id.radio_nu);
                }else genderGroup.setId(R.id.radio_nam);
                Toast.makeText(MainActivity.this, "ddd", Toast.LENGTH_SHORT).show();
            }
        });



    }


    private void requestPermissions() {
        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                openImagePicker();
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(MainActivity.this, "Permission Denied\n" +
                        deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }


        };
        TedPermission.with(this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .check();

    }

    private void openImagePicker() {
        TedBottomPicker.OnImageSelectedListener listener = new TedBottomPicker.OnImageSelectedListener() {
            @Override
            public void onImageSelected(Uri uri) {
                path = uri + "";
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    avt.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        TedBottomPicker tedBottomPicker = new TedBottomPicker.Builder(MainActivity.this)
                .setOnImageSelectedListener(listener)
                .create();
        tedBottomPicker.show(getSupportFragmentManager());
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
        nv.setPath_imge(path);


        arrNhanVien.add(nv);

        adapter.notifyDataSetChanged();

        txtTen.setText("");
        txtMa.setText("");
        txtMa.requestFocus();
    }

}