package structure.project.ajinkya.database;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import structure.project.ajinkya.common.LogMessage;
import structure.project.ajinkya.pojo.UserDetail;

/**
 * Created by Ajinkya on 6/4/17.
 */

public  class SQLiteBase
        extends SQLiteOpenHelper {
    public static String TAG = SQLiteBase.class.getName();

    private static final int DATABASE_VERSION = 1;


    // Database Name
    private static final String DATABASE_NAME = "ajinkya_demo";

    // Contacts table name
    public static final String TABLE_USER = "user";

    // Contacts Table Columns names
    private static final String KEY_ID = "_id";
    private static final String KEY_NAME = "name";

    Context mContext;

    static {
        File localFile = new File(Environment.getDataDirectory().toString() + "/data/ajinkya/databases");
        if ((!localFile.exists()) && (!localFile.mkdir())) {
            LogMessage.logMessage(TAG, "Failed creating the directory of databases.");
        }
    }


    public SQLiteBase(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;

    }


    public void getAllUserName() {
        String selectQuery = "SELECT  * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                LogMessage.logMessage(TAG, "Name: " + cursor.getString(cursor.getColumnIndex(KEY_NAME)) );
            } while (cursor.moveToNext());
        }
        db.close();
    }


    public void insertUserDetails(UserDetail userDetail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, userDetail.getName());

        String query = "INSERT INTO " + TABLE_USER + "(" + KEY_NAME +  ") VALUES ( '" +userDetail.getName()+ "')";

        LogMessage.logMessage(TAG, "query" + query);
        db.execSQL(query);
        db.close();
    }

    public List<String> getAllUsers() {

        LogMessage.logMessage(TAG, "getAllGroupsIds ");

        List<String> userNames = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                userNames.add(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            } while (cursor.moveToNext());
        }
        db.close();
        return userNames;
    }

    public void deleteAllUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER, null, null);
        db.close();
    }

    public void dropTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            LogMessage.logMessage(TAG, "onCreate..");
            String CREATE_SAVE_TRIP_TABLE = "CREATE TABLE " + TABLE_USER + "("
                    + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT)";
            db.execSQL(CREATE_SAVE_TRIP_TABLE);

        } catch (Exception e) {
            LogMessage.logMessage(TAG, "onCreate...Exception:" + e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        LogMessage.logMessage(TAG, "onUpgrade..");

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);

        onCreate(db);


    }
}
