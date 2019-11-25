package com.example.myapplication33;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Build;

public class MyCursorFactory implements SQLiteDatabase.CursorFactory {
    private byte [] image;
    public MyCursorFactory(byte[] image){
        super();
        this.image = image;
    }
    @Override
    public Cursor newCursor(SQLiteDatabase sqLiteDatabase, SQLiteCursorDriver sqLiteCursorDriver,
                            String s, SQLiteQuery sqLiteQuery) {
        sqLiteQuery.bindBlob(1,image);
        return new SQLiteCursor(sqLiteCursorDriver,s,sqLiteQuery);
    }
}
