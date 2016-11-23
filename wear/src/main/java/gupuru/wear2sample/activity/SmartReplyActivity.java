package gupuru.wear2sample.activity;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.BoxInsetLayout;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import gupuru.wear2sample.R;


public class SmartReplyActivity extends WearableActivity {

    private static final SimpleDateFormat AMBIENT_DATE_FORMAT =
            new SimpleDateFormat("HH:mm", Locale.US);

    private static final String EXTRA_SMART_REPLAY = "smart_replay";

    private BoxInsetLayout mContainerView;
    private TextView mTextView;
    private TextView mClockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_reply);
        setAmbientEnabled();

        mContainerView = (BoxInsetLayout) findViewById(R.id.container);
        mTextView = (TextView) findViewById(R.id.text);
        mClockView = (TextView) findViewById(R.id.clock);



        String[] choices = getResources().getStringArray(R.array.reply_choices);
        RemoteInput remoteInput = new RemoteInput.Builder(EXTRA_SMART_REPLAY).setLabel("いまどうしてる？").setChoices(choices).build();
//        RemoteInput[] remoteInputs = new RemoteInput[]{remoteInput};


        Intent replyIntent = new Intent(SmartReplyActivity.this, MainActivity.class);
        PendingIntent replyPendingIntent =
                PendingIntent.getActivity(SmartReplyActivity.this, 0, replyIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

// Create the reply action and add the remote input
        NotificationCompat.Action action =
                new NotificationCompat.Action.Builder(R.drawable.kitune,
                        getString(R.string.app_name), replyPendingIntent)
                        .addRemoteInput(remoteInput)

// 1) allow generated replies
                        .setAllowGeneratedReplies(true)
                        .build();

        Notification noti = new NotificationCompat.Builder(SmartReplyActivity.this)
                .setContentTitle(" new messages with ")
                .setContentText("subject")
                .setSmallIcon(R.mipmap.ic_launcher)

// 3) add an action with RemoteInput
                .extend(new NotificationCompat.WearableExtender().addAction(action)).build();


  NotificationManagerCompat manager = NotificationManagerCompat.from(getApplicationContext());
        manager.notify(100, noti);

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
            mContainerView.setBackgroundColor(getResources().getColor(android.R.color.black));
            mTextView.setTextColor(getResources().getColor(android.R.color.white));
            mClockView.setVisibility(View.VISIBLE);

            mClockView.setText(AMBIENT_DATE_FORMAT.format(new Date()));
        } else {
            mContainerView.setBackground(null);
            mTextView.setTextColor(getResources().getColor(android.R.color.black));
            mClockView.setVisibility(View.GONE);
        }
    }
}
