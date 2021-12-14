package com.example.trabalho;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "produtos";
    private static final int DATABASE_VERSION = 1;
    private final String CREATE_TABLE_PRODUTOS = "CREATE TABLE produtos(" +
            "id integer primary key autoincrement,"  +
            "nome text," +
            "categoria  text," +
            "preco integer," +
            "descricao text)";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PRODUTOS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS produtos");
        onCreate(db);

    }

    public long inserir(ContentValues cv){
        SQLiteDatabase db = this.getReadableDatabase();
        long id = db.insert("produtos", null, cv);
        return id;

    }
}
