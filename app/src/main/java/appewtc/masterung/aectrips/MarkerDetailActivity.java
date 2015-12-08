package appewtc.masterung.aectrips;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MarkerDetailActivity extends AppCompatActivity {

    //Explicit
    private TextView titleTextView, detailTextView,
            myLatTextView, myLngTextView, distantTextView;
    private String titleString, descriptionString, latString, lngString, pictureString;
    private ImageView markerImageView;
    private LocationManager objLocationManager;
    private Criteria objCriteria;
    private boolean gpsABoolean, networkABoolean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marker_detail);

        //Bind Widget
        bindWidget();

        //Get Location
        getLocation();

        //Get Value From SQLite
        getValueFromSQlite();



        //Show View
        showView();

    }   // Main Method

    @Override
    protected void onStart() {
        super.onStart();

        gpsABoolean = objLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!gpsABoolean) {

            networkABoolean = objLocationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!networkABoolean) {
                Intent objIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(objIntent);
            }

        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        afterResume();
    }

    private void afterResume() {

        objLocationManager.removeUpdates(objLocationListener);
        String strLat = "UnKnow";
        String strLng = "UnKnow";

        Location networkLocation = requestUpdateFromProvider(LocationManager.NETWORK_PROVIDER, "Not Connected Internet");
        if (networkLocation != null) {
            strLat = String.format("%.7f", networkLocation.getLatitude());
            strLng = String.format("%.7f", networkLocation.getLongitude());
        }

        Location gpsLocation = requestUpdateFromProvider(LocationManager.GPS_PROVIDER, "No Card GPS");
        if (gpsLocation != null) {
            strLat = String.format("%.7f", gpsLocation.getLatitude());
            strLng = String.format("%.7f", gpsLocation.getLongitude());
        }

        myLatTextView.setText(strLat);
        myLngTextView.setText(strLng);

    }   // afterResume

    @Override
    protected void onStop() {
        super.onStop();
        objLocationManager.removeUpdates(objLocationListener);
    }

    public Location requestUpdateFromProvider(final String strProvider, String strError) {

        Location objLocation = null;

        if (objLocationManager.isProviderEnabled(strProvider)) {

            objLocationManager.requestLocationUpdates(strProvider, 1000, 10, objLocationListener);
            objLocation = objLocationManager.getLastKnownLocation(strProvider);

        } else {
            Toast.makeText(MarkerDetailActivity.this, strError, Toast.LENGTH_SHORT).show();
        }

        return objLocation;
    }



    public final LocationListener objLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {

            myLatTextView.setText(String.format("%.7f", location.getLatitude()));
            myLngTextView.setText(String.format("%.7f", location.getLongitude()));

        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };



    private void getLocation() {

        objLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        objCriteria = new Criteria();
        objCriteria.setAccuracy(Criteria.ACCURACY_FINE);
        objCriteria.setAltitudeRequired(false);
        objCriteria.setBearingRequired(false);

    }   // getLocation

    private void getValueFromSQlite() {

        String[] strMyResult = null;
        titleString = getIntent().getStringExtra("Title");

        try {

            CountryTABLE objCountryTABLE = new CountryTABLE(this);
            strMyResult = objCountryTABLE.searchName(titleString);
            descriptionString = strMyResult[3];
            latString = strMyResult[4];
            lngString = strMyResult[5];
            pictureString = strMyResult[6];

            Log.d("aec", "Descrip ==>>>" + descriptionString);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }   // getValueFromSQLite

    private void showView() {

        //Show Title
        titleTextView.setText(titleString);

        //Show Image
        Picasso.with(MarkerDetailActivity.this)
                .load(pictureString)
                .resize(200, 200)
                .into(markerImageView);

        //Show Detail
        detailTextView.setText(descriptionString);


    }   // showView

    private void bindWidget() {
        titleTextView = (TextView) findViewById(R.id.textView14);
        markerImageView = (ImageView) findViewById(R.id.imageView12);
        detailTextView = (TextView) findViewById(R.id.textView15);
        myLatTextView = (TextView) findViewById(R.id.textView17);
        myLngTextView = (TextView) findViewById(R.id.textView18);
        distantTextView = (TextView) findViewById(R.id.textView19);
    }

}   // Main Class
