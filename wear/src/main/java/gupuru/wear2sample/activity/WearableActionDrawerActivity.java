package gupuru.wear2sample.activity;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.drawer.WearableActionDrawer;
import android.support.wearable.view.drawer.WearableDrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import gupuru.wear2sample.R;

public class WearableActionDrawerActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_drawer);

        WearableDrawerLayout wearableDrawerLayout
                = (WearableDrawerLayout) findViewById(R.id.drawer_layout);

        WearableActionDrawer wearableActionDrawer
                = (WearableActionDrawer) findViewById(R.id.bottom_action_drawer);
        wearableActionDrawer.setOnMenuItemClickListener(
                new WearableActionDrawer.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(WearableActionDrawerActivity.this, menuItem.getTitle().toString(), Toast.LENGTH_LONG).show();
                        return false;
                    }
                });

        wearableDrawerLayout.peekDrawer(Gravity.BOTTOM);

    }

}
