package com.verlekar.rahul.xavierstutorials;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Button btnNotifyUser = (Button) findViewById(R.id.btn_show_noti);
        btnNotifyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNotification();
            }
        });
        createFragment();
    }

    public void createFragment()
    {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        FragmentOne fragmentOne = new FragmentOne();
        transaction.replace(R.id.fl_fragment_view, fragmentOne);
        transaction.commit();
    }

    public void showNotification()
    {
        Intent i = new Intent(this, NotificationView.class);
        int notificationID = 11520; //Any unique value that uniquely identifies the notification
        i.putExtra("notificationID", 102);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0, i, 0);

        NotificationManager nm = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);


        Notification.Builder builder = new Notification.Builder(this)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Reminder: Meeting starts in 5 minutes");
        Notification notif = builder.build();

        CharSequence from = "System Alarm";
        CharSequence message = "Meeting with customer at 3pm...";

        nm.notify(notificationID, notif);

        //---100ms delay, vibrate for 250ms, pause for 100 ms and
        // then vibrate for 500ms---
        notif.vibrate = new long[] { 100, 250, 100, 500};
        nm.notify(notificationID, notif);
    }
}
