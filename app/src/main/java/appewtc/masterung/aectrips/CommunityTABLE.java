package appewtc.masterung.aectrips;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterUNG on 11/18/15 AD.
 */
public class CommunityTABLE {

    //Explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String COMMUNITY_TABLE = "communityTABLE";
    public static final String COLUMN_ID_COMMUNITY = "_id";
    public static final String COLUMN_THWORD = "THword";
    public static final String COLUMN_THSOUND = "THsound";
    public static final String COLUMN_LAWORD = "LAword";
    public static final String COLUMN_LASOUND = "LAsound";
    public static final String COLUMN_VNWORD = "VNword";
    public static final String COLUMN_VNSOUND = "VNsound";
    public static final String COLUMN_SGWORD = "SGword";
    public static final String COLUMN_SGSOUND = "SGsound";
    public static final String COLUMN_PHWORD = "PHword";
    public static final String COLUMN_PHSOUND = "PHsound";
    public static final String COLUMN_MMWORD = "MMword";
    public static final String COLUMN_MMSOUND = "MMsound";
    public static final String COLUMN_IDWORD = "IDword";
    public static final String COLUMN_IDSOUND = "IDsound";
    public static final String COLUMN_CBWORD = "CBword";
    public static final String COLUMN_CBSOUND = "CBsound";
    public static final String COLUMN_BNWORD = "BNword";
    public static final String COLUMN_BNSOUND = "BNsound";
    public static final String COLUMN_MYWORD = "MYword";
    public static final String COLUMN_MYSOUND = "MYsound";

    public CommunityTABLE(Context context) {

        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    }   // Constructor

    // Read All Data
    public String[] readAllData(int intColunm) {

        String[] strResult = null;

        Cursor objCursor = readSqLiteDatabase.query(COMMUNITY_TABLE,
                new String[]{COLUMN_ID_COMMUNITY, COLUMN_THWORD, COLUMN_THSOUND,
                        COLUMN_LAWORD, COLUMN_LASOUND, COLUMN_VNWORD, COLUMN_VNSOUND,
                        COLUMN_SGWORD, COLUMN_SGSOUND, COLUMN_PHWORD, COLUMN_PHSOUND,
                        COLUMN_MMWORD, COLUMN_MMSOUND, COLUMN_IDWORD, COLUMN_IDSOUND,
                        COLUMN_CBWORD, COLUMN_CBSOUND, COLUMN_BNWORD, COLUMN_BNSOUND,
                        COLUMN_MYWORD, COLUMN_MYSOUND},
                null, null, null, null, null);

        if (objCursor != null) {

            strResult = new String[objCursor.getCount()];
            objCursor.moveToFirst();

            for (int i = 0; i < objCursor.getCount(); i++) {

                switch (intColunm) {
                    case 1:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_THWORD));
                        break;
                    case 2:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_THSOUND));
                        break;
                    case 3:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_LAWORD));
                        break;
                    case 4:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_LASOUND));
                        break;
                    case 5:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_VNWORD));
                        break;
                    case 6:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_VNSOUND));
                        break;
                    case 7:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_SGWORD));
                        break;
                    case 8:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_SGSOUND));
                        break;
                    case 9:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_PHWORD));
                        break;
                    case 10:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_PHSOUND));
                        break;
                    case 11:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_MMWORD));
                        break;
                    case 12:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_MMSOUND));
                        break;
                    case 13:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_IDWORD));
                        break;
                    case 14:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_IDSOUND));
                        break;
                    case 15:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_CBWORD));
                        break;
                    case 16:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_CBSOUND));
                        break;
                    case 17:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_BNWORD));
                        break;
                    case 18:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_BNSOUND));
                        break;
                    case 19:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_MYWORD));
                        break;
                    case 20:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_MYSOUND));
                        break;
                }   // switch

                objCursor.moveToNext();
            }   // for

        }   // if


        return strResult;
    }


    public long addCommunity(String thWord, String thSound,
                             String laWord, String laSound,
                             String vnWord, String vnSound,
                             String sgWord, String sgSound,
                             String phWord, String phSound,
                             String mmWord, String mmSound,
                             String idWord, String idSound,
                             String cbWord, String cbSound,
                             String bnWord, String bnSound,
                             String myWord, String mySound) {

        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_THWORD, thWord);
        objContentValues.put(COLUMN_THSOUND, thSound);
        objContentValues.put(COLUMN_LAWORD, laWord);
        objContentValues.put(COLUMN_LASOUND, laSound);
        objContentValues.put(COLUMN_VNWORD, vnWord);
        objContentValues.put(COLUMN_VNSOUND, vnSound);
        objContentValues.put(COLUMN_SGWORD, sgWord);
        objContentValues.put(COLUMN_SGSOUND, sgSound);
        objContentValues.put(COLUMN_PHWORD, phWord);
        objContentValues.put(COLUMN_PHSOUND, phSound);
        objContentValues.put(COLUMN_MMWORD, mmWord);
        objContentValues.put(COLUMN_MMSOUND, mmSound);
        objContentValues.put(COLUMN_IDWORD, idWord);
        objContentValues.put(COLUMN_IDSOUND, idSound);
        objContentValues.put(COLUMN_CBWORD, cbWord);
        objContentValues.put(COLUMN_CBSOUND, cbSound);
        objContentValues.put(COLUMN_BNWORD, bnWord);
        objContentValues.put(COLUMN_BNSOUND, bnSound);
        objContentValues.put(COLUMN_MYWORD, myWord);
        objContentValues.put(COLUMN_MYSOUND, mySound);


        return writeSqLiteDatabase.insert(COMMUNITY_TABLE, null, objContentValues);
    }

}   // Main Class
