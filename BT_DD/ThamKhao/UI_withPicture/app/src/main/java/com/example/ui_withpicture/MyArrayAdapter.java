package com.example.ui_withpicture;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<NhanVien> {
        //Màn hình sử dụng layout này
        Activity context;
        //Layout cho từng dòng muốn hiển thị
        int resource;
        //Danh sách dữ liệu muốn hiển thị lên màn hình
    @NonNull List<NhanVien> objects;

    public MyArrayAdapter(@NonNull Activity context, int resource, @NonNull List<NhanVien> objects) {
        super(context, resource, objects);
        this.context= context;
        this.resource= resource;
        this.objects= objects;

    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Đây là 1 lớp để build layout bình thường
        LayoutInflater inflater= this.context.getLayoutInflater();
        //this.resource chính là item.xml, truyền vào khi gọi MyArrayAdapter
        convertView = inflater.inflate(this.resource, null);

        ImageView imgItem=convertView.findViewById(R.id.imageView);
        TextView profile= convertView.findViewById(R.id.profile);


        NhanVien nhanVien= this.objects.get(position);

        if(nhanVien.getGioitinh().equals("Nam")){
            imgItem.setImageResource(R.drawable.male);
        }
        else{
            imgItem.setImageResource(R.drawable.female);
        }

        profile.setText("  " +nhanVien.getMaso() + "\n  " + nhanVien.getHoten() + "\n  "+ nhanVien.getGioitinh() + "\n  "+
                nhanVien.getDonvi());

        return convertView;
    }

    //    public View getView(int position, View convertView, ViewGroup parent){
//            LayoutInflater inflater= context.getLayoutInflater();
//            convertView= inflater.inflate(layoutId, null);
//
//            if(myArray.size() > 0 && position >= 0){
//                final TextView txtDisplay= (TextView) convertView.findViewById(R.id.tv_item);
//                final NhanVien nv= myArray.get(position);
//
//                txtDisplay.setText(nv.toString());
//                final ImageView imgItem=(ImageView) convertView.findViewById(R.id.img_item);
//                if(nv.getGioitinh().equals("Nam")){
//                    imgItem.setImageResource(R.drawable.man);
//                }else {
//                    imgItem.setImageResource(R.drawable.woman);
//                }
//
//            }
//            return convertView;
//        }


}
