package appewtc.masterung.aectrips;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private CountryTABLE objCountryTABLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create & Connected Database
        objCountryTABLE = new CountryTABLE(this);

    }   // Main Method

}   // Main Class
