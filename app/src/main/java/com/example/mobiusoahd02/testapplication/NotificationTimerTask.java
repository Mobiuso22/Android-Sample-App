package com.example.mobiusoahd02.testapplication;

import java.util.TimerTask;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

public class NotificationTimerTask extends TimerTask {
    private Context context;
    private Handler mHandler = new Handler();
    int Count = 1;

    public NotificationTimerTask(Context con) {
        this.context = con;
    }

    @Override
    public void run() {
        new Thread(new Runnable() {

            public void run() {

                mHandler.post(new Runnable() {
                    public void run() {
                        Toast.makeText(context, "THIS IS NOTIFICATION MESSAGE " + Count, Toast.LENGTH_LONG).show();
                        Count++;
                    }
                });
            }
        }).start();

    }

}