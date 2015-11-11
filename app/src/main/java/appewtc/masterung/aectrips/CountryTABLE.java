package appewtc.masterung.aectrips;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterUNG on 10/14/15 AD.
 */
public class CountryTABLE {

    //Explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String COUNTRY_TABLE = "countryTABLE";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_COUNTRY = "Country";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_DESCRIPTION = "Description";
    public static final String COLUMN_LAT = "Lat";
    public static final String COLUMN_LNG = "Lng";
    public static final String COLUMN_PICTURE = "Picture";


    public CountryTABLE(Context context) {

        //Create & Connected Database
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    }   // Constructor

    //Add New Value to countryTABLE
    public long addNewValue(String strCountry, String strName, String strDescription, String strLat, String strLng, String strPicture) {

        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_COUNTRY, strCountry);
        objContentValues.put(COLUMN_NAME, strName);
        objContentValues.put(COLUMN_DESCRIPTION, strDescription);
        objContentValues.put(COLUMN_LAT, strLat);
        objContentValues.put(COLUMN_LNG, strLng);
        objContentValues.put(COLUMN_PICTURE, strPicture);

        return writeSqLiteDatabase.insert(COUNTRY_TABLE, null, objContentValues);
    }


}   // Main Class
