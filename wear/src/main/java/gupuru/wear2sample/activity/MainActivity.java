package gupuru.wear2sample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.BoxInsetLayout;
import android.support.wearable.view.WearableListView;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import gupuru.wear2sample.R;
import gupuru.wear2sample.adapter.MainContentsAdapter;

public class MainActivity extends WearableActivity implements WearableListView.ClickListener {

    private static final SimpleDateFormat AMBIENT_DATE_FORMAT =
            new SimpleDateFormat("HH:mm", Locale.US);

    private BoxInsetLayout mContainerView;
    private WearableListView listView;
    private TextView mClockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAmbientEnabled();

        mContainerView = (BoxInsetLayout) findViewById(R.id.container);
        mClockView = (TextView) findViewById(R.id.clock);
        listView = (WearableListView) findViewById(R.id.wearable_list);

        loadAdapter();
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

    private void loadAdapter() {
        List<String> items = new ArrayList<>();
        items.add(getString(R.string.keyboard));
        items.add(getString(R.string.action_drawer));
        items.add(getString(R.string.navigation_drawer));
        items.add(getString(R.string.curved_layout));
        items.add(getString(R.string.network));

        MainContentsAdapter adapter = new MainContentsAdapter(this, items);

        listView.setAdapter(adapter);
        listView.setClickListener(this);
    }

    @Override
    public void onClick(WearableListView.ViewHolder viewHolder) {
        Intent intent;
        switch (viewHolder.getAdapterPosition()) {
            case 0:
                intent = new Intent(MainActivity.this, KeybordActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(MainActivity.this, WearableActionDrawerActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(MainActivity.this, WearableNavigationDrawerActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(MainActivity.this, CurvedLayoutActivity.class);
                startActivity(intent);
            case 4:
                intent = new Intent(MainActivity.this, NetworkActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onTopEmptyRegionClick() {

    }
}
