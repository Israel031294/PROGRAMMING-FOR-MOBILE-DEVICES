package com.example.app08.db;

public class Constants {
    public static final String DB_CREATE_TABLE_MESSAGE="CREATE TABLE message (\n" +
            "    _id INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
            "    timestamp INTEGER, \n" +
            "    msg TEXT\n" +
            ");";


    public static final String DB_TABLE_NAME="message";
    public static final String DB_TABLE_FIELD_TIME="timestamp";
    public static final String DB_TABLE_FIELD_MESSAGE="msg";

}
