package gupuru.wear2sample;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.WearableRecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import gupuru.wear2sample.adapter.CurvedLayoutRecyclerAdapter;
import gupuru.wear2sample.util.MyOffsettingHelper;

public class CurvedLayoutActivity extends WearableActivity {

    private static final SimpleDateFormat AMBIENT_DATE_FORMAT =
            new SimpleDateFormat("HH:mm", Locale.US);

    private FrameLayout frameLayout;
    private WearableRecyclerView wearableRecyclerView;
    private TextView mClockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curved_layout);
        setAmbientEnabled();
        mClockView = (TextView) findViewById(R.id.clock);
        frameLayout = (FrameLayout) findViewById(R.id.container);

        wearableRecyclerView = (WearableRecyclerView) findViewById(R.id.recycler_launcher_view);
        wearableRecyclerView.setHasFixedSize(true);
        wearableRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyOffsettingHelper myOffsettingHelper = new MyOffsettingHelper();

        wearableRecyclerView.setOffsettingHelper(myOffsettingHelper);

        ArrayList<String> array = new ArrayList<>();
        array.add("apple");
        array.add("orange");
        array.add("window");
        array.add("green");
        array.add("red");
        array.add("blue");
        array.add("yellow");
        array.add("poooooooooooooo");
        
        CurvedLayoutRecyclerAdapter curvedLayoutRecyclerAdapter
                = new CurvedLayoutRecyclerAdapter(CurvedLayoutActivity.this, array);
        wearableRecyclerView.setAdapter(curvedLayoutRecyclerAdapter);

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
            frameLayout.setBackgroundColor(ContextCompat.getColor(this, android.R.color.black));
            mClockView.setVisibility(View.VISIBLE);
            wearableRecyclerView.setVisibility(View.GONE);
            mClockView.setText(AMBIENT_DATE_FORMAT.format(new Date()));
        } else {
            frameLayout.setBackground(null);
            mClockView.setVisibility(View.GONE);
            wearableRecyclerView.setVisibility(View.VISIBLE);
        }
    }

}