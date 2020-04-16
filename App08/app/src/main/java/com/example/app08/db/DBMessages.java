package com.example.app08.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ListAdapter;

import com.example.app08.model.Message;

import java.util.ArrayList;
import java.util.List;

public class DBMessages {

    private static MessageDatabaseHelper helper;

    public static void init(Context context){
        helper=new MessageDatabaseHelper(context);
    }
    public static List<Message> loadAllMessages(){
        SQLiteDatabase db =helper.getReadableDatabase();
        Cursor cursor = db.query(
                Constants.DB_TABLE_NAME,   // String the table to query
                null,null,null,null,null,null
        );
        cursor.moveToFirst();

        List<Message> list=new ArrayList<>();
        while(!cursor.isAfterLast()){
            long id =cursor.getLong(0);
            String msg=cursor.getString(2);
            long datetime=cursor.getLong(1);
            Message m = new Message();
            m.setMensaje(msg);
            m.setIdMensaje(id);
            m.setDateInMillis(datetime);
            list.add(m);
            cursor.moveToNext();
        }
        return list;
    }

    public static void saveMessage(Message m) {
        SQLiteDatabase db =helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.DB_TABLE_FIELD_MESSAGE, m.getMensaje());
        values.put(Constants.DB_TABLE_FIELD_TIME,m.getDateInMillis());
        long insertId = db.insert(Constants.DB_TABLE_NAME, null, values);
        Log.i("DBMessages","Mensaje creado");
    }
}
