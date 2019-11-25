package com.example.myapplication33;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.myapplication33.DatabaseContract.*;

import java.util.ArrayList;
import java.util.List;


public class DatabaseAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    public DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context){
        if (instance==null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.database = openHelper.getWritableDatabase();
    }
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public List<String> getImage(){
       List<String> list = new ArrayList<>();
        //byte[]data = null;
       String strQuery = "Select "+  PhysicVideoEntry.KEY_VIDEO+" from "
               + PhysicVideoEntry.TABLE_NAME; //+ " where "
              // + PhysicVideoEntry.KEY_IMAGE+" = ?";
       Cursor cursor=database.rawQuery(strQuery,null);
       cursor.moveToFirst();
       while (!cursor.isAfterLast()){
            list.add(cursor.getString(0));
            cursor.moveToNext();
       }
       return list;
    }
   public String getVideoName(byte [] image){
       String videoName="";
       String strQuery = "Select "+  PhysicVideoEntry.KEY_IMAGE+" from "
               + PhysicVideoEntry.TABLE_NAME+ " where "
               + PhysicVideoEntry.KEY_IMAGE+" = ?";
       /*Cursor cursor = database.rawQuery(strQuery,image);*/
      Cursor cursor = database.rawQueryWithFactory(new MyCursorFactory(image),strQuery,
              new String[]{},PhysicVideoEntry.TABLE_NAME);
       if (cursor.moveToFirst()){
           videoName=cursor.getString(0);
       }
       return videoName;
   }
}
