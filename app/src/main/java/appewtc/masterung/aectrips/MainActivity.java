package appewtc.masterung.aectrips;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private CountryTABLE objCountryTABLE;
    private ImageView thaiImageView, laoImageView, vietnamImageView, singaporeImageView,
            phillipinImageView, myanmaImageView, indodisiaImageView, kumpodiaImageView, blueniImageView,
            mayasiaImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        bindWidget();

        //Create & Connected Database
        objCountryTABLE = new CountryTABLE(this);

        //Tester Add Value
        //testerAddValue();

        //Delete All Data
        deleteAllData();

        //Synchronize JSON SQLite
        synJSONtoSQLite();

        //ImageView Controller
        imageViewController();

    }   // Main Method

    private void imageViewController() {
        thaiImageView.setOnClickListener(this);
        laoImageView.setOnClickListener(this);
        vietnamImageView.setOnClickListener(this);
        singaporeImageView.setOnClickListener(this);
        phillipinImageView.setOnClickListener(this);
        myanmaImageView.setOnClickListener(this);
        indodisiaImageView.setOnClickListener(this);
        kumpodiaImageView.setOnClickListener(this);
        blueniImageView.setOnClickListener(this);
        mayasiaImageView.setOnClickListener(this);
    }

    private void bindWidget() {

        thaiImageView = (ImageView) findViewById(R.id.imageView);
        laoImageView = (ImageView) findViewById(R.id.imageView2);
        vietnamImageView = (ImageView) findViewById(R.id.imageView3);
        singaporeImageView = (ImageView) findViewById(R.id.imageView4);
        phillipinImageView = (ImageView) findViewById(R.id.imageView5);
        myanmaImageView = (ImageView) findViewById(R.id.imageView6);
        indodisiaImageView = (ImageView) findViewById(R.id.imageView7);
        kumpodiaImageView = (ImageView) findViewById(R.id.imageView8);
        blueniImageView = (ImageView) findViewById(R.id.imageView9);
        mayasiaImageView = (ImageView) findViewById(R.id.imageView10);

    }

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

            while ((strLine = objBufferedReader.readLine()) != null) {
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

    @Override
    public void onClick(View view) {

        int intChoose = 0;

        switch (view.getId()) {

            case R.id.imageView:
                intChoose = 0;
                break;
            case R.id.imageView2:
                intChoose = 1;
                break;
            case R.id.imageView3:
                intChoose = 2;
                break;
            case R.id.imageView4:
                intChoose = 3;
                break;
            case R.id.imageView5:
                intChoose = 4;
                break;
            case R.id.imageView6:
                intChoose = 5;
                break;
            case R.id.imageView7:
                intChoose = 6;
                break;
            case R.id.imageView8:
                intChoose = 7;
                break;
            case R.id.imageView9:
                intChoose = 8;
                break;
            case R.id.imageView10:
                intChoose = 9;
                break;

        }   // switch

        showMyDialog(intChoose);

    }   // onClick

    private void showMyDialog(int intChoose) {

        int[] iconInts = new int[10];
        iconInts[0] = R.drawable.thailand48;
        iconInts[1] = R.drawable.laos48;
        iconInts[2] = R.drawable.vietnam48;
        iconInts[3] = R.drawable.singapore48;
        iconInts[4] = R.drawable.philippines48;
        iconInts[5] = R.drawable.myanmar48;
        iconInts[6] = R.drawable.indonesia48;
        iconInts[7] = R.drawable.cambodia48;
        iconInts[8] = R.drawable.brunei48;
        iconInts[9] = R.drawable.malaysia48;

        String[] titleStrings = new String[10];
        titleStrings[0] = getString(R.string.thai);
        titleStrings[1] = getString(R.string.lao);
        titleStrings[2] = getString(R.string.vietnam);
        titleStrings[3] = getString(R.string.singapore);
        titleStrings[4] = getString(R.string.philippines);
        titleStrings[5] = getString(R.string.myanmar);
        titleStrings[6] = getString(R.string.indonesia);
        titleStrings[7] = getString(R.string.cambodia);
        titleStrings[8] = getString(R.string.brunei);
        titleStrings[9] = getString(R.string.malaysia);

        String[] detailStrings = getResources().getStringArray(R.array.detail_shot_country);


        AlertDialog.Builder objBuilder = new AlertDialog.Builder(this);
        objBuilder.setIcon(iconInts[intChoose]);
        objBuilder.setTitle(titleStrings[intChoose]);

        objBuilder.setMessage(detailStrings[intChoose]);

        objBuilder.setCancelable(false);
        objBuilder.setPositiveButton("การสื่อสาร", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        objBuilder.setNegativeButton("การเดินทาง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        objBuilder.show();


    }

}   // Main Class
