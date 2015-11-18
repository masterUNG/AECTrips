package appewtc.masterung.aectrips;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class TravelActivity extends AppCompatActivity {

    //Explicit
    private ListView communityListView;
    private int indexAnInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        //Bind Widget
        communityListView = (ListView) findViewById(R.id.listView);

        //Create ListView
        createListView();

    }   // Main Method

    private void createListView() {

        indexAnInt = getIntent().getIntExtra("index", 0);

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

        CommunityTABLE objCommunityTABLE = new CommunityTABLE(this);

        String[] thaiStrings = objCommunityTABLE.readAllData(1);
        String[] wordStrings = objCommunityTABLE.readAllData(indexAnInt + 1);

        MyAdapter objMyAdapter = new MyAdapter(TravelActivity.this, iconInts[indexAnInt], thaiStrings, wordStrings);
        communityListView.setAdapter(objMyAdapter);

    }

}   // Main Class
