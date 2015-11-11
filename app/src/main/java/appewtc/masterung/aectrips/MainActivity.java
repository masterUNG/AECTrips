package appewtc.masterung.aectrips;

import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private CountryTABLE objCountryTABLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create & Connected Database
        objCountryTABLE = new CountryTABLE(this);

        //Tester Add Value
        //testerAddValue();

        //Delete All Data
        deleteAllData();

        //Synchronize JSON SQLite
        synJSONtoSQLite();

    }   // Main Method

    private void synJSONtoSQLite() {

        //SetUp New Policy
        StrictMode.ThreadPolicy newPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(newPolicy);

        //1. Create InputStream
        InputStream objInputStream = null;
        String strJSON = null;

        try {

            HttpClient objHttpClient = new DefaultHttpClient();
            HttpPost objHttpPost = new HttpPost("http://swiftcodingthai.com/aec/php_get_data_country.php");
            HttpResponse objHttpResponse = objHttpClient.execute(objHttpPost);
            HttpEntity objHttpEntity = objHttpResponse.getEntity();
            objInputStream = objHttpEntity.getContent();

        } catch (Exception e) {
            Log.d("aec", "InputStream ==> " + e.toString());
        }

        //2. Create JSON String
        try {

            BufferedReader objBufferedReader = new BufferedReader(new InputStreamReader(objInputStream, "UTF-8"));
            StringBuilder objStringBuilder = new StringBuilder();
            String strLine = null;

            while ((strLine = objBufferedReader.readLine()) != null ) {
                objStringBuilder.append(strLine);
            }   // while

            objInputStream.close();
            strJSON = objStringBuilder.toString();

        } catch (Exception e) {
            Log.d("aec", "JSON String ==> " + e.toString());
        }

        //3. Update to SQLite
        try {

            JSONArray objJsonArray = new JSONArray(strJSON);

            for (int i = 0; i < objJsonArray.length(); i++) {

                JSONObject object = objJsonArray.getJSONObject(i);
                String strCountry = object.getString("Country");
                String strName = object.getString("Name");
                String strDescription = object.getString("Description");
                String strLat = object.getString("Lat");
                String strLng = object.getString("Lng");
                String strPicture = object.getString("Picture");
                objCountryTABLE.addNewValue(strCountry, strName, strDescription, strLat, strLng, strPicture);

            }   // for

        } catch (Exception e) {
            Log.d("aec", "Update ==> " + e.toString());
        }



    }   // synJSONtoSQLite

    private void deleteAllData() {
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase("AEC.db", MODE_PRIVATE, null);
        objSqLiteDatabase.delete("countryTABLE", null, null);
    }

    private void testerAddValue() {
        objCountryTABLE.addNewValue("testCountry", "testName", "testDescription", "testLat", "testLng", "testPicture");
    }

}   // Main Class
