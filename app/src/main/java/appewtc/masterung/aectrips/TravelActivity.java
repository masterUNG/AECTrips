package appewtc.masterung.aectrips;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class TravelActivity extends AppCompatActivity {

    //Explicit
    private ListView communityListView;
    private int indexAnInt, forExtraAnInt;

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

        //Receive Index for Choose Country
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

        String[] wordStrings = objCommunityTABLE.readAllData(forExtra(indexAnInt));

        MyAdapter objMyAdapter = new MyAdapter(TravelActivity.this, iconInts[indexAnInt], thaiStrings, wordStrings);
        communityListView.setAdapter(objMyAdapter);

    }

    private int forExtra(int indexAnInt) {

        int intExtra = 0;
        switch (indexAnInt) {
            case 0:
                intExtra = 1;
                break;
            case 1:
                intExtra = 3;
                break;
            case 2:
                intExtra = 5;
                break;
            case 3:
                intExtra = 7;
                break;
            case 4:
                intExtra = 9;
                break;
            case 5:
                intExtra = 11;
                break;
            case 6:
                intExtra = 13;
                break;
            case 7:
                intExtra = 15;
                break;
            case 8:
                intExtra = 17;
                break;
            case 9:
                intExtra = 19;
                break;
        }

        return intExtra;
    }

}   // Main Class
