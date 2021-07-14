package com.example.freakingmath.DataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper{
    public Database(@Nullable Context context, @Nullable String name, @Nullable CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void QueryData(String sql)
    {
        SQLiteDatabase cosodulieu = getWritableDatabase();
        cosodulieu.execSQL(sql);
    }
    public Cursor GetData(String sql)
    {
        SQLiteDatabase cosodulieu = getReadableDatabase();
        return cosodulieu.rawQuery(sql,null);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void Create(Context context)
    {
        Database database = new Database(context,"FreakingMath.sqlite",null,1);
        try {
            database.GetData("SELECT * FROM Diemcao");
        }catch (Exception e)
        {
            database.QueryData("CREATE TABLE IF NOT EXISTS DiemCao(id VARCHAR PRIMARY KEY,DE INTEGER, TRUNGBINH INTEGER, KHO INTEGER)");
            database.QueryData("INSERT INTO Diemcao VALUES('TOF',0,0,0)");
            database.QueryData("INSERT INTO Diemcao VALUES('phepcong',0,0,0)");
            database.QueryData("INSERT INTO Diemcao VALUES('pheptru',0,0,0)");
            database.QueryData("INSERT INTO Diemcao VALUES('phepnhan',0,0,0)");
            database.QueryData("INSERT INTO Diemcao VALUES('phepchia',0,0,0)");
            database.QueryData("INSERT INTO Diemcao VALUES('all',0,0,0)");
            database.QueryData("INSERT INTO Diemcao VALUES('2NC',0,0,0)");
        }
        database.close();
    }
    public int getScore(Context context,String table, String id, int column){
        Database database = new Database(context,"FreakingMath.sqlite",null,1);
        Cursor cursor = database.GetData("SELECT* FROM "+table);
        while (cursor.moveToNext())
        {
          if(cursor.getString(0).equals(id))break;
        }
        database.close();
        return cursor.getInt(column);
    }
    public void setScore(Context context,String table, String id,String column, int scores)
    {
        Database database = new Database(context,"FreakingMath.sqlite",null,1);
        Cursor cursor = database.GetData("SELECT* FROM "+table);
        database.QueryData("UPDATE "+table+" SET "+column+"="+scores+" WHERE id='"+id+"'");
        database.close(); cursor.close();
    }
}
