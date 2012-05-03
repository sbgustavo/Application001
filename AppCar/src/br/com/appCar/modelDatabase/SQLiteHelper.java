package br.com.appCar.modelDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper {
    
    /** Hold the Database's name */
    private static final String DB_NAME = "AppCar";

    /** Hold the Database's version */
    private static final int DB_VERSION = 1;    
    
    private String scriptCreate;
    private String scriptDelete;
    
    /**
     * Class' Constructor
     * 
     * @param ctx
     * @param nomeBd
     * @param versaoBanco
     * @param scriptCreate
     * @param scriptDelete
     */
    public SQLiteHelper(Context ctx, String scriptCreate, String scriptDelete) {

        super(ctx, DB_NAME, null, DB_VERSION);
        this.scriptCreate = scriptCreate;
        this.scriptDelete = scriptDelete;
    }

    /**
     * Create the Database
     */
    public void onCreate(SQLiteDatabase db) {
        Log.d("log", "creating DB");
        db.execSQL(scriptCreate);
    }

    /**
     * Upgrade the database if necessary
     */
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("log", "upgrading DB");
        db.execSQL(scriptDelete);
        onCreate(db);
    }
}