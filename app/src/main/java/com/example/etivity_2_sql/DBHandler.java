// Assignment E-tivity 2 ED5042
// Oisin O'Sullivan 21304971


package com.example.etivity_2_sql;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "codedb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "mycode";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String CREATION_COL = "creation";
    private static final String DESCRIPTION_COL = "description";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + CREATION_COL + " YEAR,"
                + DESCRIPTION_COL + " TEXT)";

        db.execSQL(query);
    }

    public void addNewEntry(String codeName, String codeCreation, String codeDescription) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME_COL, codeName);
        values.put(CREATION_COL, codeCreation);
        values.put(DESCRIPTION_COL, codeDescription);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }
}
