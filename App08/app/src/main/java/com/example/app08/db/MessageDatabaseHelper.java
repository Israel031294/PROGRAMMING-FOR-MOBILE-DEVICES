package com.example.app08.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MessageDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="messages";
    private static final int DATABASE_VERSION = 1;

    public MessageDatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // crear la estructura y datos iniciales de la base de datos
        db.execSQL(Constants.DB_CREATE_TABLE_MESSAGE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //ejecutar los scripts necesarios  (SQL) para actualizar
        //de la version vieja (oldVersion) a la nueva (newVersion)}
        if(oldVersion!=1){
            db.execSQL("");
        }
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
        // sentencias necesarias para bajar la version de la db
    }
}
