package gupuru.wear2sample.activity;


import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.BoxInsetLayout;
import android.support.wearable.view.WearableListView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import gupuru.wear2sample.R;

public class NetworkActivity extends WearableActivity {

    private static final SimpleDateFormat AMBIENT_DATE_FORMAT =
            new SimpleDateFormat("HH:mm", Locale.US);
    private static final String URL =
            "http://fox-info.net/wp-content/uploads/2016/10/20160924_164255_foxinfonet.jpg";

    private BoxInsetLayout mContainerView;
    private WearableListView listView;
    private TextView mClockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        setAmbientEnabled();

        mContainerView = (BoxInsetLayout) findViewById(R.id.container);
        mClockView = (TextView) findViewById(R.id.clock);
        listView = (WearableListView) findViewById(R.id.wearable_list);
        ImageView imageView = (ImageView) findViewById(R.id.image);

        Picasso.with(NetworkActivity.this)
                .load(URL)
                .placeholder(R.drawable.ic_warning_black_24dp)
                .error(R.drawable.ic_warning_red_24dp)
                .into(imageView);
    }

    @Override
    public void onEnterAmbient(Bundle ambientDetails) {
        super.onEnterAmbient(ambientDetails);
        updateDisplay();
    }

    @Override
    public void onUpdateAmbient() {
        super.onUpdateAmbient();
        updateDisplay();
    }

    @Override
    public void onExitAmbient() {
        updateDisplay();
        super.onExitAmbient();
    }

    private void updateDisplay() {
        if (isAmbient()) {
            mContainerView.setBackgroundColor(ContextCompat.getColor(this, android.R.color.black));
            mClockView.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
            mClockView.setText(AMBIENT_DATE_FORMAT.format(new Date()));
        } else {
            mContainerView.setBackground(null);
            mClockView.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
        }
    }

}
