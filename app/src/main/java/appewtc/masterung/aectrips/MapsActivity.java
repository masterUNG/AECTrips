package appewtc.masterung.aectrips;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Double latCenterADouble, lngCenterADouble;
    private LatLng centerLatLng;
    private int countryAnInt;

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

        //Move To Center
        // moveToCenter();


    }   // onCreate

    private void moveToCenter() {

    }

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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(latCenterADouble, lngCenterADouble);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }   // onMapReady

}   // Main Class
