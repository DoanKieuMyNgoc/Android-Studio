package vn.com.ngoc.app_1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "SanPham.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

//        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS
//        phong_ban(id INTEGER PRIMARY KEY, name TEXT)");
//        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS
//        nhan_vien(id INTEGER PRIMARY KEY, name TEXT, phong_ban_id INTEGER NOT NULL," +
//                " CONSTRAINT fk_phong_ban FOREIGN KEY(phong_ban_id) REFERENCES phong_ban(id) ON DELETE CASCADE ON UPDATE CASCADE)");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS LoaiSanPham(id Integer primary key," +
                "tenLoaiSP text)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS SanPham(id Integer primary key," +
                "gia REAL, chatluong text,loaiSanPham_id Integer NOT NULL CONSTRAINT id references LoaiSanPham(id)ON DELETE CASCADE ON UPDATE CASCADE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists LoaiSanPham");
        sqLiteDatabase.execSQL("drop table if exists SanPham");
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
        super.onConfigure(db);
    }
}
