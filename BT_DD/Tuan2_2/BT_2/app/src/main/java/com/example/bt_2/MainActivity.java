package com.example.bt_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button thoat= findViewById(R.id.btn_Thoat);
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mydialog= new AlertDialog.Builder(view.getContext());
                mydialog.setMessage(getResources().getString(R.string.mes_dialog_exist));
                mydialog.setTitle(getResources().getString(R.string.mes_dialog_exist_title));
                mydialog.setIcon(android.R.drawable.ic_dialog_alert);
                mydialog.setPositiveButton(getResources().getString(R.string.mes_dialog_ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        finish();
                    }
                });
                mydialog.setNegativeButton(getResources().getString(R.string.mes_dialog_cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog dialog= mydialog.create();
                dialog.show();
        }
        });
        EditText tk= findViewById(R.id.et_tk);
        Button dangnhap= findViewById(R.id.btn_DangNhap);
        CheckBox Luu= findViewById(R.id.chbox_Luu);
        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Luu.isChecked()== true && tk.length()!=0){
                    Toast.makeText(MainActivity.this, "Chào mừng bạn đăng nhập hệ thống\n Thông tin của bạn đã được lưu", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Chào mừng bạn đăng nhập hệ thống\n Thông tin của bạn không được lưu", Toast.LENGTH_SHORT).show();
                    recreate();
                }
            }
        });
    }

}