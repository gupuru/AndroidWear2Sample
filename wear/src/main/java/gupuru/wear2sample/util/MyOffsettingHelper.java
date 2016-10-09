package gupuru.wear2sample.util;


import android.support.wearable.view.DefaultOffsettingHelper;
import android.support.wearable.view.WearableRecyclerView;
import android.view.View;

public class MyOffsettingHelper extends DefaultOffsettingHelper {

    private static final float MAX_ICON_PROGRESS = 0.65f;

    private float mProgressToCenter;

    public MyOffsettingHelper() {}

    @Override
    public void updateChild(View child, WearableRecyclerView parent) {
        super.updateChild(child, parent);

        float centerOffset = ((float) child.getHeight() / 2.0f) /  (float) parent.getHeight();
        float yRelativeToCenterOffset = (child.getY() / parent.getHeight()) + centerOffset;

        mProgressToCenter = Math.abs(0.5f - yRelativeToCenterOffset);
        mProgressToCenter = Math.min(mProgressToCenter, MAX_ICON_PROGRESS);

        child.setScaleX(1 - mProgressToCenter);
        child.setScaleY(1 - mProgressToCenter);
    }

    @Override
    protected void adjustAnchorOffsetXY(View child, float[] anchorOffsetXY) {
        anchorOffsetXY[0] = child.getHeight() / 2.0f;
    }

}