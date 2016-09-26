package gupuru.wear2sample;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.drawer.WearableDrawerLayout;
import android.support.wearable.view.drawer.WearableNavigationDrawer;

import java.util.ArrayList;
import java.util.List;

import gupuru.wear2sample.adapter.NavigationAdapter;

public class WearableNavigationDrawerActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        WearableDrawerLayout wearableDrawerLayout
                = (WearableDrawerLayout) findViewById(R.id.drawer_layout);
        WearableNavigationDrawer wearableNavigationDrawer
                = (WearableNavigationDrawer) findViewById(R.id.top_navigation_drawer);


        List<String> items = new ArrayList<>();
        items.add("apple");
        items.add("windows");
        items.add("android");

        wearableNavigationDrawer.setAdapter(new NavigationAdapter(this, items));
    }

}
