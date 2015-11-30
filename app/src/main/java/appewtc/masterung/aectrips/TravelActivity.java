package appewtc.masterung.aectrips;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TravelActivity extends AppCompatActivity {

    //Explicit
    private ListView communityListView;
    private int indexAnInt, forExtraAnInt, indexSoundAnInt;

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

        //Icon on ListView
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

        final String[] soundStrings = objCommunityTABLE.readAllData(forSound(indexAnInt));

        MyAdapter objMyAdapter = new MyAdapter(TravelActivity.this, iconInts[indexAnInt], thaiStrings, wordStrings);
        communityListView.setAdapter(objMyAdapter);

        communityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                indexSoundAnInt = soundEffect(indexAnInt, soundStrings[i]);

                MediaPlayer soundPlayer = MediaPlayer.create(getBaseContext(), indexSoundAnInt);
                soundPlayer.start();

                soundPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });

            }   // even
        });

    }   //Create ListView

    private int soundEffect(int indexAnInt, String soundString) {

        int intResult = R.raw.no1;

        switch (indexAnInt) {
            case 0:
                intResult = soundThai(soundString);
                break;
            case 1:
                intResult = soundLaos(soundString);
                break;
            case 2:
                intResult = soundVeitnam(soundString);
                break;
            case 3:
                intResult = soundSingapo(soundString);
                break;
            case 4:
                intResult = soundPhilipin(soundString);
                break;
            case 5:
                intResult = soundMayna(soundString);
                break;
            case 6:
                intResult = soundIndonisia(soundString);
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
        }   //switch

        return intResult;
    }   // soundEffect

    private int soundIndonisia(String soundString) {
        int intResult = R.raw.no1;

        if (soundString.equals("id1")) {
            intResult = R.raw.id1;
        } else if (soundString.equals("id8")) {
            intResult = R.raw.id8;
        } else {
            intResult = R.raw.no1;
        }

        return intResult;
    }

    private int soundMayna(String soundString) {
        int intResult = R.raw.no1;

        if (soundString.equals("mm1")) {
            intResult = R.raw.mm1;
        } else if (soundString.equals("mm2")) {
            intResult = R.raw.mm2;
        } else if (soundString.equals("mm3")) {
            intResult = R.raw.mm3;
        } else if (soundString.equals("mm4")) {
            intResult = R.raw.mm4;
        } else if (soundString.equals("mm5")) {
            intResult = R.raw.mm5;
        } else if (soundString.equals("mm6")) {
            intResult = R.raw.mm6;
        } else if (soundString.equals("mm9")) {
            intResult = R.raw.mm9;
        } else {
            intResult = R.raw.no1;
        }


        return intResult;
    }

    private int soundPhilipin(String soundString) {
        int intResult = R.raw.no1;

        if (soundString.equals("ph1")) {
            intResult = R.raw.ph1;
        } else if (soundString.equals("ph2")) {
            intResult = R.raw.ph2;
        } else if (soundString.equals("ph3")) {
            intResult = R.raw.ph3;
        } else if (soundString.equals("ph4")) {
            intResult = R.raw.ph4;
        } else if (soundString.equals("ph6")) {
            intResult = R.raw.ph6;
        } else if (soundString.equals("ph9")) {
            intResult = R.raw.ph9;
        } else if (soundString.equals("ph12")) {
            intResult = R.raw.no1;
        } else {
            intResult = R.raw.no1;
        }

        return intResult;
    }

    private int soundSingapo(String soundString) {
        int intResult = R.raw.no1;

        if (soundString.equals("sg1")) {
            intResult = R.raw.sg1;
        } else if (soundString.equals("sg2")) {
            intResult = R.raw.sg2;
        } else if (soundString.equals("sg3")) {
            intResult = R.raw.sg3;
        } else if (soundString.equals("sg4")) {
            intResult = R.raw.sg4;
        } else if (soundString.equals("sg5")) {
            intResult = R.raw.sg5;
        } else if (soundString.equals("sg6")) {
            intResult = R.raw.sg6;
        } else if (soundString.equals("sg7")) {
            intResult = R.raw.sg7;
        } else if (soundString.equals("sg8")) {
            intResult = R.raw.sg8;
        } else if (soundString.equals("sg9")) {
            intResult = R.raw.sg9;
        } else {
            intResult = R.raw.no1;
        }

        return intResult;
    }

    private int soundVeitnam(String soundString) {
        int intResult = R.raw.no1;

        if (soundString.equals("vn1")) {
            intResult = R.raw.vn1;
        } else if (soundString.equals("vn2")) {
            intResult = R.raw.vn2;
        } else if (soundString.equals("vn3")) {
            intResult = R.raw.vn3;
        } else if (soundString.equals("vn4")) {
            intResult = R.raw.vn4;
        } else if (soundString.equals("vn5")) {
            intResult = R.raw.vn5;
        } else if (soundString.equals("vn6")) {
            intResult = R.raw.vn6;
        } else if (soundString.equals("vn7")) {
            intResult = R.raw.vn7;
        } else if (soundString.equals("vn8")) {
            intResult = R.raw.vn8;
        } else if (soundString.equals("vn9")) {
            intResult = R.raw.vn9;
        } else {

            intResult = R.raw.no1;
        }


        return intResult;
    }

    private int soundLaos(String soundString) {
        int intResult = R.raw.no1;

        if (soundString.equals("la2")) {
            intResult = R.raw.la2;
        } else if (soundString.equals("la3")) {
            intResult = R.raw.la3;
        } else if (soundString.equals("la4")) {
            intResult = R.raw.la4;
        } else if (soundString.equals("la5")) {
            intResult = R.raw.la5;
        } else if (soundString.equals("la6")) {
            intResult = R.raw.la6;
        } else if (soundString.equals("la8")) {
            intResult = R.raw.la8;
        } else if (soundString.equals("la9")) {
            intResult = R.raw.la9;
        } else if (soundString.equals("la10")) {
            intResult = R.raw.no1;
        } else if (soundString.equals("la11")) {
            intResult = R.raw.no1;
        } else if (soundString.equals("la12")) {
            intResult = R.raw.no1;
        } else if (soundString.equals("la7")) {
            intResult = R.raw.no1;
        } else {
            intResult = R.raw.no1;
        }


        return intResult;
    }

    private int soundThai(String soundString) {
        int intResult = R.raw.no1;

        if (soundString.equals("th1")) {
            intResult = R.raw.th1;
        } else if (soundString.equals("th2")) {
            intResult = R.raw.th2;
        } else if (soundString.equals("th3")) {
            intResult = R.raw.th3;
        } else if (soundString.equals("th4")) {
            intResult = R.raw.th4;
        } else if (soundString.equals("th6")) {
            intResult = R.raw.th6;
        } else if (soundString.equals("th12")) {
            intResult = R.raw.no1;
        } else {
            intResult = R.raw.no1;
        }

        return intResult;
    }

    private int forSound(int indexAnInt) {

        int intSound = 0;
        switch (indexAnInt) {
            case 0:
                intSound = 2;
                break;
            case 1:
                intSound = 4;
                break;
            case 2:
                intSound = 6;
                break;
            case 3:
                intSound = 8;
                break;
            case 4:
                intSound = 10;
                break;
            case 5:
                intSound = 12;
                break;
            case 6:
                intSound = 14;
                break;
            case 7:
                intSound = 16;
                break;
            case 8:
                intSound = 18;
                break;
            case 9:
                intSound = 20;
                break;
        }   // switch

        return intSound;
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
