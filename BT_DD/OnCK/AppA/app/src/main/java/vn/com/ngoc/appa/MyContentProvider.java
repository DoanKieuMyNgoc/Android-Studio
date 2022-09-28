package vn.com.ngoc.appa;

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
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;

public class MyContentProvider extends ContentProvider {

    static final String AUTHORITY = "vn.com.ngoc.appa";
    static final String PHONGBAN_TABLE = "PHONGBAN";
    static final String URL = "content://" + AUTHORITY + "/" + PHONGBAN_TABLE;
    static final Uri CONTENT_URI = Uri.parse(URL);

    static final int ONE = 1;
    static final int ALL = 2;
    static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, PHONGBAN_TABLE, ALL);
        uriMatcher.addURI(AUTHORITY, PHONGBAN_TABLE + "#", ONE);

    }

    private SQLiteDatabase db;
    private static HashMap<String, String> PROJECTION_MAP;

    public MyContentProvider() {
    }

    @Override
    public boolean onCreate() {
        Context context = getContext();
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
        if (db == null)
            return true;
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection,
                        @Nullable String selection, @Nullable String[] selectionArgs,
                        @Nullable String sortOrder) {

        SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();
        sqLiteQueryBuilder.setTables(PHONGBAN_TABLE);
        switch (uriMatcher.match(uri)) {
            case ALL:
                sqLiteQueryBuilder.setProjectionMap(PROJECTION_MAP);
                break;
            case ONE:
                sqLiteQueryBuilder.appendWhere("id" + "=" + uri.getPathSegments().get(0));
        }
        if (sortOrder == null || sortOrder == "")
            sortOrder = "tenPB";
        Cursor cursor = sqLiteQueryBuilder.query(db, projection, selection, selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
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
        long number_row = db.insert(PHONGBAN_TABLE, "", contentValues);
        if (number_row > 0) {
            Uri uri1 = ContentUris.withAppendedId(CONTENT_URI, number_row);
            getContext().getContentResolver().notifyChange(uri1, null);
            return uri1;
        }
        throw new SQLException("file to add a record into" + uri);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int count = 0;
        int uri_Matcher = uriMatcher.match(uri);
        switch (uri_Matcher) {
            case ALL:
                count = db.delete(PHONGBAN_TABLE, selection, selectionArgs);
                break;
            case ONE:
                String id_PB= uri.getPathSegments().get(0);
                count= db.delete(PHONGBAN_TABLE,"id="+id_PB,selectionArgs);
                break;
        }
        getContext().getContentResolver().notifyChange(uri,null);
        return count;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String selection, @Nullable String[] selectionArgs) {
        int count = 0;
        int uri_Matcher = uriMatcher.match(uri);
        switch (uri_Matcher) {
            case ALL:
                count = db.update(PHONGBAN_TABLE, contentValues,selection, selectionArgs);
                break;
            case ONE:
                String id_PB= uri.getPathSegments().get(0);
                count= db.update(PHONGBAN_TABLE,contentValues,"id="+id_PB,selectionArgs);
                break;
        }
        getContext().getContentResolver().notifyChange(uri,null);
        return count;
    }
}
