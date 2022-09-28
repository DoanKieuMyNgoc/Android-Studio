package vn.com.ngoc.app_1;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;

public class MyContentProvider extends ContentProvider {
    public static String AUTHORITY = "vn.com.ngoc.app_1";
    public static String TABLE_LSP = "LoaiSanPham";
    public static String TABLE_SP = "SanPham";

    public static String URL_LSP = "content://" + AUTHORITY + "/" + TABLE_LSP;
    public static String URL_SP = "content://" + AUTHORITY + "/" + TABLE_SP;

    public static final Uri CONTENT_URI_LSP = Uri.parse(URL_LSP);
    public static final Uri CONTENT_URI_SP = Uri.parse(URL_SP);

    public static final int LSP_ONE = 111;
    public static final int LSP_ALL = 222;

    public static final int SP_ONE = 11;
    public static final int SP_ALL = 22;

    public static UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, TABLE_LSP, LSP_ALL);
        uriMatcher.addURI(AUTHORITY, TABLE_LSP + "/#", LSP_ONE);


        uriMatcher.addURI(AUTHORITY, TABLE_SP, SP_ALL);
        uriMatcher.addURI(AUTHORITY, TABLE_SP + "/#", SP_ONE);
    }

    private SQLiteDatabase db;
    private static HashMap<String, String> PROJECTION_MAP;

    @Override
    public boolean onCreate() {
        Context context = getContext();
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
        if (db == null)
            return false;
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection,
                        @Nullable String selection, @Nullable String[] selectionArgs,
                        @Nullable String sortOrder) {
        SQLiteQueryBuilder sqLiteQueryBuilder = null;
        int uri_matcher = uriMatcher.match(uri);
        switch (uri_matcher) {
            case LSP_ALL:
                sqLiteQueryBuilder = new SQLiteQueryBuilder();
                sqLiteQueryBuilder.setTables(TABLE_LSP);
                sqLiteQueryBuilder.setProjectionMap(PROJECTION_MAP);
                break;
            case LSP_ONE:
                sqLiteQueryBuilder = new SQLiteQueryBuilder();
                sqLiteQueryBuilder.setTables(TABLE_LSP);
                sqLiteQueryBuilder.appendWhere("id="+uri.getPathSegments().get(1));
                break;
            case SP_ALL:
                sqLiteQueryBuilder = new SQLiteQueryBuilder();
                sqLiteQueryBuilder.setTables(TABLE_SP);
                sqLiteQueryBuilder.setProjectionMap(PROJECTION_MAP);
                break;
            case SP_ONE:
                sqLiteQueryBuilder = new SQLiteQueryBuilder();
                sqLiteQueryBuilder.setTables(TABLE_SP);
                sqLiteQueryBuilder.appendWhere("id="+uri.getPathSegments().get(1));
                break;
        }
        if (sortOrder==null|| sortOrder==""){
            sortOrder="id";
        }
        Cursor cursor= sqLiteQueryBuilder.query(db,projection,selection,selectionArgs,null,null,sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(),uri);


        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        long number_row = db.insert(TABLE_LSP, null, contentValues);
        if (number_row > 0) {
            Uri uri1 = ContentUris.withAppendedId(CONTENT_URI_LSP, number_row);
            getContext().getContentResolver().notifyChange(uri1, null);
            return uri1;
        }

        long number_row1 = db.insert(TABLE_SP, null, contentValues);
        if (number_row1 > 0) {
            Uri uri1 = ContentUris.withAppendedId(CONTENT_URI_SP, number_row1);
            getContext().getContentResolver().notifyChange(uri1, null);
            return uri1;
        }
        throw new SQLException("Not insert table");

    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int count= 0;
        int uri_matcher= uriMatcher.match(uri);
        switch (uri_matcher){
            case LSP_ALL:
                count= db.delete(TABLE_LSP,selection,selectionArgs);
                break;
            case LSP_ONE:
                String id_L= uri.getPathSegments().get(1);
                count= db.delete(TABLE_LSP,"id="+id_L,selectionArgs);
                break;
            case SP_ALL:
                count= db.delete(TABLE_SP,selection,selectionArgs);
                break;
            case SP_ONE:
                String id_SP= uri.getPathSegments().get(1);
                count= db.delete(TABLE_SP,"id="+id_SP,selectionArgs);
                break;
        }
        getContext().getContentResolver().notifyChange(uri,null);

        return count;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String selection, @Nullable String[] selectionArgs) {
        int count =0;
        int uri_Matcher= uriMatcher.match(uri);
        switch (uri_Matcher){
            case LSP_ALL:
                count= db.update(TABLE_LSP,contentValues,selection,selectionArgs);
                break;
            case LSP_ONE:
                String id= uri.getPathSegments().get(1);
                count= db.update(TABLE_LSP,contentValues,"id="+id,selectionArgs);
                break;
            case SP_ALL:
                count= db.update(TABLE_SP,contentValues,selection,selectionArgs);
                break;
            case SP_ONE:
                String id1= uri.getPathSegments().get(1);
                count= db.update(TABLE_SP,contentValues,"id="+id1,selectionArgs);
                break;
        }
        getContext().getContentResolver().notifyChange(uri,null);
        return count;
    }
}
