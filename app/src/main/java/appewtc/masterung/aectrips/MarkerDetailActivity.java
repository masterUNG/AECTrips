package appewtc.masterung.aectrips;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MarkerDetailActivity extends AppCompatActivity {

    //Explicit
    private TextView titleTextView;
    private String titleString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marker_detail);

        //Bind Widget
        bindWidget();

        //Show View
        showView();

    }   // Main Method

    private void showView() {

        //Show Title
        titleString = getIntent().getStringExtra("Title");
        titleTextView.setText(titleString);

    }

    private void bindWidget() {
        titleTextView = (TextView) findViewById(R.id.textView14);
    }

}   // Main Class
