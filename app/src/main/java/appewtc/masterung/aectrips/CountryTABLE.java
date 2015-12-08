package appewtc.masterung.aectrips;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    //Search Name
    public String[] searchName(String strName) {

        try {

            String[] strResult = null;
            Cursor objCursor = readSqLiteDatabase.query(COUNTRY_TABLE,
                    new String[]{COLUMN_ID, COLUMN_COUNTRY, COLUMN_NAME, COLUMN_DESCRIPTION, COLUMN_LAT, COLUMN_LNG, COLUMN_PICTURE},
                    COLUMN_NAME + "=?",
                    new String[]{String.valueOf(strName)},
                    null, null, null, null);
            if (objCursor != null) {

                if (objCursor.moveToFirst()) {
                    strResult = new String[objCursor.getColumnCount()];
                    strResult[0] = objCursor.getString(0);
                    strResult[1] = objCursor.getString(1);
                    strResult[2] = objCursor.getString(2);
                    strResult[3] = objCursor.getString(3);
                    strResult[4] = objCursor.getString(4);
                    strResult[5] = objCursor.getString(5);
                    strResult[6] = objCursor.getString(6);
                }

            }   // if

            objCursor.close();
            return strResult;

        } catch (Exception e) {
            return null;
        }
    }


    //Read All Data
    public String[] readAllCountry(int intColumn) {

        String[] strResult = null;
        Cursor objCursor = readSqLiteDatabase.query(COUNTRY_TABLE,
                new String[]{COLUMN_ID,
                        COLUMN_COUNTRY,
                        COLUMN_NAME,
                        COLUMN_DESCRIPTION,
                        COLUMN_LAT,
                        COLUMN_LNG,
                        COLUMN_PICTURE},
                null, null, null, null, null);

        if (objCursor != null) {
            strResult = new String[objCursor.getCount()];
            objCursor.moveToFirst();
            for (int i = 0; i < objCursor.getCount(); i++) {

                switch (intColumn) {
                    case 1:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_COUNTRY));
                        break;
                    case 2:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_NAME));
                        break;
                    case 3:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_DESCRIPTION));
                        break;
                    case 4:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_LAT));
                        break;
                    case 5:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_LNG));
                        break;
                    case 6:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_PICTURE));
                        break;

                }   //switch
                objCursor.moveToNext();
            } // for
        }   //if
        objCursor.close();
        return strResult;
    }


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
