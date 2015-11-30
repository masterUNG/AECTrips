package appewtc.masterung.aectrips;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Double latCenterADouble, lngCenterADouble;
    private LatLng centerLatLng;
    private int countryAnInt;
    private CountryTABLE objCountryTABLE;
    private LatLng[] markerLatLngs;
    private int[] iconCountryInts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Get Lat&Lng to Center
        getCenterLatLng();

        //Create LatLng for Marker
        createLatLngForMarker();


    }   // onCreate

    private void createLatLngForMarker() {

        objCountryTABLE = new CountryTABLE(this);

        String[] strLat = objCountryTABLE.readAllCountry(4);
        String[] strLng = objCountryTABLE.readAllCountry(5);
        String[] strCountry = objCountryTABLE.readAllCountry(1);

        iconCountryInts = new int[strCountry.length];
        for (int i=0;i<strCountry.length;i++) {

            Log.d("aec", "Country ==> " + strCountry[i]);



            if (strCountry[i].equals("ไทย")) {
                iconCountryInts[i] = R.drawable.th;
            } else if (strCountry[i].equals("ลาว")) {
                iconCountryInts[i] = R.drawable.la;
            }else if (strCountry.equals("เวียดนาม")) {
                iconCountryInts[i] = R.drawable.vn;
            }else if (strCountry[i].equals("สิงคโปร์")) {
                iconCountryInts[i] = R.drawable.sg;
            }else if (strCountry[i].equals("ฟิลิปปินส์")) {
                iconCountryInts[i] = R.drawable.ph;
            }else if (strCountry[i].equals("เมียนม่า")) {
                iconCountryInts[i] = R.drawable.mm;
            }else if (strCountry[i].equals("อินโดนีเซีย")) {
                iconCountryInts[i] = R.drawable.id;
            }else if (strCountry[i].equals("กัมพูชา")) {
                iconCountryInts[i] = R.drawable.cb;
            }else if (strCountry.equals("บรูไน")) {
                iconCountryInts[i] = R.drawable.bn;
            } else if (strCountry[i].equals("มาเลเซีย")) {
                iconCountryInts[i] = R.drawable.my;
            } else {
                iconCountryInts[i] = R.drawable.aec;
                Log.d("aec", "bool = false");
            }

        }   //for

        Double[] latDoubles = new Double[strLat.length];
        Double[] lngDoubles = new Double[strLat.length];
        markerLatLngs = new LatLng[strLat.length];

        for (int i = 0; i < strLat.length; i++) {

            latDoubles[i] = Double.parseDouble(strLat[i]);
            lngDoubles[i] = Double.parseDouble(strLng[i]);

            markerLatLngs[i] = new LatLng(latDoubles[i], lngDoubles[i]);

        }   // for

    }   // createLatLngForMarker


    private void getCenterLatLng() {
        latCenterADouble = getIntent().getDoubleExtra("Lat", 0);
        lngCenterADouble = getIntent().getDoubleExtra("Lng", 0);
        centerLatLng = new LatLng(latCenterADouble, lngCenterADouble);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Assign Center Map
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerLatLng, 6));


        //Create All Marker
        for (int i=0;i<markerLatLngs.length;i++) {

            mMap.addMarker(new MarkerOptions().position(markerLatLngs[i]).
            icon(BitmapDescriptorFactory.fromResource(iconCountryInts[i])));

        }   // for

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(latCenterADouble, lngCenterADouble);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }   // onMapReady

}   // Main Class
