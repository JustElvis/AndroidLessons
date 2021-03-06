package ru.startandroid.develop.p0621alertdialogitems;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Slav on 16.11.2016.
 */

public class DB {
    private static final String DB_NAME = "muDB";
    private static final int DB_VERSION = 1;
    private static final String DB_TABLE = "myTab";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TEXT = "txt";
    private static final String DB_CREATE =
            "create table " + DB_TABLE + "(" +
                    COLUMN_ID + " integer primary key, " +
                    COLUMN_TEXT + " text" + ");";

    private final Context mCtx;

    private SQLiteDatabase mDB;
    private DBHelper mDBHelper;


    public DB (Context context){
        mCtx = context;
    }
    public void open(){
        mDBHelper = new DBHelper(mCtx, DB_NAME, null, DB_VERSION);
        mDB = mDBHelper.getWritableDatabase();
    }
    public void close(){
        if (mDBHelper != null) mDBHelper.close();
    }
    public Cursor getAllData(){
        return mDB.query(DB_TABLE, null, null,null,null,null,null);
    }

    public void myCkeckRec (int id, String txt){
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TEXT, txt);
        mDB.update(DB_TABLE, cv, COLUMN_ID + " = " + id, null);
    }

    private class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DB_CREATE);
            ContentValues cv = new ContentValues();
            for (int i = 1; i < 5 ; i++){
                cv.put(COLUMN_ID, i);
                cv.put(COLUMN_TEXT, "sometext " + i);
                mDB.insert(DB_TABLE, null, cv);
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
