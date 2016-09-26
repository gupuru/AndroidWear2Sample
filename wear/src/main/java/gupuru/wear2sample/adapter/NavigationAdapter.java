package gupuru.wear2sample.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.wearable.view.drawer.WearableNavigationDrawer;

import java.util.List;

import gupuru.wear2sample.R;

public class NavigationAdapter extends WearableNavigationDrawer.WearableNavigationDrawerAdapter {

    final private Context context;
    private final List<String> items;

    public NavigationAdapter(Context context, List<String> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public String getItemText(int i) {
        return items.get(i);
    }

    @Override
    public Drawable getItemDrawable(int i) {
        return ContextCompat.getDrawable(context, R.drawable.ic_check_circle_black_24dp);
    }

    @Override
    public void onItemSelected(int i) {

    }

    @Override
    public int getCount() {
        return items.size();
    }
}
