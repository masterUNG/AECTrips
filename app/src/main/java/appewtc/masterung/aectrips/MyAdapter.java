package appewtc.masterung.aectrips;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by masterUNG on 11/18/15 AD.
 */
public class MyAdapter extends BaseAdapter{

    //Explicit
    private Context objContext;
    private int iconAnInt;
    private String[] thWordStrings;
    private String[] wordStrings;

    public MyAdapter(Context objContext, int iconAnInt, String[] thWordStrings, String[] wordStrings) {
        this.objContext = objContext;
        this.iconAnInt = iconAnInt;
        this.thWordStrings = thWordStrings;
        this.wordStrings = wordStrings;
    }   // Constructor

    @Override
    public int getCount() {
        return thWordStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View objView1 = objLayoutInflater.inflate(R.layout.country_listview, viewGroup, false);

        //Icon
        ImageView iconImageView = (ImageView) objView1.findViewById(R.id.imageView11);
        iconImageView.setImageResource(iconAnInt);

        //Thai Word
        TextView thaiTextView = (TextView) objView1.findViewById(R.id.textView12);
        thaiTextView.setText(thWordStrings[i]);

        //คำต่างประเทศ
        TextView wordTextView = (TextView) objView1.findViewById(R.id.textView13);
        wordTextView.setText(wordStrings[i]);

        return objView1;
    }
}   // Main Class
