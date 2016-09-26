package gupuru.wear2sample.view;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import gupuru.wear2sample.R;

public class MainContentsItemView extends FrameLayout implements WearableListView.OnCenterProximityListener {

    final TextView text;

    public MainContentsItemView(Context context) {
        super(context);
        View.inflate(context, R.layout.wearablelistview_item, this);
        text = (TextView) findViewById(R.id.text);
    }

    @Override
    public void onCenterPosition(boolean b) {
        text.animate().scaleX(1f).scaleY(1f).alpha(1);
    }

    @Override
    public void onNonCenterPosition(boolean b) {
        text.animate().scaleX(0.8f).scaleY(0.8f).alpha(0.6f);
    }

}
