package appewtc.masterung.aectrips;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by masterUNG on 10/14/15 AD.
 */
public class MyOpenHelper extends SQLiteOpenHelper{

    //Explicit
    private static final String DATABASE_NAME = "AEC.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_COUNTRY_TABLE = "create table countryTABLE (" +
            "_id integer primary key, " +
            "Country text, " +
            "Name text, " +
            "Description text, " +
            "Lat text, " +
            "Lng text, " +
            "Picture text);";


    public MyOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }   // Constructor

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_COUNTRY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}   // Main Class นี่คือ คลาสหลัก
