package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "MyDB1", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Authors(id Interger primary key, name text,address text, email text)");
        sqLiteDatabase.execSQL("CREATE TABLE Books(" +
                "id_book Integer primary key," +
                "title text," +
                "id_author Integer not null constraint id_author references " +
                "Authors(id) On Delete Cascade ON UPDATE CASCADE)");
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
        super.onConfigure(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Authors");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Books");
        onCreate(sqLiteDatabase);
    }
    //them- xoa-sua
    //Them Author
    public int insertAuthor(Author author){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("id", author.getIdAuthor());
        values.put("name", author.getName());
        values.put("address", author.getAddress());
        values.put("email", author.getEmail());
        int r= (int) db.insert("Authors",null, values);
        close();
        return r;
    }
    //Thêm Book
    public int insertBook(Book book){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("id_book", book.getId_book());
        values.put("title", book.getTitle());
        values.put("id_author", book.getId_author());
        int r= (int) db.insert("Books",null, values);
        close();
        return r;
    }



    //Lấy ds author
    public ArrayList<Author> getAllAuthor(){
        ArrayList<Author> list= new ArrayList<>();
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery("select * from Authors", null);
        if(cursor != null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                list.add(new Author(cursor.getInt(0),cursor.getString(1),
                        cursor.getString(2), cursor.getString(3)));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return list;
    }
    //Lấy ds book
    public ArrayList<Book> getAllBook(){
        ArrayList<Book> list= new ArrayList<>();
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery("select * from Books", null);
        if(cursor != null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                list.add(new Book(cursor.getInt(0),cursor.getString(1),
                        cursor.getInt(2)));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return list;
    }


    //Lấy Book vào list GridView
    public ArrayList<Book> getBook(int id){
        ArrayList<Book> list= new ArrayList<>();
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery("select * from Authors where idAuthor=" +id, null);
        if(cursor != null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                list.add(new Book(cursor.getInt(0),cursor.getString(1),
                        cursor.getInt(2)));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return list;
    }


    //lay author vao list
//    public ArrayList<Author> getIDAuthor(int id){
//        ArrayList<Author> list= new ArrayList<>();
//        SQLiteDatabase db= this.getReadableDatabase();
//        Cursor cursor= db.rawQuery("select * from Authors where idAuthor=" +id, null);
//        if(cursor != null){
//            cursor.moveToFirst();
//            while (!cursor.isAfterLast()){
//                list.add(new Author(cursor.getInt(0),cursor.getString(1),
//                        cursor.getString(2), cursor.getString(3)));
//                cursor.moveToNext();
//            }
//            cursor.close();
//            db.close();
//        }
//        return list;
//    }
    public Author getIDAuthor(int id){
        Author au= new Author();
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery("select * from Authors where idAuthor=" +id, null);
        if(cursor != null){
            cursor.moveToFirst();
               au.setIdAuthor(cursor.getInt(0));
               au.setName(cursor.getString(1));
               au.setAddress(cursor.getString(2));
               au.setEmail(cursor.getString(3));
            cursor.close();
            db.close();
        }
        return au;
    }


}
