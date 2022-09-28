package com.example.bt4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText hoten = findViewById(R.id.hoten);
        EditText cmnd = findViewById(R.id.cmnd);

        RadioButton trungcap = findViewById(R.id.trungcap);
        RadioButton caodang = findViewById(R.id.caodang);
        RadioButton daihoc = findViewById(R.id.daihoc);
        CheckBox docbao = findViewById(R.id.docbao);
        CheckBox docsach = findViewById(R.id.docsach);
        CheckBox doccode = findViewById(R.id.doccode);
        EditText thongtin = findViewById(R.id.thongtin);
        Button gui = findViewById(R.id.btnGuiTT);
        RadioGroup bangcap = findViewById(R.id.grBangCap);


        AlertDialog.Builder mydialog = new AlertDialog.Builder(this);
        mydialog.setTitle("Cảnh báo");
        mydialog.setMessage("Yêu Cầu chọn bằng cấp");
        mydialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        mydialog.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });


        AlertDialog.Builder mydialog1 = new AlertDialog.Builder(this);
        mydialog1.setTitle("Cảnh báo");
        mydialog1.setMessage("Chọn ít nhất một sở thích");
        mydialog1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        mydialog1.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });


        gui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validData(hoten, cmnd)) {
                    //Ktra bằng cấp
                    if (trungcap.isChecked()==false&& caodang.isChecked()==false&& daihoc.isChecked()==false) {
                        AlertDialog dialog = mydialog.create();
                        dialog.show();
                    }

                    //Kiểm tra sở thích
                    if (docbao.isChecked() == false && doccode.isChecked() == false && docsach.isChecked() == false) {
                        AlertDialog dialog = mydialog1.create();
                        dialog.show();
                    }
                    Toast.makeText(MainActivity.this, "Gửi thông tin thành công", Toast.LENGTH_SHORT).show();
                    recreate();
                }


            }
        });
    }

    private boolean validData(EditText hoten, EditText cmnd) {
        String ten = hoten.getText().toString().trim();
        String cm = cmnd.getText().toString().trim();
        AlertDialog.Builder canhbao = new AlertDialog.Builder(this);
        canhbao.setTitle("Cảnh báo!!!");
        canhbao.setMessage("Bạn chưa nhập đầy đủ thông tin");
        canhbao.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                hoten.findFocus();
                dialogInterface.cancel();
            }
        });
        canhbao.setNegativeButton("Kết thúc chương trình", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Thoát khỏi chương trình", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        if (!(ten.length() > 0 && ten.matches("[a-zA-Z' ]+"))) {
            AlertDialog dialog = canhbao.create();
            dialog.show();
            hoten.requestFocus();
            return false;
        }
        if (!(cm.length() > 0 && cm.matches("[0-9]{9}"))) {
            AlertDialog dialog = canhbao.create();
            dialog.show();
            cmnd.requestFocus();
            return false;
        }
        return true;
    }

}
