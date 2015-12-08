package appewtc.masterung.aectrips;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MarkerDetailActivity extends AppCompatActivity {

    //Explicit
    private TextView titleTextView, detailTextView;
    private String titleString, descriptionString, latString, lngString, pictureString;
    private ImageView markerImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marker_detail);

        //Bind Widget
        bindWidget();

        //Get Value From SQLite
        getValueFromSQlite();

        //Show View
        showView();

    }   // Main Method

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
                .resize(250, 250)
                .into(markerImageView);

        //Show Detail
        detailTextView.setText(descriptionString);


    }   // showView

    private void bindWidget() {
        titleTextView = (TextView) findViewById(R.id.textView14);
        markerImageView = (ImageView) findViewById(R.id.imageView12);
        detailTextView = (TextView) findViewById(R.id.textView15);
    }

}   // Main Class
